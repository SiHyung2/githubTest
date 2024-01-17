package homework_2nd;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

import javax.swing.JFrame;

public class BasicGui extends JFrame{
	private static final long serialVersionUID = -6336499109619045510L;
	GridBagLayout gBag;  
    public BasicGui() {
        //삽입할 컴포넌트 생성.
        Label fileAdress = new Label("파일경로 :",Label.RIGHT);  
        Label lblContent = new Label("내 용:",Label.RIGHT);
        Label lblFile = new Label("첨부 파일:",Label.RIGHT);
        
        Button btnSearch = new Button("추가");
        Button btnAddition = new Button("추가");
        Button btnModify = new Button("수정");
        Button btnDelete = new Button("삭제");
        Button btnArrary = new Button("정렬");
        Button btnSave = new Button("저장");
        btnSearch.setBackground(Color.lightGray);   // java 에서 버튼 스타일 지정
        btnAddition.setPreferredSize(new Dimension(90,30));
        btnModify.setPreferredSize(new Dimension(50,30));
        btnDelete.setPreferredSize(new Dimension(50,30));
        btnArrary.setPreferredSize(new Dimension(50,30));
        btnSave.setPreferredSize(new Dimension(50,30));
        
        TextField Adressinput = new TextField(40);     
        TextField file = new TextField(30);
        TextArea content = new TextArea(5,40);
        gBag = new GridBagLayout();    // 현재 클래스를 그리드백(grid bag) 레이아웃으로 설정
        setLayout(new GridBagLayout()); // 4행 1열의 그리드 레이아웃 설정
       
        
        //GridBagLayout에 삽입
        setLayout(gBag);
        //1번째 줄 삽입
        gbinsert(fileAdress, 0, 0, 1, 1); 
        gbinsert(Adressinput, 1, 0, 3, 1);    
        gbinsert(btnSearch, 4, 0, 1, 1);
        //2번째 줄 삽입
        gbinsert(btnSearch, 0, 1, 1, 1);
        gbinsert(btnAddition, 1, 1, 1, 1);
        gbinsert(btnModify, 2, 1, 1, 1);
        gbinsert(btnDelete, 3, 1, 1, 1);
        gbinsert(btnSave, 4, 1, 1, 1);
        
       
       
        this.pack();   //윈도우 크기를 자동으로 설정
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   

    // 그리드 레이아웃 매니저를 사용할 때 컴포넌트의 제약 조건 정의하는 클래스
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
        new BasicGui();
    }
}
