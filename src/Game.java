import java.util.Scanner;

public class Game
{
    Scanner scanner = new Scanner(System.in);
    private boolean hasAttacked;
    public void fight(Player player, Enemy enemy)
    {
        System.out.println("A wild "+ enemy.type + " appears");
        while(player.getHealth() > 0 && enemy.getHealth() > 0)
        {
            hasAttacked = false;
            System.out.println("What action are you gonna take?");
            System.out.println("1: Attack");
            if(scanner.nextLine().equalsIgnoreCase("1"))
            {
                System.out.println("The player attacks and deals: " + player.getDamage() + " damage.");
                enemy.setHealth(enemy.getHealth()-player.getDamage());
                hasAttacked = true;
                if (enemy.getHealth() <= 0)
                {
                    System.out.println("Foe has been vanquished");
                }
            }
            else
            {
                System.out.println("Wrong input try again");
            }
            if(hasAttacked && enemy.getHealth() > 0)
            {
                System.out.println(enemy.type + " attacks the player and deals:" + enemy.getDamage() + " damage.");
                player.setHealth(player.getHealth()-enemy.getDamage());
            }
        }
    }
}
