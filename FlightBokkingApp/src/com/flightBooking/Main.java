package com.flightBooking;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println("Welcome to mmt-clone");
		Scanner sc = new Scanner(System.in);
		char resp;
		LoginResponse obj = null;
		
		do {
		System.out.println("Select option");
		System.out.println("1.Registration    2.Login");
		int option = sc.nextInt();
		
		switch(option) {
		case 1: User.registration(sc);
		case 2: obj = User.Login(sc);
		        break;
		        
		default: System.out.println("Invalid option");
		}
		
		if(obj!=null) {
		if(obj.isStatus()) {
			System.out.println("Login succesfull");
		}else {
			System.out.println("login failed..");
		}
		}
		
		System.out.println("Do you want to continue? y/n");
		resp = sc.next().charAt(0);
		
		}while(resp=='y');
		
		System.out.println("Thanks for using mmt-clone");
		
	}

}