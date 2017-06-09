
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import java.util.Random;
/**
 * @author franciscoJavier
 */
public class Pelota extends Circle{
    private Circle pelota; 
    private double centerX;
    private double centerY;
    private double radius;
    private int velocidadEnX;
    private int velocidadEnY;

    private Color color;

    public Pelota(double centerX, double centerY, double radius){
        super(centerX, centerY, radius);
        Random ale = new Random();
        Color colorPelota = new Color(ale.nextFloat(), ale.nextFloat(), ale.nextFloat(), ale.nextFloat());
        this.setCenterX(centerX);
        this.setCenterY( centerY);
        this.setRadius(radius);
        this.setFill(colorPelota);
        this.setStroke(Color.RED);
        velocidadEnX = 1;
        velocidadEnY = 1;
    }

    public Pelota() {
        super();
        Random ale = new Random();
        Color colorPelota = new Color(ale.nextFloat(), ale.nextFloat(), ale.nextFloat(), ale.nextFloat());
        this.setCenterX(250);
        this.setCenterY( 250);
        this.setRadius(20);
        this.setFill(colorPelota);
        this.setStroke(Color.RED);
        velocidadEnX = 1;
        velocidadEnY = 1;
    }


    public void mover(int largoEscena, int altoEscena, double minimoXRaqueta, double maximoXRaqueta, double minimoYRaqueta){
        setTranslateX(getTranslateX() + velocidadEnX);
        setTranslateY(getTranslateY() + velocidadEnY);
        if(getBoundsInParent().getMinX() <= 0 || 
        getBoundsInParent().getMaxX() >= largoEscena ){
            velocidadEnX = -velocidadEnX;
        }
        else if(getBoundsInParent().getMinY() <=  0)        {
            velocidadEnY = -velocidadEnY;
        }
        //      SI LA BOLA SE SALE POR ABAJO APARECE UN MENSAJE DE GANE OVER.
        else if(getBoundsInParent().getMaxY() >= minimoYRaqueta && 
                        (getBoundsInParent().getMaxX() - radius) <= maximoXRaqueta &&
                          getBoundsInParent().getMinX() >= minimoXRaqueta ){
            velocidadEnY = -velocidadEnY;
        }
        else if(getBoundsInParent().getMaxY() >= altoEscena){
            velocidadEnY = 0;
            velocidadEnX = 0;
        }
    }
    
    public int getVelocidadPelota(){
        int valor = 1;
        if(velocidadEnY == 0 && velocidadEnX == 0){
            valor = 0;
        }
        return valor;
    }
}

