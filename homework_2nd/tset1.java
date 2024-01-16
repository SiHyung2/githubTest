package homework_2nd;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;

public class tset1 extends JFrame{
	private static final long serialVersionUID = 7821144668532475480L;
	GridBagLayout gBag;
    public tset1() {
        //삽입할 컴포넌트 생성.
        Label lblReceive = new Label("받을 사람:",Label.RIGHT);
        Label lblContent = new Label("내 용:",Label.RIGHT);
        Label lblFile = new Label("첨부 파일:",Label.RIGHT);
        Button btnSearch = new Button("찾아보기");
        Button btnSend = new Button("보내기");
        TextField toPerson = new TextField(40);
        TextField file = new TextField(30);
        TextArea content = new TextArea(5,40);
        gBag = new GridBagLayout(); //GridBagLayout 생성
       
        setLayout(gBag);
        gbinsert(lblReceive, 0, 0, 1, 1); //GridBagLayout에 삽입 , 모눈종이에 컴포넌트를 배치한다고 생각
        gbinsert(toPerson, 1, 0, 3, 1);    
        gbinsert(lblContent, 0, 1, 1, 1);
        gbinsert(content, 1, 1, 3, 1);
        gbinsert(lblFile, 0, 2, 1, 1);
        gbinsert(file, 1, 2, 2, 1);
        gbinsert(btnSearch, 3, 2, 1, 1);
        gbinsert(btnSend, 0, 3, 4, 1);
       
       
        this.pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    public void gbinsert(Component c, int x, int y, int w, int h){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gBag.setConstraints(c,gbc);
        this.add(c);
       
       
    }
   
    public static void main(String[] args) {
        new tset1();
    }
}
