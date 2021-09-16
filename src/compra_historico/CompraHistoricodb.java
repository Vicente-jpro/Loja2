package compra_historico;

import compra.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;
import MyInterfaces.DropCreate_tb;
import cliente.Cliente;
import current_user.CurrentUser;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import produto.Produto;
import tempo_trabalho_tb.TempoTrabalho;

public class CompraHistoricodb implements DropCreate_tb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private CompraHistorico historico;
    private Compra compra;

    public CompraHistoricodb() {

        conn = ConnectionJDBC.getConnection();
    }

    public void create(List<Compra> listaCompra) {

        String sql = "INSERT INTO public.compra_historico_tb(\n"
                + "	 nome_cliente_id, nome_produto_id, valor_unitario, \n"
                + "	sub_total, data_compra, hora, usuario_id,\n"
                + "	quantidadee, iva, lucro, valor_total, "
                + "     valor_entregar_cliente, troco_cliente, forma_pagamento_id)\n"
                + "	VALUES (  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            stmt = conn.prepareStatement(sql);

            for (Compra compra : listaCompra) {

                stmt.setInt(1, compra.getCliente().getIdCliente());
                stmt.setInt(2, compra.getIdProduto());
                // valorUnitario corresponde ao preço do produto com iva
                stmt.setDouble(3, compra.getValorUnitario()); // valorUnitario com iva
                stmt.setDouble(4, compra.getSubTotal());

                stmt.setObject(5, compra.getDataCompra());
                stmt.setObject(6, compra.getHora());
                stmt.setInt(7, compra.getCurrentUser().getIdUsuario());
                stmt.setInt(8, compra.getQuantidade());
                stmt.setDouble(9, compra.getIva());
                stmt.setDouble(10, compra.getLucro());
                stmt.setDouble(11, compra.getValorTotal());
                stmt.setDouble(12, compra.getValorPagarCliente());
                stmt.setDouble(13, compra.getTrocoCliente());
                stmt.setInt(14, compra.getFormaPagamento().getId_forma_pagamento());
                stmt.executeUpdate();
            }
//
//            JOptionPane.showMessageDialog(null, "Compra salva com sucesso no Historico da Compra\n",
//                    "CADASTRO DA COMPRA", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o Compra \n",
                    "CADASTRO DA COMPRA ", JOptionPane.ERROR_MESSAGE);
//
//            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    public void delete(Produto produto) {

        int idProduto = produto.getIdProduto();

        String sql = "DELETE FROM compra_historico_tb "
                + " WHERE nome_produto_id = '" + idProduto + "'";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto eliminado com sucesso\n",
                    "ELIMINAR PRODUTO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o PRODUTO \n" + ex,
                    "ELIMINAR PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    public List<CompraHistorico> readTodasCompras() {

        String sql = "SELECT id_compra, cliente_tb.nome_cliente, produto_tb.nome_produto, \n"
                + "		quantidadee, valor_unitario, sub_total,  \n"
                + "		valor_total,troco_cliente,valor_entregar_cliente, compra_historico_tb.iva, "
                + "             data_compra, hora, usuario_tb.nome_usuario, compra_historico_tb.lucro\n"
                + "	FROM compra_historico_tb\n"
                + "	LEFT JOIN cliente_tb\n"
                + "	ON compra_historico_tb.nome_cliente_id = cliente_tb.id_cliente\n"
                + "	LEFT JOIN produto_tb\n"
                + "	ON compra_historico_tb.nome_produto_id = produto_tb.id_produto\n"
                + "	LEFT JOIN usuario_tb \n"
                + "	ON compra_historico_tb.usuario_id = usuario_tb.id_usuario;";

        List lista = new ArrayList<>();
        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                // Data form compra_tb
                historico = new CompraHistorico(
                        rs.getInt("id_compra"),
                        rs.getDouble("valor_unitario"),
                        rs.getDouble("sub_total"),
                        rs.getDouble("valor_total"),
                        rs.getDouble("troco_cliente"),
                        rs.getObject(11, LocalDate.class),
                        rs.getObject(12, LocalTime.class)
                );

//                compra.setValorPagarCliente(rs.getDouble("valor_entregar_cliente"));                
                historico.setQuantidade(rs.getInt("quantidadee"));                //Foreign key from table cliente_tb
                historico.setCliente(new Cliente(rs.getString("nome_cliente")));
                //compra.setValorUnitario( rs.getDouble("valor_unitario") );
                //Foreign key from table produto_tb
                historico.setNomeProduto(rs.getString("nome_produto"));

                historico.setCurrentUser(new CurrentUser(rs.getString("nome_usuario")));
                historico.setValorPagarCliente(rs.getDouble("valor_entregar_cliente"));
                historico.setLucroProdutoUnitario(rs.getDouble("lucro"));
                lista.add(historico);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do historico de compras\n" + ex,
                    "LEITURA DOS PRODUTO NA COMPRA", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return lista;
    }

    public List<String> readData() {

        String sql = "SELECT  data_compra FROM compra_historico_tb";
        String elemento = "";
        List lista = new ArrayList<String>();
        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                // Data form compra_tb
                elemento = rs.getString("data_compra");
                if (!lista.contains(elemento)) {
                    lista.add(elemento);
                }
//
//                System.out.println("Valor Unitario = " + historico.getValorUnitario() + "\n\n");
//
//                System.out.println("Valor Subtotal = " + historico.getSubTotal() + "\n\n");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura da data do historico da compras\n" + ex,
                    "LEITURA DOS PRODUTO NA COMPRA", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return lista;
    }
