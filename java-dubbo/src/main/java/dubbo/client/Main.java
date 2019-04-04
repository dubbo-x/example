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
        System.out.println(dubboService.echo("Hello World!"));
    }
}
