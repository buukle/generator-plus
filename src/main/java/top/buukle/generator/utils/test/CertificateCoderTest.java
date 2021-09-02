/**
 * Copyright (C), 2015-2021  http://www.buukle.top
 * FileName: eweewe
 * Author:   86180
 * Date:     2021/1/20 15:38
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.generator.utils.test;

import org.junit.Test;
import top.buukle.generator.utils.RSA.CertificateCoder;

/**
 * @description 〈〉
 * @author 86180
 * @create 2021/1/20
 * @since 1.0.0
 */
public class CertificateCoderTest {

    /** 秘钥库密码. */
    private static final String keystore_password  = "123456";
    /** 证书密码. */
    private static final String ca_password   = "111111";
    /** 证书别名. */
    private static final String alias = "ljw";
    /** 密钥库文件. */
    private static final String keyStorePath = "D:\\Certifacate\\ljw.keystore";
    /** 数字证书文件. */
    private static final String certificatePath = "D:\\Certifacate\\ljw.cer";

    //我们假定密钥库文件yale.keystore存储在D盘根目录，数字证书文件yale.cer也存储在D盘根目录
    /****
     * 公钥加密---私钥解密
     * @throws Exception
     */
    @Test
    public void test1() throws Exception{
        System.err.println("公钥加密---私钥解密");
        String inputStr = "数字证书";
        byte[] data = inputStr.getBytes();
        //公钥加密
        byte[] encrypt = CertificateCoder.encryptByPublicKey(data, certificatePath);
        //私钥解密
        byte[] decrypt = CertificateCoder.decryptByPrivateKey(encrypt, keyStorePath, alias, keystore_password, ca_password);
        String outputStr = new String(decrypt);
        System.err.println("加密前：\n" + inputStr);
        System.err.println("解密后：\n" + outputStr);
    }

    /****
     * 私钥加密---公钥解密
     * @throws Exception
     */
    @Test
    public  void test2()throws Exception{
        System.err.println("私钥加密---公钥解密");
        String inputStr = "数字签名";
        byte[] data = inputStr.getBytes();
        //私钥加密
        byte[] encodedData = CertificateCoder.encryptByPriateKey(data, keyStorePath, alias, keystore_password, ca_password);
        //公钥解密
        byte[] decodeData = CertificateCoder.decryptByPublicKey(encodedData, certificatePath);
        String outputStr = new String (decodeData);
        System.err.println("加密前：\n" + inputStr);
        System.err.println("解密后：\n" + outputStr);
    }

    @Test
    public  void testSign()throws Exception{
        String inputStr = "签名";
        byte[] data = inputStr.getBytes();
        System.err.println("私钥签名---公钥验证");
        //产生签名
        byte[] sign = CertificateCoder.sign(data, keyStorePath, alias, keystore_password, ca_password);
        System.err.println("签名:\n" + sign);
        //验证签名
        boolean status = CertificateCoder.verify(data, sign, certificatePath);
        System.err.println("状态：\n " + status);
    }

}