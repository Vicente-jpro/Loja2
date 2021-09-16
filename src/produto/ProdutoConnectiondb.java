package produto;

import javax.swing.JOptionPane;

public class ProdutoConnectiondb {

    private Produtodb produtodb;
    private Produto produto;

    protected void actualizar(Produto produto) {

        //     produtodb = new Produtodb();
//
//        boolean existeClassificacao = produtodb.contem(produto);
//
//        if ( existeClassificacao ) {
//
//            JOptionPane.showMessageDialog(null, "Impossível actualizar esse produto.\n "
//                    + "O produto {"+produto.getNomeProduto()+"} já existe no banco de dados",
//                    "ACTUALIZAR CLASSE", JOptionPane.ERROR_MESSAGE);
//        } else {
        produtodb = new Produtodb();
        Object dataExpiracao = produto.getDataExpiracao();
        Object dataFabricacao = produto.getDataFabrico();
        if (dataExpiracao.equals("") || dataFabricacao.equals("")) 
        {
            // Sem a data de Expiracao e Fabricacao
            produtodb.update(produto);
        } else 
        {
            // Com a data de Expiracao e Fabricacao
            produtodb.updateExpFab(produto);
        }

        //   }
    }

    protected void eliminar(Produto produto) {

        produtodb = new Produtodb();

        produtodb.delete(produto);

    }

    protected void salvar(Produto produto) {

        produtodb = new Produtodb();

        boolean existeClassificacao = produtodb.contem(produto);

        if (existeClassificacao) {

            JOptionPane.showMessageDialog(null, "Impossível salvar esse produto.\nEsse produto já existe",
                    "SALVAR CLIENTE", JOptionPane.ERROR_MESSAGE);
        } else {

            produtodb = new Produtodb();

            produtodb.create(produto);

        }

    }

}
