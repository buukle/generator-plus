package top.buukle.opensource.generator.plus.web.archetypes;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.buukle.opensource.generator.plus.service.engine.archetypes.MyArchetypeGenerationRequest;
import top.buukle.opensource.generator.plus.service.engine.archetypes.MyFilesetArchetypeGenerator;
import top.buukle.opensource.generator.plus.service.engine.archetypes.MyVelocityComponent;

import java.io.File;
import java.util.Properties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {

    @Autowired
    MyFilesetArchetypeGenerator myFilesetArchetypeGenerator;

    /**
     * @description 根据archetypes的jar直接生成代码
     * @param
     * @return void
     * @Author zhanglei451
     * @Date 2021/9/15
     */
    @Test
    public void gen_test() throws Exception {

        MyArchetypeGenerationRequest archetypeGenerationRequest = new MyArchetypeGenerationRequest();

        archetypeGenerationRequest.setInteractiveMode(false);
        archetypeGenerationRequest.setArtifactId("buukle-ta");
        archetypeGenerationRequest.setGroupId("top.buukle");
        archetypeGenerationRequest.setPackage("one.two.three");
        archetypeGenerationRequest.setVersion("1.0.0");

        archetypeGenerationRequest.setOutputDirectory("D:\\zhanglei451\\Desktop\\t\\");

        MyVelocityComponent myVelocityComponent = new MyVelocityComponent();
        Properties properties = new Properties();
        properties.setProperty("resource.loader", "jar");
        properties.setProperty("jar.resource.loader.class", "org.apache.velocity.runtime.resource.loader.JarResourceLoader");
        properties.setProperty("jar.resource.loader.path", "jar:file:D:\\file\\temp\\111\\generator-plus-archetype-1.0.0-RELEASE.jar");
        VelocityEngine velocityEngine = new VelocityEngine(properties);
        myVelocityComponent.setEngine(velocityEngine);
        myVelocityComponent.initialize();
        archetypeGenerationRequest.setMyVelocityComponent(myVelocityComponent);

        myFilesetArchetypeGenerator.generateArchetype(archetypeGenerationRequest,new File("D:\\file\\temp\\111\\generator-plus-archetype-1.0.0-RELEASE.jar"));
    }

}
