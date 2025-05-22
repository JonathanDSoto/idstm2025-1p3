package models;

import java.io.FileNotFoundException;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.Reader;

public class ProducModel {

	public ProducModel() {
		
	}
	
	public JSONArray get()
	{
		
		JSONParser jsonParser = new JSONParser();
		String url = AuthModel.class.getResource("/files/products.json").getPath();
        
        try (FileReader reader = new FileReader(url))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
  
            JSONArray productList = (JSONArray) obj;
            System.out.println(productList);
              
            return productList;
           
            
            //Iterate over  array
           // productList.forEach( emp -> parseTestData( (JSONObject) emp ) );
  
        } catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } catch (IOException e) 
        {
            e.printStackTrace();
        } catch (ParseException e) 
        {
            e.printStackTrace();
        }
	
        
        return null;
		
	}
	
	public void remove()
	{
		
		JSONArray productList = get();
		
		String url = AuthModel.class.getResource("/files/products.json").getPath();
        
		 productList.remove(0); 
         
         System.out.println(productList); 
         
         // Write the JSON array to a file
         try (FileWriter file = new FileWriter(url)) {
             file.write(productList.toString()); // Use toString(2) for pretty printing
             file.flush();
             file.close();
             System.out.println("JSON array written to file successfully!");
         } catch (IOException e) {
             e.printStackTrace();
         }
	}
	
	public boolean addProduct(String n, String a, String b, double p)
	{
		
		JSONArray productList = get();
		JSONObject jsonObject = new JSONObject();
		
		String url = AuthModel.class.getResource("/files/products.json").getPath();
		
		
		jsonObject.put("name", n);
		jsonObject.put("title", n);
		
		productList.add(jsonObject);
		
		try (FileWriter file = new FileWriter(url)) {
            file.write(productList.toString()); // Use toString(2) for pretty printing
            file.flush();
            file.close();
            System.out.println("JSON array written to file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		return false;
	}
	
	private static void parseTestData(JSONObject product)
    {
		
		// Obtener valores directamente del objeto producto
	    String title = (String) product.get("title");   
	    System.out.println("Title: " + title);
	      
	    String description = (String) product.get("description");   
	    System.out.println("Description: " + description);
	      
	    String category = (String) product.get("category"); 
	    System.out.println("Category: " + category); 
	    
    }
}
