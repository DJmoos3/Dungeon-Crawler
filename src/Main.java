public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player();
        Enemy enemy1 = new Enemy();
        Game game = new Game();

        enemy1.goblin();

        player.playerCreation();

        game.fight(player, enemy1);
        System.out.println("YOU WIN!");

    }
}