package com.mybatis.service;

import java.util.List;
import java.util.Map;

import com.mybatis.bean.CommandContent;
import com.mybatis.dao.CommandContentDao;


public class CommandContentService {

	private CommandContentDao commandContentDao;

	public CommandContentService() {
		commandContentDao = new CommandContentDao();
	}

	public List<CommandContent> queryList(CommandContent commandContent){
		return commandContentDao.queryList(commandContent);
	}
	
	public CommandContent get(CommandContent entity){
		return commandContentDao.get(entity);
	}	
	
	
	public int update(CommandContent entity){
		return commandContentDao.update(entity);
	}	
	
	
	public CommandContent findInfoByOneParam(Map<String, String> entity){
		return commandContentDao.findInfoByOneParam(entity);
	}	
	
	//批量插入数据
	public Integer insertBatch(List<CommandContent> entitys){
		return commandContentDao.insertBatch(entitys);
	}	
	
}
