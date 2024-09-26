public class Enemy extends Object
{
    //is used to get to the next floor.
    private boolean isBoss;

    //is used to get whether the target is bleeding to deal damage
    boolean isBleeding;

    private int maxHealth;


    //floor 1 monsters
    public void goblin()
    {
        setStats(10,8,2);
        setType("Goblin");
        isBoss = false;
    }
    public void kobold()
    {
        setStats(10,9,3);
        setType("Kobold");
        isBoss = false;
    }
    public void rat()
    {
        setStats(2,3,0);
        setType("Rat");
        isBoss = false;
    }

    //floor 2 monsters
    public void lizardMan()
    {
        setStats(20,7,15);
        setType("Lizardman");
        isBoss = false;
    }
    public void orc()
    {
        setStats(30, 10, 3);
        setType("Orc");
        isBoss = false;
    }
    public void skeleton()
    {
        setStats(15,8,10);
        setType("Skeleton");
        isBoss = false;
    }

    //floor 3 monsters
    public void wraith()
    {
        setStats(20,15,0);
        setType("Wraith");
        isBoss = false;
    }
    public void troll()
    {
        setStats(50,10,10);
        setType("Troll");
        isBoss = false;
    }
    public void deathKnight()
    {
        setStats(15,10,30);
        isBoss = false;
    }

    //bosses

    //floor 1
    public void hobgoblin()
    {
        setStats(40, 10, 10);
        setType("Hobgoblin");
        isBoss = true;
    }
    public void goblinMage()
    {
        setStats(30, 15,0);
        setType("Goblin Mage");
        isBoss = true;
    }

    //floor 2
    public void orcChieftan()
    {
        setStats(50,20,0);
        setType("Orc Chieftan");
        isBoss = true;
    }
    public void minotaur()
    {
        setStats(70,15,5);
        setType("Minotaur");
        isBoss = true;
    }

    //floor 3
    public void golem()
    {
        setStats(100,7,50);
        setType("Golem");
        isBoss = true;
    }
    public void giant()
    {
        setStats(100, 30,10);
        setType("Giant");
        isBoss = true;
    }

    //final floor
    public void dragon()
    {
        setStats(200,40,50);
        setType("Dragon");
        isBoss = true;
    }
    public void setStats(int health, int damage, int armour)
    {
        setHealth(health);
        setMaxHealth(health);
        setDamage(damage);
        setArmour(armour);
    }

    public boolean isBoss()
    {
        return isBoss;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
}
