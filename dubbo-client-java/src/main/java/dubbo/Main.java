package dubbo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Config.class);
        context.refresh();

        DubboServiceImpl dubboService = context.getBean(DubboServiceImpl.class);
        System.out.println(dubboService.echo("Hello World!"));
    }
}
