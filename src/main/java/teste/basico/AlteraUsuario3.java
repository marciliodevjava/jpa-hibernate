package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.basico.Usuario;

public class AlteraUsuario3 {

	public static void main(String[] args) {
		
		EntityManagerFactory emt = Persistence.createEntityManagerFactory("exercicios-jpa");
		EntityManager em = emt.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class, 7L);
		em.detach(usuario);
		usuario.setNome("Marcilio");
		em.detach(usuario);
		em.merge(usuario);
		
		em.getTransaction().commit();
		
		em.close();
		emt.close();
	}
}
