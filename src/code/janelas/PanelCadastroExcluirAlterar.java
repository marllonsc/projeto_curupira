package code.janelas;

import java.awt.Font;
import java.awt.TextArea;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import code.dados.Animal;
import code.sql.Sqlfunc;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PanelCadastroExcluirAlterar extends JPanel {

	
	private static final long serialVersionUID = 1L;

	TextArea textArea = new TextArea();

	private Sqlfunc sqlBolvinos = new Sqlfunc();
	private JTextField textField_identificador;
	JComboBox comboBox_categoria = new JComboBox();
	JComboBox comboBox_dia = new JComboBox();
	JComboBox comboBox_mes = new JComboBox();
	JComboBox comboBox_raca = new JComboBox();
	JComboBox comboBox_status = new JComboBox();
	private JTextField textField_ano;
	private JTextField textField_IHC;
	private JTextField textField_peso2;
	Vector<String> racas = new Vector<String>();
	Vector<String> vacinas = new Vector<String>();
	Vector<String> categorias = new Vector<String>();
	JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
	JLabel lblIdentificador = new JLabel("Identificador");
	JLabel lblCategoria = new JLabel("Categoria");
	JLabel lblIndiceDeMassa = new JLabel("Indice de massa Corporal");
	JLabel lblRaa = new JLabel("Raça");
	JLabel lblSexo = new JLabel("Sexo");
	final JRadioButton rdbtnMacho = new JRadioButton("Macho");
	JRadioButton rdbtnFmea = new JRadioButton("Fêmea");
	JLabel lblDataDaUltima = new JLabel("Status");
	JLabel lblObservaes = new JLabel("Observações:");
	JLabel label = new JLabel("/");
	JLabel label_1 = new JLabel("/");
	JLabel lblPeso = new JLabel("Peso");
	private final JLabel label_alterar = new JLabel("");
	JLabel label_buscar = new JLabel("");
	private final JLabel label_excluir = new JLabel("");
	private final JLabel label_cancelar = new JLabel("");
	boolean verificacao = true;
	
	

	public PanelCadastroExcluirAlterar(final String animal,String img, final String Butão) {
		setBackground(Color.WHITE);

		setBounds(23, 22, 702, 436);
		setLayout(null);
		
		
		racas = sqlBolvinos.retornaRaca(animal);
		
		
		categorias = sqlBolvinos.retornaCategoria(animal);
								label_buscar.setIcon(null);
								
								
								label_buscar.addMouseMotionListener(new MouseMotionAdapter() {
									@Override
									public void mouseMoved(MouseEvent e) {
										
										label_buscar.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("/code/imagens/bt_buscar.jpg")));
										
									}
								});
								
								
								label_buscar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
			
										liparCarregar(true);
										
										textField_peso2.setText("");
										comboBox_categoria.setSelectedItem("");
										comboBox_dia.setSelectedItem("");
										comboBox_mes.setSelectedItem("");
										comboBox_raca.setSelectedItem("");
										textField_ano.setText("");
										textField_IHC.setText("");
										textField_peso2.setText("");
										comboBox_status.setSelectedItem("");
										
										Animal animalBolvino = sqlBolvinos.buscaAnimal(textField_identificador.getText(),animal);
										
										if(animalBolvino!=null){
										String tmp = sqlBolvinos.retornaNomeCategoria(animalBolvino.getCategoria(),animal);
										
										
										comboBox_categoria.setSelectedItem(tmp);
										
										String[] data = animalBolvino.getDataNascimento().split("/");
										comboBox_dia.setSelectedItem(data[0]);
										comboBox_mes.setSelectedItem(data[1]);
										textField_ano.setText(data[2]);
										
										textField_IHC.setText(""+animalBolvino.getImc());
										textArea.setText(animalBolvino.getObservacao());
										textField_peso2.setText(""+animalBolvino.getPeso());
										
										String tmp2 = sqlBolvinos.retornaNomeRaca(animalBolvino.getRaca(),animal);
										comboBox_raca.setSelectedItem(tmp2);
										
										if(animalBolvino.getSexo().equalsIgnoreCase("F")){
										rdbtnFmea.setSelected(true);
										}else{
										rdbtnMacho.setSelected(false);
										}
										
										
										if(animalBolvino.getStatus().equalsIgnoreCase("M")){
											comboBox_status.setSelectedItem("Morto");
										}else if(animalBolvino.getStatus().equalsIgnoreCase("V")){
											comboBox_status.setSelectedItem("Vivo");
										}
										
										
										
										}else{
											liparCarregar(false);
											JOptionPane.showMessageDialog(null,
													"Animal não encontrado!");
											
										}
											
										
										
									}
									@Override
									public void mouseExited(MouseEvent e) {
										
										label_buscar.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("")));
										
									}
								});
								label_alterar.addMouseMotionListener(new MouseMotionAdapter() {
									@Override
									public void mouseMoved(MouseEvent e) {
										
										if(Butão.equalsIgnoreCase("/code/imagens/alterar.jpg")){
										label_alterar.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("/code/imagens/bt_alterar.jpg")));
										}else{
										label_alterar.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("/code/imagens/bt_cadastro.jpg")));
										}
									}
								});
								
								label_alterar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										
										
										if(Butão.equalsIgnoreCase("/code/imagens/cadastro.jpg")){
											
											liparCarregar(true);
											
											textArea.setVisible(true);
									
											String status = (String) comboBox_status.getSelectedItem();
											if(status.equalsIgnoreCase("Vivo")){
												status="V";
											}else if(status.equalsIgnoreCase("Morto")){
												status="M";
											}
							
											String sexo;
											if (rdbtnMacho.isSelected()) {
												sexo = "M";
											} else {
												sexo = "F";
											}
											
											
							
											String peso = textField_peso2.getText().replace(",", ".");
											String icm = textField_IHC.getText().replace(",", ".");
											
											int tmp = sqlBolvinos.retornaIndiceCategoria((String) comboBox_categoria.getSelectedItem(),animal);
											
											if(icm.equalsIgnoreCase("")){
												icm="0";
											}
											if(peso.equalsIgnoreCase("")){
												peso="0";
											}
											
											int tmp2 = sqlBolvinos.retornaIndiceRaca((String) comboBox_raca.getSelectedItem(),animal);
											
											
											
												Animal animalBolvino = new Animal(textField_identificador.getText(), Double.parseDouble(icm) , Double.parseDouble(peso) ,
													((String)comboBox_dia.getSelectedItem())+"/"+((String) comboBox_mes.getSelectedItem())+"/"+(textField_ano.getText()) , sexo , tmp2 , tmp ,status, textArea.getText());
											
											
									
													boolean resultado = sqlBolvinos.cadastrarAnimal(animalBolvino);
													
													if (resultado) {
														
														textField_peso2.setText("");
														textField_identificador.setText("");
														comboBox_categoria.setSelectedItem("");
														comboBox_dia.setSelectedItem("");
														comboBox_mes.setSelectedItem("");
														comboBox_raca.setSelectedItem("");
														textField_ano.setText("");
														textField_IHC.setText("");
														textField_peso2.setText("");
														comboBox_status.setSelectedItem("");
														textArea.setText("");
									
														JOptionPane.showMessageDialog(null,
																"Cadastrado com Sucesso!");
									
													} else {
									
														JOptionPane.showMessageDialog(null,
																"Animal não cadastrado!");
									
													}
											
												
											
											
								}else if(Butão.equalsIgnoreCase("/code/imagens/alterar.jpg")){
									
										liparCarregar(false);
											
											
											String status = (String) comboBox_status.getSelectedItem();
											
											if(status.equalsIgnoreCase("Vivo")){
												status="V";
											}else if(status.equalsIgnoreCase("Morto")){
												status="M";
											}
						
											String sexo;
											if (rdbtnMacho.isSelected()) {
												sexo = "M";
											} else {
												sexo = "F";
											}
											
											
						
											String peso = textField_peso2.getText().replace(",", ".");
											String icm = textField_IHC.getText().replace(",", ".");
											
											int tmp = sqlBolvinos.retornaIndiceCategoria((String) comboBox_categoria.getSelectedItem(),animal);
											
											if(icm.equalsIgnoreCase("")){
												icm="0";
											}
											if(peso.equalsIgnoreCase("")){
												peso="0";
											}
											int tmp2 = sqlBolvinos.retornaIndiceRaca((String) comboBox_raca.getSelectedItem(),animal);
											
											
											Animal animalBolvino = new Animal(textField_identificador.getText(), Double.parseDouble(icm) , Double.parseDouble(peso) ,
													((String)comboBox_dia.getSelectedItem())+"/"+((String) comboBox_mes.getSelectedItem())+"/"+(textField_ano.getText()) , sexo , tmp2 , tmp ,status, textArea.getText());
											
						
											
												boolean resultado = sqlBolvinos.AlterarAnimal(animalBolvino);
											
											if (resultado) {
						
												textField_peso2.setText("");
												textField_identificador.setText("");
												comboBox_categoria.setSelectedItem("");
												comboBox_dia.setSelectedItem("");
												comboBox_mes.setSelectedItem("");
												comboBox_raca.setSelectedItem("");
												textField_ano.setText("");
												textField_IHC.setText("");
												textField_peso2.setText("");
												comboBox_status.setSelectedItem("");
												
						
												JOptionPane.showMessageDialog(null,
														"Alterado com Sucesso!");
														liparCarregar(false);
														textField_identificador.setEditable(true);
														textField_identificador.setText("");
						
											} else {
						
												JOptionPane.showMessageDialog(null,
														"Animal não Alterado!");
						
											}
											
									
											
											}
										
									}
									@Override
									public void mouseExited(MouseEvent e) {
										
										label_alterar.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("")));
										
									}
								});
								
								label_excluir.addMouseMotionListener(new MouseMotionAdapter() {
									@Override
									public void mouseMoved(MouseEvent e) {
										
										label_excluir.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("/code/imagens/bt_excluir.jpg")));

										
									}
								});
								label_excluir.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										
										int resposta = JOptionPane.showConfirmDialog(null,"Deseja Mesmo Excluir o animal?");  
										if(resposta == JOptionPane.YES_OPTION){
										
										boolean resultado1 = sqlBolvinos.excluirAnimal(textField_identificador.getText());
										
										if (resultado1) {
											
											textField_peso2.setText("");
											textField_identificador.setText("");
											comboBox_categoria.setSelectedItem("");
											comboBox_dia.setSelectedItem("");
											comboBox_mes.setSelectedItem("");
											comboBox_raca.setSelectedItem("");
											textField_ano.setText("");
											textField_IHC.setText("");
											textField_peso2.setText("");
											comboBox_status.setSelectedItem("");
											

											JOptionPane.showMessageDialog(null,
													"Excluido com Sucesso!");
													liparCarregar(false);
													textField_identificador.setEditable(true);
													textField_identificador.setText("");
													

										} else {

											JOptionPane.showMessageDialog(null,
													"Animal não Excluido!");

										}
										}else if(resposta == JOptionPane.CANCEL_OPTION){
											liparCarregar(false);
											setVisible(false);
											
										}else if(resposta == JOptionPane.NO_OPTION){
											liparCarregar(false);
										}
										
										
									}
									@Override
									public void mouseExited(MouseEvent e) {
										
										label_excluir.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource("")));

										
									}
								});
								label_cancelar.addMouseMotionListener(new MouseMotionAdapter() {
									@Override
									public void mouseMoved(MouseEvent e) {
										
										label_cancelar.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/panel reprodução/bt_cancelar.jpg")));

										
									}
								});
								label_cancelar.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										
										setVisible(false);
										liparCarregar(false);
										verificacao = true;
									}
									@Override
									public void mouseExited(MouseEvent e) {
										
										label_cancelar.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));

										
									}
								});
								setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBox_mes, comboBox_status, comboBox_dia, comboBox_raca, lblIdentificador, lblCategoria, lblDataDeNascimento, lblIndiceDeMassa, lblRaa, lblSexo, rdbtnMacho, rdbtnFmea, lblDataDaUltima, lblObservaes, label, label_1, lblPeso, comboBox_categoria}));
										comboBox_categoria.setMaximumRowCount(5);
								
										comboBox_categoria.setModel(new DefaultComboBoxModel(
												categorias));
										comboBox_categoria.setBounds(274, 150, 233, 24);
										add(comboBox_categoria);
								comboBox_raca.setMaximumRowCount(3);
								comboBox_raca.setModel(new DefaultComboBoxModel(racas));
								
										comboBox_raca.setBounds(128, 184, 166, 24);
										add(comboBox_raca);
								label_cancelar.setBounds(79, 383, 95, 41);
								
								add(label_cancelar);
								label_excluir.setBounds(309, 383, 96, 41);
								
								add(label_excluir);
								label_alterar.setBounds(547, 383, 95, 41);
								
								add(label_alterar);
								label_buscar.setBounds(445, 53, 101, 36);
								add(label_buscar);
						
								comboBox_mes.setModel(new DefaultComboBoxModel(new String[] { "", "01",
										"02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
										"12" }));
								comboBox_mes.setBounds(428, 104, 71, 24);
								add(comboBox_mes);
						
						
						comboBox_status.setModel(new DefaultComboBoxModel(new String[] {"", "Vivo", "Morto"}));
						comboBox_status.setBounds(399, 186, 155, 20);
						add(comboBox_status);
				
						comboBox_dia.setModel(new DefaultComboBoxModel(new String[] { "", "01",
								"02", "03", "04", "05", "06", "07", "08", "09", "10", "11",
								"12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
								"22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
						comboBox_dia.setBounds(331, 104, 64, 24);
						add(comboBox_dia);
						
			
		String nome="";
		if(Butão.equalsIgnoreCase("/code/imagens/cadastro.jpg")){
			nome = "Cadastrar";
		}else{
			nome = "Alterar";
		}
		
		JLabel lblCadastrarAnimal = new JLabel(nome+" Animal");
		lblCadastrarAnimal.setBounds(189, 5, 389, 36);
		lblCadastrarAnimal.setFont(new Font("Dialog", Font.BOLD, 30));
		add(lblCadastrarAnimal);
		textArea.setText("");
		
				textArea.setBounds(86, 267, 526, 110);
				add(textArea);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class
				.getResource(img)));
		
		label_2.setBounds(0, 5, 166, 128);
		add(label_2);

		
		lblIdentificador.setBounds(213, 69, 118, 15);
		add(lblIdentificador);

		
		lblCategoria.setBounds(186, 156, 70, 15);
		add(lblCategoria);

		
		lblDataDeNascimento.setBounds(172, 109, 166, 15);
		add(lblDataDeNascimento);

		
		lblIndiceDeMassa.setBounds(68, 220, 166, 15);
		add(lblIndiceDeMassa);

		
		lblRaa.setBounds(68, 189, 70, 15);
		add(lblRaa);

		
		lblSexo.setBounds(577, 150, 70, 15);
		add(lblSexo);

		
		rdbtnMacho.setSelected(true);
		rdbtnMacho.setBounds(587, 167, 80, 23);
		add(rdbtnMacho);

		
		rdbtnFmea.setBounds(587, 194, 88, 23);
		add(rdbtnFmea);

		final ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnMacho);
		bgroup.add(rdbtnFmea);

		
		lblDataDaUltima.setBounds(330, 189, 51, 15);
		add(lblDataDaUltima);

		
		lblObservaes.setBounds(287, 253, 118, 15);
		add(lblObservaes);

		
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(413, 100, 20, 30);
		add(label);

		
		
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(517, 98, 27, 36);
		add(label_1);

		
		lblPeso.setBounds(370, 220, 70, 15);
		add(lblPeso);

		textField_identificador = new JTextField();
		textField_identificador.setBounds(309, 67, 124, 19);
		add(textField_identificador);
		textField_identificador.setColumns(10);

		textField_ano = new JTextField();
		textField_ano.setText("");
		textField_ano.setBounds(535, 107, 124, 19);
		add(textField_ano);
		textField_ano.setColumns(10);

		textField_IHC = new JTextField();
		textField_IHC.setBounds(234, 218, 124, 19);
		add(textField_IHC);
		textField_IHC.setColumns(10);

		textField_peso2 = new JTextField();
		textField_peso2.setBounds(414, 218, 124, 19);
		add(textField_peso2);
		textField_peso2.setColumns(10);
		
		JLabel label_Central = new JLabel("");
		label_Central.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
			
				if(Butão.equalsIgnoreCase("/code/imagens/cadastro.jpg")){
					liparCarregar(true);
				}
				
				if(verificacao){
					
					racas.clear();
					categorias.clear();
					racas = sqlBolvinos.retornaRaca(animal);
					categorias = sqlBolvinos.retornaCategoria(animal);
					comboBox_raca.setModel(new DefaultComboBoxModel(racas));
					comboBox_categoria.setModel(new DefaultComboBoxModel(categorias));
					verificacao = false;
				}
				
			}
		});
		label_Central.setIcon(new ImageIcon(PanelCadastroExcluirAlterar.class.getResource(Butão)));
		label_Central.setBounds(0, 0, 702, 436);
		add(label_Central);
		
		if(Butão.equalsIgnoreCase("/code/imagens/cadastro.jpg")){
			
			label_excluir.setVisible(false);
			label_buscar.setVisible(false);
			liparCarregar(true);
			
		}else{
			
			liparCarregar(false);
		}
		

	}
	
	public void liparCarregar(boolean entrada){
		textArea.setVisible(entrada);
		textField_ano.setVisible(entrada);
		textField_IHC.setVisible(entrada);
		textField_peso2.setVisible(entrada);
		comboBox_categoria.setVisible(entrada);
		comboBox_dia.setVisible(entrada);
		comboBox_mes.setVisible(entrada);
		comboBox_raca.setVisible(entrada);
		rdbtnFmea.setVisible(entrada);
		rdbtnMacho.setVisible(entrada);
		lblCategoria.setVisible(entrada);
		lblDataDeNascimento.setVisible(entrada);
		lblObservaes.setVisible(entrada);
		lblPeso.setVisible(entrada);
		lblSexo.setVisible(entrada);
		lblIndiceDeMassa.setVisible(entrada);
		label.setVisible(entrada);
		label_1.setVisible(entrada);
		lblDataDaUltima.setVisible(entrada);
		lblRaa.setVisible(entrada);
		comboBox_status.setVisible(entrada);
		
	}
}
