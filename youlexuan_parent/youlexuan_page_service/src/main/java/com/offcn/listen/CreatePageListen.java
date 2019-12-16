package com.offcn.listen;

import com.offcn.page.service.ItemPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author 邢会兴
 * date 2019/12/3   21:57
 */
@Component
public class CreatePageListen implements MessageListener {

    @Autowired
    private ItemPageService pageService;

    @Override
    public void onMessage(Message message) {


        try {
            ObjectMessage obj = (ObjectMessage) message;
            Long[] ids = (Long[]) obj.getObject();

            for (Long id : ids) {
                pageService.genItemHtml(id);
            }
            System.out.println(">>>>>>>>>>消息消费成功："+ Arrays.toString(ids)+"页面生成成功");
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
