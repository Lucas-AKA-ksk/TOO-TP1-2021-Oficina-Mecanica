package lucas.TP1.oficina;

/**
 * Classe que representa uma venda de Peças realizada pela oficina.
 *
 * @author Lucas Reis
 */
public class Peca {
	
	private String descricao;
	private Integer quantidade;
	private Double precoUnitario, precoTotal;
	
	/**
	 * Construtor da classe <code>Peca</code>
	 * 
	 * @param descricao descrição da peça;
	 * @param quantidade quantidade de peças vendidas;
	 * @param precoUnitario preço unitário da peça;
	 * @param precoTotal preço total da venda (preço unitário * quantidade).
	 */
	public Peca(String descricao, Integer quantidade, Double precoUnitario, Double precoTotal) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.precoTotal = precoTotal;
	}

	/**
	 * @return descrição atual da peça.
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao nova descrição da peça.
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return quantidade atual de peças vendidas
	 */
	public Integer getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade nova quantidade de peças vendidas
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * @return valor atual do preço unitário da peça vendida.
	 */
	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	/**
	 * @param precoUnitario novo preço unitário da peça vendida.
	 */
	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	/**
	 * @return preço total atual desta venda de peças.
	 */
	public Double getPrecoTotal() {
		return precoTotal;
	}

	/**
	 * @param precoTotal novo total atual desta venda de peças.
	 */
	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
}
