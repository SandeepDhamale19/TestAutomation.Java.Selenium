package Database;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataFactory.ListFunction;
import DatabaseFactory.*;

public class H2DatabaseTests {

	//static final String DB_URL = "jdbc:h2:file:///C:/Users/sande/eclipse-workspace/TestAutomation.Selenium.Basics/Files/Database";
	static final String DB_URL = "jdbc:h2:./Files/Database";
	static final String JDBC_Driver = "org.h2.Driver";
	static final String USERNAME = "sa";
	static final String PASSWORD = "";
	
	@Test
	   public void GetAvengerName_H2DB() throws Exception {
		   String query = "SELECT First_Name FROM Avengers_Characters_Info WHERE Character_Name = 'Captain America'";
		   List<Map<String, Object>> resultSet = DatabaseFunction.ExecuteQuery(JDBC_Driver, DB_URL, USERNAME, PASSWORD, query);
		   
		   // Method 1
		   String avengerName = resultSet.stream()
		            .filter(m -> m.containsKey("FIRST_NAME"))
		            .map(m -> m.get("FIRST_NAME"))
		            .findFirst().orElse("").toString();
		   
		   Assert.assertEquals("Steven", avengerName);
		   
		   // Method 2
		   avengerName = resultSet.stream().flatMap(map->map.entrySet().stream().filter(entry->entry.getKey().equals("FIRST_NAME"))).findFirst()
		   .orElse(new AbstractMap.SimpleEntry("FIRST_NAME", "")).getValue().toString();
		   Assert.assertEquals("Steven", avengerName);
		   
		   // Method 3
		   avengerName = ListFunction.GetKeyValueFromHashMap(resultSet, "FIRST_NAME").toString();
		   Assert.assertEquals("Steven", avengerName);
	   }
}
