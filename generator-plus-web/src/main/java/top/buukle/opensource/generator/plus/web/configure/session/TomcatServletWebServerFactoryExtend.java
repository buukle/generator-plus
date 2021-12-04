package top.buukle.opensource.generator.plus.web.configure.session;

import org.apache.catalina.Context;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class TomcatServletWebServerFactoryExtend extends TomcatServletWebServerFactory {

    protected void postProcessContext(Context context) {
        context.setManager(new NoSessionManager());
    }
}
