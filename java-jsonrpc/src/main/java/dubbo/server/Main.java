package dubbo.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
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

        ProtocolConfig protocolConfig2 = new ProtocolConfig();
        protocolConfig2.setName("jsonrpc");
        protocolConfig2.setPort(12346);

        ServiceConfig<DubboService> serviceConfig2 = new ServiceConfig<>();
        serviceConfig2.setApplication(applicationConfig);
        serviceConfig2.setRegistry(registryConfig);
        serviceConfig2.setProtocol(protocolConfig2);
        serviceConfig2.setInterface(DubboService.class);
        serviceConfig2.setRef(new DubboServiceImpl2());
        serviceConfig2.setGroup("dubbo-x");
        serviceConfig2.setVersion("0.0.2");
        serviceConfig2.setWeight(2);
        serviceConfig2.export();

        ProtocolConfig protocolConfig3 = new ProtocolConfig();
        protocolConfig3.setName("dubbo");
        protocolConfig3.setPort(12347);

        ServiceConfig<DubboService> serviceConfig3 = new ServiceConfig<>();
        serviceConfig3.setApplication(applicationConfig);
        serviceConfig3.setRegistry(registryConfig);
        serviceConfig3.setProtocol(protocolConfig3);
        serviceConfig3.setInterface(DubboService.class);
        serviceConfig3.setRef(new DubboServiceImpl3());
        serviceConfig3.setGroup("dubbo-x");
        serviceConfig3.setVersion("0.0.2");
        serviceConfig3.setWeight(2);
        serviceConfig3.export();

        System.in.read();
    }
}
