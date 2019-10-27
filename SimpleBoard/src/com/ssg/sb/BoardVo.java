package com.ssg.sb;

public class BoardVo {
	private String title;
	private String content;
	
	//getter, setter메소드 통해(넣고, 뺀다)
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
	//생성자통해(넣는다)
	public BoardVo(String title, String content) {
		this.title = title;
		this.content = content;		
	}

}
