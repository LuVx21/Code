#Java枚举类型enum

@(JavaSE)

> [toc]

## 枚举的语法
Enum的全称为enumeration,中文俗称枚举类,学过C/C++等语言的人，应该都对它略知一二。
    但在Java语言规范中,是在JDK 5版本中才引入的，存放在 java.lang 包中。在Java版的Enum实质是语法糖,其声明方式如下:
```
package com.enumtest;  
public enum Color  
{  
    RED,BLUE,BLACK,YELLOW,GREEN   //注意这里可以没有分号  
}     
```
　　enum是用来声明枚举的关键字,声明定义的类都隐含继承了一个父类(java.lang.Enum<E>),因此枚举不能再继承,但仍可实现接口。
　　该父类有两个私有属性name(枚举类型的名称)和ordinal(枚举实例被创建的序数),分别通过name()和ordinal()暴露出来了.
　　定义在枚举类型里的每一个枚举实例都将映射到Enum的子类中,其实例的名称和在枚举类型里定义的顺序都会传入到这个构造函数里 : protected Enum(String name, int ordinal)。
　　如果想更清楚了解一下Enum,可以用反编译工具把自己定义的枚举反编译一下就一目了然了,它就是一个普通的类,只是Java语言规范从Code角度进行了限制,执行javap com.enumtest.Color命令如下:
```
package com.enumtest;  
  public final class Color extends  java.lang.Enum{   
    public static final Color RED;   
    public static final Color BLUE;   
    public static final Color BLACK;   
    public static final Color YELLOW;   
    public static final Color GREEN;   
    static {};   
    public static Color[] values();   
    public static Color valueOf(java.lang.String);   
}   
```
## 继承的方法
所有枚举类都继承了Enum的方法，下面我们详细介绍这些方法。
1. ordinal()方法
返回枚举值在枚举类种的顺序。这个顺序根据枚举值声明的顺序而定。
    Color.RED.ordinal(); //返回结果：0
    Color.BLUE.ordinal(); //返回结果：1
2. compareTo()方法: 
Enum实现了java.lang.Comparable接口，因此可以比较象与指定对象的顺序。Enum中的compareTo返回的是两个枚举值的顺序之差。当然，前提是两个枚举值必须属于同一个枚举类，否则会抛出ClassCastException()异常。(具体可见源代码)
    Color.RED.compareTo(Color.BLUE); //返回结果 -1
3. values()方法
 静态方法，返回一个包含全部枚举值的数组。
    Color[] colors=Color.values();
    for(Color c:colors){
        System.out.print(c+","); 
    }//返回结果：RED,BLUE,BLACK YELLOW,GREEN,
4. toString()方法
返回枚举常量的名称。
    Color c=Color.RED;
    System.out.println(c);//返回结果: RED
5. valueOf()方法
这个方法和toString方法是相对应的，返回带指定名称的指定枚举类型的枚举常量。
    Color.valueOf("BLUE"); //返回结果: Color.BLUE
6. equals()方法
比较两个枚举类对象的引用。
> 如果定义的枚举有自己的构造函数必须声明私有的。

 注意以下区别：
```Java
enum Color3{}  
  
enum Color4  
{  
    RED  
}  
  
enum Color5  
{  
    RED;  
}  
  
enum Color6  
{  
    RED;  
    public void test(){}  
}  
  
enum Color7  
{  
    public void test(){}  
   // RED;  //枚举值不能定义在方法后面！！！！  
}  

enum Color8  
{  
    ;  
    public void test(){}  
}  
```
 在enum Color3中是一个空的枚举；在enum Color4和Color5中有一个RED的枚举值，后面可以加分号或者不加分号；如果在枚举值后面添加方法，那么在枚举值的最后添加一个分号，如enum Color6；如果像enum Color7一样想把枚举值定义在方法后面是非法的，编译器会提示错误；当然也可以像enum Color8一样定义，注意方法test()之前的分号。
 
