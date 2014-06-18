package actors;

import Main.Client;
import World.Location;
import com.bulenkov.iconloader.IconLoader;

import java.awt.*;

/**
 * Created by ros_aljacobson001 on 5/29/2014.
 * Modified by ros_aljacobson001 on 6/11/2014
 * The worker ant which walks around the map picking up food
 */
public class Ant extends Actor{

    public double hunger = 100;
    public boolean getF = false;
    public boolean getQ = false;
    public boolean start = false;
    public QueenAnt queenAnt;
    public Food food;
    public boolean hasFood = false;

    /**
     * This method determines what the ant will do when act() is called
     * The ant will do one of the following: pick up food, give food to the queen
     * eat the food, move towards the queen or move towards the food
     */
    public void act(){
        food = theWorld.getCloseFood(this);
        queenAnt = theWorld.getCloseQueen(this);
        if(getF){
            if(start){
                if(getLocation().isSameLocation(food.getLocation())){
                    start = false;
                    hunger += 50;
                    hasFood = false;
                    //eat the food
                }else{
                    if(getLocation().getY() > food.getLocation().getY() && getLocation().getX() == food.getLocation().getX()){
                        System.out.println("moving up");
                        setDirection(Location.NORTH);
                        //go up
                        move(new Location(this.getLocation().getX(), this.getLocation().getY() - 1));
                    }else if(getLocation().getX() > food.getLocation().getX() && getLocation().getY() > food.getLocation().getY()){
                        System.out.println("moving up left");
                        setDirection(Location.NORTH_WEST);
                        //go up left
                        move(new Location(this.getLocation().getX() - 1, this.getLocation().getY() - 1));
                    }else if(getLocation().getX() > food.getLocation().getX() && getLocation().getY() == food.getLocation().getY()){
                        System.out.println("moving left");
                        setDirection(Location.WEST);
                        //go left
                        move(new Location(this.getLocation().getX() - 1, this.getLocation().getY()));
                    }else if(getLocation().getX() > food.getLocation().getX() && getLocation().getY() < food.getLocation().getY()){
                        System.out.println("moving down left");
                        setDirection(Location.SOUTH_WEST);
                        //go down left
                        move(new Location(this.getLocation().getX() - 1, this.getLocation().getY() + 1));
                    }else if(getLocation().getY() < food.getLocation().getY() && getLocation().getX() == food.getLocation().getX()){
                        System.out.println("moving down");
                        setDirection(Location.SOUTH);
                        //go down
                        move(new Location(this.getLocation().getX(),this.getLocation().getY()+1));
                    }else if(getLocation().getX() < food.getLocation().getX() && getLocation().getY() < food.getLocation().getY()){
                        System.out.println("moving down right");
                        setDirection(Location.SOUTH_EAST);
                        //go down right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()+1));
                    }else if(getLocation().getX() < food.getLocation().getX() && getLocation().getY() == food.getLocation().getY()){
                        System.out.println("moving right");
                        setDirection(Location.EAST);
                        //go right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()));
                    }else{
                        System.out.println("moving up right");
                        setDirection(Location.NORTH_EAST);
                        //go up right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()-1));
                    }
                }
            }else{
                //get the food
                start = false;
                getF = false;
                food.giveFood(this);
            }
        }else if(getQ){
            if(start){
                if(getLocation().isSameLocation(food.getLocation())){
                    food.giveFood(this);
                    start = false;
                    //get the food
                }else{
                    if(getLocation().getY() > food.getLocation().getY() && getLocation().getX() == food.getLocation().getX()){
                        //go up
                        move(new Location(this.getLocation().getX(), this.getLocation().getY() - 1));
                    }else if(getLocation().getX() > food.getLocation().getX() && getLocation().getY() > food.getLocation().getY()){
                        //go up left
                        move(new Location(this.getLocation().getX()-1,this.getLocation().getY()-1));
                    }else if(getLocation().getX() > food.getLocation().getX() && food.getLocation().getY() == getLocation().getY()){
                        //go left
                        move(new Location(this.getLocation().getX()-1,this.getLocation().getY()));
                    }else if(getLocation().getX() > food.getLocation().getX() && getLocation().getY() < food.getLocation().getY()){
                        //go down left
                        move(new Location(this.getLocation().getX()-1,this.getLocation().getY()+1));
                    }else if(getLocation().getY() < food.getLocation().getY() && getLocation().getX() == food.getLocation().getX()){
                        //go down
                        move(new Location(this.getLocation().getX(),this.getLocation().getY()+1));
                    }else if(getLocation().getX() < food.getLocation().getX() && getLocation().getY() < food.getLocation().getY()){
                        //go down right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()+1));
                    }else if(getLocation().getX() < food.getLocation().getX() && food.getLocation().getY() == getLocation().getY()){
                        //go right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()));
                    }else{
                        //go up right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()-1));
                    }
                }
            }else{
                if(getLocation().isSameLocation(queenAnt.getLocation())){
                    giveQueenFood(queenAnt);
                    //give the queen the food
                }else{
                    if(getLocation().getY() > queenAnt.getLocation().getY() && getLocation().getX() == queenAnt.getLocation().getX()){
                        //go up
                        move(new Location(this.getLocation().getX(),this.getLocation().getY()-1));
                    }else if(getLocation().getX() > queenAnt.getLocation().getX() && getLocation().getY() > queenAnt.getLocation().getY()){
                        //go up left
                        move(new Location(this.getLocation().getX()-1,this.getLocation().getY()-1));
                    }else if(getLocation().getX() > queenAnt.getLocation().getX() && getLocation().getY() == queenAnt.getLocation().getY()){
                        //go left
                        move(new Location(this.getLocation().getX()-1,this.getLocation().getY()));
                    }else if(getLocation().getX() > queenAnt.getLocation().getX() && getLocation().getY() < queenAnt.getLocation().getY()){
                        //go down left
                        move(new Location(this.getLocation().getX()-1,this.getLocation().getY()+1));
                    }else if(getLocation().getY() < queenAnt.getLocation().getY() && getLocation().getX() == queenAnt.getLocation().getX()){
                        //go down
                        move(new Location(this.getLocation().getX(),this.getLocation().getY()+1));
                    }else if(getLocation().getX() < queenAnt.getLocation().getX() && getLocation().getY() < queenAnt.getLocation().getY()){
                        //go down right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()+1));
                    }else if(getLocation().getX() < queenAnt.getLocation().getX() && getLocation().getY() == queenAnt.getLocation().getY()){
                        //go right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()));
                    }else{
                        //go up right
                        move(new Location(this.getLocation().getX()+1,this.getLocation().getY()-1));
                    }
                }
            }
        }else{
            if(hunger > 30){
                getQ = true;
                start = true;
                //assign closest queen location
            }else{
                getF = true;
                start = true;
                //assign closest food location
            }
        }
    }

