package lucas.TP1.oficina.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import lucas.TP1.oficina.Oficina;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class IgMenuPrincipal extends JDialog {

	/**
	 * Create the dialog.
	 */
	public IgMenuPrincipal(Oficina oficina) {
		
		// Titulo
		setTitle("Oficina");
		
		// Desabilita o redimensionamento
		setResizable(false);
		
		// Posicionamento e dimensões
		setSize(250, 138);
		getContentPane().setLayout(new BorderLayout());
		
		// Painel de botões
		JPanel buttonPane = new JPanel();
		getContentPane().add(buttonPane, BorderLayout.CENTER);
		buttonPane.setLayout(new MigLayout("", "[45px,grow]", "[28px][][]"));
		
		
		// Botão de cadastro
		JButton cadastrarButton = new JButton("Cadastrar");
		
		// Registra o tratador de eventos do botão Cadastrar.
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IgCadastrarCliente(oficina);
			}
		});
		
		// Botão de relatório
		JButton relatorioButton = new JButton("Relatório");
		
		// Registra o tratador de eventos do botão Relatório.
		relatorioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IgRelatorioFinanceiro(oficina);
			}
		});
		
		//Botão de Sair
		JButton sairButton = new JButton("Sair");
		
		// Registra o tratador de eventos do botão Sair.
		sairButton.addActionListener( (e) -> System.exit(0)  );
		
				
		// Adiciona os botões no buttonPane			
		buttonPane.add(cadastrarButton, "cell 0 0,alignx center,aligny center");
		buttonPane.add(relatorioButton, "cell 0 1,alignx center,aligny center");
		buttonPane.add(sairButton, "cell 0 2,alignx center,aligny center");
		
		// Configura a caixa de dialogo para que ela seja liberada para o sistema quando for fechada
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Centraliza a caixa de diálogo
		setLocationRelativeTo(this);
		
		// Exibe a caixa de diálogo.
		setVisible(true);
	}

}
