package com.mybatis.service;

import java.util.List;
import java.util.Map;

import com.mybatis.bean.Message;
import com.mybatis.dao.MessageDao;


public class MessageService {

	private MessageDao messageDao;

	public MessageService() {
		messageDao = new MessageDao();
	}

	public List<Message> getList(Message message){
		return messageDao.getList(message);
	}
	
	public List<Message> queryList(Message message){
		return messageDao.queryList(message);
	}
	
	
	public int deleteOne(Integer id){
		return messageDao.deleteOne(id);
	}	
	
	public int deleteBetch(String[] ids){
		Integer[] idsInteger = new Integer[ids.length];
		for(int i=0; i<ids.length; i++){
			idsInteger[i] = Integer.valueOf(ids[i]);
		}
		for (Integer integer : idsInteger) {
			System.out.println("integer:"+integer);
		}
        return messageDao.deleteBatch(idsInteger);
	}	
	
	public Message get(Message entity){
		return messageDao.get(entity);
	}
	
	public int insert(Message entity){
		return messageDao.insert(entity);
	}
	
	public int update(Message entity){
		return messageDao.update(entity);
	}
	
	public List<Message> queryListByTrim(Message message){
		return messageDao.queryListByTrim(message);
	}
	
	public int updateByTrim(Message entity){
		return messageDao.updateByTrim(entity);
	}
	
	public int insertByTrim(Message entity){
		return messageDao.insertByTrim(entity);
	}
	
	
//	//查询并分页
//	public List<Message> queryListPage(Map map){
//		//获取总记录数
//		int total = messageDao.count((Message)map.get("message"));
//		System.out.println("total:"+total);
//		Page page = (Page)map.get("page");
//		page.setTotalNumber(total);
//		page.count();
//		System.out.println(page.toString());
//		return messageDao.queryListPage(map);
//	}	
//	
//	
//	//查询并分页 - 利用拦截器分页
//	public List<Message> queryMessageListByPage(Map map){
//		//获取总记录数
//		int total = messageDao.count((Message)map.get("message"));
//		System.out.println("total:"+total);
//		Page page = (Page)map.get("page");
//		page.setTotalNumber(total);
//		page.count();
//		System.out.println(page.toString());
//		return messageDao.queryMessageListByPage(map);
//	}	
	
}
