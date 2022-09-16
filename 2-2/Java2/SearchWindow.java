import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class SearchWindow extends JTabbedPane {
	private JTextField jTextField_queryText;
	private JTable table;
	private JComboBox jComboBox_queryField;
	public SearchWindow() {
		
		JPanel panel = new JPanel();
		addTab("상담검색", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		jComboBox_queryField = new JComboBox();
		jComboBox_queryField.setModel(new DefaultComboBoxModel(new String[] {"상담일시", "이름", "지역", "성별", "외국인유무", "상담내용"}));
		panel_1.add(jComboBox_queryField);
		
		jTextField_queryText = new JTextField();
		panel_1.add(jTextField_queryText);
		jTextField_queryText.setColumns(10);
		
		JButton jButton_search = new JButton("검색");
		jButton_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		panel_1.add(jButton_search);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("Page 0/0   ");
		panel_2.add(lblNewLabel);
		
		JButton jButton_prev = new JButton("이전");
		panel_2.add(jButton_prev);
		
		JButton jButton_next = new JButton("다음");
		panel_2.add(jButton_next);
		
		JSlider slider = new JSlider();
		panel_2.add(slider);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"상담일시", "이름", "지역", "성별", "외국인유무", "상담내용"
			}
		));
		scrollPane.setViewportView(table);
	}
	protected void search() {
		try {
			int queryFieldIndex=jComboBox_queryField.getSelectedIndex();
			String	queryText=jTextField_queryText.getText();
			DefaultTableModel	model=(DefaultTableModel) table.getModel();
			model.setRowCount(0);
			FileReader	fr=new FileReader("C:/Temp/memo.txt");
			BufferedReader	iF=new BufferedReader(fr);
			while(true) {
				String	line=iF.readLine();
				if(line==null) break;
				String	v[]=line.split("\t");
				if(v[queryFieldIndex].contains(queryText)==false) continue;
				model.addRow(v);
			}
			table.setModel(model);
			iF.close();
		} catch (Exception e) {
			message(e.getMessage());
		}
	}
	private void message(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}


}
