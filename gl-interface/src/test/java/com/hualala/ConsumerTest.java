package com.hualala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {


    public static void main(String[] args) {


        List<String> list = new ArrayList(Arrays.asList("aa", "bb", "cc", "ddd", "eeee"));

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() != 4) {
                    System.out.println(s);
                }
            }
        }.andThen(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() != 3) {
                    System.out.println(s);
                }
            }
        }));


    }
}
