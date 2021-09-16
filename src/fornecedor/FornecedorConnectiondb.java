package fornecedor;

import javax.swing.JOptionPane;

public class FornecedorConnectiondb {

    private Fornecedordb fornecedordb;
    private Fornecedor fornecedor;

    protected void actualizar(Fornecedor fornecedor) {


//        boolean existeClassificacao = fornecedordb.contem(fornecedor);
//
//        if ( !existeClassificacao ) {
//
//            JOptionPane.showMessageDialog(null, "Impossível actualizar esse fornecedor.\n "
//                    + "O fornecedor {"+fornecedor.getNomeFornecedor()+"} já existe no banco de dados",
//                    "ACTUALIZAR FORNECEDOR", JOptionPane.ERROR_MESSAGE);
//        } else {

            fornecedordb = new Fornecedordb();

            fornecedordb.update(fornecedor);

//        }
    }

    protected void eliminar(int idFornecedor) {

        fornecedordb = new Fornecedordb();

        fornecedordb.delete(idFornecedor);

    }

    protected void salvar(Fornecedor fornecedor) {

        fornecedordb = new Fornecedordb();

        boolean existeClassificacao = fornecedordb.contem(fornecedor);

        if (existeClassificacao) {

            JOptionPane.showMessageDialog(null, "Impossível salvar esse fornecedor.\nEsse fornecedor já existe",
                    "SALVAR FORNECEDOR", JOptionPane.ERROR_MESSAGE);
        } else {

            fornecedordb = new Fornecedordb();

            fornecedordb.create(fornecedor);

        }

    }

}
