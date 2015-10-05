/********************************************************************
* This program takes in a user input to create a secretkey.  The program
* encrypts a user input message and displays the encrypted code.  Lastly 
* the user is prompted for a decryption key.  If the key is the same as
* the encryption key the message is properly decrypted.
*
* Author: Roger Lee
* Organization: Athabasca University
* Date: August 18, 2003
*********************************************************************/
import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;

public class EncryptionExample {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        //get user inputted key 
        byte[] userkey = null;
        do
        { 
              System.out.println("Please enter a 8 character string to generate a Secret Key");
              userkey = (in.readLine()).getBytes();
        } while (userkey.length != 8); 

        //create Key Generator instance and generate a secret key
        KeyGenerator kgen = KeyGenerator.getInstance("DES");
        SecretKey skey = kgen.generateKey();
        
        byte[] key = userkey;
        //Create a Secret Key based on characters entered by the user
        SecretKeySpec skeyspec = new SecretKeySpec(key, "DES");
       
        //Create a cipher to encrypt with
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
        
        //Get message
        System.out.println("Please enter a string to encrypt");
        byte[] userstring = null;
        userstring = (in.readLine()).getBytes();
         
        //Encrypt message with cipher
        byte[] encrypted = cipher.doFinal(userstring);
        String enc_string = new String(encrypted);
        System.out.println("The String is encrypted as " + enc_string);

        byte[] userdecrypt = null;
        byte[] decrypted = null;
        
        //Get user decrypt key
        do
	{
        	System.out.println("Please enter the 8 character key to decrypt the message");
        	userdecrypt = (in.readLine()).getBytes();
        } while (userdecrypt.length != 8);
           
        //Reinitialize Secret Key and Cipher
        key = userdecrypt;
        SecretKeySpec decryptkey = new SecretKeySpec(key, "DES");
        cipher.init(Cipher.DECRYPT_MODE, decryptkey);

        //Decrypt message
        decrypted = cipher.doFinal(encrypted);
        
        if ((new String(decrypted)).equals(new String(userstring)))
             System.out.println("\nMessage decrypted as: " + (new String(decrypted)));
        else 
             System.out.println("\nMessage was not decrypted");
    }
}

