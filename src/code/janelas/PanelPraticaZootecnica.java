package code.janelas;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

import code.dados.Animal;
import code.dados.TabelaZootecnica;
import code.dados.VacinaTabela;
import code.sql.SqlZootecnia;
import code.sql.Sqlfunc;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.Vector;
import javax.swing.JTextField;
import java.awt.TextArea;


public class PanelPraticaZootecnica extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Animal animal;
	private Sqlfunc sqlfunc = new Sqlfunc();
	private SqlZootecnia sqlZootecnia = new SqlZootecnia();
	private JTextField textField_idAnimal;
	private JTable table;
	private JPanel panel = new JPanel();
	private JPanel panel_cadastrar = new JPanel();
	private JPanel panel_excluir = new JPanel();
	private final JLabel lblData = new JLabel("Data: ");
	private final JTextField textField = new JTextField();
	private final JLabel lblObservao = new JLabel("Observação :");
	private final TextArea textArea_obs = new TextArea();
	private final JLabel Anterior = new JLabel("");
	private final JLabel proximo = new JLabel("");
	private  JLabel lblCadastro = new JLabel("");
	private JLabel lblExcluir = new JLabel("");
	private int indice = 0;
	private Vector<TabelaZootecnica> vacinaTabelas = new Vector<TabelaZootecnica>();
	private final JLabel lblPrtica = new JLabel("Prática:");
	private final JTextField textField_pratica = new JTextField();

	public PanelPraticaZootecnica(final String ani) {
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(!panel_cadastrar.isVisible() && !panel_excluir.isVisible()){
					panel.setVisible(true);
				}
			}
		});
		setBackground(Color.WHITE);
		setBounds(23, 22, 702, 436);
		setLayout(null);
		
		table = new JTable();
		panel.setBackground(Color.WHITE);
		
		
		panel.setBounds(0, 0, 702, 436);
		add(panel);
		panel.setLayout(null);
		
		final JLabel lblCancelar = new JLabel("");
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblCancelar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCancelar.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/bt_cancelar2.jpg")));
			}
		});
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
					textArea_obs.setText(vacinaTabelas.get(indice).getObs());
					textField.setText(vacinaTabelas.get(indice).getData());
					textField_pratica.setText(vacinaTabelas.get(indice).getPratica());
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
					textArea_obs.setText(vacinaTabelas.get(indice).getObs());
					textField.setText(vacinaTabelas.get(indice).getData());
					textField_pratica.setText(vacinaTabelas.get(indice).getPratica());
					}else{
						JOptionPane.showMessageDialog(null,"Sem dados cadastrados !");
					}
			}
		});
		textField_pratica.setEditable(false);
		textField_pratica.setBounds(380, 133, 270, 19);
		textField_pratica.setColumns(10);
		
		panel.add(textField_pratica);
		lblPrtica.setBounds(309, 135, 70, 15);
		
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
		textField.setBounds(93, 133, 191, 19);
		textField.setColumns(10);
		
		panel.add(textField);
		lblData.setBounds(44, 133, 84, 19);
		
		panel.add(lblData);
		
		textField_idAnimal = new JTextField();
		textField_idAnimal.setBounds(276, 66, 169, 19);
		panel.add(textField_idAnimal);
		textField_idAnimal.setColumns(10);
		
		JLabel lblIdAnimal = new JLabel("Id Animal: ");
		lblIdAnimal.setBounds(177, 70, 84, 15);
		panel.add(lblIdAnimal);
		
		lblCancelar.setBounds(77, 379, 101, 45);
		panel.add(lblCancelar);
		
		
		lblExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblExcluir.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(animal!=null){
				panel_excluir = new PanelExcluirPZoo(animal);
				panel_excluir.setBounds(0, 0, 718, 448);
				add(panel_excluir);
				panel.setVisible(false);
				panel_cadastrar.setVisible(false);
				panel_excluir.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null,"Animal Não Pesquisado !!!");
				}
			}
		});
		lblExcluir.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblExcluir.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/BotaoExcluirVacinacao.jpg")));
			}
		});
		
		lblExcluir.setBounds(244, 370, 220, 39);
		panel.add(lblExcluir);
		
		
		lblCadastro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblCadastro.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(animal!=null){
				panel_cadastrar = new PanelCadastrarPZoo(animal);
				panel_cadastrar.setBounds(0, 0, 718, 448);
				add(panel_cadastrar);
				panel.setVisible(false);
				panel_cadastrar.setVisible(true);
				panel_excluir.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(null,"Animal Não Pesquisado !");
				}
			}
		});
		lblCadastro.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblCadastro.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/cadastrarPZootecnica.png")));
			}
		});
		
		lblCadastro.setBounds(469, 370, 209, 39);
		panel.add(lblCadastro);
		
		final JLabel lblBusca = new JLabel("");
		lblBusca.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				lblBusca.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("")));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				animal = sqlfunc.buscaAnimal(textField_idAnimal.getText(),ani);
				
				
				
				if(animal !=null){
				vacinaTabelas = sqlZootecnia.retornaPZootecniaAnimal(sqlfunc.retornaIdAnimal(animal.getIdentificador()));
				if(vacinaTabelas.size()>0){
				textArea_obs.setText(vacinaTabelas.get(vacinaTabelas.size()-1).getObs());
				textField.setText(vacinaTabelas.get(vacinaTabelas.size()-1).getData());
				textField_pratica.setText(vacinaTabelas.get(vacinaTabelas.size()-1).getPratica());
				indice = vacinaTabelas.size()-1;
				}
				
				}else{
					JOptionPane.showMessageDialog(null,"Animal Não Encontrado");
					
				}
				
				
			}
		});
		lblBusca.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblBusca.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/bt_buscar.jpg")));
			}
		});
		
		lblBusca.setBounds(452, 46, 112, 39);
		panel.add(lblBusca);
		
		JLabel lblPrticasZootcnicas = new JLabel("Práticas Zootécnicas");
		lblPrticasZootcnicas.setBounds(177, 5, 387, 39);
		panel.add(lblPrticasZootcnicas);
		lblPrticasZootcnicas.setFont(new Font("Dialog", Font.BOLD, 33));
		
		JLabel lblPrinciapl = new JLabel("");
		lblPrinciapl.setBounds(0, 0, 703, 436);
		panel.add(lblPrinciapl);
		lblPrinciapl.setIcon(new ImageIcon(PanelPraticaZootecnica.class.getResource("/code/imagens/JanelaPZoo.jpg")));
		panel_cadastrar.setBounds(0, 0, 702, 436);
		add(panel_cadastrar);
		
		
		panel_cadastrar.setBackground(Color.WHITE);
		
		
		panel_excluir.setBounds(0, 0, 703, 436);
		add(panel_excluir);
		panel_cadastrar.setVisible(false);
		panel_excluir.setVisible(false);
		
	}
}
