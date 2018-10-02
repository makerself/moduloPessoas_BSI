package br.edu.up.pessoa;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilaSender {
	
	@Autowired
	private RabbitTemplate helper;

	@Autowired
	private Queue fila;

	public void send(String mens) {
		helper.convertAndSend(this.fila.getName(), mens);
	}

}
