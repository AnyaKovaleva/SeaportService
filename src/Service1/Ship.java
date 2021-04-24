package Service1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Ship {
    private String shipName;
    private CargoType cargoType;
    private int cargoAmount;
    private Calendar scheduledArrivalDate;
    private Calendar scheduledDepartureDate;
    private Calendar actualArrivalDate;
    private Calendar actualDepartureDate;
    private int delayTime;
    private int fine;

    Ship(String shipName1, CargoType cargoType1, int cargoWeight1)
    {
        shipName = shipName1;
        cargoType = cargoType1;
        cargoAmount = cargoWeight1;
    }

    Ship(CargoType cargoType1, int cargoWeight1)
    {
        shipName = generateRandomShipName();
        cargoType = cargoType1;
        cargoAmount = cargoWeight1;
    }

    Ship()
    {
        shipName = generateRandomShipName();
        cargoType = generateRandomCargoType();
        cargoAmount = generateRandomCargoAmount();
        scheduledArrivalDate = generateScheduledArrivalDate();
        setActualArrivalDate();
    }

    private void setActualArrivalDate()
    {
        actualArrivalDate = (Calendar) scheduledArrivalDate.clone();
        Random random = new Random();
        actualArrivalDate.add(Calendar.DAY_OF_MONTH, random.nextInt(14)-7);
    }

    public String generateRandomShipName()  {
        List<String> shipNamesList;
        String name = null;

        try
        {
            shipNamesList = Files.readAllLines(Paths.get("C:\\Users\\annko\\IdeaProjects\\SeaportService\\src\\Service1\\ShipNames"));
            Random random = new Random();
            int randomNum = random.nextInt(shipNamesList.size());
            name = shipNamesList.get(randomNum);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return name;
    }

    public CargoType generateRandomCargoType()
    {
        Random random = new Random();
        int randomType = random.nextInt(CargoType.values().length);
        return CargoType.values()[randomType];
    }

    public int generateRandomCargoAmount()
    {
        Random random = new Random();
        return random.nextInt(1000);
    }

    public Calendar generateScheduledArrivalDate()
    {
        Random random = new Random();
        return new GregorianCalendar(2021, Calendar.APRIL, random.nextInt(30)+1, random.nextInt(24), random.nextInt(60));
    }

    @Override
    public String toString()
    {
        return "Scheduled Arrival: " + scheduledArrivalDate.getTime() + "\n" +
                "Actual Arrival: "   + actualArrivalDate.getTime() + "\n" +
                "Ship Name: " + shipName + "\n" +
                "Cargo Type: " + cargoType + "\n" +
                "Amount of cargo: " + cargoAmount + "\n";
    }

    public Calendar getActualArrivalDate()
    {
        return actualArrivalDate;
    }


}
