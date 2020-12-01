package test.learnjersey;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement() 
public class Course {
	private String name;
	private int code;
	
	
	
	public Course() {
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
}
