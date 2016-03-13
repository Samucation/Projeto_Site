package br.com.siteTeste.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.siteTeste.persistrencia.entidade.Usuario;

public class UsuarioDAO {

	private Connection con = ConexaoFactory.getConnection();

	public void cadastrar(Usuario usu) {
		// TODO Auto-generated method stub

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

	public void alterar(Usuario usu) {
		// TODO Auto-generated method stub

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

	public void excluir(Usuario usu) {
		// TODO Auto-generated method stub

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
		
			e.printStackTrace();
		}
	}

}
