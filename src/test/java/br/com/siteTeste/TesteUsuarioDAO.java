package br.com.siteTeste;

import java.util.ArrayList;

import br.com.siteTeste.persistencia.jdbc.UsuarioDAO;
import br.com.siteTeste.persistrencia.entidade.Usuario;

public class TesteUsuarioDAO {

	public static void main(String[] args){
		
		  testeAutenticarUsuarioSenha();
		//testBuscarTodos();
		//testBuscarPorId();
		//testSalvar();
		//testExcluir();
		//testAlterar();
		//testCadastrar();
	
	}
	
	
	
	
	/*
	 * @verifica se o usuario e senha existe.
	 */
	private static void testeAutenticarUsuarioSenha() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuarioDaConsulta = new Usuario();
		usuarioDaConsulta.setLogin("wesker");
		usuarioDaConsulta.setSenha("wesker123");
		
		Usuario usuRetorno = usuarioDAO.autenticarUsuarioSenha(usuarioDaConsulta);
		
		System.out.println(usuRetorno);
	}





	/*
	 * @Busca todos os usuarios cadastrados na tabela Usuarios 
	 */
	private static void testBuscarTodos() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();		
		ArrayList<Usuario> listaDeCadastrosDeUsuario = usuarioDAO.buscarTodosRegistroTbUsuario();
	
		for (Usuario cadastros : listaDeCadastrosDeUsuario){
			System.out.println(cadastros);//Imprime o resultado dos cadastros que estavam no banco.
		}
		
	}

	
	
	
	
	/*
	 * @Busca usuarios por id, ou seja apresenta os valores das colunas
	 * baseado no id informado em buscadorPorId(?)
	 * 
	 */
	private static void testBuscarPorId() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		Usuario usuario = usuarioDAO.buscadorPorId(1);
	
		System.out.println(usuario);
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
