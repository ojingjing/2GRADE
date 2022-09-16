import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {
	InputWindow	inputWindow=new InputWindow(); // 상담입력화면객체
	SearchWindow	searchWindow=new SearchWindow(); // 상담검색화면객체
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(760, 415));
		setLocationRelativeTo(null);
		setTitle("상담관리프로그램");
		
		JMenuBar jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		JMenu jMenu_counselManagement = new JMenu("상담관리");
		jMenuBar.add(jMenu_counselManagement);
		
		JMenuItem jMenuItem_counselInput = new JMenuItem("상담입력");
		jMenuItem_counselInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.this.setContentPane(inputWindow);
				MainWindow.this.revalidate();
			}
		});
		jMenu_counselManagement.add(jMenuItem_counselInput);
		
		JMenuItem jMenuItem_counselSearch = new JMenuItem("상담검색");
		jMenuItem_counselSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.this.setContentPane(searchWindow);
				MainWindow.this.revalidate();
			}
		});
		jMenu_counselManagement.add(jMenuItem_counselSearch);
		
		JMenuItem jMenuItem_exit = new JMenuItem("끝내기");
		jMenuItem_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result=JOptionPane.showConfirmDialog(MainWindow.this, "종료하시겠습니까?", "종료확인", JOptionPane.YES_NO_OPTION);
				if(result==JOptionPane.YES_OPTION) System.exit(0);
			}
		});
		jMenu_counselManagement.add(jMenuItem_exit);
		
		JMenu jMenu_help = new JMenu("도움말");
		jMenuBar.add(jMenu_help);
		
		JMenuItem jMenuItem_usage = new JMenuItem("사용법");
		jMenuItem_usage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(MainWindow.this, "상담관리프로그램 Ver1.0");
			}
		});
		jMenu_help.add(jMenuItem_usage);
	}

	public static void main(String[] args) {
		MainWindow	w=new MainWindow();
		w.setVisible(true);
	}

}
