package lucas.TP1.oficina;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que comtém todas as informações de um cliente.
 * 
 * @author Lucas Reis
 */
public class Cliente {
	
	private String nome, cfp, email, telefone, endereco;
	private List<Automovel> automoveisList;

	/**
	 * Construtor da classe <code>Cliente</code>
	 * 
	 * @param nome nome do cliente;
	 * @param cfp CPF do cliente;
	 * @param email email do cliente;
	 * @param telefone número de telefone do cliente;
	 * @param endereco endereço do cliente.
	 */
	public Cliente(String nome, String cfp, String email, String telefone, String endereco) {
		this.nome = nome;
		this.cfp = cfp;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		automoveisList = new ArrayList<>();
	}

	/**
	 * @return nome do cliente.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome novo nome atribuído ao cliente.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return cfp do cliente.
	 */
	public final String getCfp() {
		return cfp;
	}

	/**
	 * @param cfp novo CPF atribuído ao cliente
	 */
	public void setCfp(String cfp) {
		this.cfp = cfp;
	}

	/**
	 * @return email do cliente
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email novo email atribuído ao cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return telefone do cliente
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * @param telefone novo número de telefone atribuído ao cliente
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * @return endereço do cliente
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @param endereco novo endereço atribuído ao cliente
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	/**
	 * Realiza uma cópia em profundidade da lista de automóveis do cliente.
	 * 
	 * @return uma cópia de <code>automoveisList</code>.
	 */
	public List<Automovel> copiarListaDeAutomoveis(){
		
		List<Automovel> copiaDaLista = new ArrayList<>();
		
		for(Automovel automovel : automoveisList)
			copiaDaLista.add(automovel.copy());
		
		return copiaDaLista;
	}
	
	/**
	 * Obtem da lista de automóveis do cliente o modelo do carro
	 * correspondente ao index fornecido.
	 * 
	 * @param index index do automóvel na lista.
	 * 
	 * @return nome do modelo do automóvel
	 */
	public String obterModeloAutomovel(int index) {
		return automoveisList.get(index).getModelo();
	}

	/**
	 * Adiciona um automóvel na lista de automoveis da Cliente.
	 * 
	 * @param automovel Objeto <code>Automovel</code> a ser adicionado na lista.
	 */
	public void adicionarAutomovel(Automovel automovel) {
		this.automoveisList.add(automovel);
	}
	
	/**
	 * Obtem o número de automóveis do cliente.
	 * 
	 * @return a quantidade de automóveis presentes em <code>automoveisList</code>.
	 */
	public int obterNumeroDeAutomoveis() {
		return automoveisList.size();
	}
}
