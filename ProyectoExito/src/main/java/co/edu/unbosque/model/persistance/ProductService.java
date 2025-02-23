package co.edu.unbosque.model.persistance;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.InventoryStatus;
import co.edu.unbosque.model.Product;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class ProductService {

    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(); 
        products.add(new Product(1000, "f230fh0g3", "Barbie", "Muñeca de Mattel", "Barbie.jpg", 35000,
                "Niñas", 24, InventoryStatus.INSTOCK));
        products.add(new Product(1001, "nvklal433", "MaxSteel", "Muñeco de Mattel", "black-watch.jpg", 72,
                "Niños", 61, InventoryStatus.INSTOCK));
        products.add(new Product(1002, "zz21cz3c1", "Perrito Aprende Conmigo", "Peluche de Fisher Price", "blue-band.jpg", 79,
                "Bebés", 2, InventoryStatus.LOWSTOCK));
        products.add(new Product(1003, "244wgerg2", "Uno", "Juego de cartas", "blue-t-shirt.jpg", 29,
                "Juegos de Mesa", 25, InventoryStatus.INSTOCK));
   

    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProducts(int size) {

        if (size > products.size()) {
            Random rand = new Random();

            List<Product> randomList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int randomIndex = rand.nextInt(products.size());
                randomList.add(products.get(randomIndex));
            }

            return randomList;
        }

        else {
            return new ArrayList<>(products.subList(0, size));
        }

    }}