import java.awt.JobAttributes;

import javax.swing.JOptionPane;

import com.br.maladireta.MalaDireta;
import com.br.maladireta.csv.MalaDiretaCSV;

public class RelacionamentoComCliente {

	public static void main(String[] args) {
		
		MalaDireta mala = new MalaDiretaCSV("contatos.csv");
		String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail");
		
		boolean status = mala.enviarEmail(mensagem);
		
		JOptionPane.showConfirmDialog(null, "E-mail enviado "+(status?"Sim":"Não"));
	}
}
