package lucas.TP1.oficina;

public class Servico {
	
	private String Descricao;
	private Double preco;
	
	public Servico(String descricao, Double preco) {
		Descricao = descricao;
		this.preco = preco;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
