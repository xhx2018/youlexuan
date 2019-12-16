package com.offcn.service;

import com.offcn.pojo.TbItem;

import java.util.List;
import java.util.Map;

/**
 * @author 邢会兴
 * date 2019/11/29   20:49
 */
public interface ItemSearchService {

    //查询solr索引库
    public Map<String,Object> search(Map searchMap);

    //新增solr索引库
    public void importData(List<TbItem> list);

    //删除solr索引库：id表示多个tb_item的id
    public void  deleteData(Long[] ids);
}
