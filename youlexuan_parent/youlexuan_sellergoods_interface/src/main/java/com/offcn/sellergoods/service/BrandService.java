package com.offcn.sellergoods.service;

import com.offcn.entity.PageResult;
import com.offcn.pojo.TbBrand;

import java.util.List;
import java.util.Map;

/**
 * @author 邢会兴
 * date 2019/11/14   14:38
 */
public interface BrandService {
     List<TbBrand> findAll();
    PageResult findPage(int pageNum,int pageSize);
    PageResult findPage(TbBrand tbBrand, int pageNum,int pageSize);
    void add(TbBrand brand);

    void update(TbBrand tbBrand);

    TbBrand findOne(Long id);

    void delete(Long[] ids);


    List<Map> findBrandOptionList();
}
