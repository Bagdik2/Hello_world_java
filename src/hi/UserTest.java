package hi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

	/** Заглушка «сервера», которая возвращает ответ как реальный API. */
	private String sendPost(String path, String requestJson) {
		// Здесь в реальном проекте — REST Assured / HttpClient.
		// Для учебного теста — просто отдаём фиксированный ответ.
		return "{\"id\": 42, \"name\": \"Anna\", \"email\": \"anna@test.com\"}";
	}

	@Test
	void testCreateUser() throws Exception {
		// 1. Подготовить тело запроса
		User requestBody = new User();
		requestBody.setName("Anna");
		requestBody.setEmail("anna@test.com");

		String requestJson = Json.MAPPER.writeValueAsString(requestBody);

		// 2. Отправить запрос (в учебном варианте — заглушка)
		String responseJson = sendPost("/api/users", requestJson);

		// 3. Десериализовать ответ
		User createdUser = Json.MAPPER.readValue(responseJson, User.class);

		// 4. Проверки
		assertTrue(createdUser.getId() > 0, "ID должен быть присвоен");
		assertEquals("Anna", createdUser.getName(), "Имя совпадает");
		assertEquals("anna@test.com", createdUser.getEmail(), "Email совпадает");
	}
}
