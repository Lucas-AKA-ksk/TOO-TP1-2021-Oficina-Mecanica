package lucas.TP1.oficina;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que contém todas as informações de uma ordem de serviço.
 *
 * @author Lucas Reis
 */
public class OrdemDeServico {

	private String numero, data, hora, cpf, nome, codigo, modelo;
	private Double valorTotal; 
	private List<Servico> servicosList;
	private List<Peca> pecasList;
	
	/**
	 * Construtor da classe <code>OrdemDeServico</code>.
	 * 
	 * @param numero número da ordem de serviço;
	 * @param data data da criação da ordem de serviço;
	 * @param hora horário da criação da ordem de serviço;
	 * @param cpf CPF do cliente para o qual esta ordem foi realizada;
	 * @param nome nome do cliente para o qual esta ordem foi realizada;
	 * @param codigo código do automóvel no qual foram realizados os serviços;
	 * @param modelo modelo do automóvel no qual foram realizados os serviços;
	 */
	public OrdemDeServico(String numero, String data, String hora, String cpf, String nome,String codigo, String modelo) {
		this.numero = numero;
		this.data = data;
		this.hora = hora;
		this.cpf = cpf;
		this.nome = nome;
		this.codigo = codigo;
		this.modelo = modelo;
		servicosList = new ArrayList<>();
		pecasList = new ArrayList<>();
	}
	
	/**
	 * @return número da ordem de serviço.
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero novo número da ordem de serviço.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return data da criação/atualização da ordem de serviço;
	 */
	public String getData() {
		return data;
	}

	/**
	 * @param data nova data da criação/atualização da ordem de serviço;
	 */
	public void setData(String data) {
		this.data = data;
	}

	/**
	 * @return horário da criação/atualização da ordem de serviço;
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * @param hora novo horário da criação/atualização da ordem de serviço;
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * @return CPF do cliente para o qual esta ordem foi realizada;
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf novo CPF do cliente para o qual esta ordem foi realizada;
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return nome do cliente para o qual esta ordem foi realizada;
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome novo nome do cliente para o qual esta ordem foi realizada;
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return código do automóvel no qual foram realizados os serviços;
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo novo código do automóvel no qual foram realizados os serviços;
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return modelo do automóvel no qual foram realizados os serviços;
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo novo modelo do automóvel no qual foram realizados os serviços;
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return valor total dos serviços prestados e peças vendidas nesta ordem de serviço;
	 */
	public Double getValorTotal() {
		return valorTotal;
	}

	/**
	 * @param precoTotal novo valor total dos serviços prestados e peças vendidas nesta ordem de serviço;
	 */
	public void setValorTotal(Double precoTotal) {
		this.valorTotal = precoTotal;
	}
	
	/**
	 * Obtem a Descrição de um serviço da lista de serviços realizados.
.	 * 
	 * @param index index do serviço.
	 * 
	 * @return Descrição do serviço.
	 * 
	 * @see java.util.List#get(int)
	 */
	public String obterDescricaoDoServico(int index) {
		return servicosList.get(index).getDescricao();
	}
	
	/**
	 * Obtem o Preço de um serviço da lista de serviços realizados.
	 * 
	 * @param index index do serviço.
	 * 
	 * @return Preço do serviço.
	 * 
	 * @see java.util.List#get(int)
	 */
	public Double obterPrecoDoServico(int index) {
		return servicosList.get(index).getPreco();
	}
	
	/**
	 * Obtem a Descrição de uma peça da lista de peças vendidas.
	 * 
	 * @param index index da peça.
	 * 
	 * @return Descrição da peça.
	 * 
	 * @see java.util.List#get(int)
	 */
	public String obterDescricaoDaPeca(int index) {
		return pecasList.get(index).getDescricao();
	}
	
	/**
	 * Obtem a Quantidade de uma peça vendidas da lista de peças vendidas.
	 * 
	 * @param index index da peça.
	 * 
	 * @return Quantidade de peças.
	 * 
	 * @see java.util.List#get(int)
	 */
	public int obterQuantidadeDePecas(int index) {
		return pecasList.get(index).getQuantidade();
	}
	
	/**
	 * Obtem o Preço Unitário de uma peça da lista de peças vendidas.
	 * 
	 * @param index index da peça.
	 * 
	 * @return Preço Unitário da peça.
	 * 
	 * @see java.util.List#get(int)
	 */
	public Double obterPrecoUnitarioDaPeca(int index) {
		return pecasList.get(index).getPrecoUnitario();
	}
	
	/**
	 * Obtem o Preço Total de uma venda de peças da lista de peças vendidas.
	 * 
	 * @param index index da peça.
	 * 
	 * @return Preço Unitário da peça.
	 * 
	 * @see java.util.List#get(int)
	 */
	public Double obterPrecoTotalDasPecas(int index) {
		return pecasList.get(index).getPrecoTotal();
	}

	/**
	 * Adiciona um Serviço a esta ordem de serviços.
	 * 
	 * @param servico Objeto <code>Servico</code> que representa um serviço prestado.
	 * 
	 * @see java.util.List#add(Object)
	 */
	public void adicionarServico(Servico servico) {
		servicosList.add(servico);
	}
	
	/**
	 * Adiciona uma Venda de Peças (objeto <code>Peca</code>) a esta ordem de serviços.
	 * 
	 * 
	 * @param peca Objeto <code>Peca</code> que representa uma venda de peças.
	 * 
	 * @see java.util.List#add(Object)
	 */
	public void adicionarPeca(Peca peca) {
		pecasList.add(peca);
	}

	/**
	 * Obtem o número de serviços realizados nesta ordem de serviço.
	 * 
	 * @return quantidade de objetos <code>Servico</code> da <code>servicosList</code>
	 * 
	 * @see java.util.List#size()
	 */
	public int obterNumeroDeServicos() {
		return servicosList.size();
	}

	/**
	 * Obtem o número de vendas de peças realizadas nesta ordem de serviço.
	 * 
	 * @return uantidade de objetos <code>Peca</code> da <code>pecasList</code>
	 * 
	 * @see java.util.List#size()
	 */
	public int obterNumeroDePecas() {
		return pecasList.size();
	}

	/**
	 * Esvazia <code>servicosList</code>
	 * 
	 * @see java.util.List#clear()
	 */
	public void esvaziarListaDeServicos() {
		servicosList.clear();
	}

	/**
	 * Esvazia <code>pecasList</code>
	 * 
	 * @see java.util.List#clear()
	 */
	public void esvaziarListaDePecas() {
		pecasList.clear();
	}
}
