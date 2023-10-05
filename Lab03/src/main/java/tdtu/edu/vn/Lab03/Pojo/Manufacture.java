package tdtu.edu.vn.Lab03.Pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
@Entity
@Table(name = "Manufacture")
public class Manufacture {
	@Id
	@Column(name = "id_man")
	private String id;
//	@Size(min=3,max=128)
	@Length(min = 3, max = 128)
	private String name;
	private String location;
	private int employee;
	@OneToMany(mappedBy = "manufacture")
	private List<Phone> phones;

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getEmployee() {
		return employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Manufacture [id=" + id + ", name=" + name + ", location=" + location + ", employee=" + employee + "]";
	}
}
