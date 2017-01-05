package fr.eservices.week402.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

// Set this class as a configuration class,
// scan fr.eservices.week402.ctrl for components
// enable spring web mvc

@Configuration
@ComponentScan(basePackages = "fr.eservices.week402.ctrl")
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	// Add a method to provide an InternalResourceViewResolver,
	// put views in /WEB-INF/views
	// all views would be some jsp

	public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
