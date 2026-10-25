package hi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestUserDeserialization {

	private String testString = "{\"id\": 2, \"name\": \"faye\", \"email\": {\"email\": \"faye@reqres.in\"}}";

	@Test
	void testUserDeserialization() throws Exception {

		User createdUser = Json.MAPPER.readValue(testString, User.class);

		assertAll("Поля User после десериализации", 
				() -> assertEquals(2, createdUser.getId()),
				() -> assertEquals("faye", createdUser.getName()),
				() -> assertEquals("faye@reqres.in", createdUser.getEmail()));

		assertTrue(createdUser.getId() == 2, "ID совпадает");

		assertEquals("faye", createdUser.getName(), "Имя совпадает");

		// fail("Not yet implemented");
	}

}
