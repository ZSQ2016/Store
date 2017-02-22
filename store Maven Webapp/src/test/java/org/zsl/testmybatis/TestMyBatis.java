package org.zsl.testmybatis;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.cn.store.pojo.User;
import com.cn.store.service.IUserService;

public class TestMyBatis 
{
	private static Logger logger = Logger.getLogger(TestMyBatis.class);  
	//  private ApplicationContext ac = null;  
	@Resource  
	private IUserService userService = null;  

	//  @Before  
	//  public void before() {  
	//	      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
	//	      userService = (IUserService) ac.getBean("userService");  
	//  }  

	@Test  
	public void test1() {  
		User user = userService.getUserById(1);  
		// System.out.println(user.getUserName());  
		// logger.info("值："+user.getUserName());  
		logger.info(JSON.toJSONString(user));  
	}  
}  

