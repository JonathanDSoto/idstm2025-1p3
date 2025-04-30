package controllers;

import org.json.simple.JSONArray;

import models.ProducModel;
import views.ProductView;

public class ProductController {

	public ProductView view;
	
	public ProductController() {
		
		view = new ProductView();
	}
	
	public void products() {
		
		ProducModel pm = new ProducModel();
		JSONArray data = pm.get();
		
		view.products(data);
		
	}
	
	

}
