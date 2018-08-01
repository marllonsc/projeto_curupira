package code.janelas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import code.dados.Animal;
import code.dados.HistoricoVacina;
import code.dados.Vacina;
import code.sql.SqlVacinas;
import code.sql.Sqlfunc;

import java.awt.TextArea;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class panelCadastrarVacinacao extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextField textField_ano;
	private JComboBox comboBox_mes = new JComboBox();
	private JComboBox comboBox_dia = new JComboBox();
	private JComboBox comboBox_Vacina = new JComboBox();
	private TextArea textArea_obsVacina = new TextArea();
	private TextArea textArea_ObsVacinacao = new TextArea();
	private SqlVacinas sqlVacinas = new SqlVacinas();
	private Sqlfunc sqlfunc = new Sqlfunc();

	public panelCadastrarVacinacao(final Animal animal) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		final JLabel lblCadastrar = new JLabel("");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCadastrar.setIcon(new ImageIcon(panelCadastrarVacinacao.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String data = ((String) comboBox_dia.getSelectedItem())+"/"+((String) comboBox_mes.getSelectedItem())+"/"+textField_ano.getText();
				String periodo = (String) comboBox_Vacina.getSelectedItem();
				int idVacina = 0;
				Vector<Vacina> vacinas = sqlVacinas.retornaVacinas();
				for (int i = 0; i < vacinas.size(); i++) {
					if(periodo.equalsIgnoreCase(vacinas.elementAt(i).getPeriodo())){
						idVacina = vacinas.elementAt(i).getId();
					}
				}
				String obs = textArea_ObsVacinacao.getText();
				int idanimal = sqlfunc.retornaIdAnimal(animal.getIdentificador());
				HistoricoVacina historicoVacina = new HistoricoVacina(idVacina,idanimal, data, obs);
				boolean resultado = sqlVacinas.cadastrarVacinaAnimal(historicoVacina);
				
				if(resultado){
					comboBox_dia.setSelectedItem("");
					comboBox_mes.setSelectedItem("");
					comboBox_Vacina.setSelectedItem("");
					textField_ano.setText("");
					textArea_ObsVacinacao.setText("");
					textArea_obsVacina.setText("");
					JOptionPane.showMessageDialog(null,
							"Cadastrado com Sucesso !!!");
				}else{
					JOptionPane.showMessageDialog(null,
							"Não Cadastrado !!!");
				}
				
			}
		});
		lblCadastrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCadastrar.setIcon(new ImageIcon(panelCadastrarVacinacao.class.getResource("/code/imagens/bt_cadastro.jpg")));
			}
		});
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(panelCadastrarVacinacao.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_dia.setSelectedItem("");
				comboBox_mes.setSelectedItem("");
				comboBox_Vacina.setSelectedItem("");
				textField_ano.setText("");
				textArea_ObsVacinacao.setText("");
				textArea_obsVacina.setText("");
				setVisible(false);
			}
		});
		lblNewLabel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon(panelCadastrarVacinacao.class.getResource("/code/imagens/bt_cancelar2.jpg")));
			}
		});
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String periodo = (String) comboBox_Vacina.getSelectedItem();
				String descricao = "";
				Vector<Vacina> vacinas = sqlVacinas.retornaVacinas();
				for (int i = 0; i < vacinas.size(); i++) {
					if(periodo.equalsIgnoreCase(vacinas.elementAt(i).getPeriodo())){
						descricao = vacinas.elementAt(i).getDescricao();
					}
				}
				textArea_obsVacina.setText(descricao);
				
			}
		});
		btnCarregar.setBounds(469, 136, 117, 25);
		add(btnCarregar);
		
		textArea_ObsVacinacao.setBounds(30, 208, 350, 167);
		add(textArea_ObsVacinacao);
		
		JLabel lblObservao = new JLabel("Observação");
		lblObservao.setBounds(155, 187, 97, 15);
		add(lblObservao);
		
		
		textArea_obsVacina.setEditable(false);
		textArea_obsVacina.setBounds(433, 208, 235, 167);
		add(textArea_obsVacina);
		
		JLabel lblObsVacina = new JLabel("Obs. Vacina");
		lblObsVacina.setBounds(495, 187, 117, 15);
		add(lblObsVacina);
		Vector<String> descicoes = sqlVacinas.retornaVacinasPeriodo();
		comboBox_Vacina.setModel(new DefaultComboBoxModel(descicoes));
		
		comboBox_Vacina.setBounds(109, 136, 285, 24);
		add(comboBox_Vacina);
		
		JLabel lblVacina = new JLabel("Vacina: ");
		lblVacina.setBounds(31, 136, 84, 25);
		add(lblVacina);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Dialog", Font.BOLD, 23));
		label_1.setBounds(432, 78, 17, 25);
		add(label_1);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Dialog", Font.BOLD, 23));
		label.setBounds(308, 78, 17, 25);
		add(label);
		
		textField_ano = new JTextField();
		textField_ano.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_ano.setBounds(455, 81, 114, 19);
		add(textField_ano);
		textField_ano.setColumns(10);
		
		
		comboBox_mes.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_mes.setBounds(332, 78, 84, 25);
		add(comboBox_mes);
		
		comboBox_dia.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_dia.setBounds(217, 78, 84, 25);
		add(comboBox_dia);
		
		JLabel lblDataDaVacina = new JLabel("Data da Vacina : ");
		lblDataDaVacina.setBounds(22, 78, 177, 25);
		add(lblDataDaVacina);
		
		JLabel lblCadastrarVacinaNo = new JLabel("Cadastrar Vacina no Animal");
		lblCadastrarVacinaNo.setFont(new Font("Dialog", Font.BOLD, 33));
		lblCadastrarVacinaNo.setBounds(84, 0, 532, 45);
		add(lblCadastrarVacinaNo);
		
		lblNewLabel.setBounds(75, 381, 97, 34);
		add(lblNewLabel);
		
		lblCadastrar.setBounds(545, 381, 97, 34);
		add(lblCadastrar);
		
		JLabel lblPrincipal = new JLabel("");
		lblPrincipal.setIcon(new ImageIcon(panelCadastrarVacinacao.class.getResource("/code/imagens/cadastro.jpg")));
		lblPrincipal.setBounds(0, 0, 700, 427);
		add(lblPrincipal);
		
		
	}
}
