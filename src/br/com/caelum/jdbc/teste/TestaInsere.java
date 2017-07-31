package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) throws ClassNotFoundException {
	
		Contato contato = new Contato();
		contato.setNome("Neto");
		contato.setEmail("f.neto@outlook.com");
		contato.setEndereco("Endereço teste, 74, Fortaleza - Ceará");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao contatoDao = new ContatoDao();
		
		contatoDao.adiciona(contato);
		
		System.out.println("Contato Gravado!");
		
		
	}

}
