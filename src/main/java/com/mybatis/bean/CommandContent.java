package com.mybatis.bean;

public class CommandContent {

	private int id;

	private String content;

	private int commandId;
	
	//内容所关联的命令
	private Command command;

	public CommandContent() {
		super();
	}

	public CommandContent(int id, String content, int commandId) {
		super();
		this.id = id;
		this.content = content;
		this.commandId = commandId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCommandId() {
		return commandId;
	}

	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}
	
	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

	@Override
	public String toString() {
		return "CommandContent [id=" + id + ", content=" + content + ", commandId=" + commandId + ", command=" + command
				+ "]";
	}	
	
	

}
