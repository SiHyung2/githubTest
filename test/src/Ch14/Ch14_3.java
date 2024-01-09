package Ch14;
import java.awt.*;
import javax.swing.*;


public class Ch14_3 extends JFrame {
	private static final long serialVersionUID = -8421838651433886339L;
	private Container contentPane;
	
	public Ch14_3() {
		setTitle("툴바 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane=getContentPane();
		createToolBar();
		setSize(400,200);
		setVisible(true);
	}

	@SuppressWarnings("unchecked")
	private void createToolBar() {
		JToolBar toolBar=new JToolBar("Kitae Menu");
		toolBar.setBackground(Color.LIGHT_GRAY);
		
		toolBar.add(new JButton("New"));
		toolBar.add(new JButton(new ImageIcon("C:\\Users\\tlgud\\OneDrive\\바탕 화면\\그림 자료\\open.png")));
		
		toolBar.addSeparator();
		toolBar.add(new JButton(new ImageIcon("C:\\Users\\tlgud\\OneDrive\\바탕 화면\\그림 자료\\save.png")));
		toolBar.add(new JLabel("search"));
		toolBar.add(new JTextField("text field"));
		
		@SuppressWarnings("rawtypes")
		JComboBox combo=new JComboBox();
		combo.addItem("Java");
		combo.addItem("C#");
		combo.addItem("C");
		combo.addItem("C++");
		toolBar.add(combo);
		contentPane.add(toolBar, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		new Ch14_3();
	}
}
