package classificacao_produto;

    public class ClassificacaoProduto {

	private int idClassificacao;
	private String classeProduto;
	
        public ClassificacaoProduto(){}
        
	public ClassificacaoProduto( int idClassificacao ) {
		
		this.idClassificacao = idClassificacao;
		
	}
	
	public ClassificacaoProduto ( String classeProduto ) {
		
		this.classeProduto = classeProduto;
		
	}
	
	

	public ClassificacaoProduto(int idClassificacao, String classeProduto) {
		super();
		this.idClassificacao = idClassificacao;
		this.classeProduto = classeProduto;
	}

	public int getIdClassificacao() {
		return idClassificacao;
	}

	public void setIdClassificacao(int idClassificacao) {
		this.idClassificacao = idClassificacao;
	}

	public String getClasseProduto() {
		return classeProduto;
	}

	public void setClasseProduto(String classeProduto) {
		this.classeProduto = classeProduto;
	}
	
        
        public String toString (){
        
            return classeProduto;
        }
	
	
}
