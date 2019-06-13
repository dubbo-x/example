package org.apache.dubbo.samples.consul;

import org.apache.dubbo.samples.consul.api.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsulConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
        String hello = demoService.sayHello("consul");
        System.out.println(hello);
    }
}