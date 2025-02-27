package co.edu.unbosque.model.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.AlimentoDTO;
import co.edu.unbosque.model.JugueteDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class AlimentoDAO implements CRUDOperation<AlimentoDTO> {

	private List<AlimentoDTO> products1;

	@PostConstruct
	public void init() {
		products1 = new ArrayList<>();
		products1.add(new AlimentoDTO("f230fh0g3", "tilapia", "pescado de buena calidad", 9950, "Carnes", 24));
		products1.add(
				new AlimentoDTO("793e5e2af", "Lomo de Cerdo", "Carne de cerdo de alta calidad", 39200, "Carnes", 61));
		products1.add(new AlimentoDTO("zz21cz3c1", "Leche", "alqueria deslactosada", 15780, "Lacteos", 2));
		products1.add(new AlimentoDTO("ff24196d2", "Bon Yurt", "deslactosada", 9480, "Lacteos", 200));
		products1.add(new AlimentoDTO("fgh123abc", "Pechuga de Pollo",
				"Pechuga de pollo fresca, ideal para cocinar a la plancha", 22000, "Carnes", 50));
		products1.add(new AlimentoDTO("xyz987mno", "Chuletas de Cerdo",
				"Chuletas de cerdo frescas, perfectas para parrillada", 35000, "Carnes", 40));
		products1.add(new AlimentoDTO("abc456def", "Carne Molida de Res",
				"Carne molida de res 100% fresca, ideal para hamburguesas", 28000, "Carnes", 60));
		products1.add(new AlimentoDTO("qwert1234z", "Leche Entera", "Leche fresca de vaca, perfecta para el desayuno",
				4500, "Lácteos", 100));
		products1.add(new AlimentoDTO("zxy890wvu", "Queso Fresco",
				"Queso fresco cremoso, ideal para sandwiches y ensaladas", 18000, "Lácteos", 80));
		products1.add(new AlimentoDTO("jkl345mno", "Yogur Natural",
				"Yogur natural sin azúcar, ideal para una dieta balanceada", 6000, "Lácteos", 75));
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

	public void saveProduct(AlimentoDTO a) {
		if (a.getCode() == null) {
			a.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
			products1.add(a);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
		}

		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteProduct(AlimentoDTO a) {
		products1.remove(a);
		a = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteSelectedProducts(List<AlimentoDTO> a) {
		products1.removeAll(a);
		a = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}

}