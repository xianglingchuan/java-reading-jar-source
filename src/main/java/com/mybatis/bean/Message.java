package com.mybatis.bean;

/**
 * 
 * 与数据表相对应的Bean对象
 * 
 */
public class Message {

	/**
	 * 记录ID号 
	 */
	private Integer id;
	
	/**
	 * 消息对应的命令
	 */	
	private String command;

	/**
	 * 消息描述
	 */		
	private String description;

	
	/**
	 * 消息内容
	 */	
	private String content;

	
	
	public Message() {
		super();
	}


	public Message(Integer id, String command, String description, String content) {
		super();
		this.id = id;
		this.command = command;
		this.description = description;
		this.content = content;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getCommand() {
		return command;
	}


	public void setCommand(String command) {
		this.command = command;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}




	@Override
	public String toString() {
		return "Message [id=" + id + ", command=" + command + ", description=" + description + ", content=" + content
				+ "]";
	}
	
	
	
}
