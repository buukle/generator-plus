//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package top.buukle.opensource.generator.plus.service.engine.archetypes;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.log.LogSystem;
import org.codehaus.plexus.logging.AbstractLogEnabled;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.Initializable;
import org.codehaus.plexus.personality.plexus.lifecycle.phase.InitializationException;
import org.codehaus.plexus.velocity.VelocityComponent;

import java.util.Enumeration;
import java.util.Properties;

@Slf4j
@Data
public class MyVelocityComponent extends AbstractLogEnabled implements VelocityComponent, Initializable, LogSystem {
    private VelocityEngine engine;
    private Properties properties;
    private RuntimeServices runtimeServices;

    public MyVelocityComponent() {
    }

    public void initialize() throws InitializationException {
        this.engine.setProperty("velocimacro.library", "");
        this.engine.setProperty("runtime.log.logsystem", this);
        if (this.properties != null) {
            Enumeration e = this.properties.propertyNames();

            while(e.hasMoreElements()) {
                String key = e.nextElement().toString();
                String value = this.properties.getProperty(key);
                this.engine.setProperty(key, value);
                log.debug("Setting property: " + key + " => '" + value + "'.");
            }
        }

        try {
            this.engine.init();
        } catch (Exception var4) {
            throw new InitializationException("Cannot start the velocity engine: ", var4);
        }
    }

    public VelocityEngine getEngine() {
        return this.engine;
    }

    public void init(RuntimeServices runtimeServices) {
        this.runtimeServices = runtimeServices;
    }

    public void logVelocityMessage(int level, String message) {
        switch(level) {
        case 0:
            log.debug(message);
            break;
        case 1:
            log.debug(message);
            break;
        case 2:
            log.warn(message);
            break;
        case 3:
            log.error(message);
            break;
        default:
            log.debug(message);
        }

    }
}
