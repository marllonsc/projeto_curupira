package code.janelas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Leite extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	JTextField textField_segunda;
	JTextField textField_terca;
	JTextField textField_Quarta;
	JTextField textField_quinta;
	JTextField textField_sexta;
	JLabel lblLeite = new JLabel("Leite");
	JLabel lblSegunda = new JLabel("Segunda");
	JLabel lblTera = new JLabel("Terça");
	JLabel lblQuarta = new JLabel("Quarta");
	JLabel lblQuinta = new JLabel("Quinta");
	JLabel lblSexta = new JLabel("Sexta");
	JButton btnAdcionarProduoDiaria = new JButton("Adcionar Produção Diaria");
	JButton btnGerarRelatorios = new JButton("Gerar Relatorios");
	JLabel label = new JLabel("");
	JLabel label_1 = new JLabel("");
	JLabel label_2 = new JLabel("");
	JLabel label_3 = new JLabel("");
	JLabel label_4 = new JLabel("");
	JLabel label_5 = new JLabel("");
	ProducaoLeite producaoLeite = new ProducaoLeite();
	private final JButton btnCancelar = new JButton("Cancelar");
	
	public Leite() {
		
		
		setLayout(null);
		
		
		lblLeite.setBounds(303, 5, 137, 47);
		lblLeite.setFont(new Font("Dialog", Font.BOLD, 39));
		add(lblLeite);
		
		
		lblSegunda.setBounds(71, 88, 70, 15);
		add(lblSegunda);
		
		
		lblTera.setBounds(212, 88, 52, 15);
		add(lblTera);
		
		
		lblQuarta.setBounds(335, 88, 57, 15);
		add(lblQuarta);
		
		
		lblQuinta.setBounds(463, 88, 57, 15);
		add(lblQuinta);
		
		
		lblSexta.setBounds(591, 88, 52, 15);
		add(lblSexta);
		
		textField_segunda = new JTextField();
		textField_segunda.setEditable(false);
		textField_segunda.setBounds(47, 115, 114, 19);
		add(textField_segunda);
		textField_segunda.setColumns(10);
		
		textField_terca = new JTextField();
		textField_terca.setEditable(false);
		textField_terca.setColumns(10);
		textField_terca.setBounds(173, 115, 114, 19);
		add(textField_terca);
		
		textField_Quarta = new JTextField();
		textField_Quarta.setEditable(false);
		textField_Quarta.setColumns(10);
		textField_Quarta.setBounds(303, 115, 114, 19);
		add(textField_Quarta);
		
		textField_quinta = new JTextField();
		textField_quinta.setEditable(false);
		textField_quinta.setColumns(10);
		textField_quinta.setBounds(442, 115, 114, 19);
		add(textField_quinta);
		
		textField_sexta = new JTextField();
		textField_sexta.setEditable(false);
		textField_sexta.setColumns(10);
		textField_sexta.setBounds(573, 115, 114, 19);
		add(textField_sexta);
		
		
		btnAdcionarProduoDiaria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				btnCancelar.setVisible(true);
				producaoLeite.setBounds(23, 22, 702, 459);
				producaoLeite.setVisible(true);
				limpartela(false);
				
				add(producaoLeite);
				limpartela(false);
				
				
				
			}
		});
		btnAdcionarProduoDiaria.setBounds(71, 225, 264, 25);
		add(btnAdcionarProduoDiaria);
		
		
		btnGerarRelatorios.setBounds(71, 321, 264, 25);
		add(btnGerarRelatorios);
		
		textField_segunda.setText("500");
		textField_terca.setText("800");
		textField_Quarta.setText("400");
		textField_quinta.setText("100");
		textField_sexta.setText("1000");
		
		
		
		
		label.setIcon(new ImageIcon(Leite.class.getResource("/code/imagens/tirando_leite_da_vaca.jpg")));
		label.setBounds(421, 200, 245, 175);
		add(label);
		
		//String resultado = verificacao(textField_segunda.getText());
		
		
		label_1.setIcon(new ImageIcon(Leite.class.getResource("/code/imagens/boliinha1.jpg")));
		label_1.setBounds(94, 146, 19, 15);
		add(label_1);
		
		//resultado = verificacao(textField_terca.getText());
		
		
		label_2.setIcon(new ImageIcon(Leite.class.getResource("/code/imagens/boliinha1.jpg")));
		label_2.setBounds(220, 146, 19, 15);
		add(label_2);
		
		//resultado = verificacao(textField_Quarta.getText());
		
		
		label_3.setIcon(new ImageIcon(Leite.class.getResource("/code/imagens/boliinha1.jpg")));
		label_3.setBounds(353, 146, 19, 15);
		add(label_3);
		
		//resultado = verificacao(textField_quinta.getText());
		
		label_4.setIcon(new ImageIcon(Leite.class.getResource("/code/imagens/boliinha1.jpg")));
		label_4.setBounds(488, 146, 19, 15);
		add(label_4);
		
		//resultado = verificacao(textField_sexta.getText());
		
		label_5.setIcon(new ImageIcon(Leite.class.getResource("/code/imagens/boliinha1.jpg")));
		label_5.setBounds(614, 146, 19, 15);
		add(label_5);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				producaoLeite.setVisible(false);
				btnCancelar.setVisible(false);
				limpartela(true);
			}
		});
		btnCancelar.setBounds(560, 375, 116, 25);
		btnCancelar.setVisible(false);
		add(btnCancelar);
		
		
		
	}
	
	 void limpartela(boolean resultado){
		
		textField_segunda.setVisible(resultado);
		textField_terca.setVisible(resultado);
		textField_Quarta.setVisible(resultado);
		textField_quinta.setVisible(resultado);
		textField_sexta.setVisible(resultado);
		label.setVisible(resultado);
		label_1.setVisible(resultado);
		label_2.setVisible(resultado);
		label_3.setVisible(resultado);
		label_4.setVisible(resultado);
		label_5.setVisible(resultado);
		lblLeite.setVisible(resultado);
		lblQuarta.setVisible(resultado);
		lblQuinta.setVisible(resultado);
		lblSegunda.setVisible(resultado);
		lblSexta.setVisible(resultado);
		lblTera.setVisible(resultado);
		btnAdcionarProduoDiaria.setVisible(resultado);
		btnGerarRelatorios.setVisible(resultado);
		
		
	}
	/*private String verificacao(String text) {
		
		String resultado = "boliinha1";
		
		if(Double.parseDouble(text) < 600.0){
			resultado = "boliinha2";
		}
		
		
		return resultado;
	}*/
	
	
	
}
