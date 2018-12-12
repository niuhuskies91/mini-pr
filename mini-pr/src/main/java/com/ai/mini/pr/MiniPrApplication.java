package com.ai.mini.pr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.ai.mini.pr.config.SwaggerConfig;

@SpringBootApplication
@Import({SwaggerConfig.class})
public class MiniPrApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniPrApplication.class, args);
	}
}
