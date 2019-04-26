package fastjson;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Person {
     
    public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	private int age;	
 
    private String fullName;
 
    private Date dateOfBirth;
 
    public Person(int age, String fullName, Date dateOfBirth) {
        super();
        this.age = age;
        this.fullName= fullName;
        this.dateOfBirth = dateOfBirth;
    }
    public String toString() {
    	return ""+age+","+fullName+","+dateOfBirth.toString();
    }
    // 标准 getters & setters
}