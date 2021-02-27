package tech.qijin.study.quickstart;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void mInteain(String[] args) {
		BigDecimal value = new BigDecimal(2);
		value.setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal value2 = new BigDecimal(3);
		value.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(value.divide(value2, 2, BigDecimal.ROUND_FLOOR));
	}

	private long a(long a){
		return a;
	}
}
