package tech.qijin.study.arthas.core;


import com.sun.tools.attach.*;
import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.tree.ClassNode;
import jdk.internal.org.objectweb.asm.tree.MethodNode;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class ArthasMain {
    public static void main(String[] args) throws IOException {
        ClassReader classReader = new ClassReader("java.lang.String");
        ClassNode cn = new ClassNode();
        classReader.accept(cn, ClassReader.EXPAND_FRAMES);
        List<MethodNode> methods = cn.methods;
        Long ppid = 17056L;
        VirtualMachineDescriptor virtualMachineDescriptor = null;
        for (VirtualMachineDescriptor descriptor : VirtualMachine.list()) {
            String pid = descriptor.id();
            if (pid.equals(Long.toString(ppid))) {
                virtualMachineDescriptor = descriptor;
                break;
            }
        }

        VirtualMachine virtualMachine = null;
        try {
            virtualMachine = VirtualMachine.attach(virtualMachineDescriptor);
            Properties targetSystemProperties = virtualMachine.getSystemProperties();
            virtualMachine.loadAgent("/Users/qijin/.m2/repository/tech/qijin/study/arthas-agent/1.0.0-SNAPSHOT/arthas-agent-1.0.0-SNAPSHOT-jar-with-dependencies.jar");
            System.out.println("asdfasd");
        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AgentLoadException e) {
            e.printStackTrace();
        } catch (AgentInitializationException e) {
            e.printStackTrace();
        }

    }
}
