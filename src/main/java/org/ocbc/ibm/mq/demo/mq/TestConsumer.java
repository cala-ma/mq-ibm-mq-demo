package org.ocbc.ibm.mq.demo.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author mqt
 * @version 1.0
 * @date 2021/6/16 16:02
 */
@Component
public class TestConsumer {
    Logger log = LoggerFactory.getLogger(getClass());

    @JmsListener(destination = "OMS.QUEUE.1")
    public void test(String msg) {
        log.info("received：{}", msg);
    }
}
