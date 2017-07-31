package br.com.caelum.jdbc.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TesteLista {

	public static void main(String[] args) throws ClassNotFoundException {

		ContatoDao contatoDao = new ContatoDao();

		List<Contato> contatos = contatoDao.getLista();

		for (Contato contato : contatos) 
		{
			System.out.println("Id: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data de Nascimento: " + 
					dateFormat.format(contato.getDataNascimento().getTime()) + "\n");
		}

	}

}
