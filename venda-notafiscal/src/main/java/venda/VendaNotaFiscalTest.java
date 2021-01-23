package venda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.farias.core.builder.NotaFicalBuilder;
import br.com.farias.core.enums.PessoaTipo;
import br.com.farias.model.NotaFiscal;

public class VendaNotaFiscalTest {

	@Test
	public void retornaNotaFicalComImpostoCalculadoPessoaFisica() throws Exception {
		NotaFiscal notaFiscal = new NotaFicalBuilder()
				.cliente("João", PessoaTipo.PF)
				.emissao("23/01/2021")
				.addItem("carvão", 2, "7.5")
				.builder();
		
		assertEquals(notaFiscal.getImposto().doubleValue(), 1.05, 0.0001);
	}
	
	
	@Test
	public void retornaNotaFicalComImpostoCalculadoPessoaJuridica() throws Exception {
		NotaFiscal notaFiscal = new NotaFicalBuilder()
				.cliente("Alface Hortaliças - ME", PessoaTipo.PJ)
				.emissao("23/01/2021")
				.addItem("carvão", 2, "7.5")
				.builder();
		
		assertEquals(notaFiscal.getImposto().doubleValue(), 0.6, 0.0001);	}

}
