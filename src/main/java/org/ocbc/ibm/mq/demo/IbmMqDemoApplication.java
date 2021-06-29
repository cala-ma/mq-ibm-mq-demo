package org.ocbc.ibm.mq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import java.util.Properties;

@SpringBootApplication
public class IbmMqDemoApplication {


    public static void main(String[] args) {
        Properties systemProps = System.getProperties();
        systemProps.put( "javax.net.ssl.trustStore", "C:\\Users\\pats\\Desktop\\clientTruststore.p12");
        systemProps.put( "javax.net.ssl.trustStorePassword", "Welcome1");
        systemProps.put( "javax.net.ssl.keyStore", "C:\\Users\\pats\\Desktop\\clientKeystore.p12");
        systemProps.put( "javax.net.ssl.keyStorePassword", "Welcome1");
        System.setProperties(systemProps);
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(IbmMqDemoApplication.class, args);
        final JmsTemplate bean = applicationContext.getBean(JmsTemplate.class);
        bean.convertAndSend("OMS.QUEUE.1", "你好");
    }

}
