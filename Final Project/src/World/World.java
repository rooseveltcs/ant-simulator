package World;

import Main.Client;
import actors.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ros_aljacobson001 on 5/16/2014.
 * Modified by ros_aljacobson001 on 6/11/2014
 */
public class World {
    private Actor[][] theGrid;
    private ArrayList<Actor> theActors = new ArrayList<Actor>();
    private int x;
    private int y;

    public World(int x, int y){
        theGrid = new Actor[y][x];
        this.x = x;
        this.y = y;
    }

    public World(){
        theGrid = new Actor[10][10];
    }

    public void oneRound(){
        System.out.println("One round");
        for(int currentActor = 0;currentActor<theActors.size();currentActor++){
            theActors.get(currentActor).act();
        }
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void add(Actor theActor,int x,int y){
        theGrid[y][x] = theActor;
        theActors.add(theActor);
        theActor.putInGrid(this,x,y);
    }

    public void remove(Actor theActor){
        theActors.remove(theActor);
    }
     public void show(Graphics g, Client client){
         for(int i = 0;i<theActors.size();i++){
             theActors.get(i).show(g,client);
         }
     }

    public Food getCloseFood(Ant theAnt){
        Food theFood = new Food();
        int foodNumber = 1;
        double foodDistance = 0;
        for(int i = 0;i < theActors.size();i++){
            if(theActors.get(i) instanceof Food){
                if(foodNumber == 1){
                    theFood = (Food) theActors.get(i);
                    double changeX = theFood.getLocation().getX()-theAnt.getLocation().getX();
                    double changeY = theFood.getLocation().getY()-theAnt.getLocation().getY();
                    double distance = Math.sqrt(Math.pow(changeX,2)+Math.pow(changeY,2));
                    foodDistance = distance;
                }else{
                    Food newFood = (Food) theActors.get(i);
                    double changeX = newFood.getLocation().getX()-theAnt.getLocation().getX();
                    double changeY = newFood.getLocation().getY()-theAnt.getLocation().getY();
                    double distance = Math.sqrt(Math.pow(changeX,2)+Math.pow(changeY,2));
                    if(foodDistance < distance){
                        theFood = newFood;
                    }
                }
            }
        }
        return theFood;
    }

    public QueenAnt getCloseQueen(Ant theAnt){
        QueenAnt theQueen = new QueenAnt();
        int foodNumber = 1;
        double foodDistance = 0;
        for(int i = 0;i < theActors.size();i++){
            if(theActors.get(i) instanceof QueenAnt){
                if(foodNumber == 1){
                    theQueen = (QueenAnt) theActors.get(i);
                    double changeX = theQueen.getLocation().getX()-theAnt.getLocation().getX();
                    double changeY = theQueen.getLocation().getY()-theAnt.getLocation().getY();
                    double distance = Math.sqrt(Math.pow(changeX,2)+Math.pow(changeY,2));
                    foodDistance = distance;
                }else{
                    QueenAnt newQueen = (QueenAnt) theActors.get(i);
                    double changeX = newQueen.getLocation().getX()-theAnt.getLocation().getX();
                    double changeY = newQueen.getLocation().getY()-theAnt.getLocation().getY();
                    double distance = Math.sqrt(Math.pow(changeX,2)+Math.pow(changeY,2));
                    if(foodDistance < distance){
                        theQueen = newQueen;
                    }
                }
            }
        }
        return theQueen;
    }

    public Ant getCloseAnt(AntEater theAntEater){
        Ant theAnt = new Ant();
        int foodNumber = 1;
        double foodDistance = 0;
        for(int i = 0;i < theActors.size();i++){
            if(theActors.get(i) instanceof QueenAnt){
                if(foodNumber == 1){
                    theAnt = (QueenAnt) theActors.get(i);
                    double changeX = theAnt.getLocation().getX()-theAntEater.getLocation().getX();
                    double changeY = theAnt.getLocation().getY()-theAntEater.getLocation().getY();
                    double distance = Math.sqrt(Math.pow(changeX,2)+Math.pow(changeY,2));
                    foodDistance = distance;
                }else{
                    Ant newAnt = (Ant) theActors.get(i);
                    double changeX = newAnt.getLocation().getX()-theAntEater.getLocation().getX();
                    double changeY = newAnt.getLocation().getY()-theAntEater.getLocation().getY();
                    double distance = Math.sqrt(Math.pow(changeX,2)+Math.pow(changeY,2));
                    if(foodDistance < distance){
                        theAnt = newAnt;
                    }
                }
            }
        }
        return theAnt;
    }
}
