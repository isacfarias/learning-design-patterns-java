package calc;

import logger.abstracao.Logger;
import logger.creators.ConsoleLogCreator;

public class CalculaImposto {

	private Logger logger; 
	
	public CalculaImposto(Logger logger) {
		this.logger = logger;
	}
	
	 public void calcular(double valor) {
		 try {
			 
			 logger.log("valor R$ "+valor+" reais terá R$ "+(Math.round(valor*0.08))+" reais de imposto cobrado");
		 } catch (Exception e) {
			 logger.error(e.getMessage());;
		}
		 
	 }	
	 
	 
	 public void calcularGerarErro(double valor) {
		 try {
			 if( valor > 0) throw new Exception("essa message vai de erro");
		 } catch (Exception e) {
			 logger.error(e.getMessage());;
		}
		 
	 }	

	public static void main(String[] args) {
		
		CalculaImposto calc = new  CalculaImposto(new ConsoleLogCreator()) ;
		calc.calcular(23);
		calc.calcularGerarErro(1);

	}

}
