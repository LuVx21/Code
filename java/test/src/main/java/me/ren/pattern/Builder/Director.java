package me.ren.pattern.Builder;

public class Director {

    private Builder builder;

    public Director() {

    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Director(Builder builder) {
        this.builder = builder;
    }


    public Car build() {
        builder.buildwheels();
        builder.buildengine();

        return builder.getCar();
    }

    public Car build1(Builder builder) {
        builder.buildwheels();
        builder.buildengine();

        return builder.getCar();
    }
}
