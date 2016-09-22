/**
 * Created by Anton on 9/21/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;


public class Life extends Application implements EventHandler<ActionEvent>
{

  private Cell[][][] currentState = new Cell[31][31][31];
  private Cell[][][] nextState = new Cell[31][31][31];
  final Group root = new Group();

  @Override
  public void start(Stage primaryStage)
  {
    Scene scene = new Scene(root, 800, 600, true);
    primaryStage.setTitle("Game of Life in 3D");
    primaryStage.setScene(scene);

    initializeGame();
    primaryStage.show();
  }

  @Override
  public void handle(ActionEvent event)
  {

  }

  private void initializeGame()
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
