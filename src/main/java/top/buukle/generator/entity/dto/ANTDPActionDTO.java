/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: ANTDPActionDTO
 * Author:   elvin
 * Date:     2021/7/26 19:21
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.entity.dto;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/7/26
 * @since 1.0.0
 */
public class ANTDPActionDTO {

    private String action        ;
    private String describe      ;
    private boolean defaultCheck  ;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public boolean isDefaultCheck() {
        return defaultCheck;
    }

    public void setDefaultCheck(boolean defaultCheck) {
        this.defaultCheck = defaultCheck;
    }
}