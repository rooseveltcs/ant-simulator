package actors;

import Main.Client;
import com.bulenkov.iconloader.IconLoader;

import java.awt.*;

/**
 * Created by ros_aljacobson001 on 6/12/2014.
 *
 */
public class AntEater extends Actor {
    private int movePoints = 0;
    private Ant target;
    private boolean hasTarget = false;

    /**
     * The uncompleted act method for this.
     * will check if there is an ant next to the anteater
     */
    public void act(){
        System.out.println("Anteater");
        if(!hasTarget){
            theWorld.getCloseAnt(this);
            hasTarget = true;
        }else{
            if(this.getLocation().isSameLocation(target.getLocation())){
                target.removeFromGrid();
            }
        }
    }

    /**
     * Shows this
     * @param g the Graphics
     * @param client the Client
     */
    public void show(Graphics g, Client client){
        IconLoader.getIcon("anteater.jpg").paintIcon(client, g, 500 / client.x * this.getLocation().getX(), 500 / client.y * this.getLocation().getY() + 25);
    }
}
