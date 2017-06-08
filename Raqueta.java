import javafx.scene.paint.*;

/**
 * @author franciscoJavier
 */
public class Raqueta extends Ladrillo{
    private double x;
    private double y;
    private double width;
    private double height;
    private int direccion; 
    private int limiteEnX;
    private int velocidad;
    
    public Raqueta(double x, double y, double width, double height, int limiteEnX) {
        super(x, y, width, height);
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

    public Raqueta(){
        super();
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
            velocidad = -1;
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





