package org.apache.dubbo.samples.consul;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsulProvider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-demo-provider.xml");
        context.start();
        System.in.read();
    }
}