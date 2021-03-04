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
        System.out.println(this.x);
        this.y = r.nextInt(Window.getDIMY());
        System.out.println(this.y);
        this.radius = r.nextInt(difficulty)+10;
        System.out.println(this.radius);
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
