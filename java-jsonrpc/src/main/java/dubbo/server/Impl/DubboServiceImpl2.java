package dubbo.server.Impl;

import dubbo.DubboService;

public class DubboServiceImpl2 implements DubboService {

    @Override
    public String echo(String cmd) {
        return String.join(" ", cmd, cmd);
    }
}
