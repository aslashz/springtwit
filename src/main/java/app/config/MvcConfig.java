package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/timeline").setViewName("timeline");
        registry.addViewController("/login").setViewName("login");
        
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	// TODO Auto-generated method stub
    	/** registry.addResourceHandler("/static/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
    	registry.addResourceHandler("/static/fonts/**").addResourceLocations("/fonts/").setCachePeriod(31556926);
    	registry.addResourceHandler("/static/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    	**/
    }

}
