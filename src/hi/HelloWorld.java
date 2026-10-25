package hi;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
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
		// Маппер, переиспользуемый во всей программе, заставляем его делать "красиво"
		doPretty(Json.MAPPER);

		System.out.println("\n___Задача1 : Практика — десериализация JSON___\n");
		TestUserDeserialization test = new TestUserDeserialization();

		try {
			test.testUserDeserialization();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("\n___Задача2 : Практика — сериализация запроса___\n");
		System.out.println(CreateUserRequest.buildRequestBody("Anna", "Engineer"));

		System.out.println("\n___Задача3 : Практика — JsonNode для вложенного JSON___\n");
		String nestedApiJson = "{\"data\": {\"id\": 2, \"email\": \"a@b.com\"}, \"support\": {\"url\": \"https://...\", \"text\": \"To keep...\"}}";
		System.out.println(nestedJSON(Json.MAPPER, nestedApiJson));

	}

	public static void doPretty(@SuppressWarnings("exports") ObjectMapper mapper) {
		// Игнорировать неизвестные поля (очень полезно!)
		// Без этого — исключение если JSON содержит поле которого нет в классе
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		// Красивое форматирование по умолчанию
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	public static void doPrettyModern() {
		// Игнорирование пустых полей
		JsonMapper.builder().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// Красивое форматирование
		JsonMapper.builder().enable(SerializationFeature.INDENT_OUTPUT);
	}

	public static String nestedJSON(@SuppressWarnings("exports") ObjectMapper mapper, String json) {

		try {
			JsonNode tree = mapper.readTree(json);

			int id = tree.path("data").path("id").asInt();
			String email = tree.path("data").path("email").asText();
			String url = tree.path("support").path("url").asText();

			return ("data.id (как int): " + id + "\ndata.email (как String):" + email + "\nsupport.url (как String): "
					+ url);

		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}

}
