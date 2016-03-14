package br.com.siteTeste;

import br.com.siteTeste.persistencia.jdbc.UsuarioDAO;
import br.com.siteTeste.persistrencia.entidade.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args){
		
		testBuscarPorId();
		//testSalvar();
		//testExcluir();
		//testAlterar();
		//testCadastrar();
	
	}
	
	
	private static void testBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = usuarioDAO.buscadorPorId(2);
	
		System.out.println();
	}


	public static void testCadastrar(){
		
	Usuario usu = new Usuario();
		
		//Criando o Usuário
		usu.setNome("wqwqwqao");
		usu.setLogin("Zezao");
		usu.setSenha("123");
		
		//Cadastrando usuário no banco de dados
		UsuarioDAO usuDAO = new UsuarioDAO();
		
		usuDAO.cadastrar(usu);
		
		System.out.println("Cadastrado com sucesso!");
	}
	
	
	
	public static void testAlterar(){

		Usuario usu = new Usuario();
			
			//Criando o Usuário
		    usu.setId(4);
			usu.setNome("eee12321333");
			usu.setLogin("eeeZezao21312");
			usu.setSenha("eee12321321");
			
			//Cadastrando usuário no banco de dados
			UsuarioDAO usuDAO = new UsuarioDAO();
			
			usuDAO.alterar(usu);
			
			System.out.println("Alterado com sucesso!");
		
	}
	
	//Envia dados do id que será excluido.
	public static void testExcluir(){

			Usuario usu = new Usuario();	
			//Escolhendo qual Usuário será excluido.
		    usu.setId(4);
			
			//Chamando classe UsuarioDAO que contém o metodo de exclusão.
			UsuarioDAO usuDAO = new UsuarioDAO();
			
			//Enviando os dados para a classe UsuarioDao no metodo de exclusão.
			usuDAO.excluir(usu);
			
			System.out.println("Excluido com sucesso!");
		
	}
	
	//Envia dados para que o usuario seja alterado 
	//ou cadastrado denovo, isso ira depender se o dado existe ou nao.
	public static void testSalvar(){
		Usuario usuario = new Usuario();
		//usuario.setId(1);
		usuario.setNome("Weskerx");
		usuario.setLogin("weskerx");
		usuario.setSenha("wesker123");
		
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usuario);
		
		System.out.println("Salvo com sucesso!");
		
	}
	
	
	
}
