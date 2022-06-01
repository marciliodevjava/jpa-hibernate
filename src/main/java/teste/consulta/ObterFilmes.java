package teste.consulta;

import java.util.List;

import infra.DAO;
import modelo.muitopramuitos.Ator;
import modelo.muitopramuitos.Filme;

public class ObterFilmes {

	public static void main(String[] args) {

		DAO<Filme> dao = new DAO<>(Filme.class);
		List<Filme> filmes = dao.consultar("obterFilmesComNotaMaiorQue", "nota", 8.6);

		for (Filme filme : filmes) {
			System.out.println("Filme: " + filme.getNome() + "\nNota: " + filme.getNota() + "\n");
			for (Ator ator : filme.getAtores()) {
				System.out.println("Atores: " + ator.getNome());
			}
		}
	}
}
