package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import co.edu.unbosque.model.RopaDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class RopaDAO {

	private List<RopaDTO> products;

	@PostConstruct
	public void init() {
		products = new ArrayList<>();
		products.add(new RopaDTO("fgh123abc", "Camiseta Básica", "Camiseta de algodón, ideal para el día a día", 35000,
				"M", 45));
		products.add(
				new RopaDTO("xyt987jkl", "Jean Slim Fit", "Jean de corte ajustado, cómodo y moderno", 90000, "L", 30));
		products.add(new RopaDTO("abc456def", "Chaqueta de Cuero", "Chaqueta de cuero sintético para invierno", 180000,
				"XL", 20));
		products.add(new RopaDTO("qwert1234z", "Sudadera con Capucha", "Sudadera suave y cálida con capucha", 75000,
				"S", 25));
		products.add(
				new RopaDTO("zxy890wvu", "Pantalón Deportivo", "Pantalón cómodo para hacer deporte", 50000, "M", 35));
		products.add(
				new RopaDTO("jkl345mno", "Blusa Elegante", "Blusa de seda para ocasiones especiales", 95000, "S", 15));
		products.add(new RopaDTO("lmn678opq", "Vestido de Verano", "Vestido ligero y fresco, ideal para el calor",
				120000, "L", 40));
		products.add(new RopaDTO("abc123xyz", "Camisa de Manga Larga",
				"Camisa de manga larga de algodón, ideal para oficina", 85000, "M", 28));
		products.add(new RopaDTO("opq456rst", "Pantalón Cargo", "Pantalón cómodo y práctico con múltiples bolsillos",
				110000, "L", 18));
		products.add(new RopaDTO("uvw789ghi", "Falda Midi", "Falda midi de tela fluida, perfecta para el verano", 65000,
				"S", 22));
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