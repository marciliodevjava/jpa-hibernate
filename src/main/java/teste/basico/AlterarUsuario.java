package teste.basico;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emt = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emt.createEntityManager();
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o ID: ");
		long idUduario = entrada.nextLong();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, idUduario);
		System.out.println("Nome: " + usuario.getNome() + " E-mail: " + usuario.getEmail());
		
		System.out.println("Digite o nome novo: ");
		String novoNome = entrada.next();
		usuario.setNome(novoNome);
		
		System.out.println("Digite o novo e-mail: ");
		String novoEmail = entrada.next();
		usuario.setEmail(novoEmail);
		
		em.merge(usuario);
		em.getTransaction().commit();
		
		entrada.close();
		em.close();
		emt.close();
	}
}
