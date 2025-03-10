package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.List;

public class JugueteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String name;
	private String description;
	private double price;
	private String category;
	private int quantity;
	private List<Order> orders;

	public JugueteDTO() {
	}

	public JugueteDTO(String code, String name, String description, double price, String category, int quantity) {
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}

	@Override
	public JugueteDTO clone() {
		return new JugueteDTO(getCode(), getName(), getDescription(), getPrice(), getCategory(), getQuantity());
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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
		JugueteDTO other = (JugueteDTO) obj;
		if (code == null) {
			return other.code == null;
		} else {
			return code.equals(other.code);
		}
	}

}