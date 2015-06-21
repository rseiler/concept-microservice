package at.rseiler.concept.microservice.frontend.model;

import java.util.List;

public class DisplayShoppingCart {

    private int id;
    private int idUser;
    private String name;
    private List<DisplayShoppingCartItem> items;

    public DisplayShoppingCart(int id, int idUser, String name, List<DisplayShoppingCartItem> items) {
        this.id = id;
        this.idUser = idUser;
        this.items = items;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getIdUser() {
        return idUser;
    }

    public List<DisplayShoppingCartItem> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DisplayShoppingCart{" +
                "id=" + id +
                ", idUser=" + idUser +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

}
