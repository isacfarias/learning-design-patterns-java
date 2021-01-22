package logger.console;

import java.text.SimpleDateFormat;
import java.util.Date;

import logger.interfaces.LogPrinter;

public class ConsoleLogPrinter implements LogPrinter {
	
	public void print(String log) {
		
		SimpleDateFormat formt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		System.out.println(formt.format(new Date()) +"- INFO - "+log);
	}
	
	public void printError(String log) {
		SimpleDateFormat formt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.err.print(formt.format(new Date()) +"- ERROR - "+log);
	}

}
