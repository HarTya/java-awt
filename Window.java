import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class Window {
  public static void main(String[] args) {
    new MyWindow();
  }
}

class MyWindow extends Frame {
  private int closeCounter = 0;
  private Random random = new Random();

  public MyWindow() {
    super();
    setSize(800, 600);
    setLocation(100, 200);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent event) {
        handleWindowClosing();
      }

      public void windowIconified(WindowEvent event) {
        setBackground(generateRandomColor());
        System.out.println("Window background color changed");
      }
    });
    setVisible(true);
  }

  private void handleWindowClosing() {
    closeCounter++;
    System.out.println("Window close counter value equals " + closeCounter);

    if (closeCounter == 3) {
      System.out.println("Closing the window!");
      System.exit(0);
    }
  }

  private Color generateRandomColor() {
    int red = random.nextInt(256);
    int green = random.nextInt(256);
    int blue = random.nextInt(256);

    return new Color(red, green, blue);
  }
}
