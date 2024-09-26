import java.util.Random;
import java.util.Scanner;

public class Game
{
    Scanner scanner = new Scanner(System.in);

    //is used to check if a turn is done
    private boolean hasAttacked;
    //is used to finish the game
    boolean isDone = false;
    //only usable by the barbarian but keeps damage reduction on
    boolean rageActive = false;

    //keeps check on how many turns have passed in rage
    private int rageTurns = 0;
    private int whichFloor = 1;
    private int encounter;

    private String whichChoice;

    Random random = new Random();

    Enemy enemy = new Enemy();


    public void fight(Player player)
    {
        getWhichEnemy();
        enemy.isBleeding = false;
        System.out.println("A wild "+ enemy.getType() + " appears");
        while(player.getHealth() > 0 && enemy.getHealth() > 0)
        {
            hasAttacked = false;
            System.out.println("What action are you gonna take?");
            System.out.println("1: Attack");
            System.out.println("2: Inspect");
            System.out.println("3: Cast spell");
            whichChoice = scanner.nextLine();
            if(whichChoice.equals("1"))
            {
                attack(player,enemy, player.getDamage());
                hasAttacked = true;
                if (enemy.getHealth() <= 0)
                {
                    System.out.println("Foe has been vanquished");
                    if (rageActive)
                    {
                        rageActive = false;
                        System.out.println("Rage runs out");
                    }
                    if (enemy.isBoss())
                    {
                        isDone = true;
                    }
                    if (enemy.isBoss())
                    {
                        encounter = 0;
                        whichFloor++;
                    }
                    else
                    {
                        encounter++;
                    }
                }
            }
            else if (whichChoice.equals("2"))
            {
                System.out.println("Who do you wanna inspect?");
                System.out.println("1: Yourself");
                System.out.println("2: Enemy");
                whichChoice = scanner.nextLine();
                if (whichChoice.equals("1"))
                {
                    System.out.println("Player has " + player.getHealth() + " amount of health left");
                }
                else if (whichChoice.equals("2"))
                {
                    System.out.println("On a scale of " + enemy.getMaxHealth() + " and 0. The enemy looks like an " +
                            enemy.getHealth());
                }
                else
                {
                    System.out.println("Wrong input");
                }
            }
            else if (whichChoice.equals("3"))
            {
                castSpell(player);
                hasAttacked = true;
            }
            else
            {
                System.out.println("Wrong input try again");
            }
            if(rageActive)
            {
                player.setArmour(enemy.getDamage()/2);
                rageTurns++;
            }
            if(hasAttacked && enemy.getHealth() > 0)
            {
                attack(enemy, player, enemy.getDamage());
            }
            if(enemy.isBleeding && hasAttacked)
            {
                enemy.setHealth(enemy.getHealth() - 5);
                System.out.println("Enemy is bleeding and took " + 5 + " damage.");
            }
            if (rageTurns == 5)
            {
                System.out.println("Rage runs out");
                rageActive = false;
                rageTurns = 0;
            }
        }
    }

    private void getWhichEnemy()
    {
        int enemyNumber = getRandomNumber();
        if(whichFloor == 1)
        {
            if(encounter < 10)
            {
                if (enemyNumber == 1)
                {
                    enemy.goblin();
                }
                else if (enemyNumber == 2)
                {
                    enemy.kobold();
                }
                else
                {
                    enemy.rat();
                }
            }
            else
            {
                if(enemyNumber == 1)
                {
                    enemy.hobgoblin();
                }
                if (enemyNumber == 2)
                {
                    enemy.goblinMage();
                }
            }
        }
        else if (whichFloor == 2)
        {
            if(encounter < 10)
            {
                if (enemyNumber == 1)
                {
                    enemy.lizardMan();
                }
                else if (enemyNumber == 2)
                {
                    enemy.orc();
                }
                else
                {
                    enemy.skeleton();
                }
            }
            else
            {
                if(enemyNumber == 1)
                {
                    enemy.orcChieftan();
                }
                if (enemyNumber == 2)
                {
                    enemy.minotaur();
                }
            }
        }
        else if(whichFloor == 3)
        {
            if(encounter < 10)
            {
                if (enemyNumber == 1)
                {
                    enemy.wraith();
                }
                else if (enemyNumber == 2)
                {
                    enemy.troll();
                }
                else
                {
                    enemy.deathKnight();
                }
            }
            else
            {
                if(enemyNumber == 1)
                {
                    enemy.golem();
                }
                if (enemyNumber == 2)
                {
                    enemy.giant();
                }
            }
        }
        else
        {
            enemy.dragon();
        }
    }

    private int getRandomNumber()
    {
        if(encounter == 10)
        {
            return random.nextInt(1,3);
        }
        else
        {
            return random.nextInt(1,4);
        }
    }

    public void castSpell(Player player)
    {
        if(player.classType.equals("mage"))
        {
            System.out.println("1: Fireball");
            whichChoice = scanner.nextLine();
            enemy.setHealth(enemy.getHealth() - 10);
            System.out.println("The player casts a Fireball and deal: " + 10 + " damage to the" + enemy);
        }
        else if (player.classType.equals("warrior"))
        {
            System.out.println("1: Double Strike");
            whichChoice = scanner.nextLine();
            attack(player, enemy,player.getDamage());
            attack(player, enemy,player.getDamage());

        }
        else if(player.classType.equals("barbarian"))
        {
            System.out.println("1: Brutal strike");
            System.out.println("2: Rage");
            whichChoice = scanner.nextLine();
            if(whichChoice.equals("1"))
            {
                attack(player, enemy, player.getDamage());
                if (attack(player, enemy, player.getDamage()) > 0)
                {
                    enemy.isBleeding = true;
                }
            }
            else if(whichChoice.equals("2"))
            {
                rageActive = true;
            }
        }
    }

    public int attack(Object attacker,Object defender , int damage)
    {
        int damageDealt;
        if (defender.getArmour() < damage)
        {
            damageDealt = damage - defender.getArmour();
            defender.setHealth(defender.getHealth() - damageDealt);
            System.out.println("The " + attacker.getType() + " attacks and the "+ defender.getType() +
                    " takes " + damageDealt + " damage.");
            return damageDealt;
        }
        else
        {
            System.out.println("The " + defender.getType() + "s defense is too strong so no damage was dealt." );
            return 0;
        }
    }
}
