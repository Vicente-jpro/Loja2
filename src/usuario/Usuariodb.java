package usuario;

import usuario.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;
import funcao.Funcao;
import funcao.Funcaodb;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;
import previlegio.Previlegio;
import previlegio.Previlegiodb;
import usuario.Usuario;

public class Usuariodb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private final ArrayList listaDeClassificacoes;
    private Usuario usuario;

    public Usuariodb() {

        conn = ConnectionJDBC.getConnection();
        this.listaDeClassificacoes = new ArrayList<Usuario>();
    }

    //id_usuario, nome_usuario, morada, telemovel1, telemovel2, password
    protected void create(Usuario usuario) {

        String sql = "INSERT INTO "
                + " usuario_tb ( nome_usuario, morada, telemovel1, telemovel2, "
                + " password, funcao_id, previlegio_id ) "
                + " VALUES ( ?, ?, ?, ?, ?, ?, ? )";
        String password = DigestUtils.shaHex(usuario.getPassword());

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getTelemovel1());
            stmt.setString(4, usuario.getTelemovel2());
            stmt.setString(5, password);
            stmt.setInt(6, usuario.getFuncao().getId_funcao());
            stmt.setInt(7, usuario.getPrevilegio().getId_previlegio());

            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "++++++ Usuario salvo com sucesso++++++\n"
