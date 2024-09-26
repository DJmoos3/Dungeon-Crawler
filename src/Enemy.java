public class Enemy extends Object
{
    String type;
    //floor 1
    public void goblin()
    {
        setStats(10,2,3);
        setType("Goblin");
    }
    public void kobold()
    {
        setStats(10,1,6);
        setType("Kobold");
    }
    public void rat()
    {
        setStats(2,1,0);
        setType("Rat");
    }

    //floor 2
    public void lizardMan()
    {
        setStats(20,7,15);
        setType("Lizardman");
    }
    public void orc()
    {
        setStats(30, 10, 3);
        setType("Orc");
    }
    public void skeleton()
    {
        setStats(15,8,10);
        setType("Skeleton");
    }

    //floor 3
    public void wraith()
    {
        setStats(20,15,0);
        setType("Wraith");
    }
    public void troll()
    {
        setStats(50,10,10);
        setType("Troll");
    }

    //bosses

    //floor 1
    public void hobgoblin()
    {
        setStats(40, 10, 10);
        setType("Hobgoblin");
    }
    public void goblinMage()
    {
        setStats(30, 15,0);
        setType("Goblin Mage");
    }

    //floor 2
    public void orcChieftan()
    {
        setStats(50,20,0);
        setType("Orc Chieftan");
    }
    public void minotaur()
    {
        setStats(70,15,5);
        setType("Minotaur");
    }

    //floor 3
    public void golem()
    {
        setStats(100,7,50);
        setType("Golem");
    }
    public void giant()
    {
        setStats(100, 30,10);
        setType("Giant");
    }

    //final floor
    public void dragon()
    {
        setStats(200,40,50);
        setType("Dragon");
    }
    public void setStats(int health, int damage, int armour)
    {
        setHealth(health);
        setDamage(damage);
        setArmour(armour);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
}
