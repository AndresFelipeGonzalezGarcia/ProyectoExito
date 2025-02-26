package co.edu.unbosque.model.persistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.AlimentoDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class AlimentoDAO {

	private List<AlimentoDTO> products1;

	@PostConstruct
	public void init() {
		products1 = new ArrayList<>();
		products1.add(new AlimentoDTO(1000, "f230fh0g3", "Pata de Cerdo", "Carne de cerdo de alta calidad", "Cerdo.jpg",
				35000, "Carnes", 24, InventoryStatus.INSTOCK));
		products1.add(new AlimentoDTO(1001, "f230fh0g3", "Pata de Cerdo", "Carne de cerdo de alta calidad", "Cerdo.jpg", 72,
				"Carnes", 61, InventoryStatus.INSTOCK));
		products1.add(new AlimentoDTO(1002, "zz21cz3c1", "Leche", "deslactosada", "vaca.jpg", 79, "Lacteos", 2,
				InventoryStatus.LOWSTOCK));
		products1.add(new AlimentoDTO(1003, "244wgerg2", "Leche", "deslactosada", "vaca.jpg", 29, "Lacteos", 25,
				InventoryStatus.INSTOCK));
	}

	public List<AlimentoDTO> getProducts1() {
		return new ArrayList<>(products1);
	}

	public List<AlimentoDTO> getProducts1(int size) {

		if (size > products1.size()) {
			Random rand = new Random();

			List<AlimentoDTO> randomList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				int randomIndex = rand.nextInt(products1.size());
				randomList.add(products1.get(randomIndex));
			}

			return randomList;
		}

		else {
			return new ArrayList<>(products1.subList(0, size));
		}

	}
}