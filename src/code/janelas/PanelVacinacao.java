package code.janelas;

import java.awt.Color;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.sun.imageio.plugins.jpeg.JPEG;

import Tabela.ScrollableJTable;

import code.dados.Animal;
import code.dados.VacinaTabela;
import code.sql.SqlVacinas;
import code.sql.Sqlfunc;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Vector;


public class PanelVacinacao extends JPanel{

	
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField textField_idAnimal;
	private Sqlfunc sqlfunc = new Sqlfunc();
	private SqlVacinas sqlVacinas = new SqlVacinas();
	private JLabel label_Busca = new JLabel("");
	private Animal animal;
	private JPanel panel = new JPanel();
	JPanel panel_Cadastrar = new JPanel();
	JPanel panel_Excluir = new JPanel();
	private Vector<VacinaTabela> vacinaTabelas = new Vector<VacinaTabela>();
	private final JLabel lblData = new JLabel("Data: ");
	private final JTextField textField = new JTextField();
	private final JLabel lblObservao = new JLabel("Observação :");
	private final TextArea textArea_obs = new TextArea();
	private final JLabel Anterior = new JLabel("");
	private final JLabel proximo = new JLabel("");
	private int indice = 0;
	private final JLabel lblPrtica = new JLabel("Periodo:");
	private final JTextField textField_pratica = new JTextField();
	private final JLabel lblDescrio = new JLabel("Descrição:");
	private final JTextField textField_desc = new JTextField();
	

