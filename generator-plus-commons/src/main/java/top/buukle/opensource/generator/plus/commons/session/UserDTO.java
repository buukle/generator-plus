package top.buukle.opensource.generator.plus.commons.session;

import lombok.Data;

@Data
public class UserDTO {

    private String username;
    private String userId;
    private String tenantId;
    private String subtenantIds;

}
