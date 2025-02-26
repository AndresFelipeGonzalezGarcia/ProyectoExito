package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.List;

public class RopaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String code;
	private String name;
	private String description;
	private String image;
	private double price;
	private String talla;
	private String quantity;
	private InventoryStatus inventoryStatus;
	private List<Order> orders;

	public RopaDTO() {
	}

	public RopaDTO(int id, String code, String name, String description, String image, double price, String talla,
			String quantity, InventoryStatus inventoryStatus) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.description = description;
		this.image = image;
		this.price = price;
		this.talla = talla;
		this.quantity = quantity;
		this.inventoryStatus = inventoryStatus;
	}

	@Override
	public RopaDTO clone() {
		return new RopaDTO(getId(), getCode(), getName(), getDescription(), getImage(), getPrice(), getTalla(),
				getQuantity(), getInventoryStatus());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public InventoryStatus getInventoryStatus() {
		return inventoryStatus;
	}

	public void setInventoryStatus(InventoryStatus inventoryStatus) {
		this.inventoryStatus = inventoryStatus;
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