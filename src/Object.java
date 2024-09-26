public class Object
{
    //stats for Object
    private int health;
    private int damage;
    private int armour;

    //is used to write out in console what is what
    private String type;

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmour() {
        return armour;
    }

    public String getType() {
        return type;
    }
}
