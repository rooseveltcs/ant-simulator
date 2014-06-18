package actors;

import Main.Client;
import World.Location;
import World.World;

import java.awt.*;

/**
 * Created by ros_aljacobson001 on 5/16/2014.
 * Modified by Aaron Jacobson on 6/16/14
 * This is the Actor class which is what all things that act extend.
 * Each this has a location, Direction, World, and color. Tough Color
 * is not used. this does not show itself.
 * By default each actor does nothing when act() is called.
 */
public class Actor{
    private Location LOCATION;
    private int DIRECTION;
    private Color COLOR;
    private boolean IS_IN_GRID = false;
    public World theWorld;

    /**
     * This is the default constructor for this.
     * It takes no parameters and does not set a location.
     */
    public Actor(){
        DIRECTION = 0;
        COLOR = Color.BLUE;
        LOCATION = null;
    }

    /**
     * This is the second constructor which takes in a direction, color, and location
     * It then sets all of the class variables to the values given.
     * @param direction The initial direction of this
     * @param color The color of this
     * @param loc the initial location of this
     */
    public Actor(int direction, Color color, Location loc){
        DIRECTION = direction;
        COLOR = color;
        LOCATION = loc;
    }

    /**
     * Gets the color of this
     * @return the color of thus
     */
    public Color getColor(){
        return COLOR;
    }

    /**
     * Sets the color of this to the given color
     * @param newColor the new color
     */
    public void setColor(Color newColor){
        COLOR = newColor;
    }

    /**
     * Gets the direction of this
     * @return a value between 0 and 359 which is the direction of this
     */
    public int getDirection(){
        return DIRECTION;
    }

    /**
     * Sets the direction of this to the value given.
     * @param newDirection the direction that is given
     */
    public void setDirection(int newDirection){
        DIRECTION = newDirection;
    }

    /**
     * Gets tbe current location of this
     * @return the current location of this
     */
    public Location getLocation(){
        return LOCATION;
    }

    /**
     * Sets the location of this
     * @param newLocation the new location of this
     */
    public void setLocation(Location newLocation){
        LOCATION = newLocation;
    }

    /**
     * The default act() method which does nothing
     * and takes no parameters. It also returns nothing.
     */
    public void act(){

    }

    /**
     * Puts this in the location with the given x and y values
     * @param theWorld The world that this is being put in
     * @param x the x coordinate for this
     * @param y the y coordinate for this
     */
    public void putInGrid(World theWorld, int x, int y){
            this.theWorld = theWorld;
            LOCATION = new Location(x,y);
    }

    /**
     * Removes this from the grid
     * Does not return anything
     */
    public void removeFromGrid(){
            theWorld.remove(this);
    }

    /**
     * Checks if this is the same as the given
     * @param other The actor this is being compared to
     * @return returns true if they are the same, false if not
     */
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

    /**
     * Shows this
     * @param g the Graphics
     * @param client the Client
     */
    public void show(Graphics g, Client client){
    }
}