//
//    public List<String> readHoras() {
//
//        String sql = "SELECT hora FROM compra_historico_tb";
//        String elemento = "";
//        List lista = new ArrayList<String>();
//        try {
//
//            stmt = conn.prepareStatement(sql);
//            rs = stmt.executeQuery();
//
//            while (rs.next()) {
//
//                // Data form compra_tb
//                elemento = rs.getString("hora");
//                if (!lista.contains(elemento)) {
//                    lista.add(elemento);
//                }
////
////                System.out.println("Valor Unitario = " + historico.getValorUnitario() + "\n\n");
////
////                System.out.println("Valor Subtotal = " + historico.getSubTotal() + "\n\n");
//            }
//
//        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura dos compras\n" + ex,
//                    "LEITURA DOS PRODUTO NA COMPRA", JOptionPane.ERROR_MESSAGE);
//
//            ex.printStackTrace();
//
//        } finally {
//
//            ConnectionJDBC.closeConnection(conn, stmt, rs);
//
//        }
//
//        return lista;
//    }

    /**
     *
     * @param dataInicial
     * @param dataFinal
     * @return Retorna o lucro de uma determinada data
     */
    /**
     *
     * @param dataInicial
     * @param dataFinal
     * @param horaInicial
     * @param horaFinal
     * @return Retorna o lucro de uma determinada data apartir de determinadas
     * horas
     */
    public double getLucroTotal(LocalDate dataInicial, LocalDate dataFinal) {

        String sql = "SELECT lucro \n"
                + "   	FROM compra_historico_tb\n"
                + "   	WHERE data_compra BETWEEN '" + dataInicial + "'AND '" + dataFinal + "';";

        double lucro = 0.0;

        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                lucro += rs.getDouble("lucro");

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do LUCRO\n" + ex,
                    "LEITURA DO LUCRO DE COMPRAS", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return lucro;
    }

    @Override
    public void drop_tb() {

        String sql = "DROP TABLE public.compra_historico_tb";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto eliminado com sucesso\n",
                    "HISTORICO DE COMPRAS", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o PRODUTO \n" + ex,
                    "HISTORICO DE COMPRAS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create_tb() {

        String sql = "CREATE TABLE public.compra_historico_tb\n"
                + "(\n"
                + "    id_compra integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),\n"
                + "    nome_produto_id integer,\n"
                + "    valor_unitario real,\n"
                + "    sub_total real,\n"
                + "    valor_total real,\n"
                + "    data_compra date,\n"
                + "    hora time without time zone,\n"
                + "    usuario_id integer,\n"
                + "    quantidadee integer,\n"
                + "    troco_cliente real,\n"
                + "    valor_entregar_cliente real,\n"
                + "    iva real,\n"
                + "    nome_cliente_id integer,\n"
                + "    lucro real,\n"
                + "    forma_pagamento_id integer,\n"
                + "    CONSTRAINT compra_historico_tb_pkey PRIMARY KEY (id_compra),\n"
                + "    CONSTRAINT compra_historico_tb_forma_pagamento_id_fkey FOREIGN KEY (forma_pagamento_id)\n"
                + "        REFERENCES public.forma_pagamento_tb (id_forma_pagamento) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION,\n"
                + "    CONSTRAINT compra_historico_tb_nome_cliente_id_fkey FOREIGN KEY (nome_cliente_id)\n"
                + "        REFERENCES public.cliente_tb (id_cliente) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION,\n"
                + "    CONSTRAINT compra_historico_tb_nome_produto_id_fkey FOREIGN KEY (nome_produto_id)\n"
                + "        REFERENCES public.produto_tb (id_produto) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION\n"
                + ")\n"
                + "WITH (\n"
                + "    OIDS = FALSE\n"
                + ")\n"
                + "TABLESPACE pg_default;\n"
                + "\n"
                + "ALTER TABLE public.compra_historico_tb\n"
                + "    OWNER to postgres;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto eliminado com sucesso\n",
                    "HISTORICO DE COMPRA", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o PRODUTO \n" + ex,
                    "HISTORICO DE COMPRAS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        } //To change body of generated methods, choose Tools | Templates.
    }

    public List<LocalDate> filtrarDataCompra() {

        String sql = "SELECT DISTINCT data_compra \n"
                + "	FROM public.compra_historico_tb "
                + " ORDER BY data_compra ";

        List lista = new ArrayList<LocalDate>();

        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                lista.add(rs.getObject(1, LocalDate.class));

            }

        } catch (SQLException ex) {
            lista.get(0);
            ex.printStackTrace();
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return lista;

    }

    public void delete(LocalDate dataInicial, LocalDate dataFinal) {

        String sql = "DELETE FROM public.compra_historico_tb \n"
                + "		WHERE data_compra \n"
                + "	         BETWEEN ? AND ? ";

        try {


            stmt = conn.prepareStatement(sql);
            stmt.setObject(1, dataInicial);
            stmt.setObject(2, dataFinal);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Compras eliminada com sucesso",
                    "DATAS DE HISTÓRICO DE COMPRAS ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionJDBC.closeConnection(conn, stmt);
        }
    }
    
    

}
