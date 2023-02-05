import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pong extends JPanel {
  private int ballX = 50, ballY = 50, ballSpeedX = 2, ballSpeedY = 2;
  private int player1Y = 250, player2Y = 250, playerSpeed = 3;
  private int player1Score = 0, player2Score = 0;
  private final int PADDLE_HEIGHT = 100, PADDLE_WIDTH = 10;

  public Pong() {
    setPreferredSize(new Dimension(600, 400));
    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
          player2Y -= playerSpeed;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
          player2Y += playerSpeed;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
          player1Y -= playerSpeed;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
          player1Y += playerSpeed;
        }
      }
    });
    setFocusable(true);
    requestFocus();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, 600, 400);
    g.setColor(Color.WHITE);
    g.fillOval(ballX, ballY, 20, 20);
    g.fillRect(10, player1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
    g.fillRect(570, player2Y, PADDLE_WIDTH, PADDLE_HEIGHT);
    g.setFont(new Font("Arial", Font.BOLD, 20));
    g.drawString(String.valueOf(player1Score), 200, 20);
    g.drawString(String.valueOf(player2Score), 400, 20);
  }

  public void moveBall() {
    ballX += ballSpeedX;
    ballY += ballSpeedY;
    if (ballX < PADDLE_WIDTH + 20) {
      if (ballY >= player1Y && ballY <= player1Y + PADDLE_HEIGHT) {
        ballSpeedX = -ballSpeedX;
      } else {
        player2Score++;
        ballX = 300;
        ballY = 200;
      }
    }
    if (ballX > 570) {
      if (ballY >= player2Y && ballY <= player2Y + PADDLE_HEIGHT) {
        ballSpeedX = -ballSpeedX;
      } else {
        player1Score++;
        ballX = 300;
        ballY = 200;
      }
    }
    if (ballY < 0 || ballY > 380) {
      ballSpeedY = -ballSpeedY;
    }
  }

  public static void main (String[] args) throws InterruptedException {
    JFrame frame = new JFrame("Pong");
    Pong pong = new Pong();
    frame.add(pong);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    while (true) {
      pong.moveBall();
      pong.repaint();
      Thread.sleep(10);
    }
  }
}
