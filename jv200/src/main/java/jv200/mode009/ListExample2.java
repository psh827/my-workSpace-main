package jv200.mode009;

import java.util.ArrayList;
import java.util.List;
/**
 * ArrayList<Type> name = new ArrayList<Type>();
 * name.size() = length
 * name.get(i) = i번재 인데스의 값을 가져온다.
 * get은 Object로 받아야한다. generic을 사용했을 경우는 바로 그 Type으로 받으면 된다.
 * iterators -> list의 동적 삭제 추가 시 사용해야함. enhanced for loop로는 에러가 난다.
 * @author Administrator
 *
 */
public class ListExample2 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(new Integer(10));
		list.add(16);
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(int i : list) {
			System.out.println(i);
		}
		
		System.out.println(list);
	}
}
