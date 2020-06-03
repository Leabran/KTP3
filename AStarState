import java.util.*;

public class AStarState
{
    private Map2D map;

    private HashMap<Location, Waypoint> openVertex = new HashMap<Location, Waypoint>();
    private HashMap<Location, Waypoint> closeVertex = new HashMap<Location, Waypoint>();

    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }

    public Waypoint getMinOpenWaypoint() {

        if (openVertex.isEmpty()) return null;

        float minCost = 3.4e+38f;
        Waypoint minCostObject = null;

        ArrayList<Waypoint> values = new ArrayList<Waypoint>(openVertex.values());
        for (Waypoint element : values) {
            if (element.getTotalCost() < minCost) {
                minCost = element.getTotalCost();
                minCostObject = element;
            }
        }

        return minCostObject;
    }

    public boolean addOpenWaypoint(Waypoint newWP)
    {

        ArrayList<Location> locations = new ArrayList<Location>(openVertex.keySet());

        Location newLoc = newWP.getLocation();

        for (Location index : locations) {
            if (newLoc.equals(index)) {

                Waypoint oldWP = openVertex.get(index);

                double oldCost = oldWP.getPreviousCost();
                double newCost = newWP.getPreviousCost();

                if (newCost < oldCost) {
                    openVertex.put(newLoc, newWP);
                    return true;
                }

                return false;

            }
        }

        openVertex.put(newLoc, newWP);
        return true;
    }

    public int numOpenWaypoints()
    {
        return openVertex.size();
    }

    public void closeWaypoint(Location loc)
    {
        //System.out.println("Closing waypoint: " + loc.xCoord + ", " + loc.yCoord);
        Waypoint wp = openVertex.get(loc);
        openVertex.remove(loc);
        closeVertex.put(loc, wp);
    }

    public boolean isLocationClosed(Location loc)
    {
        return openVertex.containsKey(loc);
    }
}
