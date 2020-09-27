package com.adev.aggregator;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AggregatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorApplication.class, args);
	}

	@Configuration
    @EnableSwagger2
    public class Swagger {

        @Bean
        public Docket createApi() {
            return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                    .apis(RequestHandlerSelectors.basePackage("com.adev.aggregator.controller"))
                    .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any())
                    .build();
        }

        private ApiInfo apiInfo() {
            return new ApiInfoBuilder().title("adev - aggregator Specification").description("")
                    .version("1.0.0-SNAPSHOT").build();
        }
    }
	
	/**
     * Web security configurer.
     */
    @Order(SecurityProperties.DEFAULT_FILTER_ORDER)
    @Configuration
    protected static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        /**
         * Override the access rules without changing any other auto-configured
         * features.
         *
         * <p>
         * The basic features in a web application are: HTTP Basic security for
         * all other endpoints. Security events published to Spring’s
         * ApplicationEventPublisher (successful and unsuccessful authentication
         * and access denied). Common low-level features (HSTS, XSS, CSRF,
         * caching) provided by Spring Security are on by default.
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/**").authorizeRequests()
                    .antMatchers("/", "/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**", "/webjars/**",
                            "/api/**", "/websocket/**", "/sockjs/**", "/callback/**")
                    .permitAll()
                    .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs", "/configuration/ui",
                            "/configuration/security")
                    .permitAll().antMatchers("/manager/**").hasRole("ADMIN").antMatchers("/db/**")
                    .access("hasRole('ADMIN') and hasRole('DBA')").anyRequest().authenticated().and().formLogin()
                    .loginPage("/login").successHandler(authenticationSuccessHandler()).and().logout()
                    .logoutSuccessUrl("/").permitAll().and().csrf().disable().sessionManagement().invalidSessionUrl("/")
                    .maximumSessions(1).expiredUrl("/login");
        }

        /**
         * Authentication success handler.
         */
        private SavedRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler() {
            return new SavedRequestAwareAuthenticationSuccessHandler() {

				@Override
				public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
						org.springframework.security.core.Authentication authentication)
						throws ServletException, IOException {
					super.onAuthenticationSuccess(request, response, authentication);
				}
            	 
            };
        }
    }
}
