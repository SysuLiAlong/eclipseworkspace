package lialong;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class HashSetDemo {
	public static void main(String[] args) {
		HashSet set = new HashSet<String>();
		LinkedHashSet<Object> linkedSet = new LinkedHashSet<Object>();
		int len = 5;
		String arr[] = {"c","java","python","ruby","scala"};
		for(int i=0;i<len;i++) {
			set.add(arr[i]);
			linkedSet.add(arr[i]);
		}
		linkedSet.add(1);
		Iterator<Object> ite = linkedSet.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
	}
}
