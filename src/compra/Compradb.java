package compra;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;
import MyInterfaces.DropCreate_tb;
import cliente.Cliente;
import current_user.CurrentUser;
import forma_pagamento.FormaPagamento;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import produto.Produto;

public class Compradb implements DropCreate_tb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private final ArrayList listaDeClassificacoes;
    private Compra compra;

    public Compradb() {

        conn = ConnectionJDBC.getConnection();
        this.listaDeClassificacoes = new ArrayList<Compra>();
    }

    public void create(Compra compra, Produto produto) {

        String sql = "INSERT INTO public.compra_tb(\n"
                + "	 nome_cliente_id, nome_produto_id, valor_unitario, \n"
                + "	sub_total, data_compra, hora, usuario_id,\n"
                + "	quantidadee, iva, lucro)\n"
                + "	VALUES (  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, compra.getCliente().getIdCliente());
            stmt.setInt(2, produto.getIdProduto());
            // valorUnitario corresponde ao preço do produto com iva
            stmt.setDouble(3, produto.getValorPagarCliente()); // valorUnitario com iva
            stmt.setDouble(4, compra.getSubTotal());

            stmt.setObject(5, compra.getDataCompra());
            stmt.setObject(6, compra.getHora());
            stmt.setInt(7, produto.getCurrentUser().getIdUsuario());
            stmt.setInt(8, compra.getQuantidade());
            stmt.setDouble(9, compra.getIva());
            stmt.setDouble(10, compra.getLucro());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso.\n",
                    "CADASTRO DO PRODUTO NA COMPRA", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o Compra \n" + ex,
                    "CADASTRO DO PRODUTO NA COMPRA ", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    public void updateQuantidade(Compra compra, Produto produto) {

        String sql = "UPDATE public.compra_tb "
                + "	SET valor_unitario = ?, "
                + "	sub_total = ?, 	quantidadee = ?, iva = ?, lucro = ?"
                + "	WHERE nome_produto_id = ?";

        try {

            stmt = conn.prepareStatement(sql);

            // valorUnitario corresponde ao preço do produto com iva
            stmt.setDouble(1, compra.getValorUnitario()); // valorUnitario com iva
            stmt.setDouble(2, compra.getSubTotal());
            stmt.setInt(3, compra.getQuantidade());
            stmt.setDouble(4, compra.getIva());
            stmt.setDouble(5, compra.getLucro());
            stmt.setInt(6, produto.getIdProduto());
            stmt.executeUpdate();
//            
//            System.out.println(  "Valor unitario = "+compra.getValorUnitario()  
//             +"\nsubtotal = "+compra.getSubTotal()
//            +"\nQuantidae = "+compra.getQuantidade()
//             +"\n Iva = "+compra.getIva()
//             +"\n Lucro = "+compra.getLucro()
//             +"idDoProduto = "+produto.getIdProduto());

            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso.\n",
                    "CADASTRO DO PRODUTO NA COMPRA", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar a quantidade da Compra \n",
                    "ACTUALIZAR QUANTIDADE NA COMPRA ", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    public void update(Compra compra) {

        try {
            String sql = "UPDATE compra_tb "
                    + "SET valor_total = ?, troco_cliente = ?, "
                    + "valor_entregar_cliente = ?, forma_pagamento_id = ?"
                    + "WHERE id_compra >  '0' ";

            stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, compra.getValorTotal());
            stmt.setDouble(2, compra.getTrocoCliente());
            stmt.setDouble(3, compra.getValorPagarCliente());
            stmt.setInt(4, compra.getFormaPagamento().getId_forma_pagamento());
            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "O Valor entregue pelo cliente e o Troco foram salvos com sucesso",
//                    "SALVAR O VALOR E TROCO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não existe compra para salvar o valor entregue pelo cliente\n" ,
                    "SALVAR O VALOR E TROCO", JOptionPane.INFORMATION_MESSAGE);
        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);
        }

    }

    /**
     *
     * @param compra do tipo Compra Elimina um produto na compra
     */
    public void deleteProduct(Compra compra) {

        int idProduto = compra.getIdProduto();

        String sql = "DELETE FROM Compra_tb "
                + " WHERE nome_produto_id = '" + idProduto + "' ";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Produto eliminado com sucesso\n",
//                    "ELIMINAR PRODUTO DA COMPRA", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o produto\n da lista de compra \n" ,
                    "ELIMINAR PRODUTO DA COMPRA", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    public ArrayList<Compra> read() {

        String sql = "SELECT produto_tb.codigo_produto, produto_tb.nome_produto, \n"
                + "		quantidadee, valor_unitario, sub_total "
                + "	FROM compra_tb\n"
                + "	LEFT JOIN produto_tb\n"
                + "	ON compra_tb.nome_produto_id = produto_tb.id_produto"
                + "     ORDER BY nome_produto\n";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                compra = new Compra();

                compra.setCodigoProduto(rs.getString("codigo_produto"));
                compra.setNomeProduto(rs.getString("nome_produto"));

                compra.setQuantidade(rs.getInt("quantidadee"));                //Foreign key from table cliente_tb
                compra.setValorUnitario(rs.getDouble("valor_Unitario"));
                compra.setSubTotal(rs.getDouble("sub_total"));
                listaDeClassificacoes.add(compra);
//
//                System.out.println("Valor Unitario = " + compra.getValorUnitario() + "\n\n");
//
//                System.out.println("Valor Subtotal = " + compra.getSubTotal() + "\n\n");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura das compras\n",
                    "LEITURA DOS PRODUTO NA COMPRA", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return listaDeClassificacoes;
    }

    public ArrayList<Compra> readTodaCompraActual() {

        String sql = "SELECT id_compra, nome_produto_id, valor_unitario, sub_total, \n"
                + "     valor_total, data_compra, hora, usuario_id, quantidadee, lucro,\n"
                + "     troco_cliente, valor_entregar_cliente, iva, nome_cliente_id, forma_pagamento_id\n"
                + "	FROM public.compra_tb;";
        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                compra = new Compra();

                compra.setIdCompra(rs.getInt("id_compra"));
                compra.setIdProduto(rs.getInt("nome_produto_id"));
                compra.setValorUnitario(rs.getDouble("valor_Unitario"));
                compra.setSubTotal(rs.getDouble("sub_total"));
                compra.setValorTotal(rs.getDouble("valor_total"));
                compra.setDataCompra(rs.getObject(6, LocalDate.class));
                compra.setHora(rs.getObject(7, LocalTime.class));

                CurrentUser usuario = new CurrentUser(rs.getInt("usuario_id"));
                compra.setCurrentUser(usuario);
                compra.setQuantidade(rs.getInt("quantidadee"));
                compra.setLucro(rs.getDouble("lucro"));
                compra.setTrocoCliente(rs.getDouble("troco_cliente"));
                compra.setValorPagarCliente(rs.getDouble("valor_entregar_cliente"));
                compra.setIva(rs.getDouble("iva"));
                Cliente cliente = new Cliente(rs.getInt("nome_cliente_id"));
                compra.setCliente(cliente);

                compra.setFormaPagamento(new FormaPagamento(rs.getInt("forma_pagamento_id")));

                listaDeClassificacoes.add(compra);
//
//                System.out.println("Valor Total = " + compra.getValorTotal() + "\n");
//                System.out.println("Valor Troco_Cliente = " + compra.getTrocoCliente() + "\n");
//                System.out.println("Valor Valor_Entregar_Cliente = " + compra.getValorPagarCliente() + "\n");
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura das compras actuais\n" ,
                    "LEITURA DOS PRODUTO NA COMPRA", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return listaDeClassificacoes;
    }

    /**
     *
     * @param produto Recebe por parametro o produto com o seu id
     * @return true se o produto já existe na lista de compra, caso contrario
     * false
     */
    public boolean contem(Produto produto) {

        boolean existe = false;

        int idProduto = 0;

        int idNovoProduto = produto.getIdProduto();

        String sql = "SELECT nome_produto_id"
                + " FROM Compra_tb "
                + " WHERE nome_produto_id = '" + idNovoProduto + "'";

        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            rs.next();

            idProduto = rs.getInt("nome_produto_id");

            if (idProduto > 0) {
                existe = true;
            }

        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do compra\n {" + idNovoProduto + "}\n" + ex,
//                    "PRODUTO EXISTE NA COMPRA", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return existe;
    }

    /**
     *
     * @param String codigoProduto Recebe por parametro o produto com o seu
     * codigo
     * @return true se o produto já existe na lista de compra, caso contrario
     * false
     */
    public boolean contem(String codigoProduto) {

        boolean existe = false;

        String codigo = null;

        String sql = "SELECT produto_tb.codigo_produto\n"
                + "	FROM compra_tb\n"
                + "	INNER JOIN produto_tb\n"
                + "	ON compra_tb.nome_produto_id = produto_tb.id_produto\n"
                + "	WHERE produto_tb.codigo_produto = '"+codigoProduto+"'";

        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            rs.next();

            codigo = rs.getString("codigo_produto");

            if (codigo != null ) {
                existe = true;
            }

        } catch (SQLException ex) {
//
//            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do compra\n {" + idNovoProduto + "}\n" + ex,
//                    "PRODUTO EXISTE NA COMPRA", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return existe;
    }

    public double getTotalSomaSubtotal() {

        String sql = "SELECT sub_total FROM compra_tb;";

        double total = 0.0;

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                total += rs.getDouble("sub_total");

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura dos compras\n" ,
                    "LEITURA DOS PRODUTO NA COMPRA", JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return total;
    }

    @Override
    public void drop_tb() {

        String sql = "DROP TABLE public.compra_tb";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Produto eliminado com sucesso\n",
//                    "ELIMINAR PRODUTO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar a lista de compras \n",
                    "ELIMINAR PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create_tb() {

        String sql = "CREATE TABLE public.compra_tb\n"
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
                + "    lucro real,\n"
                + "    nome_cliente_id integer,\n"
                + "    forma_pagamento_id integer,\n"
                + "    CONSTRAINT compra_tb_pkey PRIMARY KEY (id_compra),\n"
                + "    CONSTRAINT compra_tb_forma_pagamento_id_fkey FOREIGN KEY (forma_pagamento_id)\n"
                + "        REFERENCES public.forma_pagamento_tb (id_forma_pagamento) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION,\n"
                + "    CONSTRAINT compra_tb_nome_cliente_id_fkey FOREIGN KEY (nome_cliente_id)\n"
                + "        REFERENCES public.cliente_tb (id_cliente) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION,\n"
                + "    CONSTRAINT compra_tb_nome_produto_id_fkey FOREIGN KEY (nome_produto_id)\n"
                + "        REFERENCES public.produto_tb (id_produto) MATCH SIMPLE\n"
                + "        ON UPDATE NO ACTION\n"
                + "        ON DELETE NO ACTION\n"
                + ")\n"
                + "WITH (\n"
                + "    OIDS = FALSE\n"
                + ")\n"
                + "TABLESPACE pg_default;\n"
                + "\n"
                + "ALTER TABLE public.compra_tb\n"
                + "    OWNER to postgres;";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Produto eliminado com sucesso\n",
//                    "COMPRA DE PRODUTOS ELIMINADA COM SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel criar uma lista de compra \n",
                    "COMPRA DE PRODUTOS ELIMINADA COM SUCESSO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        } //To change body of generated methods, choose Tools | Templates.
    }

}
