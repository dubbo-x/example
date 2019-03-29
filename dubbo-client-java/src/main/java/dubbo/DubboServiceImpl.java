package dubbo;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class DubboServiceImpl {

    @Reference
    private DubboService dubboService;

    public String echo(String cmd) {
        return dubboService.echo(cmd);
    }
}
