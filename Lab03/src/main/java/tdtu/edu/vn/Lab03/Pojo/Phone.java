package tdtu.edu.vn.Lab03.Pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "MobilePhone")
public class Phone {
	@Id
	private String id;
	@Column(nullable = false)
//	@Size(min=3,max=128)
	@Length(min = 3, max = 128)
	private String name;
	@Column(nullable = false)
	private int price;
	@Column(nullable = false)
	private String color;
	@Column(nullable = true)
	private String country;
	private int quantity;
	@JoinColumn(name = "id_man")
	@ManyToOne
	private Manufacture manufacture;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Phone(String id, @Length(min = 3, max = 128) String name, int price, String color, String country,
			int quantity, Manufacture manufacture) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
		this.country = country;
		this.quantity = quantity;
		this.manufacture = manufacture;
	}

	public Phone() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public Manufacture getManufacture() {
		return manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", name=" + name + ", price=" + price + ", color=" + color + ", country=" + country
				+ ", quantity=" + quantity + "]";
	}
}
