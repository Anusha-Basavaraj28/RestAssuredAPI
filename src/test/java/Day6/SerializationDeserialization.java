package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;





// POJO--> JSON  --->Serialize

// JSOM-->POJO  --> De-serialize

public class SerializationDeserialization {
	
	@Test
	void serialize() throws JsonProcessingException {
		Student studentPojo=new Student();  // Java object
		
		String courses[]= {"C","C++"};
		studentPojo.setName("Scott");
		studentPojo.setLocation("France");
		studentPojo.setPhone("1234567898");
		studentPojo.setCourses(courses);
		
		// convert java object to json object----- > serialization
		
		ObjectMapper objMapper=new ObjectMapper();
		
	String jsonData=	objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentPojo);
	
	System.out.println(jsonData);
		
	}
	
	@Test
	void deSerialize() throws JsonProcessingException {
		
		String jsonData="{\r\n"
				+ "  \"name\" : \"Scott\",\r\n"
				+ "  \"location\" : \"France\",\r\n"
				+ "  \"phone\" : \"1234567898\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";
		
		// convert  JSON object to JAVA object----- > De-Serialization
		ObjectMapper objMapper=new ObjectMapper();
		
		Student stu=objMapper.readValue(jsonData, Student.class);
		
		System.out.println(stu.getName());
		
		System.out.println(stu.getLocation());
		
		System.out.println(stu.getPhone());
		
		System.out.println(stu.getCourses()[0]);
		
		System.out.println(stu.getCourses()[1]);
		
		
		
	}

}
