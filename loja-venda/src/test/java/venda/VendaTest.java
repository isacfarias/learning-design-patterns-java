package venda;

import org.junit.Before;
import org.junit.Test;

import com.br.farias.impl.LojaFactory;
import com.br.farias.model.NotaFiscal;
import com.br.farias.venda.Venda;
import com.br.farias.venda.builder.VendaToNotaFiscalBuilder;

public class VendaTest {

	private Venda venda;
	
	@Before
	public void setUp() throws Exception {
		venda = new Venda(new LojaFactory());
	}

	@Test
	public void test() {
		NotaFiscal nf = new VendaToNotaFiscalBuilder()
				.cliente("Joaquim Pasteleiro")
				.addItem("Trigo", 1, "23")
				.addItem("Oleo soja", 2, "55")
				.builder();
		
		venda.finalizarVenda(nf);
	}

}
