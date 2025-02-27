package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.RopaDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class JugueteDAO implements CRUDOperation<JugueteDTO> {

	private List<JugueteDTO> products;

	@PostConstruct
	public void init() {
		products = new ArrayList<>();
		products.add(
				new JugueteDTO("f230fh0g3", "Barbie", "Muñeca Barbie Dream Besties Brooklyn", 169900, "Niñas", 24));
		products.add(new JugueteDTO("nvklal433", "MaxSteel", "Muñeco de Mattel", 100000, "Niños", 61));
		products.add(
				new JugueteDTO("zz21cz3c1", "Perrito Aprende Conmigo", "Peluche de Fisher Price", 80000, "Bebés", 2));
		products.add(new JugueteDTO("244wgerg2", "Uno", "Juego de cartas", 48950, "Juegos de Mesa", 25));
		products.add(new JugueteDTO("1a2b3c4d5", "Monopoly", "Juego de mesa clásico", 120000, "Juegos de Mesa", 18));
		products.add(new JugueteDTO("9x8y7z6w5", "Ajedrez", "Juego de estrategia y concentración", 45000,
				"Juegos de Mesa", 30));
		products.add(
				new JugueteDTO("qwerty123", "Lego City", "Set de construcción Lego de ciudad", 150000, "Niños", 12));
		products.add(new JugueteDTO("7abcde6f5", "Masha y el Oso", "Juguete de peluche de Masha", 35000, "Niñas", 40));
		products.add(
				new JugueteDTO("zxy987654", "Scrabble", "Juego de palabras y letras", 70000, "Juegos de Mesa", 22));
		products.add(
				new JugueteDTO("abcd1234e", "Peluche Dinosaurio", "Peluche suave de dinosaurio", 42000, "Bebés", 50));
		products.add(new JugueteDTO("xy1234z56", "Puzzles 3D", "Rompecabezas en 3D para mayores de 12 años", 80000,
				"Juegos de Mesa", 15));
	}

	public List<JugueteDTO> getProducts() {
		return new ArrayList<>(products);
	}

	public List<JugueteDTO> getProducts(int size) {

		if (size > products.size()) {
			Random rand = new Random();

			List<JugueteDTO> randomList = new ArrayList<>();
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

	public void saveProduct(JugueteDTO a) {
		if (a.getCode() == null) {
			a.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
			products.add(a);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
		}

		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteProduct(JugueteDTO a) {
		products.remove(a);
		a = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteSelectedProducts(List<JugueteDTO> a) {
		products.removeAll(a);
		a = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}
}