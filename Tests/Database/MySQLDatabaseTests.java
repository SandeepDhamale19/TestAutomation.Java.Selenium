package Database;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import DataFactory.ListFunction;
import DatabaseFactory.DatabaseFunction;

public class MySQLDatabaseTests {

	//static final String DB_URL = "jdbc:h2:file:///C:/Users/sande/eclipse-workspace/TestAutomation.Selenium.Basics/Files/Database";
		static final String DB_URL = "jdbc:mysql://localhost/AvengersDatabase";
		static final String JDBC_Driver = "com.mysql.cj.jdbc.Driver";
		static final String USERNAME = "root";
		static final String PASSWORD = "password"; // You know it
		
		@Test
		   public void GetAvengerName_MySQLDB() throws Exception {
			   String query = "SELECT First_Name FROM Avengers_Characters_Info WHERE Character_Name = 'Captain America'";
			   List<Map<String, Object>> resultSet = DatabaseFunction.ExecuteQuery(JDBC_Driver, DB_URL, USERNAME, PASSWORD, query);
			   
			   // Method 1
			   String avengerName = resultSet.stream()
			            .filter(m -> m.containsKey("First_Name"))
			            .map(m -> m.get("First_Name"))
			            .findFirst().orElse("").toString();
			   
			   Assert.assertEquals("Steven", avengerName);
			   
			   // Method 2
			   avengerName = resultSet.stream().flatMap(map->map.entrySet().stream().filter(entry->entry.getKey().equals("First_Name"))).findFirst()
			   .orElse(new AbstractMap.SimpleEntry("First_Name", "")).getValue().toString();
			   Assert.assertEquals("Steven", avengerName);
			   
			   // Method 3
			   avengerName = ListFunction.GetKeyValueFromHashMap(resultSet, "First_Name").toString();
			   Assert.assertEquals("Steven", avengerName);
		   }
}
