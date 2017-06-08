import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.util.Random;
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
        super(x, y, width, height);
        Random ale = new Random();
        Color colorLadrillo = new Color(ale.nextFloat(), ale.nextFloat(), ale.nextFloat(), ale.nextFloat());
        this.setWidth(width);
        this.setHeight(height);
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.setFill(colorLadrillo);
        this.setStroke(Color.BLACK);
        
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
    