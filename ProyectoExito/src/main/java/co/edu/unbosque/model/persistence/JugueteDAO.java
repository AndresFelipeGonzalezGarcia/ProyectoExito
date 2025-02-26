package co.edu.unbosque.model.persistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import co.edu.unbosque.model.JugueteDTO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class JugueteDAO {

    private List<JugueteDTO> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(); 
        products.add(new JugueteDTO(1000, "f230fh0g3", "Barbie", "Muñeca de Mattel", "Barbie.jpg", 35000,
                "Niñas", 24));
        products.add(new JugueteDTO(1001, "nvklal433", "MaxSteel", "Muñeco de Mattel", "black-watch.jpg", 72,
                "Niños", 61));
        products.add(new JugueteDTO(1002, "zz21cz3c1", "Perrito Aprende Conmigo", "Peluche de Fisher Price", "blue-band.jpg", 79,
                "Bebés", 2));
        products.add(new JugueteDTO(1003, "244wgerg2", "Uno", "Juego de cartas", "blue-t-shirt.jpg", 29,
                "Juegos de Mesa", 25));

        
        

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

    }}