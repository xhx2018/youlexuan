package com.offcn.listen;

import com.alibaba.fastjson.JSON;
import com.offcn.pojo.TbItem;
import com.offcn.service.ItemSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.List;

/**
 * @author 邢会兴
 * date 2019/12/3   19:39
 */
@Component
public class ImportSolrListen implements MessageListener {

    @Autowired
    private ItemSearchService itemSearchService;

    @Override
    public void onMessage(Message message) {


        try {
            TextMessage msg = (TextMessage) message;
            String text = msg.getText();
            List<TbItem> list = JSON.parseArray(text, TbItem.class);
            itemSearchService.importData(list);
            System.out.println(">>>>>>>消息消费成功：solr库导入数据");
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }
}
