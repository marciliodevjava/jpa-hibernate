package teste.basico;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import modelo.basico.Usuario;
/*
 * Consultar varios os usuarios 
 */
public class ObterUsuarios {

	public static void main(String[] args) {
		
		EntityManagerFactory emt = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emt.createEntityManager();
		Scanner entrada = new Scanner(System.in);
		
		String jpql = "SELECT u FROM Usuario u";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		System.out.println("Quantos usuario deseja buscar?");
		int quantidadeUsuario = entrada.nextInt();
		query.setMaxResults(quantidadeUsuario);
		
//		List<Usuario> usuarios = em.createQuery("SELECT U FROM USUARIOS", Usuario.class)
//				.setMaxResults(5).getResultList();
		
		List<Usuario> usuarios = query.getResultList();
		
		for(Usuario usuario: usuarios) {
			System.out.println("ID: " + usuario.getId() + " Nome: " + usuario.getNome()
			+ " E-mail:" + usuario.getEmail());
		}
		
		entrada.close();
		em.close();
		emt.close();
	}
}
