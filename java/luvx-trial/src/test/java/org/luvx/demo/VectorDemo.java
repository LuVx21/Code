package org.luvx.demo;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {
	public static void main(String args[]) {
		// initial size is 3, increment is 2
		Vector<Number> v = new Vector<Number>(3, 2);
		System.out.println("Initial size: " + v.size());// 0
		System.out.println("Initial capacity: " + v.capacity());// 3

		v.addElement(new Integer(1));
		v.addElement(new Integer(2));
		v.addElement(new Integer(3));
		v.addElement(new Integer(4));
		System.out.println("Capacity after four additions: " + v.capacity());// 5

		v.addElement(new Double(5.45));
		System.out.println("Current capacity: " + v.capacity());// 5

		v.addElement(new Double(6.08));
		v.addElement(new Integer(7));
		System.out.println("Current capacity: " + v.capacity());// 7

		v.addElement(new Float(9.4));
		v.addElement(new Integer(10));
		System.out.println("Current capacity: " + v.capacity());// 9

		v.addElement(new Integer(11));
		v.addElement(new Integer(12));
		// firstElement(),lastElement()函数
		System.out.println("First element: " + (Integer) v.firstElement());// 1
		System.out.println("Last element: " + (Integer) v.lastElement());// 12

		// contain()函数
		System.out.println(v.contains(3) ? "Vector contains 3." : "not in");

		// enumerate the elements in the vector.
		// 遍历vector
		Enumeration<Number> vEnum = v.elements();
		System.out.println("\nElements in vector:");
		while (vEnum.hasMoreElements()) {
			System.out.print(vEnum.nextElement() + " ");
		}
	}
}