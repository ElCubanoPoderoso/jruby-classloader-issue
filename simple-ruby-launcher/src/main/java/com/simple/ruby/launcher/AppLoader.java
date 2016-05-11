package com.simple.ruby.launcher;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Hello world!
 *
 */
public class AppLoader 
{
	public void doSomething() throws Exception
	{
		URLClassLoader urlClassLoader = null;
		try
		{
			URL[] urlArray = new URL[]{this.getClass().getClassLoader().getResource("jars/simple-ruby-plugin-0.0.1-SNAPSHOT.jar")};
			urlClassLoader = new URLClassLoader(urlArray);
			Class <?> clazz = urlClassLoader.loadClass("com.ruby.plugin.simple_ruby_plugin.App");
			Object randomObject = clazz.newInstance();
			Method method = clazz.getMethod("doSomething");
			Object obj = method.invoke(randomObject);			
		}
		finally
		{
			if (urlClassLoader != null)
				urlClassLoader.close();
		}
	}
}
