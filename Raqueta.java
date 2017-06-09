import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
/**
 * @author franciscoJavier
 */
public class Raqueta extends Rectangle{
    private double x;
    private double y;
    private double width;
    private double height;
    private int direccion; 
    private int limiteEnX;
    private int velocidad;
    
    public Raqueta(double x, double y, double width, double height, int limiteEnX) {
        super();
        this.setWidth(width);
        this.setHeight(height);
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.setFill(Color.BLUE);
        this.limiteEnX = limiteEnX;
        direccion = 1;
       //this.limiteEnX = limiteEnX;
        velocidad = 1;
    }

    public Raqueta(int limiteEnX){
        super();
        this.setWidth(50);
        this.setHeight(5);
        this.setTranslateX(225);
        this.setTranslateY(480);
        this.setFill(Color.BLUE);
        direccion = 1;
        this.limiteEnX = limiteEnX;
        velocidad = 1;
    }
    
    public void cambiarDireccionDerecha(){
        if(getBoundsInParent().getMaxX() != limiteEnX){
            velocidad = 1;
        }
    }
    
    public void cambiarDireccionIzquierda(){
        if(getBoundsInParent().getMinX() != 0 ){
            velocidad =  -1;
        }
    }
    
    public void mover(){
        setTranslateX(getTranslateX() + velocidad);
        if(getBoundsInParent().getMinX() == 0 || 
            getBoundsInParent().getMaxX() == limiteEnX){
            velocidad = 0;
        }
    }
}





