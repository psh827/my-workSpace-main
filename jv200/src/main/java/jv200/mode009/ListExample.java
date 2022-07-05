package jv200.mode009;

import java.util.*;
/**
 * list는 중복 o, 순서 o
 * @author Administrator
 *
 */
public class ListExample {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("one");
		list.add("second");
		list.add("3rd");
		list.add(4);
		list.add(new Float(5.0F));
		list.add("second");
		list.add(new Integer(4));
		System.out.println(list);
	}
}
