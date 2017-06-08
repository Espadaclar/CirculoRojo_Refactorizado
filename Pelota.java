
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
    }

    public Pelota() {
        centerX = 0.0f;
        centerY = 0.0f;
        radius = 0.0f;
    }

   
    public void setColor(Color color) {
        this.color = color;
    }
    
}



















