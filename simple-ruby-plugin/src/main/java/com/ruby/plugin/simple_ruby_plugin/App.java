package com.ruby.plugin.simple_ruby_plugin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;
import org.jruby.Ruby;
import org.jruby.RubyInstanceConfig;
import org.jruby.RubyRuntimeAdapter;
import org.jruby.javasupport.JavaEmbedUtils;
import org.jruby.runtime.builtin.IRubyObject;

import com.ruby.plugin.interfaces.RubyInterface;

/**
 * Hello world!
 *
 */
public class App 
{
	private Ruby ruby;
	private RubyRuntimeAdapter adapter;
	
	public App()
	{
		RubyInstanceConfig config = new RubyInstanceConfig();
		config.addLoader(App.class.getClassLoader());
		this.ruby = Ruby.newInstance(config);
		this.adapter = JavaEmbedUtils.newRuntimeAdapter();
	}
	
	public void doSomething() throws IOException
	{
		InputStream file = App.class.getClassLoader().getResourceAsStream("ruby/RubyImpl.rb");
		@SuppressWarnings("deprecation")
		String code = IOUtils.toString(file, StandardCharsets.UTF_8);
		this.ruby.evalScriptlet(code);
		IRubyObject rubyClass = this.adapter.eval(this.ruby, "RubyImpl");
		RubyInterface rInterface = (RubyInterface) JavaEmbedUtils.invokeMethod(this.ruby, rubyClass, "new", 
				new Object[]{"fooBar"}, RubyInterface.class);
		rInterface.doSomething();
	}
}
