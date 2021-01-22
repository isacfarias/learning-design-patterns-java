package logger.console;

import java.text.SimpleDateFormat;
import java.util.Date;

import logger.interfaces.LogPrinter;

public class ConsoleLogPrinter implements LogPrinter {
	
	public void print(String log) {
		System.out.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) +"- INFO - "+log);
	}
	
	public void printError(String log) {
		System.err.println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()) +"- ERROR - "+log);
	}

}
