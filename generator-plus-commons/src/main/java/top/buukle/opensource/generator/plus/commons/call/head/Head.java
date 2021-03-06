/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: Head
 * Author:   zhanglei1102
 * Date:     2019/7/26 15:09
 * Description: 来源头部规范
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.generator.plus.commons.call.head;

import lombok.Data;

/**
 * @description 〈来源头部规范〉
 * @author zhanglei1102
 * @create 2019/7/26
 * @since 1.0.0
 */
@Data
public class Head {

    /** 来源系统code*/
    private String appId;
    /** 来源操作时间*/
    private String operationTime;
    /** 来源操作人*/
    private String operator;
    /** 来源操作人Id*/
    private String operatorId;
    /** 来源操作人主租户Id*/
    private String operatorTenantId;
    /** 来源操作人下辖租户Ids*/
    private String operatorSubTenantIds;
    /** 签名 */
    private String signature;

    protected Head() {
    }

    public static class Builder {

        public static Head build() {
            Head head  = new Head();
            head.setOperationTime(System.currentTimeMillis() + "");
            return head;
        }
    }
}
