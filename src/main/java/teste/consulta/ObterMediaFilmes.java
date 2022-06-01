package teste.consulta;

import infra.DAO;
import modelo.muitopramuitos.Filme;

public class ObterMediaFilmes {

	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>(Filme.class);
		
	}
}
