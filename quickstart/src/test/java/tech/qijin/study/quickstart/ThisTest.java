package tech.qijin.study.quickstart;

import org.assertj.core.util.Lists;

import java.util.List;
import java.util.function.Consumer;

public class ThisTest {
    public void test() {
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(this);
            }

        };

        Hehe hehe = new Hehe() {
            @Override
            public void aa() {
                System.out.println(this);
            }
        };
        hehe.aa();
        list.forEach(a -> {
            System.out.println(this);
        });
    }
}
