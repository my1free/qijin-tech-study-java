package tech.qijin.study.metrics.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.qijin.util4j.aop.annotation.Timed;
import tech.qijin.util4j.utils.Util;

import java.lang.management.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MxBeanService {
    private final RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    private final ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
    private final CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
    private final Collection<GarbageCollectorMXBean> garbageCollectorMXBeans = ManagementFactory.getGarbageCollectorMXBeans();
    private final Collection<MemoryManagerMXBean> memoryManagerMXBeans = ManagementFactory.getMemoryManagerMXBeans();
    private final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    private final OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
    private final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

    private static final Logger aLog = LoggerFactory.getLogger("ACCESS");

    @Autowired
    private MxBeanService mxBeanService;

    @Timed
    public Object info() {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> runtimeInfo = new HashMap<>();
        String bootClassPath = "";
        bootClassPath = runtimeMXBean.getBootClassPath();
        runtimeInfo.put("MACHINE-NAME", runtimeMXBean.getName());
        runtimeInfo.put("JVM-START-TIME", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(runtimeMXBean.getStartTime())));
        runtimeInfo.put("MANAGEMENT-SPEC-VERSION", runtimeMXBean.getManagementSpecVersion());
        runtimeInfo.put("SPEC-NAME", runtimeMXBean.getSpecName());
        runtimeInfo.put("SPEC-VENDOR", runtimeMXBean.getSpecVendor());
        runtimeInfo.put("SPEC-VERSION", runtimeMXBean.getSpecVersion());
        runtimeInfo.put("VM-NAME", runtimeMXBean.getVmName());
        runtimeInfo.put("VM-VENDOR", runtimeMXBean.getVmVendor());
        runtimeInfo.put("VM-VERSION", runtimeMXBean.getVmVersion());
        runtimeInfo.put("INPUT-ARGUMENTS", runtimeMXBean.getInputArguments());
        runtimeInfo.put("CLASS-PATH", runtimeMXBean.getClassPath());
        runtimeInfo.put("BOOT-CLASS-PATH", bootClassPath);
        runtimeInfo.put("LIBRARY-PATH", runtimeMXBean.getLibraryPath());

        Map<String, Object> gcInfo = new HashMap<>();
        for (GarbageCollectorMXBean garbageCollectorMXBean : garbageCollectorMXBeans) {
            gcInfo.put(garbageCollectorMXBean.getName() + "\n[count/time]",
                    garbageCollectorMXBean.getCollectionCount() + "/" + garbageCollectorMXBean.getCollectionTime() + "(ms)");
        }

        Map<String, Object> memInfo = new HashMap<>();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        memInfo.put("HEAP-MEMORY-USAGE\n[committed/init/max/used]",
                formatMemoryByte(heapMemoryUsage.getCommitted())
                        + "/" + formatMemoryByte(heapMemoryUsage.getInit())
                        + "/" + formatMemoryByte(heapMemoryUsage.getMax())
                        + "/" + formatMemoryByte(heapMemoryUsage.getUsed())
        );
        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        memInfo.put("NO-HEAP-MEMORY-USAGE\n[committed/init/max/used]",
                formatMemoryByte(nonHeapMemoryUsage.getCommitted())
                        + "/" + formatMemoryByte(nonHeapMemoryUsage.getInit())
                        + "/" + formatMemoryByte(nonHeapMemoryUsage.getMax())
                        + "/" + formatMemoryByte(nonHeapMemoryUsage.getUsed())
        );

        memInfo.put("PENDING-FINALIZE-COUNT", "" + memoryMXBean.getObjectPendingFinalizationCount());
        Map<String, Object> memManagerInfo = new HashMap<>();
        Map<String, Object> osInfo = new HashMap<>();
        osInfo.put("OS", operatingSystemMXBean.getName());
        osInfo.put("ARCH", operatingSystemMXBean.getArch());
        osInfo.put("PROCESSORS-COUNT", "" + operatingSystemMXBean.getAvailableProcessors());
        osInfo.put("LOAD-AVERAGE", "" + operatingSystemMXBean.getSystemLoadAverage());
        osInfo.put("VERSION", operatingSystemMXBean.getVersion());

        Map<String, Object> threadInfo = new HashMap<>();
        threadInfo.put("COUNT", "" + threadMXBean.getThreadCount());
        threadInfo.put("DAEMON-COUNT", "" + threadMXBean.getDaemonThreadCount());
        threadInfo.put("PEAK-COUNT", "" + threadMXBean.getPeakThreadCount());
        threadInfo.put("STARTED-COUNT", "" + threadMXBean.getTotalStartedThreadCount());
        threadInfo.put("DEADLOCK-COUNT","" + getDeadlockedThreadsCount(threadMXBean));


        result.put("runtime", runtimeInfo);
        result.put("gc", gcInfo);
        result.put("mem", memInfo);
        result.put("os", osInfo);
        result.put("thread", threadInfo);

        mxBeanService.test();
        String hehe = Util.runIgnoreEx(() -> mxBeanService.test());
        return result;
    }

    @Timed
    public String test() {
        System.out.println("test");
        return "test";
    }

    private String formatMemoryByte(long bytes){
        return String.format("%s(%s)",bytes, humanReadableByteCount(bytes));
    }

    public static String humanReadableByteCount(long bytes) {
        return bytes < 1024L ? bytes + " B"
                : bytes < 0xfffccccccccccccL >> 40 ? String.format("%.1f KiB", bytes / 0x1p10)
                : bytes < 0xfffccccccccccccL >> 30 ? String.format("%.1f MiB", bytes / 0x1p20)
                : bytes < 0xfffccccccccccccL >> 20 ? String.format("%.1f GiB", bytes / 0x1p30)
                : bytes < 0xfffccccccccccccL >> 10 ? String.format("%.1f TiB", bytes / 0x1p40)
                : bytes < 0xfffccccccccccccL ? String.format("%.1f PiB", (bytes >> 10) / 0x1p40)
                : String.format("%.1f EiB", (bytes >> 20) / 0x1p40);
    }
    private int getDeadlockedThreadsCount(ThreadMXBean threads) {
        final long[] ids = threads.findDeadlockedThreads();
        if (ids == null) {
            return 0;
        } else {
            return ids.length;
        }
    }
}
