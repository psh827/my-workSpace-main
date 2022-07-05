package jv200.mode007;

public class Bird extends Animal implements Flyer{

	public void fly() {
		System.out.println("새 : 날기");
	}

	public void takeOff() {
		System.out.println("새 : 이륙하기");
	}

	public void land() {
		System.out.println("새 : 착륙하기");
	}

	@Override
	public void makeSound() {
		System.out.println("짹짹");
		
	}

}
