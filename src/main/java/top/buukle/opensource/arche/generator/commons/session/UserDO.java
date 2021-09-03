package top.buukle.opensource.arche.generator.commons.session;

import lombok.Data;

import java.util.List;

@Data
public class UserDO {

    private String username;
    private String userId;
    private Integer deptId;
    private List<String> subDeptIds;

}
