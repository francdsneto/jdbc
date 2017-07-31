package br.com.caelum.jdbc.teste;

import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaRemove {

	public static void main(String[] args) throws ClassNotFoundException {
	
		ContatoDao contatoDao = new ContatoDao();
		
		List<Contato> contatos = contatoDao.getLista();
		
		System.out.println(contatos.size());
		
		for(Contato contato : contatos)
			contatoDao.remove(contato);
		
		contatos = contatoDao.getLista();
		
		System.out.println(contatos.size());
		
	}

}
