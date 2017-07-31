package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class PesquisarTeste {

	public static void main(String[] args) throws ClassNotFoundException {
		
		ContatoDao contatoDao = new ContatoDao();
		
		Contato contato = contatoDao.getById(1l);

		System.out.println("Id: " + contato.getId());
		System.out.println("Nome: " + contato.getNome());
		System.out.println("Email: " + contato.getEmail());
		System.out.println("Endereço: " + contato.getEndereco());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data de Nascimento: " + 
				dateFormat.format(contato.getDataNascimento().getTime()) + "\n");
		
	}

}
