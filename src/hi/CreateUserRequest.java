package hi;

public class CreateUserRequest {
	
	private String name;
	private String job;
	
	public CreateUserRequest() { }
	
	public CreateUserRequest(String name, String job) {
		this.name = name;
		this.job = job;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public static String buildRequestBody(String name, String job) {
		try {
			CreateUserRequest request = new CreateUserRequest(name, job);
			String returnJson = Json.MAPPER.writeValueAsString(request);
			return returnJson;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public String toString() {
		return "CreateUserRequest{name='" + name + "', job='" + job + "'}";
	}
}
