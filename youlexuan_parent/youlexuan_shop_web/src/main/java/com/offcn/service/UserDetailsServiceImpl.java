package com.offcn.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.pojo.TbSeller;
import com.offcn.sellergoods.service.SellerService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 邢会兴
 * date 2019/11/19   21:58
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Reference
    private SellerService sellerService;

    @Override
    public UserDetails loadUserByUsername(String usname) throws UsernameNotFoundException {
        System.out.println("经过自定义类》》》》"+usname);

        //目的：查询数据库，判断该用户的用户名、密码是否正确

        List<GrantedAuthority> list  = new ArrayList();
        list.add(new SimpleGrantedAuthority("ROLE_SELLER"));

        TbSeller seller = sellerService.findOne(usname);
        if (seller!=null){

            if (seller.getStatus().equals("1")){
                return new User(usname,seller.getPassword(),list);
            }else {
                return  null;
            }
        }else {
            return null;
        }
        //参数1：用户名
        //参数2：密码
        //参数3：角色

    }
}
