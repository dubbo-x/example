package dubbo.client;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import dubbo.DubboService;

public class Main {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("client-java-dubbo");
        applicationConfig.setQosPort(33333);

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("consul://127.0.0.1:8500");

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
