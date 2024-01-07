package configserver.configmsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigMsServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigMsServerApplication.class, args);
	}

}
