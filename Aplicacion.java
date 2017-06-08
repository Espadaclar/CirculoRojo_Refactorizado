
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
/**
 * franciscoJavier
 */
public class Aplicacion extends Application
{
    // instance variables - replace the example below with your own
    private Pelota pelota;
    private Ladrillo ladrillo;
    private Raqueta raqueta;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage ventana){
        Random ale = new Random();
        Color colorLadrillo = new Color(ale.nextFloat(), ale.nextFloat(), ale.nextFloat(), ale.nextFloat());
        Color colorPelota = new Color(ale.nextFloat(), ale.nextFloat(), ale.nextFloat(), ale.nextFloat());

        Pelota pelota;
        Ladrillo ladrillo;
        Raqueta raqueta;

        int  ANCHO_ESCENA = 500;
        int ALTO_ESCENA = 500;
        int RADIO = 10;

        int LARGO_LADRILLO = 100;
        int ALTO_LADRILLO = 20;
        int LARGO_LADRILLO_ALEATORIO = ale.nextInt(60) +40;
        int ALTO_LADRILLO_ALEATORIO = ale.nextInt(11) +9;

        int LARGO_RAQUETA = 80;
        int ALTO_RAQUETA = 6;

        Group root = new Group();
        Scene escene = new Scene(root, ANCHO_ESCENA, ALTO_ESCENA, Color.WHITESMOKE);
        ventana.setScene(escene);

        pelota = new Pelota();
        pelota.setCenterX(ANCHO_ESCENA/2);
        pelota.setCenterY( ALTO_ESCENA/2);
        pelota.setRadius(RADIO);
        pelota.setFill(colorPelota);
        pelota.setStroke(Color.RED);
        root.getChildren().add(pelota);

        ladrillo = new Ladrillo();
        ladrillo.setLayoutX(ale.nextInt(ANCHO_ESCENA - (LARGO_LADRILLO *2)) + LARGO_LADRILLO);
        ladrillo.setLayoutY(ale.nextInt(ALTO_ESCENA/2)  + ALTO_LADRILLO_ALEATORIO);
        ladrillo.setWidth(LARGO_LADRILLO_ALEATORIO);
        ladrillo.setHeight(ALTO_LADRILLO_ALEATORIO);
        ladrillo.setFill(colorLadrillo);
        ladrillo.setStroke(Color.BLACK);
        root.getChildren().add(ladrillo);

        raqueta = new Raqueta( (ANCHO_ESCENA /2), (ALTO_ESCENA - (ALTO_RAQUETA + 20)), LARGO_RAQUETA, ALTO_RAQUETA, ANCHO_ESCENA);
        //         raqueta.setLayoutX(ANCHO_ESCENA /2);
        //         raqueta.setLayoutY(ALTO_ESCENA - (ALTO_RAQUETA + 20));
        //         raqueta.setWidth(LARGO_RAQUETA);
        //         raqueta.setHeight(ALTO_RAQUETA);
        raqueta.setFill(Color.BLUE);
        root.getChildren().add(raqueta);

        //////////////////////////////////////////////////////////////

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse (true); 

        Rectangle rectangle = new Rectangle (0, 0, 100, 50);
        root.getChildren().add(rectangle); 

        KeyFrame keyframe = new KeyFrame(Duration.seconds(0.001), event -> {
                    raqueta.mover();
                });

        timeline.getKeyFrames().add(keyframe);
        timeline.play();

        escene.setOnKeyPressed(event -> {
                if (event.getCode() == KeyCode.RIGHT && 
                raqueta.getBoundsInParent().getMaxX() != escene.getWidth()) {
                    raqueta.cambiarDireccionDerecha();
                }
                else if (event.getCode() == KeyCode.LEFT && 
                raqueta.getBoundsInParent().getMinX() != 0) {
                    raqueta.cambiarDireccionIzquierda();
                }
            });

        ventana.show();

        //         KeyValue xValue = new KeyValue (rectangle.xProperty (), 200);
        //         KeyValue yValue = new KeyValue (rectangle.yProperty (), 200);
        //         KeyFrame   keyFrame = new KeyFrame (Duration.millis (2000), xValue, yValue);
        //         KeyValue xValue = new KeyValue (rectangle.opacityProperty (), 0);
        //         KeyFrame   keyFrame = new KeyFrame (Duration.millis (2000), xValue);
        //         timeline.getKeyFrames().add(keyFrame);
        //         timeline.play();
        ////////////////////////////////////////////////////////////

    }

}

