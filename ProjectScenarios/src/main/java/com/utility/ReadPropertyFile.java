package com.utility;

import java.io.FileInputStream;
import java.util.Properties;

 public class ReadPropertyFile {
	static FileInputStream fis = null;
     static public String readPropertyFile(String key) {
    	  Properties prop = new Properties();
    	  try{
    		 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties"); 
    		 prop.load(fis);
    	  }
    	  catch (Exception e){
    		  System.out.println("");
    	  }
    	  return prop.getProperty(key);
      }
}
