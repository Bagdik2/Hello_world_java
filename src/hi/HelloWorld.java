package hi;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class HelloWorld {

	public static void main(String[] args) {
		//Маппер, переиспользуемый во всей программе
        ObjectMapper mapper = new ObjectMapper();
        
        doPretty(mapper);

        String json0 = "{\"id\": 1, \"name\": \"Anna\", \"email\": \"anna@test.com\"}";
     // JSON с массивом — List<User>
        String jsonArray = "[{\"id\": 1, \"name\": \"Anna\"}, {\"id\": 2, \"name\": \"Ivan\"}]";

		User user = new User(1, "Anna", "anna@test.com");
		List<User> users = List.of(
		    new User(1, "Anna", "anna@test.com"),
		    new User(2, "Ivan", "ivan@test.com")
		);
        
		serialization(mapper, user);
		serializationPretty(mapper, user);
		serializationList(mapper, users);
		deserialization(mapper, json0);
		deserializationArray(mapper, jsonArray);
		deserializationMap(mapper, json0);
		
		String json = 
				 "{\"status\": \"success\",\"data\": { \"id\": 42, \"name\": \"Anna\" },\"meta\": { \"total\": 100, \"page\": 1 }}";
		nestedJSON(mapper, json);
		nestedJSON2(mapper, json);
		
	}
	
	public static void doPretty(@SuppressWarnings("exports") ObjectMapper mapper) {
        // Игнорировать неизвестные поля (очень полезно!)
        // Без этого — исключение если JSON содержит поле которого нет в классе
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Красивое форматирование по умолчанию
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	public static void doPrettyModern() {
        //Игнорирование пустых полей
        JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Красивое форматирование
        JsonMapper.builder().enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	public static void deserialization(@SuppressWarnings("exports") ObjectMapper mapper, String json) {
		System.out.println("___Десериализация___\n");
        // Строку JSON — объект User

        try {
        	User user = mapper.readValue(json, User.class);
        	System.out.println(user.getName()); // "Anna"
            System.out.println(user.getEmail());     // "anna@test.com"
		} catch (Exception e) {
			System.out.println("Caught an error, message:" + e.getMessage());
		}
       
	}
	
	public static void deserializationArray(@SuppressWarnings("exports") ObjectMapper mapper, String jsonArray) {
		System.out.println("___Десериализация Array___\n");
		try {
            
            List<User> users = mapper.readValue(jsonArray,
            		new TypeReference<List<User>>() {});
            System.out.println(users.size());        // 2
            System.out.println(users.get(0).getName()); // "Anna"
            
		} catch (Exception e) {
			System.out.println("Caught an error, message:" + e.getMessage());
		}
	}
	
	public static void deserializationMap(@SuppressWarnings("exports") ObjectMapper mapper, String json) {
		System.out.println("___Десериализация Map___\n");
		try {
            // JSON — Map (когда структура неизвестна заранее)
            Map<String, Object> map = mapper.readValue(json,
        		 new TypeReference<Map<String, Object>>() {});
            System.out.println(map.get("name"));
            System.out.println(map.get("id"));
         	        // 1 (Integer)
		} catch (Exception e) {
			System.out.println("Caught an error, message:" + e.getMessage());
		}
	}
	
	public static void serialization(@SuppressWarnings("exports") ObjectMapper mapper, User user) {
		// Объект — JSON строку
		System.out.println("___Сериализация___\n");
		try {
			String json = mapper.writeValueAsString(user);
			// {"id":1,"name":"Anna","email":"anna@test.com"}
			System.out.println(json);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void serializationPretty(@SuppressWarnings("exports") ObjectMapper mapper, User user) {
		System.out.println("___Сериализация карасивая___\n");
		try {
			// С красивым форматированием (для логов и отладки)
			String pretty = mapper.writerWithDefaultPrettyPrinter()
			    .writeValueAsString(user);
			// {
			//   "id" : 1,
			//   "name" : "Anna",
			//   "email" : "anna@test.com"
			// }

			// Список объектов — JSON
			System.out.println(pretty);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void serializationList(@SuppressWarnings("exports") ObjectMapper mapper, List<User> users) {
		System.out.println("___Сериализация список___\n");
		try {
			String jsonArray = mapper.writeValueAsString(users);
			System.out.println(jsonArray);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void nestedJSON(@SuppressWarnings("exports") ObjectMapper mapper, String json) {
		System.out.println("___Вложенный JSON v1___\n");
		try {
			ApiResponse response = mapper.readValue(json, ApiResponse.class);
			String status = response.getStatus();      // "success"
			String name   = response.getData().getName(); // "Anna"
			int total     = response.getMeta().getTotal();     // 100
			System.out.println("Status: " + status + "\nName: " + name + "\nTotal: " + total + "\n");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ошибка: " + e.getMessage());
		}

	} 
	
	public static void nestedJSON2(@SuppressWarnings("exports") ObjectMapper mapper, String json) {
		// Вариант 2 — через JsonNode (дерево, без POJO)
		System.out.println("___Вложенный JSON v2___\n");
		try {
			JsonNode root = mapper.readTree(json);
			String status = root.get("status").asText();           // "success"
			String name   = root.get("data").get("name").asText(); // "Anna"
			int total     = root.get("meta").get("total").asInt();  // 100
			System.out.println("Status: " + status + "\nName: " + name + "\nTotal: " + total + "\n");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
