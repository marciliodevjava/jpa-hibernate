package teste.basico;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.basico.Usuario;

public class RemoverUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emt = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emt.createEntityManager();
		Scanner entrada = new Scanner(System.in);
		String idString = JOptionPane.showInputDialog("Digite o ID que deseja excluir: ");
		long id = Long.parseLong(idString);

		Usuario usuario = em.find(Usuario.class, id);

		String excluir = JOptionPane
				.showInputDialog("Deseja excluir usuario: " + usuario.getNome() + "\nDigite: \nS - Sim \nN - Não").toLowerCase();
		System.out.println(excluir);
		
		if (excluir.equals("s")) {
			JOptionPane.showMessageDialog(null, "Usuário: " + usuario.getNome() + "\nEXCLUIDO!!!");
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
			

		} else {
			JOptionPane.showMessageDialog(null,"Usuário: "+ usuario.getNome() +"\nNÃO excluido.", excluir, 0);
		}

		entrada.close();
		em.close();
		emt.close();
	}
}
