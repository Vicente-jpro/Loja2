package produto;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;
import current_user.CurrentUser;
import fornecedor.Fornecedor;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Produtodb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private final ArrayList listaDeClassificacoes;
    private Produto produto;

    public Produtodb() {

        conn = ConnectionJDBC.getConnection();
        this.listaDeClassificacoes = new ArrayList<Produto>();
    }

    protected void create(Produto produto) {

        String sql = "INSERT INTO public.produto_tb( "
                + "     nome_produto, data_fabrico, data_expiracao, "
                + "	fornecedor_id, classificacao_id, quantidade, preco, iva,"
                + "	codigo_produto, data_registo, valor_pagar_cliente, "
                + "     usuario_id, lucro)"
                + "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());
            stmt.setObject(2, produto.getDataFabrico());
            stmt.setObject(3, produto.getDataExpiracao());
            stmt.setInt(4, produto.getFornecedor().getIdFornecedor());
            stmt.setInt(5, produto.getIdClassificacao());
            stmt.setInt(6, produto.getQuantidade());
            stmt.setDouble(7, produto.getPreco());
            stmt.setDouble(8, produto.getIva());
            stmt.setString(9, produto.getCodigoProduto());
            stmt.setObject(10, produto.getDataRegisto());
            stmt.setDouble(11, produto.getValorPagarCliente());
            stmt.setInt(12, produto.getCurrentUser().getIdUsuario());
            stmt.setDouble(13, produto.getLucroProdutoUnitario());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso\n",
                    "CADASTRO DE PRODUTO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel salvar o Produto \n" + ex,
                    "CADASTRO DE PRODUTO DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    /**
     * @return Actualiza o produto com a data de expiracao e de fabricacao
     * @param produto
     */
    protected void updateExpFab(Produto produto) {

        String nomeProduto = produto.getNomeProduto();

        String sql = "UPDATE public.produto_tb "
                + "	SET nome_produto=?, data_fabrico=?, data_expiracao=?, "
                + "	fornecedor_id=?, classificacao_id=?, quantidade=?, preco=?, "
                + "	iva=?, codigo_produto=?, data_registo=?, valor_pagar_cliente=?, "
                + "     usuario_id=?, lucro =? "
                + "	WHERE  nome_produto = '" + nomeProduto + "'";

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNomeProduto());
            stmt.setObject(2, produto.getDataFabrico());
            stmt.setObject(3, produto.getDataExpiracao());
            stmt.setInt(4, produto.getFornecedor().getIdFornecedor());
            stmt.setInt(5, produto.getIdClassificacao());
            stmt.setInt(6, produto.getQuantidade());
            stmt.setDouble(7, produto.getPreco());
            stmt.setDouble(8, produto.getIva());
            stmt.setString(9, produto.getCodigoProduto());
            stmt.setObject(10, produto.getDataRegisto());
            stmt.setDouble(11, produto.getValorPagarCliente());
            stmt.setInt(12, produto.getCurrentUser().getIdUsuario());
            stmt.setDouble(13, produto.getLucroProdutoUnitario());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto actualizado com sucesso\n",
                    "ACTUALIZAÇÃO DE PRODUTO ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o produto \n" + ex,
                    "ACTUALIZAÇÃO DE PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    /**
     * @return Actualiza o produto sem a data de expiracao e de fabricacao
     * @param produto
     */
    protected void update(Produto produto) {

        String nomeProduto = produto.getNomeProduto();

        String sql = "UPDATE public.produto_tb "
                + "	SET nome_produto=?, "
                + "	fornecedor_id=?, classificacao_id=?, quantidade=?, preco=?, "
                + "	iva=?, codigo_produto=?, data_registo=?, valor_pagar_cliente=?, "
                + "     usuario_id=?, lucro =? "
                + "	WHERE  nome_produto = '" + nomeProduto + "'";

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getFornecedor().getIdFornecedor());
            stmt.setInt(3, produto.getIdClassificacao());
            stmt.setInt(4, produto.getQuantidade());
            stmt.setDouble(5, produto.getPreco());
            stmt.setDouble(6, produto.getIva());
            stmt.setString(7, produto.getCodigoProduto());
            stmt.setObject(8, produto.getDataRegisto());
            stmt.setDouble(9, produto.getValorPagarCliente());
            stmt.setInt(10, produto.getCurrentUser().getIdUsuario());
            stmt.setDouble(11, produto.getLucroProdutoUnitario());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto actualizado com sucesso\n",
                    "ACTUALIZAÇÃO DE PRODUTO ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o produto \n" + ex,
                    "ACTUALIZAÇÃO DE PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    /**
     *
     * @param produto
     * @return Quantidadade do produto em stock
     */
    public int getQuantidade(Produto produto) {

        String sql = "SELECT quantidade FROM public.produto_tb "
                + "	WHERE  codigo_produto = '" + produto.getCodigoProduto() + "'";

        int quantidade = 0;
        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            rs.next();

            quantidade = rs.getInt("quantidade");
//
//            JOptionPane.showMessageDialog(null, "Quantidade do Produto actualizada com sucesso\n",
//                    "ACTUALIZAÇÃO DA QUANTIDADE DO PRODUTO ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel obter a quantidade do produto \n" + ex,
                    "ACTUALIZAÇÃO DA QUANTIDADE DO PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

        return quantidade;
    }

    public void updateQuantidade(int quantidade, Produto produto) {

        String nomeProduto = produto.getNomeProduto();
        String codigo = produto.getCodigoProduto();
        String sql = "UPDATE public.produto_tb "
                + "	SET quantidade=? "
                + "	WHERE  nome_produto = '" + nomeProduto + "' OR codigo_produto = '" + codigo + "'";

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, quantidade);

            stmt.executeUpdate();
//
//            JOptionPane.showMessageDialog(null, "Quantidade do Produto actualizada com sucesso\n",
//                    "ACTUALIZAÇÃO DA QUANTIDADE DO PRODUTO ", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar a quantidade do produto actualizada \n" + ex,
                    "ACTUALIZAÇÃO DA QUANTIDADE DO PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected void delete(Produto produto) {

        String nomeProduto = produto.getNomeProduto();

        String sql = "DELETE FROM Produto_tb "
                + " WHERE nome_produto = '" + nomeProduto + "'";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Produto eliminado com sucesso\n",
                    "ELIMINAR PRODUTO", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi possivel eliminar o produto\n" + ex,
                    "ELIMINAR PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }

    }

    protected ArrayList<Produto> read() {

        String sql = "SELECT nome_produto, classe_produto, nome_fornecedor,\n"
                + "	   data_fabrico, data_expiracao, data_registo,\n"
                + "	   quantidade, preco, iva, valor_pagar_cliente, \n"
                + "	   codigo_produto,  lucro, \n"
                + "	   usuario_tb.nome_usuario\n"
                + "	FROM produto_tb\n"
                + "	LEFT JOIN fornecedor_tb\n"
                + "	ON produto_tb.fornecedor_id = fornecedor_tb.id_fornecedor\n"
                + "	LEFT JOIN classificacao_produto_tb\n"
                + "	ON produto_tb.classificacao_id = classificacao_produto_tb.id_classificacao\n"
                + "	LEFT JOIN usuario_tb\n"
                + "	ON produto_tb.usuario_id = Usuario_tb.id_usuario ORDER BY nome_produto";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                // Data form produto_tb
                produto = new Produto(
                        rs.getString("nome_produto"),
                        rs.getObject(4, LocalDate.class),
                        rs.getObject(5, LocalDate.class),
                        rs.getObject(6, LocalDate.class),
                        rs.getInt("quantidade"),
                        rs.getString("codigo_produto"),
                        rs.getDouble("preco"),
                        rs.getDouble("iva"),
                        rs.getDouble("valor_pagar_cliente"),
                        rs.getDouble("lucro")
                );

                //Foreign key from table produto_tb
                produto.setClasseProduto(rs.getString("classe_produto"));
//
//                //Foreign key from table fornecedor_tb

                produto.setFornecedor(new Fornecedor(rs.getString("nome_fornecedor")));

                produto.setCurrentUser(new CurrentUser(rs.getString("nome_usuario")));

                listaDeClassificacoes.add(produto);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura dos produtos\n"
                    + "A lista de produtos está vazia",
                    "LEITURA DOS PRODUTO", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return listaDeClassificacoes;
    }

    /**
     *
     * @param nomeProduto
     * @param codigoProduto
     * @return retorna um Produto com todos os seus dados A pesquisa é feita com
     * um nome ou pelo seu codigo
     */
    public Produto getProtudo(String nomeProduto) {

        String sql = "SELECT id_produto, nome_produto, data_fabrico, data_expiracao, \n"
                + "	   fornecedor_id, classificacao_id, quantidade, preco, \n"
                + "	   iva, codigo_produto, data_registo, valor_pagar_cliente, \n"
                + "	   usuario_id, lucro\n"
                + "	FROM public.produto_tb "
                + " WHERE nome_produto = '" + nomeProduto + "'";

        Produto produto = null;

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            rs.next();

            // Data form produto_tb
            produto = new Produto(
                    rs.getString("nome_produto"),
                    rs.getObject(3, LocalDate.class),
                    rs.getObject(4, LocalDate.class),
                    rs.getObject(11, LocalDate.class),
                    rs.getInt("quantidade"),
                    rs.getString("codigo_produto"),
                    rs.getDouble("preco"),
                    rs.getDouble("iva"),
                    rs.getDouble("valor_pagar_cliente"),
                    rs.getDouble("lucro")
            );

            produto.setIdProduto(rs.getInt("id_produto"));
            //Foreign key from table produto_tb
            produto.setIdClassificacao(rs.getInt("classificacao_id"));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do produto \n"
                    + "Esse produto ainda não existe",
                    "LEITURA DO PRODUTO SALVAR", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return produto;

    }

    public Produto getProtudoPeloCodigo(String codigo_produto) {

        String sql = "SELECT id_produto, nome_produto, data_fabrico, "
                    + " data_expiracao, fornecedor_id, classificacao_id, quantidade, "
                    + " preco, iva, codigo_produto, data_registo, valor_pagar_cliente, "
                    + " usuario_id, lucro "
                    + " FROM produto_tb "
                        + " WHERE codigo_produto = '" + codigo_produto + "'";

        Produto produto = null;

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            rs.next();

            // Data form produto_tb
            produto = new Produto(
                    rs.getString("nome_produto"),
                    rs.getObject(3, LocalDate.class),
                    rs.getObject(4, LocalDate.class),
                    rs.getObject(11, LocalDate.class),
                    rs.getInt("quantidade"),
                    rs.getString("codigo_produto"),
                    rs.getDouble("preco"),
                    rs.getDouble("iva"),
                    rs.getDouble("valor_pagar_cliente"),
                    rs.getDouble("lucro")
            );

            produto.setIdProduto(rs.getInt("id_produto"));
            //Foreign key from table produto_tb
            produto.setIdClassificacao(rs.getInt("classificacao_id"));

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a leitura do produto\n"
                    + "Esse produto código do produto não existe" ,
                    "LEITURA DO PRODUTO SALVAR", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return produto;

    }

    private List<Produto> getNumberItemTable() {

        String sql = "SELECT id_produto FROM produto_tb ORDER BY nome_produto ";

        List lista = new ArrayList<Produto>();

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            produto = null;
            while (rs.next()) {

                produto = new Produto(rs.getInt("id_produto"));

                lista.add(produto);

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

        String sql = "UPDATE public.produto_tb "
                + "	SET contador = ? "
                + "	WHERE  id_produto = ? ";

        List<Produto> lista = getNumberItemTable();

        try {
            conn = ConnectionJDBC.getConnection();
            stmt = conn.prepareStatement(sql);

            int contador = 1;
            for (Produto produt : lista) {

                stmt.setInt(1, contador);
                stmt.setInt(2, produt.getIdProduto());
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

    protected boolean contem(Produto produto) {

        boolean existe = false;

        String novoProduto = null;

        String nome_produto = produto.getNomeProduto();

        String sql = "SELECT nome_produto"
                + " FROM Produto_tb "
                + " WHERE nome_produto = ?";

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome_produto);

            rs = stmt.executeQuery();
            rs.next();

            novoProduto = rs.getString("nome_produto");

            if (novoProduto.equals(nome_produto)) {
                existe = true;
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa do produto\n {" + novoProduto + "}\n" ,
                    "CADASTRO DE PRODUTO DE PRODUTOS", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);

        }

        return existe;
    }

    public int getIdProduto(Produto produto) {

        String sql = "SELECT id_produto "
                + " FROM produto_tb"
                + " WHERE nome_produto = ?";

        int idProduto = 0;

        try {

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, produto.getNomeProduto());

            rs = stmt.executeQuery();
            rs.next();

            idProduto = rs.getInt("id_produto");

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Não foi efectuar a pesquisa ID do produto\n",
                    "PESQUISA DE PRODUTO ", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }

        return idProduto;

    }

    public boolean getValidarCodigoProduto(String codigo) {

        String sql = "SELECT codigo_produto "
                + " FROM produto_tb"
                + " WHERE codigo_produto = '" + codigo + "'";

        String codigo_produto = "";

        boolean existe = false;

        try {

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();
            rs.next();

            codigo_produto = rs.getString("codigo_produto");

            if (codigo_produto.equalsIgnoreCase(codigo)) {
                existe = true;

                JOptionPane.showMessageDialog(null, "Esse código do produto já existe.\n"
                        + "O sistema vai gerar um outro código para garantir integredade dos dados",
                        "CÓDIGO DE PRODUTO ", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Esse código do produto ainda não existe\n" ,
                    "CÓDIGO DE PRODUTO ", JOptionPane.ERROR_MESSAGE);
        } finally {

            ConnectionJDBC.closeConnection(conn, stmt, rs);
        }
        // return true se ja existe
        // return false se ainda não existe
        return existe;

    }

}
