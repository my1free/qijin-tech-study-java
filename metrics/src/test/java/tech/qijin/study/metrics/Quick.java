package tech.qijin.study.metrics;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.MurmurHash3;
import org.junit.jupiter.api.Test;

public class Quick {
    private static final Long ONE_DAY_MILLISECONDS = 24 * 3600 * 1000L;

    @Test
    public void test() {
        String deviceId = "02735ff2-1c0d-4aa2-8884-e54a768a30e4";
        int hash1 = MurmurHash3.hash32(deviceId);
        int hash2 = MurmurHash3.hash32x86(StringUtils.getBytesUtf8(deviceId));
        System.out.println(hash1);
        System.out.println(hash2);
    }

}
