import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;

/**
 * Created by Anton on 9/21/2016.
 */
public class Cell
{

  private boolean alive;
  private Cell[][][] board;
  private int x, y, z;
  public Box cellBox;

  public Cell(boolean alive, Cell[][][] board, int x, int y, int z)
  {
    final PhongMaterial redMaterial = new PhongMaterial();
    redMaterial.setDiffuseColor(Color.RED);
    this.alive = alive;
    this.board = board;
    this.x = x;
    this.y = y;
    this.z = z;
    cellBox = new Box(1, 1, 1);
    cellBox.setMaterial(redMaterial);
    if(!alive)
    {
      cellBox.setVisible(false);
    }
  }

  public void setAlive(boolean state)
  {
    alive = state;
  }

  public boolean getAlive()
  {
    if(alive)
    {
      cellBox.setVisible(true);
    }
    else
    {
      cellBox.setVisible(false);
    }
    return alive;
  }

  public int getNeighbors()
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
            if(board[xx][yy][zz].getAlive())
            {
              neighbors++;
            }
          }
        }
      }
    }

    return neighbors;
  }
}
