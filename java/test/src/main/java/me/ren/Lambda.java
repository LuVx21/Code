package me.ren;

public class Lambda {

// lambda 表达式只能引用 final 或 final 局部变量
// 不能在内部修改外部的局部变量,能否只读????
// 匿名内部类中使用类外的变量,那么此变量需要final修饰


// 使用的接口必须是函数式接口(其中只能有一个方法的接口)???
/*
interface MathOperation {
    int operation(int a, int b);
    default int addition(int a, int b){
    return a + b;
    }
}
*/
// https://www.cnblogs.com/snowInPluto/p/5981400.html
// http://www.importnew.com/16436.html
// http://blog.csdn.net/renfufei/article/details/24600507/
// http://blog.csdn.net/bitcarmanlee/article/details/70195403

   interface MathOperation {
      int operation(int a, int b);
   }

   interface GreetingService {
      void sayMessage(String message);
   }

   public int operate(int a, int b, MathOperation mathOperation){
      return mathOperation.operation(a, b);
   }

}