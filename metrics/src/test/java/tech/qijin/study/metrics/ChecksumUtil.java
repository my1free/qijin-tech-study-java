/*
 * Copyright (c) 2018. aviagames.com
 */

package tech.qijin.study.metrics;


import java.math.BigInteger;
import java.util.Random;

/**
 * ChecksumUtil
 *   校验和工具
 *   checksum= pa*a+pb*b+pc*c+pd
 *   pa=rand(1,100)
 *   pb=rand(1,100)
 *   pc=rand(1,100)
 *   pd=rand(10000, 1000000)
 * @author: zhangpeng
 * @date: 2018/11/21
 */
public class ChecksumUtil {
    private static final int SCORE_CHECKSUM_PARAMS_COUNT = 3;
    private static final String FACTOR_SEPARATOR = "&";
    private static final String[] PARAMS_NAMES = {"a", "b", "c", "d", "e", "f"};

    /**
     * 生成分数校验和系数
     * @return
     */
    public static String generateScoreChecksumFactors() {
        return generateRandChecksumFactors(SCORE_CHECKSUM_PARAMS_COUNT);
    }

    /**
     * 随机生成指定数量的校验和参数
     * @param paramCount
     * @return
     */
    public static String generateRandChecksumFactors(int paramCount) {
        assert paramCount>0 && paramCount<=PARAMS_NAMES.length;

        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        //参数数量
        for (int i = 0; i<paramCount; i++){
            sb.append(1+random.nextInt(99)).append(FACTOR_SEPARATOR);
        }

        //常数
        sb.append(10000+ random.nextInt(1000000));

        return sb.toString();
    }


    /**
     * checksum系数转化为js表达式
     * @param checksumFactors
     * @return
     */
    public static String convertToJsExpression(String checksumFactors) {
        assert null != checksumFactors && checksumFactors.length()>0;

        String[] factors = checksumFactors.split(FACTOR_SEPARATOR);
        assert factors.length>=2 && factors.length <= PARAMS_NAMES.length+1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < factors.length - 1; i++) {
            sb.append(factors[i]).append("*").append(PARAMS_NAMES[i]).append("+");
        }

        sb.append(factors[factors.length-1]);

        return sb.toString();
    }

    /**
     * 计算校验和
     * @param checksumFactors
     * @param args
     * @return
     */
    public static Long calcChecksum(String checksumFactors, Integer... args) {
        String[] factors = checksumFactors.split(FACTOR_SEPARATOR);
        assert factors.length-1 == args.length;


        Long checksum = 0L;

        for (int i = 0; i < factors.length - 1; i++) {
            checksum += Integer.parseInt(factors[i]) * args[i];
        }

        checksum += Integer.parseInt(factors[factors.length-1]);

        return checksum;
    }

    private static final BigInteger RAND_FACTOR = BigInteger.valueOf(17);
    private static final BigInteger RAND_DELT = BigInteger.valueOf(49297);
    private static final BigInteger RAND_MOD = BigInteger.valueOf(2332801);

    /**
     * 获取指定的种子随机指定次数后的随机数
     * @param gameSeed
     * @param times
     * @return
     */
    public static Long getRandOfSeedAndTimes(String gameSeed, int times) {
        Long seed = seed(gameSeed);
        BigInteger rand = BigInteger.valueOf(seed);
        for (int i = 0; i < times; i++) {
            rand = ((rand.multiply(RAND_FACTOR)).add(RAND_DELT)).mod(RAND_MOD);
        }

        return rand.longValue();
    }

    public static Long seed(String gameSeed) {
        return Long.parseLong(gameSeed.substring(0, 12), 16);
    }

    public static void main(String[] args) {
        System.out.println(seed("F573E3B1C6B081CB"));
        System.out.println(getRandOfSeedAndTimes("F573E3B1C6B081CB", 1));
        String factor = generateScoreChecksumFactors();
        System.out.println(factor);
        System.out.println(convertToJsExpression(factor));
    }
}
