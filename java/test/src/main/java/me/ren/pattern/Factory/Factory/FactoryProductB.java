package me.ren.pattern.Factory.Factory;


import me.ren.pattern.Factory.Bean.FactoryInter;
import me.ren.pattern.Factory.Bean.Product;
import me.ren.pattern.Factory.Bean.ProductB;

/**
 * 工厂方法模式
 *
 * 为解决简单工厂模式中工厂类的臃肿问题,每种产品都由一个工厂创建
 */

public class FactoryProductB implements FactoryInter {

    @Override
    public Product getProduct() {
        return new ProductB();
    }
}
