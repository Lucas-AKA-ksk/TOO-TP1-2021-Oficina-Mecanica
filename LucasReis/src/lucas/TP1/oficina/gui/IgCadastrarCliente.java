package lucas.TP1.oficina.gui;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import lucas.TP1.oficina.Automovel;
import lucas.TP1.oficina.Cliente;
import lucas.TP1.oficina.Oficina;
import net.miginfocom.swing.MigLayout;

/**
 * Classe que representa o menu de cadastro de Clientes,
 * onde operações de cadastro e pesquisa de clientes pode ser realizado
 * através de uma Interface Gráfica.
 * 
 * @author Lucas Reis
 */
@SuppressWarnings("serial")
public class IgCadastrarCliente extends JDialog {
	
	private JTextField emailTextField;
	private JTextField telefoneTextField;
	private JTextField cpfTextField;
	private JTextField nomeTextField;
	private JTextField modeloTextField;
	private JTextField quilometragemTextField;
	private JTextField placaTextField;
	private JTextArea enderecoTextArea;
	private JComboBox<String> combustivelComboBox;
	private JComboBox<String> anoModeloComboBox;
	private JComboBox<String> marcaComboBox;
	private JComboBox<String> codigoComboBox;
	private List<Automovel> listaDeAutomoveisTemporaria;
	private Oficina oficina;

