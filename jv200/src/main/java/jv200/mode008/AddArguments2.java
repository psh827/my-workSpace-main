package jv200.mode008;

public class AddArguments2 {
	public static void main(String[] args) {
		try { //예외 발생 가능성이 있는 코드.
			int sum = 0;
			for(String arg : args) {
				sum += Integer.parseInt(arg);
			}
			System.out.println("Sum = " + sum);
		} catch (NumberFormatException nfe) { //예외 발생 시 처리 할 코드
			System.err.println("One of the command-line " + "arguments is not an integer.");
		} finally { //예외 발생 유무와 관계없이 처리 할 코드.
		}
	}
}