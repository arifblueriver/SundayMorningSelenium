package com.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectMap {

	public String getconfig(String object) throws IOException {
		String file = "./Config.properties";// location
		FileInputStream fis = new FileInputStream(file);// serilization

		Properties propeties = new Properties();// to read notepad

		propeties.load(fis);// properties & serilization connect together
		propeties.getProperty(object);		
		
		return propeties.getProperty(object);

	}

	
}
