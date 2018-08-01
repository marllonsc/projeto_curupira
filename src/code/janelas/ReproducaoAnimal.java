package code.janelas;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

import code.dados.Animal;
import code.dados.Filhote;
import code.sql.SqlReproducao;
import code.sql.Sqlfunc;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ReproducaoAnimal extends JPanel{

	private static final long serialVersionUID = 1L;
	private SqlReproducao sqlReproducao = new SqlReproducao();
	private Sqlfunc sqlfunc = new Sqlfunc();
	int carregar = 0;
	JPanel panel = new JPanel();
	JPanel panel_criaMae = new JPanel();
	final JPanel panel_1 = new JPanel();
	private JTextField textField_identificacao;
	private JTextField textField_ano;
	JLabel lblDataFinalDo = new JLabel("Data Final do Cio:");
	JComboBox comboBox_mes = new JComboBox();
	JComboBox comboBox_dia = new JComboBox();
	JLabel label = new JLabel("/");
	JLabel label_1 = new JLabel("/");
	JLabel label_QutAbortos = new JLabel("");
	JLabel label_QutPartos = new JLabel("");
	JLabel label_QutMort = new JLabel("");
	JRadioButton radioButton = new JRadioButton("Sim");
	JRadioButton radioButton_1 = new JRadioButton("Não");
	JRadioButton rdbtnNo = new JRadioButton("Não");
	JRadioButton rdbtnSim = new JRadioButton("Sim");
	private JTextField textField_anoDesmame;
	private JTextField textField_anoAborto;
	private JTextField textField_idMae;
	JComboBox comboBox_diaDesmame = new JComboBox();
	JComboBox comboBox_mesDesmame = new JComboBox();
	JComboBox comboBox_diaAborto = new JComboBox();
	JComboBox comboBox_mesAborto = new JComboBox();
	JRadioButton rdbtnSim_curaUmvigo = new JRadioButton("Sim");
	JRadioButton rdbtnNo_curaUmvigo = new JRadioButton("Não");
	JRadioButton radioNao_colastro = new JRadioButton("Não");
	JRadioButton radioSim_colastro = new JRadioButton("Sim");
	ButtonGroup  bgroup_colastro = new ButtonGroup();
	JRadioButton radioNao_marcacao = new JRadioButton("Não");
	JRadioButton radioSim_marcacao = new JRadioButton("Sim");
	private JTextField textField_idCria;
	
	
	public ReproducaoAnimal(final String animal) {
		setBackground(Color.WHITE);
		setForeground(Color.WHITE);
	
		setBounds(23, 22, 702, 436);
		setLayout(null);
		
		ButtonGroup  bgroup_curaUmbigo = new ButtonGroup();
		
		ButtonGroup  bgroup_marcacao = new ButtonGroup();
		
		final ButtonGroup bgroup2 = new ButtonGroup();
		
		final ButtonGroup bgroup = new ButtonGroup();
		panel.setBounds(0, 0, 702, 424);
		add(panel);
		
		
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		
		final JLabel label_cancelar2 = new JLabel("");
		label_cancelar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_cancelar2.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
		});
		label_cancelar2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_cancelar2.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/bt_cancelar2.jpg")));
				
			}
		});
		
		final JLabel label_busca = new JLabel("");
		label_busca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_busca.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Animal ani = sqlfunc.buscaAnimal(textField_identificacao.getText(),animal);
				
				if(ani!=null){
					
				label_QutAbortos.setText(""+sqlReproducao.retornaQtAbortoAnimal(animal, textField_identificacao.getText()));
				label_QutPartos.setText(""+sqlReproducao.retornaQtCriaAnimal(animal,textField_identificacao.getText()));
				label_QutMort.setText(""+sqlReproducao.retornaMortalidadeAnimal(animal, textField_identificacao.getText()));
				
				}else{
					comboBox_dia.setSelectedItem("");
					comboBox_mes.setSelectedItem("");
					label_QutAbortos.setText("");
					label_QutMort.setText("");
					label_QutPartos.setText("");
					textField_ano.setText("");
					JOptionPane.showMessageDialog(null,"Animal não encontrado");
				}
			}
		});
		label_busca.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_busca.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/bt_buscar.jpg")));
				
			}
		});
		
		final JLabel label_cadastrar = new JLabel("");
		label_cadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_cadastrar.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				boolean resultado = false;
				String dia = (String) comboBox_dia.getSelectedItem();
				String mes = (String) comboBox_mes.getSelectedItem();
				String data =dia+"/"+mes+"/"+textField_ano.getText(); 
				String prenha;
				
				if(radioButton.isSelected()){
					prenha = "S";
				}else{
					prenha = "N";
				}
				
				if(rdbtnSim.isSelected()){
					resultado = sqlReproducao.cadastrarReprodutora(data,prenha,textField_identificacao.getText());
				}else{
					resultado = sqlReproducao.cadastrarReprodutora("",prenha,textField_identificacao.getText());
				}
				if(resultado){
					textField_ano.setText("");
					comboBox_dia.setSelectedItem("");
					comboBox_mes.setSelectedItem("");
					JOptionPane.showMessageDialog(null,"Cadastrado com Sucesso");
				}else{
					JOptionPane.showMessageDialog(null,"Cadastrado sem Sucesso");
				}
				
			}
		});
		label_cadastrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_cadastrar.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/Reproducao animal/cadastrar_reproducao.jpg")));

			}
		});
		
		
		label_QutMort.setFont(new Font("Dialog", Font.BOLD, 20));
		label_QutMort.setBounds(421, 326, 95, 23);
		panel.add(label_QutMort);
		
		
		label_QutAbortos.setFont(new Font("Dialog", Font.BOLD, 20));
		label_QutAbortos.setBounds(370, 291, 95, 23);
		panel.add(label_QutAbortos);
		
		
		label_QutPartos.setFont(new Font("Dialog", Font.BOLD, 20));
		label_QutPartos.setBounds(358, 256, 95, 23);
		panel.add(label_QutPartos);
		
		
		
		
		JLabel lblQuantidadeDeMortalidade = new JLabel("Quantidade de Mortalidade:");
		lblQuantidadeDeMortalidade.setFont(new Font("Dialog", Font.BOLD, 20));
		lblQuantidadeDeMortalidade.setBounds(88, 326, 342, 23);
		panel.add(lblQuantidadeDeMortalidade);
		
		JLabel lblQuantidadeDeAbortos_1 = new JLabel("Quantidade de Abortos:");
		lblQuantidadeDeAbortos_1.setFont(new Font("Dialog", Font.BOLD, 20));
		lblQuantidadeDeAbortos_1.setBounds(88, 291, 304, 23);
		panel.add(lblQuantidadeDeAbortos_1);
		
		JLabel lblQuantidadeDePartos = new JLabel("Quantidade de Partos:");
		lblQuantidadeDePartos.setFont(new Font("Dialog", Font.BOLD, 20));
		lblQuantidadeDePartos.setBounds(88, 256, 266, 23);
		panel.add(lblQuantidadeDePartos);
		
		
		radioButton.setBounds(188, 187, 53, 23);
		panel.add(radioButton);
		
		
		radioButton_1.setBounds(245, 187, 53, 23);
		panel.add(radioButton_1);
		bgroup2.add(radioButton);
		bgroup2.add(radioButton_1);
		
		JLabel lblPrenha = new JLabel("Prenha:");
		lblPrenha.setBounds(126, 187, 61, 15);
		panel.add(lblPrenha);
		
		textField_ano = new JTextField();
		textField_ano.setBounds(386, 147, 114, 24);
		panel.add(textField_ano);
		textField_ano.setColumns(10);
		textField_ano.setVisible(false);
		
		
		label_1.setFont(new Font("Dialog", Font.BOLD, 26));
		label_1.setBounds(361, 147, 15, 24);
		panel.add(label_1);
		label_1.setVisible(false);
		
	
		label.setFont(new Font("Dialog", Font.BOLD, 26));
		label.setBounds(255, 147, 15, 24);
		panel.add(label);
		label.setVisible(false);
		
		
		comboBox_mes.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_mes.setMaximumRowCount(4);
		comboBox_mes.setBounds(279, 147, 75, 24);
		panel.add(comboBox_mes);
		comboBox_mes.setVisible(false);
		
		
		comboBox_dia.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_dia.setMaximumRowCount(4);
		comboBox_dia.setBounds(173, 147, 75, 24);
		panel.add(comboBox_dia);
		comboBox_dia.setVisible(false);
		
		
		lblDataFinalDo.setBounds(38, 147, 149, 15);
		panel.add(lblDataFinalDo);
		lblDataFinalDo.setVisible(false);
		
		
		rdbtnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_dia.setVisible(false);
				comboBox_mes.setVisible(false);
				textField_ano.setVisible(false);
				label.setVisible(false);
				label_1.setVisible(false);
				lblDataFinalDo.setVisible(false);
			}
		});
		rdbtnNo.setBounds(220, 111, 53, 23);
		panel.add(rdbtnNo);
		
		
		rdbtnSim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_dia.setVisible(true);
				comboBox_mes.setVisible(true);
				textField_ano.setVisible(true);
				label.setVisible(true);
				label_1.setVisible(true);
				lblDataFinalDo.setVisible(true);
			}
		});
		rdbtnSim.setBounds(163, 111, 53, 23);
		panel.add(rdbtnSim);
		bgroup.add(rdbtnSim);
		bgroup.add(rdbtnNo);
		
		JLabel lblCio = new JLabel("Cio Detectado:");
		lblCio.setBounds(38, 115, 121, 15);
		panel.add(lblCio);
		
		textField_identificacao = new JTextField();
		textField_identificacao.setBounds(153, 79, 181, 19);
		panel.add(textField_identificacao);
		textField_identificacao.setColumns(10);
		
		JLabel lblIndinficao = new JLabel("Indentificação: ");
		lblIndinficao.setBounds(38, 74, 121, 29);
		panel.add(lblIndinficao);
		
		JLabel lblReproduo_1 = new JLabel("Reprodutora");
		lblReproduo_1.setFont(new Font("Dialog", Font.BOLD, 40));
		lblReproduo_1.setBounds(219, 12, 263, 44);
		panel.add(lblReproduo_1);
		label_cadastrar.setBounds(352, 172, 101, 38);
		panel.add(label_cadastrar);
		
		label_busca.setBounds(352, 65, 101, 38);
		panel.add(label_busca);
		
		label_cancelar2.setBounds(64, 374, 95, 38);
		panel.add(label_cancelar2);
		
		JLabel label_principal2 = new JLabel("");
		label_principal2.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/Reproducao animal/tela reproducao.jpg")));
		label_principal2.setBounds(12, 12, 665, 400);
		panel.add(label_principal2);
		panel.setVisible(false);
		
		
		panel_criaMae.setBounds(0, 0, 702, 424);
		add(panel_criaMae);
		panel_criaMae.setLayout(null);
		
		final JLabel label_cadastrar2 = new JLabel("");
		label_cadastrar2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_cadastrar2.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/bt_cadastro.jpg")));
			}
		});
		label_cadastrar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_cadastrar2.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));

			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String dataDesmame = (String) comboBox_diaDesmame.getSelectedItem()+"/"+(String) comboBox_mesDesmame.getSelectedItem()+"/"+textField_anoDesmame.getText();
				String dataAborto = (String) comboBox_diaAborto.getSelectedItem()+"/"+(String) comboBox_mesAborto.getSelectedItem()+"/"+textField_anoAborto.getText();
				String curaUmbigo;
				String colastro;
				String marcacao;
				
				if(rdbtnSim_curaUmvigo.isSelected()){
					curaUmbigo = "S";
				}else{
					curaUmbigo = "N";
				}
	
				if(radioSim_marcacao.isSelected()){
					marcacao = "S";
				}else{
					marcacao = "N";
				}
				
				if(radioSim_colastro.isSelected()){
					colastro = "S";
				}else{
					colastro = "N";
				}
				
				Filhote filhote = new Filhote(textField_idCria.getText(),dataDesmame, dataAborto, curaUmbigo, colastro, marcacao, textField_idMae.getText());
				
				boolean resultado = sqlReproducao.cadastrarDadosFilhote(filhote);
				
				if(resultado){
					
					JOptionPane.showMessageDialog(null,"Dados Cadastrados com Sucesso !");
					textField_ano.setText("");
					textField_anoAborto.setText("");
					textField_anoDesmame.setText("");
					textField_identificacao.setText("");
					textField_idMae.setText("");
					comboBox_diaDesmame.setSelectedItem("");
					comboBox_diaAborto.setSelectedItem("");
					comboBox_mesAborto.setSelectedItem("");
					comboBox_mesDesmame.setSelectedItem("");
					
				}else{
					JOptionPane.showMessageDialog(null,"Dados Não foram Cadastrados !");
					
				}
				
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(41, 72, 621, 284);
		panel_criaMae.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblDataDoDesmame = new JLabel("Data do Desmame");
		lblDataDoDesmame.setBounds(0, 52, 193, 24);
		lblDataDoDesmame.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_2.add(lblDataDoDesmame);
		
		
		comboBox_diaDesmame.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_diaDesmame.setBounds(194, 53, 87, 24);
		panel_2.add(comboBox_diaDesmame);
		
		
		comboBox_mesDesmame.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_mesDesmame.setBounds(313, 53, 81, 24);
		panel_2.add(comboBox_mesDesmame);
		
		textField_anoDesmame = new JTextField();
		textField_anoDesmame.setBounds(441, 54, 155, 24);
		panel_2.add(textField_anoDesmame);
		textField_anoDesmame.setColumns(10);
		
		
		JLabel lblDataDo = new JLabel("Data do Aborto");
		lblDataDo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDataDo.setBounds(0, 90, 155, 24);
		panel_2.add(lblDataDo);
		
		JLabel lblCuraDoUmbigo = new JLabel("Cura do Umbigo");
		lblCuraDoUmbigo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCuraDoUmbigo.setBounds(0, 128, 155, 24);
		panel_2.add(lblCuraDoUmbigo);
		
		JLabel lblColastro = new JLabel("Colastro");
		lblColastro.setFont(new Font("Dialog", Font.BOLD, 16));
		lblColastro.setBounds(0, 166, 155, 24);
		panel_2.add(lblColastro);
		
		JLabel lblMarcao = new JLabel("Marcação");
		lblMarcao.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMarcao.setBounds(0, 204, 155, 24);
		panel_2.add(lblMarcao);
		
		JLabel lblIdentificaoDaMe = new JLabel("Identificação da Mãe");
		lblIdentificaoDaMe.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIdentificaoDaMe.setBounds(0, 242, 183, 24);
		panel_2.add(lblIdentificaoDaMe);
		
		
		comboBox_diaAborto.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_diaAborto.setBounds(194, 95, 87, 24);
		panel_2.add(comboBox_diaAborto);
		
		
		comboBox_mesAborto.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_mesAborto.setBounds(313, 97, 81, 24);
		panel_2.add(comboBox_mesAborto);
		
		textField_anoAborto = new JTextField();
		textField_anoAborto.setColumns(10);
		textField_anoAborto.setBounds(441, 98, 155, 24);
		panel_2.add(textField_anoAborto);
		
		textField_idMae = new JTextField();
		textField_idMae.setColumns(10);
		textField_idMae.setBounds(185, 240, 155, 24);
		panel_2.add(textField_idMae);
		
		
		rdbtnSim_curaUmvigo.setBounds(192, 130, 61, 23);
		panel_2.add(rdbtnSim_curaUmvigo);
		
		
		rdbtnNo_curaUmvigo.setBounds(274, 130, 66, 23);
		panel_2.add(rdbtnNo_curaUmvigo);
		bgroup_curaUmbigo.add(rdbtnSim_curaUmvigo);
		bgroup_curaUmbigo.add(rdbtnNo_curaUmvigo);
		
		
		
		radioNao_colastro.setBounds(274, 168, 66, 23);
		panel_2.add(radioNao_colastro);
		
		
		radioSim_colastro.setBounds(192, 168, 61, 23);
		panel_2.add(radioSim_colastro);
		
		
		bgroup_colastro.add(radioSim_colastro);
		bgroup_colastro.add(radioNao_colastro);
		
		
		radioNao_marcacao.setBounds(274, 206, 66, 23);
		panel_2.add(radioNao_marcacao);
		
		
		radioSim_marcacao.setBounds(192, 206, 61, 23);
		panel_2.add(radioSim_marcacao);
		bgroup_marcacao.add(radioSim_marcacao);
		bgroup_marcacao.add(radioNao_marcacao);
		
		JLabel label_2 = new JLabel("/");
		label_2.setFont(new Font("Dialog", Font.BOLD, 16));
		label_2.setBounds(406, 52, 17, 24);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("/");
		label_3.setFont(new Font("Dialog", Font.BOLD, 16));
		label_3.setBounds(406, 96, 17, 24);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("/");
		label_4.setFont(new Font("Dialog", Font.BOLD, 16));
		label_4.setBounds(288, 52, 17, 24);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("/");
		label_5.setFont(new Font("Dialog", Font.BOLD, 16));
		label_5.setBounds(288, 96, 17, 24);
		panel_2.add(label_5);
		
		JLabel lblIdentificaoDaCria = new JLabel("Identificação da Cria");
		lblIdentificaoDaCria.setFont(new Font("Dialog", Font.BOLD, 16));
		lblIdentificaoDaCria.setBounds(0, 14, 193, 24);
		panel_2.add(lblIdentificaoDaCria);
		
		textField_idCria = new JTextField();
		textField_idCria.setColumns(10);
		textField_idCria.setBounds(194, 12, 155, 24);
		panel_2.add(textField_idCria);
		
		JLabel lblRelaoCria = new JLabel("Relação Cria / Mãe");
		lblRelaoCria.setFont(new Font("Dialog", Font.BOLD, 40));
		lblRelaoCria.setBounds(135, 12, 432, 48);
		panel_criaMae.add(lblRelaoCria);
		label_cadastrar2.setBounds(546, 381, 96, 31);
		panel_criaMae.add(label_cadastrar2);
		
		final JLabel label_cancelar3 = new JLabel("");
		label_cancelar3.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_cancelar3.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/bt_cancelar2.jpg")));
			}
		});
		label_cancelar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_cancelar3.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(true);
				panel_criaMae.setVisible(false);
			}
		});
		label_cancelar3.setBounds(77, 381, 96, 31);
		panel_criaMae.add(label_cancelar3);
		
		JLabel label_principal = new JLabel("");
		label_principal.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/cadastro.jpg")));
		label_principal.setBounds(0, 0, 702, 424);
		panel_criaMae.add(label_principal);
		panel_criaMae.setVisible(false);
		
		JLabel lblReproduo = new JLabel("Reprodução");
		lblReproduo.setBounds(207, 0, 287, 56);
		lblReproduo.setFont(new Font("Dialog", Font.BOLD, 40));
		add(lblReproduo);
		
		JLabel lblQuantidadeDeVacas_1 = new JLabel("Quantidade de Animais Preenhas:");
		lblQuantidadeDeVacas_1.setBounds(28, 133, 494, 43);
		lblQuantidadeDeVacas_1.setFont(new Font("Dialog", Font.BOLD, 25));
		add(lblQuantidadeDeVacas_1);
		
		JLabel lblQuantidadeDeMortes = new JLabel("Quantidade de Mortes:");
		lblQuantidadeDeMortes.setBounds(28, 287, 339, 32);
		lblQuantidadeDeMortes.setFont(new Font("Dialog", Font.BOLD, 25));
		add(lblQuantidadeDeMortes);
		
		JLabel lblQuantidadeDeAbortos = new JLabel("Quantidade de Abortos:");
		lblQuantidadeDeAbortos.setBounds(28, 242, 339, 30);
		lblQuantidadeDeAbortos.setFont(new Font("Dialog", Font.BOLD, 25));
		add(lblQuantidadeDeAbortos);
		
		JLabel lblQuantidadeDeCrias = new JLabel("Quantidade de Crias:");
		lblQuantidadeDeCrias.setBounds(28, 188, 306, 32);
		lblQuantidadeDeCrias.setFont(new Font("Dialog", Font.BOLD, 25));
		add(lblQuantidadeDeCrias);
		
		JLabel lblQuantidadeDeVacas = new JLabel("Quantidade de Animais no Cio:");
		lblQuantidadeDeVacas.setBounds(28, 89, 454, 32);
		lblQuantidadeDeVacas.setFont(new Font("Dialog", Font.BOLD, 25));
		add(lblQuantidadeDeVacas);
		
		
		panel_1.setBounds(0, 0, 702, 424);
		add(panel_1);
		
		final JLabel label_reprodutora = new JLabel("");
		label_reprodutora.setBounds(251, 374, 178, 38);
		label_reprodutora.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_reprodutora.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				carregar=0;
				panel_1.setVisible(false);
				panel.setVisible(true);
				
			}
		});
		label_reprodutora.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_reprodutora.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/panel reprodução/bt_reprodutora.jpg")));

				
			}
		});
		
		final JLabel label_cancelar = new JLabel("");
		label_cancelar.setBounds(53, 378, 90, 34);
		label_cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_cancelar.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				carregar = 0;
				setVisible(false);
			}
		});
		label_cancelar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_cancelar.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/panel reprodução/bt_cancelar.jpg")));

				
			}
		});
		panel_1.setLayout(null);
		panel_1.add(label_cancelar);
		panel_1.add(label_reprodutora);
		
		final JLabel label_qMortes = new JLabel(""+sqlReproducao.retornaQtMortes(animal));
		label_qMortes.setBounds(370, 293, 116, 23);
		label_qMortes.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(label_qMortes);
		
		final JLabel label_qAbortos = new JLabel(""+sqlReproducao.retornaQtAbortos(animal));
		label_qAbortos.setBounds(375, 248, 116, 23);
		label_qAbortos.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(label_qAbortos);
		
		final JLabel label_qCrias = new JLabel(""+sqlReproducao.retornaQtCrias(animal));
		label_qCrias.setBounds(337, 195, 116, 23);
		label_qCrias.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(label_qCrias);
		
		final JLabel label_qAnimaisPreenhas = new JLabel(""+sqlReproducao.retornaVacasPrenhas(animal));
		label_qAnimaisPreenhas.setBounds(520, 145, 116, 23);
		label_qAnimaisPreenhas.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(label_qAnimaisPreenhas);
		
		
		
		final JLabel label_qAnimaisCio = new JLabel(""+sqlReproducao.retornaVacasCio(""+getDateTime(),animal));
		label_qAnimaisCio.setBounds(480, 95, 116, 23);
		label_qAnimaisCio.setFont(new Font("Dialog", Font.BOLD, 25));
		panel_1.add(label_qAnimaisCio);
		
		final JLabel label_relacaoCriaMae = new JLabel("");
		label_relacaoCriaMae.setBounds(493, 378, 186, 34);
		label_relacaoCriaMae.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				
				label_relacaoCriaMae.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("")));

				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				carregar=0;
				panel_1.setVisible(false);
				panel.setVisible(false);
				panel_criaMae.setVisible(true);
			}
		});
		label_relacaoCriaMae.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				label_relacaoCriaMae.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/panel reprodução/bt_relacaocria.jpg")));
				
			}
		});
		panel_1.add(label_relacaoCriaMae);
		
		JLabel label_imagem = new JLabel("");
		label_imagem.setBounds(0, 0, 702, 424);
		label_imagem.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				if(carregar == 0){
				label_qMortes.setText(""+sqlReproducao.retornaQtMortes(animal));
				label_qAbortos.setText(""+sqlReproducao.retornaQtAbortos(animal));
				label_qCrias.setText(""+sqlReproducao.retornaQtCrias(animal));
				label_qAnimaisPreenhas.setText(""+sqlReproducao.retornaVacasPrenhas(animal));
				label_qAnimaisCio.setText(""+sqlReproducao.retornaVacasCio(""+getDateTime(),animal));
				carregar=1;
				}
				
			}
		});
		label_imagem.setIcon(new ImageIcon(ReproducaoAnimal.class.getResource("/code/imagens/panel reprodução/tela reproducao.jpg")));
		panel_1.add(label_imagem);
		
		
		
	}
	
	private static  String getDateTime() {
		
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
        
        
    }
}
