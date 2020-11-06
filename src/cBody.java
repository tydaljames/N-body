import java.awt.Color;

public class cBody {
    public String name;
    public double size;
    public double mass;
    public double x;
    public double y;
    public double velX;
    public double velY;
    public double gx;
    public double gy;
    public Color color;
    private double gravity = 6.673*(Math.pow(10,-11));   // Force of Gravity


    public String toString() { //Shows all data for the celestial body
        return "" + name + ", " + mass + ", " + x + ", "+ y+ ", "+  velX+ ", "+ velY+ ", "+ size;
    }

    public cBody(String name, double mass,  double x, double y, double velX, double velY, double size, Color color) {
        this.name = name;
        this.mass  = mass;
        this.size = size;
        this.x    = x;
        this.y    = y;
        this.velX    = velX;
        this.velY    = velY;
        this.color = color;
    }

    public void move() { //Moves the celestial body based on its velocity
        velX += gx / mass;
        velY += gy / mass;
        x += velX;
        y += velY;
    }



    public void gPull(cBody b) { //Applies gravity to celestial body
        cBody a = this;
        double dist = Math.sqrt(Math.pow((b.x-a.x),2) + Math.pow((b.y-a.y),2));
        double dx = b.x - a.x;
        double dy = b.y - a.y;
        double force = (gravity * ((a.mass * b.mass) / (dist*dist + 900000000)));
        a.gx += force * dx / dist;
        a.gy += force * dy / dist;
    }

    public void reset() { //resets gravity for a celestial body
        gx = 0.0;
        gy = 0.0;
    }


}