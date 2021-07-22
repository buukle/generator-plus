package top.buukle.generator.utils.test;



import top.buukle.generator.utils.RSA.RSACoder;
import org.junit.Before;
import org.junit.Test;

import java.net.URLEncoder;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * elvin
 */
public class RSACoderTest {
    private String publicKey;
    private String privateKey;

    @Before
    public void setUp() throws Exception {
        Map<String, Object> keyMap = RSACoder.initKey();
        publicKey = RSACoder.getPublicKey(keyMap);
        privateKey = RSACoder.getPrivateKey(keyMap);
        System.out.println("公钥: \n\r" + publicKey);
        System.out.println("私钥： \n\r" + privateKey);
    }

    /**
     * @description 公钥加密,私钥解密 - 测试
     * @param
     * @return void
     * @Author 86180
     * @Date 2020/10/21
     */
    @Test
    public void publicKeyEncryptPrivateDecrypt_test() throws Exception {
        String inputStr = "abc";
        byte[] data = inputStr.getBytes();
        byte[] encodedData = RSACoder.encryptByPublicKey(data, publicKey);
        byte[] decodedData = RSACoder.decryptByPrivateKey(encodedData, privateKey);
        String outputStr = new String(decodedData);
        System.out.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        assertEquals(inputStr, outputStr);
    }

    /**
     * @description 私钥加密,公钥解密 - 测试
     * @param
     * @return void
     * @Author 86180
     * @Date 2020/10/21
     */
    @Test
    public void privateEncryptPublicKeyDecrypt_test() throws Exception {
        String inputStr = "def";
        byte[] data = inputStr.getBytes();
        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);
        byte[] decodedData = RSACoder.decryptByPublicKey(encodedData, publicKey);
        String outputStr = new String(decodedData);
        System.out.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);
        assertEquals(inputStr, outputStr);
    }

    /**
     * @description 签名验签 - 测试
     * @param
     * @return void
     * @Author 86180
     * @Date 2020/10/21
     */
    @Test
    public void signVerify_test() throws Exception {
        String inputStr = "sign";
        // 私钥签名
        String sign = RSACoder.sign(inputStr.getBytes(), privateKey);
        System.out.println("签名:" + sign);
        // 公钥验签
        boolean status = RSACoder.verify(inputStr.getBytes(), publicKey, sign,false);
        System.out.println("状态:" + status);
        assertTrue(status);
    }

    /**
     * @description 签名验签 - 测试
     * @param
     * @return void
     * @Author 86180
     * @Date 2020/10/21
     */
    @Test
    public void signOAthu2_test() throws Exception {
        String inputStr = "code-ade0103531294cef8507c534f8b2a356";
        //认证中心服务
        String privateKey="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKWsGb5F4yGhSPAD/53WbDfnUhr1vWY2Nd+Gc86ScfKbLs3Q/08J22dBq9SH+QwpVqj4ehqE+VNHmOMgowLo6zw0czzFHlvGF5/PRw+mOpKoNhdElkDB/Bwgo6GoePaj3waez14fsiJD7/lC3KsLMY2w7K1ybpLxeV7X65jXJIA9AgMBAAECgYEAoakT3bU4c0J8d6iPL6diJhLU7XXJgQl4/EqoinQgOInw2+kKmEeYDmPolhSwkotsAqmkDGihGgCNUWQxbM93adAgkyI4F6r5a6vTI9l9/LACnYAQy/+/h9kU3STe+QU94neE/ml/mYWKwDfkgJqQUw3UH1971VlNouTSdbjgv0ECQQDPAM9inOTeq6bSSvp6hsGEy9rvfktfZG/3tJUHb2zfgO/MtQCOYF62rXWt7xF45Iryid1AdfnLI5AQV0uHLynZAkEAzOLgyrG393Ab+HdGuAllJFi0NRNMc3KQrAZ9oWGNJRRYPgFk7nK2qkgKDV8QAwJYjdr5bdIuT0qO40qiX5nHBQJAZzTNMSpuRcKpSuHNHne/VllZD90U8TufQ44KW4mna4vag2KfI11S+5tiN9UhDfhMen5YDIKFh010z2DmrEDMiQJBAK4nr8I7nE+EiRIDeSZYPhPOHqf61oJPgK/o+ILj49D/4R4bm0qgUaqef4TsKDUWmmVCG8EA5oJZsul6+Fhg420CQEn2AXqNE0teN0Q0RS1t8TFGJgbt6hE6fksa/mVlbB2CyLwDzlcsmbXefjue4xQhTCncf7kSctK0EutDQKTnsl0=";
        String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQClrBm+ReMhoUjwA/+d1mw351Ia9b1mNjXfhnPOknHymy7N0P9PCdtnQavUh/kMKVao+HoahPlTR5jjIKMC6Os8NHM8xR5bxhefz0cPpjqSqDYXRJZAwfwcIKOhqHj2o98Gns9eH7IiQ+/5QtyrCzGNsOytcm6S8Xle1+uY1ySAPQIDAQAB";

        // 私钥签名
        System.out.println("验签内容："+inputStr);
        String sign = RSACoder.sign(inputStr.getBytes(), privateKey);
        System.out.println("签名:" + sign);
        String encode = URLEncoder.encode(sign,"UTF-8");
        System.out.println("签名URL编码:" + encode);
        // 公钥验签
        boolean status = RSACoder.verify(inputStr.getBytes(), publicKey, sign,false);
        System.out.println("状态:" + status);
        assertTrue(status);
    }
}