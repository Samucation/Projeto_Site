package br.com.siteTeste.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.siteTeste.persistrencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();

	//Metodo para criar um novo cadastro de usuário.
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

	//Metodo para alterar um cadastro existem de usuário.
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

	//Metodo para excluir um cadastro existente de usuário.
	public void excluir(Usuario usu) {
		//Criando Sql de exclusão.
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
		    System.out.println("Erro ao excluir cadastro\nA Menssagem de retorno do erro é\n\n");
			e.printStackTrace();
		}
	}
	
	//Metodo de alteração de cadastro de usuario.
	public void salvar(Usuario usuario){
		if(usuario.getId()!=null){
			alterar(usuario); //usuario antigo apenas alterar
		}else{
			cadastrar(usuario); //usuario novo, chama o metodo cadastrar.
		}
	}
	
	/**
	 * Busca um registro no banco de dados pelo id do usuário.
	 * @param id é um inteiro que representa o numero do id do usuário a ser buscado
	 * @return Um Objeto usuário quando encontra ou nulo quando não encontra.
	 */
	public Usuario buscadorPorId(Integer id){
		
		String sql = ("select * from usuario where id =?");
		
		try (PreparedStatement preparador = con.prepareStatement(sql)){ //try tatch vai fechar sozinho o objeto.
			//subistitui os parametros
			preparador.setInt(1, id);
			
			//Resultado com todos os registros
			ResultSet resultadoDaConsulta = preparador.executeQuery();
			
			//Posicionando para consultar o cadastro no primeiro registro
			if(resultadoDaConsulta.next()){
				Usuario usuario = new Usuario();
				usuario.setId(resultadoDaConsulta.getInt("id"));
				usuario.setNome(resultadoDaConsulta.getString("nome"));
				usuario.setSenha(resultadoDaConsulta.getString("senha"));
			
				return usuario;
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;// se nao achar consulta objeto retorna nulo.
	}

}
