package model;

import java.util.ArrayList;
import java.util.List;

public class KamerVerhuur {

	private final List<User> users;
	private final List<Kamer> kamers;
	
	public KamerVerhuur(){
		users = new ArrayList<>();
		kamers = new ArrayList<>();
	}
	
	public void addUser(User user){
		users.add(user);
	}
	
	public void addKamer(Kamer kamer){
		kamers.add(kamer);
	}
	
	public User getUser(String username,String password){
		for(User user: users){
			if(user.getUsername().toLowerCase().equals(username.toLowerCase())
					&& user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
	
	public boolean userExists(String username){
		for(User u : users){
			if (u.getUsername().equals(username)){
				return true;
			}
		}
		return false;
	}
	
	public List<Kamer> getKamers(){
		return kamers;
	}
	
	public List<User> getUsers(){
		return users;
	}
	
}
