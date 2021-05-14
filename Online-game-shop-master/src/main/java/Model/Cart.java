package Model;

import java.io.Serializable;

public class Cart implements Serializable {
    private int cart_id;
    private int amount;
    private String game_name;
    private double cost;
    private double total_cost;
    private int user_id;

    public Cart(){}


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(double total_cost) {
        this.total_cost = total_cost;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", amount=" + amount +
                ", game_name='" + game_name + '\'' +
                ", cost=" + cost +
                ", total_cost=" + total_cost +
                ", user_id=" + user_id +
                '}';
    }
}
