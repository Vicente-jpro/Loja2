package previlegio;

import funcao.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Previlegiodb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private final ArrayList listaDeClassificacoes;

    public Previlegiodb() {

        conn = ConnectionJDBC.getConnection();
        this.listaDeClassificacoes = new ArrayList<Previlegio>();
    }

    public ArrayList<Previlegio> read() {

        String sql = "SELECT descricao\n"
                + "	FROM public.previlegio_tb ORDER BY descricao";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Previlegio funcao
                        = new Previlegio(rs.getString("descricao"));
                listaDeClassificacoes.add(funcao);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do Privilégio\n",
                    "PESQUISA DE PRIVILÉGIOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return listaDeClassificacoes;
    }

//    
//    SELECT id_previlegio, descricao
//	FROM public.classificacao_previlegio_tb;
    public int getIdPrevilegio(String nomePrevilegio) {

        String sql = "SELECT id_previlegio "
                + " FROM previlegio_tb"
                + " WHERE  descricao = '" + nomePrevilegio + "'";

        int idClassificacao = 0;

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            rs.next();

            idClassificacao = rs.getInt("id_previlegio");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do ID da Previlegio\n" + ex,
                    "PESQUISA DA FUNÇÃO", JOptionPane.ERROR_MESSAGE);
        } finally {

        }

        return idClassificacao;

    }

}
