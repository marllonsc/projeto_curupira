package code.janelas;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import code.sql.SqlConfiguracoes;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;

public class PanelConfiguracoes extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField_nome;
	private JTextField textField_perido;
	private SqlConfiguracoes sqlConfiguracoes = new SqlConfiguracoes();
	
	
	public PanelConfiguracoes(final String titulo) {
		setBackground(Color.WHITE);
		
		setBounds(23, 5, 720, 450);
		setLayout(null);
		
		textField_perido = new JTextField();
		textField_perido.setBounds(136, 127, 386, 19);
		add(textField_perido);
		textField_perido.setColumns(10);
		textField_perido.setVisible(false);
		
		JLabel lblPeriodo = new JLabel("Periodo:");
		lblPeriodo.setBounds(75, 131, 78, 15);
		add(lblPeriodo);
		lblPeriodo.setVisible(false);
		
		JLabel lblCadastrar = new JLabel(titulo+" Cadastrar");
		lblCadastrar.setFont(new Font("Dialog", Font.BOLD, 30));
		lblCadastrar.setBounds(70, 0, 669, 43);
		add(lblCadastrar);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(75, 98, 61, 15);
		add(lblNome);
		
		textField_nome = new JTextField();
		textField_nome.setBounds(123, 96, 400, 19);
		add(textField_nome);
		textField_nome.setColumns(10);
		
		final JRadioButton radioButton_bovino = new JRadioButton("");
		radioButton_bovino.setBounds(105, 194, 21, 23);
		add(radioButton_bovino);
		
		final JRadioButton radioButton_caprino = new JRadioButton("");
		radioButton_caprino.setBounds(229, 194, 21, 23);
		add(radioButton_caprino);
		
		final JRadioButton radioButton_suino = new JRadioButton("");
		radioButton_suino.setBounds(353, 194, 21, 23);
		add(radioButton_suino);
		
		final JRadioButton radioButton_ovino = new JRadioButton("");
		radioButton_ovino.setBounds(471, 194, 21, 23);
		add(radioButton_ovino);
		
		final JRadioButton radioButton_aves = new JRadioButton("");
		radioButton_aves.setBounds(584, 194, 21, 23);
		add(radioButton_aves);
		
		final ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(radioButton_aves);
		bgroup.add(radioButton_bovino);
		bgroup.add(radioButton_caprino);
		bgroup.add(radioButton_ovino);
		bgroup.add(radioButton_suino);
		
		final JLabel label_cancelar = new JLabel("");
		label_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_cancelar.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));
				
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		label_cancelar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_cancelar.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/panel reprodução/bt_cancelar.jpg")));

				
			}
		});
		label_cancelar.setBounds(40, 393, 96, 31);
		add(label_cancelar);
		
		final JLabel label_cadastrar = new JLabel("");
		label_cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_cadastrar.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("")));

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String animal="";
				
				if(radioButton_aves.isSelected()){
				animal = "A";
				}else if(radioButton_bovino.isSelected()){
					animal = "B";
				}else if(radioButton_caprino.isSelected()){
					animal = "C";
				}else if(radioButton_ovino.isSelected()){
					animal = "O";
				}else if(radioButton_suino.isSelected()){
					animal = "S";
				}
				
				if(titulo.equalsIgnoreCase("Raça")){
					
					boolean resultado = sqlConfiguracoes.cadastraRaca(textField_nome.getText(), animal);
					
					if(resultado){
						textField_nome.setText("");
						JOptionPane.showMessageDialog(null,
								"Raça Cadastrada com Sucesso!");
					}else{
						JOptionPane.showMessageDialog(null,
								"Raça não Cadastrada com Sucesso!");
					}
				}
				
				if(titulo.equalsIgnoreCase("Categoria")){
					
					boolean resultado = sqlConfiguracoes.cadastraCategoria(textField_nome.getText(), animal);
					
					if(resultado){
						textField_nome.setText("");
						JOptionPane.showMessageDialog(null,
								"Categoria Cadastrada com Sucesso!");
					}else{
						JOptionPane.showMessageDialog(null,
								"Categoria não Cadastrada com Sucesso!");
					}
				}
				
				if(titulo.equalsIgnoreCase("Vacinas")){
					
					boolean resultado = sqlConfiguracoes.cadastraVacina(textField_nome.getText(), textField_perido.getText());
					
					if(resultado){
						textField_nome.setText("");
						textField_perido.setText("");
						JOptionPane.showMessageDialog(null,
								"Vacina Cadastrada com Sucesso!");
					}else{
						JOptionPane.showMessageDialog(null,
								"Vacina não Cadastrada com Sucesso!");
					}
				}
				
				

				if(titulo.equalsIgnoreCase("P. Zootécnica")){
					
					boolean resultado = sqlConfiguracoes.cadastraPraticaZoo(textField_nome.getText());
					
					if(resultado){
						textField_nome.setText("");
						textField_perido.setText("");
						JOptionPane.showMessageDialog(null,
								"Prática Zootécnica Cadastrada com Sucesso!");
					}else{
						JOptionPane.showMessageDialog(null,
								"Prática Zootécnica não Cadastrada com Sucesso!");
					}
				}
				
				
				
			}
		});
		label_cadastrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_cadastrar.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("/code/imagens/bt_cadastro.jpg")));

				
			}
		});
		label_cadastrar.setBounds(579, 393, 102, 37);
		add(label_cadastrar);
		
		
		JLabel label_principal = new JLabel("");
		label_principal.setBackground(Color.WHITE);
		label_principal.setIcon(new ImageIcon(PanelConfiguracoes.class.getResource("/code/imagens/Cadastrar raca.jpg")));
		label_principal.setBounds(0, 0, 702, 436);
		add(label_principal);
		
		
		
		if(titulo.equalsIgnoreCase("Vacinas")){
			
			textField_perido.setVisible(true);
			lblPeriodo.setVisible(true);
			radioButton_aves.setVisible(false);
			radioButton_bovino.setVisible(false);
			radioButton_caprino.setVisible(false);
			radioButton_ovino.setVisible(false);
			radioButton_suino.setVisible(false);
		}
		
		if(titulo.equalsIgnoreCase("P. Zootécnica")){
			
			radioButton_aves.setVisible(false);
			radioButton_bovino.setVisible(false);
			radioButton_caprino.setVisible(false);
			radioButton_ovino.setVisible(false);
			radioButton_suino.setVisible(false);
			lblCadastrar.setBounds(140, 0, 470, 43);
			
		}
		

	}
}
