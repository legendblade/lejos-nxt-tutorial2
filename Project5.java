/*
*	Code to go along with my YouTube tutorial at https://www.youtube.com/watch?v=Cd5N6R-9DUo
*/

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

import java.util.*;

public class Project5
{
    private DifferentialPilot bot;  //field declaration for a DifferentialPilot object

    public static void main(String[] args)
    {
        Project5 myProgram = new Project5();
        myProgram.run();
    }

    public Project5()
    {
        bot = new DifferentialPilot(56, 108, Motor.B, Motor.C);
        bot.setRotateSpeed(250);
        bot.setTravelSpeed(250);
    }

    public void run()
    {
        // Define our travel distances:
        List travel = new ArrayList();
        travel.add(getTravelDistanceFromInches(60)); // 0
        travel.add(getTravelDistanceFromInches(33)); // 1
        travel.add(getTravelDistanceFromInches(44)); // 2
        travel.add(getTravelDistanceFromInches(43));
        travel.add(getTravelDistanceFromInches(33)); // 4

        // Define our turns:
        List turn = new ArrayList();
        turn.add(getCalibratedAngle(90));
        turn.add(getCalibratedAngle(135));
        turn.add(getCalibratedAngle(-90));
        turn.add(getCalibratedAngle(135));
        turn.add(getCalibratedAngle(90));

        // Pause so we can get our finger out of the way:
        pause(500);

        // Iterate the list of travel and turns:
        for(int i = 0; i < 5; i++)
        {
            bot.travel(travel.get(i));
            bot.rotate(turn.get(i));
        }
    }//run()

    public void pause(int milli)
    {
        try
        {
            Thread.sleep(milli);
        }
        catch(InterruptedException e)
        {
        }
    }

    // Returns an angle roughly calibrated against the floor:
    public double getCalibratedAngle(double angle)
    {
        // Adjust according to calibration
        return angle * 1.21;
    }

    // Gets a travel distance from inches:
    public int getTravelDistanceFromInches(int inches)
    {
        // 300 = 11.5 inches
        // ~26 = 1 inch
        return inches * 26;
    }
}