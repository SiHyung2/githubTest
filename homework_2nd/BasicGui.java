package homework_2nd;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BasicGui extends JFrame{
	private static final long serialVersionUID = -6336499109619045510L;
	public BasicGui() {
		setTitle("Person Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c=getContentPane();
		 setLayout(new GridLayout(3, 1));  // 3행 1열
		c.setLayout(null);
		setSize(400,300);
		setVisible(true);
		
		//첫번째 줄 :라벨, 텍스트 필드, 버튼
		JPanel firstPanel=new JPanel(new FlowLayout());
		JLabel label=new JLabel("파일 경로 : ");   //라벨 생성
		JTextField textField=new JTextField(10);
		JButton button=new JButton("열기");
		
		firstPanel.add(label);
		firstPanel.add(textField);
		firstPanel.add(button);
		
		
		//두번째 줄: 버튼
		JButton b2=new JButton("추가");  
		c.add(b2);
		JButton b3=new JButton("수정");   
		c.add(b3);
		JButton b4=new JButton("삭제");  
		c.add(b4);
		JButton b5=new JButton("정렬");  
		c.add(b5);
		JButton b6=new JButton("저장");   
		c.add(b6);
		
		
		
	}
	public static void main(String[] args) {
		new BasicGui();
	}
}
