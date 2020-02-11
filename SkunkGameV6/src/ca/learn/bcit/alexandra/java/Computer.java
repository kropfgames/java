/**
 * 
 */
package ca.learn.bcit.alexandra.java;

import java.util.Random;

/**
 * @author  Alexandra Kropova
 * @version Feb. 9, 2020
 */
public class Computer
{
	private boolean isComputerStanding;
	
	public Computer(boolean isComputerStanding)
	{
		setIsComputerStanding(isComputerStanding);
	}

	/**
	 * @return the isComputerStanding
	 */
	public boolean getIsComputerStanding()
	{
		return isComputerStanding;
	}

	/**
	 * @param isComputerStanding the isComputerStanding to set
	 */
	public void setIsComputerStanding(boolean isComputerStanding)
	{
		this.isComputerStanding = isComputerStanding;
	}

	public int generateRandom()
	{
		Random random = new Random();
		int randomNum = random.nextInt(2);
		return randomNum;
	}
	
	/**
	 * 
	 */
	public void decideIfComputerWantsToKeepPlaying()
	{
		if (generateRandom() == 0)
		{
			System.out.println("Computer.decideIfComputerWantsToKeepPlaying: The computer has locked their points.");
			setIsComputerStanding(false);
		}
		
		else
		{
			System.out.println("The computer decided to keep playing.");
			setIsComputerStanding(true);
		}
		
	}
//	end of decideIfLockPoints()


	

	


}
