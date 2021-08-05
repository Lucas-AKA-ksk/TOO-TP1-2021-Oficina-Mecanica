package lucas.TP1.oficina;

/**
 * Classe que representa um Serviço realizado pela oficina.
 *
 * @author Lucas Reis
 */
public class Servico {
	
	private String Descricao;
	private Double preco;
	
	/**
	 * Construtor da classe <code>Servico</code>.
	 * 
	 * @param descricao descrição do serviço realizado;
	 * @param preco preço do serviço realizado.
	 */
	public Servico(String descricao, Double preco) {
		Descricao = descricao;
		this.preco = preco;
	}

	/**
	 * @return descrição atual do serviço.
	 */
	public String getDescricao() {
		return Descricao;
	}

	/**
	 * @param descricao nova descrição para o serviço realizado.
	 */
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	/**
	 * @return preço atual do serviço realizado.
	 */
	public Double getPreco() {
		return preco;
	}

	/**
	 * @param preco novo preço do serviço realizado.
	 */
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
