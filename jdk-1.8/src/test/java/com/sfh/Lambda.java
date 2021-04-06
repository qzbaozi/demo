package com.sfh;

import com.sfh.entity.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * 用例说明博客：
 * https://blog.csdn.net/qq_29411737/article/details/80835658
 *
 */
public class Lambda {

    /**
     * lambda  与普通代码对比
     */
    @Test
    public void compare() {
        //匿名内部类
        Comparator<Integer> cpt = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> set = new TreeSet<>(cpt);

        System.out.println("=========================");

        //使用lambda表达式
        Comparator<Integer> cpt2 = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> set2 = new TreeSet<>(cpt2);
    }
}
