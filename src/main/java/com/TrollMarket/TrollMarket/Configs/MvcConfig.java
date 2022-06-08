package com.TrollMarket.TrollMarket.Configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/home/index");
        registry.addViewController("/login").setViewName("forward:/user/login-form");
        registry.addViewController("/profile").setViewName("forward:/profile/index");
        registry.addViewController("/shop").setViewName("forward:/shop/index");
        registry.addViewController("/merchandise").setViewName("forward:/merchandise/index");
        registry.addViewController("/shipment").setViewName("forward:/shipment/index");
        registry.addViewController("/cart").setViewName("forward:/cart/index");
        registry.addViewController("/home").setViewName("forward:/home/index");
        registry.addViewController("/admin").setViewName("forward:/admin/index");
        registry.addViewController("/history").setViewName("forward:/history/index");
        registry.addViewController("/register").setViewName("forward:/user/register-form");
        registry.addViewController("/access-denied").setViewName("forward:/account/access-denied");

    }
}