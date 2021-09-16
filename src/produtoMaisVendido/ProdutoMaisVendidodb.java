/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produtoMaisVendido;

import Connectiondb.ConnectionJDBC;
import compra_historico.CompraHistorico;
import interfaces.DropAndCreat_table;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vicente-jpro
 */
public class ProdutoMaisVendidodb {

    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private CompraHistorico historico;

    private ProdutoMaisVendido produtoMaisVendido;

    public ProdutoMaisVendidodb() {

        conn = ConnectionJDBC.getConnection();

    }

    protected List<ProdutoMaisVendido> read() {

        String sql = "SELECT compra_historico_tb.contador, produto_tb.nome_produto, COUNT( nome_produto_id) AS numero_compras, \n"
                + "       SUM(quantidadee) as total_item \n"
                + "       FROM compra_historico_tb\n"
                + "         LEFT JOIN cliente_tb\n"
                + "         ON compra_historico_tb.nome_cliente_id = cliente_tb.id_cliente\n"
                + "         LEFT JOIN produto_tb\n"
                + "         ON compra_historico_tb.nome_produto_id = produto_tb.id_produto\n"
                + "         LEFT JOIN usuario_tb \n"
                + "          	ON compra_historico_tb.usuario_id = usuario_tb.id_usuario\n"
                + "        		GROUP BY nome_produto,compra_historico_tb.contador\n"
                + "        		ORDER BY numero_compras DESC\n"
                + "        		LIMIT 100;";

        List lista = new ArrayList<Integer>();

        produtoMaisVendido = null;
        try {

            // conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                produtoMaisVendido = new ProdutoMaisVendido();
                produtoMaisVendido.setNumero_compras(rs.getInt("numero_compras"));
                // produtoMaisVendido.setId_produto_mais_vendido(rs.getInt("id_produto_mais_vendido"));
                produtoMaisVendido.setNomeProduto(rs.getString("nome_produto"));
                produtoMaisVendido.setTotal_item(rs.getInt("total_item"));
                // Meu contador de sequencia de ordem
                produtoMaisVendido.setIdCompra(rs.getInt("contador")); 

                lista.add(produtoMaisVendido);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura dos idProduto no historico\n" + ex,
                    "LEITURA DO ID PRODUTO MAIS VENDIDOS", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return lista;

    }

    private List<CompraHistorico> getNumberItemTable() {

        String sql = "SELECT nome_produto_id, produto_tb.nome_produto, COUNT( nome_produto_id) AS numero_compras, \n"
                + "        	SUM(quantidadee) as total_item \n"
                + "                FROM compra_historico_tb\n"
                + "                LEFT JOIN cliente_tb\n"
                + "                ON compra_historico_tb.nome_cliente_id = cliente_tb.id_cliente\n"
                + "                LEFT JOIN produto_tb\n"
                + "                ON compra_historico_tb.nome_produto_id = produto_tb.id_produto\n"
                + "                LEFT JOIN usuario_tb \n"
                + "               	ON compra_historico_tb.usuario_id = usuario_tb.id_usuario\n"
                + "        		GROUP BY nome_produto,nome_produto_id\n"
                + "        		ORDER BY numero_compras DESC\n"
                + "        		LIMIT 100";

        List lista = new ArrayList<CompraHistorico>();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            historico = null;
            while (rs.next()) {

                historico = new CompraHistorico();
                historico.setIdCompra(rs.getInt("nome_produto_id"));
                lista.add(historico);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do produto\n"
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
     * @param produto
     */
    protected void updateSequenceNumber() {

        String sql = "UPDATE public.compra_historico_tb "
                + "	SET contador = ? "
                + "	WHERE  nome_produto_id = ? ";

        List<CompraHistorico> lista = getNumberItemTable();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(sql);

            int contador = 1;
            for (CompraHistorico produt : lista) {

                stmt.setInt(1, contador);
                stmt.setInt(2, produt.getIdCompra());
                contador++;

                stmt.executeUpdate();

            }
//
//            JOptionPane.showMessageDialog(null, "Produto actualizado com sucesso\n",
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
