package com.lukeshannon.datastreaming;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ProcessorRepositoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessorRepositoryApplication.class, args);
	}
	
	@RestController
	class HomeController {

		@Value("${application.uri}")
		private String uri;

		//app register --name simple-message-processor --type processor --uri https://<application name>.cfapps.io/simple-message-processor.jar
		@GetMapping("/")
		public String home() {
			if (uri.contains("localhost")) {
				return "app register --name simple-message-processor --type processor --uri http://" + uri + "/simple-mesage-processor-0.0.1-SNAPSHOT.jar";
			}
			return "app register --name simple-message-processor --type processor --uri https://" + uri + "/simple-mesage-processor-0.0.1-SNAPSHOT.jar";

		}

	}
}
