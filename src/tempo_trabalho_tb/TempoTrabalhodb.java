/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tempo_trabalho_tb;

import Connectiondb.ConnectionJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente-jpro
 */
public class TempoTrabalhodb {

    private PreparedStatement stmt;
    private ResultSet rs;
    private Connection conn;

    public TempoTrabalhodb() {

        conn = ConnectionJDBC.getConnection();

    }

    public void createHoraEntrada(TempoTrabalho tempo) {

        String sql = "INSERT INTO tempo_trabalho_tb (data_hora_entrada, data_hora_saida, usuario_id) "
                + "VALUES (?, ?, ?)";
        try {

            stmt = conn.prepareStatement(sql);

            Timestamp data_entrada = Timestamp.valueOf(tempo.getData_hora_entrada());
            Timestamp data_saida = Timestamp.valueOf(tempo.getData_hora_saida());

            stmt.setTimestamp(1, data_entrada);
            stmt.setTimestamp(2, data_saida);
//            
            stmt.setInt(3, tempo.getIdUsuario());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Horas de entrada salva com sucesso",
                    "HORA DE ENTRADA DO USUÁRIO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt);
        }
    }

    public void updateHoraSaidaa(TempoTrabalho tempo) {

        String sql = "UPDATE tempo_trabalho_tb "
                + " SET data_hora_saida = ? "
                + " WHERE data_hora_saida = '2021-01-01 01:01:01' ";
        try {
            stmt = conn.prepareStatement(sql);

            Timestamp data_saida = Timestamp.valueOf(tempo.getData_hora_saida());

            stmt.setTimestamp(1, data_saida);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Horas de saída salva com sucesso",
                    "HORA DE SAÍDA DO USUÁRIO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt);
        }
    }

    public List<TempoTrabalho> read() {

        String sql = "SELECT id_tempo, data_hora_entrada, data_hora_saida, \n"
                + "		usuario_tb.nome_usuario\n"
                + "	FROM public.tempo_trabalho_tb\n"
                + "	LEFT JOIN usuario_tb\n"
                + "	ON tempo_trabalho_tb.usuario_id = usuario_tb.id_usuario";

        List lista = new ArrayList<>();

        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                TempoTrabalho tempo = new TempoTrabalho(
                        rs.getInt("id_tempo"),
                        rs.getString("data_hora_entrada"),
                        rs.getString("data_hora_saida")
                );
                tempo.setNome(rs.getString("nome_usuario"));

                lista.add(tempo);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return lista;

    }

    public List<Timestamp> filtrarDataTrabalho() {

        String sql = "SELECT DISTINCT data_hora_entrada \n"
                + "	FROM public.tempo_trabalho_tb "
                + " ORDER BY data_hora_entrada";

        List lista = new ArrayList<Timestamp>();

        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                lista.add(rs.getTimestamp("data_hora_entrada"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return lista;

    }

    public void delete(TempoTrabalho tempo) {

        String sql = "DELETE FROM public.tempo_trabalho_tb \n"
                + "		WHERE data_hora_entrada \n"
                + "			BETWEEN ? AND ? ";

        try {

            Timestamp data_entrada = Timestamp.valueOf(tempo.getData_hora_entrada());
            Timestamp data_saida = Timestamp.valueOf(tempo.getData_hora_saida());

            stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, data_entrada);
            stmt.setTimestamp(2, data_saida);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Horas de saída eliminada com sucesso",
                    "HORÁRIO DE TRABALHO ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt);
        }
    }

   private List<TempoTrabalho> getNumberItemTable() {

        String sql = "SELECT id_tempo FROM tempo_trabalho_tb ORDER BY data_hora_entrada ";

        List lista = new ArrayList<TempoTrabalho>();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

           TempoTrabalho tempo = null;
            while (rs.next()) {

                tempo = new TempoTrabalho(rs.getInt("id_tempo"));

                lista.add(tempo);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do tempo\n"
                    + "O correu um erro ao ler todos os IDs",
                    "LEITURA DO PRODUTO SALVAR", JOptionPane.ERROR_MESSAGE);

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
     * @param tempo
     */
    protected void updateSequenceNumber() {

        String sql = "UPDATE public.tempo_trabalho_tb "
                + "	SET contador = ? "
                + "	WHERE  id_tempo = ? ";

        List<TempoTrabalho> lista = getNumberItemTable();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(sql);

            int contador = 1;
            for (TempoTrabalho tempo : lista) {

                stmt.setInt(1, contador);
                stmt.setInt(2, tempo.getId_tempo());
                contador++;

                stmt.executeUpdate();

            }
//
//            JOptionPane.showMessageDialog(null, "TempoTrabalho actualizado com sucesso\n",
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
