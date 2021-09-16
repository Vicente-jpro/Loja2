/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forma_pagamento;

import Connectiondb.ConnectionJDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vicente-jpro
 */
public class FormaPagamentodb {

    private PreparedStatement stmt;
    private ResultSet rs;
    private Connection conn;
    private FormaPagamento formaPagamento;

    public FormaPagamentodb() {

        conn = ConnectionJDBC.getConnection();
        this.formaPagamento = null;
    }

    public int getIdFormaPagamento(FormaPagamento pagamento) {

        String pag = pagamento.getForma_pagamento();

        String sql = "SELECT id_forma_pagamento "
                + " FROM forma_pagamento_tb "
                + "WHERE forma_pagamento = '" + pag + "' ";

        int idFormaPagamento = 0;

        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            rs.next();

            idFormaPagamento = rs.getInt("id_forma_pagamento");
//
//            JOptionPane.showMessageDialog(null, "Id forma pagamento:  " + idFormaPagamento);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possível obter o id da forma de pagamento \n ",
                    "IDENTIFICADOR DA FORMA DE PAGAMENTO",JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return idFormaPagamento;

    }

    public List<FormaPagamento> read() {

        String sql = "SELECT forma_pagamento "
                + " FROM forma_pagamento_tb "
                + "ORDER BY forma_pagamento";

        List lista = new ArrayList<>();
        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {
                
                formaPagamento = new FormaPagamento(rs.getString("forma_pagamento"));
                lista.add(formaPagamento);
            
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro na leitura da forma de pagamento \n " + ex);
            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return lista;

    }

}
