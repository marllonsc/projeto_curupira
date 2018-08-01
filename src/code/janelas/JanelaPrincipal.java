package code.janelas;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class JanelaPrincipal extends JFrame {
	
	private static final long serialVersionUID = 1L;
	final JPanel panel = new JPanel();
	JLabel label_animalFora = new JLabel("");
	JLabel label_semAnimais = new JLabel("");
	

	public JanelaPrincipal() {
		
		
		super("Curupira");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final InternalFrameboi internalFrameboi = new InternalFrameboi();
		internalFrameboi.setLocation(137, 68);
		panel.add(internalFrameboi);		
		internalFrameboi.setVisible(false);
		
		final InternalFrameCabra cabra = new InternalFrameCabra();
		cabra.setLocation(137, 68);
		panel.add(cabra);
		cabra.setVisible(false);
		
		final InternalFrameSuino frameSuino = new InternalFrameSuino();
		frameSuino.setLocation(137,68);
		panel.add(frameSuino);
		frameSuino.setVisible(false);
		
		final InternalFrameOvino frameOvino = new InternalFrameOvino();
		frameOvino.setLocation(137, 68);
		panel.add(frameOvino);
		frameOvino.setVisible(false);
		
		final InternalFrameAves frameAves = new InternalFrameAves();
		frameAves.setLocation(137, 68);
		panel.add(frameAves);
		frameAves.setVisible(false);
		
		final InternalFrameRacaCategoria internalFrameRacaCategoria = new InternalFrameRacaCategoria();
		internalFrameRacaCategoria.setLocation(137,68);
		panel.add(internalFrameRacaCategoria);
		internalFrameRacaCategoria.setVisible(false);
		
		getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		setSize(1024,720);
		getContentPane().setLayout(null);
		
		
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0,1022,686);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		final JLabel label_bovino = new JLabel("");
		label_bovino.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_bovino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/bovino.jpg")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/vaca tela inicial.png")));
				label_semAnimais.setVisible(true);
			}
		});
		label_bovino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_bovino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_semAnimais.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				internalFrameboi.reset();
				internalFrameboi.setVisible(true);
				cabra.setVisible(false);
				frameSuino.setVisible(false);
				frameOvino.setVisible(false);
				frameAves.setVisible(false);
				internalFrameRacaCategoria.setVisible(false);

			}
		});
		
		final JLabel label_caprino = new JLabel("");
		label_caprino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_caprino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_semAnimais.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cabra.reset();
				cabra.setVisible(true);
				internalFrameboi.setVisible(false);
				frameSuino.setVisible(false);
				frameOvino.setVisible(false);
				frameAves.setVisible(false);
				internalFrameRacaCategoria.setVisible(false);

			}
		});
		label_caprino.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_caprino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/capino.jpg")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/cabra.png")));
				label_semAnimais.setVisible(true);
			}
		});
		
		final JLabel label_suino = new JLabel("");
		label_suino.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_suino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/suino.jpg")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/porco.png")));
				label_semAnimais.setVisible(true);
			}
		});
		label_suino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_suino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_semAnimais.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frameSuino.reset();
				frameSuino.setVisible(true);
				internalFrameboi.setVisible(false);
				cabra.setVisible(false);
				frameOvino.setVisible(false);
				frameAves.setVisible(false);
				internalFrameRacaCategoria.setVisible(false);

				
			}
		});
		
		final JLabel label_ovino = new JLabel("");
		label_ovino.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_ovino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/ovino.jpg")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/ovelha.png")));
				label_semAnimais.setVisible(true);
			}
		});
		label_ovino.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_ovino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_semAnimais.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frameOvino.reset();
				frameOvino.setVisible(true);
				internalFrameboi.setVisible(false);
				frameSuino.setVisible(false);
				cabra.setVisible(false);
				frameAves.setVisible(false);
				internalFrameRacaCategoria.setVisible(false);
				
			}
		});
		
		final JLabel label_ferramentas = new JLabel("");
		label_ferramentas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_ferramentas.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/ferramentas.jpg")));
			}
		});
		label_ferramentas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_ferramentas.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				frameOvino.setVisible(false);
				internalFrameboi.setVisible(false);
				frameSuino.setVisible(false);
				cabra.setVisible(false);
				frameAves.setVisible(false);
				internalFrameRacaCategoria.reset();
				internalFrameRacaCategoria.setVisible(true);
				
			}
		});
		
		final JLabel label_manual = new JLabel("");
		label_manual.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_manual.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/manual.jpg")));
				
			}
		});
		label_manual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_manual.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				
			}
		});
		
		final JLabel label_creditos = new JLabel("");
		label_creditos.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_creditos.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/creditos.jpg")));
				
			}
		});
		
		label_creditos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_creditos.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				
			}
		});
		label_creditos.setBounds(105, 524, 99, 32);
		panel.add(label_creditos);
		label_manual.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
		label_manual.setBounds(824, 225, 172, 171);
		panel.add(label_manual);
		
		label_animalFora.setBounds(410, 379, 248, 197);
		panel.add(label_animalFora);
		
		
		label_semAnimais.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/casa sem bixo.jpg")));
		label_semAnimais.setBounds(467, 225, 240, 215);
		panel.add(label_semAnimais);
		label_ferramentas.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
		label_ferramentas.setBounds(830, 418, 157, 171);
		panel.add(label_ferramentas);
		label_ovino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
		label_ovino.setBounds(77, 418, 152, 44);
		panel.add(label_ovino);
		label_suino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
		label_suino.setBounds(77, 372, 152, 44);
		panel.add(label_suino);
		label_caprino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
		label_caprino.setBounds(77, 323, 152, 44);
		panel.add(label_caprino);
		label_bovino.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
		label_bovino.setBounds(77, 275, 152, 44);
		panel.add(label_bovino);
		
		final JLabel label_aves = new JLabel("");
		label_aves.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_aves.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/aves.jpg")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/aves.png")));
				label_semAnimais.setVisible(true);
			}
		});
		label_aves.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_aves.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_animalFora.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
				label_semAnimais.setVisible(false);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frameAves.reset();
				frameAves.setVisible(true);
				internalFrameboi.setVisible(false);
				frameSuino.setVisible(false);
				cabra.setVisible(false);
				frameOvino.setVisible(false);
				
				
			}
		});
		label_aves.setBounds(77, 470, 152, 44);
		panel.add(label_aves);
		
		label_aves.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("")));
		JLabel label_imagemInicial = new JLabel("");

		label_imagemInicial.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/code/imagens/tela inciial final.jpg")));
		label_imagemInicial.setBounds(0, 0, 1045, 686);
		panel.add(label_imagemInicial);
		
		
		
	}
	
	public static void main(String[] args) {
		
		JanelaPrincipal janelaPrincipal = new JanelaPrincipal();
		janelaPrincipal.setVisible(true);
		
		
	}
}