	/**
	 * Construtor da classe <code>IgCadastrarCliente</code>
	 * 
	 * @param oficina objeto do tipo <code>Oficina</code>
	 * para que esta classe invoque os métodos da mesma.
	 */
	public IgCadastrarCliente(Oficina oficina) {
		this.oficina = oficina;
		
		this.listaDeAutomoveisTemporaria = new ArrayList<>();
		
		// Desabilita o redimensionamento
		setResizable(false);
		
		// Título, tamanho e layout
		setTitle("Cliente e Automóvel");
		setSize(714, 488);
		getContentPane().setLayout(new MigLayout("", "[390.00px,grow][390.00px,grow]", "[38px][][][grow][][][][][][grow][][][][][][][][]"));
		
		// Painel de Clientes
		JPanel clientePanel = new JPanel();
		clientePanel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(clientePanel, "cell 0 0 1 17,grow");
		clientePanel.setLayout(new MigLayout("", "[52.00][250.00,fill]", "[119.00][][][][grow]"));
			
		// Subpainel de pesquisa de cliente
		JPanel pesquisaClientePanel = new JPanel();
		pesquisaClientePanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		clientePanel.add(pesquisaClientePanel, "cell 0 0 2 1,grow");
		pesquisaClientePanel.setLayout(new MigLayout("", "[][grow]", "[][][]"));
				
		// Label de CPF
		JLabel cpfLabel = new JLabel("CPF:");
		cpfLabel.setDisplayedMnemonic(KeyEvent.VK_F);
		pesquisaClientePanel.add(cpfLabel, "cell 0 0,alignx left");
		cpfLabel.setLabelFor(cpfTextField);
		
		// TextField para CPF
		cpfTextField = new JTextField();
		pesquisaClientePanel.add(cpfTextField, "cell 1 0,alignx left");
		cpfTextField.setColumns(10);
		cpfTextField.addActionListener((e) -> pesquisarCliente() );
				
		// Label do Nome do CLiente
		JLabel nomeLabel = new JLabel("Nome: ");
		nomeLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		pesquisaClientePanel.add(nomeLabel, "cell 0 1,alignx left");
		nomeLabel.setLabelFor(nomeTextField);
					
		// TextField para o Nome
		nomeTextField = new JTextField();
		pesquisaClientePanel.add(nomeTextField, "cell 1 1,growx");
		nomeTextField.setColumns(10);
		nomeTextField.addActionListener((e) -> pesquisarCliente() );
				
		// Botão Pesquisar
		JButton pesquisarButton = new JButton("Pesquisar");
		pesquisarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarCliente();
			}
		});
		pesquisarButton.setMnemonic(KeyEvent.VK_P);
		pesquisaClientePanel.add(pesquisarButton, "cell 1 2,alignx right");
				
		// Label do email
		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setDisplayedMnemonic(KeyEvent.VK_I);
		clientePanel.add(emailLabel, "cell 0 1,alignx left");
		emailLabel.setLabelFor(emailTextField);
				
		// TextField do email
		emailTextField = new JTextField();
		clientePanel.add(emailTextField, "cell 1 1,grow");
		emailTextField.setColumns(10);
			
		// Label do telefone
		JLabel telefoneLabel = new JLabel("Telefone: ");
		telefoneLabel.setDisplayedMnemonic(KeyEvent.VK_T);
		clientePanel.add(telefoneLabel, "cell 0 2,alignx left");
		telefoneLabel.setLabelFor(telefoneTextField);
		
		// TextField do telefone
		telefoneTextField = new JTextField();
		clientePanel.add(telefoneTextField, "cell 1 2,alignx left");
		telefoneTextField.setColumns(10);
			
		// Label do endereço
		JLabel enderecoLabel = new JLabel("Endereço:");
		enderecoLabel.setDisplayedMnemonic(KeyEvent.VK_E);
		clientePanel.add(enderecoLabel, "cell 0 3,alignx left");
		enderecoLabel.setLabelFor(enderecoTextArea);
			
		// TextArea do endereço
		enderecoTextArea = new JTextArea();
		enderecoTextArea.setLineWrap(true);
		clientePanel.add(enderecoTextArea, "cell 0 4 2 1,grow");
		
		// Painel de automóvel
		JPanel automovelPanel = new JPanel();
		automovelPanel.setBorder(new TitledBorder(null, "Autom\u00F3vel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		getContentPane().add(automovelPanel, "cell 1 0 1 17,grow");
		automovelPanel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][][][][]"));
			
		// Label do código do automóvel
		JLabel codigoLabel = new JLabel("Código:");
		codigoLabel.setDisplayedMnemonic(KeyEvent.VK_C);
		automovelPanel.add(codigoLabel, "cell 0 0,alignx left");
		codigoLabel.setLabelFor(codigoComboBox);
		
		// ComboBox do código do automóvel
		codigoComboBox = new JComboBox<>();
		codigoComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					preencherCamposDoAutomovel(codigoComboBox.getSelectedIndex());
			}
		});
		automovelPanel.add(codigoComboBox, "cell 1 0,alignx left");
			
		// Label da Marca do automóvel
		JLabel marcaLabel = new JLabel("Marca:");
		marcaLabel.setDisplayedMnemonic(KeyEvent.VK_R);
		automovelPanel.add(marcaLabel, "cell 0 1,alignx left");
		marcaLabel.setLabelFor(marcaComboBox);
		
		// ComboBox da MArca do automóvel
		marcaComboBox = new JComboBox<>();
		marcaComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Acura", "Alfa Romeo", "Aston Martin", "Audi", "BAC",
				"BMW", "Bentley", "Bizzarrini", "Bowler", "Bugatti",
				"Buick", "Cadillac", "Chevrolet", "Chrysler", "Citroën",
				"Datsun", "Dodge", "Ferrari", "Fiat", "Ford", "GMC",
				"General Motors", "Hennessey", "Honda", "Hummer",
				"Hyundai", "Infiniti", "Iveco", "JAC", "Jaguar", "Jawa",
				"Jeep", "Jensen", "KTM", "Kia", "Koenigsegg",
				"Lada", "Lamborghini", "Lancia", "Land Rover", "Lexus",
				"Lotus", "Maserati", "Mastretta", "Maxus", "Maybach",
				"Mazda", "McLaren", "Mercedes-Benz", "Mini",
				"Mitsubishi", "Nissan", "Opel", "Pagani", "Peugeot",
				"Plymouth", "Pontiac", "Porsche", "Renault", "Rolls-Royce",
				"Saleen", "Scania", "Subaru", "Suzuki", "TVR",
				"Tesla", "Toyota", "Troller", "Vauxhall",
				"Volkswagen", "Volvo"}));
		marcaComboBox.setSelectedIndex(47);
		automovelPanel.add(marcaComboBox, "cell 1 1,alignx left");
			
		// Label do Modelo
		JLabel modeloLabel = new JLabel("Modelo:");
		modeloLabel.setDisplayedMnemonic(KeyEvent.VK_M);
		automovelPanel.add(modeloLabel, "cell 0 2,alignx left");
				
		// TextField do Modelo
		modeloTextField = new JTextField();
		modeloLabel.setLabelFor(modeloTextField);
		automovelPanel.add(modeloTextField, "cell 1 2,growx");
		modeloTextField.setColumns(10);
			
		// Label do Ano
		JLabel anoModeloLabel = new JLabel("Ano Modelo:");
		anoModeloLabel.setDisplayedMnemonic(KeyEvent.VK_A);
		automovelPanel.add(anoModeloLabel, "cell 0 3,alignx left");
		anoModeloLabel.setLabelFor(anoModeloComboBox);
		
		// Combobox do ano
		anoModeloComboBox = new JComboBox<>();
		anoModeloComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {
				"2021", "2020", "2019", "2018",
				"2017", "2016", "2015", "2014",
				"2013", "2012", "2011", "2010",
				"2009", "2008", "2007", "2006",
				"2005", "2004", "2003", "2002",
				"2001", "2000", "1999", "1998",
				"1997", "1996", "1995", "1994",
				"1993", "1992", "1991", "1990",
				"1989", "1988", "1987", "1986",
				"1985", "1984", "1983", "1982",
				"1981", "1980", "1979", "1978",
				"1977", "1976", "1975", "1974",
				"1973", "1972", "1971", "1970",
				"1969", "1968", "1967", "1966",
				"1965", "1964", "1963", "1962",
				"1961", "1960", "1959", "1958",
				"1957", "1956", "1955", "1954",
				"1953", "1952", "1951", "1950",
				"1949", "1948", "1947", "1946",
				"1945", "1944", "1943", "1942",
				"1941", "1940", "1939", "1938",
				"1937", "1936", "1935", "1934",
				"1933", "1932", "1931", "1930",
				"1929", "1928", "1927", "1926",
				"1925", "1924", "1923", "1922",
				"1921", "1920", "1919", "1918",
				"1917", "1916", "1915", "1914",
				"1913", "1912", "1911", "1910",
				"1909", "1908", "1907", "1906",
				"1905", "1904", "1903", "1902",
				"1901", "1900"}));
		automovelPanel.add(anoModeloComboBox, "cell 1 3,alignx left");
			
		// Label do tipo de combustível
		JLabel combustivelLabel = new JLabel("Combustível:");
		combustivelLabel.setDisplayedMnemonic(KeyEvent.VK_B);
		automovelPanel.add(combustivelLabel, "cell 0 4,alignx left");
		combustivelLabel.setLabelFor(combustivelComboBox);
		
		// ComboBox do combustível
		combustivelComboBox = new JComboBox<>();
		combustivelComboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Diesel", "Elétrico", "Ethanol", "Ethanol e/ou Gasolina", "Gasolina", "GNV"}));
		combustivelComboBox.setSelectedIndex(3);
		automovelPanel.add(combustivelComboBox, "cell 1 4,alignx left");
			
		// Label da Quilometragem
		JLabel quilometragemLabel = new JLabel("Quilometragem:");
		quilometragemLabel.setDisplayedMnemonic(KeyEvent.VK_Q);
		automovelPanel.add(quilometragemLabel, "cell 0 5,alignx left");
		
		// TextField da Quilometragem
		quilometragemTextField = new JTextField();
		quilometragemLabel.setLabelFor(quilometragemTextField);
		quilometragemTextField.setColumns(10);
		automovelPanel.add(quilometragemTextField, "flowx,cell 1 5,alignx left");
			
		// Label da Placa do veículo
		JLabel placaLabel = new JLabel("Placa:");
		placaLabel.setDisplayedMnemonic(KeyEvent.VK_L);
		automovelPanel.add(placaLabel, "cell 0 6,alignx left");
		
		// TextField da Placa do veículo
		placaTextField = new JTextField();
		placaLabel.setLabelFor(placaTextField);
		placaTextField.setColumns(10);
		automovelPanel.add(placaTextField, "cell 1 6,alignx left");
			
		// Botão adicionar automóvel
		JButton addAutomovelButton = new JButton("Adicionar Automóvel");
		addAutomovelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarAutomovelNaListaTemporaria();
			}
		});
		addAutomovelButton.setMnemonic(KeyEvent.VK_D);
		automovelPanel.add(addAutomovelButton, "cell 1 11,alignx right");
			
		// Label decorativa de KM
		JLabel kmLabel = new JLabel("KM");
		automovelPanel.add(kmLabel, "cell 1 5,alignx left");
			
		
		// Painel de botões inferior
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, "cell 0 17 2 1,growx,aligny top");
			
		// Botão Gravar
		JButton gravarButton = new JButton("Gravar");
		gravarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente();
			}
		});
		gravarButton.setMnemonic(KeyEvent.VK_G);
		buttonPane.add(gravarButton);
			
		// Botão Gerar Ordem de Serviço
		JButton ordemServicoButton = new JButton("Gerar Ordem de Serviço");
		ordemServicoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(verificarDadosCliente(cpfTextField.getText(), nomeTextField.getText(),
						emailTextField.getText(), telefoneTextField.getText(),
						enderecoTextArea.getText())/* && !listaDeAutomoveisTemporaria.isEmpty()*/) {
					
					if(!oficina.verificarCPFCliente(cpfTextField.getText().replaceAll("\\D", ""))) 
						cadastrarCliente();
						
					new IgOrdemDeServico(oficina, cpfTextField.getText().replaceAll("\\D", ""), nomeTextField.getText(),
							oficina.pesquisarClientePeloCPF(cpfTextField.getText().replaceAll("\\D", "")).copiarListaDeAutomoveis());
					dispose();
					
				}
				else
					showMessageDialog(null, "Não é possível realizar ordens de serviço com dados\n não verificados,"
							+ " pesquise os dados do cliente antes", "Cadastrar Cliente", ERROR_MESSAGE);
			}
		});
		ordemServicoButton.setMnemonic(KeyEvent.VK_O);
		buttonPane.add(ordemServicoButton);
			
		// Botão Cancelar
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPane.add(cancelarButton);
			
		
		// Configura a caixa de dialogo para que ela seja liberada para o sistema quando for fechada
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Centraliza a caixa de diálogo
		setLocationRelativeTo(this);
		
		// Exibe a caixa de diálogo.
		setVisible(true);
	}

	/**
	 * Obtem os dados do cliente e de seus carros da interface gráfica e os cadastra
	 */
	private void cadastrarCliente() {

		String cpf = cpfTextField.getText().replaceAll("\\D", ""),
				nomeCliente = nomeTextField.getText(), 
				email = emailTextField.getText(),
				telefone = telefoneTextField.getText(),
				endereco = enderecoTextArea.getText();
		
		Cliente novoCliente;
		
		if(verificarDadosCliente(cpf, nomeCliente, email, telefone, endereco)) {
							
			//Verifica se o CPF já está cadastrado no sistema ou não
			if(!oficina.verificarCPFCliente(cpf)) {
				
				novoCliente = new Cliente(nomeCliente, cpf, email, telefone, endereco);
			
				/* Verificar se a lista de automoveis temporaria não está vazia,
				 * se não estiver, adiciona o cliente a lista de clientes e adiciona
				 * cada automóvel da lista temporária na lista de automóveis do cliente */
				if(!listaDeAutomoveisTemporaria.isEmpty()) {
					
					for(Automovel automovel : listaDeAutomoveisTemporaria) {
						novoCliente.adicionarAutomovel(automovel);
					}
					
					oficina.cadastrarCliente(novoCliente);
					showMessageDialog(this, String.format("Cliente cadastrado com %d carros.", novoCliente.obterNumeroDeAutomoveis()), "Cadastrar Cliente", INFORMATION_MESSAGE);

					// Preenche os campos de dados do automóvel com os automóveis do novo cliente (cópias)
					preencherCamposDoAutomovel(novoCliente, 0);
				}
				/* Caso a lista temporária de automóveis esteja vazia, checa os campos
				 * de dados de automóvel, e caso tenham dados preenchidos, cria um novo
				 * objeto Automovel para relacionar ao Cliente, pois é obrigatório que o
				 * mesmo tenha pelo menos um automóvel cadastrado */
				else {
					String codigo = String.format("A%d", listaDeAutomoveisTemporaria.size() + 1),
							marca = marcaComboBox.getItemAt(marcaComboBox.getSelectedIndex()),
							modelo = modeloTextField.getText(),
							anoModelo = anoModeloComboBox.getItemAt(anoModeloComboBox.getSelectedIndex()),
							combustivel = combustivelComboBox.getItemAt(combustivelComboBox.getSelectedIndex()),
							quilometragem = quilometragemTextField.getText(),
							placa = placaTextField.getText();
					
					if(verificarDadosAutomovel(modelo, quilometragem, placa)) {
						novoCliente.adicionarAutomovel(new Automovel(codigo, marca, modelo, anoModelo, combustivel, placa, Integer.valueOf(quilometragem)));
						oficina.cadastrarCliente(novoCliente);
						showMessageDialog(this, String.format("Cliente cadastrado com %d carros.", novoCliente.obterNumeroDeAutomoveis()), "Cadastrar Cliente", INFORMATION_MESSAGE);
					}
				}
			}
			else
				showMessageDialog(this, "CPF já cadastrado no sistema.", "Cadastrar Cliente", ERROR_MESSAGE);
		}
	}
	
	/**
	 * Obtem dados do painel de Automóveis e os adiciona em uma lista de automóveis temporária
	 */
	private void adicionarAutomovelNaListaTemporaria() {
		
		String codigo = String.format("A%d", listaDeAutomoveisTemporaria.size() + 1),
				marca = marcaComboBox.getItemAt(marcaComboBox.getSelectedIndex()),
				modelo = modeloTextField.getText(),
				anoModelo = anoModeloComboBox.getItemAt(anoModeloComboBox.getSelectedIndex()),
				combustivel = combustivelComboBox.getItemAt(combustivelComboBox.getSelectedIndex()),
				quilometragem = quilometragemTextField.getText(),
				placa = placaTextField.getText();
		
		if(verificarDadosAutomovel(modelo, quilometragem, placa)) {
			listaDeAutomoveisTemporaria.add(new Automovel(codigo, marca, modelo, anoModelo, combustivel, placa, Integer.valueOf(quilometragem)));
			showMessageDialog(this, "Carro adicionado a lista de pré cadastro\nconfirme o cadastro do cliente para concluir a operação.", "Cadastrar Cliente", INFORMATION_MESSAGE);		}
	}
	
	/**
	 * Pesquisa por um cliente já cadastrado com base no CPF
	 * ou Nome inseridos na GUI, caso encontre, preenche a tela com
	 * seus dados e os dados de seus automóveis
	 */
	private void pesquisarCliente() {
		
		String cpf = cpfTextField.getText(),
				nomeCliente = nomeTextField.getText();
		Cliente clientePesquisado;
		
		if(!cpf.isBlank())
			clientePesquisado = oficina.pesquisarClientePeloCPF(cpf);
		else if(!nomeCliente.isBlank())
			clientePesquisado = oficina.pesquisarClientePeloNome(nomeCliente);
		else {
			showMessageDialog(this, "Campos de CPF e nome vazios.", "Cadastrar Cliente", ERROR_MESSAGE);
			return;
		}
		
		if(clientePesquisado != null)
			preencherCamposDaTela(clientePesquisado);
		else
			showMessageDialog(this, "Cliente não encontrado", "Cadastrar Cliente", ERROR_MESSAGE);
		
	}
	
	/**
	 * Preenche os campos dos dados do cliente, 
	 * @param cliente Objeto <code>Cliente</code> usado para preencher a GUI.
	 */
	private void preencherCamposDaTela(Cliente cliente) {
		
		preencherCamposDoCliente(cliente);
		
//		// Esvazia o ComboBox de códigos
//		codigoComboBox.removeAllItems();
//		
//		// Preenche a lista temporária com cópias dos objetos Automovel
//		listaDeAutomoveisTemporaria = cliente.copiarListaDeAutomoveis();
//		
//		// Preenche o ComboBox de códigos com os códigos dos carros do cliente
//		for(Automovel automovel : listaDeAutomoveisTemporaria)
//			codigoComboBox.addItem(automovel.getCodigo());
		
		// Preenche os campos do automovel da GUI com os dados do primeiro automóvel do cliente
		preencherCamposDoAutomovel(cliente, 0);
		
	}
	
	/**
	 * Configura os campos dos dados do cliente com os dados adquiridos
	 * do parâmetro cliente.
	 * 
	 * @param cliente Objeto <code>Cliente</code> usado para preencher a GUI.
	 */
	private void preencherCamposDoCliente(Cliente cliente){
		
		cpfTextField.setText(cliente.getCfp());
		nomeTextField.setText(cliente.getNome());
		emailTextField.setText(cliente.getEmail());
		telefoneTextField.setText(cliente.getTelefone());
		enderecoTextArea.setText(cliente.getEndereco());
	}
	
	/**
	 * Altera a <code>listaDeAutomoveisTemporaria</code> fazendo que a mesma referencie uma cópia
	 * da lista de automóveis de um cliente.
	 * Configura os campos dos dados do automóvel com as informações do automóvel
	 * no index especificado da <code>listaDeAutomoveisTemporaria</code>.
	 * 
	 * @param cliente cliente do qual será obtida a cópia da lista de automóveis;
	 * @param index index de <code>listaDeAutomoveisTemporaria</code> com as informações para preencher os campos.
	 */
	private void preencherCamposDoAutomovel(Cliente cliente, int index) {
		
		// Esvazia o ComboBox de códigos
		codigoComboBox.removeAllItems();
		
		// Preenche a lista temporária com cópias dos objetos Automovel
		listaDeAutomoveisTemporaria = cliente.copiarListaDeAutomoveis();
		
		// Preenche o ComboBox de códigos com os códigos dos carros do cliente
		for(Automovel automovel : listaDeAutomoveisTemporaria)
			codigoComboBox.addItem(automovel.getCodigo());
		
		preencherCamposDoAutomovel(index);
	}
	
	/**
	 * Configura os campos dos dados do automóvel com as informações do automóvel
	 * no index especificado da <code>listaDeAutomoveisTemporaria</code>.
	 * 
	 * @param index index de <code>listaDeAutomoveisTemporaria</code> com as informações para preencher os campos.
	 */
	private void preencherCamposDoAutomovel(int index) {
		
		marcaComboBox.setSelectedItem(listaDeAutomoveisTemporaria.get(index).getMarca());
		modeloTextField.setText(listaDeAutomoveisTemporaria.get(index).getModelo());
		anoModeloComboBox.setSelectedItem(listaDeAutomoveisTemporaria.get(index).getAnoModelo());
		combustivelComboBox.setSelectedItem(listaDeAutomoveisTemporaria.get(index).getCombustivel());
		quilometragemTextField.setText(listaDeAutomoveisTemporaria.get(index).getQuilometragem().toString());
		placaTextField.setText(listaDeAutomoveisTemporaria.get(index).getPlaca());
	}
		

	/**
	 * Realiza as verificações necessárias nos campos preenchiveis de um cliente,
	 * e mostra janelas de erro apropriadas para cada validação que falhe.
	 * 
	 * As validações são: <br>
	 * - Campos não podem estar vazios; <br>
	 * - <code>cpf</code> deve conformar a expressão regular "([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})"
	 * que é validada para CPF digitado nos formatos 123.456.789-10 e 12345678910, ou seja, com ou sem os caracteres separadores; <br>
	 * - <code>email</code> deve conformar com a expressão regular "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$"
	 * que é validada para adequar a RFC 5322. <br>
	 * - <code>telefone</code> deve conformar com a expressão regular "\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}" que é validada para telefones no formato (xx)Xxxxx-xxxx (X sendo opcional).
	 * 
	 * @param cpf cpf fornecido para verificação;
	 * @param nome nome fornecido para verificação;
	 * @param email email fornecido para verificação;
	 * @param telefone telefone fornecido para verificação;
	 * @param endereco endereço fornecido para verificação.
	 * 
	 * @return <code>true</code> se todas as validações forem bem-sucedidas, <code>false</code> caso falhe alguma delas.
	 */
	private boolean verificarDadosCliente(String cpf, String nome, String email, String telefone, String endereco) {
		
		// Verificações dos campos com dados do Cliente quanto a se então em branco ou não
		if(cpf.isBlank()) {
			showMessageDialog(this, "Você deve preencher o CPF do cliente.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		if(nome.isBlank()) {
			showMessageDialog(this, "Você deve preencher o Nome do cliente.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		if(email.isBlank()) {
			showMessageDialog(this, "Você deve preencher o Email do cliente.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		if(telefone.isBlank()) {
			showMessageDialog(this, "Você deve preencher o Telefone do cliente.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		if(endereco.isBlank()) {
			showMessageDialog(this, "Você deve preencher o Endereço do cliente.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		
		// Verificações de formato do cpf, email e telefone usando regex
		if(!validarString(cpf,"([0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2})")) {
			showMessageDialog(this, "CPF inválido.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		if(!validarString(email,"^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")) {
			showMessageDialog(this, "Email inválido.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		if(!validarString(telefone,"\\([0-9]{2}\\)[0-9]{4,5}-[0-9]{4}")) {
			showMessageDialog(this, "Telefone inválido.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Realiza as verificações necessárias nos campos preenchiveis de um automóvel,
	 * e mostra janelas de erro apropriadas para cada validação que falhe (de apenas uma, a primeira encontrada).
	 * <br>
	 * As validações são: <br>
	 * - Campos não podem estar vazios; <br>
	 * - <code>quilometragem</code> deve ser um valor númerico do tipo inteiro; <br>
	 * - <code>placa</code> deve conformar com a expressão regular "([a-zA-z]{3}-?\\d{4})|([a-zA-Z]{3}\\d[a-zA-Z]\\d{2})"
	 * que é validada para os formatos de emplacamento veícular comuns "abc-1234" ou padrão mercosul "abc1d23".
	 * 
	 * @param modelo modelo do veículo fornecido para verificação;
	 * @param quilometragem valor de quilometragem fornecido para verificação;
	 * @param placa numeração da placa fornecido para validação 
	 * 
	 * @return <code>true</code> se passar em todas as verificações, <code>false</code> caso falhe qualquer uma delas.
	 * 
	 * @see javax.swing.JOptionPane#showMessageDialog
	 */
	private boolean verificarDadosAutomovel(String modelo, String quilometragem, String placa) {
		
		// Verificações dos campos preenchiveis com dados do Automóvel quanto a se então em branco ou não
		if(modelo.isBlank()) {
			showMessageDialog(this, "Você deve preencher o Modelo do automóvel.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		if(quilometragem.isBlank()) {
			showMessageDialog(this, "Você deve preencher a Quilometragem do automóvel.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		if(placa.isBlank()) {
			showMessageDialog(this, "Você deve preencher a Placa do automóvel.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		
		// Verificação e parsing do valor String que representa a quilometragem
		try {
			Integer.valueOf(quilometragem);
		} catch (NumberFormatException e) {
			showMessageDialog(this, "Valor de quilometragem inválido.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		
		// Verificação do formato da placa (placas antigas e padrão Mercosul)
		if(!validarString(placa,"([a-zA-z]{3}-?\\d{4})|([a-zA-Z]{3}\\d[a-zA-Z]\\d{2})")) {
			showMessageDialog(this, "Email inválido.", "Cadastrar Cliente", ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}

	/**
	 * Testa a string passada por parâmetro e verifica se a mesma está no formato estipulado por <code>regex</code>.
	 * 
	 * @param stringTestada <code>String</code> a ser validada;
	 * @param regex Expressão regular usada na validação.
	 * 
	 * @return <code>true</code> se a string corresponder ao formato estipulado, <code>false</code> caso contrário.
	 * 
	 * @see java.lang.String#matches(String)
	 */
	private boolean validarString(String stringTestada, String regex) {
		if(stringTestada.matches(regex))
			return true;
		return false;
	}
	
}
