import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import model.Pedido;
import repository.PedidoFonte;
import repository.impls.PedidosXML;

public class PedidoImportaTest {

	@Test
	public void retornaTrue_SeImportarPedidos() {
		
		PedidoFonte pedidos = new PedidosXML("pedidos.xml");
		List<Pedido> list = pedidos.pedidos();
		
		assertTrue("Pedido processado ", !list.isEmpty());
	}

}
