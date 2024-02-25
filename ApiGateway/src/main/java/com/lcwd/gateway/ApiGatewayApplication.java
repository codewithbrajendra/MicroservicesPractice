package com.lcwd.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder locatorBuilder) {
		return locatorBuilder.routes()
				.route("USER-SERVICE",r ->  r.path("/users/**")
						.uri("lb://USER-SERVICE"))
						//.id("employeeModule"))
				.route("HOTEL-SERVICE",r ->  r.path("/hotel/**","/staffs/**")
						.uri("lb://HOTEL-SERVICE"))
						//.id("employeeModule"))
				.route("RATING-SERVICE",r ->  r.path("/ratings/**")
						.uri("lb://RATING-SERVICE"))
						//.id("employeeModule"))
				.build();
	}

}
