package webbati.web.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "car")
@SessionScoped
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String model;
	private int year;
	private String manufacturer;
	private String color;
	private int price;
	private String name;
	private java.lang.Integer actId;

	public void setActId(java.lang.Integer actId) {
		this.actId = actId;
	}

	public java.lang.Integer getActId() {
		return actId;
	}

	public void setName(String name) {
		this.name = name;

	}

	public String getName() {
		return name;
	}

	public Car() {

	}

	public Car(String model, int year, String manufacturer, String color) {
		this(model, year, manufacturer, color, 0);

	}

	public Car(String model, int year, String manufacturer, String color, int price) {
		this.model = model;
		this.year = year;
		this.manufacturer = manufacturer;
		this.color = color;
		this.price = price;
		actId = new Integer(12);
		name = "tyty";
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Car)) {
			return false;
		}

		Car compare = (Car) obj;

		return compare.model.equals(this.model);
	}

	@Override
	public int hashCode() {
		int hash = 1;

		return hash * 31 + model.hashCode();
	}

	@Override
	public String toString() {
		return "Car{" + "model=" + model + ", year=" + year + ", manufacturer=" + manufacturer + ", color=" + color + ", price=" + price + '}';
	}
}