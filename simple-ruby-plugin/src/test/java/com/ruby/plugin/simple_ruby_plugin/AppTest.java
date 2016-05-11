package com.ruby.plugin.simple_ruby_plugin;

import java.io.IOException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{

	public void testApp() throws IOException
	{
		App app = new App();
		app.doSomething();
	}
}
