package org.apcffl.mini.pr;

import org.apcffl.mini.pr.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SwaggerConfig.class})
public class MiniPrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniPrApplication.class, args);
	}
}
