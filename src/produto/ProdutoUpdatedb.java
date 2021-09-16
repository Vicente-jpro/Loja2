package produto;

import java.sql.ResultSet;
import java.sql.SQLException;

import Connectiondb.ConnectionJDBC;

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class ProdutoUpdatedb {

    private ResultSet rs;
    private Connection conn;
    private PreparedStatement stmt;
    private Produto produto;

    public ProdutoUpdatedb() {

        conn = ConnectionJDBC.getConnection();
    }



    public void updateQuantidade(int quantidade, Produto produto) {

        String nomeProduto = produto.getNomeProduto();

        String sql = "UPDATE public.produto_tb "
                + "	SET quantidade=? "
                + "	WHERE  nome_produto = '" + nomeProduto + "'";

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
    
    
    
    /**
     * @return Actualiza o produto com a data de expiracao e de fabricacao
     * @param produto
     */
    protected void actualizarComData(Produto produto){
    
                String nomeProduto = produto.getNomeProduto();

        String sql = "UPDATE public.produto_tb "
                + "	SET nome_produto=?, data_fabrico=?, data_expiracao=?, "
                + "	 quantidade=?, preco=?, "
                + "	iva=?, codigo_produto=?, data_registo=?, valor_pagar_cliente=?, "
                + "     usuario_id=?, lucro =? "
                + "	WHERE  nome_produto = '" + nomeProduto + "'";

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNomeProduto());
            stmt.setObject(2, produto.getDataFabrico());
            stmt.setObject(3, produto.getDataExpiracao());
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

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o produto \n"
                    + "Seleciona uma Data de Expiração e de Fabricação para alterar" ,
                    "ACTUALIZAÇÃO DE PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }
    
    }
    
    
    /**
     * @return Actualiza o produto com fornecedor e uma Classificaçao
     * @param produto
     */
    protected void actualizarComFornecedorClassificacao(Produto produto){
    
            String nomeProduto = produto.getNomeProduto();

        String sql = "UPDATE public.produto_tb "
                + "	SET nome_produto=?, fornecedor_id=?, classificacao_id=?, "
                + "     quantidade=?, preco=?, iva=?, codigo_produto=?, data_registo=?, "
                + "     valor_pagar_cliente=?, usuario_id=?, lucro =? "
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

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o produto \n"
                    + "Seleciona um Fornecedor e a sua Classificação para alterar",
                    "ACTUALIZAÇÃO DE PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }
    }
    
    // O usuario deve preencher todos os campos
    protected void actualizarTudo(Produto produto){
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

            JOptionPane.showMessageDialog(null, "Não foi possivel actualizar o produto \n",
                    "ACTUALIZAÇÃO DE PRODUTO", JOptionPane.ERROR_MESSAGE);

        } finally {

            ConnectionJDBC.closeConnection(conn, stmt);

        }
    }
   

    /**
     * @return  O Usuario de preencher tudo menos as datas, fornecedor e classificação
     * @param produto
     */
    protected void actualizar(Produto produto){
            String nomeProduto = produto.getNomeProduto();

        String sql = "UPDATE public.produto_tb "
                + "	SET nome_produto=?, quantidade=?, preco=?, "
                + "	iva=?, codigo_produto=?, data_registo=?, valor_pagar_cliente=?, "
                + "     usuario_id=?, lucro =? "
                + "	WHERE  nome_produto = '" + nomeProduto + "'";

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNomeProduto());
            stmt.setInt(2, produto.getQuantidade());
            stmt.setDouble(3, produto.getPreco());
            stmt.setDouble(4, produto.getIva());
            stmt.setString(5, produto.getCodigoProduto());
            stmt.setObject(6, produto.getDataRegisto());
            stmt.setDouble(7, produto.getValorPagarCliente());
            stmt.setInt(8, produto.getCurrentUser().getIdUsuario());
            stmt.setDouble(9, produto.getLucroProdutoUnitario());
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
    
    


}
