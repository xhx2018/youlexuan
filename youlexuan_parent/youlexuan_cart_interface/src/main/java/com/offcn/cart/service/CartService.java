package com.offcn.cart.service;

import com.offcn.group.Cart;

import java.util.List;

/**
 * @author 邢会兴
 * date 2019/12/10   20:17
 */
public interface CartService {
    List<Cart> addGoodsToCart(List<Cart> cartList,Long skuId, Integer num);
    List<Cart> findCartListFromRedis(String userName);
    void addGoodsToRedis(List<Cart> cartList,String userName);
    List<Cart> mergeCartList(List<Cart> list1,List<Cart> list2);
}
