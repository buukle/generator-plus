package top.buukle.generator.entity.vo;

import top.buukle.generator.commons.mvc.BaseQuery;
import top.buukle.generator.entity.Configures;
import top.buukle.generator.entity.Templates;

import java.util.List;


/**
* @author elvin
* @description  Configures 查询包装类
*/
public class ConfiguresQuery extends Configures implements BaseQuery {

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
    /** 连接名称*/
    private String datasourcesName;
    /** 模板ids*/
    private String templateIds;
    /** 模板集合*/
    private List<Templates> templatesList;
    /** 表名集合*/
    private List<TableVo> tableList;

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

    public String getDatasourcesName() {
        return datasourcesName;
    }

    public void setDatasourcesName(String datasourcesName) {
        this.datasourcesName = datasourcesName;
    }

    public List<Templates> getTemplatesList() {
        return templatesList;
    }

    public void setTemplatesList(List<Templates> templatesList) {
        this.templatesList = templatesList;
    }

    public String getTemplateIds() {
        return templateIds;
    }

    public void setTemplateIds(String templateIds) {
        this.templateIds = templateIds;
    }

    public List<TableVo> getTableList() {
        return tableList;
    }

    public void setTableList(List<TableVo> tableList) {
        this.tableList = tableList;
    }
}