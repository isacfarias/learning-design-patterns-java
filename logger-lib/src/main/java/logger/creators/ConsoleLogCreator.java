package logger.creators;

import logger.abstracao.Logger;
import logger.console.ConsoleLogPrinter;
import logger.interfaces.LogPrinter;

public class ConsoleLogCreator extends Logger {

	@Override
	public LogPrinter createLog() {
		return new ConsoleLogPrinter();
	}

}
