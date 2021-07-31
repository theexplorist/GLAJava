package class20;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> ram = new ArrayList<>();
		ram.add(1);
		ram.add(2);
		List<Integer> shyam = ram;
		System.out.println(shyam);
		System.out.println(ram);
		ram.remove(ram.size() - 1);
		System.out.println(shyam);
		System.out.println(ram);
		
		
		List<List<Integer>> badi = new ArrayList<>();
		
		List<Integer> list1 = new ArrayList<>();
		
		List<Integer> list2 = new ArrayList<>();
		
		badi.add(list1);
		badi.add(list2);
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(badi);
		
		list1.add(10);
		
		list1.add(20);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(badi);
		
		List<Integer> list3 = new ArrayList<>(list1);
		badi.add(list3);
		list1.remove(list1.size() - 1);
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(badi);
		
		
		
	}

}
