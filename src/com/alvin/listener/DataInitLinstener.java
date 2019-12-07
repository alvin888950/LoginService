package com.alvin.listener;

import java.io.File;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.alvin.common.Config_Xml;

/**
 * @Title : DataInitLinstener.java
 * @Company : 永硕
 * @Package : com.alvin.listener
 * @Description : TODO(数据初始化监听)
 * @author : fxd
 * @date : 2019-8-22 上午11:13:38
 * @version : 版本 3.0
 */
public class DataInitLinstener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			System.out.println("初始化数据");
			String configPath = arg0.getServletContext().getRealPath("").toString();
			if (configPath.substring(configPath.length()-1,configPath.length()).equals(File.separator)) {
				configPath=configPath.substring(0,configPath.length()-1);
			}
			configPath += File.separator+"WEB-INF"+File.separator+"classes"+File.separator;
			Config_Xml.PRIVATE_KEY=configPath+"private.key";
			Config_Xml.PUBLIC_KEY=configPath+"public.key";
			new Config_Xml().init(configPath+"config/");

			System.out.println("初始化数据完毕");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
