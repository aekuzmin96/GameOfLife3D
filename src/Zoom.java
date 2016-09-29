import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

/**
 * Anton Kuzmin
 *
 * This class is used as the background scene for the GUI. It has
 * a keyboard listener to zoom in and out
 * C =  zoom in
 * X = zoom out
 */
public class Zoom extends Scene implements EventHandler<KeyEvent>
{
  private double cameraDistance;

  public Zoom(BorderPane bp, double cameraDistance)
  {
    super(bp, 850, 650);
    this.cameraDistance = cameraDistance;
    this.setOnKeyPressed(this);
  }

  /**
   * Used to zoom in and out on the cube
   * C = zoom in
   * X = zoom out
   *
   * @param e
   */
  @Override
  public void handle(KeyEvent e)
  {
    if (e.getCode() == KeyCode.X)
    {
      cameraDistance -= 1;
    }
    if (e.getCode() == KeyCode.C)
    {
      cameraDistance += 1;
    }
  }

  /**
   * Used to return the new camera distance after zooming
   *
   * @return new camera distance
   */
  public double getCameraDistance()
  {
    return cameraDistance;
  }
}
