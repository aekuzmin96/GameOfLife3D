import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

/**
 * Created by Anton on 9/21/2016.
 */
public class Cell
{

  private boolean alive;
  private int x, y, z;
  public Box cellBox;

  public Cell(boolean alive, int x, int y, int z)
  {
    final PhongMaterial material = new PhongMaterial();
    material.setDiffuseColor(Color.GREEN);
    this.alive = alive;
    this.x = x;
    this.y = y;
    this.z = z;
    cellBox = new Box(1, 1, 1);
    cellBox.setMaterial(material);
    if(!alive)
    {
      setDead();
    }
    else
    {
      setAlive();
    }
  }

  public void setAlive()
  {
    cellBox.setVisible(true);
    alive = true;
  }

  public void setDead()
  {
    final PhongMaterial redMaterial = new PhongMaterial();
    redMaterial.setDiffuseColor(Color.RED);
    cellBox.setMaterial(redMaterial);
    cellBox.setVisible(false);
    alive = false;
  }
  
  public boolean getAlive()
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
              if (board[xx][yy][zz].getAlive())
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
