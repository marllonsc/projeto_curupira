package code.janelas;

import java.awt.Font;
import java.awt.TextArea;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProducaoLeite extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private JTextField textField_identificacaoAnimal;
	private JTextField textField_dataProducao;
	private JTextField textField_quantidade;
	TextArea textArea_producaodeLeite = new TextArea();
	
public ProducaoLeite() {
	

	setBounds(23, 22, 702, 404);
	setVisible(true);
	setLayout(null);
	
	JLabel lblProduoDeLeite = new JLabel("Produção de Leite");
	lblProduoDeLeite.setBounds(139, 12, 424, 47);
	lblProduoDeLeite.setFont(new Font("Dialog", Font.BOLD, 39));
	add(lblProduoDeLeite);
	
	JLabel lblIdentificaoAnimal = new JLabel("Identificação Animal: ");
	lblIdentificaoAnimal.setBounds(44, 107, 171, 15);
	add(lblIdentificaoAnimal);
	
	textField_identificacaoAnimal = new JTextField();
	textField_identificacaoAnimal.setBounds(219, 105, 189, 19);
	add(textField_identificacaoAnimal);
	textField_identificacaoAnimal.setColumns(10);
	
	JLabel lblData = new JLabel("Data:");
	lblData.setBounds(70, 149, 70, 15);
	add(lblData);
	
	textField_dataProducao = new JTextField();
	textField_dataProducao.setBounds(147, 147, 163, 19);
	add(textField_dataProducao);
	textField_dataProducao.setColumns(10);
	
	JLabel lblQuantidadeEmLitros = new JLabel("Quantidade em Litros:");
	lblQuantidadeEmLitros.setBounds(44, 188, 177, 15);
	add(lblQuantidadeEmLitros);
	
	textField_quantidade = new JTextField();
	textField_quantidade.setBounds(214, 186, 174, 19);
	add(textField_quantidade);
	textField_quantidade.setColumns(10);
	
	JLabel lblObservao = new JLabel("Observação");
	lblObservao.setBounds(70, 237, 109, 15);
    add(lblObservao);
	
	
	textArea_producaodeLeite.setBounds(45, 258, 459, 123);
	add(textArea_producaodeLeite);
	
	JButton btnCadastrar_1 = new JButton("Cadastrar");
	btnCadastrar_1.setBounds(539, 266, 117, 25);
	add(btnCadastrar_1);
	
	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(ProducaoLeite.class.getResource("/code/imagens/tirando_leite_da_vaca.jpg")));
	label.setBounds(465, 71, 212, 151);
	add(label);
	textArea_producaodeLeite.setVisible(true);
	
	
}
	

}
