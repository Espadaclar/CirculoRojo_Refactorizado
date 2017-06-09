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
        super();
        Random ale = new Random();
        Color colorLadrillo = new Color(ale.nextFloat(), ale.nextFloat(), ale.nextFloat(), ale.nextFloat());
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.setWidth(width);
        this.setHeight(height);
        this.setFill(colorLadrillo);
        this.setStroke(Color.BLACK);

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

}  
