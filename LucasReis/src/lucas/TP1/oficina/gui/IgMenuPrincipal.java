package lucas.TP1.oficina.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import lucas.TP1.oficina.Oficina;
import net.miginfocom.swing.MigLayout;

/**
 * Classe que representa o menu principal do programa,
 * onde as demais operações disponíveis podem ser escolhidas
 * através de uma Interface Gráfica.
 *
 * @author Lucas Reis
 */
@SuppressWarnings("serial")
public class IgMenuPrincipal extends JDialog {

	/**
	 * Contrutor da classe <code>IgMenuPrincipal</code>.
	 *
	 * @param oficina objeto do tipo <code>Oficina</code>
	 * para que esta classe invoque os métodos da mesma.
	 */
	public IgMenuPrincipal(Oficina oficina) {
		
		// Titulo
		setTitle("Oficina");
		
		// Desabilita o redimensionamento
		setResizable(false);
		
		// Posicionamento e dimensões
		setSize(250, 204);
		getContentPane().setLayout(new BorderLayout());
		
		// Painel de botões
		JPanel buttonPane = new JPanel();
		buttonPane.setBorder(new TitledBorder(null, "Menu Principal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(buttonPane, BorderLayout.CENTER);
		buttonPane.setLayout(new MigLayout("", "[45px,grow]", "[28px][][][]"));
		
		
		// Botão de cadastro
		JButton cadastrarButton = new JButton("Cadastrar");
		cadastrarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IgCadastrarCliente(oficina);
			}
		});
		buttonPane.add(cadastrarButton, "cell 0 0,alignx center,aligny center");
		
		// Botão Ordem de Serviço
		JButton ordemServicoButton = new JButton("Ordem de Serviço");
		ordemServicoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IgOrdemDeServico(oficina);
			}
		});
		buttonPane.add(ordemServicoButton, "cell 0 1,alignx center,aligny center");
		
		// Botão de relatório
		JButton relatorioButton = new JButton("Relatório");
		relatorioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IgRelatorioFinanceiro(oficina);
			}
		});
		buttonPane.add(relatorioButton, "cell 0 2,alignx center,aligny center");
		
		//Botão de Sair
		JButton sairButton = new JButton("Sair");
		sairButton.addActionListener( (e) -> System.exit(0)  );
		buttonPane.add(sairButton, "cell 0 3,alignx center,aligny center");
		
		// Configura a caixa de dialogo para que ela seja liberada para o sistema quando for fechada
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// Centraliza a caixa de diálogo
		setLocationRelativeTo(this);
		
		ativarLookAndFeel(new NimbusLookAndFeel());
		
		// Exibe a caixa de diálogo.
		setVisible(true);
	}

	/**
	 *  Ativa o look-and-feel em todos os componentes da da caixa de diálogo.
	 *  Retorna true se o look-and-feel foi ativado ou false caso contrário.
	 */
	private boolean ativarLookAndFeel(LookAndFeel  lookAndFeel ) {
		try { 
					UIManager.setLookAndFeel(lookAndFeel);
					SwingUtilities.updateComponentTreeUI(this);
					
		} catch (UnsupportedLookAndFeelException e) {
			System.err.printf("Não foi possível ativar o look-and-fell %s.", lookAndFeel.getName());
			return false;
		}
		return true;
	}
	
}
