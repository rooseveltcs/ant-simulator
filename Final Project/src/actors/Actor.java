package actors;

import Main.Client;
import World.Location;
import World.World;

import java.awt.*;

/**
 * Created by ros_aljacobson001 on 5/16/2014.
 */
public class Actor{
    private Location LOCATION;
    private int DIRECTION;
    private Color COLOR;
    private boolean IS_IN_GRID = false;
    public World theWorld;

    public Actor(){
        DIRECTION = 0;
        COLOR = Color.BLUE;
        LOCATION = null;
    }

    public Actor(int direction, Color color, Location loc){
        DIRECTION = direction;
        COLOR = color;
        LOCATION = loc;
    }

    public Color getColor(){
        return COLOR;
    }

    public void setColor(Color newColor){
        COLOR = newColor;
    }

    public int getDirection(){
        return DIRECTION;
    }

    public void setDirection(int newDirection){
        DIRECTION = newDirection;
    }

    public Location getLocation(){
        return LOCATION;
    }

    public void setLocation(Location newLocation){
        LOCATION = newLocation;
    }

    public void act(){

    }

    public void putInGrid(World theWorld, int x, int y){
            this.theWorld = theWorld;
            LOCATION = new Location(x,y);
    }

    public void removeFromGrid(){
            theWorld.remove(this);
    }

    public boolean isSame(Actor other){
        if(other.getColor().equals(getColor())){
            if(other.getDirection() == getDirection()){
                if(other.getLocation().isSameLocation(other.getLocation())){
                    return true;
                }
            }
        }
        return false;
    }
    public void show(Graphics g, Client client){
    }
}
