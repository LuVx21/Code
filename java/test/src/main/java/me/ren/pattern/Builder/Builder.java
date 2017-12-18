package me.ren.pattern.Builder;


/**
 * 建造者中有多个建造函数,用于创建复杂产品的组成部分
 * 还有一个返回创建对象的方法
 */
public abstract class Builder {

    protected Car car = new Car();

    public abstract void buildwheels();

    public abstract void buildengine();

    public Car getCar() {
        return car;
    }
    
}
