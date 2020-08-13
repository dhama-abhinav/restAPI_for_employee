package com.example.com.restAPIs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo {
    @RequestMapping("/")
    public String home(){
        return "hello first app";
        //returning simple string
    }
    @GetMapping(path = "hello-world")
    public HelloWorldBean hellowWorld(){
        return new HelloWorldBean("new bean");
        //returning a bean and this bean will be cnverted to json
    }
    @GetMapping(path = "hello-world/path/{name}")
    public HelloWorldBean hellowWorldPath(@PathVariable String name){
        return new HelloWorldBean(String.format("new bean , %s",name));
        //returning a bean and this bean will be cnverted to json
    }

}





// autoconfiguration report: it will have DispatcherServletAutoConfiguration matched bcoz it will found the dispatcher
//servlet on the classpath and we added a starter to spring-boot-starter and it has a dependency spring mvc framework
//also it will have ErrorMvcAutoConfiguration-