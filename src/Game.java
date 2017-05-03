/*
 *  @author zhuoyue2
 * 
 */
public class Game 
{
	Player p1;
	Board board;
	int count=0;
	
	public Game()
	{
		this.board = new Board();
		this.p1 = new Player(this.board);
	}
	
	public void main(String[] args)
	{
		Game thisGame = new Game();
		thisGame.start();
	}
	
	public void start()
	{
		System.out.println("Welcome to BattleGolf !");
		p1.getName();
		while(!this.board.winnerCheck())
		{
			System.out.println("Take a shot bro (The form should be x,y)");
			p1.getFire();
			count++;
			if(board.winnerCheck())
			{
				System.out.println("Congratulations! You win!");
				System.out.println(p1.name + "'s score is" + count);
			}
		}
	}
}
