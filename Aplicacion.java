
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;
import javafx.scene.control.Label;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;
import javafx.scene.shape.Shape;
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
        ArrayList<Ladrillo> ladrillos = new ArrayList<>();

        int ANCHO_ESCENA = 800;
        int ALTO_ESCENA = 700;
        int NUM_LADRILLO_EN_ESCENA = 60;
        int RADIO = 10;

        int LARGO_LADRILLO = 100;
        int ALTO_LADRILLO = 20;
        int LARGO_LADRILLO_ALEATORIO = ale.nextInt(60) +40;
        int ALTO_LADRILLO_ALEATORIO = ale.nextInt(11) +15;

        int LARGO_RAQUETA = 80;
        int ALTO_RAQUETA = 6;

        Group root = new Group();
        Scene escene = new Scene(root, ANCHO_ESCENA, ALTO_ESCENA, Color.WHITESMOKE);
        ventana.setScene(escene);

        // SE CREAN VARIOS OBJETOS LADRILLO, QUE NO INTERSECCIONAN, PARA MOSTRAR EN LA ESCENA.
        Ladrillo ladrillo2 = new Ladrillo( (ale.nextInt( ( ANCHO_ESCENA -(LARGO_LADRILLO_ALEATORIO *2) ) + LARGO_LADRILLO_ALEATORIO) ),
                ale.nextInt(ALTO_ESCENA /2) + ALTO_LADRILLO_ALEATORIO,
                (LARGO_LADRILLO_ALEATORIO), (ALTO_LADRILLO_ALEATORIO));
        ladrillos.add(ladrillo2);
        root.getChildren().add(ladrillo2);
        int val = 0;
        while(val < ( NUM_LADRILLO_EN_ESCENA -1 )){
            boolean barritaValida = true;
            boolean add = false;
            while(barritaValida == true && add == false){
                Ladrillo ladrillo = new Ladrillo( (ale.nextInt( ( ANCHO_ESCENA -(LARGO_LADRILLO_ALEATORIO *2) ) + LARGO_LADRILLO_ALEATORIO) ),
                        ale.nextInt(ALTO_ESCENA /2) + ALTO_LADRILLO_ALEATORIO,
                        (LARGO_LADRILLO_ALEATORIO), (ALTO_LADRILLO_ALEATORIO));
                for(int i = 0; i <ladrillos.size(); i ++){
                    Shape c = Shape.intersect(ladrillos.get(i), ladrillo);
                    if(c.getBoundsInParent().getWidth() != -1){
                        barritaValida = false;
                    }
                }
                if(barritaValida == true){
                    ladrillos.add(ladrillo);
                    root.getChildren().add(ladrillo);; 
                    add = true;
                }
            }
            val ++;
        }
        //SE CREA LA RAQUETA
        Raqueta raqueta = new Raqueta( (ANCHO_ESCENA /2), (ALTO_ESCENA - (ALTO_RAQUETA + 20)), LARGO_RAQUETA, ALTO_RAQUETA, ANCHO_ESCENA);
        root.getChildren().add(raqueta);
        // SE CREA LA PELOTA
        Pelota pelota = new Pelota(ANCHO_ESCENA/2, ALTO_ESCENA/2, RADIO);
        root.getChildren().add(pelota);    

        //////////////////////////////////////////////////////////////

        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.setAutoReverse (true); 

        KeyFrame keyframe = new KeyFrame(Duration.seconds(0.01), event -> {

                    // PELOTA-
                    double minimoXRaqueta = raqueta.getBoundsInParent().getMinX();
                    double maximoXRaqueta = raqueta.getBoundsInParent().getMaxX();
                    double minimoYRaqueta = raqueta.getBoundsInParent().getMinY();
                    pelota.mover(ANCHO_ESCENA, ALTO_ESCENA, minimoXRaqueta, maximoXRaqueta, minimoYRaqueta);
                    if(pelota.getVelocidadPelota() == 0){
                        Label label1 = new Label();
                        label1.setText(" -- GANE  OVER -- ");        
                        label1.setLayoutX( (ANCHO_ESCENA /2) -90);
                        label1.setLayoutY(ALTO_ESCENA /2);
                        label1.setTextFill(Color.RED);
                        label1.setStyle("-fx-font-size: 2em;");
                        root.getChildren().add(label1);
                    }

                    // RAQUETA-
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

