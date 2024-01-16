package homework_2nd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIExample extends JFrame {
	private static final long serialVersionUID = -8748576165500607924L;

	public GUIExample() {
        // JFrame 설정
        setTitle("GUI Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(3, 1)); // 3행 1열의 그리드 레이아웃 설정

        // 첫 번째 줄: 라벨, 텍스트 필드, 버튼
        JPanel firstPanel = new JPanel(new FlowLayout());
        JLabel label = new JLabel("Label:");
        JTextField textField = new JTextField(10);
        JButton button = new JButton("Submit");

        firstPanel.add(label);
        firstPanel.add(textField);
        firstPanel.add(button);

        // 두 번째 줄: 버튼
        JPanel secondPanel = new JPanel(new FlowLayout());
        JButton secondButton = new JButton("Second Button");
        secondPanel.add(secondButton);

        // 세 번째 줄: 하얀 사각형
        JPanel thirdPanel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -7112110794668966440L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        // 이벤트 처리: 두 번째 버튼 클릭 시 콘솔에 메시지 출력
        secondButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Second Button Clicked!");
            }
        });

        // 프레임에 패널 추가
        add(firstPanel);
        add(secondPanel);
        add(thirdPanel);

        // 프레임 표시
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUIExample();
            }
        });
    }
}


