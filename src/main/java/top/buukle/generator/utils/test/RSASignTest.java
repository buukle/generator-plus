package top.buukle.generator.utils.test;

import top.buukle.generator.utils.JsonUtil;
import top.buukle.generator.utils.RSA.RSACoder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RSASignTest {

    /**
     * @param
     * @return void
     * @description 签名验签 - 测试
     * @Author 86180
     * @Date 2020/10/21
     */
    @Test
    public void signOAthu2_test() throws Exception {
        //应用私钥
        String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJXUoXgCOOw8jSMAKgIGAcTmdeop8iBEIE5qMZEj44+iRCF16eppw9/7rY3OWU76QuAA/NsRoKjrdDqiZCj2z+rl9KViAtAxu1aDpZ0b0q6yfrGn7IugS+5wH9DobGVdg4PaLO4n6LLA8tiwVOwmPAHnOwF0ysb+/+Uj5GQpfa2FAgMBAAECgYEAkODxXYTwm+YVJ1ICTMCYN1gNjucOfIrDnm9rDIhig8IJFT3aeVPaFpxbfrKYgxjVT5tE5WQPMSez1Pqv1TiLZIGxNYeYOdISXBJAm9pou/sBgtCmdiV6rbrdXa/GpQr+VHPxFdg6ZLKs+hQilmLZUsh+xeEqvMlzVKG+FD2a64ECQQDO6Kj9QmLFlz474VvhWvHCA6xkfQMdXUy4tIAmuCxu1YhVHRL4PUNnKPENQiqQWPccGQEECme4Q04p6IfEs72hAkEAuWEfKwmUqrxHJ5JMpgfP/d27PkiwM6dYpOab5xLuDtN5Iht0fd1/0gDj5VJa7DqHBvZtj6YNvwvv8EP2KxS9ZQJAPaijw2UnHg7mIt4TjWKWrOR/WSrP5M5K8LgJgIBd7WGA0Sxq3MMU9QcEXpkbKgz5BsyEuvmG0yhrgJ2k5/9QQQJAeNpVPHR5hDlMVgLtj0wGj6VPHZK7tGEDzDU/LAzOP8Ij9VVaw3d0jg7gg68F8X1Sa/qZgI2r5oG8wbE8uedCdQJAR8IGRHI83trMz8Jv+UuERjS+Fwddwmgoulct5muiTrRfm0zycigMSMxBZvLpe6huPJs3wpAijw3hjt5uQZZDPQ==";
        //应用公钥
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCV1KF4AjjsPI0jACoCBgHE5nXqKfIgRCBOajGRI+OPokQhdenqacPf+62NzllO+kLgAPzbEaCo63Q6omQo9s/q5fSlYgLQMbtWg6WdG9Kusn6xp+yLoEvucB/Q6GxlXYOD2izuJ+iywPLYsFTsJjwB5zsBdMrG/v/lI+RkKX2thQIDAQAB";

        //1、组装请求参数
        Map param = new HashMap<String, Map<String, String>>();
        Map head = new HashMap<String, String>();
        Map body = new HashMap<String, String>();

        //2、组装head
        head.put("applicationCode", "test-buukle-password");
        head.put("operationTime", "dafddfadf");
        param.put("head", head);

        //3、组装body 上传文件接口签名只需组装head，只对head签名，可跳过这步。
        body.put("param1", "dfadfadf");
        param.put("body", body);

        //4、将参数转换为String
        String paramString = JsonUtil.toJSONString(param);

        //5、私钥签名
        System.out.println("签名内容：" + paramString);
        System.out.println("应用私钥：" + privateKey);
        String sign = RSACoder.sign(paramString.getBytes(), privateKey);
        System.out.println("签名:" + sign);

        //6、公钥验签
        System.out.println("应用公钥：" + publicKey);
        boolean status = RSACoder.verifyWithBase64Utils(paramString.getBytes(), publicKey, sign, false);
        System.out.println("状态:" + status);
    }
}
