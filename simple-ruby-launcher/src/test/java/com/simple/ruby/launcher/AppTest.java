package com.simple.ruby.launcher;

import com.simple.ruby.launcher.AppLoader;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	public void testApp() throws Exception 
	{
		AppLoader app = new AppLoader();
		app.doSomething();
	}
	
	public void testAppAgain() throws Exception 
	{
		AppLoader app = new AppLoader();
		app.doSomething();
	}
}
