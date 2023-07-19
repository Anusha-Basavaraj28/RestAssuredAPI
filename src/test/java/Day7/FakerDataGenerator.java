package Day7;

import java.util.Locale;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {
	
	// https://github.com/DiUS/java-faker
	@Test
	void testgenerateDummyData() {
		
		Faker faker=new Faker(new Locale("en-IND"));
		
	String fullName=	faker.name().fullName();
	
	String firstName=faker.name().firstName();
	
	String lastName=faker.name().lastName();
	
	String userName=faker.name().username();
	
	String email=faker.internet().emailAddress();
	String pwd=faker.internet().password();
	
	String phoneNum=faker.phoneNumber().cellPhone();
	
	
	System.out.println(fullName);
	
	System.out.println(firstName);
	System.out.println(lastName);
	System.out.println(userName);
	System.out.println(email);
	System.out.println(pwd);
	System.out.println(phoneNum);
	
	
		
	}

}
