package tech.qijin.study.metrics;

import org.junit.Test;

public class ChecksumUtilTest {
    @Test
    public void testGetRandOfSeedAndTimes() {
        Long rand = ChecksumUtil.getRandOfSeedAndTimes("562822A8CC930D87", 3);
        System.out.println(rand);
    }

    @Test
    public void testCalcChecksum() {
        Integer[] args = new Integer[]{};
        ChecksumUtil.calcChecksum("2&26&38&189710", args);
    }
}
