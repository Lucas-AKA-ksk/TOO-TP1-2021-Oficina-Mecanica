package lucas.TP1.oficina.gui;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import lucas.TP1.oficina.Automovel;
import lucas.TP1.oficina.Cliente;
import lucas.TP1.oficina.Oficina;
import lucas.TP1.oficina.OrdemDeServico;
import lucas.TP1.oficina.Peca;
import lucas.TP1.oficina.Servico;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/**
 * Classe que representa o menu de cadastro de ordens de serviço,
 * onde operações de cadastro, consulta e atualização das mesmas pode ser realizado 
 * através de uma Interface Gráfica.
 *
 * @author Lucas Reis
 */
@SuppressWarnings("serial")
public class IgOrdemDeServico extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField numeroTextField;
	private JTextField dataTextField;
	private JTextField horaTextField;
	private JTextField cpfTextField;
	private JTextField nomeTextField;
	private JTable servicosTable;
	private JTextField modeloTextField;
	private JTable pecasTable;
	private JTextField ValorTotalTextField;
	private JComboBox<String> codigoCarrocomboBox;
	private List<Automovel> listaDeAutomoveisTemporaria;
	private Oficina oficina;

	/**
	 * Contrutor da classe <code>IgOrdemDeServico</code>.
	 * Cria uma nova janela de Ordem de Serviço com os dados do cliente já preenchidos,
	 * assim como o numero da ordem de serviço, data e hora do preenchimento da ordem de serviço
	 * 
	 * @param oficina objeto do tipo <code>Oficina</code>
	 * para que esta classe invoque os métodos da mesma;
	 * @param cpf CPF do cliente usado para preencher o campo da interface;
	 * @param nome nome do cliente usado para preencher o campo da interface;
	 * @param automoveis lista de automóveis do cliente usada para preencher os campo da interface.
	 */
	public IgOrdemDeServico(Oficina oficina, String cpf, String nome, List<Automovel> automoveis) {
		this(oficina);
		
		numeroTextField.setText(String.format("%04d", oficina.obterNumeroDeOrdensDeServico()+1));
		numeroTextField.setEditable(false);
		cpfTextField.setText(cpf);
		nomeTextField.setText(nome);
		listaDeAutomoveisTemporaria = automoveis;
		
		for(Automovel automovel : listaDeAutomoveisTemporaria)
			codigoCarrocomboBox.addItem(automovel.getCodigo());
		
		modeloTextField.setText(listaDeAutomoveisTemporaria.get(0).getModelo());
		
		dataTextField.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		horaTextField.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
	}
	
	/**
	 * Contrutor da classe <code>IgOrdemDeServico</code>.
	 * Cria uma nova janela de Ordem de Serviço em branco.
	 * <br>
	 * @wbp.parser.constructor tag -> tag especifica para o windowbuilder
	 * que define este construtor como o construtor a ser usado na aba de design.
	 * Para abrir esta classe na aba design,
	 * basta adicionar esta tag neste comentário javadoc.
	 * 
	 * @param oficina objeto do tipo <code>Oficina</code>
	 * para que esta classe invoque os métodos da mesma.
	 */
	public IgOrdemDeServico(Oficina oficina) {
		
		this.oficina = oficina;
		
		// Desabilita o redimensionamento
		setResizable(false);
		
		// Título, tamanho e layout
		setTitle("Ordem de serviço");
		setSize(734, 653);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[328.00][]", "[][][][50,grow]"));
		
		
		// Panel das informações das Ordens De Serviço
		JPanel ordemServicoPanel = new JPanel();
		ordemServicoPanel.setBorder(new TitledBorder(null, "Ordem de Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(ordemServicoPanel, "cell 0 0,growx,aligny baseline");
		ordemServicoPanel.setLayout(new MigLayout("", "[][139.00][139.00][139.00][139.00][86.00]", "[][][]"));
			
		// Label do número de serviço
		JLabel numeroLabel = new JLabel("Número:");
		numeroLabel.setDisplayedMnemonic(KeyEvent.VK_N);
		ordemServicoPanel.add(numeroLabel, "cell 0 0,alignx left");
		numeroLabel.setLabelFor(numeroTextField);
		
		// TextField do número de serviço
		numeroTextField = new JTextField();
		numeroTextField.setToolTipText("Número da Ordem de Serviço. Pressione Enter para pesquisar uma Ordem de Serviço.");
		numeroTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarOrdemDeServico();
			}
		});
		ordemServicoPanel.add(numeroTextField, "cell 1 0 4 1,growx");
		numeroTextField.setColumns(10);
			
		// Botão de pesquisa
		JButton pesquisarButton = new JButton("Pesquisar");
		pesquisarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarOrdemDeServico();
			}
		});
		ordemServicoPanel.add(pesquisarButton, "cell 5 0");
			
		// Label da Data
		JLabel dataLabel = new JLabel("Data:");
		ordemServicoPanel.add(dataLabel, "cell 0 1,alignx left");
		dataLabel.setLabelFor(dataTextField);
		
		// TextField da Data
		dataTextField = new JTextField();
		dataTextField.setToolTipText("Dia da geração da ordem de serviço.");
		dataTextField.setEditable(false);
		ordemServicoPanel.add(dataTextField, "cell 1 1 3 1,alignx left");
		dataTextField.setColumns(10);
			
		// Label da Hora
		JLabel horaLabel = new JLabel("Hora:");
		horaLabel.setLabelFor(horaLabel);
		ordemServicoPanel.add(horaLabel, "cell 0 2,alignx left");
			
		// TextField da Hora
		horaTextField = new JTextField();
		horaTextField.setToolTipText("Horário da geração da Ordem de serviço.");
		horaTextField.setEditable(false);
		ordemServicoPanel.add(horaTextField, "cell 1 2 2 1,alignx left");
		horaTextField.setColumns(10);

		// Painel das informações do Cliente
		JPanel clientePanel = new JPanel();
		clientePanel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(clientePanel, "cell 1 0,growx,aligny baseline");
		clientePanel.setLayout(new MigLayout("", "[][][][grow]", "[][][]"));
			
		// Label de CPF
		JLabel cpfLabel = new JLabel("CPF:");
		clientePanel.add(cpfLabel, "cell 0 0,alignx left");
		cpfLabel.setLabelFor(cpfTextField);
				
		// TextField de CPF
		cpfTextField = new JTextField();
		cpfTextField.setToolTipText("CPF do cliente atendido.");
		cpfTextField.setEditable(false);
		clientePanel.add(cpfTextField, "cell 1 0 3 1,alignx left");
		cpfTextField.setColumns(10);
			
		// Label do Nome
		JLabel nomeLabel = new JLabel("Nome:");
		clientePanel.add(nomeLabel, "cell 0 1,alignx trailing");
		nomeLabel.setLabelFor(nomeTextField);
		
		// TextField do Nome
		nomeTextField = new JTextField();
		nomeTextField.setToolTipText("Nome do Cliente atendido.");
		nomeTextField.setEditable(false);
		clientePanel.add(nomeTextField, "cell 1 1 3 1,growx");
		nomeTextField.setColumns(10);
			
		// Label do código do carro
		JLabel codigoCarroLabel = new JLabel("Carro:");
		clientePanel.add(codigoCarroLabel, "cell 0 2,alignx trailing");
		codigoCarroLabel.setLabelFor(codigoCarrocomboBox);
		
		// ComboBox do Código do Automóvel
		codigoCarrocomboBox = new JComboBox<>();
		codigoCarrocomboBox.setToolTipText("Código do carro do cliente.");
		codigoCarrocomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED)
					modeloTextField.setText(oficina.pesquisarClientePeloCPF(cpfTextField.getText()).obterModeloAutomovel(codigoCarrocomboBox.getSelectedIndex()));
			}
		});
		clientePanel.add(codigoCarrocomboBox, "flowx,cell 1 2,alignx left");
			
		// Label do Modelo
		JLabel modeloLabel = new JLabel("Modelo:");
		clientePanel.add(modeloLabel, "flowx,cell 3 2,alignx right");
		modeloLabel.setLabelFor(modeloTextField);
		
		// TextField do Modelo
		modeloTextField = new JTextField();
		modeloTextField.setToolTipText("Modelo do carro do Cliente.");
		modeloTextField.setEditable(false);
		clientePanel.add(modeloTextField, "cell 3 2,alignx right");
		modeloTextField.setColumns(10);
		
		// Painel de Serviços
		JPanel servicosPanel = new JPanel();
		servicosPanel.setBorder(new TitledBorder(null, "Servi\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(servicosPanel, "cell 0 1 2 1,grow");
		servicosPanel.setLayout(new MigLayout("", "[674.00px,fill]", "[123.00px]"));
			
		// ScroolPane de Serviços		
		JScrollPane servicosScrollPane = new JScrollPane();
		servicosPanel.add(servicosScrollPane, "cell 0 0,grow");
				
		// Tabela de Serviços
		servicosTable = new JTable();
		int i = 0;
		servicosTable.setModel(new DefaultTableModel(
			new Object[][] {
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
				{++i, null, null},
			},
			new String[] {
				"N\u00BA", "Descri\u00E7\u00E3o", "Pre\u00E7o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		servicosTable.getColumnModel().getColumn(0).setResizable(false);
		servicosTable.getColumnModel().getColumn(0).setPreferredWidth(25);
		servicosTable.getColumnModel().getColumn(1).setResizable(false);
		servicosTable.getColumnModel().getColumn(1).setPreferredWidth(350);
		servicosTable.getColumnModel().getColumn(2).setResizable(false);
		servicosTable.getColumnModel().getColumn(2).setPreferredWidth(100);
		servicosTable.setShowGrid(true);
		servicosScrollPane.setViewportView(servicosTable);
				
		// Listener da tabela de serviços que reage a altereções na coluna de preço
		servicosTable.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				if(e.getColumn() == 2 && servicosTable.getModel().getValueAt(e.getFirstRow(), e.getColumn()) != null) {
					atualizarValorTotal();
				}
			}
		});
		
		// Painel de Peças
		JPanel pecasPanel = new JPanel();
		pecasPanel.setBorder(new TitledBorder(null, "Pe\u00E7as", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(pecasPanel, "cell 0 2 2 1,grow");
		pecasPanel.setLayout(new MigLayout("", "[666.00px]", "[123.00px]"));
			
		// ScrollPane de Peças
		JScrollPane pecasScrollPane = new JScrollPane();
		pecasPanel.add(pecasScrollPane, "cell 0 0,grow");
				
		// Tabela de Peças
		pecasTable = new JTable();
		i = 0;
		pecasTable.setModel(new DefaultTableModel(
			new Object[][] {
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
				{++i, null, null, null, null},
			},
			new String[] {
				"N\u00BA", "Descri\u00E7\u00E3o", "Quantidade", "Valor Unit\u00E1rio", "Valor Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		pecasTable.getColumnModel().getColumn(0).setResizable(false);
		pecasTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		pecasTable.getColumnModel().getColumn(1).setResizable(false);
		pecasTable.getColumnModel().getColumn(1).setPreferredWidth(225);
		pecasTable.getColumnModel().getColumn(2).setResizable(false);
		pecasTable.getColumnModel().getColumn(3).setResizable(false);
		pecasTable.getColumnModel().getColumn(4).setResizable(false);
		pecasTable.setShowGrid(true);
		pecasScrollPane.setViewportView(pecasTable);
				
		
		// Listener da tabela de peças que reage a altereções na coluna de preço
		pecasTable.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				
				if(e.getColumn() == 4 && pecasTable.getModel().getValueAt(e.getFirstRow(), e.getColumn()) != null) {
					atualizarValorTotal();
				}
				else if((e.getColumn() == 2 || e.getColumn() == 3) && pecasTable.getModel().getValueAt(e.getFirstRow(), e.getColumn()) != null) {
					CalcularValorTotalDePecas(e.getFirstRow());
				}
			}
		});
		
		// Painel do Valor Total
		JPanel valorTotalPanel = new JPanel();
		valorTotalPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(valorTotalPanel, "cell 0 3 2 1,grow");
		valorTotalPanel.setLayout(new MigLayout("", "[55px][122px]", "[28px]"));
			
		// Label do Valor Total
		JLabel valorTotalLabel = new JLabel("Valor total da ordem de serviço:");
		valorTotalPanel.add(valorTotalLabel, "cell 0 0,alignx left,aligny center");
		valorTotalLabel.setLabelFor(ValorTotalTextField);
				
		// TextField do Valor Total
		ValorTotalTextField = new JTextField("0.0");
		ValorTotalTextField.setEditable(false);
		valorTotalPanel.add(ValorTotalTextField, "cell 1 0,alignx left,aligny center");
		ValorTotalTextField.setColumns(10);
			
		// Painel de botões inferior
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		// Botão Gravar
		JButton gravarButton = new JButton("Gravar");
		gravarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(oficina.verificarNumeroDeOS(numeroTextField.getText().trim()))
					alterarOrdemDeServico();
				else
					gravarOrdemDeServico();
			}
		});
		gravarButton.setMnemonic(KeyEvent.VK_G);
		gravarButton.setActionCommand("OK");
		buttonPane.add(gravarButton);
			
		// Botão Cancelar
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelarButton.setActionCommand("Cancel");
		buttonPane.add(cancelarButton);
			
		
		// Configura a caixa de dialogo para que ela seja liberada para o sistema quando for fechada
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Centraliza a caixa de diálogo
		setLocationRelativeTo(this);
		
		// Exibe a caixa de diálogo.
		setVisible(true);
	}
	
	/**
	 * Realiza a gravação da ordem de serviço
	 */
	private void gravarOrdemDeServico() {
		
		String numero = numeroTextField.getText().trim(),
				data = dataTextField.getText().isBlank() ? dataTextField.getText() : LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				hora = horaTextField.getText().isBlank() ? horaTextField.getText() : LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")),
				cpf = cpfTextField.getText(),
				nome = nomeTextField.getText(),
				codigo = (String) codigoCarrocomboBox.getSelectedItem(),
				modelo = modeloTextField.getText();
		
		OrdemDeServico novaOrdemDeServico;
		
		if(verificarCampos(numero, cpf, nome, modelo)) {
			novaOrdemDeServico = new OrdemDeServico(numero, data, hora, cpf, nome, codigo, modelo);
			
			DefaultTableModel servicosTM = (DefaultTableModel) servicosTable.getModel();
			DefaultTableModel pecasTM = (DefaultTableModel) pecasTable.getModel();
				
			// Adicionando Serviços da tabela na Ordem de serviço
			for (int linha = 0; linha < servicosTM.getRowCount(); linha++) {
				
				// Verifica se todas as colunas da linha estão preenchidas
				if(servicosTM.getValueAt(linha, 0) != null && servicosTM.getValueAt(linha, 1) != null && servicosTM.getValueAt(linha, 2) != null) {
					novaOrdemDeServico.adicionarServico(new Servico(servicosTM.getValueAt(linha, 1).toString().trim(), Double.valueOf(servicosTM.getValueAt(linha, 2).toString().trim())));
				}
				/* Caso Alguma coluna esteja em branco nesta linha, muda o valor da coluna preço final para null,
				 * a fim de disparar o event listener que recalcula o Valor Total da Ordem de Serviço*/
				else
					servicosTM.setValueAt(null, linha, 2);
			}
			
			// Adicionando Peças da tabela na Ordem de serviço
			for (int linha = 0; linha < pecasTM.getRowCount(); linha++) {
				
				// Verifica se todas as colunas da linha estão preenchidas
				if(pecasTM.getValueAt(linha, 0) != null && pecasTM.getValueAt(linha, 1) != null && pecasTM.getValueAt(linha, 2) != null 
						&& pecasTM.getValueAt(linha, 3) != null && pecasTM.getValueAt(linha, 4) != null) {
					
					novaOrdemDeServico.adicionarPeca(new Peca(pecasTM.getValueAt(linha, 1).toString().trim(), Integer.valueOf(pecasTM.getValueAt(linha, 2).toString()), Double.valueOf(pecasTM.getValueAt(linha, 3).toString()), Double.valueOf(pecasTM.getValueAt(linha, 4).toString())));
				}
				/* Caso Alguma coluna esteja em branco nesta linha, muda o valor da coluna preço final para null,
				 * a fim de disparar o event listener que recalcula o Valor Total da Ordem de Serviço*/
				else
					pecasTM.setValueAt(null, linha, 4);
			}
			
			// Caso pelo menos uma das tabelas não esteja vazia, cadastra a nova ordem de serviço
			if(novaOrdemDeServico.obterNumeroDeServicos() > 0 || novaOrdemDeServico.obterNumeroDePecas() > 0) {
				novaOrdemDeServico.setValorTotal(Double.valueOf(ValorTotalTextField.getText()));
				oficina.cadastrarOrdemDeServico(novaOrdemDeServico);
				showMessageDialog(this, "Ordem de serviço cadastrada com sucesso.", "Ordem de Serviço", INFORMATION_MESSAGE);
				
				// Coloca o próximo número disponível na área de texto numeroTextField
				numeroTextField.setText(String.format("%04d", oficina.obterNumeroDeOrdensDeServico()+1));
			}
			else
				showMessageDialog(this, "Não é possível cadastrar uma ordem de serviço\n sem serviços ou peças", "Ordem de Serviço", ERROR_MESSAGE);
		}
	}
	
	/**
	 * Realiza a alteração de uma ordem de serviço
	 */
	private void alterarOrdemDeServico() {
		
		String numero = numeroTextField.getText().trim(),
				data = dataTextField.getText().isBlank() ? dataTextField.getText() : LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
				hora = horaTextField.getText().isBlank() ? horaTextField.getText() : LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")),
				cpf = cpfTextField.getText(),
				nome = nomeTextField.getText(),
				codigo = (String) codigoCarrocomboBox.getSelectedItem(),
				modelo = modeloTextField.getText();
		
		OrdemDeServico ordemDeServicoAtualizada;
		
		if(verificarCampos(numero, cpf, nome, modelo)) {
			ordemDeServicoAtualizada = oficina.pesquisarNumeroDeOS(numero);
			
			
			DefaultTableModel servicosTM = (DefaultTableModel) servicosTable.getModel();
			DefaultTableModel pecasTM = (DefaultTableModel) pecasTable.getModel();
			
			List<Servico> tabelaDeServicosAtualizada = new ArrayList<>();
			List<Peca> tabelaDePecasAtualizada = new ArrayList<>();
			
			// Adicionando Serviços Atualizados da tabela em uma lista temporária
			for (int linha = 0; linha < servicosTM.getRowCount(); linha++) {
				
				// Verifica se todas as colunas da linha estão preenchidas
				if(servicosTM.getValueAt(linha, 0) != null && servicosTM.getValueAt(linha, 1) != null && servicosTM.getValueAt(linha, 2) != null) {
					tabelaDeServicosAtualizada.add(new Servico(servicosTM.getValueAt(linha, 1).toString().trim(), Double.valueOf(servicosTM.getValueAt(linha, 2).toString().trim())));
				}
				/* Caso Alguma coluna esteja em branco nesta linha, muda o valor da coluna preço final para null,
				 * a fim de disparar o event listener que recalcula o Valor Total da Ordem de Serviço*/
				else
					servicosTM.setValueAt(null, linha, 2);
			}
			
			// Adicionando Peças Atualizados da tabela em uma lista temporária
			for (int linha = 0; linha < pecasTM.getRowCount(); linha++) {
				
				// Verifica se todas as colunas da linha estão preenchidas
				if(pecasTM.getValueAt(linha, 0) != null && pecasTM.getValueAt(linha, 1) != null && pecasTM.getValueAt(linha, 2) != null 
						&& pecasTM.getValueAt(linha, 3) != null && pecasTM.getValueAt(linha, 4) != null) {
					
					tabelaDePecasAtualizada.add(new Peca(pecasTM.getValueAt(linha, 1).toString().trim(), Integer.valueOf(pecasTM.getValueAt(linha, 2).toString()), Double.valueOf(pecasTM.getValueAt(linha, 3).toString()), Double.valueOf(pecasTM.getValueAt(linha, 4).toString())));
				}
				/* Caso Alguma coluna esteja em branco nesta linha, muda o valor da coluna preço final para null,
				 * a fim de disparar o event listener que recalcula o Valor Total da Ordem de Serviço*/
				else
					pecasTM.setValueAt(null, linha, 4);
			}
			
			// Caso pelo menos uma das tabelas atualizadas não estajam vazias
			if(tabelaDeServicosAtualizada.size() > 0 || tabelaDePecasAtualizada.size() > 0) {
				
				// Esvazia as listas de Serviços e Peças 
				ordemDeServicoAtualizada.esvaziarListaDeServicos();
				ordemDeServicoAtualizada.esvaziarListaDePecas();
				
				// Insere os Serviços e Peças atualizados nas listas
				for(Servico servico : tabelaDeServicosAtualizada)
					ordemDeServicoAtualizada.adicionarServico(servico);
				for(Peca peca : tabelaDePecasAtualizada)
					ordemDeServicoAtualizada.adicionarPeca(peca);
				
				
				ordemDeServicoAtualizada.setData(data);
				ordemDeServicoAtualizada.setHora(hora);
				ordemDeServicoAtualizada.setCpf(cpf);
				ordemDeServicoAtualizada.setNome(nome);
				ordemDeServicoAtualizada.setCodigo(codigo);
				ordemDeServicoAtualizada.setModelo(modelo);
				ordemDeServicoAtualizada.setValorTotal(Double.valueOf(ValorTotalTextField.getText()));
				
				showMessageDialog(this, "Ordem de serviço atualizada com sucesso.", "Ordem de Serviço", INFORMATION_MESSAGE);
			}
			else
				showMessageDialog(this, "Não é possível atualizar uma ordem de serviço\n sem serviços ou peças", "Ordem de Serviço", ERROR_MESSAGE);
		}
	}
	
	/**
	 * Pesquisa por uma Ordem de serviço com base no numero fornecido,
	 * caso encontre, preenche os campos e as tabelas da tela
	 */
	private void pesquisarOrdemDeServico() {
		
		String numero = numeroTextField.getText().trim();
		OrdemDeServico ordemServicoPesquisada;
		
		if(!numero.isBlank()) {
			ordemServicoPesquisada = oficina.pesquisarNumeroDeOS(numero);
		}
		else {
			showMessageDialog(this, "Campo numero vazio.", "Cadastrar Cliente", ERROR_MESSAGE);
			return;
		}
		
		if(ordemServicoPesquisada != null)
			preencherCamposDaTela(ordemServicoPesquisada);
		else
			showMessageDialog(this, "Cliente não encontrado", "Cadastrar Cliente", ERROR_MESSAGE);
	}
	
	/**
	 * Preenche os campos da tela com as informações de uma Ordem de Serviço.
	 * 
	 * @param ordemServico Objeto <code>OrdemDeServico</code> usado para preencher os campos da Interface Gráfica.
	 */
	private void preencherCamposDaTela(OrdemDeServico ordemServico) {
		
		limparCamposDaTela();
		
		numeroTextField.setText(ordemServico.getNumero());
		dataTextField.setText(ordemServico.getData());
		horaTextField.setText(ordemServico.getHora());
		cpfTextField.setText(ordemServico.getCpf());
		nomeTextField.setText(ordemServico.getNome());
		modeloTextField.setText(ordemServico.getModelo());
		
		Cliente cliente = oficina.pesquisarClientePeloCPF(ordemServico.getCpf());
		for(int i = 1; i <= cliente.obterNumeroDeAutomoveis(); i++)
			codigoCarrocomboBox.addItem(String.format("A%d", i));
		
		codigoCarrocomboBox.setSelectedItem(ordemServico.getCodigo());
		
		DefaultTableModel servicosTM = (DefaultTableModel) servicosTable.getModel();
		for(int linha = 0; linha < ordemServico.obterNumeroDeServicos(); linha++) {
			servicosTM.setValueAt(linha + 1, linha, 0);
			servicosTM.setValueAt(ordemServico.obterDescricaoDoServico(linha), linha, 1);
			servicosTM.setValueAt(ordemServico.obterPrecoDoServico(linha), linha, 2);
		}
		DefaultTableModel pecasTM = (DefaultTableModel) pecasTable.getModel();
		for(int linha = 0; linha < ordemServico.obterNumeroDePecas(); linha++) {
			pecasTM.setValueAt(linha+1, linha, 0);
			pecasTM.setValueAt(ordemServico.obterDescricaoDaPeca(linha), linha, 1);
			pecasTM.setValueAt(ordemServico.obterQuantidadeDePecas(linha), linha, 2);
			pecasTM.setValueAt(ordemServico.obterPrecoUnitarioDaPeca(linha), linha, 3);
		}
	}
	
	/**
	 * Limpa todos os campos da tela assim como os campos editaveis das tabelas
	 */
	private void limparCamposDaTela() {
		
		numeroTextField.setText(null);
		dataTextField.setText(null);
		horaTextField.setText(null);
		cpfTextField.setText(null);
		nomeTextField.setText(null);
		modeloTextField.setText(null);
		
		codigoCarrocomboBox.removeAllItems();
		
		DefaultTableModel servicosTM = (DefaultTableModel)servicosTable.getModel();
		limparTabela(servicosTM, 1, servicosTM.getColumnCount());
		
		DefaultTableModel pecasTM = (DefaultTableModel)pecasTable.getModel();
		limparTabela(pecasTM, 1, pecasTM.getColumnCount());
		
	}
	
	/**
	 * Limpa os dados de uma tabela, a partir de uma coluna de index <code>inicio</code> até 
	 * a coluna anterior ao index <code>fim</code>.
	 * 
	 * @param tableModel TableModel da tabela
	 * @param inicio index inicial; 
	 * @param fim index final.
	 */
	private void limparTabela(DefaultTableModel tableModel, int inicio, int fim) {
		
		for (int linha = 0; linha < tableModel.getRowCount(); linha++) 
			for(int coluna = inicio; coluna < fim; coluna++)
				tableModel.setValueAt(null, linha, coluna);
	}
	
	/**
	 * Realiza as verificações necessárias nos campos editaveis da janela, apenas verifica se não estão vazios.
	 * 
	 * @param numero número da ordem de serviço fornecido para verificação;
	 * @param cpf CPF do cliente fornecido para validação;
	 * @param nome nome do cliente fornecido para validação;
	 * @param modelo modelo do automóvel fornecido para validação.
	 * 
	 * @return <code>true</code> se todos os campos forem validados e <code>false</code> se alguma validação falhar.
	 */
	public boolean verificarCampos(String numero, String cpf, String nome, String modelo) {
		
		if(numero.isBlank()) {
			showMessageDialog(this, "Você deve preencher o numero da Ordem de Serviço.", "Ordem de Serviço", ERROR_MESSAGE);
			return false;
		}
		if(cpf.isBlank()) {
			showMessageDialog(this, "Você deve preencher o CPF do cliente.", "Ordem de Serviço", ERROR_MESSAGE);
			return false;
		}
		if(nome.isBlank()) {
			showMessageDialog(this, "Você deve preencher o nome do cliente.", "Ordem de Serviço", ERROR_MESSAGE);
			return false;
		}
		if(modelo.isBlank()) {
			showMessageDialog(this, "Você deve preencher o modelo do carro do cliente.", "Ordem de Serviço", ERROR_MESSAGE);
			return false;
		}
		return true;
	}

	/**
	 * Atualiza o valor total da ordem de serviço mostrado pela ValorTotalTextField
	 */
	private void atualizarValorTotal() {
		
		Double totalServicos = 0.0, totalPecas = 0.0, valor;
		DefaultTableModel servicosTM = (DefaultTableModel) servicosTable.getModel(),
				pecasTM = (DefaultTableModel) pecasTable.getModel();
		
		// Soma os valores na tabela de serviços
		for(int index = 0; index < servicosTM.getRowCount(); index++) {
			if(servicosTM.getValueAt(index, 2) != null) {
				try {
					valor = Double.valueOf(servicosTM.getValueAt(index, 2).toString().trim());
					totalServicos+=valor;
				} catch (NumberFormatException e) {
					servicosTM.setValueAt(null, index, 2);
				}
			}
		}
		
		// Soma os valores na tabela de peças
		for(int index = 0; index < pecasTM.getRowCount(); index++) {
			if(pecasTM.getValueAt(index, 4) != null) {
				try {
					valor = Double.valueOf(pecasTM.getValueAt(index, 4).toString().trim());
					totalPecas+=valor;
				} catch (NumberFormatException e) {
					pecasTM.setValueAt(null, index, 4);
				}
			}
		}
		
		// Altera o valor na tela
		ValorTotalTextField.setText(String.valueOf(totalServicos + totalPecas));
	}
	
	/**
	 * Calcula o valor total de peças (qtde*preço) de uma linha na tabela
	 * e insere esse valor na coluna de valor total da tabela de peças
	 * @param linha linha da tabela onde será feito o calculo
	 */
	private void CalcularValorTotalDePecas(int linha) {
		
		DefaultTableModel pecasTM = (DefaultTableModel) pecasTable.getModel();
		int quantidade = 0;
		double precoUnitario = 0.0;
		
		/* Se o campo quantidade na tabela não estivel vazio,
		 * Tenta obter seu valor e caso seja inválido
		 * (não seja inteiro ou seja menor ou igual a 0)
		 * limpa a celula da tabela.
		 */
		if(pecasTM.getValueAt(linha, 2) != null) {
			try {
				quantidade = Integer.valueOf(pecasTM.getValueAt(linha, 2).toString().trim());
			} catch (NumberFormatException e) {
				pecasTM.setValueAt(null, linha, 2);
			}
			if(!(quantidade > 0))
				pecasTM.setValueAt(null, linha, 2);
		}
		
		/* Se o campo preço unitário na tabela não estivel vazio,
		 * Tenta obter seu valor e caso seja inválido
		 * (não seja um valor numérico ou seja menor ou igual a 0)
		 * limpa a celula da tabela.
		 */
		if(pecasTM.getValueAt(linha, 3) != null) {
			try {
				precoUnitario = Double.valueOf(pecasTM.getValueAt(linha, 3).toString().trim());
			} catch (NumberFormatException e) {
				pecasTM.setValueAt(null, linha, 3);
			}
			if(!(precoUnitario > 0))
				pecasTM.setValueAt(null, linha, 3);
		}
		
		if(quantidade > 0 && precoUnitario > 0.0)
			pecasTM.setValueAt((quantidade*precoUnitario), linha, 4);
	}
}
