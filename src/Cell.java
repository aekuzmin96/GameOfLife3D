/**
 * Created by Anton on 9/21/2016.
 */
public class Cell
{

  private boolean alive;
  private Cell[][][] board;

  public Cell(boolean alive, Cell[][][] board)
  {
    this.alive = alive;
    this.board = board;
  }

  public void setAlive(boolean state)
  {
    alive = state;
  }

  public boolean getAlive()
  {
    return alive;
  }

  public int getNumberOfNeighbors()
  {
    int neighbors = 0;

    return neighbors;
  }
}
