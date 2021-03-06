/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: TableVo
 * Author:   elvin
 * Date:     2021/5/13 9:18
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.opensource.generator.plus.dtvo.vo.tables;

/**
 * @description 〈〉
 * @author elvin
 * @create 2021/5/13
 * @since 1.0.0
 */
public class TableVo {

    private String name;
    private boolean checked;

    public TableVo(String name, boolean checked) {
        this.name = name;
        this.checked = checked;
    }
    public TableVo( ) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}