//                    + "Nome: " + usuario.getNome() + "\n"
//                    + "Morada: " + usuario.getEndereco() + "\n"
//                    + "Telemovel 1: " + usuario.getTelemovel1() + "\n"
//                    + "Telemovel 2: " + usuario.getTelemovel2() + "\n"
//                    + "Palavra Passe:" + usuario.getPassword() + "\n",
//                    "CADASTRO DE FUNCIONÁRIOS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o Usuario \n" + ex,
                    "CADASTRO DE FUNCIONÁRIOS ", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected void update(Usuario usuario, String opcao) {

        int idUsuario = usuario.getIdUsuario();
        String sql = "",
                password = DigestUtils.shaHex(usuario.getPassword());
        switch (opcao) {
            case "funcao": // Actualizar o usuario com a sua funcao

                sql = "UPDATE Usuario_tb "
                        + " SET nome_usuario = ?, morada = ?, telemovel1 =  ?, "
                        + " telemovel2 = ?, password = ?, funcao_id = ?"
                        + " WHERE  id_usuario = '" + idUsuario + "'";
                break;
            case "privilegio": // Actualizar o usuario com o seu privilegio

                sql = "UPDATE Usuario_tb "
                        + " SET nome_usuario = ?, morada = ?, telemovel1 =  ?, "
                        + " telemovel2 = ?, password = ?, previlegio_id = ?"
                        + " WHERE  id_usuario = '" + idUsuario + "'";
                break;
            default: // Salva sem a funcao e o previlegio.

                sql = "UPDATE Usuario_tb "
                        + " SET nome_usuario = ?, morada = ?, telemovel1 =  ?, "
                        + " telemovel2 = ?, password = ?"
                        + " WHERE  id_usuario = '" + idUsuario + "'";
                break;

        }

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEndereco());
            stmt.setString(3, usuario.getTelemovel1());
            stmt.setString(4, usuario.getTelemovel2());
            stmt.setString(5, password);
            if (opcao.equalsIgnoreCase("funcao")) {
                stmt.setInt(6, usuario.getFuncao().getId_funcao());
            } else if (opcao.equalsIgnoreCase("privilegio")) {
                stmt.setInt(6, usuario.getPrevilegio().getId_previlegio());
            }

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario actualizado com sucesso\n",
                    "ACTUALIZAÇÃO DE FUNCIONÁRIOS ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o usuario \n" + ex,
                    "ACTUALIZAÇÃO DE FUNCIONÁRIOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected void delete(int idUsuario) {

        String sql = "DELETE FROM Usuario_tb "
                + " WHERE id_usuario = " + idUsuario;

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario eliminado com sucesso\n",
                    "ELIMINAR FUNCIONÁRIOS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o usuario\n" + ex,
                    "ELIMINAR FUNCIONÁRIOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected ArrayList<Usuario> read() {

        String sql = "SELECT  id_usuario, nome_usuario, morada, telemovel1, telemovel2,\n"
                + "		funcao_tb.descricao AS funcao, \n"
                + "		previlegio_tb.descricao AS previlegio\n"
                + "     FROM Usuario_tb \n"
                + "	 INNER JOIN funcao_tb\n"
                + "	 ON Usuario_tb.funcao_id = funcao_tb.id_funcao\n"
                + "	 INNER JOIN previlegio_tb\n"
                + "	 ON Usuario_tb.previlegio_id = previlegio_tb.id_previlegio\n"
                + "	 ORDER BY id_usuario";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                usuario = new Usuario();

                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setEndereco(rs.getString("morada"));
                usuario.setTelemovel1(rs.getString("telemovel1"));
                usuario.setTelemovel2(rs.getString("telemovel2"));

                usuario.setPrevilegio(new Previlegio(rs.getString("previlegio")));
                usuario.setFuncao(new Funcao(rs.getString("funcao")));

                listaDeClassificacoes.add(usuario);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura dos usuarios\n" + ex,
                    "LEITURA DOS FUNCIONÁRIOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return listaDeClassificacoes;
    }

    protected boolean contem(Usuario usuario) {

        boolean existe = false;

        String novoUsuario = null,
                nome_usuario = usuario.getNome(),
                password = DigestUtils.shaHex(usuario.getPassword());
      

        String sql = "SELECT nome_usuario"
                + " FROM Usuario_tb "
                + " WHERE nome_usuario = ? AND password = ?";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_usuario);
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            rs.next();

            novoUsuario = rs.getString("nome_usuario");

            if (novoUsuario.equals(nome_usuario)) {
                existe = true;
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do usuario\n " + novoUsuario + "\n" + ex,
                    "CADASTRO DE FUNCIONÁRIOS DE ", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return existe;
    }

    public int getIdUsuario(Usuario usuario) {

        String sql = "SELECT id_usuario "
                + " FROM usuario_tb"
                + " WHERE nome_usuario = ? AND password = ? ";

        String password = DigestUtils.shaHex(usuario.getPassword());

        int idUsuario = 0;

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            rs.next();

            idUsuario = rs.getInt("id_usuario");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Esse usuário não existe.\n O Nome ou a palavra passe não está correcta" + ex,
                    "PESQUISA DE FUNCIONÁRIOS ", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return idUsuario;

    }

    public boolean isAdministrador(Usuario usuario) {

        String sql = "SELECT  funcao_tb.descricao AS funcao\n"
                + "        FROM Usuario_tb \n"
                + "        INNER JOIN funcao_tb\n"
                + "        ON Usuario_tb.funcao_id = funcao_tb.id_funcao\n"
                + "		WHERE nome_usuario = ? AND password = ?"
                + "                     AND funcao_tb.descricao = 'Administrador'";

        boolean existe = false;
        String password = DigestUtils.shaHex(usuario.getPassword()),
                funcao = null;

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, password);

            rs = stmt.executeQuery();
            rs.next();

            funcao = rs.getString("funcao");

            if (funcao != null) {
                existe = true;
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Tu não és um Administrador.\n A palavra passe ou senha não está correcta " + usuario.getNome() + "\n",
                    "VALIDAÇÃO DO ADMINISTRADOR", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return existe;
    }

    public boolean isFuncionario(String nomeFuncionario) {

        String sql = "SELECT  funcao_tb.descricao AS funcao\n"
                + "        FROM Usuario_tb \n"
                + "        INNER JOIN funcao_tb\n"
                + "        ON Usuario_tb.funcao_id = funcao_tb.id_funcao\n"
                + "        INNER JOIN previlegio_tb\n"
                + "        ON Usuario_tb.previlegio_id = previlegio_tb.id_previlegio\n"
                + "		WHERE nome_usuario = ? AND funcao_tb.descricao = 'Funcionário'";

        boolean existe = false;
        String funcao = null;

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());

            rs = stmt.executeQuery();
            rs.next();

            funcao = rs.getString("funcao");

            if (funcao != null) {
                existe = true;
            }

        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do usuario\n " + usuario.getNome() + "\n" + ex,
