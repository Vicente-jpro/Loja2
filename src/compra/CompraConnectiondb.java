package compra;

import compra_historico.CompraHistorico;
import compra_historico.CompraHistoricodb;
import interfaces.ValidarCompra;
import static java.net.URI.create;
import java.util.List;
import javax.swing.JOptionPane;
import produto.Produto;
import produto.Produtodb;

public class CompraConnectiondb implements ValidarCompra {

    private Compradb compradb;
    private Compra compra;
    private CompraHistoricodb compraHistoricodb;
    private Produtodb produtodb;

    public void actualizar(Compra compra) {

        //     compradb = new Compradb();
//
//        boolean existeClassificacao = compradb.contem(compra);
//
//        if ( existeClassificacao ) {
//
//            JOptionPane.showMessageDialog(null, "Impossível actualizar esse compra.\n "
//                    + "O compra {"+compra.getNomeCompra()+"} já existe no banco de dados",
//                    "ACTUALIZAR CLASSE", JOptionPane.ERROR_MESSAGE);
//        } else {
        compradb = new Compradb();

        compradb.update(compra);

        // Leitura das compras dos produtos actuais efectuadas 
        compradb = new Compradb();
        List<Compra> listaCompra = compradb.readTodaCompraActual();

        // Salvar compra no historico de compra
        compraHistoricodb = new CompraHistoricodb();
       
        compraHistoricodb.create(listaCompra);

        //   }
    }

    protected void eliminar(Compra compra) {

        compradb = new Compradb();

        compradb.deleteProduct(compra);

    }

    public boolean salvar(Compra compra, Produto produto) {

        boolean produtoSalvo = false;

        compradb = new Compradb();

        boolean existeClassificacao = compradb.contem(produto);

        if (existeClassificacao) {

            JOptionPane.showMessageDialog(null, "Impossível salvar esse PRODUTO.\nEsse produto já existe na compra",
                    "SALVAR PRODUTO NA COMPRA", JOptionPane.ERROR_MESSAGE);
        } else {

//            
//            
//            System.out.println("Dados da compra:\n"+
//                 "\nidCliente: "+   compra.getCliente().getIdCliente()
//           +"\n IdProduto: "+ produto.getIdProduto()
//           +"\n valorPagarCliente: "+ produto.getValorPagarCliente() 
//           +"\n subtotal: "+ compra.getSubTotal()
//           +"\n DataCompra: "+ compra.getDataCompra()
//          +"\n Hora: "+  compra.getHora()
//          +"\n idUser: "+  produto.getCurrentUser().getIdUsuario()
//          +"\n Quantidade: "+  compra.getQuantidade()
//          +"\n Iva: "+  compra.getIva());
            int quantidadeComprar = compra.getQuantidade();

            int quantidadeProduto = validarCompra(quantidadeComprar, produto);

            if (quantidadeProduto > -1) {

                // Salvar compra actual
                compradb = new Compradb();
                compradb.create(compra, produto);

                produtoSalvo = true;
            }

        }

        return produtoSalvo;

    }

    /**
     *
     * @param quantidadeComprar
     * @param produto
     * @return Retorna a nova quantidade que o produto de ter na base de dados 
     * pós ter feito a compra
     */
    @Override
    public int validarCompra(int quantidadeComprar, Produto produto) {

        // novaQuantidade = quantidadeProdutoSock - quantidadeComprar;
        int novaQuantidade = produto.getQuantidade() - quantidadeComprar;

        if (novaQuantidade > -1) {

            produtodb = new Produtodb();
            produtodb.updateQuantidade(novaQuantidade, produto);

        } else {
            JOptionPane.showMessageDialog(null, "Stock insuficente para vender o produto:\n "
                    + produto.getNomeProduto() + "\n Número de Items = " + produto.getQuantidade(),
                    "IMPOSSÍVEL VENDER", JOptionPane.ERROR_MESSAGE);
//
//            novaQuantidade = produto.getQuantidade();
        }

        return novaQuantidade;
    }

}
