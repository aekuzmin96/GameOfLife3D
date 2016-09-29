import javafx.animation.ScaleTransition;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.util.Duration;

/**
 * Anton Kuzmin
 *
 * Class that represents each individual cell in the cube.
 * It has a boolean value to check if it is alive or dead,
 * the coordinates in the cube, and a Box to represent it
 * in the GUI.
 */

public class Cell
{
  private boolean alive;
  private int x, y, z;
  public Box cellBox;

  /**
   * Creates a new cell, sets the box dimensions to be 1 x 1 x 1,
   * the color to be blue, and the state (alive or dead)
   *
   * @param alive        state
   * @param x            x position
   * @param y            y position
   * @param z            z position
   * @param blueMaterial cell color
   */
  public Cell(boolean alive, int x, int y, int z, PhongMaterial blueMaterial)
  {
    this.alive = alive;
    this.x = x;
    this.y = y;
    this.z = z;
    cellBox = new Box(1, 1, 1);
    cellBox.setMaterial(blueMaterial);
    if (!alive)
    {
      cellBox.setVisible(false);
      setDead();
    }
  }

  /**
   * Sets the cell to alive state and plays an animation. It expands from
   * nothing into a cell that is 0.85 x 0.85 x 0.85. This is done in order
   * to see the cells on the inside, if the alive cells keep growing and
   * encompass the cube.
   */
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

  /**
   * Sets the cells to the dead state and plays an animation. It contracts from
   * the current cell size into nothing.
   */
  public void setDead()
  {
    ScaleTransition st = new ScaleTransition(Duration.millis(900), cellBox);
    st.setToX(0);
    st.setToY(0);
    st.setToZ(0);
    st.play();
    alive = false;
  }

  /**
   * Get the state of the cell
   *
   * @return true if alive and false if dead
   */
  public boolean getStatus()
  {
    return alive;
  }

  /**
   * Get the number of neighbors the cell has
   *
   * @param board current generation board
   * @return number of neighbors
   */
  public int getNeighbors(Cell[][][] board)
  {
    int neighbors = 0;

    for (int xx = x - 1; xx <= x + 1; xx++)
    {
      for (int yy = y - 1; yy <= y + 1; yy++)
      {
        for (int zz = z - 1; zz <= z + 1; zz++)
        {
          if (!((xx == x) && (yy == y) && (zz == z)))
          {
            if (xx > 0 && yy > 0 && zz > 0 && xx < 31 && yy < 31 && zz < 31)
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
