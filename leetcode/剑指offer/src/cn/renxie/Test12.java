package cn.renxie;
/**
 * Author: 王俊超
 * Date: 2015-04-23
 * Time: 13:39
 * Declaration: All Rights Reserved !!!
 */
public class Test12 {

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     *
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigits(int n) {
        // 输入的数字不能为小于1
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }
        // 创建一个数组用于打存放值
        int[] arr = new int[n];
        printOneToNthDigits(0, arr);
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。
     *
     * @param n   当前处理的是第个元素，从0开始计数
     * @param arr 存放结果的数组
     */
    public static void printOneToNthDigits(int n, int[] arr) {

        // 说明所有的数据排列选择已经处理完了
        if (n >= arr.length) {
            // 可以输入数组的值
            printArray(arr);
        } else {
            // 对
            for (int i = 0; i <= 9; i++) {
                arr[n] = i;
                printOneToNthDigits(n + 1, arr);
            }
        }
    }

    /**
     * 输入数组的元素，从左到右，从第一个非0值到开始输出到最后的元素。
     *
     * @param arr 要输出的数组
     */
    public static void printArray(int[] arr) {
        // 找第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }

        // 从第一个非0值到开始输出到最后的元素。
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < arr.length) {
            System.out.println();
        }
    }

    /**
     * 输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，则打印出1、2、3 一直到最大的3位数即999。
     * 【第二种方法，比上一种少用内存空间】
     *
     * @param n 数字的最大位数
     */
    public static void printOneToNthDigits2(int n) {
        // 输入值必须大于0
        if (n < 1) {
            throw new RuntimeException("The input number must larger than 0");
        }

        // 创建一个长度为n的数组
        int[] arr = new int[n];
        // 为数组元素赋初始值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }

        // 求结果，如果最高位没有进位就一直进行处理
        while (addOne(arr) == 0) {
            printArray(arr);
        }
    }

    /**
     * 对arr表示的数组的最低位加1 arr中的每个数都不能超过9不能小于0，每个位置模拟一个数位
     *
     * @param arr 待加数组
     * @return 判断最高位是否有进位，如果有进位就返回1，否则返回0
     */
    public static int addOne(int[] arr) {
        // 保存进位值，因为每次最低位加1
        int carry = 1;
        // 最低位的位置的后一位
        int index = arr.length;

        do {
            // 指向上一个处理位置
            index--;
            // 处理位置的值加上进位的值
            arr[index] += carry;
            // 求处理位置的进位
            carry = arr[index] / 10;
            // 求处理位置的值
            arr[index] %= 10;
        } while (carry != 0 && index > 0);

        // 如果index=0说明已经处理了最高位，carry>0说明最高位有进位，返回1
        if (carry > 0 && index == 0) {
            return 1;
        }

        // 无进位返回0
        return 0;
    }


    public static void main(String[] args) {
        printOneToNthDigits2(2);
        System.out.println();
        printOneToNthDigits(2);
    }

}
