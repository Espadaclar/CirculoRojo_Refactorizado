import javafx.scene.shape.Rectangle;

/**
 * @author franciscoJavier
 */
public class Ladrillo {
    private Rectangle ladrillo; 
    private double x;
    private double y;
    private double width;
    private double height;

    public Ladrillo(double x, double y, double width, double height) {
        ladrillo = new Rectangle(x, y, width, height);
        
    }
    
    public Ladrillo() {
        x = 0.0f;
        y = 0.0f;
        width = 0.0f;
        height = 0.0f;
    }
    
    

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    
    
    
    
    
    
    
    
}  
    