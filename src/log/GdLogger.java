package log;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;


public class GdLogger {
	
	protected GdLogger() throws Exception{
		throw new Exception();
	}
	
	public static Logger getLogget(Class<?> aClass) {
		return getLog4jLogger(aClass);
	}
	
	private static Logger getLog4jLogger(Class<?> aClass) {
		Logger logger = null;
		
		logger = Logger.getLogger(aClass);
		logger.addAppender(getAppender(aClass.getName()));
		
		return logger;
	}
	
	private static RollingFileAppender getAppender(String className) {
		RollingFileAppender appender = null;
		
		try {
			//???
			appender = new RollingFileAppender(null, getPath(className));
			appender.setMaxFileSize("5MB");
			appender.setMaxBackupIndex(5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return appender;
	}
	
	private static String getPath(String className) {
		StringBuffer path = new StringBuffer();
		
		path.append("logs");
		checkPathExists(path);
		path.append("/"+className);
		
		DateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
		path.append(dformat.format(new Date())+".log");
		
		return path.toString();
	}

	private static void checkPathExists(StringBuffer path) {
		String thePath = path.toString();
		File file = new File(thePath);
		if(!file.exists()) {
			file.mkdir();
		}
	}

}
