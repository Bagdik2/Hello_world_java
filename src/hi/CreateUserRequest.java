package hi;

import javax.management.RuntimeErrorException;

public class CreateUserRequest {
	
	private String name;
	private String job;
	
	public CreateUserRequest() { }
	
	public CreateUserRequest(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
	public static String buildRequestBody(String name, String job) {
		try {
			CreateUserRequest request = new CreateUserRequest(name, job);
			return Json.MAPPER.writeValueAsString(request);
			
		} catch (Exception e) {
			throw new RuntimeException("Ошибка сериализации CreateUserRequest:\n", e);
		}
		return null;
	}
}
