public class Waypoint
{
    /**  Расположение этой путевой точки **/
    Location loc;

    Waypoint prevWaypoint;

    private float prevCost;

    private float remainingCost;

    public Waypoint(Location loc, Waypoint prevWaypoint)
    {
        this.loc = loc;
        this.prevWaypoint = prevWaypoint;
    }

    /** Возвращает местоположение путевой точки. **/
    public Location getLocation()
    {
        return loc;
    }

    public Waypoint getPrevious()
    {
        return prevWaypoint;
    }

    public void setCosts(float prevCost, float remainingCost)
    {
        this.prevCost = prevCost;
        this.remainingCost = remainingCost;
    }

    public float getPreviousCost()
    {
        return prevCost;
    }

    public float getRemainingCost()
    {
        return remainingCost;
    }

    public float getTotalCost()
    {
        return prevCost + remainingCost;
    }
}
