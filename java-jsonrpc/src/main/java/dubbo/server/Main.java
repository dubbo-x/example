package dubbo.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import dubbo.DubboService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("server-java-dubbo");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("jsonrpc");
        protocolConfig.setPort(12345);

        ServiceConfig<DubboService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(DubboService.class);
        serviceConfig.setRef(new DubboServiceImpl());
        serviceConfig.setGroup("dubbo-x");
        serviceConfig.setVersion("0.0.1");
        serviceConfig.export();

        System.in.read();
    }
}
