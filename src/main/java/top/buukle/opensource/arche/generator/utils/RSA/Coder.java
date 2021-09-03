package top.buukle.opensource.arche.generator.utils.RSA;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/6/6.
 * @Description :
 */
import org.apache.tomcat.util.codec.binary.Base64;

public class Coder {

    /**
     * @description BASE64解密
     * @param key
     * @return byte[]
     * @Author 86180
     * @Date 2020/10/21
     */
    public static byte[] decryptBASE64(String key)  {
        return Base64.decodeBase64(key);
    }

    /**
     * @description BASE64加密
     * @param key
     * @return java.lang.String
     * @Author 86180
     * @Date 2020/10/21
     */
    public static String encryptBASE64(byte[] key) {
        return new String(Base64.encodeBase64(key));
    }
}
