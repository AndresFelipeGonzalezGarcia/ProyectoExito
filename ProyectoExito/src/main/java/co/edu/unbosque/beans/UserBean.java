package co.edu.unbosque.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.primefaces.PrimeFaces;

import co.edu.unbosque.model.AlimentoDTO;
import co.edu.unbosque.model.JugueteDTO;
import co.edu.unbosque.model.RopaDTO;
import co.edu.unbosque.model.persistence.AlimentoDAO;
import co.edu.unbosque.model.persistence.JugueteDAO;
import co.edu.unbosque.model.persistence.RopaDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("UserBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	// lista juguetes
	private List<JugueteDTO> products;
	private JugueteDTO selectedProduct;
	private List<JugueteDTO> selectedProducts;

	// lista alimentos
	private List<AlimentoDTO> products1;
	private AlimentoDTO selectedProduct1;
	private List<AlimentoDTO> selectedProducts1;

	// lista alimentos
	private List<RopaDTO> products2;
	private RopaDTO selectedProduct2;
	private List<RopaDTO> selectedProducts2;

	@Inject
	private JugueteDAO jDAO;
	@Inject
	private AlimentoDAO aDAO;
	@Inject
	private RopaDAO rDAO;

	@PostConstruct
	public void init() {
		this.products = jDAO.getProducts();
		this.selectedProducts = new ArrayList<JugueteDTO>();
		this.products1 = aDAO.getProducts1();
		this.selectedProducts1 = new ArrayList<AlimentoDTO>();
		this.products2 = rDAO.getProducts();
		this.selectedProducts2 = new ArrayList<RopaDTO>();
	}

	public void openNew() {
		this.selectedProduct = new JugueteDTO();
	}

	public void saveProduct() {
		if (this.selectedProduct.getCode() == null) {
			this.selectedProduct.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
			jDAO.getProducts().add(this.selectedProduct);
			products.add(this.selectedProduct);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
		}

		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteProduct() {
		products.remove(this.selectedProduct);
		jDAO.getProducts().remove(this.selectedProduct);
		this.selectedProducts.remove(this.selectedProduct);
		this.selectedProduct = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteSelectedProducts() {
		products.removeAll(this.selectedProducts);
		jDAO.getProducts().removeAll(this.selectedProducts);
		this.selectedProducts = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}

	public void openNewAl() {
		this.selectedProduct1 = new AlimentoDTO();
	}

	public void saveProductAl() {
		if (this.selectedProduct1.getCode() == null) {
			this.selectedProduct1.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
			aDAO.getProducts1().add(this.selectedProduct1);
			products1.add(this.selectedProduct1);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
		}

		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteProductAl() {
		products1.remove(this.selectedProduct1);
		aDAO.getProducts1().remove(this.selectedProduct1);
		this.selectedProducts1.remove(this.selectedProduct1);
		this.selectedProduct1 = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteSelectedProductsAl() {
		products1.removeAll(this.selectedProducts1);
		aDAO.getProducts1().removeAll(this.selectedProducts1);
		this.selectedProducts1 = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}

	public void openNewR() {
		this.selectedProduct2 = new RopaDTO();
	}

	public void saveProductR() {
		if (this.selectedProduct2.getCode() == null) {
			this.selectedProduct2.setCode(UUID.randomUUID().toString().replaceAll("-", "").substring(0, 9));
			rDAO.getProducts().add(this.selectedProduct2);
			products2.add(this.selectedProduct2);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
		}

		PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteProductR() {
		products2.remove(this.selectedProduct2);
		rDAO.getProducts().remove(this.selectedProduct2);
		this.selectedProducts2.remove(this.selectedProduct2);
		this.selectedProduct2 = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	}

	public void deleteSelectedProductsR() {
		products2.removeAll(this.selectedProducts2);
		rDAO.getProducts().removeAll(this.selectedProducts2);
		this.selectedProducts2 = null;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Products Removed"));
		PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
		PrimeFaces.current().executeScript("PF('dtProducts').clearFilters()");
	}

//	public String getDeleteButtonMessage() {
//		if (hasSelectedProducts()) {
//			int size = this.selectedProducts.size();
//			return size > 1 ? size + " products selected" : "1 product selected";
//		}
//
//		return "Delete";
//	}
//
//	public boolean hasSelectedProducts() {
//		return this.selectedProducts != null && !this.selectedProducts.isEmpty();
//	}

	public List<JugueteDTO> getProducts() {
		return products;
	}

	public List<AlimentoDTO> getProducts1() {
		return products1;
	}

	public void setProducts1(List<AlimentoDTO> products1) {
		this.products1 = products1;
	}

	public AlimentoDTO getSelectedProduct1() {
		return selectedProduct1;
	}

	public void setSelectedProduct1(AlimentoDTO selectedProduct1) {
		this.selectedProduct1 = selectedProduct1;
	}

	public List<AlimentoDTO> getSelectedProducts1() {
		return selectedProducts1;
	}

	public void setSelectedProducts1(List<AlimentoDTO> selectedProducts1) {
		this.selectedProducts1 = selectedProducts1;
	}

	public List<RopaDTO> getProducts2() {
		return products2;
	}

	public void setProducts2(List<RopaDTO> products2) {
		this.products2 = products2;
	}

	public RopaDTO getSelectedProduct2() {
		return selectedProduct2;
	}

	public void setSelectedProduct2(RopaDTO selectedProduct2) {
		this.selectedProduct2 = selectedProduct2;
	}

	public List<RopaDTO> getSelectedProducts2() {
		return selectedProducts2;
	}

	public void setSelectedProducts2(List<RopaDTO> selectedProducts2) {
		this.selectedProducts2 = selectedProducts2;
	}

	public void setProducts(List<JugueteDTO> products) {
		this.products = products;
	}

	public JugueteDTO getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(JugueteDTO selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public List<JugueteDTO> getSelectedProducts() {
		return selectedProducts;
	}

	public void setSelectedProducts(List<JugueteDTO> selectedProducts) {
		this.selectedProducts = selectedProducts;
	}

	public JugueteDAO getpDAO() {
		return jDAO;
	}

	public void setpDAO(JugueteDAO pDAO) {
		this.jDAO = pDAO;
	}

}
