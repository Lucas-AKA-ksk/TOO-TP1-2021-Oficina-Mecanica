package lucas.TP1.oficina;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private String nome, cfp, email, telefone, endereco;
	private List<Automovel> automoveisList;
	
	public Cliente() {
		automoveisList = new ArrayList<>();
	}

	public Cliente(String nome, String cfp, String email, String telefone, String endereco) {
		this();
		this.nome = nome;
		this.cfp = cfp;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public final String getCfp() {
		return cfp;
	}

	public void setCfp(String cfp) {
		this.cfp = cfp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public List<Automovel> getAutomoveisList() {
		return automoveisList;
	}

	/**
	 * Adiciona um automóvel na lista de automoveis da Cliente 
	 * @param automovel 
	 */
	public void adicionarAutomovel(Automovel automovel) {
		this.automoveisList.add(automovel);
	}
	
	/**
	 * Obtem o número de automóveis do cliente
	 */
	public int obterNumeroDeAutomoveis() {
		return automoveisList.size();
	}
}
