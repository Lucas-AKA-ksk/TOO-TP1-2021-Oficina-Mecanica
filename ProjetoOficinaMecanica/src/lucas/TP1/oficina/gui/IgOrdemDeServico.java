package lucas.TP1.oficina.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

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
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IgOrdemDeServico dialog = new IgOrdemDeServico();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public IgOrdemDeServico() {
		setResizable(false);
		setTitle("Ordem de serviço");
		setBounds(100, 100, 734, 653);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[328.00][]", "[][][][50,grow]"));
		{
			JPanel ordemServicoPanel = new JPanel();
			ordemServicoPanel.setBorder(new TitledBorder(null, "Ordem de Servi\u00E7o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(ordemServicoPanel, "cell 0 0,growx,aligny baseline");
			ordemServicoPanel.setLayout(new MigLayout("", "[][139.00][139.00][139.00][139.00][86.00]", "[][][]"));
			{
				JLabel numeroLabel = new JLabel("Número:");
				numeroLabel.setDisplayedMnemonic(KeyEvent.VK_N);
				ordemServicoPanel.add(numeroLabel, "cell 0 0,alignx left");
				numeroTextField = new JTextField();
				numeroLabel.setLabelFor(numeroTextField);
				ordemServicoPanel.add(numeroTextField, "cell 1 0 4 1,growx");
				numeroTextField.setColumns(10);
			}
			{
				JButton pesquisarButton = new JButton("Pesquisar");
				ordemServicoPanel.add(pesquisarButton, "cell 5 0");
			}
			{
				JLabel dataLabel = new JLabel("Data:");
				ordemServicoPanel.add(dataLabel, "cell 0 1,alignx left");
				dataTextField = new JTextField();
				dataTextField.setEditable(false);
				dataLabel.setLabelFor(dataTextField);
				ordemServicoPanel.add(dataTextField, "cell 1 1 3 1,alignx left");
				dataTextField.setColumns(10);
			}
			{
				JLabel horaLabel = new JLabel("Hora:");
				horaLabel.setLabelFor(horaLabel);
				ordemServicoPanel.add(horaLabel, "cell 0 2,alignx left");
			}
			{
				horaTextField = new JTextField();
				horaTextField.setEditable(false);
				ordemServicoPanel.add(horaTextField, "cell 1 2 2 1,alignx left");
				horaTextField.setColumns(10);
			}
		}
		{
			JPanel clientePanel = new JPanel();
			clientePanel.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(clientePanel, "cell 1 0,growx,aligny baseline");
			clientePanel.setLayout(new MigLayout("", "[][][][grow]", "[][][]"));
			{
				JLabel cpfLabel = new JLabel("CPF:");
				clientePanel.add(cpfLabel, "cell 0 0,alignx left");
				cpfTextField = new JTextField();
				cpfTextField.setEditable(false);
				cpfLabel.setLabelFor(cpfTextField);
				clientePanel.add(cpfTextField, "cell 1 0 3 1,alignx left");
				cpfTextField.setColumns(10);
			}
			{
				JLabel nomeLabel = new JLabel("Nome:");
				clientePanel.add(nomeLabel, "cell 0 1,alignx trailing");
				nomeTextField = new JTextField();
				nomeTextField.setEditable(false);
				nomeLabel.setLabelFor(nomeTextField);
				clientePanel.add(nomeTextField, "cell 1 1 3 1,growx");
				nomeTextField.setColumns(10);
			}
			{
				JLabel codigoCarroLabel = new JLabel("Carro:");
				clientePanel.add(codigoCarroLabel, "cell 0 2,alignx trailing");
				JComboBox<String> codigoCarrocomboBox = new JComboBox<>();
				codigoCarroLabel.setLabelFor(codigoCarrocomboBox);
				clientePanel.add(codigoCarrocomboBox, "flowx,cell 1 2,alignx left");
			}
			{
				JLabel modeloLabel = new JLabel("Modelo:");
				clientePanel.add(modeloLabel, "flowx,cell 3 2,alignx right");
				modeloTextField = new JTextField();
				modeloTextField.setEditable(false);
				modeloLabel.setLabelFor(modeloTextField);
				clientePanel.add(modeloTextField, "cell 3 2,alignx right");
				modeloTextField.setColumns(10);
			}
		}
		{
			JPanel servicosPanel = new JPanel();
			servicosPanel.setBorder(new TitledBorder(null, "Servi\u00E7os", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(servicosPanel, "cell 0 1 2 1,grow");
			servicosPanel.setLayout(new MigLayout("", "[674.00px,fill]", "[123.00px]"));
			{
				JScrollPane scrollPane = new JScrollPane();
				servicosPanel.add(scrollPane, "cell 0 0,grow");
				{
					servicosTable = new JTable();
					servicosTable.setModel(new DefaultTableModel(
						new Object[][] {
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
							{null, null, null},
						},
						new String[] {
							"N\u00BA", "Descri\u00E7\u00E3o", "Pre\u00E7o"
						}
					));
					servicosTable.getColumnModel().getColumn(0).setResizable(false);
					servicosTable.getColumnModel().getColumn(0).setPreferredWidth(25);
					servicosTable.getColumnModel().getColumn(1).setResizable(false);
					servicosTable.getColumnModel().getColumn(1).setPreferredWidth(350);
					servicosTable.getColumnModel().getColumn(2).setResizable(false);
					servicosTable.getColumnModel().getColumn(2).setPreferredWidth(100);
					scrollPane.setViewportView(servicosTable);
				}
			}
		}
		{
			JPanel pecasPanel = new JPanel();
			pecasPanel.setBorder(new TitledBorder(null, "Pe\u00E7as", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(pecasPanel, "cell 0 2 2 1,grow");
			pecasPanel.setLayout(new MigLayout("", "[666.00px]", "[123.00px]"));
			{
				JScrollPane scrollPane = new JScrollPane();
				pecasPanel.add(scrollPane, "cell 0 0,grow");
				{
					pecasTable = new JTable();
					pecasTable.setModel(new DefaultTableModel(
						new Object[][] {
							{"", null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
							{null, null, null, null, null},
						},
						new String[] {
							"N\u00BA", "Descri\u00E7\u00E3o", "Quantidade", "Valor Unit\u00E1rio", "Valor Total"
						}
					));
					pecasTable.getColumnModel().getColumn(0).setResizable(false);
					pecasTable.getColumnModel().getColumn(0).setPreferredWidth(50);
					pecasTable.getColumnModel().getColumn(1).setResizable(false);
					pecasTable.getColumnModel().getColumn(1).setPreferredWidth(225);
					pecasTable.getColumnModel().getColumn(2).setResizable(false);
					pecasTable.getColumnModel().getColumn(3).setResizable(false);
					pecasTable.getColumnModel().getColumn(4).setResizable(false);
					scrollPane.setViewportView(pecasTable);
				}
			}
		}
		{
			JPanel valorTotalPanel = new JPanel();
			valorTotalPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(valorTotalPanel, "cell 0 3 2 1,grow");
			valorTotalPanel.setLayout(new MigLayout("", "[55px][122px]", "[28px]"));
			{
				JLabel valorTotalLabel = new JLabel("Valor total da ordem de serviço:");
				valorTotalPanel.add(valorTotalLabel, "cell 0 0,alignx left,aligny center");
				ValorTotalTextField = new JTextField();
				ValorTotalTextField.setEditable(false);
				valorTotalLabel.setLabelFor(ValorTotalTextField);
				valorTotalPanel.add(ValorTotalTextField, "cell 1 0,alignx left,aligny center");
				ValorTotalTextField.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton gravarButton = new JButton("Gravar");
				gravarButton.setMnemonic(KeyEvent.VK_G);
				gravarButton.setActionCommand("OK");
				buttonPane.add(gravarButton);
				getRootPane().setDefaultButton(gravarButton);
			}
			{
				JButton cancelarButton = new JButton("Cancelar");
				cancelarButton.setActionCommand("Cancel");
				buttonPane.add(cancelarButton);
			}
		}
		// Configura a caixa de dialogo para que ela seja liberada para o sistema quando for fechada
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Centraliza a caixa de diálogo
		setLocationRelativeTo(this);
		
		// Exibe a caixa de diálogo.
		setVisible(true);
	}

}
