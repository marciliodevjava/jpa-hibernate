package teste.basico;

import javax.swing.JOptionPane;

import infra.DAO;
import modelo.basico.Produto;

public class NovoProduto {

	public static void main(String[] args) {
		
		DAO<Produto> dao = new DAO<>(Produto.class);
		
		String nomeProduto = JOptionPane.showInputDialog("Digite o nome do produto:");
		String precoProduto = JOptionPane.showInputDialog("Digite o preço do produto:");
		double preco = Double.parseDouble(precoProduto);
		
		Produto produto = new Produto(nomeProduto, preco);
		dao.incluirAtomico(produto).fechar();
		
		JOptionPane.showMessageDialog(null, "ID: " + produto.getId());
	}
}
