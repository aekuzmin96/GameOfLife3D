/**
 * Created by Anton on 9/21/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Life extends Application implements EventHandler<ActionEvent>
{

  private Cell[][][] currentState = new Cell[31][31][31];
  private Cell[][][] nextState = new Cell[31][31][31];

  @Override
  public void start(Stage primaryStage)
  {
    StackPane root = new StackPane();
    primaryStage.setTitle("Game of Life in 3D");
    primaryStage.setScene(new Scene(root, 800, 600));

    primaryStage.show();
  }

  @Override
  public void handle(ActionEvent event)
  {

  }

  private void game()
  {
    for(int x = 1; x < 31; x++)
    {
      for(int y = 1; y < 31; y++)
      {
        for(int z = 1; z < 31; z++)
        {
          currentState[x][y][z] = new Cell(true, currentState, x, y, z);
        }
      }
    }
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
