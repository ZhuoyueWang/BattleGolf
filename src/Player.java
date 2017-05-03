/*
 *  @author zhuoyue2
 * 
 */


import java.util.Scanner;

public class Player 
{
	public String name;
	public boolean turn;
	public Board board;
	public String guess;
	
	public Player(Board x)
	{
		this.board = x;
	}
	
    public void getName()
    {
    	System.out.println("Player's name is__");
    	Scanner str = new Scanner(System.in);
    	this.name = str.nextLine();
        str.close();

    }
	public void getFire()
	{
		System.out.println("What's your guess?");
		boolean flag = true;
		int x = 0;
		int y = 0;
		while(flag)
    	{
			Scanner str1 = new Scanner(System.in);
			this.guess = str1.nextLine();
			str1.close();
			x = (int)(guess.charAt(0))- (int)('0');
			y = (int)(guess.charAt(2))- (int)('0');
			if(((x>0)&&(x<9)) && ((y>0)&&(y<9)))
			{
				break;
			}
			System.out.println("Invalid Value! Please try it again!");
    	}
		if(this.board.BoardGetter(x, y).equals("O"))
		{
			this.board.BoardSetter(x-1, y-1, "M");
			System.out.println("You Miss it!");
		}
		if(this.board.BoardGetter(x, y).equals("1")||this.board.BoardGetter(x, y).equals("2")||this.board.BoardGetter(x, y).equals("3")||this.board.BoardGetter(x, y).equals("4")||this.board.BoardGetter(x, y).equals("5"))
		{
			this.board.BoardSetter(x-1, y-1, "X");
			System.out.println("Nice Shot!");
		}
	}
}
