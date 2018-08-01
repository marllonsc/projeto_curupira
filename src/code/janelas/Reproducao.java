package code.janelas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.TextArea;

public class Reproducao extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTable table;
	public Reproducao() {
		
		super("Curupira - Bolvinos Reprodução ");
		setSize(998, 509);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 14, 983, 483);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEvoluoDoRebanho = new JLabel("EVOLUÇÃO DO REBANHO BOVINO ");
		lblEvoluoDoRebanho.setBounds(145, 0, 693, 43);
		panel.add(lblEvoluoDoRebanho);
		lblEvoluoDoRebanho.setFont(new Font("Dialog", Font.BOLD, 36));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ANO I", null, null, null, null, null, null, null, null, null},
				{"Estoque", null, null, null, null, null, null, null, null, null},
				{"Aquisi\u00E7\u00E3o", null, null, null, null, null, null, null, null, null},
				{"Nascimento", null, null, null, null, null, null, null, null, null},
				{"Perda", null, null, null, null, null, null, null, null, null},
				{"Venda", null, null, null, null, null, null, null, null, null},
				{"Ocupa\u00E7\u00E3o (ha)", null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setMinWidth(100);
		table.setBounds(75, 124, 833, 112);
		panel.add(table);
		
		JLabel lblEspecificao = new JLabel("Especificação");
		lblEspecificao.setBounds(73, 97, 112, 15);
		panel.add(lblEspecificao);
		
		JLabel lblTouros = new JLabel("Touros\n");
		lblTouros.setBounds(191, 97, 70, 15);
		panel.add(lblTouros);
		
		JLabel lblVacas = new JLabel("Vacas");
		lblVacas.setBounds(272, 97, 70, 15);
		panel.add(lblVacas);
		
		JLabel lblMAt = new JLabel("M até 1º a");
		lblMAt.setBounds(342, 97, 83, 15);
		panel.add(lblMAt);
		
		JLabel lblFAt = new JLabel("F até 1º a");
		lblFAt.setBounds(427, 97, 70, 15);
		panel.add(lblFAt);
		
		JLabel lblM = new JLabel("M  1º- 2º a");
		lblM.setBounds(507, 97, 83, 15);
		panel.add(lblM);
		
		JLabel lblF = new JLabel("F  1º- 2º a");
		lblF.setBounds(589, 97, 70, 15);
		panel.add(lblF);
		
		JLabel lblM_1 = new JLabel("M  2º- 3º a");
		lblM_1.setBounds(671, 97, 83, 15);
		panel.add(lblM_1);
		
		JLabel lblF_1 = new JLabel("F  2º- 3º a");
		lblF_1.setBounds(756, 97, 70, 15);
		panel.add(lblF_1);
		
		JLabel lblTotais = new JLabel("Totais");
		lblTotais.setBounds(838, 97, 70, 15);
		panel.add(lblTotais);
		
		JLabel lblNewLabel = new JLabel("ÍNDICES ZOOTÉCNICOS APLICADOS A PRODUÇÃO DE BOVINOS DE CORTE");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(117, 271, 749, 15);
		panel.add(lblNewLabel);
		
		String parte1 = " Taxa de natalidade => 1º ano (70%) / => 2º ano (80%) "+"\n\n Taxa de mortalidade => Até o 1º ano (3%) \n => Depois do 1ºano (1%) "+"\n\nVenda de machos até 1 ano => (100%)";
		
		String parte2 = "Venda de vacas (descarte) 1º ano => 10% \n" +"2º ano => 10% / 3º ano => 20% \n\n"+"Ocupação por (ha) para cada categoria: \n"+"Bezerros(as) até 1 ano => 0,25 Bezerros(as) até 1 ano => 0,25 UA | Touros => 1,25 UA"+"\n Bezerros(as) de 1 a 2 anos => 0,50 UA Vacas => 1,00 UA ";
				
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText(parte1);
		textArea.setBounds(58, 326, 439, 145);
		panel.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setText(parte2);
		textArea_1.setEditable(false);
		textArea_1.setBounds(522, 326, 439, 145);
		panel.add(textArea_1);
		setVisible(true);
		
		
	}
}
