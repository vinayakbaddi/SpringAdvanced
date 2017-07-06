package com.way2learnonline.config;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
@ComponentScan(basePackages={"com.way2learnonline"})
@EnableJms
public class JmsConfig {

	@Bean
	public ConnectionFactory connectionFactory() throws Throwable {
		InitialContext context = new InitialContext();
		return (ConnectionFactory) context.lookup("connectionFactory");
	}

	@Bean
	public Queue queue() throws Exception {
		InitialContext context = new InitialContext();
		return (Queue) context.lookup("MyQueue");
	}
	
	@Bean
	public JmsTemplate jmsTemplate() throws Throwable{
		JmsTemplate jmsTemplate= new JmsTemplate(connectionFactory());
		//jmsTemplate.setDefaultDestination(queue());
		jmsTemplate.setDefaultDestinationName("orders");
		jmsTemplate.setDestinationResolver(destinationResolver());
		jmsTemplate.setMessageConverter(messageConverter());
		return jmsTemplate;
	}
	@Bean
	public DestinationResolver destinationResolver(){
		JndiDestinationResolver destinationResolver= new JndiDestinationResolver();
		return destinationResolver;
	}
	
	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() throws Throwable{
		DefaultJmsListenerContainerFactory jmsListenerContainerFactory= new DefaultJmsListenerContainerFactory();
		jmsListenerContainerFactory.setConnectionFactory(connectionFactory());
		jmsListenerContainerFactory.setDestinationResolver(destinationResolver());
		jmsListenerContainerFactory.setMessageConverter(messageConverter());
		return jmsListenerContainerFactory;
	}
	
	
	@Bean
	public MessageConverter messageConverter(){
		return  new MarshallingMessageConverter(marshaller());	
	}
	@Bean
	public Marshaller marshaller(){
		Jaxb2Marshaller marshaller= new Jaxb2Marshaller();
		marshaller.setContextPath("com.way2learnonline");
		return marshaller;
		
	}

}
