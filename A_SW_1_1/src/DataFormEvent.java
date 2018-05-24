import java.util.EventObject;

public class DataFormEvent extends EventObject {
	
	private String name;
	private String city;
	private String mail;

	public DataFormEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public DataFormEvent(Object source, String name, String city, String mail) {
		super(source);
		this.name = name;
		this.city = city;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
