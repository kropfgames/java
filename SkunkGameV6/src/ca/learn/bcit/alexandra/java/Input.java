
package ca.learn.bcit.alexandra.java;

import java.util.Scanner;

/**
 * @author  Alexandra Kropova
 * @version Jan. 26, 2020
 */
public class Input
{
	private boolean isPlayerStanding;
	
	private int difficultyLevelSelected;
	
	public Input()
	{
//		setIsPlayerStanding(isPlayerStanding);
//		setDifficultyLevelSelected(difficultyLevelSelected);
	}
	
	/**
	 * @return the isPlayingStanding
	 */
	public boolean getIsPlayerStanding()
	{
		return isPlayerStanding;
	}

	/**
	 * @param isPlayingStanding the isPlayingStanding to set
	 */
	public void setIsPlayerStanding(boolean isPlayerStanding)
	{
		this.isPlayerStanding = isPlayerStanding;
	}
	
	/**
	 * @return the difficultyLevelSelected
	 */
	public int getDifficultyLevelSelected()
	{
		return difficultyLevelSelected;
	}

	/**
	 * @param difficultyLevelSelected the difficultyLevelSelected to set
	 */
	public void setDifficultyLevelSelected(int difficultyLevelSelected)
	{
		this.difficultyLevelSelected = difficultyLevelSelected;
	}

	public void selectMode()
	{
		System.out.println("Input.selectMode: Enter an integer to select a difficulty level.");
		
	}
//	end of selectNumberOfDice()
	
	public void checkUserInput()
	{		
		Scanner keyboardScanner = new Scanner(System.in);
		
		while (keyboardScanner.hasNextInt())
		{
			setDifficultyLevelSelected(keyboardScanner.nextInt());
			displayMode();
			break;
		} 
		
	}
//	end of checkUserInput()
	
	public void displayMode()
	{
		System.out.println("You selected " + getDifficultyLevelSelected() + ".");
	}
	
	public void askIfUserWantsToKeepPlaying()
	{
		System.out.println("Press L to lock in your points or C to continue playing this round.");

		Scanner keyboardScanner = new Scanner(System.in);
		while (keyboardScanner.hasNext())
		{
			String input = keyboardScanner.next();
			
			if (input.equalsIgnoreCase("L"))
			{
				System.out.println("Input.scanLockPointsInput: You locked your points.");
				setIsPlayerStanding(false);
				break;
			}
			
			else
			{
				setIsPlayerStanding(true);
				System.out.println("Input.scanLockPointsInput: You chose to continue.");
				break;
			}
			
		}
//		end of while loop
	}
//	end of scanLockPointsInput
	

	
	
	
	
	
}
//end of Input class