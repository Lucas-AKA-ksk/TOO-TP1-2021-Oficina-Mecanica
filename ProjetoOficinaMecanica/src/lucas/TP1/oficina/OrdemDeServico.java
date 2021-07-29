package lucas.TP1.oficina;

import java.util.ArrayList;
import java.util.List;

public class OrdemDeServico {

	private String numero, data, hora, cpf, nome, modelo;
	private Double valorTotal; 
	private List<Servico> listaDeServicos;
	private List<Peca> listaDePecas;
	
	public OrdemDeServico() {
		listaDeServicos = new ArrayList<>();
		listaDePecas = new ArrayList<>();
	}
	
	public OrdemDeServico(String numero, String data, String hora, String cpf, String nome, String modelo, Double valorTotal) {
		this();
		this.numero = numero;
		this.data = data;
		this.hora = hora;
		this.cpf = cpf;
		this.nome = nome;
		this.modelo = modelo;
		this.valorTotal = valorTotal;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double precoTotal) {
		this.valorTotal = precoTotal;
	}
	
	/**
	 * Obtem a Descrição de um serviço da lista de serviços 
	 * desta ordem de serviço.
	 * @param index index do serviço.
	 * @return Descrição do serviço.
	 */
	public String obterDescricaoDoServico(int index) {
		return listaDeServicos.get(index).getDescricao();
	}
	
	/**
	 * Obtem o Preço de um serviço da lista de serviços
	 * desta ordem de serviço.
	 * @param index index do serviço.
	 * @return Preço do serviço.
	 */
	public Double obterPrecoDoServico(int index) {
		return listaDeServicos.get(index).getPreco();
	}
	
	/**
	 * Obtem a Descrição de uma peça da lista de peças 
	 * desta ordem de serviço.
	 * @param index index da peça.
	 * @return Descrição da peça.
	 */
	public String obterDescricaoDaPeca(int index) {
		return listaDePecas.get(index).getDescricao();
	}
	
	/**
	 * Obtem a Quantidade de uma peça da lista de peças 
	 * desta ordem de serviço.
	 * @param index index da peça.
	 * @return Quantidade de peças.
	 */
	public int obterQuantidadeDePecas(int index) {
		return listaDePecas.get(index).getQuantidade();
	}
	
	/**
	 * Obtem o Preço Unitário de uma peça da lista de peças
	 * desta ordem de serviço.
	 * @param index index da peça.
	 * @return Preço Unitário da peça.
	 */
	public Double obterPrecoUnitarioDaPeca(int index) {
		return listaDePecas.get(index).getPrecoUnitario();
	}
	
	/**
	 * Obtem o Preço Total de uma peça da lista de peças
	 * desta ordem de serviço.
	 * @param index index da peça.
	 * @return Preço Unitário da peça.
	 */
	public Double obterPrecoTotalDasPecas(int index) {
		return listaDePecas.get(index).getPrecoTotal();
	}

	public List<Peca> getListaDePecas() {
		return listaDePecas;
	}

	public void adicionarServico(Servico servico) {
		listaDeServicos.add(servico);
	}
	
	public void adicionarPeca(Peca peca) {
		listaDePecas.add(peca);
	}

	public int obterNumeroDeServicos() {
		return listaDeServicos.size();
	}

	public int obterNumeroDePecas() {
		return listaDePecas.size();
	}
}
