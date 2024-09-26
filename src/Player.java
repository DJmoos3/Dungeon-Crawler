import java.util.Scanner;

public class Player extends Object
{
    Scanner scanner = new Scanner(System.in);
    String classType;

    public void playerCreation()
    {
        setType("player");
        String choice;
        System.out.println("Welcome to the player creation.");
        System.out.println("Which class do you want to play?");
        System.out.println("You've got 3 choices. \n1: Mage \n2: Warrior \n3: Barbarian");
        System.out.println("Make your choice by either typing in the Job or number.");
        choice = scanner.nextLine();

        if(choice.equals("1") || choice.equalsIgnoreCase("mage"))
        {
            mage();
            classType = "mage";
        }
        else if (choice.equals("2") || choice.equalsIgnoreCase("warrior"))
        {
            warrior();
            classType = "warrior";
        }
        else if(choice.equals("3") || choice.equalsIgnoreCase("barbarian"))
        {
            barbarian();
            classType = "barbarian";
        }

    }

    public void mage()
    {
        setHealth(50);
        setDamage(2);
        setArmour(2);
    }
    public void warrior()
    {
        setHealth(100);
        setDamage(5);
        setArmour(5);
    }
    public void barbarian()
    {
        setHealth(100);
        setDamage(10);
        setArmour(0);
    }
}
