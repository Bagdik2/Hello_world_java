package hi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

// Модель для JSON:
// { "id": 1, "first_name": "Anna", "email": "a@test.com" }
public class User {
    private int id;

    // @JsonProperty — если имя поля JSON не совпадает с именем поля Java
    @JsonProperty("name")
    private String name;

    private String email;

    // @JsonIgnore — не включать поле в JSON при сериализации
    @JsonIgnore
    private String password;

    // Jackson требует конструктор без параметров (или @JsonCreator)
    public User() { }

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Геттеры и сеттеры — обязательны для Jackson!
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String fn) { this.name = fn; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    @JsonProperty("email")
    public void setEmailFromAny(Object email) {
        if (email == null) {
            return;
        }
        if (email instanceof String s) {
            this.email = s;
        } else if (email instanceof Map<?, ?> map) {
            Object inner = map.get("email");
            if (inner != null) {
                this.email = inner.toString();
            }
        } else {
            // на всякий случай — если прилетит число или boolean
            this.email = email.toString();
        }
    }
    
    @Override
    public String toString() {
    	return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    	} 
}
