/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sample.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author truon
 */
public class Cart {

    private Map<String, Clothes> cart;

    public Cart() {
    }

    public Cart(Map<String, Clothes> cart) {
        this.cart = cart;
    }

    public Map<String, Clothes> getCart() {
        return cart;
    }

    public void setCart(Map<String, Clothes> cart) {
        this.cart = cart;
    }

    public void add(Clothes clothes) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(clothes.getId())) {
            int currentQuantity = this.cart.get(clothes.getId()).getQuantity();
            clothes.setQuantity(currentQuantity + clothes.getQuantity());
        }
        this.cart.put(clothes.getId(), clothes);
    }

    public boolean edit(String id, Clothes clothes) {
        boolean checkEdit = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.replace(id, clothes);
                    checkEdit = true;
                }
            }
        } catch (Exception e) {
        }
        return checkEdit;
    }
    public boolean remove(String id, Clothes clothes) {
        boolean checkEdit = false;
        try {
            if (this.cart != null) {
                if (this.cart.containsKey(id)) {
                    this.cart.remove(id);
                    checkEdit = true;
                }
            }
        } catch (Exception e) {
        }
        return checkEdit;
    }

}
