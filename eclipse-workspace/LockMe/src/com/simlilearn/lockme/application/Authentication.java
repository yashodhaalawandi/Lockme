package com.simlilearn.lockme.application;
import java.io.*;
import java.util.Scanner;

import com.simplilearn.lockme.model.*;


public class Authentication {
    //input Data
	private static Scanner keyboard;
	private static Scanner input;
	
	//output data
	private static PrintWriter output;
	private static PrintWriter lockerOutput;
	
	//model to store data
	private static Users users;
	private static UserCredentials userCrdentials;

	
	public static void main(String[] args) 
	{
		initApp();
		welcomeScreen();
		signInOption();
	}
	public static void signInOption()
	{
		System.out.println("1.Rigistration");
		System.out.println("2.Login");
		int option=keyboard.nextInt();
		switch(option) {
		case 1:
		signUp();
		break;
		case 2:
			logIn();
			break;
			
		default :
			System.out.println("Please Choose valid option");
			break;
		}
		input.close();
		keyboard.close();
		
			
	}
	
	public static void signUp() {
		System.out.println("===============================================");
		System.out.println("*                                            *");
		System.out.println("** Welcome to Lockme.com Registration Page  **");
		System.out.println("*                                            *");
		System.out.println("===============================================");
		System.out.println("Enter Username: ");
		String username=keyboard.next();
		users.setUsername(username);
		
		System.out.println("Enter password: ");
		String password=keyboard.next();

		users.setPassword(password);
		output.println(users.getUsername());
		output.println(users.getPassword());
		
		System.out.println("You are registired successfully!!!!");
		output.close();
	}
	public static void logIn() {
		
		System.out.println("===============================================");
		System.out.println("*                                            *");
		System.out.println("**    Welcome to Lockme.com Login Page      **");
		System.out.println("*                                            *");
		System.out.println("===============================================");
		System.out.println("Enter Username: ");
		String inputUsername=keyboard.next();
		
		boolean found=false;
		while(input.hasNext() && !found) {
			if(input.next().equals(inputUsername))
			{
				System.out.println("Enter password: ");
				String inpPassword=keyboard.next();				
				if(input.next().equals(inpPassword)) {				
					System.out.println("Login Successful !!  200 OK");
					found=true;
					break;
				}
		}
				
	}
		if(!found)
		{
			System.out.println("User not found : Login Failure : 404");
		}
	
	}
	public static void welcomeScreen()
	{
		System.out.println("===============================================");
		System.out.println("*                                            *");
		System.out.println("**           Welcome to Lockme.com  :        **");
		System.out.println("**         Your personal Digital Locker      **");
		System.out.println("*                                            *");
		System.out.println("===============================================");
	
	}
	public static void initApp()
	{
		File dbfile=new File("database.txt");
		File lockerfile=new File("lockerfile.txt");
		
		try {
			//to read data from file
			input=new Scanner(dbfile);
			
			//to read data from keyboard
			keyboard=new Scanner(System.in);
			
			//output
			output=new PrintWriter(new FileWriter(dbfile,true));
			lockerOutput=new PrintWriter(new FileWriter(lockerfile,true));
			
			users=new Users();
			userCrdentials=new  UserCredentials();
			
		} catch (IOException e) {
						System.out.println("404 : File not found error");
		}
		
		
	}

}
