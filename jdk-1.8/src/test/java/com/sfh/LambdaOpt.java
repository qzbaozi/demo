package com.sfh;

import com.sfh.entity.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Lmabda表达式的语法总结： () -> ();
 *
 * 前置	语法
 * 无参数无返回值	() -> System.out.println(“Hello WOrld”)
 * 有一个参数无返回值	(x) -> System.out.println(x)
 * 有且只有一个参数无返回值	x -> System.out.println(x)
 * 有多个参数，有返回值，有多条lambda体语句	(x，y) -> {System.out.println(“xxx”);return xxxx;}；
 * 有多个参数，有返回值，只有一条lambda体语句	(x，y) -> xxxx
 * 口诀：左右遇一省括号，左侧推断类型省
 *
 * 注：当一个接口中存在多个抽象方法时，如果使用lambda表达式，并不能智能匹配对应的抽象方法，因此引入了函数式接口的概念
 *
 */
public class LambdaOpt {

    /**
     * 这样一个场景，在商城浏览商品信息时，经常会有条件的进行筛选浏览，
     * 例如要选颜色为红色的、价格小于8000千的
     * @param list
     * @return
     */
    // 筛选颜色为红色
    public List<Product> filterProductByColor(List<Product> list){
        List<Product> prods = new ArrayList<>();
        for (Product product : list){
            if ("红色".equals(product.getColor())){
                prods.add(product);
            }
        }
        return prods;
    }

    // 筛选价格小于8千的
    public  List<Product> filterProductByPrice(List<Product> list){
        List<Product> prods = new ArrayList<>();
        for (Product product : list){
            if (product.getPrice() < 8000){
                prods.add(product);
            }
        }
        return prods;
    }

    /**
     * 优化一：使用设计模式
     */
    public interface MyPredicate <T> {
        boolean test(T t);
    }

    public class ColorPredicate implements MyPredicate <Product> {

        private static final String RED = "红色";

        @Override
        public boolean test(Product product) {
            return RED.equals(product.getColor());
        }
    }

    public List<Product> filterProductByPredicate(List<Product> list,MyPredicate<Product> mp){
        List<Product> prods = new ArrayList<>();
        for (Product prod : list){
            if (mp.test(prod)){
                prods.add(prod);
            }
        }
        return prods;
    }

    public class PricePredicate implements MyPredicate<Product> {
        @Override
        public boolean test(Product product) {
            return product.getPrice() < 8000;
        }
    }


    /**
     * 优化一：使用设计模式
     *每次变更需求都需要新建一个实现类，感觉还是有点繁琐
     * end
     */


    /**
     * 优化二：使用匿名内部类
     */
    public List<Product> filterProductByPredicateAnonymous(List<Product> list,MyPredicate<Product> mp){
        List<Product> prods = new ArrayList<>();
        for (Product prod : list){
            if (mp.test(prod)){
                prods.add(prod);
            }
        }
        return prods;
    }

    List<Product> proList=new ArrayList<>();
    // 按价格过滤
    public void test2(){
        filterProductByPredicate(proList, new MyPredicate<Product>() {
            @Override
            public boolean test(Product product) {
                return product.getPrice() < 8000;
            }
        });
    }

    // 按颜色过滤
    public void test3(){
        filterProductByPredicate(proList, new MyPredicate<Product>() {
            @Override
            public boolean test(Product product) {
                return "红色".equals(product.getColor());
            }
        });
    }
    /**
     * 优化二：使用匿名内部类
     * end
     */
    /**
     * 优化三：使用lambda表达式
     */
    @Test
    public void test4(){
        List<Product> products = filterProductByPredicate(proList, (p) -> p.getPrice() < 8000);
        for (Product pro : products){
            System.out.println(pro);
        }
    }
    /**
     * 优化三：使用lambda表达式
     * end
     */
    /**
     * 优化四：使用Stream API
     */
    // 使用jdk1.8中的Stream API进行集合的操作
    @Test
    public void test(){
        // 根据价格过滤
        proList.stream()
                .filter((p) -> p.getPrice() <8000)
                .limit(2)
                .forEach(System.out::println);

        // 根据颜色过滤
        proList.stream()
                .filter((p) -> "红色".equals(p.getColor()))
                .forEach(System.out::println);

        // 遍历输出商品名称
        proList.stream()
                .map(Product::getName)
                .forEach(System.out::println);
    }
    /**
     * 优化四：使用Stream API
     * end
     */
}
