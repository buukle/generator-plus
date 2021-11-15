package top.buukle.opensource.generator.plus.commons.call;


import lombok.Data;
import top.buukle.opensource.generator.plus.commons.call.head.Head;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle 公共请求规范
 */
@Data
public class CommonRequest<T>{

    /** 请求头*/
    private Head head;
    /** 请求体*/
    private T body;

    public static class Builder {

        public static CommonRequest build(String applicationName) {
            CommonRequest commonRequest =  new CommonRequest<>();
            Head head  = new Head.Builder().build();
            head.setApplicationCode(applicationName);
            head.setOperator(applicationName);
            head.setOperatorId(applicationName);
            commonRequest.setHead(head);
            return commonRequest;
        }
    }
}


