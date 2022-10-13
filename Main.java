import java.util.Scanner;
class Main {
  public static void main(String[] args) {
   
//package u5methodsproj;
    
// Create scanner
Scanner scanN = new Scanner(System.in);

// Declare Variables
int inp, times = 0, points = 0,quart; 

// Title message
System.out.println("\n\n\nWelcome to the most fun Arcade!"); 

System.out.println("How many coins would you like to deposit?");
quart = scanN.nextInt(); // collect user input


do {
    Menu(); 
    inp = scanN.nextInt(); // collect user input


    // Switch statement for each possible user input(3 games+exit+error)
    switch (inp) {

        // If user inputs 1: go to method for Rock Paper Scissors
        case (1): {
            times++; // adds 1 to counter for number of times played
            points = RockPaperScissors(points); // adds # of points earned
            break; 
        }

        // If user inputs 2: go to method for Guess My Number
        case (2):{
            times++; // adds 1 to counter for number of times played
            points = GuessMyNumber(points); // adds # of points earned
            break; 
        }

        // If user enters 3: go to method for Flipping Coin Guessing Game
        case (3): {
            times++; // adds 1 to counter for number of times played
            points = CoinFlip(points); // adds # of points earned
            break; 
        }    

        // If user enters 4 - exit loop
        case (4): {
            System.out.println("Exiting...");
            break;
        }

        // If user enters a value other than 1-4
        default:
            System.out.println("You have entered an incorrect value. "
                    + "Try again.");
    }

} while (inp!=4 && times<quart); 
// loops repeats while inp is not 4 and quarters remain


// end statement
System.out.println("\nThe number of points you have won is: "+points);
Prize(points); // method that outputs prize
}

/*
* Method name: Menu
* Outputs game menu
*/
public static void Menu() {

// Menu
System.out.println("\nMenu:\n1. Rock Paper Scissors\n2. Guess My "
    + "Number\n3. Flipping a coin guessing game\n4. Exit program");

}

/*
* Method name: RockPaperScissors
* Rock paper scissors game
*/
public static int RockPaperScissors(int points) {

// Create scanner
Scanner scanN = new Scanner(System.in);

// Game title
System.out.println("\nRock paper scissors"); 

// variables for game 1
int num,comp,result; 
comp = (int)(Math.random()*3);

// Do..while loop for error trap
do {
    System.out.println("\nEnter one of the following:\n0 = paper\n1 = "
            + "scissors\n2 = rock"); // game instructions

    num = scanN.nextInt(); // collect user input

    if (num>2||num<0) 
        System.out.println("You have entered an incorrect value. Try "
                + "again."); // tells user if input is incorrect

} while(num>2||num<0); //repeats while wrong value is entered

// Outputs comp choice
switch (comp) {
    case (0): {
        System.out.println("The computer picked Paper");
        break;
    }
    case (1): {
        System.out.println("The computer picked Scissors");
        break;
    }
    case (2): {
        System.out.println("The computer picked Rock");
        break;
    }
}

result = comp-num; // determines result

if ((result==1)||(result==-2)) // checks if computer wins, no points added
    System.out.println("You have lost");

else if ((result==-1)||(result==2)) { // checks if user wins, add 50 points
    System.out.println("You have won!");
    points += 50;
}

else if (result==0) { // check if its a draw, add 20 points
    System.out.println("It is a draw");
    points += 20;
}

System.out.println("Game Over."); // output at the end

return points; // sends back the number of points earned 
}

/*
* Method name: GuessMyNumber
* Guess my number game
*/
public static int GuessMyNumber(int points) {

// Create scanner
Scanner scanN = new Scanner(System.in);

// Game title
System.out.println("\nGuess My Number"); 

// Variables for guessing game
int guess;
int compG = (int)(1+Math.random()*(100));

// Guessing game instructions 
System.out.println("\nI am thinking of a number between 1 and 100 can "
        + "you guess it? You have 10 tries.");

// For loop that repeats while number of tries are left
for(int t=1;t<=10;t++) {
    System.out.println("What is your guess? ");

    guess = scanN.nextInt(); // collect input

    if (guess>100||guess<1){ 
        System.out.println("Your number is not whithin the range"); 
    }
    
    else if (guess==compG) {
        System.out.println("You are correct!");
        if (t<=6)
            points +=50;
        else if (t>6)
            points +=10;
        break;  
    }

    else if (guess>compG) {
        System.out.println("You guessed too high");
    }

    else if (guess<compG) {
        System.out.println("You guessed too low");
    }

    System.out.println("\nYou have "+(10-t)+" tries left");

} 
System.out.println("Game Over."); // output at the end

return points; // sends back the number of points earned
}

/*
* Method name: CoinFlip
* Coin flip game
*/
public static int CoinFlip(int points) {

// Create scanner
Scanner scanN = new Scanner(System.in);

// Variables for game 3
int compC = (int)(1+Math.random()*(2));
int coinInp;

// Game title
System.out.println("\nFlipping a Coin Guessing Game"); 

// Do..while loop for error trap
do { 

// Instructions
System.out.println("\nEnter one of the following values:\n1 = Heads\n2 "
        + "= Tails"); 
coinInp = scanN.nextInt(); // collect input

if (coinInp>2||coinInp<1) // tells user if input is incorrect
        System.out.println("You have entered an incorrect value. Try "
                + "again");
} 
while(coinInp>2||coinInp<1); //repeats while input is incorrect

if ((compC==1&&coinInp==1)||(compC==2&&coinInp==2)) {
    System.out.println("You win!");
    points +=50;
}

else if ((compC==1&&coinInp==2)||(compC==2&&coinInp==1)) {
    System.out.println("You lose");  
}

System.out.println("Game over."); // output at the end

return points; // sends back the number of points earned
}

/*
* Method name: Prize
* Outputs the prize won
*/
public static void Prize(int points) {

// If statements that outputs the prize depending on # of points
if (points<=100)
    System.out.println("You win Prize 1: Chocolate!");

else if (points>100&points<200)
    System.out.println("You win prize 2: Free pizza for a lifetime!");

else  if (points>200&points<300)
    System.out.println("You win prize 3: A new Tesla!");

else if (points>=300)
    System.out.println("You win the top prize: A trip to Europe");
}

}