package Main;

import World.World;
import actors.Ant;
import actors.AntEater;
import actors.Food;
import actors.QueenAnt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by ros_aljacobson001 on 5/15/2014.
 */
public class Client extends JFrame {

    public int x = 10;
    public int y = 10;
    private World theWorld = new World(x,y);
    private Image dbImage;
    private Graphics dbg;

    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            if(keyCode == KeyEvent.VK_SPACE){
                theWorld.oneRound();
            }
        }

        public void keyReleased(KeyEvent e){

        }
    }

    public Client(){
        theWorld.add(new Ant(),8,8);
        theWorld.add(new Food(),0,0);
        theWorld.add(new Food(),3,3);
        theWorld.add(new QueenAnt(),5,2);
        theWorld.add(new Ant(),4,4);
        theWorld.add(new QueenAnt(),9,9);
        theWorld.add(new AntEater(),5,5);
        addKeyListener(new AL());
        setLayout(new GridLayout(5, 5));
        setTitle("Ant Simulator");
        setSize(500, 525);
        setResizable(false);
        setBackground(Color.WHITE);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);
        g.drawImage(dbImage,0,0,this);
    }

    public void paintComponent(Graphics g) {
        theWorld.show(g,this);
        paintGrid(g);
        repaint();
    }

    public void paintGrid(Graphics g){
        g.setColor(Color.BLACK);
        int tileX = 50;
        int tileY = 50;
        for(int i = 0;i<x;i++){
            g.drawLine(i*tileX,25,i*tileX,525);
        }
        for(int i = 1;i<y;i++){
            g.drawLine(0,i*tileY+25,500,i*tileY+25);
        }
    }
    public static void main(String[] args) {
        new Client();
    }
}