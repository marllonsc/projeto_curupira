package code.janelas;

import java.awt.Color;
import java.awt.Panel;

import botao.botao;
import code.sql.Sqlfunc;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelVisuzalizarRebanho extends Panel {
	
	private static final long serialVersionUID = 1L;
	private Sqlfunc sqlAnimal = new Sqlfunc();

	public PanelVisuzalizarRebanho(String animal) {
		
		setBackground(Color.WHITE);
		setBounds(23, 22, 702, 436);
		setLayout(null);
		
		JLabel lblQuantidadeTotalDe = new JLabel("Quantidade total de animais");
		lblQuantidadeTotalDe.setFont(new Font("Dialog", Font.BOLD, 30));
		lblQuantidadeTotalDe.setBounds(112, 44, 477, 36);
		add(lblQuantidadeTotalDe);
		
		JLabel label_quantidadeAnimais = new JLabel("");
		label_quantidadeAnimais.setFont(new Font("Dialog", Font.BOLD, 30));
		label_quantidadeAnimais.setBounds(327, 86, 48, 48);
		add(label_quantidadeAnimais);
		
		JLabel lblQuanti = new JLabel("Quantidade de Machos");
		lblQuanti.setFont(new Font("Dialog", Font.BOLD, 25));
		lblQuanti.setBounds(22, 238, 336, 36);
		add(lblQuanti);
		
		JLabel lblQuantidadeDeFmias = new JLabel("Quantidade de Fêmias");
		lblQuantidadeDeFmias.setFont(new Font("Dialog", Font.BOLD, 25));
		lblQuantidadeDeFmias.setBounds(370, 238, 352, 36);
		add(lblQuantidadeDeFmias);
		
		JLabel label_quantidadeMachos = new JLabel("");
		label_quantidadeMachos.setFont(new Font("Dialog", Font.BOLD, 25));
		label_quantidadeMachos.setBounds(168, 275, 48, 48);
		add(label_quantidadeMachos);
		
		JLabel label_quantidadeFêmias = new JLabel("");
		label_quantidadeFêmias.setFont(new Font("Dialog", Font.BOLD, 25));
		label_quantidadeFêmias.setBounds(516, 275, 56, 48);
		add(label_quantidadeFêmias);
		
		JLabel label_botao = new botao("/code/imagens/cancelar.png","/code/imagens/panel reprodução/bt_cancelar.jpg");
		label_botao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		label_botao.setBounds(304, 390, 94, 34);
		add(label_botao);
		
		int numeroTotal = sqlAnimal.QuantAnimal(animal);
		int numeroMacho = sqlAnimal.QuantAnimalMacho(animal);
		int numeroFemias = sqlAnimal.QuantAnimalFemias(animal);
		
		label_quantidadeAnimais.setText(""+numeroTotal);
		label_quantidadeFêmias.setText(""+numeroFemias);
		label_quantidadeMachos.setText(""+numeroMacho);
		
		
		
	}
}
