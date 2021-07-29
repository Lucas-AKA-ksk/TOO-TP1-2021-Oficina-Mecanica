package lucas.TP1.oficina;

import java.util.ArrayList;
import java.util.List;

import lucas.TP1.oficina.gui.IgMenuPrincipal;

public class Oficina {
	private List<Cliente> clientesList;
	private List<OrdemDeServico> ordensServicoList;
	
	public Oficina() {
		clientesList = new ArrayList<>();
		ordensServicoList = new ArrayList<>();
		new IgMenuPrincipal(this);
	}
	
	/**
	 * Inicia e exibe a interface gráfica do programa.
	 */
	public static void main(String[] args) {
		new Oficina();
	}
	
	/**
	 * Insere um cliente em uma lista de clientes. 
	 */
	public void cadastrarCliente(Cliente cliente) {
		clientesList.add(cliente);
	}
	
	/**
	 * Pesquisa o CPF de um cliente na lista de clientes.
	 * Retorna o cliente se o CPF estiver cadastrado ou null caso contrário.
	 */
	public Cliente pesquisarCPFCliente(String cpf) {
		for (Cliente cliente : clientesList) 
			if (cpf.equalsIgnoreCase(cliente.getCfp()))
					return cliente;
		return null;
	}
	
	/**
	 * Pesquisa o CPF informado na lista de clientes.
	 * Retorna true se o CPF estiver cadastrado ou false caso contrário.
	 */
	public boolean verificarCPFCliente(String cpf) {
		for (Cliente cliente : clientesList) 
			if (cpf.equalsIgnoreCase(cliente.getCfp()))
					return true;
		return false;
	}
	
	/**
	 * Pesquisa o nome de um cliente na lista de clientes.
	 * Retorna o cliente se o nome estiver cadastrado ou null caso contrário.
	 */
	public Cliente pesquisarNomeCliente(String nome) {
		for (Cliente cliente : clientesList) 
			if (nome.equalsIgnoreCase(cliente.getNome()))
					return cliente;
		return null;
	}
	
	/**
	 * Insere um ordem de serviço em uma lista de ordens de serviço. 
	 */
	public void cadastrarOrdemDeServico(OrdemDeServico ordemDeServico) {
		ordensServicoList.add(ordemDeServico);
	}
	
	/**
	 * Pesquisa o numero de uma ordem de serviço na lista de ordens de serviço.
	 * Retorna a ordem de serviço se o numero estiver cadastrado ou null caso contrário.
	 */
	public OrdemDeServico pesquisarNumeroDeOS(String numero) {
		for(OrdemDeServico ordemDeServico : ordensServicoList)
			if(numero.equals(ordemDeServico.getNumero()))
				return ordemDeServico;
		return null;
	}
	
	public int obterNumeroDeOrdensDeServico() {
		return ordensServicoList.size();
	}
}
