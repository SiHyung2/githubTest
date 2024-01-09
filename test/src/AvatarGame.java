import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AvatarGame extends JFrame {
    private JLabel avatarLabel;
    private JLabel monsterLabel;

    private int avatarX = 0;
    private int avatarY = 0;

    private int monsterX = 0;
    private int monsterY = 0;

    public AvatarGame() {
        setTitle("Avatar Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 아바타 레이블 초기화
        avatarLabel = new JLabel("@");
        avatarLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        avatarLabel.setBounds(avatarX, avatarY, 20, 20);

        // 괴물 레이블 초기화
        monsterLabel = new JLabel("M");
        monsterLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        monsterLabel.setBounds(monsterX, monsterY, 20, 20);

        // 패널 초기화 및 레이아웃 설정
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.add(avatarLabel);
        panel.add(monsterLabel);

        // 키 이벤트 리스너 등록
        addKeyListener(new KeyHandler());

        // 포커스 설정
        setFocusable(true);
        getContentPane().add(panel);

        // 괴물 이동 스레드 시작
        new Thread(this::moveMonster).start();
    }

    private class KeyHandler implements KeyListener {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            // 아바타 이동
            if (key == KeyEvent.VK_UP && avatarY > 0) {
                avatarY -= 10;
            } else if (key == KeyEvent.VK_DOWN && avatarY < getHeight() - 30) {
                avatarY += 10;
            } else if (key == KeyEvent.VK_LEFT && avatarX > 0) {
                avatarX -= 10;
            } else if (key == KeyEvent.VK_RIGHT && avatarX < getWidth() - 30) {
                avatarX += 10;
            }

            // 아바타 위치 업데이트
            avatarLabel.setBounds(avatarX, avatarY, 20, 20);
        }

        @Override
        public void keyTyped(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

    private void moveMonster() {
        while (true) {
            // 괴물이 아바타를 추적하도록 구현 (간단한 예시)
            if (monsterX < avatarX) {
                monsterX += 5;
            } else if (monsterX > avatarX) {
                monsterX -= 5;
            }

            if (monsterY < avatarY) {
                monsterY += 5;
            } else if (monsterY > avatarY) {
                monsterY -= 5;
            }

            // 괴물 위치 업데이트
            monsterLabel.setBounds(monsterX, monsterY, 20, 20);

            try {
                // 200ms 간격으로 괴물 이동
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            AvatarGame game = new AvatarGame();
            game.setVisible(true);
        });
    }
}
