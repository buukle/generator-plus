package top.buukle.opensource.generator.plus.service.engine.archetypes;

import lombok.Data;
import org.apache.maven.archetype.ArchetypeGenerationRequest;

@Data
public class MyArchetypeGenerationRequest extends ArchetypeGenerationRequest {

    private MyVelocityComponent myVelocityComponent = new MyVelocityComponent();

}
