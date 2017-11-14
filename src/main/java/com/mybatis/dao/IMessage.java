package com.mybatis.dao;

import java.util.List;
import java.util.Map;

import com.mybatis.bean.Message;


public interface IMessage {

	// 获取列表
	public List<Message> queryList(Message message);

	//获取列表并分页
	public List<Message> queryListPage(Map map);

	// 删除单条数据
	public int deleteOne(Integer id);

	public int deleteBatch(Integer[] ids);

	public Message get(Message entity);

	public int insert(Message entity);

	public int update(Message entity);

	public int count(Message entity);

	public List<Message> queryListByTrim(Message message);

	public int updateByTrim(Message entity);

	public int insertByTrim(Message entity);
	
	//获取列表并分页-利用拦截器处理
	public List<Message> queryMessageListByPage(Map map);
}
