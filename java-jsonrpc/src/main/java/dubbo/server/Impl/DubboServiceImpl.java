package dubbo.server.Impl;

import dubbo.DubboService;

public class DubboServiceImpl implements DubboService {

    @Override
    public String echo(String cmd) {
        return cmd;
    }
}
