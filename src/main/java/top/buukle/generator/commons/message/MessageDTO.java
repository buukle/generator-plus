/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: MessageData
 * Author:   zhanglei1102
 * Date:     2019/12/3 18:29
 * Description: 消息数据包装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.commons.message;

/**
 * @description 〈消息数据包装类〉
 * @author zhanglei1102
 * @create 2019/12/3
 * @since 1.0.0
 */
public class MessageDTO<T> {

    private MessageHead head;

    private MessageActivityEnum activityEnum;

    private T body;

    public MessageDTO(MessageHead head, MessageActivityEnum activityEnum, T body) {
        this.head = head;
        this.activityEnum = activityEnum;
        this.body = body;
    }

    public MessageHead getHead() {
        return head;
    }

    public void setHead(MessageHead head) {
        this.head = head;
    }

    public MessageActivityEnum getActivityEnum() {
        return activityEnum;
    }

    public void setActivityEnum(MessageActivityEnum activityEnum) {
        this.activityEnum = activityEnum;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}