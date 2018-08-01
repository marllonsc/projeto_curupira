package code.janelas;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JPanel;



public class InternalFrameRacaCategoria extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	JLabel label_principal = new JLabel("");
	final JPanel panel_tampa = new JPanel();
    final JLabel label_vacina = new JLabel("");
    final JLabel label_praticaZoo = new JLabel("");
    final JLabel label_excluir = new JLabel("");
    JLabel lblConfiguraes = new JLabel("Configurações");
    final JLabel label_categoria = new JLabel("");
    final JLabel label_raca = new JLabel("");
    PanelExcluirConfiguracao panelExcluirConfiguracao = new PanelExcluirConfiguracao();
    PanelConfiguracoes panelConfiguracoes4 = new PanelConfiguracoes("P. Zootécnica");
    PanelConfiguracoes panelConfiguracoes = new PanelConfiguracoes("Categoria");
    PanelConfiguracoes panelConfiguracoes2 = new PanelConfiguracoes("Raça");
    PanelConfiguracoes panelConfiguracoes3 = new PanelConfiguracoes("Vacinas");
	
    public InternalFrameRacaCategoria() {
		
		 super("Configurações",
	              false, //resizable
	              true, //closable
	              false, //maximizable
	              false);
		 
		 setFrameIcon(null);
		 setBackground(Color.WHITE);
	     setSize(747, 570);  
	     setLocation(30, 44);
	     setResizable(false);
	     getContentPane().setLayout(null);
	     
	     
	     panelExcluirConfiguracao.setBounds(23, 5, 720, 533);
	     getContentPane().add(panelExcluirConfiguracao);
	     panelExcluirConfiguracao.setVisible(false);
	     
	     
	     panelConfiguracoes4.setBounds(23, 5, 720, 533);
	     getContentPane().add(panelConfiguracoes4);
	     panelConfiguracoes4.setVisible(false);
	     
	     
	 
	     panelConfiguracoes.setBounds(0, 0, 720, 528);
	     getContentPane().add(panelConfiguracoes);
	     panelConfiguracoes.setVisible(false);
	     
	     
	     
	     panelConfiguracoes2.setBounds(23, 5, 720, 521);
	     getContentPane().add(panelConfiguracoes2);
	     panelConfiguracoes2.setVisible(false);
	     
	     
	     panelConfiguracoes3.setBounds(23, 5, 720, 533);
	     getContentPane().add(panelConfiguracoes3);
	     panelConfiguracoes3.setVisible(false);
	     
	     
	     label_praticaZoo.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseExited(MouseEvent e) {
	     		
	   	     label_praticaZoo.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("")));

	     		
	     	}
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		
	            panelConfiguracoes.setVisible(false);
	     		panelConfiguracoes2.setVisible(false);
	     		panelConfiguracoes3.setVisible(false);
	     		panelExcluirConfiguracao.setVisible(false);
	     		panelConfiguracoes4.setVisible(true);
	     		panel_tampa.setVisible(true);
	     		
	     	}
	     });
	     label_praticaZoo.addMouseMotionListener(new MouseMotionAdapter() {
	     	@Override
	     	public void mouseMoved(MouseEvent e) {
	     		
	   	     label_praticaZoo.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("/code/imagens/bt_práticas zootecnicas2.jpg")));

	     		
	     	}
	     });
	     
	  
	     label_excluir.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseExited(MouseEvent e) {
	     		label_excluir.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("")));
	     		
	     	}
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		
	     		panelExcluirConfiguracao.setVisible(true);
	     		 panelConfiguracoes.setVisible(false);
		     		panelConfiguracoes2.setVisible(false);
		     		panelConfiguracoes3.setVisible(false);
		     		panelConfiguracoes4.setVisible(false);
	     		
	     	}
	     });
	     label_excluir.addMouseMotionListener(new MouseMotionAdapter() {
	     	@Override
	     	public void mouseMoved(MouseEvent e) {
	     		label_excluir.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("/code/imagens/bt_lixeira.jpg")));
	     		
	     	}
	     });
	     
	     
	     panel_tampa.setBackground(Color.WHITE);
	     panel_tampa.setBounds(337, 407, 90, 131);
	     getContentPane().add(panel_tampa);
	     label_excluir.setBackground(Color.WHITE);
	     panel_tampa.setVisible(false);
	     
	     label_excluir.setBounds(337, 407, 80, 123);
	     getContentPane().add(label_excluir);
	     
	     
	     label_raca.setBounds(410, 187, 294, 92);
	     getContentPane().add(label_raca);
	     label_raca.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseExited(MouseEvent e) {
	   	     label_raca.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("")));

	     		
	     	}
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		
	     		panelConfiguracoes.setVisible(false);
	     		panelConfiguracoes2.setVisible(true);
	     		panelConfiguracoes3.setVisible(false);
	     		panelConfiguracoes4.setVisible(false);
	     		panelExcluirConfiguracao.setVisible(false);

	     		panel_tampa.setVisible(true);
	     	}
	     });
	     label_raca.addMouseMotionListener(new MouseMotionAdapter() {
	     	@Override
	     	public void mouseMoved(MouseEvent e) {
	   	     label_raca.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("/code/imagens/bt_raca.jpg")));

	     		
	     	}
	     });
	     label_praticaZoo.setBounds(420, 291, 284, 97);
	     getContentPane().add(label_praticaZoo);
	     
	     label_vacina.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseExited(MouseEvent e) {
	     		
	     		 label_vacina.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("")));
	     		
	     	}
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		
	     		panelConfiguracoes.setVisible(false);
	     		panelConfiguracoes2.setVisible(false);
	     		panelConfiguracoes3.setVisible(true);
	     		panelConfiguracoes4.setVisible(false);
	     		panelExcluirConfiguracao.setVisible(false);

	     		panel_tampa.setVisible(true);
	     	
	     	}
	     });
	     label_vacina.addMouseMotionListener(new MouseMotionAdapter() {
	     	@Override
	     	public void mouseMoved(MouseEvent e) {
	     		 label_vacina.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("/code/imagens/bt_vacina.jpg")));
	     		
	     	}
	     });
	    
	     label_vacina.setBounds(73, 290, 274, 97);
	     getContentPane().add(label_vacina);
	     
	     
	     lblConfiguraes.setFont(new Font("Dialog", Font.BOLD, 40));
	     lblConfiguraes.setBounds(197, 0, 342, 48);
	     getContentPane().add(lblConfiguraes);
	     
	     
	     label_categoria.setBounds(63, 187, 284, 92);
	     getContentPane().add(label_categoria);
	     label_categoria.addMouseListener(new MouseAdapter() {
	     	@Override
	     	public void mouseExited(MouseEvent e) {
	     		
	     		label_categoria.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("")));
	     	}
	     	@Override
	     	public void mouseClicked(MouseEvent e) {
	     		
	     		
	     		panelConfiguracoes.setVisible(true);
	     		panelConfiguracoes2.setVisible(false);
	     		panelConfiguracoes3.setVisible(false);
	     		panelConfiguracoes4.setVisible(false);
	     		panelExcluirConfiguracao.setVisible(false);

	     		panel_tampa.setVisible(true);
	     	
	     	}
	     });
	     label_categoria.addMouseMotionListener(new MouseMotionAdapter() {
	     	@Override
	     	public void mouseMoved(MouseEvent e) {
	     		
	     		label_categoria.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("/code/imagens/bt_categoria.jpg")));
	     	}
	     });
	     label_principal.setIcon(new ImageIcon(InternalFrameRacaCategoria.class.getResource("/code/imagens/especificacoes.jpg")));
	     label_principal.addMouseMotionListener(new MouseMotionAdapter() {
	     	
	    
	     	@Override
	     	public void mouseMoved(MouseEvent e) {
	     		
	     		if(!panelConfiguracoes.isVisible() && !panelConfiguracoes2.isVisible() && !panelConfiguracoes3.isVisible() && !panelConfiguracoes.isVisible() && !panelExcluirConfiguracao.isVisible()){
	     			
	     			panel_tampa.setVisible(false);
	     			desativaFuncoes(true);
	     			
	     		}else{
	     			panel_tampa.setVisible(true);
	     			desativaFuncoes(false);
	     		}
	     		
	     	}
	     });
	     
	     
	     
	     label_principal.setBounds(0, 0, 737, 542);
	     getContentPane().add(label_principal);
	     
	         
	     
		
		
	}
	
	private void desativaFuncoes(boolean entrada){
   	 label_categoria.setVisible(entrada);
   	 label_excluir.setVisible(entrada);
   	 label_praticaZoo.setVisible(entrada);
   	 label_raca.setVisible(entrada);
   	 label_vacina.setVisible(entrada);
   	    	 
    }
	
	public void reset(){
		
		panelConfiguracoes.setVisible(false);
		panelConfiguracoes2.setVisible(false);
		panelConfiguracoes3.setVisible(false);
		panelConfiguracoes4.setVisible(false);
		panelExcluirConfiguracao.setVisible(false);
		
	}
	
}
