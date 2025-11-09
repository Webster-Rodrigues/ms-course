package io.github.websterrodrigues.mscloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MscloudgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscloudgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		//Define as rotas do gateway. Os acesso a /clients/** serão redirecionados para o msclientes
		return builder.routes()
				.route(r-> r.path("/clients/**").uri("lb://msclientes"))
				.route(r-> r.path("/cards/**").uri("lb://mscartoes"))
				.route(r-> r.path("/credit-appraiser/**").uri("lb://msavaliadorcredito"))
				.build();
	}
}
