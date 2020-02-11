package ca.learn.bcit.alexandra.java;
import java.util.Random;

/**
 * @author  Alexandra Kropova
 * @version Jan. 26, 2020
 */
public class Dice
{
	public Dice()
	{

	}

	public int generateRandom()
	{
		int randomNumber;
		Random randomGenerator = new Random();
		randomNumber = randomGenerator.nextInt(6) + 1;
		return randomNumber;
	}
	
	
	
	
	
	
	
}
//end of Turn