枚举的用法
1. 常用于对同一类常量进行分类。
2. 声明接口方法时,输入参数类型采用枚举比用原始类型值常量更严谨. 
3. 常量有时往往不仅仅只是一个值,有可能会包含多个属性,此时很适合用枚举 
4. 有时常量对象需要从配置文件中读取其描述信息或者UI显示信息,此时也适合用枚举 
5. 从Java语法层面来说,枚举可以在switch使用,在if中可直接进行比较 。
```
package com.enumtest;  
  
public enum Color   
{  
    RED,BLUE,BLACK,YELLOW,GREEN; //注意这里有分号  
  
    public static void valuePrint(Color color)  
    {  
        switch(color)  
        {  
            case RED:  
                System.out.println(RED);  
                break;  
            case BLUE:  
                System.out.println(BLUE);  
                break;  
            case BLACK:  
                System.out.println(BLACK);  
                break;  
            case YELLOW:  
                System.out.println(YELLOW);  
                break;  
            case GREEN:  
                System.out.println(GREEN);  
                break;  
            default:  
                break;  
        }  
    }  
  
    public static void main(String args[])  
    {  
        Color color = Color.RED;  
        valuePrint(color);  
        EnumTest.valuePrint(color);  
    }  
}  
  
class EnumTest  
{  
    public static void valuePrint(Color color)  
    {  
        switch(color)  
        {  
            case RED:  
                System.out.println(Color.RED);//注意这里的Color.RED不能写成RED，而case中的必须写成RED。  
                break;  
            case BLUE:  
                System.out.println(Color.BLUE);  
                break;  
            case BLACK:  
                System.out.println(Color.BLACK);  
                break;  
            case YELLOW:  
                System.out.println(Color.YELLOW);  
                break;  
            case GREEN:  
                System.out.println(Color.GREEN);  
                break;  
            default:  
                break;  
        }  
    }  
}  
```
运行结果：

```
RED  
RED  
```

