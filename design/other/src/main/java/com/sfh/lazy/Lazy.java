package com.sfh.lazy;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 为了方便与标准的 Java 函数式接口交互，Lazy 也实现了 Supplier
 */
public class Lazy<T> implements Supplier<T> {

    private final Supplier<? extends T> supplier;

    // 利用 value 属性缓存 supplier 计算后的值
    private T value;

    private Lazy(Supplier<? extends T> supplier) {
        this.supplier = supplier;
    }

    public static <T> Lazy<T> of(Supplier<? extends T> supplier) {
        return new Lazy<>(supplier);
    }

    @Override
    public T get() {
        if (value == null) {
            T newValue = supplier.get();

            if (newValue == null) {
                throw new IllegalStateException("Lazy value can not be null!");
            }

            value = newValue;
        }

        return value;
    }

    public <S> Lazy<S> map(Function<? super T, ? extends S> function) {
        return Lazy.of(() -> function.apply(get()));
    }

    public <S> Lazy<S> flatMap(Function<? super T, Lazy<? extends S>> function) {
        return Lazy.of(() -> function.apply(get()).get());
    }

    public static void main(String[] args) {

        Lazy<Integer> a = Lazy.of(() -> 10 + 1);
        int b = a.get() + 1;
        // get 不会再重新计算, 直接用缓存的值
        int c = a.get();
    }
}