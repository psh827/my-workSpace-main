package jv200.mode008;

public class AddArguments3 {
	public static void main(String[] args) {
		int sum = 0;
		for(String arg : args) {
			try { //예외 발생 가능성이 있는 코드.
				sum += Integer.parseInt(arg);
			} catch (NumberFormatException nfe) { //예외 발생 시 처리 할 코드
				System.err.println("[" + arg + "] is not an integer." + " and will not be included in the sum.");
			}
		}
		System.out.println("Sum = " + sum);
	}
}
