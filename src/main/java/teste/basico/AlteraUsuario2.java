package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.basico.Usuario;

public class AlteraUsuario2 {

	public static void main(String[] args) {

		EntityManagerFactory emt = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emt.createEntityManager();

		em.getTransaction().begin();
		String id = JOptionPane.showInputDialog("Digite o id do usuario: ");
		long idAlterar = Long.parseLong(id);
		Usuario usuario = em.find(Usuario.class, idAlterar);
		JOptionPane.showMessageDialog(null, "Nome: " + usuario.getNome() + "\nE-mail: " + usuario.getEmail());
		String nome = JOptionPane.showInputDialog("Nome: " + usuario.getNome() + "\nDigite o novo nome:");
		usuario.setNome(nome);
		String email = JOptionPane.showInputDialog("E-mail: " + usuario.getEmail() + "\nDigite o novo e-mail:");
		usuario.setEmail(email);

		JOptionPane.showMessageDialog(null, "Dados atualizados \nNome: " + usuario.getNome() + "\nE-mail: " + usuario.getEmail());
		em.merge(usuario);
		em.getTransaction().commit();

		em.close();
		emt.close();
	}
}
