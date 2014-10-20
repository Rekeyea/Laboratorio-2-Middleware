package middleware.clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Iniciando middleware...");
		
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("annotation.xml");
		
		context.start();
		
		System.out.println("Middleware iniciado");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Presione una tecla para terminar el middleware.");
		br.readLine();
		
		context.close();

		System.out.println("Middleware Terminado");
	}

}
