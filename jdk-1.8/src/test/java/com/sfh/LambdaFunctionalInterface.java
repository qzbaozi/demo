package com.sfh;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 函数式接口的提出是为了给Lambda表达式的使用提供更好的支持。
 */
public class LambdaFunctionalInterface {
    /**
     * Consumer 《T》：消费型接口，有参无返回值
     */
    @Test
    public void test(){
        changeStr("hello",(str) -> System.out.println(str));
    }

    /**
     *  Consumer<T> 消费型接口
     * @param str
     * @param con
     */
    public void changeStr(String str, Consumer<String> con){
        con.accept(str);
    }

    @Test
    public void test2(){
        String value = getValue(() -> "hello");
        System.out.println(value);
    }

    /**
     *  Supplier<T> 供给型接口
     * @param sup
     * @return
     */
    public String getValue(Supplier<String> sup){
        return sup.get();
    }


    @Test
    public void test3(){
        Long result = changeNum(100L, (x) -> x + 200L);
        System.out.println(result);
    }

    /**
     *  Function<T,R> 函数式接口
     * @param num
     * @param fun
     * @return
     */
    public Long changeNum(Long num, Function<Long, Long> fun){
        return fun.apply(num);
    }


    public void test4(){
        boolean result = changeBoolean("hello", (str) -> str.length() > 5);
        System.out.println(result);
    }

    /**
     *  Predicate<T> 断言型接口
     * @param str
     * @param pre
     * @return
     */
    public boolean changeBoolean(String str, Predicate<String> pre){
        return pre.test(str);
    }
}
