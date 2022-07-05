package jv200.mode007;

/**
 * -. abstract메소드의 집합, 상수(public)
 * -. 인스턴스(객체) 생성 불가
 * -. 다중 상속 지원
 * @author Administrator
 *
 */
public interface Flyer {
	public void fly(); // interface내에서는 abstract을 안쓰고 public도 기본이라 생략한다. default가 아님! public이 생략된것.
	public void takeOff();
	public void land();
}
