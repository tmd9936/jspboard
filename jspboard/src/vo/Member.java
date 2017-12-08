package vo;

public class Member {
	private String id;
	private String password;
	private String name;
	private String phone;
	private String address;
	
	public Member() {
	}

	public Member(String id, String password, String name, String phone, String address) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", phone=" + phone + ", address="
				+ address + "]";
	}
	
	
}
