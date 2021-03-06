package br.edu.up.pessoa;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	@Autowired
	private FilaSender sender;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		String msg;
		int opcao = 10;
		
		for (int i = 0; i < opcao; i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite a mensagem que deseja enviar: ");
			msg = sc.nextLine();
			
			if(msg == null) {
				msg = " ";
			}
			sender.send(msg);
			System.out.println("Mensagem enviada...");
			
		}
		
		
	}

}
