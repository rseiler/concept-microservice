package at.rseiler.concept.microservice.model;

import java.util.Date;

public class ShoppingCartItem {

    private int id;
    private int idProduct;
    private Date creationDate;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(int id, int idProduct, Date creationDate) {
        this.id = id;
        this.idProduct = idProduct;
        this.creationDate = new Date(creationDate.getTime());
    }

    public Date getCreationDate() {
        return new Date(creationDate.getTime());
    }

    public int getId() {
        return id;
    }

    public int getIdProduct() {
        return idProduct;
    }

    @Override
    public String toString() {
        return "ShoppingCartItem{" +
                "creationDate=" + creationDate +
                ", id=" + id +
                ", idProduct=" + idProduct +
                '}';
    }

}
