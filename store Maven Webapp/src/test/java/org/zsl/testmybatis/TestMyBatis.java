package org.zsl.testmybatis;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 

import com.alibaba.fastjson.JSON;
import com.cn.store.pojo.User;
import com.cn.store.service.IUserService;

//@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  测试运行器 
//@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  
public class TestMyBatis 
{
	private static Logger logger = Logger.getLogger(TestMyBatis.class);  
	  private ApplicationContext ac = null;  
	@Resource  
	private IUserService userService = null;  
	private SqlSessionFactory sqlSessionFactory=null;

	  @Before  
	  public void before() {  
		      ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
		      userService = (IUserService) ac.getBean("userService");  
		      sqlSessionFactory=(SqlSessionFactory) ac.getBean("sqlSessionFactory");
		     
	  }  

	@Test  
	public void test1() { 
		SqlSession session=sqlSessionFactory.openSession();
		try{
			System.out.println(userService.getClass().toString());
			User user=session.selectOne("com.cn.store.dao.IUserDao.UserMapper.selectByPrimaryKey",1);
			//User user = userService.getUserById(2);		
			
			 logger.info("值："+user.getUserName());  
			logger.info(JSON.toJSONString(user));  
		}finally{
			session.close();
		}	
	}  
}  

