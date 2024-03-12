package com.example.cartservice.Services;

import com.example.cartservice.dto.cartdto;
import com.example.cartservice.Models.Cart;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService implements CartInterface{
    RestTemplate restTemplate = new RestTemplate();
    @Override
    public Cart getCartById(Long id) {
        cartdto cartdto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/"+id,
                cartdto.class);
        Cart cart = new Cart();
        cart.setId(cartdto.getId());
        cart.setDate(cartdto.getDate());
        cart.setUserId(cartdto.getUserId());
        cart.setProduct(cartdto.getProducts());
        return cart;


    }
    @Override
    public Cart[] getAllcart() {
        cartdto[] cartdto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts",
                cartdto[].class);
        Cart[] cartList = new Cart[cartdto.length];
        for (int i = 0; i < cartdto.length; i++) {
            cartList[i] = new Cart();
            cartList[i].setId(cartdto[i].getId());
            cartList[i].setUserId(cartdto[i].getUserId());
            cartList[i].setDate(cartdto[i].getDate());
            cartList[i].setProduct(cartdto[i].getProducts());
        }
        return cartList;
    }
    @Override
    public Cart[] getCartInRangeOfDate(String startDate, String endDate) {
        cartdto[] cartdto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts?startdate="+startDate+"&enddate="+endDate,
                cartdto[].class);
        Cart[] cartListByDate = new Cart[cartdto.length];
        for (int i = 0; i < cartdto.length; i++) {
            cartListByDate[i] = new Cart();
            cartListByDate[i].setId(cartdto[i].getId());
            cartListByDate[i].setUserId(cartdto[i].getUserId());
            cartListByDate[i].setProduct(cartdto[i].getProducts());
            cartListByDate[i].setDate(cartdto[i].getDate());
        }
        return cartListByDate;
    }
    @Override
    public Cart[] getCartByUserId(Long userId) {
        cartdto[] cartdto = restTemplate.getForObject(
                "https://fakestoreapi.com/carts/user/"+userId,
                cartdto[].class);
        Cart[] cartListByUserId = new Cart[cartdto.length];
        for (int i = 0; i < cartdto.length; i++) {
            cartListByUserId[i] = new Cart();
            cartListByUserId[i].setId(cartdto[i].getId());
            cartListByUserId[i].setUserId(cartdto[i].getUserId());
            cartListByUserId[i].setProduct(cartdto[i].getProducts());
            cartListByUserId[i].setDate(cartdto[i].getDate());

        }
        return cartListByUserId;
    }

    public Cart addNewCart(Cart cart) {
        cartdto cartdto = new cartdto();
        cartdto.setId(cart.getId());
        cartdto.setUserId(cart.getUserId());
        cartdto.setDate(cart.getDate());
        cartdto.setProducts(cart.getProduct());

        restTemplate.postForEntity(
                "https://fakestoreapi.com/carts",
                cartdto,
                cartdto.class);

        return cart;
    }
    @Override
    public Cart updateCart(Long id,Cart cart) {
        Cart oldCart = getCartById(id);
        cartdto newCart = new cartdto();
        newCart.setId(oldCart.getId());
        newCart.setUserId(oldCart.getUserId());
        newCart.setDate(oldCart.getDate());
        newCart.setProducts(oldCart.getProduct());

        restTemplate.postForEntity(
                "https://fakestoreapi.com/carts",
                newCart,
                Cart.class);
        return cart;
    }
    @Override
    public Cart deleteCart(Long id) {
        Cart getCart = getCartById(id);
        restTemplate.delete("https://fakestoreapi.com/carts/"+id);
        return getCart;
    }
}