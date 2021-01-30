package repository.impls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.thoughtworks.xstream.XStream;

import model.Pedido;
import repository.PedidoFonte;

public class PedidosXML implements PedidoFonte {
	
	private List<Pedido> pedidos;
	private String arquivo;
	
	public PedidosXML() {
		pedidos = new ArrayList<>();
		Properties prop = new Properties();
		try {
			prop.load(this.getClass().getResourceAsStream("/config.properties"));
			this.arquivo = prop.getProperty("file");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void lerPedidos(String... arquivos) {
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
		lerPedidos(this.arquivo);
		return this.pedidos;
	}

}
