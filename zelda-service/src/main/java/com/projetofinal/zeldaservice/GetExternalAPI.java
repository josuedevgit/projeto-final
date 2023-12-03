package com.projetofinal.zeldaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class GetExternalAPI {

	public static void main(String[] args) {
		SpringApplication.run(GetExternalAPI.class, args);

		String url ="https://zelda.fanapis.com/api/games";

		WebClient.Builder builder = WebClient.builder();

		Zelda zelda = builder.build()
				.get()
				.uri(url)
				.retrieve()
				.bodyToMono(Zelda.class)
				.block();


	}

}
