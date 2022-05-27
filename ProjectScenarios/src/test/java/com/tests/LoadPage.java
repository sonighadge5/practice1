package com.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.page.AmazonPageLoad;

public class LoadPage extends AmazonPageLoad{
  @BeforeSuite
   public void setUp()
   {
	  //initalization();
	  reportsinit();
   }
	@Test
	public void test01()
	{
		Assert.assertTrue(true);
	}
	
	@Test 
	public void test02()
	{
		Assert.assertTrue(false);
	}
	
	@Test
	public void test03()
	{
		throw new SkipException ("test is skipped");
			
		
	}
}
