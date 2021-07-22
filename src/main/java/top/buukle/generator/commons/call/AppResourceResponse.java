package top.buukle.generator.commons.call;



import top.buukle.generator.commons.call.head.ResponseHead;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle 公共请求规范
 */
public class AppResourceResponse {
    /** 响应头*/
    private ResponseHead head;

    /** 接口资源目录*/
    private List<String> apiResourceList;
    /** 会话资源目录*/
    private List<String> sessionResourceList;

    public AppResourceResponse(){

    }

    public AppResourceResponse(ResponseHead responseHead) {
        this.head = responseHead;
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public List<String> getApiResourceList() {
        return apiResourceList;
    }

    public void setApiResourceList(List<String> apiResourceList) {
        this.apiResourceList = apiResourceList;
    }

    public List<String> getSessionResourceList() {
        return sessionResourceList;
    }

    public void setSessionResourceList(List<String> sessionResourceList) {
        this.sessionResourceList = sessionResourceList;
    }

}





