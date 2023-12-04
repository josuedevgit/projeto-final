package com.projetofinal.zeldaservice;

import com.projetofinal.zeldaservice.model.RetornoJogo;
import com.projetofinal.zeldaservice.model.ZeldaResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class GetExternalAPI {

	public static void main(String[] args) {
		SpringApplication.run(GetExternalAPI.class, args);


	}

}
