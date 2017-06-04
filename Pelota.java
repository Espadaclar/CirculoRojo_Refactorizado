
import javafx.scene.shape.Circle;

/**
 * @author franciscoJavier
 */
public class Pelota {
    private Circle pelota; 
    private double centerX;
    private double centerY;
    private double radius;
    
    public Pelota(double centerX, double centerY, double radius){
        pelota = new Circle(centerX, centerY, radius);
    }

    public Pelota() {
        centerX = 0.0f;
        centerY = 0.0f;
        radius = 0.0f;
    }

    public void setCenterX(double centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(double centerY) {
        this.centerY = centerY;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getCenterX() {
        return centerX;
    }

    public double getCenterY() {
        return centerY;
    }

    public double getRadius() {
        return radius;
    }
    
    
    
}



















