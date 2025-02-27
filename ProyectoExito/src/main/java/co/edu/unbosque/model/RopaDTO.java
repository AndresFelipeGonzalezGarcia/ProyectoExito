package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.List;

public class RopaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String description;
	private double price;
	private String talla;
	private int quantity;
	private List<Order> orders;

	public RopaDTO() {
	}

	public RopaDTO(String code, String name, String description, double price, String talla, int quantity) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.talla = talla;
		this.quantity = quantity;
	}

	@Override
	public RopaDTO clone() {
		return new RopaDTO(getCode(), getName(), getDescription(), getPrice(), getTalla(), getQuantity());
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RopaDTO other = (RopaDTO) obj;
		if (code == null) {
			return other.code == null;
		} else {
			return code.equals(other.code);
		}
	}

}