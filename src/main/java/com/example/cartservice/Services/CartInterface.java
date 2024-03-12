package com.example.cartservice.Services;


import com.example.cartservice.Models.Cart;

public interface CartInterface {
    public Cart getCartById(Long id);
    public Cart[] getAllcart();
    public Cart[] getCartInRangeOfDate(String startDate, String endDate);
    public Cart[] getCartByUserId(Long userId);
    public Cart addNewCart(Cart cart);
    public Cart updateCart(Long id,Cart cart);
    public Cart deleteCart(Long id);
}