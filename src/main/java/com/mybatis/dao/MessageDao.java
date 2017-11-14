package com.mybatis.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.bean.Command;
import com.mybatis.bean.Message;
import com.mybatis.util.DBMybatisUtil;



public class MessageDao{

	
	/**
	 * 源始的DB操作数据库表方式
	 * 
	 */
	public List<Message> getList(Message message){
		//String sql1 = "select ID, COMMAND, DESCRIPTION, CONTENT from message where COMMAND='查看'";
		StringBuilder sql = new StringBuilder("select ID, COMMAND, DESCRIPTION, CONTENT from message WHERE 1=1");
		List<String> paramerList = new ArrayList<String>();
		if(message.getCommand()!=null && !message.getCommand().trim().equals("")){
			sql.append(" AND COMMAND=?");
			paramerList.add(message.getCommand());
		}
		if(message.getDescription()!=null && !message.getDescription().trim().equals("")){
			sql.append(" AND DESCRIPTION like ? ");
			paramerList.add("%"+message.getDescription()+"%");
		}
		//ResultSet resultSet = DBMybatisUtil.executeQuery(sql.toString(), paramerList);
		List<Message> list = new ArrayList<Message>();
//		try {
//			while(resultSet.next()){
//				Message messageTmp = new Message();
//				messageTmp.setId(resultSet.getInt("ID"));
//				messageTmp.setCommand(resultSet.getString("COMMAND"));
//				messageTmp.setDescription(resultSet.getString("DESCRIPTION"));
//				messageTmp.setContent(resultSet.getString("CONTENT"));
//				System.out.println(messageTmp.toString());
//				list.add(messageTmp);
//			}
//			resultSet.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}	
		return list;
	}
	
	
	/**
	 * 通过MyBatis查询数据列表 
	 * */
	public List<Message> queryList(Message message){
		SqlSession sqlSession = null;
		List<Message> list = new ArrayList<Message>();
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//list = sqlSession.selectList("Message.queryList",message);
			//通过反射操数据表
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			list = iMessage.queryList(message);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return list;
	}
	
	
	/**
	 * 删除单条数据
	 * */
	public Integer deleteOne(Integer id){
		SqlSession sqlSession = null;
		int result = 0;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//result = sqlSession.delete("Message.deleteOne",id);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			result = iMessage.deleteOne(id);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return result;
	}
	
	
	
	
	
	/**
	 * 批量删除多条数据
	 * */
	public int deleteBatch(Integer[] ids){
		SqlSession sqlSession = null;
		int result = 0;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//result = sqlSession.delete("Message.deleteBatch",ids);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			result = iMessage.deleteBatch(ids);
			
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return result;
	}
	
	
	/**
	 * 查询一条语句
	 * */
	public Message get(Message entity){
		SqlSession sqlSession = null;
		Message info = null;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//info = sqlSession.selectOne("Message.get", entity);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			info = iMessage.get(entity);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return info;
	}
	
	
	public int insert(Message entity){
		SqlSession sqlSession = null;
		int result = 0;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//result = sqlSession.insert("Message.insert", entity);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			result = iMessage.insert(entity);
			
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return result;
	}
	
	
	public int update(Message entity){
		SqlSession sqlSession = null;
		int result = 0;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//result = sqlSession.update("Message.update", entity);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			result = iMessage.update(entity);			
			
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return result;
	}	
	
	
	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message entity) {
		SqlSession sqlSession = null;
		int result = 0;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//result = sqlSession.selectOne("Message.count", entity);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			result = iMessage.count(entity);				
			
			sqlSession.commit();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}	
	
	
	
	
	
	/**
	 * 通过MyBatis查询数据列表 
	 * */
	public List<Message> queryListByTrim(Message message){
		SqlSession sqlSession = null;
		List<Message> list = new ArrayList<Message>();
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//list = sqlSession.selectList("Message.queryListByTrim",message);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			list = iMessage.queryListByTrim(message);			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return list;
	}
	
	
	public int updateByTrim(Message entity){
		SqlSession sqlSession = null;
		int result = 0;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//result = sqlSession.update("Message.updateByTrim", entity);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			result = iMessage.updateByTrim(entity);			
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return result;
	}	
	
	
	public int insertByTrim(Message entity){
		SqlSession sqlSession = null;
		int result = 0;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			//result = sqlSession.insert("Message.insertByTrim", entity);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			result = iMessage.insertByTrim(entity);	
			
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return result;
	}	
	
	
	
	/**
	 * 通过MyBatis查询数据列表 
	 * */
	public List<Message> queryListPage(Map map){
		System.out.println("queryListPage......");
		SqlSession sqlSession = null;
		List<Message> list = new ArrayList<Message>();
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			Command command = new Command();
			//list = sqlSession.selectList("Message.queryListPage",command);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			list = iMessage.queryListPage(map);
			//System.out.println("list.size:"+list.size());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return list;
	}	
	
	
	/**
	 * 通过MyBatis查询数据列表 
	 * */
	public List<Message> queryMessageListByPage(Map map){
		System.out.println("queryListPage......");
		SqlSession sqlSession = null;
		List<Message> list = new ArrayList<Message>();
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			Command command = new Command();
			//list = sqlSession.selectList("Message.queryListPage",command);
			IMessage iMessage = sqlSession.getMapper(IMessage.class);
			list = iMessage.queryMessageListByPage(map);
			//System.out.println("list.size:"+list.size());
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return list;
	}	
	
	
	
	
}
