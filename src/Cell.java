/**
 * Created by Anton on 9/21/2016.
 */
public class Cell
{

  private boolean alive;
  private Cell[][][] board;
  private int x, y, z;

  public Cell(boolean alive, Cell[][][] board, int x, int y, int z)
  {
    this.alive = alive;
    this.board = board;
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public void setAlive(boolean state)
  {
    alive = state;
  }

  public boolean getAlive()
  {
    return alive;
  }

  public int getNeighbors()
  {
    int neighbors = 0;
    neighbors += getNeighborsHelper(x - 1, y, z);
    neighbors += getNeighborsHelper(x + 1, y, z);
    neighbors += getNeighborsHelper(x, y - 1, z);
    neighbors += getNeighborsHelper(x, y + 1, z);
    neighbors += getNeighborsHelper(x, y , z - 1);
    neighbors += getNeighborsHelper(x, y , z + 1);

    return neighbors;
  }

  private int getNeighborsHelper(int xAxis, int yAxis, int zAxis)
  {
    if(board[xAxis][yAxis][zAxis].getAlive())
    {
      return 1;
    }
    return 0;
  }
}
