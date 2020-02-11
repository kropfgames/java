/**
 * 
 */
package ca.learn.bcit.alexandra.java;

/**
 * @author  Alexandra Kropova
 * @version Feb. 9, 2020
 */
public class Round
{
	public static final int NUMBER_OF_SKUNK_ROUNDS = 5;
	
	private Dice dice;
	private Input input;
	private Computer computer;
	private Score score;
	
	private int turnScore;
	private int playerTotalScore;
	private int computerTotalScore;
	
	private boolean shouldNextRoundContinue;
	private boolean isAnyoneStanding;
	
	boolean shouldGameEnd = false;
	
	/**
	 * 
	 */
	public Round()
	{
		int[] rounds = new int[NUMBER_OF_SKUNK_ROUNDS];
		int roundCount = 1;
		
		shouldNextRoundContinue = true;
		
		input = new Input();
		input.selectMode();
		input.checkUserInput();
		
		while (shouldNextRoundContinue && !shouldGameEnd)
		{
			for (int i : rounds)
			{
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Round #" + roundCount + "/" + NUMBER_OF_SKUNK_ROUNDS);
				generateARound();
				
				playerTotalScore += score.getPlayerScore();
				computerTotalScore += score.getComputerScore();
				
				System.out.println("Your score for Round #" + roundCount + ": " + score.getPlayerScore());
				System.out.println("Computer score for Round #" + roundCount + ": " + score.getComputerScore());

				score.setPlayerScore(-score.getPlayerScore());
				score.setComputerScore(-score.getComputerScore());
				turnScore = 0;
				
				roundCount++;
			}
			shouldNextRoundContinue = false;
		}
//		
//		System.out.println("Round.Round: ");
//		System.out.println("Your final score: " + playerTotalScore);
//		System.out.println("Computer final score: " + computerTotalScore);

		
	}
//	end of Round()
	
	
	public void generateARound()
	{
		dice = new Dice();
		computer = new Computer(true);
		score = new Score();
		
		isAnyoneStanding = true;
		input.setIsPlayerStanding(true);
		computer.setIsComputerStanding(true);
		
//		the length is being set to zero
		int[] diceRolled = new int[input.getDifficultyLevelSelected()];
	
		while (isAnyoneStanding)
		{	
			System.out.println("Round.while:");
			int numberOfDiceWithA1 = 0;
			
			for (int index = 0; index < diceRolled.length; index++)
			{
				int die = dice.generateRandom();
				diceRolled[index] = die;
				
				System.out.print("[" + die + "]");
				
				if (diceRolled[index] == 1)
				{
					numberOfDiceWithA1++;
				}
				
				if (numberOfDiceWithA1 != 1 && numberOfDiceWithA1 != 2)
				{
					turnScore += diceRolled[index];
				}
			}
			
			if (numberOfDiceWithA1 == 2)
			{
				if (someoneIsStandingForADouble1Roll())
				{
//					System.out.println("numberOfDiceWithA1 == 2. someoneIsStandingForADouble1Roll: ");
//					System.out.println("Your score: " + score.getPlayerScore());
//					System.out.println("Comp score: " + score.getComputerScore());
					
					break;
					

				}
				
//				System.out.println("numberOfDiceWithA1 == 2. !someoneIsStandingForADouble1Roll: ");
//
//				System.out.println("Your score: " + score.getPlayerScore());
//				System.out.println("Comp score: " + score.getComputerScore());
			}

			else if (numberOfDiceWithA1 == 1)
			{
				if (someoneIsStandingForASingle1Roll())
				{
//					System.out.println("numberOfDiceWithA1 == 1. someoneIsStandingForASingle1Roll: ");
//					System.out.println("Your score: " + score.getPlayerScore());
//					System.out.println("Comp score: " + score.getComputerScore());
					break;
					

				}
				
//				System.out.println("numberOfDiceWithA1 == 1. !someoneIsStandingForASingle1Roll: ");
//				System.out.println("Your score: " + score.getPlayerScore());
//				System.out.println("Comp score: " + score.getComputerScore());
				
			}
			
			else
			{
				if (everyoneDecidesToSit())
				{
					
//					System.out.println("everyoneDecidesToSit");
//					System.out.println("Your score: " + score.getPlayerScore());
//					System.out.println("Comp score: " + score.getComputerScore());
					
					break;

				}

//				System.out.println("!everyoneDecidesToSit");
//				System.out.println("Your score: " + score.getPlayerScore());
//				System.out.println("Comp score: " + score.getComputerScore());
			}
	
		}
//		end of while loop
	}
//	end of generateARound()


	public boolean someoneIsStandingForADouble1Roll()
	{		
		if (input.getIsPlayerStanding())
		{
			if (!computer.getIsComputerStanding())
			{
				System.out.println("The computer wins this game.");
				score.setPlayerScore(-(score.getPlayerScore()));
				System.out.println("---------------------------------------------------------------------");
				isAnyoneStanding = false;
				shouldNextRoundContinue = false;
				shouldGameEnd = true;
			}
			else
			{
				System.out.println("Everyone was standing. Skip.");
			}
		}
		
		else if (computer.getIsComputerStanding())
		{
			System.out.println("You win this game.");
			score.setComputerScore(-(score.getComputerScore()));
			System.out.println("---------------------------------------------------------------------");
			shouldGameEnd = true;
			isAnyoneStanding = false;
			shouldNextRoundContinue = false;
		}
		
		else
		{
			System.out.println("Everyone was sitting.");
			shouldGameEnd = true;
		}
		
		return shouldGameEnd;
	}
	
	/**
	 * @return
	 */
	private boolean someoneIsStandingForASingle1Roll()
	{
		boolean shouldRoundEnd = false;
		
		if (input.getIsPlayerStanding())
		{
			if (!computer.getIsComputerStanding())
			{
				System.out.println("The computer wins this round.");
				score.setPlayerScore(-(score.getPlayerScore()));
				System.out.println("---------------------------------------------------------------------");
				isAnyoneStanding = false;
				shouldRoundEnd = true;
			}
			
			else
			{
				System.out.println("Everyone was standing. Skip.");
			}
		}
		
		else if (computer.getIsComputerStanding())
		{
			System.out.println("You win this round.");
			score.setComputerScore(-(score.getComputerScore()));
			System.out.println("---------------------------------------------------------------------");

			isAnyoneStanding = false;
			shouldRoundEnd = true;
		}
		
		else
		{
			System.out.println("Everyone was sitting.");
			shouldRoundEnd = true;
		}
		
		return shouldRoundEnd;
	}
//	end of someoneIsStandingForASingle1Roll()
	
	public boolean everyoneDecidesToSit()
	{
		boolean didEveryoneSit = false;
		
		if (input.getIsPlayerStanding())
		{
			score.setPlayerScore(turnScore);
			input.askIfUserWantsToKeepPlaying();
		}
		
		if (computer.getIsComputerStanding())
		{
			score.setComputerScore(turnScore);
			computer.decideIfComputerWantsToKeepPlaying();
		}
		
		if (!input.getIsPlayerStanding() && !computer.getIsComputerStanding())
		{ 
			System.out.println("---------------------------------------------------------------------");

			isAnyoneStanding = false;
			didEveryoneSit = true;
		}
		
		return didEveryoneSit;
	}
//	end of everyoneDecidesToSit

}
//end of Round
