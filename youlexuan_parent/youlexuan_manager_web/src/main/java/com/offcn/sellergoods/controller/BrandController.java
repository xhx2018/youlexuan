package com.offcn.sellergoods.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import com.offcn.pojo.TbBrand;
import com.offcn.sellergoods.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;
import java.util.Map;

/**
 * @author 邢会兴
 * date 2019/11/14   15:26
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAll(){
        return brandService.findAll();
    }

    @RequestMapping("/findPage")
    public PageResult findPage(int page,int size){
        return brandService.findPage(page,size);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody TbBrand tbBrand,int page,int size){
        return brandService.findPage(tbBrand,page,size);
    }


    @RequestMapping("/add")
    public Result add(@RequestBody TbBrand brand){
        try {
            brandService.add(brand);
            return new Result(true,"增加品牌成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"增加品牌失败");
        }
    }

    @RequestMapping("/findOne")
    public TbBrand findOne(Long id){
        return brandService.findOne(id);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand tbBrand){
        try {
            brandService.update(tbBrand);
            return new Result(true,"修改品牌成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改品牌失败");
        }
    }

    @RequestMapping("/delete")
    public  Result delete(Long[] ids){


        try {
            brandService.delete(ids);
            return new Result(true,"删除品牌成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除品牌失败");
        }

    }
    @RequestMapping("/findBrandOptionList")
    public List<Map> findBrandOptionList(){
        return  brandService.findBrandOptionList();
    }

}
