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
    for(int i = 1; i < 32; i++)
    {
      board[i][15][15].setAlive();
      board[15][i][15].setAlive();
      board[15][15][i].setAlive();
    }
  }

  public void preset2(Cell[][][] board)
  {
    for(int i = 1; i < 32; i++)
    {
      for(int j = 1; j < 32; j++)
      {
        board[i][j][j].setAlive();
        board[j][j][i].setAlive();
        board[j][i][j].setAlive();
      }
    }
  }

  public void preset3(Cell[][][] board)
  {
    for(int i = 1; i < 32; i++)
    {
      board[i][1][1].setAlive();
      board[1][i][1].setAlive();
      board[1][1][i].setAlive();
      board[i][30][30].setAlive();
      board[30][i][30].setAlive();
      board[30][30][i].setAlive();
      board[1][i][i].setAlive();
      board[i][1][i].setAlive();
      board[i][i][1].setAlive();
      board[30][i][i].setAlive();
      board[i][30][i].setAlive();
      board[i][i][30].setAlive();
    }
  }

  public void preset4(Cell[][][] board)
  {
    for(int x = 1; x < 29; x+=10)
    {
      for (int y = 1; y < 29; y+=10)
      {
        for (int z = 1; z < 29; z+=10)
        {
          for(int i = 0; i < 5; i++)
          {
            board[x ][y + i][z + i].setAlive();
            board[x + i][y ][z + i].setAlive();
            board[x + i][y + i][z].setAlive();
          }
        }
      }
    }
  }

  public void preset5(Cell[][][] board)
  {

  }
}
