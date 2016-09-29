import javafx.scene.paint.PhongMaterial;
import java.util.Random;

/**
 * Anton Kuzmin
 *
 * This class holds all of the preset configuration for the cube.
 */

public class Presets
{
  /**
   * Resets the cube (current generation and next generation)
   * to the state in which all of the cells are dead.
   *
   * @param board        current generation board
   * @param boardTwo     next generation board
   * @param blueMaterial color to set the cells to
   */
  public void reset(Cell[][][] board, boolean[][][] boardTwo, PhongMaterial blueMaterial)
  {
    for (int x = 1; x < 32; x++)
    {
      for (int y = 1; y < 32; y++)
      {
        for (int z = 1; z < 32; z++)
        {
          board[x][y][z].setDead();
          board[x][y][z].cellBox.setMaterial(blueMaterial);
          board[x][y][z].cellBox.setVisible(false);
          boardTwo[x][y][z] = false;
        }
      }
    }
  }

  /**
   * Randomly place cells in the cube
   *
   * @param board current generation board
   */
  public void randomPreset(Cell[][][] board)
  {
    Random rand = new Random();

    for (int x = 1; x < 31; x++)
    {
      for (int y = 1; y < 31; y++)
      {
        for (int z = 1; z < 31; z++)
        {
          int n = rand.nextInt(100);
          if (n > 85)
          {
            board[x][y][z].setAlive();
          }
        }
      }
    }
  }

  /**
   * First preset for the cube. It is a cube that
   * has cells in every other index.
   *
   * @param board current generation board
   */
  public void preset1(Cell[][][] board)
  {
    for (int x = 1; x < 31; x++)
    {
      for (int y = 1; y < 31; y++)
      {
        for (int z = 1; z < 31; z++)
        {
          if ((x % 2 == 0) && (y % 2 == 0) && (z % 2 == 0))
          {
            board[x][y][z].setAlive();
          }
        }
      }
    }
  }

  /**
   * Second preset for the cube.
   *
   * @param board current generation board
   */
  public void preset2(Cell[][][] board)
  {
    for (int i = 1; i < 31; i++)
    {
      for (int j = 1; j < 31; j++)
      {
        board[i][j][j].setAlive();
        board[j][j][i].setAlive();
        board[j][i][j].setAlive();
      }
    }
  }

  /**
   * Third preset for the cube.
   *
   * @param board current generation board
   */
  public void preset3(Cell[][][] board)
  {
    for (int i = 3; i < 28; i += 5)
    {
      for (int j = 3; j < 28; j += 5)
      {
        for (int k = 3; k < 28; k += 5)
        {
          for (int l = 0; l < 4; l++)
          {
            board[j][i + l][k].setAlive();
            board[j + 1][i + l][k].setAlive();
            board[j + 2][i + l][k].setAlive();
            board[j + 3][i + l][k].setAlive();
          }
        }
      }
    }
  }

  /**
   * Fourth preset for the cube. After several generations
   * have passed, the remaining cells become oscillators.
   *
   * @param board current generation board
   */
  public void preset4(Cell[][][] board)
  {
    for (int i = 1; i < 31; i++)
    {
      for (int j = 1; j < 31; j++)
      {
        board[15][i][j].setAlive();
        board[i][15][j].setAlive();
        board[i][j][15].setAlive();
      }
    }
  }

  /**
   * Fifth preset for the cube.
   *
   * @param board current generation board
   */
  public void preset5(Cell[][][] board)
  {
    for (int i = 1; i < 31; i++)
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
}
