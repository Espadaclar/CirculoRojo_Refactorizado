import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import java.util.Random;
import java.util.ArrayList;
/**
 * @author franciscoJavier
 */
public class Ladrillo extends Rectangle{
    private Rectangle ladrillo; 
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    private int velocidadX;
    private int velocidadY;
    //ladrillos que van siendo eliminados.
    private int eliminados;

    public Ladrillo(double x, double y, double width, double height) {
        super();
        Random ale = new Random();
        width = ale.nextInt(60) +40;
        height = ale.nextInt(11) +9;

        Color colorLadrillo = new Color(ale.nextFloat(), ale.nextFloat(), ale.nextFloat(), ale.nextFloat());
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(colorLadrillo);
        this.setStroke(Color.BLACK);

        velocidadX = 1;
        velocidadY = 1;
        eliminados = 0;

    }

    public Ladrillo() {
        Random ale = new Random();
        Color colorLadrillo = new Color(ale.nextFloat(), ale.nextFloat(), ale.nextFloat(), ale.nextFloat());
        this.setTranslateX(122);
        this.setTranslateY(237);
        this.setWidth(100);
        this.setHeight(20);
        this.setFill(colorLadrillo);
        this.setStroke(Color.BLACK);
    }

    public void eliminarLadrillos(ArrayList<Ladrillo> ladrillos, Pelota pelot){

        for(int i = 0; i < ladrillos.size(); i ++ ){
            Shape c = Shape.intersect(ladrillos.get(i), pelot);

            //COORDENADAS LATERALES DE CADA BARRITA Y DE LA BOLA.
            double longitud_ladrillo = ladrillos.get(i).getWidth();
            double minimoDe_X_ladrillo =  ladrillos.get(i).getBoundsInParent().getMinX();
            double maximo_X_ladrillo =  minimoDe_X_ladrillo + longitud_ladrillo;
            double minimoDe_Y_ladrillo = ladrillos.get(i).getBoundsInParent().getMinY();
            double maximoDe_Y_ladrillo = ladrillos.get(i).getBoundsInParent().getMaxY();

            double maximoDe_X_pelota = pelot.getBoundsInParent().getMaxX()-0.5;
            double minimoDe_X_pelota =  pelot.getBoundsInParent().getMinX() -0.5;
            double maximoDe_Y_pelota = pelot.getBoundsInParent().getMaxY() ;
            double minimoDe_Y_pelota = pelot.getBoundsInParent().getMinY() ;

            if(c.getBoundsInParent().getWidth() != -1){
                ladrillos.get(i).setFill(Color.WHITESMOKE);
                ladrillos.get(i).setStroke(Color.WHITESMOKE);
                ladrillos.remove(i);

                if( (maximoDe_X_pelota ) == minimoDe_X_ladrillo && maximoDe_Y_pelota >= minimoDe_Y_ladrillo &&
                minimoDe_Y_pelota <= maximoDe_Y_ladrillo ){
                     pelot.setVelocidad_X_APelota(-velocidadX);                                 
                    eliminados ++;
                }
                else if( (maximoDe_X_pelota +1) == minimoDe_X_ladrillo && maximoDe_Y_pelota >= minimoDe_Y_ladrillo &&
                minimoDe_Y_pelota <= maximoDe_Y_ladrillo ){
                     pelot.setVelocidad_X_APelota(-velocidadX);                                  
                    eliminados ++;
                }
                else if( (minimoDe_X_pelota ) == (minimoDe_X_ladrillo + longitud_ladrillo)
                && maximoDe_Y_pelota >= minimoDe_Y_ladrillo &&
                minimoDe_Y_pelota <= maximoDe_Y_ladrillo){
                     pelot.setVelocidad_X_APelota(-velocidadX);
                    eliminados ++;
                }
                else{
                    pelot.setVelocidad_Y_APelota(-velocidadY) ;
                    eliminados ++;
                }
                //barritasEliminadas.setText("Barritas eliminadas; " +eliminados);
            }
        }
    }

    public int getLadrillosEliminados(){
        return eliminados;
    }
}  
