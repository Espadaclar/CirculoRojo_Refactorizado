
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

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage ventana){
        Random ale = new Random();

        int  ANCHO_ESCENA = 800;
        int ALTO_ESCENA = 700;
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

        Pelota pelota = new Pelota(ANCHO_ESCENA/2, ALTO_ESCENA/2, RADIO);
        root.getChildren().add(pelota);

        //
        Ladrillo ladrillo = new Ladrillo( (ale.nextInt(ANCHO_ESCENA - (LARGO_LADRILLO *2)) + LARGO_LADRILLO),
            (ale.nextInt(ALTO_ESCENA/2)  + ALTO_LADRILLO_ALEATORIO),
            (LARGO_LADRILLO_ALEATORIO), (ALTO_LADRILLO_ALEATORIO));
        root.getChildren().add(ladrillo);

        //
        Raqueta raqueta = new Raqueta( (ANCHO_ESCENA /2), (ALTO_ESCENA - (ALTO_RAQUETA + 20)), LARGO_RAQUETA, ALTO_RAQUETA, ANCHO_ESCENA);
        root.getChildren().add(raqueta);

        //////////////////////////////////////////////////////////////

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse (true); 

        KeyFrame keyframe = new KeyFrame(Duration.seconds(0.001), event -> {
                    raqueta.mover();
                });

        timeline.getKeyFrames().add(keyframe);
        timeline.play();
        
        //MUEVE RAQUETA CON LAS TECLAS.
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
        
        
        //         Rectangle rectangle = new Rectangle (0, 0, 100, 50);
        //        root.getChildren().add(rectangle); 
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

