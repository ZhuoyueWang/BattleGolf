/*
 *  @author zhuoyue2
 * 
 */
public class Board 
{
	String[][] board;
	
	public Board()
	{
		this.board = new String[8][8];
		this.clearBoard();
		this.assignShip();
	}
	
	public void clearBoard()
	{
		for (int i =0;i< this.board.length; i++)
		    for (int j =0; j < this.board[0].length; j++)
		    {
			this.board[i][j] = "O";//character "O"
		    }
	}
	
	//public void getScore()
	//{
		
	//}
	
	public void assignShip()
	{
		for(int i = 0; i<5; i++)//assign ships number 1 to 5
		{
			int size;
			if(i == 0)// number 1 has 5 size and stuffs like that
				size = 5;
			else if( i == 1)
				size = 4;
			else if(i == 3 || i == 4)
				size = 3;
			else
				size = 2;
			int HoriOrVert = (int)(Math.random()+1);//0 means horizontal movement and vice versa
			int Dist = (int)(Math.random()*(8-(size-1)));//random position for starting point
			if(HoriOrVert == 0)//horizontal
			{
				int RandomRow = (int)(Math.random()*8);
				boolean flag = true;//check the position we want to assign ship that whether it is empty
				for(int j = 0; j<size;j++)
				{
					if(this.board[RandomRow][Dist+j] != "O")//need to ensure the positions are empty, or randomly generalize a new value again
					{
						flag = false;
						i = i -1;//do this loop again to ensure our randomization be successful
						break;
					}
				}
				if(flag)
				{
					for(int j = 0; j < size;j++)
					{
						this.board[RandomRow][Dist+j] = "" + (i+1);//record the serial number of ship
					}
				}
			}
			else//vertical
			{
				int RandomCol = (int)(Math.random()*8);
				boolean flag = true;
				for(int j = 0; j<size;j++)
				{
					if(this.board[Dist+j][RandomCol] != "O")
					{
						flag = false;
						i = i-1;
						break;
					}
				}
				if(flag)
				{
					for(int j = 0; j<size ; j++)
					{
						this.board[Dist+j][RandomCol] = "" + (i+1);
					}
				}
			}
		}
		
	}
	
//	public void screen()
//	{
		
//	}
	
//	public void printBoard()
//	{
		
//	}
	
	public boolean winnerCheck()
	{
		for(int i = 0; i<8;i++)
			for(int j = 0; j<8;j++)
			{
				if((!this.board[i][j].equals("X"))&&(!this.board[i][j].equals("O")))//X means the ship is sunk and O means it is sea
						return false;
			}
		return true;
	}
	
	public void BoardSetter(int i, int j, String x)
	{
		this.board[i-1][j-1] = x;
	}
	
	public String BoardGetter(int i, int j)
	{
		return this.board[i-1][j-1];
	}
	
//	public void printFinal()
//	{
		
//	}
	
	//public void forceQuit()
	//{
		
	//}
	
}
