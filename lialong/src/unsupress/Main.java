package unsupress;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<String> set1 = new HashSet<String>(Arrays.asList("li","a","long"));
		Set<String> set2 = new HashSet<String>(Arrays.asList("zhong","shan","daxue"));
		Set<String> un = union(set1,set2);
	}
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
	    Set<E> result = new HashSet<E>(s1);
	    result.addAll(s2);
	    return result;
	}
}
