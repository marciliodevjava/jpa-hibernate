package modelo.muitopramuitos;

import infra.DAO;

public class NovoFilmeAtor {

	public static void main(String[] args) {
		
		Filme filmeA = new Filme("Star Wars Ep 4", 8.9);
		Filme filmeB = new Filme("O Fugitivo", 8.1);
		
		Ator atorA = new Ator("Harrinson Ford");
		Ator atrizB = new Ator("Carrie Fisher");
		
		filmeA.adicionrAtor(atorA);
		filmeA.adicionrAtor(atrizB);
		
		filmeB.adicionrAtor(atorA);
		
		DAO<Filme> dao = new DAO<Filme>();
		
		dao.incluirAtomico(filmeA);
	}
}
