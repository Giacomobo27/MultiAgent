import java.util.HashMap;
import java.util.Map;

import astra.core.Module;
import astra.formula.Formula;
import astra.formula.Predicate;
import astra.term.Funct;
import astra.term.ListTerm;
import astra.term.Primitive;
import astra.term.Term;

//Routing.java provides the interface for the VacBot to interact with the map, detect obstacles,
// and calculate routes to its target destination based on the gradient values.

public class Routing extends Module {
    GradientMap map = new GradientMap();

    @ACTION
    public boolean updateBoundary(long x, long y) { //may have to fix this
        map.setMax_x((int)x);
        map.setMax_y((int)y);
        return true;
    }
    //return the maximum X and Y coordinates of the map.
    @TERM
    public long maxX() {
        return map.getMax_x();
    }
    
    @TERM
    public long maxY() {
        return map.getMax_y();
    }

    private Map<String, int[]> offsets = new HashMap<>();
    //The offsets map stores the relative movements in different directions,
    // which allows the agent to calculate where it should look or move based on its current position and orientation.

    {
        offsets.put("north-left", new int[] {-1,0});
        offsets.put("north-forwardLeft", new int[] {-1,-1});
        offsets.put("north-forward", new int[] {0,-1});
        offsets.put("north-forwardRight", new int[] {1,-1});
        offsets.put("north-right", new int[] {1,0});
        offsets.put("south-left", new int[] {1,0});
        offsets.put("south-forwardLeft", new int[] {1,1});
        offsets.put("south-forward", new int[] {0,1});
        offsets.put("south-forwardRight", new int[] {-1,1});
        offsets.put("south-right", new int[] {-1,0});
        offsets.put("east-left", new int[] {0,-1});
        offsets.put("east-forwardLeft", new int[] {1,-1});
        offsets.put("east-forward", new int[] {1,0});
        offsets.put("east-forwardRight", new int[] {1,1});
        offsets.put("east-right", new int[] {0,1});
        offsets.put("west-left", new int[] {0,1});
        offsets.put("west-forwardLeft", new int[] {-1,1});
        offsets.put("west-forward", new int[] {-1,0});
        offsets.put("west-forwardRight", new int[] {-1,-1});
        offsets.put("west-right", new int[] {0, -1});
    }

    @FORMULA
    public Formula obstacle(long X, long Y, String D, String location) {
        //This formula checks whether there is an obstacle at a specific location
        // relative to the VacBot. It takes coordinates (X, Y), a direction (D), and a location (left, forward, etc.).
        int x = (int) X;
        int y = (int) Y;

        int[] offset = offsets.get(D+"-"+location);
        return map.hasObstacle(x+offset[0], y+offset[1]) ? Predicate.TRUE:Predicate.FALSE;
    }

    @ACTION
    public boolean recordObstacle(long X, long Y, String D, String location) {
        int x = (int) X;
        int y = (int) Y;

        int[] offset = offsets.get(D+"-"+location);
        map.setObstacle(x+offset[0], y+offset[1]);
     //   System.out.println("[" + agent.name() +"] Recording Obstacle: (" + (x+offset[0]) + "," + (y+offset[1]) + ") @ (" + x + "," + y+")");
        return true;
    }  //This action records an obstacle at a given location by adjusting the coordinates 
    //based on the direction and location. It then updates the map using the setObstacle() method.

    @ACTION
    public boolean displayMap() {
      //  System.out.println(map.toString());
        return true;
    }

    @TERM
    public ListTerm routeTo(long sx, long sy, long x, long y) {
        return routeTo((int) sx, (int)sy, (int)x, (int) y);
    }  // These methods calculate a route from a starting point (sx, sy) 
    //to a target (x, y) using a gradient map (flood fill algorithm).

    @TERM
    public ListTerm routeTo(int sx, int sy, int x, int y) {
        if (!map.inBounds(x, y)) throw new RuntimeException("Route target (" + x + "," + y +") is outside known area of agent");

        map.generateGradient(x, y);
        // System.out.println(map.toString());

        ListTerm list = new ListTerm();
        int[] coords = new int[] { sx, sy };
        int i=0;
        while (map.getDistance(coords) > 1) {
            int option = map.chooseOption(coords);
            if (i++ == 20 || option == -1) {
             //   System.out.println("FAILED OPTION: ("+coords[0]+","+coords[1]+")");
             //   System.out.println(map.toString());
             //   System.exit(0);
            }

            list.add(new Funct("move", new Term[] {
                Primitive.newPrimitive(map.optionDirection(option))
            }));
            coords = map.optionCoords(coords, option);
        }

        return list;
    }

}
