package com.cg.library.logger;




import java.io.IOException;

import org.apache.log4j.*;

public class MyLogger {
	
	static Logger logger;
	
	static
	{
		logger = Logger.getLogger(MyLogger.class);
		SimpleLayout layout = new SimpleLayout();
		try
		{
			FileAppender appender = new FileAppender(layout,"basic.log");
			logger.addAppender(appender);
			logger.setLevel(Level.DEBUG);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	public static Logger getLogger()
	{
		return logger;
	}
	

}
