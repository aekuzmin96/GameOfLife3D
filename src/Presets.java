import java.util.Random;

public class Presets
{
  public void reset(Cell[][][] board)
  {
    for(int x = 1; x < 32; x++)
    {
      for (int y = 1; y < 32; y++)
      {
        for (int z = 1; z < 32; z++)
        {
          board[x][y][z].setDead();
        }
      }
    }
  }

  public void randomPreset(Cell[][][] board)
  {
    Random rand = new Random();

    for(int x = 1; x < 32; x++)
    {
      for(int y = 1; y < 32; y++)
      {
        for(int z = 1; z < 32; z++)
        {
          int n = rand.nextInt(100);
          if(n > 70)
          {
            board[x][y][z].setAlive();
          }
        }
      }
    }
  }

  public void preset1(Cell[][][] board)
  {
    for(int x = 5; x < 25; x++)
    {
      for (int y = 5; y < 25; y++)
      {
        for (int z = 14; z < 16; z++)
        {
          board[x][y][z].setAlive();
        }
      }
    }
  }

  public void preset2(Cell[][][] board)
  {
    for(int i = 1; i < 30; i++)
    {
      for(int j = 1; j < 30; j++)
      {
        board[i][j][j].setAlive();
        board[j][j][i].setAlive();
        board[j][i][j].setAlive();
      }
    }
  }

  public void preset3(Cell[][][] board)
  {

  }

  public void preset4(Cell[][][] board)
  {

  }

  public void preset5(Cell[][][] board)
  {

  }
}
