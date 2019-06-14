package dubbo.server;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import dubbo.DubboService;
import dubbo.server.Impl.DubboServiceImpl;
import dubbo.server.Impl.DubboServiceImpl2;
import dubbo.server.Impl.DubboServiceImpl3;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("server-java-dubbo");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("consul://127.0.0.1:8500");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setHost("172.30.196.1");  // specific in my machine
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
