package logger.abstracao;

import logger.interfaces.LogPrinter;

public abstract class Logger {

	
	protected abstract LogPrinter createLog();
	 
	public void log(String log) {
		 createLog().print(log);;
	}
	
	public void error(String log) {
		 createLog().printError(log);
	}
}
 