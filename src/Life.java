/**
 * Created by Anton on 9/21/2016.
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

import java.util.Random;

public class Life extends Application implements EventHandler<ActionEvent>
{

  private Cell[][][] currentState = new Cell[32][32][32];
  private Cell[][][] nextState = new Cell[32][32][32];
  final Group root = new Group();
  final Xform cube = new Xform();
  final Xform axisGroup = new Xform();
  final Xform cameraXform = new Xform();
  final Xform cameraXform2 = new Xform();
  final Xform cameraXform3 = new Xform();
  final PerspectiveCamera camera = new PerspectiveCamera(true);
  private static final double CAMERA_INITIAL_DISTANCE = -125;
  private static final double CAMERA_INITIAL_X_ANGLE = 20.0;
  private static final double CAMERA_INITIAL_Y_ANGLE = 320.0;
  private static final double CAMERA_NEAR_CLIP = 0.1;
  private static final double CAMERA_FAR_CLIP = 10000.0;
  private int r1, r2, r3, r4;
  
  private void buildCamera()
  {
    root.getChildren().add(cameraXform);
    cameraXform.getChildren().add(cameraXform2);
    cameraXform2.getChildren().add(cameraXform3);
    cameraXform3.getChildren().add(camera);
    cameraXform3.setRotateZ(180.0);
  
    camera.setNearClip(CAMERA_NEAR_CLIP);
    camera.setFarClip(CAMERA_FAR_CLIP);
    camera.setTranslateZ(CAMERA_INITIAL_DISTANCE);
    cameraXform.ry.setAngle(CAMERA_INITIAL_Y_ANGLE);
    cameraXform.rx.setAngle(CAMERA_INITIAL_X_ANGLE);
  }
  
  private void buildCube()
  {
    for(int x = 1; x < 31; x++)
    {
      for(int y = 1; y < 31; y++)
      {
        for(int z = 1; z < 31; z++)
        {
          currentState[x][y][z].cellBox.setTranslateX(x - 15);
          currentState[x][y][z].cellBox.setTranslateY(y - 15);
          currentState[x][y][z].cellBox.setTranslateZ(z - 15);
          cube.getChildren().add(currentState[x][y][z].cellBox);
        }
      }
    }
  }

  @Override
  public void start(Stage primaryStage)
  {
    BorderPane borderPane = new BorderPane();
  
    Scene scene = new Scene(borderPane, 850, 650, true);
    primaryStage.setTitle("Game of Life in 3D");
    scene.setFill(Color.BLUE);
    primaryStage.setScene(scene);
  
    SubScene subScene = new SubScene(root, 850, 600, true, SceneAntialiasing.BALANCED);
    subScene.setFill(Color.GRAY);
    subScene.setCamera(camera);
    
    HBox hbox = new HBox();
    setUp(hbox);
    borderPane.setTop(hbox);
    borderPane.setCenter(subScene);
    root.getChildren().add(cube);
    initializeGame();
    buildCamera();
    buildCube();
    primaryStage.show();
    new RotateLoop().start();
  }
  
  private void setUp(HBox hbox)
  {
    TextField r1Text = new TextField(" ");
    r1Text.setPrefSize(40, 5);
    TextField r2Text = new TextField(" ");
    r2Text.setPrefSize(40, 5);
    TextField r3Text = new TextField(" ");
    r3Text.setPrefSize(40, 5);
    TextField r4Text = new TextField(" ");
    r4Text.setPrefSize(40, 5);
  
    hbox.getChildren().addAll(new Label("R1:"), r1Text);
    hbox.getChildren().addAll(new Label("R2:"), r2Text);
    hbox.getChildren().addAll(new Label("R3:"), r3Text);
    hbox.getChildren().addAll(new Label("R4:"), r4Text);
  }

  class RotateLoop extends AnimationTimer
  {
    int frame = 0;
    @Override
    public void handle(long time)
    {
      frame ++;
      cube.ry.setAngle(cameraXform.ry.getAngle() - (0.5 * frame));
      cube.rx.setAngle(cameraXform.rx.getAngle() - (0.5 * frame));
    }
  }
  
  @Override
  public void handle(ActionEvent event)
  {

  }

  private void initializeGame()
  {
    for(int x = 1; x < 32; x++)
    {
      for(int y = 1; y < 32; y++)
      {
        for(int z = 1; z < 32; z++)
        {
          Random rand = new Random();
          int n = rand.nextInt(10) + 1;
          if(n % 4 == 0)
          {
            currentState[x][y][z] = new Cell(true, currentState, x, y, z);
          }
          else
            currentState[x][y][z] = new Cell(false, currentState, x, y, z);
        }
      }
    }
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
