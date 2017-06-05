import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
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

    public Ladrillo(double x, double y, double width, double height) {
        ladrillo = new Rectangle(x, y, width, height);
        color = null;
        
    }
    
    public Ladrillo() {
        x = 0.0f;
        y = 0.0f;
        width = 0.0f;
        height = 0.0f;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
}  
    