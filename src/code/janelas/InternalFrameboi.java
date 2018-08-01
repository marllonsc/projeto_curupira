package code.janelas;


import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseMotionAdapter;

public class InternalFrameboi extends JInternalFrame{
	
	private static final long serialVersionUID = 1L;
	JPanel panel_producaodeLeite = new JPanel();

	final JPanel panel_cadastrar = new PanelCadastroExcluirAlterar("B","/code/imagens/foto_boi_cadastro.jpg","/code/imagens/cadastro.jpg");
		JPanel panel_modificar = new PanelCadastroExcluirAlterar("B","/code/imagens/foto_boi_cadastro.jpg","/code/imagens/alterar.jpg");
		ReproducaoAnimal reproducaoAnimal = new ReproducaoAnimal("B");
		PanelVisuzalizarRebanho panelVisuzalizarRebanho = new PanelVisuzalizarRebanho("B");
		PanelVacinacao panelVacinacao = new PanelVacinacao("B");
		PanelPraticaZootecnica panelPraticaZootecnica = new PanelPraticaZootecnica("B");
	
	Leite leite = new Leite();
	final JPanel panel_principal = new JPanel();
	
	public InternalFrameboi() {
		
		 super("Bovino",
	              false, //resizable
	              true, //closable
	              false, //maximizable
	              false);
		 getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
		 	@Override
		 	public void mouseMoved(MouseEvent e) {
		 		
		 		if(!panel_cadastrar.isVisible() && !panel_modificar.isVisible() && !reproducaoAnimal.isVisible() && !panelVisuzalizarRebanho.isVisible() && !panelVacinacao.isVisible() && !panelPraticaZootecnica.isVisible()){
		 			
		 			panel_principal.setVisible(true);
		 			
		 		}
		 		
		 		
		 	}
		 });
		 setFrameIcon(null);
		 setBackground(Color.WHITE);
	        setSize(747, 550);
	       
	        setLocation(30, 44);
	        setResizable(false);
		
		getContentPane().setLayout(null);
		
		
		panel_cadastrar.setVisible(false);
		panel_modificar.setVisible(false);
		
		
		panel_principal.setBackground(Color.WHITE);
		panel_principal.setBounds(0, 0, 737, 506);
		getContentPane().add(panel_principal);
		panel_principal.setLayout(null);
		
		final JLabel label_cadastrar = new JLabel("");
		label_cadastrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_cadastrar.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botão_boi_cadastrar.jpg")));
				
				
			}
		});
		label_cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_cadastrar.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_cadastrar.setVisible(true);
				getContentPane().add(panel_cadastrar);
				panel_principal.setVisible(false);
				panel_modificar.setVisible(false);
				reproducaoAnimal.setVisible(false);
				panelVisuzalizarRebanho.setVisible(false);
				panelVacinacao.setVisible(false);
				panelPraticaZootecnica.setVisible(false);
				
			}
		});
		
		final JLabel label_visualizarRebanho = new JLabel("");
		label_visualizarRebanho.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {	
				label_visualizarRebanho.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botão_boi_visualizar_rebanho.jpg")));
			}
		});
		label_visualizarRebanho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_visualizarRebanho.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelVisuzalizarRebanho = new PanelVisuzalizarRebanho("B");
				panel_modificar.setVisible(false);
				getContentPane().add(panelVisuzalizarRebanho);
				panelVisuzalizarRebanho.setVisible(true);
				panel_principal.setVisible(false);
				panel_cadastrar.setVisible(false);
				reproducaoAnimal.setVisible(false);
				panelVacinacao.setVisible(false);
				panelPraticaZootecnica.setVisible(false);
			}
		});
		
		final JLabel label_alterarDados = new JLabel("");
		label_alterarDados.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_alterarDados.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botao_boi_alterar.jpg")));
				
			}
		});
		label_alterarDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_alterarDados.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {

				panel_modificar.setVisible(true);
				getContentPane().add(panel_modificar);
				panel_principal.setVisible(false);
				panel_cadastrar.setVisible(false);
				reproducaoAnimal.setVisible(false);
				panelVisuzalizarRebanho.setVisible(false);
				panelVacinacao.setVisible(false);
				panelPraticaZootecnica.setVisible(false);
			}
		});
		
		final JLabel label_reproducao = new JLabel("");
		label_reproducao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_reproducao.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				reproducaoAnimal.setVisible(true);
				getContentPane().add(reproducaoAnimal);
				panel_principal.setVisible(false);
				panel_cadastrar.setVisible(false);
				panel_modificar.setVisible(false);
				panelVisuzalizarRebanho.setVisible(false);
				panelVacinacao.setVisible(false);
				panelPraticaZootecnica.setVisible(false);
			}
		});
		
		label_reproducao.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_reproducao.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botao_boi_reproducao.jpg")));
				
			}
		});
		
		final JLabel label_racao = new JLabel("");
		label_racao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_racao.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));

			}
		});
		label_racao.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_racao.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botao_boi_racao.jpg")));
				
			}
		});
		
		final JLabel label_producao = new JLabel("");
		label_producao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_producao.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
				
			}
		});
		label_producao.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_producao.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botao_boi_leite.jpg")));
				
			}
		});
		
		final JLabel label_manejo = new JLabel("");
		label_manejo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_manejo.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panelPraticaZootecnica = new PanelPraticaZootecnica("B");
				panel_modificar.setVisible(false);
				getContentPane().add(panelPraticaZootecnica);
				panelVisuzalizarRebanho.setVisible(false);
				panel_principal.setVisible(false);
				panel_cadastrar.setVisible(false);
				reproducaoAnimal.setVisible(false);
				panelVacinacao.setVisible(false);
				panelPraticaZootecnica.setVisible(true);
			}
		});
		label_manejo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_manejo.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botao_boi_manejo.jpg")));
				
			}
		});
		
		final JLabel label_vacina = new JLabel("");
		label_vacina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_vacina.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_cadastrar.setVisible(false);
				panelVacinacao = new PanelVacinacao("B");
				getContentPane().add(panelVacinacao);
				panelVacinacao.setVisible(true);
				panel_principal.setVisible(false);
				panel_modificar.setVisible(false);
				reproducaoAnimal.setVisible(false);
				panelVisuzalizarRebanho.setVisible(false);
				panelPraticaZootecnica.setVisible(false);
				
			}
		});
		label_vacina.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_vacina.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botao_boi_vacina.jpg")));

				
			}
		});
		
		final JLabel label_relatorios = new JLabel("");
		label_relatorios.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_relatorios.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
				
			}
		});
		label_relatorios.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_relatorios.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/botao_boi_relatorio.jpg")));

			}
		});
		label_relatorios.setBounds(465, 436, 232, 46);
		panel_principal.add(label_relatorios);
		label_vacina.setBounds(465, 391, 232, 39);
		panel_principal.add(label_vacina);
		label_manejo.setBounds(465, 343, 232, 39);
		panel_principal.add(label_manejo);
		label_producao.setBounds(465, 298, 232, 39);
		panel_principal.add(label_producao);
		label_racao.setBounds(465, 248, 232, 46);
		panel_principal.add(label_racao);
		label_reproducao.setBounds(465, 198, 232, 46);
		panel_principal.add(label_reproducao);
		label_alterarDados.setBounds(465, 154, 233, 39);
		panel_principal.add(label_alterarDados);
		label_visualizarRebanho.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
		label_visualizarRebanho.setBounds(465, 104, 233, 46);
		panel_principal.add(label_visualizarRebanho);
		label_cadastrar.setIcon(new ImageIcon(InternalFrameboi.class.getResource("")));
		label_cadastrar.setBounds(465, 60, 233, 39);
		panel_principal.add(label_cadastrar);
		
		JLabel label_central = new JLabel("");
		label_central.setBackground(Color.WHITE);
		label_central.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				
				
				
			}
		});
		label_central.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
		});
		label_central.setIcon(new ImageIcon(InternalFrameboi.class.getResource("/code/imagens/internal frame boi/tela boi.jpg")));
		label_central.setBounds(0, 0, 737, 520);
		panel_principal.add(label_central);
		
		JLabel label = new JLabel("");
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
		});
		label.setBounds(465, 154, 233, 39);
		panel_principal.add(label);
		
		
	}
	public void reset(){
		panel_cadastrar.setVisible(false);
		panel_modificar.setVisible(false);
		panel_principal.setVisible(true);
		panel_producaodeLeite.setVisible(false);
	
	}
}
	
	
	


