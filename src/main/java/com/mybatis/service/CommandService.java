package com.mybatis.service;

import java.util.List;

import com.mybatis.bean.Command;
import com.mybatis.dao.CommandDao;


public class CommandService {

	private CommandDao commandDao;

	public CommandService() {
		commandDao = new CommandDao();
	}

	public List<Command> queryList(Command command){
		return commandDao.queryList(command);
	}
	
	public Command get(Command entity){
		return commandDao.get(entity);
	}	
}
