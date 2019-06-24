package com.cg.library.dto;

import java.sql.Date;

public class Book {
	private int bId;
	private String bName;
	private int bPrice;
	private String bAuthor;
	private int bPage;
	private Date issueDate;
	private Date returnDate;
	private String studentId;
	/**
	 * 
	 */
	public Book() {
		super();
	}
	/**
	 * @param bId
	 * @param bName
	 * @param bPrice
	 * @param bAuthor
	 * @param bPage
	 * @param issueDate
	 * @param returnDate
	 * @param studentId
	 */
	public Book(int bId, String bName, int bPrice, String bAuthor, int bPage, Date issueDate, Date returnDate,
			String studentId) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bPrice = bPrice;
		this.bAuthor = bAuthor;
		this.bPage = bPage;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.studentId = studentId;
	}
	/**
	 * @return the bId
	 */
	public int getbId() {
		return bId;
	}
	/**
	 * @param bId the bId to set
	 */
	public void setbId(int bId) {
		this.bId = bId;
	}
	/**
	 * @return the bName
	 */
	public String getbName() {
		return bName;
	}
	/**
	 * @param bName the bName to set
	 */
	public void setbName(String bName) {
		this.bName = bName;
	}
	/**
	 * @return the bPrice
	 */
	public int getbPrice() {
		return bPrice;
	}
	/**
	 * @param bPrice the bPrice to set
	 */
	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}
	/**
	 * @return the bAuthor
	 */
	public String getbAuthor() {
		return bAuthor;
	}
	/**
	 * @param bAuthor the bAuthor to set
	 */
	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}
	/**
	 * @return the bPage
	 */
	public int getbPage() {
		return bPage;
	}
	/**
	 * @param bPage the bPage to set
	 */
	public void setbPage(int bPage) {
		this.bPage = bPage;
	}
	/**
	 * @return the issueDate
	 */
	public Date getIssueDate() {
		return issueDate;
	}
	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}
	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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
		return "Book [bId=" + bId + ", bName=" + bName + ", bPrice=" + bPrice + ", bAuthor=" + bAuthor + ", bPage="
				+ bPage + ", issueDate=" + issueDate + ", returnDate=" + returnDate + ", studentId=" + studentId + "]";
	}
	
}
