package code.janelas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import code.dados.Animal;
import code.dados.HistoricoZootecnia;
import code.dados.Zootecnica;
import code.sql.SqlZootecnia;
import code.sql.Sqlfunc;

import java.awt.TextArea;
import java.util.Vector;

public class PanelCadastrarPZoo extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JTextField textField_ano;
	private JComboBox comboBox_mes = new JComboBox();
	private JComboBox comboBox_dia = new JComboBox();
	private TextArea textArea = new TextArea();
	private JComboBox comboBox_pratica = new JComboBox();
	private Vector<String> PZootecnias = new Vector<String>();
	private SqlZootecnia sqlZootecnia = new SqlZootecnia();
	private Sqlfunc sqlfunc = new Sqlfunc();
	
	public PanelCadastrarPZoo(final Animal animal) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		final JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelCadastrarPZoo.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblCancelar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelCadastrarPZoo.class.getResource("/code/imagens/bt_cancelar2.jpg")));
			}
		});
		
		PZootecnias = sqlZootecnia.retornaZooPratica();
		
		textArea.setBounds(32, 210, 628, 167);
		add(textArea);
		
		JLabel lblObservao = new JLabel("Observação");
		lblObservao.setBounds(299, 188, 94, 25);
		add(lblObservao);
		comboBox_pratica.setModel(new DefaultComboBoxModel(PZootecnias));
		comboBox_pratica.setToolTipText("\n");
		
		
		comboBox_pratica.setBounds(226, 132, 241, 24);
		add(comboBox_pratica);
		
		JLabel lblPrtica = new JLabel("Prática: ");
		lblPrtica.setBounds(311, 115, 70, 15);
		add(lblPrtica);
		
		textField_ano = new JTextField();
		textField_ano.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField_ano.setBounds(474, 76, 114, 22);
		add(textField_ano);
		textField_ano.setColumns(10);
		
		JLabel label_1 = new JLabel("/");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(456, 67, 19, 33);
		add(label_1);
		
		JLabel label = new JLabel("/");
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(345, 69, 19, 33);
		add(label);
		
		
		comboBox_mes.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBox_mes.setBounds(373, 75, 76, 24);
		add(comboBox_mes);
		
		
		comboBox_dia.setModel(new DefaultComboBoxModel(new String[] {"", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_dia.setBounds(262, 75, 76, 24);
		add(comboBox_dia);
		
		JLabel lblDataDaPrtica = new JLabel("Data da Prática :");
		lblDataDaPrtica.setBounds(111, 75, 131, 25);
		add(lblDataDaPrtica);
		
		lblCancelar.setBounds(76, 383, 94, 44);
		add(lblCancelar);
		
		final JLabel lblCadastrar = new JLabel("");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCadastrar.setIcon(new ImageIcon(PanelCadastrarPZoo.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				String data = (String) comboBox_dia.getSelectedItem()+"/"+ (String) comboBox_mes.getSelectedItem()+"/"+textField_ano.getText();
				String pratica = (String) comboBox_pratica.getSelectedItem();
				Vector<Zootecnica> zootecnicas = sqlZootecnia.retornaPraticasZoo();
				int idZootecnia = 0;
				for (int i = 0; i < zootecnicas.size(); i++) {
					if(zootecnicas.elementAt(i).getPratica().equalsIgnoreCase(pratica)){
						idZootecnia = zootecnicas.elementAt(i).getId();
					}
				}
				String observacao = textArea.getText();
				int idAnimal = sqlfunc.retornaIdAnimal(animal.getIdentificador());
				HistoricoZootecnia historicoZootecnia = new HistoricoZootecnia(idAnimal, idZootecnia, data, observacao);
				boolean resultado = sqlZootecnia.cadastrarPratizaZootecnica(historicoZootecnia);
				if(resultado){
					comboBox_dia.setSelectedItem("");
					comboBox_mes.setSelectedItem("");
					comboBox_pratica.setSelectedItem("");
					textArea.setText("");
					textField_ano.setText("");
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
				lblCadastrar.setIcon(new ImageIcon(PanelCadastrarPZoo.class.getResource("/code/imagens/bt_cadastro.jpg")));
			}
		});
		
		lblCadastrar.setBounds(545, 383, 94, 44);
		add(lblCadastrar);
		
		JLabel lblCadastrarPrticaZoo = new JLabel("Cadastrar Prática Zootécnica no animal");
		lblCadastrarPrticaZoo.setBounds(32, 5, 628, 33);
		lblCadastrarPrticaZoo.setFont(new Font("Dialog", Font.BOLD, 28));
		add(lblCadastrarPrticaZoo);
		
		JLabel lblPrincipal = new JLabel("");
		lblPrincipal.setIcon(new ImageIcon(PanelCadastrarPZoo.class.getResource("/code/imagens/cadastro.jpg")));
		lblPrincipal.setBounds(0, 0, 693, 439);
		add(lblPrincipal);
		
		
	}
}
