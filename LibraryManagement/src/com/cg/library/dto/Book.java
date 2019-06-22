package com.cg.library.dto;

public class Book {
	private int bId;
	private String bName;
	private int bPrice;
	private String bAuthor;
	private int bPage;
	
	public Book()
	{
		
	}

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public int getbPrice() {
		return bPrice;
	}

	public void setbPrice(int bPrice) {
		this.bPrice = bPrice;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public void setbAuthor(String bAuthor) {
		this.bAuthor = bAuthor;
	}

	public int getbPage() {
		return bPage;
	}

	public void setbPage(int bPage) {
		this.bPage = bPage;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bName=" + bName + ", bPrice=" + bPrice
				+ ", bAuthor=" + bAuthor + ", bPage=" + bPage + "]";
	}

	public Book(int bId, String bName, int bPrice, String bAuthor, int bPage) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bPrice = bPrice;
		this.bAuthor = bAuthor;
		this.bPage = bPage;
	}
	

}
