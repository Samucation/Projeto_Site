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
	
	//Envia dados do id que ser� excluido.
	public static void testExcluir(){

			Usuario usu = new Usuario();	
			//Escolhendo qual Usu�rio ser� excluido.
		    usu.setId(4);
			
			//Chamando classe UsuarioDAO que cont�m o metodo de exclus�o.
			UsuarioDAO usuDAO = new UsuarioDAO();
			
			//Enviando os dados para a classe UsuarioDao no metodo de exclus�o.
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
