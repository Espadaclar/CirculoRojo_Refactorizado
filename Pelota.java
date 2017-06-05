
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

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
        pelota = new Circle(centerX, centerY, radius);
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



















