package dubbo;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class DubboServiceImpl implements DubboService {

    @Override
    public String echo(String cmd) {
        return cmd;
    }
}
