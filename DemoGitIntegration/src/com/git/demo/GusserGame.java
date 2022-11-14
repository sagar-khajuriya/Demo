package com.git.demo;
import java.util.Scanner;

class Gusser{
	//In this method gusser can guess the number between 0 to 10 only 
	//if gusser guess invalid range then controls again comes on guessNumber() method 
	int guessNumber;
	public int guessNumber(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Gusser please guess the Number between 0-10");
		guessNumber=sc.nextInt();
		if(guessNumber<0 || guessNumber>10){
			System.out.println("Invalid Range Guess Again");
			guessNumber();
		}
		return guessNumber;	
	}	
}

class Player{
	// This is the Player class in which guessnumber() method is defined to take the guessed number
	// from players
	int guessNumber;
	public int guessNumber(){
		Scanner sc=new Scanner(System.in);
		System.out.println("guess the Number");
		guessNumber=sc.nextInt();
		return guessNumber;
	}
		
}

class Umpire{
	// This is Umpire class in which we are calling the method of class Gusser and class Player 
	
	int guessNumber;
	
	public void collectNumFromGusser(){
		Gusser g=new Gusser();
		guessNumber=g.guessNumber();
	}
	public void collectNumFromPlayer(){
		
		Scanner sc=new Scanner(System.in);
			System.out.println("Enter the number of players : Range(2 to 5)");
			int num=sc.nextInt();
			Player [] play=new Player[num];
			int [] ar=new int[num];
			String[] strr=new String[num];
		if(num<2 || num>5){
			System.out.println("Invalid No of players ");
			collectNumFromPlayer();
		}else{ 
				for(int i=0;i<num;i++){
				play[i]=new Player();
				System.out.print("Player "+(i+1)+" :- Enter your name : ");
				strr[i]=sc.next();
				ar[i]=play[i].guessNumber();
				}
				
		
		System.out.println("****************************");
		
		int count=0;
		boolean flag=false;
		String name="";
		for(int i=0;i<ar.length;i++){
			if(ar[i]==guessNumber){
				System.out.println("Player : "+strr[i]+" guessed the right number   **Congratulations**");
				count++;
				flag=true;
				name=strr[i];
			}
			
		}
		
		System.out.println();
		
		if(count==1 && flag==true){
			System.out.println(name+" Won the match   **Congratulations**");
		}
		
		if(flag==false){
			System.out.println("Game Lost Try Again...............");
		}
		
		if(count>1){
			System.out.println("Game draw between "+count+" players");
		}
	
		System.out.println();
		// After showing result here we are asking from players to show the summary of game 
		// if he press y then if block will execute otherwise else block
		System.out.println("If you wants to know summary of a game then please press Y otherwise press N");
		String str=sc.next();
		if(str.equalsIgnoreCase("Y")){
			System.out.println(count+" Player Won the Game");
			for(int i=0;i<ar.length;i++){
				System.out.println("Number Guessed by Player "+strr[i]+" is : "+ar[i]);
			}
		}else{
			System.out.println("****************************");
		}
		// Here we are asking from player to play again press P or to exit press E
		System.out.println("For Play Again press P or For exit press E");
		String str1=sc.next();
		if(str1.equalsIgnoreCase("P")){
			collectNumFromGusser();
			collectNumFromPlayer();
		}else{
			System.exit(0);
		}
		
		}
	}
}


public class GusserGame {

	public static void main(String[] args) {
		Umpire u=new Umpire();
		u.collectNumFromGusser();
		u.collectNumFromPlayer();

	}

}
