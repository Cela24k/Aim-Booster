import java.util.Random;

public class Cerchio {

    private int radius;
    private int x;
    private int y;
    private int difficulty;

    public Cerchio(int difficulty) {
        this.difficulty = difficulty;
        Random r = new Random();
        this.x = r.nextInt(Window.getDIMX());
        this.y = r.nextInt(Window.getDIMY());
        this.radius = r.nextInt(difficulty)+25;
        System.out.println("The circle has those bounders X= "+this.x+" Y = "+this.y+" RADIUS = "+this.radius+" DIAMETER = "+this.radius*2);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getRadius() {
        return radius;
    }
}
