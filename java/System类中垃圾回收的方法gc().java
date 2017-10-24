package test;

public class RegexDemo2 {
	public static void main(String[] args) 
	{
		Person person = new Person("–ª»Ã",23);
		System.out.println(person);
		
		person = null;
		System.gc();
	}
}
