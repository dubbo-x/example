package org.apache.dubbo.samples.consul.impl;

import org.apache.dubbo.samples.consul.api.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }
}