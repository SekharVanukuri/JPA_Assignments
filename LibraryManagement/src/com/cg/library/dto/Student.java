/**
 * 
 */
package com.cg.library.dto;

/**
 * @author Lenovo
 *
 */
public class Student {
	private String studentId;

	/**
	 * 
	 */
	public Student() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the studentId
	 */
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + "]";
	}

	/**
	 * @param studentId
	 */
	public Student(String studentId) {
		super();
		this.studentId = studentId;
	}
	

}
