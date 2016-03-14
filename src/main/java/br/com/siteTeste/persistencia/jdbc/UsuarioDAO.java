package br.com.siteTeste.persistencia.jdbc;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.siteTeste.persistrencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection(); //chama a conex�o com o banco.

	//Metodo para criar um novo cadastro de usu�rio.
	public void cadastrar(Usuario usu) {
		String sql = "insert into usuario (nome,login,senha) values (?,?,?)";

		try {
			// Criando um Statement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());// subistitui o ? pelo dado
													// do usuario.
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			// Executando o SQL
			preparador.execute();
			// Fechando o Objeto.
			preparador.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	//Metodo para alterar um cadastro existem de usu�rio.
	public void alterar(Usuario usu) {
		String sql = "update usuario set nome=? , login=? , senha=? where id=? ";

		try {
			// Criando um Statement
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setString(1, usu.getNome());// subistitui o ? pelo dado
													// do usuario.
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4, usu.getId());
			
			// Executando o SQL
			preparador.execute();
			// Fechando o Objeto.
			preparador.close();

		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}

	//Metodo para excluir um cadastro existente de usu�rio.
	public void excluir(Usuario usu) {
		//Criando Sql de exclus�o.
		String sql = "delete from usuario where id=? ";

		try {
			// Criando um Statement
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1, usu.getId());
			
			// Executando o SQL
			preparador.execute();
			
			// Fechando o Objeto.
			preparador.close();

		} catch (SQLException e) {
		    System.out.println("Erro ao excluir cadastro\nA Menssagem de retorno do erro �\n\n");
			e.printStackTrace();
		}
	}
	
	//Metodo de altera��o de cadastro de usuario.
	public void salvar(Usuario usuario){
		if(usuario.getId()!=null){
			alterar(usuario); //usuario antigo apenas alterar
		}else{
			cadastrar(usuario); //usuario novo, chama o metodo cadastrar.
		}
	}
	
	/**
	 * Busca um registro no banco de dados pelo id do usu�rio.
	 * @param id � um inteiro que representa o numero do id do usu�rio a ser buscado
	 * @return Retorna um Objeto usu�rio,se ele encontrar o cadastro no banco, ele retornar� os valores, caso ele
	 *  n�o encontre, ele retornar� nulo.
	 */
	public Usuario buscadorPorId(Integer id){
		
		String sql = ("select * from usuario where id =?");
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){ //try catch vai fechar sozinho o objeto.
			//subistitui os parametros
			preparador.setInt(1, id);
			
			//Resultado com todos os registros, ResultSet recebe os dados temporarios da consulta do PrepareStatement.
			ResultSet resultadoDaConsulta = preparador.executeQuery();
			
			//Posicionando para consultar o cadastro no primeiro registro
			if(resultadoDaConsulta.next()){//Existe o primeiro registro?
				
				Usuario usuario = new Usuario();//Objeto com as variaveis
				
				//Objeto Usuario recebe os dados acumulados no ResultSet
				usuario.setId(resultadoDaConsulta.getInt("id"));
				usuario.setNome(resultadoDaConsulta.getString("nome"));
				usuario.setLogin(resultadoDaConsulta.getString("login"));
				usuario.setSenha(resultadoDaConsulta.getString("senha"));
			
				return usuario;
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;// se n�o achar a consulta, o objeto retorna nulo.
	}
	
	
	
	
	/*
	 * Realiza a busca de todos os registros da tabela de usu�rios
	 * @return Retorna uma lista de objetos Usuario contendo 0 elementos quando estiver com registros
	 */
	public ArrayList<Usuario> buscarTodosRegistroTbUsuario(){
		
		String sql = ("select * from usuario");
		ArrayList<Usuario> lista = new ArrayList<Usuario>();//Array para todos os uru�rios.
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){ //try catch vai fechar sozinho o objeto.
			
			//Resultado com todos os registros, ResultSet recebe os dados temporarios da consulta do PrepareStatement.
			ResultSet resultadoDaConsulta = preparador.executeQuery();
			
			//Posicionando para consultar o cadastro no primeiro registro
			while(resultadoDaConsulta.next()){//Existe o primeiro registro?
				
				Usuario usuario = new Usuario();//Objeto com as variaveis
				
				//Objeto Usuario recebe os dados acumulados no ResultSet
				usuario.setId(resultadoDaConsulta.getInt("id"));
				usuario.setNome(resultadoDaConsulta.getString("nome"));
				usuario.setLogin(resultadoDaConsulta.getString("login"));
				usuario.setSenha(resultadoDaConsulta.getString("senha"));
				
				lista.add(usuario);//Adiciona o dado de uma linha de consulta a cada ciclo do while.
			
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return lista;// se n�o achar a consulta, o objeto retorna nulo.
	}
	
	
	
	
	
	public Usuario autenticarUsuarioSenha(Usuario UsuarioConsulta){
		
		//SQl compara se o login solicitado existe no banco ou n�o 
		String sql = "Select * from usuario where login=? and senha=?";
		
		try(PreparedStatement preparador = con.prepareStatement(sql)){
			preparador.setString(1, UsuarioConsulta.getLogin());
			preparador.setString(2, UsuarioConsulta.getSenha());			
			//resultado recebe todos os dados de retorno de "ExecuteQuery"
			ResultSet resultado = preparador.executeQuery(); 
			
			if(resultado.next()){
				Usuario usuario = new Usuario();//Objeto com todas as vari�veis.
				usuario.setId(resultado.getInt("id"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setSenha(resultado.getString("senha"));
				
				return usuario;
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
	
	
	
	
	
	

}
