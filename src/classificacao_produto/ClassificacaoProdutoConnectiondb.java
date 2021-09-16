package classificacao_produto;

import javax.swing.JOptionPane;

public class ClassificacaoProdutoConnectiondb {

    private ClassificacaoProdutodb classificacaodb;
    private ClassificacaoProduto classificacao;

    protected void salvar(String nomeDaClasse) {

        classificacao = new ClassificacaoProduto(nomeDaClasse);

        classificacaodb = new ClassificacaoProdutodb();

        boolean existeClassificacao = classificacaodb.contem(nomeDaClasse);

        if (existeClassificacao) {

            JOptionPane.showMessageDialog(null, "Impossível actualizar essa classe já existe",
                    "ACTUALIZAR CLASSE", JOptionPane.ERROR_MESSAGE);
        } else {
            
            classificacaodb = new ClassificacaoProdutodb();

            classificacaodb.create(classificacao);

        }

    }

    protected void actualizar(String novaClassificacao, String antigaClassificacao) {

        classificacaodb = new ClassificacaoProdutodb();

        boolean existeClassificacao = classificacaodb.contem(novaClassificacao);

        if (existeClassificacao) {

            JOptionPane.showMessageDialog(null, "Impossível actualizar essa classe já existe",
                    "ACTUALIZAR CLASSE", JOptionPane.ERROR_MESSAGE);
        } else {

            classificacaodb = new ClassificacaoProdutodb();
            classificacaodb.update(novaClassificacao, antigaClassificacao);

        }

    }

    protected void eliminar(String nomeDaClasseficacaoDoProduto) {

        classificacaodb = new ClassificacaoProdutodb();

        classificacaodb.delete(nomeDaClasseficacaoDoProduto);

    }

}
