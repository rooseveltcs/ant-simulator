package actors;

import Main.Client;
import com.bulenkov.iconloader.IconLoader;

import java.awt.*;

/**
 * Created by Aaron on 6/3/2014.
 */
public class Food extends Actor {
    public void giveFood(Ant theAnt){
        theAnt.hasFood = true;
        System.out.println("giving food");
    }
    public void show(Graphics g, Client client){
        IconLoader.getIcon("grass.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
    }
}
