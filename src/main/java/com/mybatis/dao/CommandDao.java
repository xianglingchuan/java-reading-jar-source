package com.mybatis.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.bean.Command;
import com.mybatis.util.DBMybatisUtil;


public class CommandDao {

	/**
	 * 通过MyBatis查询数据列表 
	 * */
	public List<Command> queryList(Command command){
		SqlSession sqlSession = null;
		List<Command> list = new ArrayList<Command>();
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			list = sqlSession.selectList("Command.queryList",command);
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
	 * 查询一条语句
	 * */
	public Command get(Command entity){
		SqlSession sqlSession = null;
		Command info = null;
		try {
			DBMybatisUtil dbMybatisUtil = new DBMybatisUtil();
			sqlSession = dbMybatisUtil.getSqlSession();
			info = sqlSession.selectOne("Command.get", entity);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(sqlSession!=null){
				sqlSession.close();
			}
		}		
		return info;
	}	
}