//                    "VALIDAÇÃO DO FUNCIONÁRIOS DE ", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return existe;
    }

    public int verificaExistenciaUsuario(Usuario usuario) {

        String sql = "SELECT id_usuario "
                + " FROM usuario_tb"
                + " WHERE nome_usuario > 0 ";

        int idUsuario = 0;

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());

            rs = stmt.executeQuery();

            rs.next();

            idUsuario = rs.getInt("id_usuario");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ainda não existe um Adminstrador cadastrado\n" + ex,
                    "PESQUISA DE ADMINISTRADOR ", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return idUsuario;

    }

    public boolean isDesenvolvedor(Usuario usuario) {

        
        String sql = "SELECT  id_usuario\n"
                + "        FROM Usuario_tb \n"
                + "        INNER JOIN funcao_tb\n"
                + "        ON Usuario_tb.funcao_id = funcao_tb.id_funcao\n"
                + "		WHERE nome_usuario = ? AND password = ?"
                + "                     AND funcao_tb.descricao = 'Desenvolvedor'";
        
       

        String password = DigestUtils.shaHex(usuario.getPassword());

        int idUsuario = 0;

        boolean existe = false;
        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, password);

            rs = stmt.executeQuery();

            rs.next();

            idUsuario = rs.getInt("id_usuario");
            if (idUsuario != 0) {
                existe = true;
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Tu não és um Desenvolvedor\n"
                    + "A palavra passe ou senha não está correcta" ,
                    "DESENVOLVEDOR", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return existe;

    }

    public boolean verificaExistenciaUsuario() {

        String sql = "SELECT id_usuario "
                + " FROM usuario_tb"
                + " WHERE nome_usuario > 0 ";

        int idUsuario = 0;

        boolean existe = false;
        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());

            rs = stmt.executeQuery();

            rs.next();

            idUsuario = rs.getInt("id_usuario");
            if (idUsuario != 0) {
                existe = true;
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ainda não existe um Adminstrador cadastrado\n" + ex,
                    "PESQUISA DE FUNCIONÁRIOS ", JOptionPane.ERROR_MESSAGE);
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return existe;

    }
    
    
    
    
    private List<Usuario> getNumberItemTable() {

        String sql = "SELECT id_usuario FROM Usuario_tb ORDER BY nome_usuario ";

        List lista = new ArrayList<Usuario>();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            usuario = null;
            while (rs.next()) {

                usuario = new Usuario(rs.getInt("id_usuario"));

                lista.add(usuario);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do usuario\n"
                    + "O correu um erro ao ler todos os IDs",
                    "LEITURA DO IDs DOS USUARIOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return lista;

    }

    /**
     * @return Actualiza o número de ordem na lista de PRODUTO para ser
     * impresso.
     *
     * A contagem de número de ordem começa apartir de 1 até n.
     * @param usuario
     */
    protected void updateSequenceNumber() {

        String sql = "UPDATE public.usuario_tb "
                + "	SET contador = ? "
                + "	WHERE  id_usuario = ? ";

        List<Usuario> lista = getNumberItemTable();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(sql);

            int contador = 1;
            for (Usuario usuario : lista) {

                stmt.setInt(1, contador);
                stmt.setInt(2, usuario.getIdUsuario());
                contador++;

                stmt.executeUpdate();

            }
//
//            JOptionPane.showMessageDialog(null, "Usuario actualizado com sucesso\n",
//                    "ACTUALIZAÇÃO DE PRODUTO ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o número de sequência\n" ,
//                    "ACTUALIZAÇÃO DO NÚMERO DE SEQUÊNCIA", JOptionPane.ERROR_MESSAGE);
//            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    
    
    

}
