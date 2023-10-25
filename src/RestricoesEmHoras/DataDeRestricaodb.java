/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestricoesEmHoras;

import Connectiondb.ConnectionJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente
 */
public class DataDeRestricaodb {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); 

    public DataDeRestricaodb() {

        con = ConnectionJDBC.getConnection();

    }

    public void create(DataHorasDeRestricao data) {

        String sql = "INSERT INTO DataHorasDeRestricaotb "
                + "( dataInicial, dataFinal, totalHorasConsumida, idDescricao, idDuracoEmHoras) "
                + "VALUES ( ?, ?, ?, ?, ?)";

        try {
            
            stmt = con.prepareStatement(sql);
            stmt.setObject(1, data.getDataInicial());
            stmt.setObject(2, data.getDataFinal());
            stmt.setDouble(3, data.getTotalHorasConsumida());
            stmt.setInt(4, data.getIdPacote());
            stmt.setInt(5, data.getIdPacote());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Pacote salvo com sucesso",
                    "PACOTE", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel dalvar o pacote na dataHorasDeRestricao \n" + ex,
                    "PACOTE", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt);
        }

    }

    public void update(DataHorasDeRestricao data) {

        String sql = "UPDATE DataHorasDeRestricaotb "
                + " SET dataInicial = ?,"
                + " dataFinal = ?  "
                + " WHERE pacoteSelecionado = ? ";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setObject(1, data.getDataInicial());
            stmt.setObject(2, data.getDataFinal());
            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Data data actualizada com sucesso");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel actualizar a data \n" + ex,
                    "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt);
        }

    }

    /**
     *
     * @return Retorna as ultimas horas contida no banco de dados. Esta hora
     * corresponde a hora salva desde o primeiro dia de uso da aplicacao
     */
    public double getUltimasHoras() {

        double ultimasHoras = 0.0;

        String sql = "SELECT totalHorasConsumida FROM DataHorasDeRestricaotb";

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();

            ultimasHoras = rs.getDouble("totalHorasConsumida");
//
//            JOptionPane.showMessageDialog(null, "Horas consumida obtida com sucesso \n",
//                    "HORAS", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel obter as horas consumidas \n" + ex,
                    "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt, rs);
        }

        return ultimasHoras;

    }

    /**
     *
     * @return Pegar a ultima data salva no banco de dados
     */
    public String getDataInicial() {

        String dataInicial = null;

        String sql = "SELECT dataInicial FROM DataHorasDeRestricaotb";

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();

            dataInicial = rs.getString("dataInicial");
//
//            JOptionPane.showMessageDialog(null, "Horas consumida obtida com sucesso \n",
//                    "HORAS", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel obter as horas consumidas \n" + ex,
                    "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt, rs);
        }

        return dataInicial;

    }

    /**
     *
     * @return Retorna true se ja exites um pacote escolhido
     */
    public boolean ExistenciaDePacoteEscolhido() {

        boolean pacoteExiste = false;
        int idDataDeRestricao = 0;

        String sql = "SELECT  idDataDeRestricao FROM DataHorasDeRestricaotb WHERE idDataDeRestricao > 0 ";

        try {

            stmt = con.prepareStatement(sql);

            rs = stmt.executeQuery();

            rs.next();

            idDataDeRestricao = rs.getInt("idDataDeRestricao");

            if (idDataDeRestricao != 0) {

                pacoteExiste = true;
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel obter a leitura dos Pacotes \n" + ex,
                    "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt, rs);
        }

        return pacoteExiste;

    }

    public double getHorasParaPermitirUsoDaApp() {

        double horasDeConsumo = 0.0;

        String sql = " SELECT Pacotestb.duracaoEmHoras "
                + " FROM DataHorasDeRestricaotb "
                + " LEFT JOIN Pacotestb "
                + " ON DataHorasDeRestricaotb.idDescricao = Pacotestb.idPacote ";

        try {

            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            horasDeConsumo = rs.getDouble("duracaoEmHoras");
//
//            JOptionPane.showMessageDialog(null, "Horas de consumo obtida com sucesso \n",
//                    "HORAS DE CONSUMO", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel obter as horas consumidas \n" + ex,
                    "ERRO HORAS DE CONSUMO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt, rs);
        }

        return horasDeConsumo;

    }

    public void deleteList() {

        String sql = "DROP TABLE DataHorasDeRestricaotb ";

        try {

            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Lista de restricao eliminada com sucesso");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel eliminar a lista de restriçao \n" + ex,
                    "LISTA DE RESTRIÇAO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt);
        }

    }

    public void creatList() {

        String sql = "CREATE TABLE public.datahorasderestricaotb\n"
                + "(\n"
                + "    iddataderestricao integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),\n"
                + "    datainicial character varying(15) COLLATE pg_catalog.\"default\",\n"
                + "    datafinal character varying(15) COLLATE pg_catalog.\"default\",\n"
                + "    totalhorasconsumida real,\n"
                + "    iddescricao integer,\n"
                + "    idduracoemhoras integer,\n"
                + "    CONSTRAINT datahorasderestricaotb_pkey PRIMARY KEY (iddataderestricao),\n"
                + "    CONSTRAINT datahorasderestricaotb_iddescricao_fkey FOREIGN KEY (iddescricao)\n"
                + "        REFERENCES public.pacotestb (idpacote) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION,\n"
                + "    CONSTRAINT datahorasderestricaotb_idduracoemhoras_fkey FOREIGN KEY (idduracoemhoras)\n"
                + "        REFERENCES public.pacotestb (idpacote) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION\n"
                + ")\n"
                + "WITH (\n"
                + "    OIDS = FALSE\n"
                + ")\n"
                + "TABLESPACE pg_default;\n"
                + "\n"
                + "ALTER TABLE public.datahorasderestricaotb\n"
                + "    OWNER to postgres";

        try {

            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Lista de restricao criada com sucesso");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel criar a lista de restriçao \n" + ex,
                    "LISTA DE RESTRIÇAO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt);
        }

    }

    public void updateTotalHorasUtilizadas(double totalHorasConsumida, String dataFinal) {

        // Nao mexe em nada esta tudo certinho nao pensa que esta errado
        String sql = "UPDATE DataHorasDeRestricaotb "
                + " SET dataInicial = ?, dataFinal = ? , totalHorasConsumida = ? "
                + " WHERE idDataDeRestricao = '1' ";

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, dataFinal);
            stmt.setString(2, dataFinal);
            stmt.setDouble(3, totalHorasConsumida);
            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Data data actualizada com sucesso");
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Nao foi possivel actualizar a data \n" + ex,
                    "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(con, stmt);
        }

    }

}
