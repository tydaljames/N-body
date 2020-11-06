import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Animate extends JPanel implements ActionListener { //Runs all other required classes for the nBody program to run, and animates the celestial bodies
    private static List<cBody> list;
    private ArrayList<Color> cArray = new ArrayList<Color>();
    private Timer tm = new Timer(1, this);
    private Random rand = new Random();


    public void paintComponent(Graphics g){ //Paints the celestial bodies on our JFrame
        super.paintComponent(g);

        for(int i=0;i<list.size();i++){
            g.setColor(list.get(i).color);

            double x = (list.get(i).x);
            double y = (list.get(i).y);
            double velX = (list.get(i).velX);
            double velY = (list.get(i).velY);
            double size = (list.get(i).size);

            g.fillOval((int)x,(int)y,(int)size,(int)size);
        }
        tm.start(); //Starts timer which animates the cBodies
    }


    public void actionPerformed(ActionEvent e){ //Moves the cBodies by changing their values




        for(int i=0;i<list.size();i++){
            double x = (list.get(i).x);
            double y = (list.get(i).y);
            double velX = (list.get(i).velX);
            double velY = (list.get(i).velY);
            double size = (list.get(i).size);
            cBody a = list.get(i);


            a.reset();

            for(int j=0;j<list.size();j++) {
                if(i != j){
                    cBody b = list.get(j);
                    a.gPull(b);
                }
            }
        }

        for(int k=0;k<list.size();k++) {
            cBody a = list.get(k);
            a.move();
        }
        repaint();
    }




    public static void main(String[] args){
        getData.csvFile = args[0];
        getData.run();
        Animate a = new Animate();
        list = getData.getList();

        JFrame jf = new JFrame();
        jf.setTitle("Celestial");
        jf.setSize(768,768);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(a);

    }
}
