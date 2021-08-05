package lucas.TP1.oficina;

import java.util.ArrayList;
import java.util.List;

import lucas.TP1.oficina.gui.IgMenuPrincipal;

/**
 * Classe que inicializa o funcionamento do programa,
 * cadastra e armazena os clientes e as ordens de serviço.
 *
 * @author Lucas Reis
 */
public class Oficina {
	private List<Cliente> clientesList;
	private List<OrdemDeServico> ordensServicoList;
	
	/**
	 * Construtor da classe <code>Oficina</code>. Inicializa as variáveis 
	 * <code>clientesList</code> e <code>ordensServicoList</code> e instancia
	 * uma Interface Gráfica <code>IgMenuPrincipal</code> com as operações disponíves
	 * para o usuário.
	 * 
	 * @see lucas.TP1.oficina.gui.IgMenuPrincipal
	 */
	public Oficina() {
		clientesList = new ArrayList<>();
		ordensServicoList = new ArrayList<>();
		new IgMenuPrincipal(this);
	}
	
	/**
	 * Inicia o aplicativo.
	 * 
	 * @param args este programa não utiliza parâmetros de linha de comando.
	 */
	public static void main(String[] args) {
		new Oficina();
	}
	
	/**
	 * Insere um cliente em uma lista de clientes.
	 * 
	 * @param cliente Objeto <code>Cliente</code> a ser inserido na lista.
	 */
	public void cadastrarCliente(Cliente cliente) {
		clientesList.add(cliente);
	}
	
	/**
	 * Pesquisa o CPF de um cliente na lista de clientes.
	 * Retorna o cliente se o CPF estiver cadastrado ou null caso contrário.
	 * 
	 * @param cpf CPF do cliente a ser pesquisado;
	 * 
	 * @return Objeto <code>Cliente</code> correspondente ao CPF pesquisado, ou <code>Null</code>
	 *  caso nenhum <code>Cliente</code> correspondente seja encontrado.
	 */
	public Cliente pesquisarClientePeloCPF(String cpf) {
		for (Cliente cliente : clientesList) 
			if (cpf.equalsIgnoreCase(cliente.getCfp()))
					return cliente;
		return null;
	}
	
	/**
	 * Verifica se o CPF informado corresponde a algum cliente na lista de clientes.
	 * 
	 * @param cpf CPF do cliente a ser verificado;
	 * 
	 * @return Retorna <code>true</code> se o CPF corresponder a um cliente cadastrado ou <code>false</code> caso contrário.
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
	 * 
	 * @param nome nome do cliente a ser pesquisado;
	 * 
	 * @return Objeto <code>Cliente</code> correspondente ao nome pesquisado, ou <code>Null</code>
	 * caso nenhum <code>Cliente</code> correspondente seja encontrado.
	 */
	public Cliente pesquisarClientePeloNome(String nome) {
		for (Cliente cliente : clientesList) 
			if (nome.equalsIgnoreCase(cliente.getNome()))
					return cliente;
		return null;
	}
	
	/**
	 * Insere um ordem de serviço em uma lista de ordens de serviço. 
	 * 
	 * @param ordemDeServico Objeto <code>OrdemDeServico</code> a ser inserido na lista.
	 */
	public void cadastrarOrdemDeServico(OrdemDeServico ordemDeServico) {
		ordensServicoList.add(ordemDeServico);
	}
	
	/**
	 * Pesquisa o número de uma ordem de serviço na lista de ordens de serviço.
	 * 
	 * @param numero número de uma ordem de serviço a ser pesquisada; 
	 * 
	 * @return Objeto <code>OrdemDeServico</code> correspondente ao número pesquisado, ou <code>Null</code>
	 * caso nenhum <code>OrdemDeServico</code> correspondente seja encontrado.
	 */
	public OrdemDeServico pesquisarNumeroDeOS(String numero) {
		for(OrdemDeServico ordemDeServico : ordensServicoList)
			if(numero.equals(ordemDeServico.getNumero()))
				return ordemDeServico;
		return null;
	}
	
	/**
	 * Verifica se o número fornecido corresponde à uma ordem de serviço na lista de Ordens de Serviço.
	 * 
	 * @param numero número a ser verificado;
	 * 
	 * @return <code>true</code> caso o número corresponda a uma ordem de serviço cadastrada ou <code>false</code> caso contrário.
	 */
	public boolean verificarNumeroDeOS(String numero) {
		for(OrdemDeServico ordemDeServico : ordensServicoList)
			if(numero.equals(ordemDeServico.getNumero()))
				return true;
		return false;
	}
	
	/**
	 * Obtem o número de Ordens de Serviço cadastradas.
	 * 
	 * @return a quantidade de ordens de serviço presentes em <code>ordensDeServicoList</code>.
	 * 
	 * @see java.util.List#size()
	 */
	public int obterNumeroDeOrdensDeServico() {
		return ordensServicoList.size();
	}

	/**
	 * Obtem a ordem de serviço no index fornecido.
	 * 
	 * @param index index da ordem de serviço a ser obtida.
	 * 
	 * @return Objeto <code>OrdemDeServico</code> armazenado no index fornecido.
	 * 
	 * @see java.util.List#get(int)
	 */
	public OrdemDeServico obterOrdemDeServico(int index) {
		return ordensServicoList.get(index);
	}
}
