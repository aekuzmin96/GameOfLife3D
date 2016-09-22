/**
 * Created by Anton on 9/21/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.TextField;


public class Life extends Application implements EventHandler<ActionEvent>
{

  private Cell[][][] currentState = new Cell[31][31][31];
  private Cell[][][] nextState = new Cell[31][31][31];
  final Group root = new Group();
  private int r1;
  private int r2;
  private int r3;
  private int r4;

  @Override
  public void start(Stage primaryStage)
  {
    Scene scene = new Scene(root, 1000, 750, true);
    primaryStage.setTitle("Game of Life in 3D");
    primaryStage.setScene(scene);

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.TOP_RIGHT);
    grid.setHgap(5);
    grid.setVgap(5);

    TextField r1Text = new TextField("Enter r1 value");
    TextField r2Text = new TextField("Enter r2 value");
    TextField r3Text = new TextField("Enter r3 value");
    TextField r4Text = new TextField("Enter r4 value");


    grid.add(new Label("R1 Value: "), 1, 1);
    grid.add(new Label("R2 Value: "), 1, 5);
    grid.add(new Label("R3 Value: "), 1, 10);
    grid.add(new Label("R4 Value: "), 1, 15);
    grid.add(r1Text, 1, 3);


    root.getChildren().add(grid);
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
