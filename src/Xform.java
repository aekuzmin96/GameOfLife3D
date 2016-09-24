/*
 * Anton Kuzmin
 *
 *
 */


import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

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
  
  public Xform()
  {
    super();
    getTransforms().addAll(t, rz, ry, rx, s);
  }
  
  public void setRotateZ(double z)
  {
    rz.setAngle(z);
  }
}