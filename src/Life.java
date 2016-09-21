/**
 * Created by Anton on 9/21/2016.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Life extends Application
{

  private Cell[][][] currentState = new Cell[30][30][30];
  private Cell[][][] nextState = new Cell[30][30][30];

  @Override
  public void start(Stage primaryStage)
  {
    StackPane root = new StackPane();
    primaryStage.setTitle("Game of Life in 3D");
    primaryStage.setScene(new Scene(root, 800, 600));

    primaryStage.show();
  }

  private void game()
  {
    for(int x = 0; x < 30; x++)
    {
      for(int y = 0; y < 30; y++)
      {
        for(int z = 0; z < 30; z++)
        {
          currentState[x][y][z] = new Cell(true, currentState);
        }
      }
    }

  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
