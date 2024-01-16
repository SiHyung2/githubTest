package homework_2nd;

import javax.swing.*;
import java.awt.*;

public class GridLayoutWithPanels {

    public static void main(String[] args) {
        JFrame frame = new JFrame("GridLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2x2 그리드 레이아웃 생성
        GridLayout gridLayout = new GridLayout(2, 2);
        frame.setLayout(gridLayout);

        // 각 셀을 JPanel로 구성하여 합치는 효과
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        frame.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.GREEN);
        frame.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.BLUE);
        frame.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.YELLOW);
        frame.add(panel4);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

