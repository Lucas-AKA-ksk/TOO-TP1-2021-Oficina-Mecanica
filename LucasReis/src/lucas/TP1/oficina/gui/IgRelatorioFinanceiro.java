package lucas.TP1.oficina.gui;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import lucas.TP1.oficina.Oficina;
import lucas.TP1.oficina.OrdemDeServico;
import net.miginfocom.swing.MigLayout;

/**
 * Classe que representa o menu de relatórios,
 * onde o usuário pode requisitar relatórios por data
 * através de uma Interface Gráfica.
 *
 * @author Lucas Reis
 */
@SuppressWarnings("serial")
public class IgRelatorioFinanceiro extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField dataInicialTextField;
	private JTextField dataFinalTextField;
	private JTable servicosTable;
	private JTable pecasTable;
	private JTextField receitaServicosTextField;
	private JTextField receitaPecasTextField;
	private JTextField receitaTotalTextField;
	private Oficina oficina;

	/**
	 * Create the dialog.
	 * @param oficina objeto do tipo <code>Oficina</code>
	 * para que esta classe invoque os métodos da mesma.
	 */
	public IgRelatorioFinanceiro(Oficina oficina) {
		this.oficina = oficina;
		// Titulo
		setTitle("Relatório Financeiro");
		
		// Desabilita o redimensionamento
		setResizable(false);
		
		// Tamanho da janela
		setSize(656, 642);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[328.00][]", "[][][][75.00,grow]"));
		
		// Painel Período
		JPanel periodoPanel = new JPanel();
		periodoPanel.setBorder(new TitledBorder(null, "Per\u00EDodo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		contentPanel.add(periodoPanel, "cell 0 0 2 1,growx,aligny baseline");
		periodoPanel.setLayout(new MigLayout("", "[][123.00][68.00][132.00][86.00]", "[]"));
		
		// Label de Data Inicial
		JLabel dataInicialLabel = new JLabel("Data inicial:");
		dataInicialLabel.setDisplayedMnemonic(KeyEvent.VK_I);
		periodoPanel.add(dataInicialLabel, "cell 0 0,alignx left");
		dataInicialLabel.setLabelFor(dataInicialTextField);
				
		// TextField de Data Inicial
		dataInicialTextField = new JTextField();
		dataInicialTextField.setToolTipText("Data Inicial do relatório. Se não houver Data Final o relatório será apenas da data digitada.");
		dataInicialTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		periodoPanel.add(dataInicialTextField, "flowx,cell 1 0,alignx left");
		dataInicialTextField.setColumns(10);
			
		// Label de Data Final
		JLabel dataFinalLabel = new JLabel("Data final:");
		dataFinalLabel.setDisplayedMnemonic(KeyEvent.VK_F);
		periodoPanel.add(dataFinalLabel, "cell 2 0,alignx left");
		dataFinalLabel.setLabelFor(dataFinalTextField);
			
		// TextField de Data Final
		dataFinalTextField = new JTextField();
		dataFinalTextField.setToolTipText("Data Final do relatório.");
		dataFinalTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		periodoPanel.add(dataFinalTextField, "flowx,cell 3 0,alignx left");
		dataFinalTextField.setColumns(10);
			
		// Botão Gerar Relatório
		JButton gerarRelatorioButton = new JButton("Gerar Relatório");
		gerarRelatorioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarRelatorio();
			}
		});
		gerarRelatorioButton.setMnemonic(KeyEvent.VK_G);
		periodoPanel.add(gerarRelatorioButton, "cell 4 0");
			
		
		// Painel de Serviços
		JPanel servicosPanel = new JPanel();
		servicosPanel.setBorder(new TitledBorder(null, "Servi\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(servicosPanel, "cell 0 1 2 1,grow");
		servicosPanel.setLayout(new MigLayout("", "[674.00px,fill]", "[123.00px]"));
			
		// ScrollPane da tabela de serviços
		JScrollPane servicosScrollPane = new JScrollPane();
		servicosPanel.add(servicosScrollPane, "cell 0 0,grow");
				
		// Tabela de serviços
		servicosTable = new JTable();
		servicosTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Pre\u00E7o Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		servicosTable.getColumnModel().getColumn(0).setResizable(false);
		servicosTable.getColumnModel().getColumn(0).setPreferredWidth(350);
		servicosTable.getColumnModel().getColumn(1).setResizable(false);
		servicosTable.getColumnModel().getColumn(1).setPreferredWidth(179);
		servicosTable.setShowGrid(true);
		servicosScrollPane.setViewportView(servicosTable);
				
			
		
		// Painel de Peças
		JPanel pecasPanel = new JPanel();
		pecasPanel.setBorder(new TitledBorder(null, "Pe\u00E7as", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(pecasPanel, "cell 0 2 2 1,grow");
		pecasPanel.setLayout(new MigLayout("", "[666.00px]", "[123.00px]"));
		
		// ScrollPane da tabela de peças
		JScrollPane pecasScrollPane = new JScrollPane();
		pecasPanel.add(pecasScrollPane, "cell 0 0,grow");
			
		// Tabela de Peças
		pecasTable = new JTable();
		pecasTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Descri\u00E7\u00E3o", "Quantidade", "Valor Unit\u00E1rio", "Valor Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		pecasTable.getColumnModel().getColumn(0).setResizable(false);
		pecasTable.getColumnModel().getColumn(1).setResizable(false);
		pecasTable.getColumnModel().getColumn(2).setResizable(false);
		pecasTable.getColumnModel().getColumn(3).setResizable(false);
		pecasTable.setShowGrid(true);
		pecasScrollPane.setViewportView(pecasTable);
				
			
		
		// Painel do Valor Total
		JPanel valorTotalPanel = new JPanel();
		valorTotalPanel.setBorder(new TitledBorder(null, "Receita", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		contentPanel.add(valorTotalPanel, "cell 0 3 2 1,growx");
		valorTotalPanel.setLayout(new MigLayout("", "[55px][122px,grow]", "[28px][][]"));
			
		// Label da Receita dos Serviços
		JLabel receitaServicosLabel = new JLabel("Receita com serviços:");
		valorTotalPanel.add(receitaServicosLabel, "cell 0 0,alignx left,aligny center");
		receitaServicosLabel.setLabelFor(receitaServicosTextField);
				
		// TextField da Receita dos Serviços
		receitaServicosTextField = new JTextField();
		receitaServicosTextField.setEditable(false);
		valorTotalPanel.add(receitaServicosTextField, "cell 1 0,alignx left,aligny center");
		receitaServicosTextField.setColumns(10);
			
		// Label da Receita das Peças
		JLabel receitaPecasLabel = new JLabel("Receita com peças:");
		valorTotalPanel.add(receitaPecasLabel, "cell 0 1,alignx trailing");
		receitaPecasLabel.setLabelFor(receitaPecasTextField);
				
		// TextField da Receita das Peças
		receitaPecasTextField = new JTextField();
		receitaPecasTextField.setEditable(false);
		valorTotalPanel.add(receitaPecasTextField, "cell 1 1,alignx left");
		receitaPecasTextField.setColumns(10);
			
		// Label da Receita Total
		JLabel receitaTotalLabel = new JLabel("Receita total:");
		valorTotalPanel.add(receitaTotalLabel, "cell 0 2,alignx trailing");
		receitaTotalLabel.setLabelFor(receitaTotalTextField);
		
		// TextField de Receita Total
		receitaTotalTextField = new JTextField();
		receitaTotalTextField.setEditable(false);
		valorTotalPanel.add(receitaTotalTextField, "cell 1 2,alignx left");
		receitaTotalTextField.setColumns(10);
			
		
		// Painel de Botões inferior
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
		// Botão OK
		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		okButton.setMnemonic(KeyEvent.VK_G);
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
			
		// Botão cancelar
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
	 * Gera um relatório financeiro com base nos campos Data Inicial e Data Final.
	 * Caso apenas Data Inicial seja preenchido, gera um relatório apenas daquela data em específico,
	 * caso ambos os campos estejam preenchidos, gera um relatório daquele intervalo de datas. 
	 */
	private void gerarRelatorio() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String dataIni = dataInicialTextField.getText(), dataFim = dataFinalTextField.getText();
		LocalDate dataInicial, dataFinal;
		
		
		if(!dataIni.isBlank()) {
			
			try {
				dataInicial = LocalDate.parse(dataIni, formato);
			} catch (DateTimeParseException e) {
				showMessageDialog(this, "Data Inicial inválida.", "Relatório Financeiro", ERROR_MESSAGE);
				return;
			}
			
			// Se o Campo Data não estiver vazio, sera realizada uma busca no intervalo entre as datas
			if(!dataFim.isBlank()) {
				
				try {
					dataFinal = LocalDate.parse(dataFim, formato);
				} catch (DateTimeParseException e) {
					showMessageDialog(this, "Data Final inválida.", "Relatório Financeiro", ERROR_MESSAGE);
					return;
				}
				
				if(dataFinal.isAfter(dataInicial) || dataFinal.isEqual(dataInicial))
					gerarRelatorio(dataInicial, dataFinal);
				else
					showMessageDialog(this, "Intervalo de datas inválido.", "Relatório Financeiro", ERROR_MESSAGE);
			}
			else {
				gerarRelatorio(dataInicial);
			}
		}
		else
			showMessageDialog(this, "Campo Data Inicial está vazio.", "Relatório Financeiro", ERROR_MESSAGE);
	}

	/**
	 * Gera um relatório de todos os serviços realizados e peças vendidas em uma data especifica.
	 * Realiza uma chamada de <code>gerarRelatorio(LocalDate dataInicial, Localdate dataFinal)</code>
	 * com a mesma data em ambos os parâmetros
	 * 
	 * @param data data usada para gerar o relatório.
	 * 
	 * @see IgRelatorioFinanceiro#gerarRelatorio(LocalDate, LocalDate)
	 */
	private void gerarRelatorio(LocalDate data) {
		gerarRelatorio(data, data);
	}

	/**
	 * Gera um relatório de todos os serviços realizados e peças vendidas em um intervalo de datas.
	 * 
	 * @param dataInicial data inicial do relatório;
	 * @param dataFinal data final do relatório.
	 */
	private void gerarRelatorio(LocalDate dataInicial, LocalDate dataFinal) {
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Double receitaServicos = 0.0, receitaPecas = 0.0;
		DefaultTableModel servicosTM = (DefaultTableModel) servicosTable.getModel();
		DefaultTableModel pecasTM = (DefaultTableModel) pecasTable.getModel();
		int servicosRowCount = 0, pecasRowCount = 0;
		
		for(int index = 0; index < oficina.obterNumeroDeOrdensDeServico(); index++) {
			
			OrdemDeServico ordemDeServico =  oficina.obterOrdemDeServico(index);
			LocalDate dataDaOrdemDeServico = LocalDate.parse(ordemDeServico.getData(), formato);
			
			// Se a data da Ordem de Serviço estiver entre DataInicial e DataFinal
			if((dataDaOrdemDeServico.isEqual(dataInicial) || dataDaOrdemDeServico.isAfter(dataInicial)) && (dataDaOrdemDeServico.isEqual(dataFinal) || dataDaOrdemDeServico.isAfter(dataFinal))){
				
				Double valorServico, valorPecas;
				
				for(int indexServico = 0; indexServico < ordemDeServico.obterNumeroDeServicos(); indexServico++) {
					
					valorServico = ordemDeServico.obterPrecoDoServico(indexServico);
					receitaServicos += valorServico;
					
					servicosTM.setValueAt(ordemDeServico.obterDescricaoDoServico(indexServico), servicosRowCount, 0);
					servicosTM.setValueAt(valorServico, servicosRowCount, 1);
					
					if(servicosRowCount == servicosTM.getRowCount())
						servicosTM.addRow(new Object [] {null,null});
					
					servicosRowCount++;
				}
				
				for(int indexPeca = 0; indexPeca < ordemDeServico.obterNumeroDeServicos(); indexPeca++) {
					
					valorPecas = ordemDeServico.obterPrecoTotalDasPecas(indexPeca);
					receitaPecas += valorPecas;
					
					pecasTM.setValueAt(ordemDeServico.obterDescricaoDaPeca(indexPeca), pecasRowCount, 0);
					pecasTM.setValueAt(ordemDeServico.obterQuantidadeDePecas(indexPeca), pecasRowCount, 1);
					pecasTM.setValueAt(ordemDeServico.obterPrecoUnitarioDaPeca(indexPeca), pecasRowCount, 2);
					pecasTM.setValueAt(valorPecas, pecasRowCount, 3);
					
					if(pecasRowCount == pecasTM.getRowCount())
						pecasTM.addRow(new Object [] {null,null,null,null});
					
					pecasRowCount++;
				}
				
				receitaServicosTextField.setText(String.format("%.2f", receitaServicos));
				receitaPecasTextField.setText(String.format("%.2f", receitaPecas));
				receitaTotalTextField.setText(String.format("%.2f", receitaServicos + receitaPecas));
			}
				
		}
	}
	
}
