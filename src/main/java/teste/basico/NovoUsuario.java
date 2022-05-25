package teste.basico;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o nome:");
		String nome = entrada.next();
		System.out.println("Digite o e-mail:");
		String email = entrada.next();
		Usuario novoUsuario = new Usuario(nome, email);
		
		em.getTransaction().begin();
		em.persist(novoUsuario); // Inserir
		em.getTransaction().commit();
		
		System.out.println("ID GERADO: " + novoUsuario.getId());
		
		entrada.close();
		em.close();
		emf.close();
	}
}
