package com.loylty.camel;

public class CamelConstants {
	
	/* Camel components */
	public final static String FILE ="file:";
	public static final String ACTIVE_MQ = "activemq:";
	public static final String KAFKA = "kafka:";
	public final static String TIMER = "timer:";
	public final static String DIRECT = "direct:";
	public final static String LOG = "log:";
	public static final String RABBIT_MQ = "rabbitmq:";
	
	/* file related */
	public final static String CSV_FILE_PATH = "C:\\Users\\Aryak\\OneDrive\\Desktop\\Camel\\csv";
	public final static String FILE_DIR = "C:\\Users\\Aryak\\OneDrive\\Desktop\\Camel\\files?";
	public final static String APPEND = "&fileExist=append";

	/*Timer related*/
	public final static String TIMER_PERIOD = "?period=";
	
		
}
