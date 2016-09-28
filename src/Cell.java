import javafx.animation.ScaleTransition;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.util.Duration;

/**
 * Created by Anton on 9/21/2016.
 */
public class Cell
{

  private boolean alive;
  private int x, y, z;
  public Box cellBox;

  public Cell(boolean alive, int x, int y, int z, PhongMaterial blueMaterial)
  {
    this.alive = alive;
    this.x = x;
    this.y = y;
    this.z = z;
    cellBox = new Box(1, 1, 1);
    cellBox.setMaterial(blueMaterial);
    if(!alive)
    {
      cellBox.setVisible(false);
      setDead();
    }
  }

  public void setAlive()
  {
    cellBox.setVisible(true);
    ScaleTransition st = new ScaleTransition(Duration.millis(900), cellBox);
    st.setToX(0.85);
    st.setToY(0.85);
    st.setToZ(0.85);
    st.play();
    alive = true;
  }

  public void setDead()
  {
    ScaleTransition st = new ScaleTransition(Duration.millis(900), cellBox);
    st.setToX(0);
    st.setToY(0);
    st.setToZ(0);
    st.play();
    alive = false;
  }
  
  public boolean getStatus()
  {
    return alive;
  }

  public int getNeighbors(Cell[][][] board)
  {
    int neighbors = 0;

    for(int xx = x - 1; xx <= x + 1; xx++)
    {
      for(int yy = y - 1; yy <= y + 1; yy++)
      {
        for(int zz = z - 1; zz <= z + 1; zz++)
        {
          if(!((xx == x) && (yy == y) && (zz == z)))
          {
            if(xx > 0 && yy > 0 && zz > 0 && xx < 31 && yy < 31 && zz < 31)
            {
              if (board[xx][yy][zz].getStatus())
              {
                neighbors++;
              }
            }
          }
        }
      }
    }
    return neighbors;
  }
}
