package lialong;

import java.util.ArrayList;

public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person("lialong",12);
		Person p2 = p1.clone();
		System.out.println(p1);
		System.out.println(p2);
		p2.age = 13;
		p2.arr.add("3");
		System.out.println(p1);
		System.out.println(p2);
		
	}
}

class Person implements Cloneable{
	public String name;
	public int age;
	public ArrayList<String> arr = new ArrayList<String>();
	Person(String name,int age){
		this.name = name;
		this.age = age;
		arr.add("1");
		arr.add("2");
	}
	public Person clone() throws CloneNotSupportedException {
		Person clonePerson = (Person) super.clone();
		clonePerson.arr = (ArrayList<String>) arr.clone();
		return clonePerson;
	}
	public String toString() {
		return "name:"+name+",age:"+age+",arr.size"+arr.size();
	}
}
