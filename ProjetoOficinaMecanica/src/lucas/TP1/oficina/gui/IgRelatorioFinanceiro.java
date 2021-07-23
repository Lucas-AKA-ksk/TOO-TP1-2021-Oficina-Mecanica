package lucas.TP1.oficina.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

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
import net.miginfocom.swing.MigLayout;

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

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			IgRelatorioFinanceiro dialog = new IgRelatorioFinanceiro();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 * @param oficina 
	 */
	public IgRelatorioFinanceiro(Oficina oficina) {
		
		// Titulo
		setTitle("Ordem de serviço");
		
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
		periodoPanel.add(dataInicialTextField, "flowx,cell 1 0,alignx left");
		dataInicialTextField.setColumns(10);
			
		// Label de Data Final
		JLabel dataFinalLabel = new JLabel("Data final:");
		dataFinalLabel.setDisplayedMnemonic(KeyEvent.VK_F);
		periodoPanel.add(dataFinalLabel, "cell 2 0,alignx left");
		dataFinalLabel.setLabelFor(dataFinalTextField);
			
		// TextField de Data Final
		dataFinalTextField = new JTextField();
		periodoPanel.add(dataFinalTextField, "flowx,cell 3 0,alignx left");
		dataFinalTextField.setColumns(10);
			
		// Botão Gerar Relatório
		JButton gerarRelatorioButton = new JButton("Gerar Relatório");
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
		okButton.setMnemonic(KeyEvent.VK_G);
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
			
		// Botão cancelar
		JButton cancelarButton = new JButton("Cancelar");
		cancelarButton.setActionCommand("Cancel");
		buttonPane.add(cancelarButton);
			
		
		// Configura a caixa de dialogo para que ela seja liberada para o sistema quando for fechada
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Centraliza a caixa de diálogo
		setLocationRelativeTo(this);
		
		// Exibe a caixa de diálogo.
		setVisible(true);
	}

}
