/**
 * Created by Anton on 9/21/2016.
 */

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Random;

public class Life extends Application implements EventHandler<ActionEvent>
{

  private Cell[][][] currentState = new Cell[32][32][32];
  private Cell[][][] nextState = new Cell[32][32][32];
  final Group root = new Group();
  final Xform cube = new Xform();
  final Xform cameraXform = new Xform();
  final Xform cameraXform2 = new Xform();
  final Xform cameraXform3 = new Xform();
  final PerspectiveCamera camera = new PerspectiveCamera(true);
  private Button pauseButton;
  private Button randomButton;
  private Button preset1;
  private Button preset2;
  private Button preset3;
  private Button preset4;
  private Button preset5;

  private static final double CAMERA_INITIAL_DISTANCE = -125;
  private static final double CAMERA_INITIAL_X_ANGLE = 20.0;
  private static final double CAMERA_INITIAL_Y_ANGLE = 320.0;
  private static final double CAMERA_NEAR_CLIP = 0.1;
  private static final double CAMERA_FAR_CLIP = 10000.0;
  private int r1, r2, r3, r4;
  private RotateLoop loop;
  
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
    borderPane.setTop(hbox);
    borderPane.setCenter(subScene);
    root.getChildren().add(cube);
    buildCamera();
    initializeGame();
    buildCube();
    setUpHBox(hbox);
    primaryStage.show();
    loop = new RotateLoop();
    loop.start();
  }
  
  private void setUpHBox(HBox hbox)
  {
    TextField r1Text = new TextField(r1 + "");
    r1Text.setPrefSize(40, 5);
    TextField r2Text = new TextField(r2 + "");
    r2Text.setPrefSize(40, 5);
    TextField r3Text = new TextField(r3 + "");
    r3Text.setPrefSize(40, 5);
    TextField r4Text = new TextField(r4 + "");
    r4Text.setPrefSize(40, 5);

    pauseButton = new Button("Pause");
    pauseButton.setOnAction(this);
    randomButton = new Button("Random");
    randomButton.setOnAction(this);
    preset1 = new Button("Preset 1");
    preset1.setOnAction(this);
    preset2 = new Button("Preset 2");
    preset2.setOnAction(this);
    preset3 = new Button("Preset 3");
    preset3.setOnAction(this);
    preset4 = new Button("Preset 4");
    preset4.setOnAction(this);
    preset5 = new Button("Preset 5");
    preset5.setOnAction(this);

    hbox.getChildren().addAll(new Label("R1:"), r1Text);
    hbox.getChildren().addAll(new Label("R2:"), r2Text);
    hbox.getChildren().addAll(new Label("R3:"), r3Text);
    hbox.getChildren().addAll(new Label("R4:"), r4Text);
    hbox.setPadding(new Insets(10));
    hbox.setSpacing(10);
    hbox.getChildren().addAll(pauseButton, randomButton,
            preset1, preset2, preset3, preset4, preset5);
  }

  @Override
  public void handle(ActionEvent event)
  {
    Object source = event.getSource();
    if(source == pauseButton && pauseButton.getText().equals("Pause"))
    {
      pauseButton.setText("Start");
      loop.stop();
    }
    else if(source == pauseButton && pauseButton.getText().equals("Start"))
    {
      pauseButton.setText("Pause");
      loop.start();
    }
    if(source == randomButton)
    {
      randomPreset();
    }
    if(source == preset1)
    {
      System.out.println("Preset 1");
    }
    if(source == preset2)
    {
      System.out.println("Preset 2");
    }
    if(source == preset3)
    {
      System.out.println("Preset 3");
    }
    if(source == preset4)
    {
      System.out.println("Preset 4");
    }
    if(source == preset5)
    {
      System.out.println("Preset 5");
    }
  }

  class RotateLoop extends AnimationTimer
  {
    int frame = 0;
    long updateTime = 0;
    int lastFrame = 0;
    @Override
    public void handle(long time)
    {
      frame ++;
      cube.ry.setAngle(cameraXform.ry.getAngle() - (0.5 * frame));
      cube.rx.setAngle(cameraXform.rx.getAngle() - (0.5 * frame));
      if(time - updateTime >= 1_000_000_000)
      {
        System.out.println(frame - lastFrame);
        //updateGame();
        updateTime = time;
        lastFrame = frame;
      }
    }
  }

  private void updateGame()
  {
    for(int x = 1; x < 32; x++)
    {
      for (int y = 1; y < 32; y++)
      {
        for (int z = 1; z < 32; z++)
        {
          int neighbors = currentState[x][y][z].getNeighbors(currentState);
          if((!currentState[x][y][z].getAlive()) && neighbors >= r1 && neighbors <= r2)
          {
            nextState[x][y][z].cellBox.setVisible(true);
          }
          if(currentState[x][y][z].getAlive() && (neighbors > r3 || neighbors < r4))
          {
            nextState[x][y][z].cellBox.setVisible(false);
          }
        }
      }
    }

    nextState = currentState;
    /*for(int x = 1; x < 32; x++)
    {
      for (int y = 1; y < 32; y++)
      {
        for (int z = 1; z < 32; z++)
        {
          nextState[x][y][z] = currentState[x][y][z];
        }
      }
    }*/
  }

  private void randomPreset()
  {
    Random rand = new Random();

    for(int x = 1; x < 32; x++)
    {
      for(int y = 1; y < 32; y++)
      {
        for(int z = 1; z < 32; z++)
        {
          int n = rand.nextInt(100);
          if(n > 90)
          {
            System.out.println("random preset");
            currentState[x][y][z].setAlive();
          }
          else
            currentState[x][y][z].setDead();
        }
      }
    }
  }

  private void initializeGame()
  {
    r1 = 8;
    r2 = 16;
    r3 = 18;
    r4 = 6;
  
    Random rand = new Random();
    
    for(int x = 1; x < 32; x++)
    {
      for(int y = 1; y < 32; y++)
      {
        for(int z = 1; z < 32; z++)
        {
          int n = rand.nextInt(100);
          if(n > 90)
          {
            currentState[x][y][z] = new Cell(true, x, y, z);
            nextState[x][y][z] = new Cell(true, x, y, z);
          }
          else
            currentState[x][y][z] = new Cell(false, x, y, z);
            nextState[x][y][z] = new Cell(true, x, y, z);
        }
      }
    }
  }

  public static void main(String[] args)
  {
    launch(args);
  }
}
