package code.janelas;

import javax.swing.JPanel;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import code.sql.SqlConfiguracoes;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;



public class PanelExcluirConfiguracao extends JPanel{

	private static final long serialVersionUID = 1L;
	SqlConfiguracoes configuracoes = new SqlConfiguracoes();
	JComboBox comboBox = new JComboBox();
	Vector<String> nomes = new Vector<String>();
	String decisao="";
	
	public PanelExcluirConfiguracao() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		setBounds(23, 5, 720, 450);
		
		final JLabel label_praticaZoo = new JLabel("");
		label_praticaZoo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_praticaZoo.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("")));

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				nomes.clear();
				nomes = configuracoes.retornaPraticaZoo();
				comboBox.setModel(new DefaultComboBoxModel(nomes));
				decisao = "Pratica";
			}
		});
		label_praticaZoo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_praticaZoo.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("/code/imagens/bt_práticas zootecnicas.jpg")));

				
			}
		});
		label_praticaZoo.setBounds(547, 126, 144, 56);
		add(label_praticaZoo);
		
		final JLabel label_vacinas = new JLabel("");
		label_vacinas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_vacinas.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("")));

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				nomes.clear();
				nomes = configuracoes.retornaVacinas();
				comboBox.setModel(new DefaultComboBoxModel(nomes));
				decisao = "Vacina";
				
			}
		});
		label_vacinas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_vacinas.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("/code/imagens/bt_vacina2.jpg")));

				
			}
		});
		label_vacinas.setBounds(373, 137, 135, 45);
		add(label_vacinas);
		
		final JLabel label_raca = new JLabel("");
		label_raca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_raca.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("")));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				nomes.clear();
				nomes = configuracoes.retornaNomeRaca();
				comboBox.setModel(new DefaultComboBoxModel(nomes));
				decisao = "Raça";
				
				
			}
		});
		label_raca.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_raca.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("/code/imagens/bt_raça2.jpg")));
				
			}
		});
		
		label_raca.setBounds(36, 126, 137, 66);
		add(label_raca);
		
		final JLabel label_categoria = new JLabel("");
		label_categoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_categoria.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("")));

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				nomes.clear();
				nomes = configuracoes.retornaNomeCategoria();
				comboBox.setModel(new DefaultComboBoxModel(nomes));
				decisao = "Categoria";
				
			}
		});
		label_categoria.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_categoria.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("/code/imagens/bt_categoria2.jpg")));
	
				
			}
		});
		label_categoria.setBounds(206, 137, 135, 45);
		add(label_categoria);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setFont(new Font("Dialog", Font.BOLD, 30));
		lblExcluir.setBounds(301, 12, 118, 36);
		add(lblExcluir);
		
		comboBox.setBounds(228, 237, 268, 24);
		add(comboBox);
		
		final JLabel label_cancelar = new JLabel("");
		label_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_cancelar.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("")));

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		label_cancelar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_cancelar.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("/code/imagens/bt_cancelar2.jpg")));

				
			}
		});
		label_cancelar.setBounds(39, 393, 97, 45);
		add(label_cancelar);
		
		final JLabel label_excluir = new JLabel("");
		label_excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_excluir.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("")));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean resultado = false;
				
				if(decisao.equalsIgnoreCase("Raça")){
					resultado = configuracoes.excluirRaca((String) comboBox.getSelectedItem());
				}else if(decisao.equalsIgnoreCase("Categoria")){
					resultado = configuracoes.excluirCategoria((String) comboBox.getSelectedItem());
				}else if(decisao.equalsIgnoreCase("Vacina")){
					resultado = configuracoes.excluirVacina((String) comboBox.getSelectedItem());
				}else if(decisao.equalsIgnoreCase("Pratica")){
					resultado = configuracoes.excluirPraticaZoo((String) comboBox.getSelectedItem());
				}
				
				if(resultado){
					nomes.clear();
					comboBox.setModel(new DefaultComboBoxModel(nomes));
					JOptionPane.showMessageDialog(null,
							"Excluido com Sucesso !!!");
					
				}else{
					JOptionPane.showMessageDialog(null,
							"Não foi Excluido !!!");
					
				}
				
			}
		});
		label_excluir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_excluir.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("/code/imagens/bt_excluir2.jpg")));

			}
		});
		label_excluir.setBounds(579, 393, 97, 45);
		add(label_excluir);
		
		JLabel label_principal = new JLabel("");
		label_principal.setBackground(Color.WHITE);
		label_principal.setIcon(new ImageIcon(PanelExcluirConfiguracao.class.getResource("/code/imagens/excluir.jpg")));
		label_principal.setBounds(0, 0, 720, 450);
		add(label_principal);
		
		JLabel label = new JLabel("");
		label.setBounds(579, 393, 97, 45);
		add(label);
		
		
		
	}
	

		
	
}
