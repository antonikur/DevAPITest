package service;


import java.util.UUID;

import Util.java.File;
import Util.java.SendMail;
import model.User;

public class UserServiceImpl implements UserService, EmailService {
	
	public User createUser(String firstName, String lastName, String email, String password, String repeatPassword) {
		// TODO Auto-generated method stub
		if(firstName == null || firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("User first name is empty");
		}
		
		if(lastName == null || lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("User last name is empty");
		}
		
		return new User(firstName, lastName, email, UUID.randomUUID().toString());
	}
	
	public void test() {
		
	}
	
	@Override
	public void addAttachment() {
		// TODO Auto-generated method stub
		File file = new File();
		file.createAttachment();
		System.out.println("Add Attachment");
	}
	
	@Override
	public void sendEmail() {
		// TODO Auto-generated method stub
		SendMail mail = new SendMail();
		mail.createMail();
		System.out.println("Send Email");
	}
}
