package top.buukle.generator.utils;

import org.springframework.util.CollectionUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;


/**
 * CSV操作(导出和导入)
 *
 */
public class CsvUtil {

    private static final String NEXT_LINE = "\r";
    private static final String CST_FILE_PREFIX = "csv-temp";
    private static final String CST_FILE_EXTEND_NAME = ".csv";
    private static final String NO_CONTENT = "暂无数据!";
    private static final String CHINESE_COMMA = "，";

    public static File create(String name, String count, String[] titleArr, String[] fieldNameArr, List<?> dataList) {
        String filename = CST_FILE_PREFIX +  UUID.randomUUID().toString() + CST_FILE_EXTEND_NAME;
        File file = new File(filename);

        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            osw = new OutputStreamWriter(fileOutputStream, "UTF-8");
            byte [] bs = { (byte)0xEF, (byte)0xBB, (byte)0xBF};
            fileOutputStream.write(bs);
            bw = new BufferedWriter(osw);
            // 写入 name
            bw.append(name).append(StringUtil.COMMA);
            bw.append(NEXT_LINE);
            // 写入 count
            bw.append(count).append(StringUtil.COMMA);
            bw.append(NEXT_LINE);
            // 写入 title
            bw.append("序号").append(StringUtil.COMMA);
            for (String title : titleArr){
                // 将英文逗号转成中文,避免出现串列
                if(!StringUtil.isEmpty(title)){
                    title = title.replace(StringUtil.COMMA,CHINESE_COMMA);
                }
                bw.append(title).append(StringUtil.COMMA);
            }
            bw.append(NEXT_LINE);
            // 没有,写入空内容
            if(CollectionUtils.isEmpty(dataList)) {
                bw.append(NO_CONTENT).append(StringUtil.COMMA);
            }
            // 有,写入行级内容
            else{
                Integer orderNo = 0;
                for (Object  object : dataList) {
                    // 写入序号
                    bw.append(String.valueOf(++orderNo)).append(StringUtil.COMMA);
                    Class<?> clazz = object.getClass();
                    // 反射写入字段名到单元格
                    for (String fieldName : fieldNameArr){
                        Field field = getField(clazz,fieldName);
                        if(field != null){
                            field.setAccessible(true);
                            Object o = field.get(object);
                            String content =  o == null ? StringUtil.EMPTY : o.toString();
                            // 将英文逗号转成中文,避免出现串列
                            if(!StringUtil.isEmpty(content)){
                                content = content.replace(StringUtil.COMMA,CHINESE_COMMA);
                            }
                            bw.append(content).append(StringUtil.COMMA);
                        }else{
                            bw.append(StringUtil.EMPTY).append(StringUtil.COMMA);
                        }
                    }
                    // 写入换行
                    bw.append(NEXT_LINE);
                }
            }
        } catch ( Exception e) {
            e.printStackTrace();
        }finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (osw != null) {
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file;
    }

    private static Field getField( Class<?> clazz, String fieldName) {
        Field  field = null;
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class<?> superclass = clazz.getSuperclass();
            if(superclass != null){
                return getField(superclass,fieldName);
            }else{
                return null;
            }
        }
    }
}
