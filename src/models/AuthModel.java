package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import views.AuthView;

public class AuthModel {

	public AuthModel() {
		
	}
	
	public boolean access(String u, String p){
		
		
		try { 
			
			String url = AuthModel.class.getResource("/files/users.txt").getPath();
			FileReader fileReader = new FileReader(url);
			
			int i;

            while ((i = fileReader.read()) != -1) {
                System.out.print((char)i);
                
                // convertir el row en String 
                // el string cortarlo con Split 
                // comparar con el arreglo en la pos 1,2
                
                if(u.equals("fake@mail.com") ) {
        			if(p.equals("12345")) { 
        				return true;  
        			}
        		}
            } 
       
            fileReader.close();
            
            return false;
		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("error"); 
		}
		
		return false;
		 
	}
}
