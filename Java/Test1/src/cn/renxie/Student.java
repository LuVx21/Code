package cn.renxie;

import java.util.Arrays;

/**
 * 回调函数示例 某个程序S(Student.main) 调用 服务程序A(Arrays) 中的某个方法(sort),
 * 服务程序A的sort方法在某个时候反过来调用S的某个方法(compareTo),这种情况下,compareTo叫做S的回调方法。
 */
public class Student implements Comparable<Object> {
	private int		id;
	private String	name;
	private int		age;
	private int		score;

	public Student(int id, String name, int age, int score) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", score=" + score + "]";
	}

	// 构造器
	// getter / setter方法
	// 回调方法
	public int compareTo(Object obj) {
		System.out.println("回调函数");
		return this.id - ((Student) obj).id;
	}

	public static void main(String[] args) {
		Student s1 = new Student(2, "a", 18, 89);
		Student s2 = new Student(3, "x", 22, 94);
		Student s3 = new Student(1, "w", 19, 78);
		Student[] arrs = {s1, s2, s3};
		Arrays.sort(arrs);
		for (Student student : arrs) {
			System.out.println(student);
		}
	}
}
