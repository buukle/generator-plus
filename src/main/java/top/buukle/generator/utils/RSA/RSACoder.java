package top.buukle.generator.utils.RSA;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/6/6.
 * @Description :
 */


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * RSA安全编码组件
 *
 * @author 梁栋
 * @version 1.0
 * @since 1.0
 */
public abstract class RSACoder extends Coder {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /** 验签本地缓存*/
    private static final Cache<String,Boolean> VERIFY_LOCAL_CACHE = CacheBuilder.newBuilder()
                // 设置缓存容器的初始化容量为10（可以存10个键值对）
                .initialCapacity(1024 * 5)
                // 最大缓存容量是100,超过100后会安装LRU策略-最近最少使用，具体百度-移除缓存项
                .maximumSize(1024 * 10)
                // 设置写入缓存后1分钟后过期
                .expireAfterWrite(500, TimeUnit.MILLISECONDS).build();

    /**
     * @description 用私钥对信息生成数字签名
     * @param data
     * @param privateKey
     * @return java.lang.String
     * @Author 86180
     * @Date 2020/10/21
     */
    public static String sign(byte[] data, String privateKey) throws Exception {
        // 解密由base64编码的私钥
        byte[] keyBytes = decryptBASE64(privateKey);
        // 构造PKCS8EncodedKeySpec对象
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取私钥匙对象
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(priKey);
        signature.update(data);
        return encryptBASE64(signature.sign());
    }

    /**
     * @description 校验数字签名
     * @param data
     * @param publicKey
     * @param sign
     * @return boolean
     * @Author 86180
     * @Date 2020/10/21
     */
    public static boolean verify(byte[] data, String publicKey, String sign,boolean isOpenLocalCache)throws Exception {
        if(isOpenLocalCache){
            Boolean isPass = VERIFY_LOCAL_CACHE.getIfPresent(publicKey);
            if(null != isPass){
                return isPass;
            }
        }
        // 解密由base64编码的公钥
        byte[] keyBytes = decryptBASE64(publicKey);
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
        // 验证签名是否正常
        boolean result = signature.verify(decryptBASE64(sign));
        // 加入本地缓存
        VERIFY_LOCAL_CACHE.put(publicKey,result);
        return result;
    }

    /**
     * @description 校验数字签名
     * @param data
     * @param publicKey
     * @param sign
     * @return boolean
     * @Author 86180
     * @Date 2020/10/21
     */
    public static boolean verifyWithBase64Utils(byte[] data, String publicKey, String sign,boolean isOpenLocalCache)throws Exception {
        if(isOpenLocalCache){
            Boolean isPass = VERIFY_LOCAL_CACHE.getIfPresent(publicKey);
            if(null != isPass){
                return isPass;
            }
        }
        // 解密由base64编码的公钥
        byte[] keyBytes = Base64Utils.decodeFromString(publicKey);
        // 构造X509EncodedKeySpec对象
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        // KEY_ALGORITHM 指定的加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        // 取公钥匙对象
        PublicKey pubKey = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(pubKey);
        signature.update(data);
        // 验证签名是否正常
        boolean result = signature.verify(Base64Utils.decodeFromString(sign));
        // 加入本地缓存
        VERIFY_LOCAL_CACHE.put(publicKey,result);
        return result;
    }

    /**
     * @description 用私钥解密
     * @param data
     * @param key
     * @return byte[]
     * @Author 86180
     * @Date 2020/10/21
     */
    public static byte[] decryptByPrivateKey(byte[] data, String key)throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * @description 用私钥解密
     * @param data
     * @param key
     * @return byte[]
     * @Author 86180
     * @Date 2020/10/21
     */
    public static byte[] decryptByPublicKey(byte[] data, String key) throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * @description 用公钥加密
     * @param data
     * @param key
     * @return byte[]
     * @Author 86180
     * @Date 2020/10/21
     */
    public static byte[] encryptByPublicKey(byte[] data, String key)throws Exception {
        // 对公钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得公钥
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicKey = keyFactory.generatePublic(x509KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(data);
    }

    /**
     * @description 用私钥加密
     * @param data
     * @param key
     * @return byte[]
     * @Author 86180
     * @Date 2020/10/21
     */
    public static byte[] encryptByPrivateKey(byte[] data, String key)throws Exception {
        // 对密钥解密
        byte[] keyBytes = decryptBASE64(key);
        // 取得私钥
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);
        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);
        return cipher.doFinal(data);
    }

    /**
     * @description 获取私钥
     * @param keyMap
     * @return java.lang.String
     * @Author 86180
     * @Date 2020/10/21
     */
    public static String getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * @description 获取公钥
     * @param keyMap
     * @return java.lang.String
     * @Author 86180
     * @Date 2020/10/21
     */
    public static String getPublicKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return encryptBASE64(key.getEncoded());
    }

    /**
     * @description 初始化密钥
     * @param
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @Author 86180
     * @Date 2020/10/21
     */
    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // 公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        // 私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }
}