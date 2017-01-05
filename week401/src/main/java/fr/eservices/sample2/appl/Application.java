package fr.eservices.sample2.appl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import fr.eservices.sample2.api.Greeter;
import fr.eservices.sample2.api.Printer;
import fr.eservices.sample2.api.Welcome;
import fr.eservices.sample2.impl.FrenchGreeter;


@Configuration
@ComponentScan(value="fr.eservices.sample2.impl")
@Component
public class Application {
	
	@Autowired
	@Qualifier("french")
	Greeter greeter;
	@Autowired
	@Qualifier("console")
	Printer printer;
	@Autowired
	@Qualifier("swing")
	Welcome welcome;
	
	

	public Application() {
	}
	
	public void run() {
		String name = welcome.askName();
		String response = greeter.hello(name);
		printer.print( response );
	}
	
	
	public void setWelcome(Welcome welcome) {
		this.welcome = welcome;
	}
	
	public void setGreeter(Greeter greeter) {
		this.greeter = greeter;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	
	
	public static void main(String[] args) {
		ApplicationContext myCtx = new AnnotationConfigApplicationContext(Application.class);
		Application app = myCtx.getBean(Application.class);
		app.run();
		
		
	}
}
