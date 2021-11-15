package top.buukle.opensource.generator.plus.commons.call;

import lombok.Data;
import top.buukle.opensource.generator.plus.commons.call.head.ResponseHead;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description : 分页响应
 */
@Data
public class PageResponse<T>{

    /** 响应头*/
    private ResponseHead head;
    /** 响应体*/
    private PageBody<T> body;

    private PageResponse(List<T> list, int pageNo, int pageSize, long total) {
        head = new ResponseHead.Builder().buildSuccess();
        body = new PageBody(list,pageNo,pageSize,total);
    }

    private PageResponse() {
    }

    private PageResponse(List<T> list) {
        head = new ResponseHead.Builder().buildSuccess();
        body = new PageBody(list);
    }

    public static class Builder{

        public <T> PageResponse <T> build(List<T> list, int pageNo, int pageSize, long total) {
            PageResponse<T> tPageResponse = new PageResponse<>(list, pageNo, pageSize, total);
            tPageResponse.getBody().setTotalPage(total % pageSize > 0 ? 1 + (total / pageSize) : (total / pageSize));
            return tPageResponse;
        }
    }

    @Data
    public class PageBody<T>{
        private Integer pageNo = 1;
        private Integer pageSize = 10;
        private long total;
        private long totalPage;
        private List<T> list;
        PageBody(List<T> list, int pageNo, int pageSize, long total) {
            this.pageNo =  pageNo;
            this.pageSize =  pageSize == 0 ? this.pageSize : pageSize;
            this.total =  total;
            this.list =  list;
        }
        public PageBody() {
        }
        public PageBody(List<T> list) {
            this.list =  list;
        }

    }
}

