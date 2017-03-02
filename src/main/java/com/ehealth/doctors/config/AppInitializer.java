package com.ehealth.doctors.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer {
 
    private static Class<?>[]  configurationClasses = new Class<?>[] 
    	{ SecurityConfigurationAdapter.class, AppConfiguration.class, WebMvcConfig.class };
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SecurityConfigurationAdapter.class, AppConfiguration.class, WebMvcConfig.class };
    }
  
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }
  
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }    
    
    @Override
    public void onStartup(ServletContext container) {
        // Load application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SecurityConfigurationAdapter.class);
        rootContext.register(AppConfiguration.class);
        rootContext.register(WebMvcConfig.class);
        container.addListener(new RequestContextListener());
        container.addFilter("securityFilter", 
                new DelegatingFilterProxy("springSecurityFilterChain"))
        .addMappingForUrlPatterns(null, false, "/*");
        rootContext.setServletContext(container);
        rootContext.setDisplayName("ehealth");

        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(rootContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.setAsyncSupported(true);

        dispatcher.addMapping("/");

    }
    
}
