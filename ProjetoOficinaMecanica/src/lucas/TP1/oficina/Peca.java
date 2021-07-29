package lucas.TP1.oficina;

public class Peca {
	
	private String descricao;
	private Integer quantidade;
	private Double precoUnitario, precoTotal;
	
	public Peca(String descricao, Integer quantidade, Double precoUnitario, Double precoTotal) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.precoTotal = precoTotal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}
}
