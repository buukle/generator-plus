package top.buukle.opensource.arche.generator.service.constants;


import top.buukle.commons.call.code.BaseReturnEnum;

/**
 * @description
 * @Author jingkang
 * @Date 2020/12/1
 */
public enum SystemReturnEnum {

    SUCCESS(BaseReturnEnum.SUCCESS),
    FAILED(BaseReturnEnum.FAILED),
    RUD_ID_NULL("F","000000","ID为空"),
    DELETE_BATCH_IDS_NULL(BaseReturnEnum.FAILED),
    /**/
    GEN_TEMPLATE_IDS_NULL("F","980000","失败,模板ids为空!"),
    GEN_DATASOURCES_ID_NULL("F","980001","失败,连接ids为空!"),
    GEN_TABLES_NULL("F","980002","失败,表为空!"),
    GEN_CONFIGURES_ID_NULL("F","980003","失败,配置id为空"),
    GEN_CONFIGURES_FAILED("F","980004","执行失败!"),
    GEN_CONFIGURES_UPLOAD_ZIP_FAILED("F","980005","上传失败!"),
    GEN_CONFIGURES_GEN_BAT_SCRIPT_FAILED("F","980006","生成脚本文件失败!"),

    ;
    private String status;
    private String code;
    private String msg;

    SystemReturnEnum(BaseReturnEnum baseReturnEnum) {
        this.status = baseReturnEnum.getStatus();
        this.code = baseReturnEnum.getCode();
        this.msg = baseReturnEnum.getMsg();
    }
    SystemReturnEnum(String status, String code, String msg) {
        this.status = status;
        this.code = code;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
