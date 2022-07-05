package jv200.mode009;

import java.util.HashSet;
import java.util.Set;
/**
 * set은 중복 x, 순서 x
 * @author Administrator
 *
 */
public class SetExample {
	public static void main(String[] args) {
		Set set = new HashSet();
		set.add("one");
		set.add("second");
		set.add("3rd");
		set.add(new Integer(4));
		set.add(new Float(5.0F));
		set.add("second");
		set.add(new Integer(4));
		System.out.println(set);
	}
}
