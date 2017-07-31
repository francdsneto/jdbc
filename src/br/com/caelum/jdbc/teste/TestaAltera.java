package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaAltera {

	public static void main(String[] args) throws ClassNotFoundException {
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		ContatoDao contatoDao = new ContatoDao();
		
		Contato contato = contatoDao.getById(1l);
		
		System.out.println("Id: " + contato.getId());
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endereço: " + contato.getEndereco());		
		System.out.println("Data de Nascimento: " + 
				dateFormat.format(contato.getDataNascimento().getTime()) + "\n");
		
		contato.setNome("Francisco Neto");
		
		contatoDao.altera(contato);
		
		contato = contatoDao.getById(1l);
		
		System.out.println("Id: " + contato.getId());
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endereço: " + contato.getEndereco());
		System.out.println("Data de Nascimento: " + 
				dateFormat.format(contato.getDataNascimento().getTime()) + "\n");

	}

}
