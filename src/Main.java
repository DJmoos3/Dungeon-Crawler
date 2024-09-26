public class Main
{
    public static void main(String[] args)
    {
        Player player = new Player();
        Game game = new Game();

        player.playerCreation();
        while(!game.isDone)
        {
            game.fight(player);
        }
        System.out.println("YOU WIN!");

    }
}