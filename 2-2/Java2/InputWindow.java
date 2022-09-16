import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class InputWindow extends JTabbedPane {
	private JTextField jTextField_name;
	private JComboBox jComboBox_address;
	private JRadioButton jRadioButton_male;
	private JRadioButton jRadioButton_female;
	private JCheckBox jCheckBox_foreigner;
	private JTextArea jTextArea_memo;
	public InputWindow() {
		
		JPanel panel = new JPanel();
		addTab("상담입력", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("피상담자 정보      이름  ");
		panel_1.add(lblNewLabel);
		
		jTextField_name = new JTextField();
		panel_1.add(jTextField_name);
		jTextField_name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("    거주지역 ");
		panel_1.add(lblNewLabel_1);
		
		jComboBox_address = new JComboBox();
		jComboBox_address.setModel(new DefaultComboBoxModel(new String[] {"서울", "대전", "대구", "부산", "김해", "창원", "제주", "기타"}));
		panel_1.add(jComboBox_address);
		
		JLabel lblNewLabel_2 = new JLabel("     성별 ");
		panel_1.add(lblNewLabel_2);
		
		jRadioButton_male = new JRadioButton("남자");
		panel_1.add(jRadioButton_male);
		
		jRadioButton_female = new JRadioButton("여자");
		panel_1.add(jRadioButton_female);

		ButtonGroup	buttonGroup=new ButtonGroup();
		buttonGroup.add(jRadioButton_female);
		buttonGroup.add(jRadioButton_male);
		
		
		JLabel lblNewLabel_3 = new JLabel("     ");
		panel_1.add(lblNewLabel_3);
		
		jCheckBox_foreigner = new JCheckBox("외국인여부");
		panel_1.add(jCheckBox_foreigner);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		JButton jButton_clear = new JButton("새상담입력");
		panel_2.add(jButton_clear);
		
		JButton jButton_save = new JButton("상담저장");
		jButton_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		panel_2.add(jButton_save);
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		jTextArea_memo = new JTextArea();
		scrollPane.setViewportView(jTextArea_memo);
		
		JLabel lblNewLabel_4 = new JLabel("상담내용");
		lblNewLabel_4.setBorder(new EmptyBorder(10, 10, 10, 10));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("     ");
		scrollPane.setRowHeaderView(lblNewLabel_5);
	}
	protected void save() {
		String	name=jTextField_name.getText();
		if(name.equals("")) { message("이름을 입력하세요."); return; }
		String	address=jComboBox_address.getSelectedItem().toString();
		if(jRadioButton_female.isSelected()==false && jRadioButton_male.isSelected()==false) { message("성별을 선택하세요."); return; }
		String	gender=jRadioButton_female.isSelected()? "여자" : "남자";
		String	foreigner=jCheckBox_foreigner.isSelected()? "외국인" : "한국인";
		String	memo=jTextArea_memo.getText().replaceAll("\\s+", " ");
		if(memo.equals("")) { message("상담내용을 입력하세요."); return; }
		SimpleDateFormat	sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss (E)");
		String	date=sdf.format(new Date());
		String	v=date+"\t"+name+"\t"+address+"\t"+gender+"\t"+foreigner+"\t"+memo;
		
		try {
			FileWriter	oF=new FileWriter("C:/Temp/memo.txt", true);
			oF.write(v+"\n");
			oF.close();
			message("상담 저장 완료");
		} catch (Exception e) {
			message(e.getMessage());
		}
		
	}
	private void message(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}

}
