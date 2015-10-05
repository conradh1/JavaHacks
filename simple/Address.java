// Comp 308 assignment 1 question 4
//Conrad Holmberg
// id# 9403987
//This program creates three address objects from the class Address and displays them.

import java.io.*;

public class Address {
	
	private String First_Name, Last_Name, Home_Address, City, State, Zip;

	public Address() throws IOException {
		//constructor creates address
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the First Name of the person.");
		this.First_Name= in.readLine();
		System.out.println("Enter the LastName of the person.");
		this.Last_Name= in.readLine();
		System.out.println("Enter the Apartment number or street address of the person.");
		this.Home_Address= in.readLine();
		System.out.println("Enter the city.");
		this.City= in.readLine();
		System.out.println("Enter the state.");
		this.State= in.readLine();
		System.out.println("Enter the Zip Code.");
		this.Zip= in.readLine();
		System.out.println("Address created.");
	}//Address constructor

	public String toString() {
		//Create string for printing full address
		String FullAddress= new String ("******************\n" +"Full Name: " +First_Name +" " +Last_Name +"\nAddress: " +Home_Address +"\nCity: " +City +"\nState: " +State +"\nZip Code: " +Zip +"\n");

		return FullAddress; 	
	}//toString
	
	public void printAddress() {
		String Add= toString();
		System.out.println(Add);
	}//printAddress

	public static void main(String[] args) {
		try {
			Address Index[]= {	
									//creates three new addresses
									new Address(), 
									new Address(), 
									new Address(),
			};
			//print out addresses
			for (int i= 0; i < Index.length; i++) Index[i].printAddress();
		}//try

		catch(Exception E) { 
			//do nothing
		}//catch
	}//main
	
}//Address