package teste.umpramuitos;

import infra.DAO;
import modelo.basico.Produto;
import modelo.umpramuito.ItemPedido;
import modelo.umpramuito.Pedido;

public class NovoPedido {

	public static void main(String[] args) {
		
		DAO<Object> dao = new DAO<>();
		
		Produto produto = new Produto("Geladeira", 2789.99);
		Pedido pedido = new Pedido();
		ItemPedido item = new ItemPedido(pedido, produto, 10);
		
		dao.abrirT().incluirT(produto).incluirT(pedido).incluirT(item).fecharT().fechar();
		
	}
}
