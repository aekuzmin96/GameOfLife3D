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

    for(int xx = x - 1; xx <= x + 1; x++)
    {
      for(int yy = y - 1; yy <= y + 1; y++)
      {
        for(int zz = z - 1; zz <= z + 1; z++)
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
