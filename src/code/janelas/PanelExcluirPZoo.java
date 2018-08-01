package code.janelas;

import javax.swing.JPanel;

import code.dados.Animal;
import code.dados.HistoricoZootecnia;
import code.dados.TabelaZootecnica;
import code.dados.Zootecnica;
import code.sql.SqlZootecnia;
import code.sql.Sqlfunc;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelExcluirPZoo extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private Vector<String> datas = new Vector<String>();
	private SqlZootecnia sqlSqlZootecnia = new SqlZootecnia();
	private Sqlfunc sqlfunc = new Sqlfunc();
	private JComboBox comboBox_data = new JComboBox();
	
	private TextArea textArea = new TextArea();

	public PanelExcluirPZoo(final Animal animal) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		datas = sqlSqlZootecnia.retornaVectorDatas(sqlfunc.retornaIdAnimal(animal.getIdentificador()));
		
		final JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelExcluirPZoo.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblCancelar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelExcluirPZoo.class.getResource("/code/imagens/bt_cancelar2.jpg")));
			}
		});
		
		final JLabel lblExcluir = new JLabel("");
		lblExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblExcluir.setIcon(new ImageIcon(PanelExcluirPZoo.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int idAnimal = sqlfunc.retornaIdAnimal(animal.getIdentificador());
				String data = (String) comboBox_data.getSelectedItem();
				String obs = textArea.getText();
				boolean resultado =  sqlSqlZootecnia.deletarPraticaZootecnica(idAnimal, obs, data);
				if(resultado){
					comboBox_data.setSelectedItem("");
					textArea.setText("");
					textField.setText("");
					JOptionPane.showMessageDialog(null,
							"Excluido com Sucesso !!!");
					datas.clear();
					datas = sqlSqlZootecnia.retornaVectorDatas(sqlfunc.retornaIdAnimal(animal.getIdentificador()));
					comboBox_data.setModel(new DefaultComboBoxModel(datas));
					
				}else{
					JOptionPane.showMessageDialog(null,
							"Não Excluido !!!");
				}
				
			}
		});
		lblExcluir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblExcluir.setIcon(new ImageIcon(PanelExcluirPZoo.class.getResource("/code/imagens/bt_excluir.jpg")));
			}
		});
		
		lblExcluir.setBounds(545, 383, 98, 36);
		add(lblExcluir);
		
		lblCancelar.setBounds(77, 383, 99, 36);
		add(lblCancelar);
		
		JLabel lblExcluirPrticaZootcnica = new JLabel("Excluir Prática Zootécnica do Animal");
		lblExcluirPrticaZootcnica.setBounds(33, 5, 615, 36);
		lblExcluirPrticaZootcnica.setFont(new Font("Dialog", Font.BOLD, 30));
		add(lblExcluirPrticaZootcnica);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setBounds(108, 74, 70, 15);
		add(lblData);
		comboBox_data.setModel(new DefaultComboBoxModel(datas));
		
		
		comboBox_data.setBounds(162, 69, 231, 24);
		add(comboBox_data);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<TabelaZootecnica> tabelaZootecnicas = new Vector<TabelaZootecnica>();
				tabelaZootecnicas = sqlSqlZootecnia.retornaPZootecniaAnimal(sqlfunc.retornaIdAnimal(animal.getIdentificador()));
				String pratica = "";
				String obs = "";
				for (int i = 0; i < tabelaZootecnicas.size(); i++) {
					if(((String) comboBox_data.getSelectedItem()).equalsIgnoreCase(tabelaZootecnicas.elementAt(i).getData())){
						pratica = tabelaZootecnicas.elementAt(i).getPratica();
						obs = tabelaZootecnicas.elementAt(i).getObs();
					}
				}
				textArea.setText(obs);
				textField.setText(pratica);
				
			}
		});
		btnCarregar.setBounds(493, 69, 117, 25);
		add(btnCarregar);
		
		JLabel lblPratica = new JLabel("Pratica");
		lblPratica.setBounds(143, 163, 70, 15);
		add(lblPratica);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(12, 190, 327, 36);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblObservaes = new JLabel("Observações");
		lblObservaes.setBounds(447, 163, 98, 15);
		add(lblObservaes);
		textArea.setEditable(false);
		
		
		textArea.setBounds(357, 190, 301, 167);
		add(textArea);
		
		JLabel lblPrincipal = new JLabel("");
		lblPrincipal.setIcon(new ImageIcon(PanelExcluirPZoo.class.getResource("/code/imagens/janelaExcluir.jpg")));
		lblPrincipal.setBounds(0, 0, 682, 431);
		add(lblPrincipal);
		
		
	}
}
