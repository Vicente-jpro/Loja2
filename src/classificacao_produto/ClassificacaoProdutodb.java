package classificacao_produto;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClassificacaoProdutodb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private final ArrayList listaDeClassificacoes;

    public ClassificacaoProdutodb() {

        conn = ConnectionJDBC.getConnection();
        this.listaDeClassificacoes = new ArrayList<ClassificacaoProduto>();
    }

    protected void create(ClassificacaoProduto classificao) {

        String sql = "INSERT INTO Classificacao_produto_tb ( classe_produto ) VALUES ( ? )";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, classificao.getClasseProduto());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Classe salva com sucesso\n",
                    "CADASTRO DE CLASSE", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel salvar a Classe do Produto\n" ,
                    "CADASTRO DE CLASSE DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected void update(String novaClassificacao, String antigaClassificacao) {

        String sql = "UPDATE Classificacao_produto_tb "
                + " SET classe_produto = ? WHERE  classe_produto = '" + antigaClassificacao + "'";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, novaClassificacao);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Classe salva com sucesso\n",
                    "CADASTRO DE CLASSE DE PRODUTOS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel salvar a Classe do Produto\n" + ex,
                    "CADASTRO DE CLASSE DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected void delete(String nomeDaClasseficacaoDoProduto) {

        String sql = "DELETE FROM Classificacao_produto_tb "
                + " WHERE classe_produto = ?";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nomeDaClasseficacaoDoProduto);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Classe eliminada com sucesso\n",
                    "CADASTRO DE CLASSE DE PRODUTOS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar a Classe do Produto\n" + ex,
                    "CADASTRO DE CLASSE DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    
    
    
        public ArrayList<ClassificacaoProduto> read() {

        String sql = "SELECT classe_produto "
                + " FROM Classificacao_produto_tb ";
       

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                ClassificacaoProduto produto =
                        new ClassificacaoProduto( rs.getString("classe_produto") );
                listaDeClassificacoes.add( produto );

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa da Classe do Produto\n",
                    "CADASTRO DE CLASSE DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return listaDeClassificacoes;
    }
    
    

    protected boolean contem(Object nomeDaClasseDoProduto) {

        boolean existe = false;

        String novoNomeDaClasse = null;

        String sql = "SELECT classe_produto "
                + " FROM Classificacao_produto_tb "
                + " WHERE classe_produto = '" + nomeDaClasseDoProduto + "'";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();

            novoNomeDaClasse = rs.getString("classe_produto");

            if (novoNomeDaClasse.equals(nomeDaClasseDoProduto)) {
                existe = true;
            }

        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa da Classe do Produto\n",
//                    "CADASTRO DE CLASSE DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return existe;
    }

//    
//    SELECT id_classificacao, classe_produto
//	FROM public.classificacao_produto_tb;
    public int getIdClassificacaoProduto(String nomeClasseProduto) {

        String sql = "SELECT id_classificacao "
                + " FROM Classificacao_produto_tb"
                + " WHERE  classe_produto = '" + nomeClasseProduto + "'";

        int idClassificacao = 0;

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            rs.next();
            
            idClassificacao = rs.getInt( "id_classificacao" );

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do ID da Classe do Produto\n",
                    "PESQUISA DE CLASSE DE PRODUTOS", JOptionPane.ERROR_MESSAGE);
        } finally {

        }

        return idClassificacao;

    }

}
