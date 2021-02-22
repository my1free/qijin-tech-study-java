package tech.qijin.study.quickstart;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<List<Integer>> listlist = new ArrayList<>();
		listlist.add(new ArrayList<Integer>(){{
			add(1);
			add(1);
			add(1);
			add(1);
			add(1);
		}});
		listlist.add(new ArrayList<Integer>(){{
			add(2);
			add(2);
			add(2);
			add(2);
			add(2);
		}});
		listlist.add(new ArrayList<Integer>(){{
			add(3);
		}});
		System.out.println(listlist.stream().collect(Collectors.summingLong(List::size)));
	}

	private long a(long a){
		return a;
	}
}
