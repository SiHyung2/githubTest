package Ch14;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ch14_2 extends JFrame{
	private static final long serialVersionUID = -2759061091804031438L;
	private JLabel imgLabel = new JLabel();  // imgLabel 추가  (중요!)
	public Ch14_2() {
		
		setTitle("Menu 만들기 예제");
		createMenu();
		
		getContentPane().add(imgLabel,BorderLayout.CENTER);
		setSize(250,200);
		setVisible(true);
	}
	private void createMenu() {
		JMenuBar mb=new JMenuBar();
		JMenuItem[] menuItem=new JMenuItem[4];
		String[] itemTitle= {"Load", "Hide", "ReShow", "Exit"};		
		JMenu screenMenu=new JMenu("Screen");
		
		MenuActionListener litener=new MenuActionListener();
		
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i]=new JMenuItem(itemTitle[i]);
			menuItem[i].addActionListener(litener);
			screenMenu.add(menuItem[i]);
		}
		mb.add(screenMenu);
		setJMenuBar(mb);			
	}
	
	class MenuActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String cmd=e.getActionCommand();
			switch(cmd) {
				case "Load":
					if(imgLabel.getIcon()!=null) 
						return;   //이미 로딩되었으면 리턴
					imgLabel.setIcon(new ImageIcon("C:\\Users\\tlgud\\OneDrive\\바탕 화면\\그림 자료\\cobayashi.png"));
					
					break;
				case "Hide" :
					imgLabel.setVisible(false);
					break;
				case "ReShow" :
					imgLabel.setVisible(true);
					break;
				case "Exit" :
					System.exit(0);
					break;
			}
		}	
	}
	
	public static void main(String[] args) {
		new Ch14_2();
	}
}
