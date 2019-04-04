package dubbo.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import dubbo.DubboService;

public class Main {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("client-java-dubbo");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("zookeeper://127.0.0.1:2181");

        ReferenceConfig<DubboService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(DubboService.class);
        referenceConfig.setGroup("dubbo-x");
        referenceConfig.setVersion("0.0.1");

        DubboService dubboService = referenceConfig.get();
        System.out.println(dubboService.echo("Hello World!"));  // bug: route to protocol = jsonrpc, port = 12346, interface = dubbo.DubboService, group = dubbo-x, version = 0.0.2

        ReferenceConfig<DubboService> referenceConfig2 = new ReferenceConfig<>();
        referenceConfig2.setApplication(applicationConfig);
        referenceConfig2.setRegistry(registryConfig);
        referenceConfig2.setInterface(DubboService.class);
        referenceConfig2.setGroup("dubbo-x");
        referenceConfig2.setVersion("0.0.2");
//        referenceConfig2.setProtocol("jsonrpc");

        DubboService dubboService2 = referenceConfig2.get();
        for (int i = 0; i < 20; i++) {
            System.out.println(dubboService2.echo("Hello World!"));
        }
    }
}
