package com.user.service.config;

import com.user.service.config.intercepter.RestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MyConfig {

  @Autowired
  private ClientRegistrationRepository clientRegistrationRepository;
  @Autowired
  private OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

  @Bean
  @LoadBalanced
  public RestTemplate restTemplate(){

    RestTemplate restTemplate = new RestTemplate();
    List<ClientHttpRequestInterceptor> interceptor = new ArrayList<>();
    interceptor.add(new RestTemplateInterceptor(manager(clientRegistrationRepository,oAuth2AuthorizedClientRepository)));
    restTemplate.setInterceptors(interceptor);
    return restTemplate;
  }
  //create bean of Oauth2Authoriizedclient manager

  @Bean
  public OAuth2AuthorizedClientManager manager(
          ClientRegistrationRepository clientRegistrationRepository,
          OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository
  ) {

    OAuth2AuthorizedClientProviderBuilder builder = OAuth2AuthorizedClientProviderBuilder.builder();
    OAuth2AuthorizedClientProviderBuilder oAuth2AuthorizedClientProviderBuilder = builder.clientCredentials();
    //oAuth2AuthorizedClientProviderBuilder.build();
    DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository,oAuth2AuthorizedClientRepository);
    defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(oAuth2AuthorizedClientProviderBuilder.build());
    return defaultOAuth2AuthorizedClientManager;

  }

}
