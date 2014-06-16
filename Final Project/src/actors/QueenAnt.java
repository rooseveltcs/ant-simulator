package actors;

import Main.Client;
import World.Location;
import com.bulenkov.iconloader.IconLoader;

import java.awt.*;

/**
 * Created by ros_aljacobson001 on 5/29/2014.
 */
public class QueenAnt extends Ant{
    private double hunger = 100;

    public void act(){
        if(hunger >= 200){
            makeAnt();
        }
    }

    public double getHunger(){
        return this.hunger;
    }

    public void setHunger(double newHunger){
        hunger = newHunger;
    }

    public void makeAnt(){
        theWorld.add(new Ant(),this.getLocation().getX(),this.getLocation().getY());
        hunger -= 200;
    }
    public void show(Graphics g, Client client){
        if(getDirection() == Location.NORTH){
            IconLoader.getIcon("Qant_N.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.NORTH_WEST){
            IconLoader.getIcon("Qant_NW.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.WEST){
            IconLoader.getIcon("Qant_W.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.SOUTH_WEST){
            IconLoader.getIcon("Qant_SW.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.SOUTH){
            IconLoader.getIcon("Qant_S.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.SOUTH_EAST){
            IconLoader.getIcon("Qant_SE.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.EAST){
            IconLoader.getIcon("Qant_E.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else{
            IconLoader.getIcon("Qant_NE.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }
    }
}
