package com.mybatis.util;

import java.io.IOException;
import java.io.Reader;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class DBMybatisUtil {

	@Resource
	private SqlSessionFactory sqlSessionFactory;	
	
	
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库连接信息
		Reader reader;
		//reader = Resources.getResourceAsReader("com/message/config/Configuration.xml");
		//reader = Resources.getResourceAsReader("src/main/resources/Configuration.xml");
		
		//在Maven中读取Mybatis路径地址
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		//InputStream is = classloader.getResourceAsStream("Configuration.xml");
		reader = Resources.getResourceAsReader(classloader, "mybatis/Configuration.xml");
		//reader = Resources.getResourceAsReader(classloader, "springmvc/applicationContext.xml");
		
		// 通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 通过SqlSessionFactory打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
		
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		SqlSessionFactory sessionFactory2 = factoryBean.getObject();
//		System.out.println("sessionFactory2:"+sessionFactory2.toString());
//		
//		
//		SqlSession sqlSession = sessionFactory2.openSession();
//		return sqlSession;
		
	}
	
	
	
	public static void main(String[] args) {
		DBMybatisUtil mybatisUtil = new DBMybatisUtil();
		try {
			SqlSession sqlSession = mybatisUtil.getSqlSession();
			System.out.println("sqlSession:"+sqlSession);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