    /**
     * This method displays the ant on the screen.
     * @param g the Graphics which will be used
     * @param client the Client of this program
     */
    public void show(Graphics g, Client client){
        if(getDirection() == Location.NORTH){
            IconLoader.getIcon("ant_N.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.NORTH_WEST){
            IconLoader.getIcon("ant_NW.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.WEST){
            IconLoader.getIcon("ant_W.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.SOUTH_WEST){
            IconLoader.getIcon("ant_SW.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.SOUTH){
            IconLoader.getIcon("ant_S.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.SOUTH_EAST){
            IconLoader.getIcon("ant_SE.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else if(getDirection() == Location.EAST){
            IconLoader.getIcon("ant_E.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }else{
            IconLoader.getIcon("ant_NE.jpg").paintIcon(client,g,500/client.x*this.getLocation().getX(),500/client.y*this.getLocation().getY()+25);
        }
    }

    /**
     * Moves the ant to the given tile.
     * @param moveTo the location to move to
     */
    public void move(Location moveTo){
        if(canMove(moveTo)){
            removeFromGrid();
            setDirection(Location.NORTH);
            getLocation().setX(moveTo.getX());
            getLocation().setY(moveTo.getY());
            theWorld.add(this, getLocation().getX(), getLocation().getY());
            putInGrid(theWorld,getLocation().getX(),getLocation().getY());
        }
    }

    /**
     * Checks if the ant can move to the given location.
     * @param loc the location to check
     * @return returns true if the ant can move to the given location, false otherwise
     */
    public boolean canMove(Location loc){
        if(loc.getX() >= theWorld.getX() || loc.getX() < 0){
            System.out.println("cant move1");
            return false;
        }else if(loc.getY() >= theWorld.getY() || loc.getY() < 0){
            System.out.println("cant move2");
            return false;
        }else{
            System.out.println("can move");
            return true;
        }
    }

    /**
     * gives te Queen food
     * @param theQueen The queen which the food is given to
     */
    public void giveQueenFood(QueenAnt theQueen){
        hasFood = false;
        theQueen.setHunger(theQueen.getHunger()+50);
    }
}
