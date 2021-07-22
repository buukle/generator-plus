package top.buukle.generator.commons.call;

import top.buukle.generator.commons.call.head.ResponseHead;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description : 分页响应
 */
public class PageResponse<T>{

    /** 响应头*/
    private ResponseHead head;
    /** 响应体*/
    private PageBody<T> body;

    PageResponse(List<T> list, int pageNo, int pageSize, long total) {
        head = new ResponseHead.Builder().buildSuccess();
        body = new PageBody(list,pageNo,pageSize,total);
    }

    public PageResponse() {
    }

    public PageResponse(List<T> list) {
        head = new ResponseHead.Builder().buildSuccess();
        body = new PageBody(list);
    }
    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public PageBody<T> getBody() {
        return body;
    }

    public void setBody(PageBody<T> body) {
        this.body = body;
    }

    public static class Builder<T>{
        public PageResponse build(List<T> list, int pageNo, int pageSize, long total) {
            return new PageResponse(list,pageNo,pageSize,total);
        }
        public PageResponse buildWithoutPage(List<T> list) {
            return new PageResponse(list);
        }
    }
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
        public Integer getPageNo() {
            return pageNo;
        }

        public void setPageNo(Integer pageNo) {
            this.pageNo = pageNo;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public long getTotalPage() {
            return  total % pageSize > 0 ? 1 + (total / pageSize) : (total / pageSize);
        }

        public void setTotalPage(long totalPage) {
            this.totalPage = totalPage;
        }
    }
}

