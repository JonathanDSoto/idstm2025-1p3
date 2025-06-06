package controllers;

import java.util.ArrayList;

import org.json.simple.JSONArray;

import models.ProducModel;
import models.User;
import models.UserModel;
import views.UserView;

public class UserController {

	private UserView vista;
	
	public UserController() {
		
		vista = new UserView();
	}
	
	public void users()
	{
		
		UserModel um = new UserModel();
		ArrayList<User> users = um.get();
		
		vista.showUsers(users);
		
	}
	
	public void add()
	{
		vista.showFormAdd();
	}
	
	public void update(User userToUpdate)
	{
		vista.showFormUpdate(userToUpdate);
	}

}
