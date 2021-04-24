package Service1;


import java.util.ArrayList;
import java.util.List;

public class PortSchedule {
    private List<Ship> ships = new ArrayList<>();

    public PortSchedule(int shipsNum)
    {
        GenerateSchedule(shipsNum);
    }

    private void GenerateSchedule(int shipsNum)
    {
        for(int i=0; i < shipsNum; i++)
        {
            ships.add(new Ship());
        }
    }

    public void printPortSchedule()
    {
        for(Ship ship :ships)
        {
            System.out.println(ship.toString() + "\n");
        }
    }

    public List<Ship> getPortSchedule()
    {
        return ships;
    }
}
