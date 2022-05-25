package teste.basico;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class ObterUsuario {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emf.createEntityManager();

		Scanner entrada = new Scanner(System.in);
		System.out.println("Digite o id do usuário que deseja buscar:");
		Long id = entrada.nextLong();

		Usuario usuario = em.find(Usuario.class, id); // Consultar
		System.out.println("Nome: " + usuario.getNome() + "\nE-mail: " + usuario.getEmail());

		entrada.close();
		em.close();
		emf.close();
	}
}
