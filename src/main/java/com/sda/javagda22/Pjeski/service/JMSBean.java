package com.sda.javagda22.Pjeski.service;

import org.apache.activemq.ActiveMQConnectionFactory;


import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.*;


public class JMSBean {

//    @Inject
//    ActiveMQConnectionFactory jmsFactory;
//
//    public void submit(String message) throws Exception{
//        Connection connection = jmsFactory.createConnection();
//        connection.start();
//        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Queue photoQueue = session.createQueue("photos");
//        MessageProducer producer = session.createProducer(photoQueue);
//        TextMessage textMessage = session.createTextMessage(message);
//        producer.send(textMessage);
//        connection.stop();
//    }
}
