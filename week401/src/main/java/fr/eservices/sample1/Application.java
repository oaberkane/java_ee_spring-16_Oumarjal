

package fr.eservices.sample1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

//@Configuration
@Component
@ComponentScan
public class Application {
	
	@Autowired
	Greeter greeter;
	@Autowired
	Printer printer;
	@Autowired
	Welcome welcome;
	
	public Application() {
	
	}
	
	public void run() {
		String name = welcome.askName();
		String response = greeter.hello(name);
		printer.print( response );
	}
	
	public static void main(String[] args) {
		ApplicationContext Myctx = new AnnotationConfigApplicationContext(Application.class);
				
		Application app = Myctx.getBean(Application.class);
		app.run();
	}

}

