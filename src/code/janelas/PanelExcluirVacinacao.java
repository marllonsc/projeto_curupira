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
import javax.swing.JButton;
import javax.swing.JOptionPane;

import code.dados.Animal;
import code.dados.HistoricoVacina;
import code.dados.VacinaTabela;
import code.sql.SqlVacinas;
import code.sql.Sqlfunc;

import java.awt.TextArea;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelExcluirVacinacao extends JPanel{

	private static final long serialVersionUID = 1L;
	private SqlVacinas sqlVacinas = new SqlVacinas();
	private Sqlfunc sqlfunc = new Sqlfunc();
	private JComboBox comboBox_periodo = new JComboBox();
	private TextArea textArea_ObsVacina = new TextArea();
	private TextArea textArea_obsVacinacao = new TextArea();
	private Vector<String> datas = new Vector<String>();
	
	public PanelExcluirVacinacao(final Animal animal) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		datas = sqlVacinas.retornaVectorDatas(sqlfunc.retornaIdAnimal(animal.getIdentificador()));
		final JLabel Label_excluir = new JLabel("");
		Label_excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				Label_excluir.setIcon(new ImageIcon(PanelExcluirVacinacao.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				int idAnimal = sqlfunc.retornaIdAnimal(animal.getIdentificador());
				String data = (String) comboBox_periodo.getSelectedItem();
				String obs = textArea_obsVacinacao.getText();
				boolean resultado = sqlVacinas.excluirVacinaAnimal(idAnimal, obs, data);
				if(resultado){
					comboBox_periodo.setSelectedItem("");
					textArea_ObsVacina.setText("");
					textArea_obsVacinacao.setText("");
					JOptionPane.showMessageDialog(null,
							"Excluido com Sucesso !!!");
					datas.clear();
					datas = sqlVacinas.retornaVectorDatas(sqlfunc.retornaIdAnimal(animal.getIdentificador()));
					comboBox_periodo.setModel(new DefaultComboBoxModel(datas));
					
				}else{
					JOptionPane.showMessageDialog(null,
							"Não Excluido !!!");
				}
			}
		});
		Label_excluir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Label_excluir.setIcon(new ImageIcon(PanelExcluirVacinacao.class.getResource("/code/imagens/bt_excluir.jpg")));
			}
		});
		
		final JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelExcluirVacinacao.class.getResource("/code/imagens/bt_cancelar2.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_periodo.setSelectedItem("");
				textArea_ObsVacina.setText("");
				textArea_obsVacinacao.setText("");
				setVisible(false);
			}
		});
		lblCancelar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelExcluirVacinacao.class.getResource("/code/imagens/bt_cancelar2.jpg")));
			}
		});
		
		JLabel lblObsVacinao = new JLabel("Obs. Vacinação");
		lblObsVacinao.setBounds(485, 177, 117, 15);
		add(lblObsVacinao);
		
		JLabel lblObsVacina = new JLabel("Obs. Vacina");
		lblObsVacina.setBounds(131, 177, 101, 15);
		add(lblObsVacina);
		
		textArea_obsVacinacao.setBounds(407, 198, 265, 167);
		add(textArea_obsVacinacao);
		
		textArea_ObsVacina.setEditable(false);
		textArea_ObsVacina.setBounds(44, 198, 294, 167);
		add(textArea_ObsVacina);
		
		JButton btnCarregar = new JButton("Carregar");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<VacinaTabela> historicoVacinas = new Vector<VacinaTabela>();
				int idAnimal = sqlfunc.retornaIdAnimal(animal.getIdentificador());
				historicoVacinas = sqlVacinas.retornaVacinasAnimal(idAnimal);
				String data = (String) comboBox_periodo.getSelectedItem();
				String obs = "";
				String des = "";
				for (int i = 0; i < historicoVacinas.size(); i++) {
					if(data.equalsIgnoreCase(historicoVacinas.elementAt(i).getData())){
						obs = historicoVacinas.elementAt(i).getObservação();
						des = historicoVacinas.elementAt(i).getDescrição();
					}
					
				}
				textArea_ObsVacina.setText(des);
				textArea_obsVacinacao.setText(obs);
			}
		});
		btnCarregar.setBounds(468, 81, 117, 25);
		add(btnCarregar);
		comboBox_periodo.setModel(new DefaultComboBoxModel(datas));
		
		
		comboBox_periodo.setBounds(147, 81, 241, 24);
		add(comboBox_periodo);
		
		JLabel lblPeriodo = new JLabel("Data: ");
		lblPeriodo.setBounds(79, 83, 75, 21);
		add(lblPeriodo);
		
		lblCancelar.setBounds(77, 371, 96, 51);
		add(lblCancelar);
		
		Label_excluir.setBounds(547, 380, 92, 30);
		add(Label_excluir);
		
		JLabel lblExcluirVacinaDo = new JLabel("Excluir Vacina do Animal");
		lblExcluirVacinaDo.setFont(new Font("Dialog", Font.BOLD, 33));
		lblExcluirVacinaDo.setBounds(115, 0, 470, 39);
		add(lblExcluirVacinaDo);
		
		JLabel label_principal = new JLabel("");
		label_principal.setIcon(new ImageIcon(PanelExcluirVacinacao.class.getResource("/code/imagens/janelaExcluir.jpg")));
		label_principal.setBounds(0, 0, 701, 422);
		add(label_principal);
		
	}
}
