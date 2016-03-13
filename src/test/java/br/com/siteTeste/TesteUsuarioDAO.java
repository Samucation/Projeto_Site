package br.com.siteTeste;

import br.com.siteTeste.persistencia.jdbc.UsuarioDAO;
import br.com.siteTeste.persistrencia.entidade.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args){
		
		testExcluir();
		//testAlterar();
		//testCadastrar();
	
	}
	
	
	public static void testCadastrar(){
		
	Usuario usu = new Usuario();
		
		//Criando o Usu�rio
		usu.setNome("wqwqwqao");
		usu.setLogin("Zezao");
		usu.setSenha("123");
		
		//Cadastrando usu�rio no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadastrado com sucesso!");
	}
	
	
	
	public static void testAlterar(){

		Usuario usu = new Usuario();
			
			//Criando o Usu�rio
		    usu.setId(4);
			usu.setNome("eee12321333");
			usu.setLogin("eeeZezao21312");
			usu.setSenha("eee12321321");
			
			//Cadastrando usu�rio no banco de dados
			UsuarioDAO usuDAO = new UsuarioDAO();
			
			usuDAO.alterar(usu);
			
			System.out.println("Alterado com sucesso!");
		
	}
	
	public static void testExcluir(){

			Usuario usu = new Usuario();	
			//Criando o Usu�rio
		    usu.setId(4);
			
			//Cadastrando usu�rio no banco de dados
			UsuarioDAO usuDAO = new UsuarioDAO();
			
			usuDAO.excluir(usu);
			
			System.out.println("Excluido com sucesso!");
		
	}
		
	
	
}
