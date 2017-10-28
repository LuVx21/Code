package test;

public class Person {
	private String name;
	private int age;
	public Person() {
		super();
		// TODO 自动生成的构造函数存根
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO 自动生成的方法存根
		System.err.println("当前的对象被回收了"+this);
		super.finalize();
	}
	
}
