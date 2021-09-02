package top.buukle.generator.commons.session;

import lombok.Data;

import java.util.List;

@Data
public class UserDO {

    private String username;
    private String userId;
    private String deptId;
    private List<String> subDeptIds;

}
