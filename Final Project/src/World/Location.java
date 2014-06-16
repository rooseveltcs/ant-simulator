package World;

import actors.Actor;

import java.util.ArrayList;

/**
 * Created by ros_aljacobson001 on 5/16/2014.
 */
public class Location {
    private int X;
    private int Y;

    public static final int NORTH = 0;
    public static final int NORTH_EAST = 45;
    public static final int EAST = 90;
    public static final int SOUTH_EAST = 135;
    public static final int SOUTH = 180;
    public static final int SOUTH_WEST = 225;
    public static final int WEST = 270;
    public static final int NORTH_WEST = 335;

    /**
     * Creates a new Location with the given coordinates
     * @param x the desired X
     * @param y the desired Y
     */
    public Location(int x, int y){
        X = x;
        Y = y;
    }

    /**
     * gives this X
     * @return gives this X
     */
    public int getX(){
        return X;
    }

    /**
     * gives this Y
     * @return gives this Y
     */
    public int getY(){
        return Y;
    }

    /**
     * Changes this X to the given input
     * @param newX the desired X
     */
    public void setX(int newX){
        X = newX;
    }

    /**
     * changes this Y to the given input
     * @param newY the desired Y
     */
    public void setY(int newY){
        Y = newY;
    }

    /**
     * Returns an ArrayList made up of all the locations adjacent to this
     * @return and ArrayList
     */
    public ArrayList<Location> getNeighborLocations(){
        ArrayList<Location> theLocs = new ArrayList<Location>();
        for(int currentLoc = 0;currentLoc < 360;currentLoc += 45){
            Location oneLocation = getAdjacentLocation(currentLoc);
            theLocs.add(oneLocation);
        }
        return theLocs;
    }

    /**
     * Takes in a direction and returns the closest location in that direction
     * @param direction the direction desired
     * @return the adjacent location in the given direction
     */
    public Location getAdjacentLocation(int direction){
        int xChange = 0;
        int yChange = 0;
        if(direction == NORTH){
            yChange = -1;
        }else if(direction == NORTH_EAST){
            xChange = 1;
            yChange = -1;
        }else if(direction == EAST){
            xChange = 1;
        }else if(direction == SOUTH_EAST){
            xChange = 1;
            yChange = 1;
        }else if(direction == SOUTH){
            yChange = 1;
        }else if(direction == SOUTH_WEST){
            xChange = -1;
            yChange = 1;
        }else if(direction == WEST){
            xChange = -1;
        }else{
            xChange = -1;
            yChange = -1;
        }
        Location theReturn = new Location(getX()+xChange,getY()+yChange);
        return theReturn;
    }

    /**
     * Takes in another Location and returns true if they are the same
     * Will return false otherwise
     * @param other the other Location
     * @return true if the are the same, false if they are not
     */
    public boolean isSameLocation(Location other){
        if(other.getX() == getX() && other.getY() == getY()){
            return true;
        }else{
            return false;
        }
    }
}
