//teste
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

public class UsuarioDAO {

    public boolean inserirUsuario(Usuario usuario) {

        try {
            Connection conexao = Conexao.abreConexao();

            String queryInserir = "INSERT INTO usuario VALUES (null, ?, ?)";

            PreparedStatement pst = conexao.prepareStatement(queryInserir);
            pst.setString(1, usuario.getLogin());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getPerfil());

            pst.executeUpdate();

            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public boolean atualizarUsuario(Usuario usuario) {

        try {
                 Connection conexao = Conexao.abreConexao();

            String queryAtualizar = "UPDATE usuario SET nome = ?, idade = ? WHERE id = ?";

            PreparedStatement pst = conexao.prepareStatement(queryAtualizar);
            pst.setString(1, usuario.getLogin());
            pst.setString(2, usuario.getSenha());
            pst.setString(3, usuario.getEmail());
            pst.setString(4, usuario.getPerfil());

            pst.executeUpdate();

            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public boolean excluirUsuario(Usuario usuario) {

        try {
            Connection conexao = Conexao.abreConexao();

            String queryExcluir = "DELETE FROM usuario WHERE login = ?";

            PreparedStatement pst = conexao.prepareStatement(queryExcluir);

            pst.setString(1, usuario.getLogin());

            pst.executeUpdate();

            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();

            return false;
        }

        return true;
    }

    public ArrayList<Usuario> buscarTodosUsuarios() {

        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        Usuario usuario = null;

        try {
            Connection conexao = Conexao.abreConexao();

            String queryBuscar = "SELECT * FROM usuario";

            PreparedStatement pst = conexao.prepareStatement(queryBuscar);

            ResultSet rst = pst.executeQuery();

            while (rst.next()) {

                usuario = new Usuario();

                usuario.setLogin(rst.getString(1));
                usuario.setSenha(rst.getString(2));
                usuario.setEmail(rst.getString(3));
                usuario.setPerfil(rst.getString(4));

                lista.add(usuario);
            }

            conexao.close();

        } catch (SQLException e) {
    
            e.printStackTrace();

        }

        return lista;
    }

    public Usuario buscarUsuarioPorLogin(Usuario usuario    ) {                   
        
        try {
             Connection conexao = Conexao.abreConexao();

            String queryBuscar = "SELECT * FROM usuario WHERE login = ?";

            PreparedStatement pst = conexao.prepareStatement(queryBuscar);

            pst.setString(1, usuario.getLogin());

            ResultSet rst = pst.executeQuery();

            if (rst.next()) {

                usuario = new Usuario();

                usuario.setLogin(rst.getString(1));
                usuario.setSenha(rst.getString(2));
                usuario.setEmail(rst.getString(3));
                usuario.setPerfil(rst.getString(4));

            } else {

                return usuario; // retorna nulo
            }

            conexao.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return usuario;

    }


}
