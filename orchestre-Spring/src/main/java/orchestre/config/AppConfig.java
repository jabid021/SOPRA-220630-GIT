package orchestre.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan({"orchestre.model","orchestre.aspect"})
@EnableAspectJAutoProxy
public class AppConfig {
	
}
