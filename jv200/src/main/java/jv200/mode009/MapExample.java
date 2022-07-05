package jv200.mode009;

import java.util.*;
/**
 * map.put(Type, Type); -> Set이나 ArrayList는 add지만 map은 put으로 key, value입력
 * map.get(Key); -> Key값을 넣어서 value값을 가져올 수 있다. 
 * 
 * java 5.0 이 후로 auto-boxing 
 * int -> Integer : boxing
 * Integer -> int : unboxing
 * 자동으로 해줌.
 * new Integer(2)는 java 9이후로는 deprecated(더이상 사용하지 않는) 권고함.
 * Integer.valueof(2)를 사용하거나 그냥 2(auto-boxing)을 사용.
 * 
 * Set<Integer> set = map.keySet();
 * map의 key값들의 모음. // Set타입이기때문에 Set으로 받아야한다.
 * 
 * @author Administrator
 *
 */
public class MapExample {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(Integer.valueOf(1), "유비");
		map.put(new Integer(2), "관우");
		map.put(3, "장비");
		
		System.out.println(map.get(new Integer(1)));
		System.out.println(map.get(new Integer(2)));
		System.out.println(map.get(new Integer(3)));
		
		Set<Integer> set = map.keySet();
		for(Integer i : set) {
			System.out.println(i);
			System.out.println(map.get(i));
		}
	}
}
