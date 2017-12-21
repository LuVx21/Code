package me.ren.Java8.interface8;

/**
 * 在Java8之前,接口中只能有抽象方法
 * 现在可以使用default定义普通方法,
 * 可以看出接口逐渐在向抽象类靠拢
 */

public interface Formula {

    double calculate(int a);

    /**
     * 默认方法
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
