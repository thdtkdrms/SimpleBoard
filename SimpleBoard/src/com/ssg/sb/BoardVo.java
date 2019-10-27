package com.ssg.sb;

public class BoardVo {
	private int i_board;
	private String title;
	private String content;
	private String regDateTime;

	//생성자통해(넣는다)
	public BoardVo(String title, String content) {
		this.title = title;
		this.content = content;		
	}
	
	public BoardVo(int i_board, String title, String content, String regDateTime) {
		this.i_board = i_board;
		this.title = title;
		this.content = content;		
		this.regDateTime = regDateTime;
	}
	
	//getter, setter메소드 통해(넣고, 뺀다)
	
	public String getRegDateTime() {
		return regDateTime;
	}

	public int getI_board() {
		return i_board;
	}

	public void setI_board(int i_board) {
		this.i_board = i_board;
	}

	public void setRegDateTime(String regDateTime) {
		this.regDateTime = regDateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	

	
	
	
}
