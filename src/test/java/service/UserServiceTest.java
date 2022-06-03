package service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import model.User;

public class UserServiceTest {
	
	public UserService userService;
	public String firstName;
	public String lastName;
	public String email;
	public String password;
	public String repeatPassword; 
	
	@BeforeEach
	public void init() {
		userService = new UserServiceImpl();
		firstName = "Antoni";
		lastName = "Kurniawan";
		email = "antoni@gmail.com";
		password = "rahasia";
		repeatPassword = "rahasia";
	}
	
	//green test / positive test
	@DisplayName("User object is created")
	@Test
//	@Timeout(value = 5, unit = TimeUnit.MILLISECONDS)
	public void testCreateUser_WhenDetailIsProvided_ReturnUserObject() {
		//Arrange
		
		//Act
		User user = userService.createUser(firstName, lastName, email, password, repeatPassword);
		
		EmailService emails = new UserServiceImpl();
		emails.sendEmail();
		System.out.println(user.getId());
		
		assertTimeout(Duration.ofMillis(500), ()->{
			try {
				Thread.sleep(600);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		});
		
		//Assert
		assertNotNull(user, "if create user success should not return null");
		assertEquals(firstName, user.getFirstName(), "User first name is incorrect");
		assertEquals(lastName, user.getLastName(), "User last name is incorrect");
		assertEquals(email, user.getEmail(), "User email is incorrect");
		assertNotNull(user.getId(), "User id cannot pulls");
		
		
	}
	
	//Red Test/Negative Test
	@DisplayName("Empty first name cause exception")
	@Test
	public void testCreateUser_WhenFirstNameIsEmpty_ThrowsIllegalException() {
		//Arrange
		firstName = "";
		
		String expectedExceptionMessage = "User first name is empty";
		
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
			userService.createUser(firstName, lastName, email, password, repeatPassword);
		}, "Empty first name cause illegal Argument Exception");
		
		//Assert
		assertEquals(expectedExceptionMessage, thrown.getMessage());
		
	}
	
	//Red Test/Negative Test
	@DisplayName("Empty Last name cause exception")
	@Test
	public void testCreateUser_WhenLastNameIsEmpty_ThrowsIllegalException() {
		//Arrange
		lastName = "";
		
		String expectedExceptionMessage = "User last name is empty";
		
		//Act
		IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, ()->{
			userService.createUser(firstName, lastName, email, password, repeatPassword);
		}, "Empty last name cause illegal Argument Exception");
		
		//Assert
		assertEquals(expectedExceptionMessage, thrown.getMessage());
	}
	
	
}
