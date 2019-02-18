//Adrienne Lee
//20063367
import java.util.*; //import class

public class GuessMaster { //class is guessmaster
	private int numberOfCandidateEntities; //instance variable. represents the number of entities 
	private Entity[] entities; //array with all the entities

	public GuessMaster() { //constructor
		numberOfCandidateEntities = 0; //set the number of entries to 0
		entities = new Entity[1000]; //create an array with 1000 indexes. maximum amount of entries is 1000
	}

	public void addEntity(Entity entity) { //method that adds the entities into the array
		this.entities[numberOfCandidateEntities] = entity; //takes the entity entered and puts it in the array of the instance variable
		numberOfCandidateEntities++; //increase the variable
	}

	public void playGame(Entity entity) { //method that allows to play the game
		System.out.println("Hello human player. Guess the birthdate of " + entity.getName()); //prints this out at the beginning of the game
		Scanner in = new Scanner(System.in); //takes an input 
		String input = in.nextLine(); //puts the input into a string
		if (input.equalsIgnoreCase("Quit")) { //if the input is quit
			System.out.println("Thank you for playing and please come again"); //then print this line out
			System.exit(0); //exit the code
		}
		Date dateInput = new Date(input); //puts the input through the method in Date class in order to split the numbers
		if (entity.getBorn().equals(dateInput)) { //if the dateInput is equal to the entity
			System.out.println("Bingo!! You got it!"); //then print out Bingo!! You got it!
		} else if (entity.getBorn().precedes(dateInput)) { //if precede function returns true
			System.out.println("Incorrect, try an earlier date."); //print Incorrect, try an earlier date
			playGame(entity); //call the function again to loop
		} else { //if the precede function returns false
			System.out.println("Incorrect, try a later date."); //print Incorrect, try a later date.
			playGame(entity); //call the function again to loop
		}
	}

	public void playGame(int entityInd) { //parameter is the entity index
		playGame(entities[entityInd]); //call the playGame function with the entity of a specific person
	}

	public static void main(String[] args) {

		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971)); //setting the entities
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968)); //setting the entities
		Entity usa = new Entity("United States", new Date("July", 4, 1776)); //setting the entities
//		Entity adrienne = new Entity("Adrienne", new Date("August", 9, 1999));
//		Entity yujin = new Entity("Yujin", new Date ("February", 19, 1999));
//		Entity headta = new Entity("headta", new Date ("August", 2, 1995));
		

		GuessMaster gm = new GuessMaster(); //setting the array
		gm.addEntity(trudeau); //adding the entities
		gm.addEntity(dion); //adding the entities
		gm.addEntity(usa); //adding the entities
//		gm.addEntity(adrienne);
//		gm.addEntity(yujin);
//		gm.addEntity(headta);
		Random rand = new Random(); //creating a random number and storing into rand
		while (true) { //loop
			gm.playGame(rand.nextInt(gm.numberOfCandidateEntities) + 0); //creating a random number from 0 to the amount of entities
		}
	}
}
