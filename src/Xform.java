import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

/**
 * Anton Kuzmin
 *
 * Xform class that is used in grouping all of the cells into
 * one object. This class was taken from the Oracle example:
 * https://docs.oracle.com/javase/8/javafx/graphics-tutorial/sampleapp3d.htm
 */

public class Xform extends Group
{

  private Translate t = new Translate();
  public Rotate rx = new Rotate();
  public Rotate ry = new Rotate();
  public Rotate rz = new Rotate();
  private Scale s = new Scale();

  {
    rx.setAxis(Rotate.X_AXIS);
  }

  {
    ry.setAxis(Rotate.Y_AXIS);
  }

  {
    rz.setAxis(Rotate.Z_AXIS);
  }

  /**
   * Constructor for the Xform class
   */
  public Xform()
  {
    super();
    getTransforms().addAll(t, rz, ry, rx, s);
  }

  /**
   * Used to rotate the cube while running the game
   *
   * @param z angle of rotation
   */
  public void setRotateZ(double z)
  {
    rz.setAngle(z);
  }
}