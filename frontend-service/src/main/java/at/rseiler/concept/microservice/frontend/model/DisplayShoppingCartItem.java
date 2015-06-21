package at.rseiler.concept.microservice.frontend.model;

import at.rseiler.concept.microservice.model.Product;

public class DisplayShoppingCartItem {

    private int id;
    private Product product;
    private String creationDate;

    public DisplayShoppingCartItem(int id, Product product, String creationDate) {
        this.id = id;
        this.product = product;
        this.creationDate = creationDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return "DisplayShoppingCartItem{" +
                "creationDate=" + creationDate +
                ", id=" + id +
                ", product=" + product +
                '}';
    }

}
