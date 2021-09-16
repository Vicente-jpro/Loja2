package funcao;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Funcaodb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private final ArrayList listaDeClassificacoes;

    public Funcaodb() {

        conn = ConnectionJDBC.getConnection();
        this.listaDeClassificacoes = new ArrayList<Funcao>();
    }

    public ArrayList<Funcao> read() {

        String sql = "SELECT descricao\n"
                + "	FROM public.funcao_tb ORDER BY descricao";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

           
            while (rs.next()) {

                Funcao funcao
                        = new Funcao(rs.getString("descricao"));
                
              //  if ( !"Desenvolvedor".equalsIgnoreCase(funcao.getDescricao()) )
                    listaDeClassificacoes.add(funcao);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa das Funções\n",
                    "PESQUISA DAS FUNÇÕES", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return listaDeClassificacoes;
    }

//    
//    SELECT id_funcao, descricao
//	FROM public.classificacao_funcao_tb;
    public int getIdFuncao(String nomeFuncao) {

        String sql = "SELECT id_funcao "
                + " FROM funcao_tb"
                + " WHERE  descricao = '" + nomeFuncao + "'";

        int idClassificacao = 0;

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            rs.next();

            idClassificacao = rs.getInt("id_funcao");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do ID da Funcao\n" + ex,
                    "PESQUISA DA FUNÇÃO", JOptionPane.ERROR_MESSAGE);
        } finally {

        }

        return idClassificacao;

    }

}
