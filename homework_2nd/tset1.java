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
	GridBagLayout gBag;   //그리드 레이아웃 객체 생성.   다른 클래스에 그리드 적용할지도 모르니 클래스 변수로 생성됨
    public tset1() {
        //삽입할 컴포넌트 생성.
        Label lblReceive = new Label("받을 사람:",Label.RIGHT);   //".RIGHT" 부컴포넌트의 정렬 속성인데 큰 의미는 없음
        Label lblContent = new Label("내 용:",Label.RIGHT);
        Label lblFile = new Label("첨부 파일:",Label.RIGHT);
        Button btnSearch = new Button("찾아보기");
        Button btnSend = new Button("보내기");
        TextField toPerson = new TextField(40);     //단일 행의 텍스트 필드.  최대 글자 수는 40자
        TextField file = new TextField(30);       //두번째 텍스트 필드.
        TextArea content = new TextArea(5,40);     //여러줄을 입력 할 수 있는 텍스트 영역이다. 5행 40열로 지정됨
        gBag = new GridBagLayout();    // 현재 클래스를 그리드백 레이아웃 매니저 설정
        				//그리드백 레이아웃 : 그리드 레이아웃 중 하나. 다양한 크기의 그리드 셀을 배치하고 유연하게 배치 제어 할 수 있다 
       
        setLayout(gBag);
        gbinsert(lblReceive, 0, 0, 1, 1); //GridBagLayout에 삽입 , 모눈종이에 컴포넌트를 배치한다고 생각
        gbinsert(toPerson, 1, 0, 3, 1);    
        gbinsert(lblContent, 0, 1, 1, 1);
        gbinsert(content, 1, 1, 3, 1);
        gbinsert(lblFile, 0, 2, 1, 1);
        gbinsert(file, 1, 2, 2, 1);
        gbinsert(btnSearch, 3, 2, 1, 1);
        gbinsert(btnSend, 0, 3, 4, 1);
       
       
        this.pack();   //윈도우 크기를 자동으로 설정
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    
    //매개변수에 적혀있는 Component 는 자바 AWT 패키지의 클래스의 최상위 클래스이다
    //모든 사용자 인터페이스 요소의 기본 클래스로 사용됨
    // 그리드 레이아웃 매니저를 사용할 때 컴포넌트의 제약 조건 정의하는 클래스이다
    //GridBagConstraints 를 호출하여 배치와 크기를 지정할 수 있었다
    public void gbinsert(Component c, int x, int y, int w, int h){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.BOTH;       //객체 생성,   BOTH는 가로 및 세로로 그리드 셀을 채우도록 지정
        gbc.gridx = x;        //왼쪽 상단의 x,y 좌표
        gbc.gridy = y;
        gbc.gridwidth = w;      //가로크기와 세로크기 지정
        gbc.gridheight = h;
        gBag.setConstraints(c,gbc);   //그리드백 레이아웃에 컴포넌트의 제약조건 설정 (제약조건에 따라 위치와 크기로 추가됨)
                               //메소드에서 클래스 변수로 생성된 객체에 전달됨에 유의
        this.add(c);   //현재 클래스의 컨테이너에 컴포넌트 추가
       
       
    }
   
    public static void main(String[] args) {
        new tset1();
    }
}