6. 声明枚举属性时最好用public final修饰,使用起来会非常方便 
7. 自定义枚举时,建议不要使用自带的name()和ordinal()方法返回值来与原始值类型转换,这样业务不依赖其枚举的名字和顺序
```
package com.enumtest;  
  
public enum Color2  
{  
    RED("红色",1),BLUE("蓝色",2),BLACK("黑色",3),YELLOW("黄色",4),GREEN("绿色",5);  
  
    public final String name;  
    public final int index;  
  
    private Color2(String name, int index)  
    {  
        this.name = name;  
        this.index = index;  
    }  
  
    public static String getName(int index)  
    {  
        for(Color2 c: Color2.values())  
        {  
            if(c.getIndex() == index)  
            {  
                return c.name;  
            }  
        }  
        return null;  
    }  
  
    public static void main(String[] args)  
    {  
        System.out.println(getName(1));  
    }  
  
    public String getName()  
    {  
        return name;  
    }  
  
    public int getIndex()  
    {  
        return index;  
    }  
}  
```
运行结果：红色
8. 重载枚举的方法toString
```
package com.enumtest;  
  
public enum Color2  
{  
    RED("红色",1),BLUE("蓝色",2),BLACK("黑色",3),YELLOW("黄色",4),GREEN("绿色",5);  
  
    public final String name;  
    public final int index;  
  
    private Color2(String name, int index)  
    {  
        this.name = name;  
        this.index = index;  
    }  
  
    public static String getName(int index)  
    {  
        for(Color2 c: Color2.values())  
        {  
            if(c.getIndex() == index)  
            {  
                return c.toString();  
            }  
        }  
        return null;  
    }  
  
    public static void main(String[] args)  
    {  
        System.out.println(getName(1));  
    }  
  
    @Override  
    public String toString()  
    {  
        return this.index+"_"+this.name;  
    }  
  
    public String getName()  
    {  
        return name;  
    }  
  
    public int getIndex()  
    {  
        return index;  
    }  
}  
```
9. 实现接口。所有的枚举都继承自java.lang.Enum类。由于java不支持多继承，所以枚举对象不能再继承其他的类。
```
package com.enumtest;  
  
public interface Behaviour  
{  
    void print();  
    String getInfo();  
}  
```
```
package com.enumtest;  
  
public enum Color9 implements Behaviour  
{  
    RED("红色",1),BLUE("蓝色",2),BLACK("黑色",3),YELLOW("黄色",4),GREEN("绿色",5);  
  
    public final String name;  
    public final int index;  
  
    private Color9(String name, int index)  
    {  
        this.name = name;  
        this.index = index;  
    }  
  
    @Override  
    public void print()  
    {  
        System.out.println(this.index+":"+this.name);  
    }  
  
    @Override  
    public String getInfo()  
    {  
        return this.name;  
    }  
}  
```
10. 可以创建一个enum类，把它看做一个普通的类。除了它不能继承其他类。（Java是单继承，它已经继承了Enum),可以添加其他的方法，覆盖它本身的方法。
11. values()方法是编译器插入到enum定义中的static方法，所以，当你将enum实例向上转型为父类Enum是，values()就不可访问了。解决办法：在Class中有一个getEnumConstants()方法，所以即便Enum接口中没有values()方法，我们仍然可以通过Class对象取得所有的enum实例。
```
package com.enumtest;  
  
public enum Color   
{  
    RED,BLUE,BLACK,YELLOW,GREEN; //注意这里有分号  
  
    public void print()  
    {  
        for(Color c : Color.class.getEnumConstants())  
        {  
            System.out.println(c.toString());  
        }  
    }  
  
    public static void main(String args[])  
    {  
        Color.RED.print();  
    }  
}  
```
12. 无法从enum继承子类，如果需要扩展enum中的元素，在一个接口的内部，创建实现该接口的枚举，以此将元素进行分组。达到将枚举元素进行分组。
```
package com.enumtest;  
  
public interface Food  
{  
    enum Coffee implements Food   
    {  
        BLACK_COFFEE, DECAF_COFFEE,LATTE;  
    }  
  
    enum Dessert implements Food  
    {  
        FRUIT,CAKE,GELATO;  
    }  
}  
```
13. java.util.EnumSet和java.util.EnumMap是两个枚举集合。EnumSet保证集合中的元素不重复;EnumMap中的 key是enum类型，而value则可以是任意类型。
```
package com.enumtest;  
  
import java.util.EnumMap;  
import java.util.EnumSet;  
import java.util.Set;  
  
public class LightTest  
{  
    public enum Light{  
        RED(1),GREEN(2),YELLOW(3);  
  
        public final int nCode;  
  
        private Light(int nCode)  
        {  
            this.nCode = nCode;  
        }  
    }  
  
    public static void testTraversalEnum()  
    {  
        Light[] allLight = Light.values();  
        for(Light aLight:allLight)  
        {  
            System.out.println(aLight.name()+" "+aLight.ordinal()+" "+aLight);  
        }  
    }  
  
    public static void testEnumMap()  
    {  
        EnumMap<Light,String> currEnumMap = new EnumMap<Light,String>(Light.class);  
        currEnumMap.put(Light.RED, "红色");  
        currEnumMap.put(Light.GREEN, "绿色");  
        currEnumMap.put(Light.YELLOW, "黄色");  
        Set<Light> set = currEnumMap.keySet();  
        for(Light aLight:set)  
        {  
            System.out.println(aLight.name()+" "+aLight.ordinal()+" "+aLight);  
        }  
    }  
  
    public static void testEnumSet()  
    {  
        EnumSet<Light> currEnumSet = EnumSet.allOf(Light.class);  
        for(Light aLightSetElement : currEnumSet)  
        {  
            System.out.println(aLightSetElement);  
        }  
    }  
  
    public static void main(String[] args)  
    {  
        testTraversalEnum();  
        testEnumMap();  
        testEnumSet();  
    }  
}  
```
运行结果：（略）
14. 使用enum的职责链(Chain of Responsibility) .这个关系到设计模式的职责链模式。以多种不同的方法来解决一个问题。然后将他们链接在一起。当一个请求到来时，遍历这个链，直到链中的某个解决方案能够处理该请求。

