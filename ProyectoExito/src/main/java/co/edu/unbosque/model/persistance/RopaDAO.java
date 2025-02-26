package co.edu.unbosque.model.persistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.RopaDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class RopaDAO {

	@Inject
	RopaDTO ropa;

	private List<RopaDTO> products;

	@PostConstruct
	public void init() {
		products = new ArrayList<>();
		products.add(new RopaDTO(1000, "f230fh0g3", "Camiseta Polo", "camiseta con cuello color verde", "Polo.jpg",
				35000, "XL", "In Stock", InventoryStatus.INSTOCK));
		products.add(new RopaDTO(1000, "f230fh0g3", "Camiseta Polo", "camiseta con cuello color verde", "Polo.jpg",
				35000, "XL", "In Stock", InventoryStatus.INSTOCK));
		products.add(new RopaDTO(1002, "zz21cz3c1", "vestido Zara", "vestido de una pieza color rojo", "vestido.jpg",
				79, "S", "Low Stock", InventoryStatus.LOWSTOCK));
		products.add(new RopaDTO(1002, "zz21cz3c1", "vestido Zara", "vestido de una pieza color rojo", "vestido.jpg",
				79, "S", "Low Stock ", InventoryStatus.LOWSTOCK));
	}

	public String inLowStock() {
		int a = Integer.parseInt(ropa.getQuantity());
		if (a > 0) {
			return "In Stock";
		} else {
			return "Low stock";
		}
	}

	public List<RopaDTO> getProducts() {
		return new ArrayList<>(products);
	}

	public List<RopaDTO> getProducts(int size) {

		if (size > products.size()) {
			Random rand = new Random();

			List<RopaDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(products.size());
				randomList.add(products.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(products.subList(0, size));
		}

	}
}