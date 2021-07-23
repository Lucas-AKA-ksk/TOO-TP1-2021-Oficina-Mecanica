package lucas.TP1.oficina;

import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.util.ArrayList;
import java.util.List;

import lucas.TP1.oficina.gui.IgMenuPrincipal;

public class Oficina {
	private List<Cliente> clientesList;
	private IgMenuPrincipal igMenuPrincipal;
	
	public Oficina() {
		clientesList = new ArrayList<>();
		
		igMenuPrincipal = new IgMenuPrincipal(this);
	}
	
	/**
	 * Inicia e exibe a interface gráfica do programa.
	 */
	public static void main(String[] args) {
		new Oficina();
	}
	
	/**
	 * Insere o cliente em uma lista de clientes. 
	 */
	public void cadastrarCliente(Cliente cliente) {
		clientesList.add(cliente);
		showMessageDialog(igMenuPrincipal, String.format("Cliente cadastrado com %d carros.", cliente.obterNumeroDeAutomoveis()), "Cadastrar Cliente", INFORMATION_MESSAGE);
	}
	
	/**
	 * Pesquisa o nome de um cliente na lista de clientes.
	 * Retorna o cliente se o nome estiver cadastrado ou null caso contrário.
	 */
	public Cliente pesquisarCliente(String nome) {
		for (Cliente cliente : clientesList) 
			if (nome.equalsIgnoreCase(cliente.getNome()))
					return cliente;
		return null;
	}
}
