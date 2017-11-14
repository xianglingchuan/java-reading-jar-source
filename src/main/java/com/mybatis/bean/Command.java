package com.mybatis.bean;

import java.util.List;

public class Command {

	private int id;
	private String name;
	private String description;
	//命令所关系的内容信息
	public List<CommandContent> contentList;

	public Command() {
		super();
	}

	public Command(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CommandContent> getContentList() {
		return contentList;
	}

	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}

}