	public PanelVacinacao(final String ani) {
		textField_desc.setEditable(false);
		textField_desc.setBounds(128, 136, 512, 19);
		textField_desc.setColumns(10);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(!panel_Cadastrar.isVisible() && !panel_Excluir.isVisible()){
					panel.setVisible(true);
				}
			}
		});
		
		
		setBackground(Color.WHITE);
		setBounds(23, 22, 702, 436);
		setLayout(null);
		table = new JTable();
		panel.setBackground(Color.WHITE);
		
		panel.setBounds(0, 0, 718, 448);
		add(panel);
		panel.setLayout(null);
		panel_Cadastrar.setVisible(false);
		panel_Excluir.setVisible(false);
		
		Anterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				Anterior.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/anterior_verde.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				indice--;
				if(indice < 0){
					indice = vacinaTabelas.size()-1;
				}
				
				if(vacinaTabelas.size()>0){
					textArea_obs.setText(vacinaTabelas.get(indice).getObservação());
					textField.setText(vacinaTabelas.get(indice).getData());
					textField_pratica.setText(vacinaTabelas.get(indice).getPerido());
					textField_desc.setText(vacinaTabelas.get(indice).getDescrição());
					}else{
						JOptionPane.showMessageDialog(null,"Sem dados cadastrados !");
					}
			}
		});
		Anterior.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Anterior.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/anterior_azul.jpg")));
			}
		});
		proximo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				proximo.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/proximo_azul.jpg")));
			}
		});
		proximo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				proximo.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/proximo_verde.jpg")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				indice++;
				if(indice == vacinaTabelas.size()){
					indice = 0;
				}
				
				if(vacinaTabelas.size()>0){
					textArea_obs.setText(vacinaTabelas.get(indice).getObservação());
					textField.setText(vacinaTabelas.get(indice).getData());
					textField_pratica.setText(vacinaTabelas.get(indice).getPerido());
					textField_desc.setText(vacinaTabelas.get(indice).getDescrição());
					}else{
						JOptionPane.showMessageDialog(null,"Sem dados cadastrados !");
					}
			}
		});
		lblDescrio.setBounds(47, 138, 84, 15);
		
		panel.add(lblDescrio);
		textField_pratica.setEditable(false);
		textField_pratica.setBounds(370, 101, 270, 19);
		textField_pratica.setColumns(10);
		
		panel.add(textField_pratica);
		lblPrtica.setBounds(310, 103, 70, 15);
		
		panel.add(lblPrtica);
		proximo.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/proximo_verde.jpg")));
		proximo.setBounds(452, 281, 160, 51);
		
		panel.add(proximo);
		Anterior.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/anterior_verde.jpg")));
		Anterior.setBounds(93, 281, 160, 51);
		
		panel.add(Anterior);
		textArea_obs.setEditable(false);
		textArea_obs.setBounds(118, 196, 465, 64);
		
		panel.add(textArea_obs);
		lblObservao.setBounds(295, 175, 112, 15);
		
		panel.add(lblObservao);
		textField.setEditable(false);
		textField.setBounds(95, 101, 191, 19);
		textField.setColumns(10);
		
		panel.add(textField);
		lblData.setBounds(47, 101, 84, 19);
		
		panel.add(lblData);
		
		label_Busca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				label_Busca.setIcon(new ImageIcon(PanelVacinacao.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				animal = sqlfunc.buscaAnimal(textField_idAnimal.getText(),ani);
				
				
				if(animal!=null){
				vacinaTabelas = sqlVacinas.retornaVacinasAnimal(sqlfunc.retornaIdAnimal(animal.getIdentificador()));
				
				if(vacinaTabelas.size()>0){
					textArea_obs.setText(vacinaTabelas.get(vacinaTabelas.size()-1).getObservação());
					textField.setText(vacinaTabelas.get(vacinaTabelas.size()-1).getData());
					textField_pratica.setText(vacinaTabelas.get(vacinaTabelas.size()-1).getPerido());
					textField_desc.setText(vacinaTabelas.get(vacinaTabelas.size()-1).getDescrição());
					indice = vacinaTabelas.size()-1;
					}
				
				}else{
					JOptionPane.showMessageDialog(null,"Animal Não Encontrado");
					
				}
				
				
				
			}
		});
		label_Busca.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				label_Busca.setIcon(new ImageIcon(PanelVacinacao.class.getResource("/code/imagens/bt_buscar.jpg")));
			}
		});
		
		final JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelVacinacao.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblCancelar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelVacinacao.class.getResource("/code/imagens/bt_cancelar2.jpg")));
			}
		});
		
		final JLabel lblCadastrar = new JLabel("");
		lblCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(animal!=null){
				panel_Cadastrar = new panelCadastrarVacinacao(animal);
				panel_Cadastrar.setBounds(0, 0, 718, 448);
				add(panel_Cadastrar);
				panel.setVisible(false);
				panel_Excluir.setVisible(false);
				panel_Cadastrar.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"Animal Não Pesquisado !");
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblCadastrar.setIcon(new ImageIcon(PanelVacinacao.class.getResource("")));
			}
		});
		lblCadastrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCadastrar.setIcon(new ImageIcon(PanelVacinacao.class.getResource("/code/imagens/butaoCadastrarVacina.jpg")));
			}
		});
		
		final JLabel lblExcluir = new JLabel("");
		lblExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblExcluir.setIcon(new ImageIcon(PanelVacinacao.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(animal!=null){
				panel_Excluir = new PanelExcluirVacinacao(animal);
				panel_Excluir.setBounds(0, 0, 718, 448);
				add(panel_Excluir);
				panel.setVisible(false);
				panel_Cadastrar.setVisible(false);
				panel_Excluir.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"Animal Não Pesquisado !");
				}
				
			}
		});
		lblExcluir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblExcluir.setIcon(new ImageIcon(PanelVacinacao.class.getResource("/code/imagens/BotaoExcluirVacinacao.jpg")));
			}
		});
		
		lblExcluir.setBounds(245, 361, 209, 36);
		panel.add(lblExcluir);
		
		lblCadastrar.setBounds(471, 361, 209, 36);
		panel.add(lblCadastrar);
		
		lblCancelar.setBounds(74, 370, 101, 36);
		panel.add(lblCancelar);
		
		
		
		label_Busca.setBounds(451, 38, 101, 33);
		panel.add(label_Busca);
		
		textField_idAnimal = new JTextField();
		textField_idAnimal.setBounds(310, 44, 133, 19);
		panel.add(textField_idAnimal);
		textField_idAnimal.setColumns(10);
		
		JLabel lblIdAnimal = new JLabel("ID Animal:");
		lblIdAnimal.setBounds(233, 46, 80, 15);
		panel.add(lblIdAnimal);
		
		JLabel lblVacinas = new JLabel("Vacinas");
		lblVacinas.setBounds(0, 0, 215, 45);
		panel.add(lblVacinas);
		lblVacinas.setFont(new Font("Dialog", Font.BOLD, 45));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 694, 406);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(PanelVacinacao.class.getResource("/code/imagens/vacinacao.png")));
		
		panel.add(textField_desc);
		
		
		
	}
}
