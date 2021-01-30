package repository.impls;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import model.Pedido;
import repository.PedidoFonte;

public class PedidosXML implements PedidoFonte {
	
	private List<Pedido> pedidos;
	
	@SuppressWarnings("unchecked")
	public PedidosXML(String... arquivos) {
		pedidos = new ArrayList<>();
		XStream xstream = new XStream();
	    xstream.alias("pedidos", List.class);
	    xstream.alias("pedido", Pedido.class);
	    
	    for (String arquivo : arquivos) {
	    	System.out.println("Carregando arquivo: " + arquivo);
	    	List<Pedido> temp =  (List<Pedido>) xstream.fromXML(this.getClass().getResource("/" + arquivo));
	    	pedidos.addAll(temp);
	    }
		
	}

	@Override
	public List<Pedido> pedidos() {
		return this.pedidos;
	}

}
