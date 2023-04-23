package personal.xjl.jerrymouse.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加登录拦截器，拦截/Student/除去login.do以外的所有请求
        registry.addInterceptor(new MyLoginInterceptor())
                .addPathPatterns("/Student/*")
                .addPathPatterns("/Teacher/*")
                .addPathPatterns("/Admin/*")
                .excludePathPatterns("/Login*");
    }
//    @Bean
//    public LocaleResolver localeResolver(){
//        return new MyLocaleResolver();
//    }
}
