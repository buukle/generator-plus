package top.buukle.generator.entity.vo;

import top.buukle.generator.commons.mvc.BaseQuery;
import top.buukle.generator.entity.Datasources;


/**
* @author elvin
* @description  Datasources 查询包装类
*/
public class DatasourcesQuery extends Datasources implements BaseQuery{

    /** 当前页码*/
    private Integer page;
    /** 页长*/
    private Integer pageSize;
    /** 起始时间*/
    private String startTime;
    /** 截止时间*/
    private String endTime;
    /** 状态*/
    private String states;
    /** 下拉框名称*/
    private String title;



    public String getStates() {
        if("null".equals(states)){
            return null;
        }
        return this.states;
    }

    public void setStates(String states) {
        if("null".equals(states)){
            states = null;
        }
        this.states = states;
    }

    public Integer getPage() {
        return page == null ? 1 : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}