package br.com.felipeaio.CadastrodeGames.config;

import br.com.felipeaio.CadastrodeGames.serialization.converter.YamlJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //..add a media type
    private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");

    //..add a interceptor
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        converters.add(new YamlJackson2HttpMessageConverter());
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer){
        configurer.favorParameter(true)
                .ignoreAcceptHeader(false) //.. remove parameterName method and don't ignore Accept Header
                .parameterName("mediaType") //..query parameter name
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("x-yaml", MEDIA_TYPE_YAML); //..adding YAML support
    }
}
