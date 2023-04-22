import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class Elevator {


private int currentFloor;
private String direction;
private int[] upQueue;
private int[] downQueue;
private int maxFloor;
private int maxCapacity;


    public static void main(String[] args)
    {
        Elevator elevator = new Elevator();
        elevator.getSpecs();
        elevator.startElevator();
    }

    public void printElevator()
    {
        int [] floors = new int[maxFloor];
        Arrays.setAll(floors, i -> i + 1);
        System.out.println("---------------------------------------------");
        String display = "";
        for(int i = 0; i < floors.length; i++)
        {
            if(floors[i] == currentFloor)
            {
                display += "[" + floors[i] + "]";
            }
            else
            {
                display += floors[i];
            }
            if(floors[i] != maxFloor)
            {
                display += " - ";
            }
        }
        System.out.println(display);
        System.out.println("---------------------------------------------");

    }
    //This method will request input from the user to set up maxFloor and maxCapacity
    public void getSpecs()
    {
        //Elevator will default start at floor #1
        currentFloor = 1;

        //Default maxFloor will be 10 floors for print purposes.
        maxFloor = 10;

        //Default direction will start going up.
        direction = "UP";


        System.out.println("Elevator configuration starting...");
        //Scanner myScanner = new Scanner(System.in);

        //OPTIONAL code to allow custom maxFloor input
        //System.out.println("Please enter the max floor.");
        //maxFloor = myScanner.nextInt();

        //OPTIONAL code to allow maxCapacity for elevator.
        //System.out.println("Please enter max elevator capacity(in persons) :");
        //maxCapacity = myScanner.nextInt();
        //myScanner.close();
    }

    public void startElevator()
    {
        //The following code would be part of future implementation including
        //floor inputs simultaneously. Would require either 'waiting' or multi-threading.
        /*
        ArrayList<Integer> goingUpQueue = new ArrayList<Integer>();
        ArrayList<Integer> goingDownQueue = new ArrayList<Integer>();
        //Input needed for floor request, future implementation would link GUI floor buttons
        System.out.println("If elevator needed, please enter current floor : ");
        int floorRequest = myScanner.nextInt();
        System.out.println("What is your desired floor? : ");
        int desiredFloor = myScanner.nextInt();
        if(floorRequest == desiredFloor)
        {
            System.out.println("You are at your desired floor.");
        }
        if(desiredFloor > floorRequest)
        {
            goingUpQueue.add(Integer.valueOf(floorRequest));
            goingUpQueue.add(Integer.valueOf(desiredFloor));
        }
        else
        {
            goingDownQueue.add(Integer.valueOf(floorRequest));
            goingDownQueue.add(Integer.valueOf(desiredFloor));
        }
        Collections.sort(goingUpQueue);
        Collections.sort(goingDownQueue, Collections.reverseOrder());

         */
        Scanner myScanner = new Scanner(System.in);
        System.out.println("To turn off elevator at any time, enter STOP.");
        while(true)
        {
            System.out.println("If elevator needed, enter your current floor :");
            String command = myScanner.nextLine();
            if(validInput(command))
            {
                int riderFloor = Integer.parseInt(command);
                if(riderFloor != currentFloor)
                {
                    System.out.println("Elevator on the way from floor #" + currentFloor);
                }
                currentFloor = Integer.parseInt(command);
                System.out.println("Elevator is at your floor. What is your desired floor?");
            }
            else
            {
                continue;
            }
            String command2 = myScanner.nextLine();
            if(validInput(command2))
            {
                int desiredFloor = Integer.parseInt(command2);
                changeFloor(desiredFloor);
            }

        }


    }

    //This method is used to verify that a floor 'input' is either a valid floor or valid stop command.
    //If neither, the method returns false, which ultimately re-asks user for desired input.
    public boolean validInput(String input)
    {
        if(input.toLowerCase().equals("stop"))
        {
            System.exit(0);
        }
        try {
            int floor = Integer.parseInt(input);
            if(floor < 1 || floor > maxFloor)
            {
                System.out.println("That is not a valid floor.");
                return false;
            }
            return true;
        } catch (NumberFormatException nfe) {
            System.out.println("That is not a valid floor.");
            return false;
        }
    }

    //This method takes in a new floor and 'moves' the elevator(relevant fields updated).
    //If elevator is already at new floor, message is displayed.
    //After successful floor change, elevator status is displayed with its floor location.
    public void changeFloor(int newFloor)
    {
        if(currentFloor == newFloor)
        {
            System.out.println("You are at your desired floor.");
        }
        else
        {
            currentFloor = newFloor;
            System.out.println("Arrived at floor #" + newFloor + ". Elevator Status : ");
            printElevator();
        }
    }

}
