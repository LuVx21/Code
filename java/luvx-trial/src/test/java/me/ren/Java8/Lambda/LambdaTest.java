package me.ren.Java8.Lambda;

import me.ren.Java8.Lambda.Lambda.GreetingService;
import me.ren.Java8.Lambda.Lambda.MathOperation;
import org.junit.Test;

public class LambdaTest {
	
	@Test
	public void lambdaoperatetest() {
		Lambda tester = new Lambda();

		Runnable noArguments = () -> System.out.println("START");
		MathOperation addition = (int a, int b) -> a + b;
		MathOperation subtraction = (a, b) -> a - b;
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};
		MathOperation division = (int a, int b) -> a / b;

		noArguments.run();
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + multiplication.operation(10, 5));
		System.out.println("10 / 5 = " + division.operation(10, 5));

		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		greetService1.sayMessage("Hello");
		greetService2.sayMessage("World");
	}
}
