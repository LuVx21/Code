package me.ren.pattern.Factory;

import me.ren.pattern.Factory.Abstract.FactoryAB;
import me.ren.pattern.Factory.Factory.FactoryProductA;
import me.ren.pattern.Factory.Factory.FactoryProductB;
import me.ren.pattern.Factory.Simple.Factory;
import org.junit.Test;

public class FactoryTest {

    /**
     * 简单方法模式
     */
    @Test
    public void getProductTest() {
        Factory factory = new Factory();
        factory.getProduct("A").methodDiff();
        factory.getProduct("B").methodDiff();
    }

    /**
     * 工厂方法模式
     */
    @Test
    public void getProductTest1() {
        FactoryProductA factoryA = new FactoryProductA();
        FactoryProductB factoryB = new FactoryProductB();
        factoryA.getProduct().methodDiff();
        factoryB.getProduct().methodDiff();
    }

    /**
     * 抽象工厂方法模式
     */
    @Test
    public void getProductTest2() {
        FactoryAB factoryAB = new FactoryAB();
        factoryAB.getProductA().methodDiff();
        factoryAB.getProductB().methodDiff();
    }

}
