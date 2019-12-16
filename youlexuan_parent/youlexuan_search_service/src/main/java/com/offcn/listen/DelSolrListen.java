package com.offcn.listen;

import com.alibaba.fastjson.JSON;
import com.offcn.pojo.TbItem;
import com.offcn.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.util.List;

/**
 * @author 邢会兴
 * date 2019/12/3   19:39
 */
@Component
public class DelSolrListen implements MessageListener {

    @Autowired
    private ItemSearchService itemSearchService;

    @Override
    public void onMessage(Message message) {


        try {
            ObjectMessage msg = (ObjectMessage) message;
            Long[] ids = (Long[]) msg.getObject();
            itemSearchService.deleteData(ids);
            System.out.println(">>>>>>>消息消费成功：solr库删除数据");
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
