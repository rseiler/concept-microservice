package at.rseiler.concept.microservice.model;

import java.util.List;

public class ShoppingCart {

    private int id;
    private int idUser;
    private String name;
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
    }

    public ShoppingCart(int id, int idUser, String name, List<ShoppingCartItem> items) {
        this.id = id;
        this.idUser = idUser;
        this.name = name;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

}
