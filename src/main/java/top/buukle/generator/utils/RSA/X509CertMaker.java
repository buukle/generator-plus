package top.buukle.generator.utils.RSA;///**
// * Copyright (C), 2015-2021  http://www.buukle.top
// * FileName: EWEWW
// * Author:   86180
// * Date:     2021/1/20 15:51
// * Description:
// * History:
// * <author>          <time>          <version>          <desc>
// * 作者姓名           修改时间           版本号              描述
// */
//package top.buukle.generator.utils.RSA;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.security.InvalidKeyException;
//import java.security.Key;
//import java.security.KeyStore;
//import java.security.KeyStoreException;
//import java.security.NoSuchAlgorithmException;
//import java.security.NoSuchProviderException;
//import java.security.PrivateKey;
//import java.security.SecureRandom;
//import java.security.SignatureException;
//import java.security.UnrecoverableKeyException;
//import java.security.cert.Certificate;
//import java.security.cert.CertificateException;
//import java.security.cert.CertificateFactory;
//import java.security.cert.X509Certificate;
//import java.util.Date;
//
//import sun.security.tools.keytool.CertAndKeyGen;
//import sun.security.x509.AlgorithmId;
//import sun.security.x509.CertificateAlgorithmId;
//import sun.security.x509.CertificateIssuerName;
//import sun.security.x509.CertificateSerialNumber;
//import sun.security.x509.CertificateSubjectName;
//import sun.security.x509.CertificateValidity;
//import sun.security.x509.CertificateVersion;
//import sun.security.x509.CertificateX509Key;
//import sun.security.x509.X500Name;
//import sun.security.x509.X509CertImpl;
//import sun.security.x509.X509CertInfo;
//
//public class X509CertMaker {
//
//    private SecureRandom secureRandom;
//
//    public X509CertMaker() {
//        try {
//            secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 创建根证书
//     *
//     * @param issuePfxPath-->根证书pfx存储路径
//     * @param issueCrtPath-->根证书crt存储路径
//     * @param length-->秘钥长度
//     * @param issue-->颁发者&接收颁发者
//     * @param effectiveDays-->有效天
//     * @param rootAlias-->别名
//     * @param storePasswd-->证书库秘钥
//     * @param certPasswd-->证书秘钥
//     * @throws NoSuchAlgorithmException
//     * @throws NoSuchProviderException
//     * @throws InvalidKeyException
//     * @throws IOException
//     * @throws CertificateException
//     * @throws SignatureException
//     * @throws KeyStoreException
//     */
//    public void createRootCert(String issuePfxPath, String issueCrtPath, int length, X500Name issue, int effectiveDays,
//                               String rootAlias, String storePasswd, String certPasswd)
//            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, IOException,
//            CertificateException, SignatureException, KeyStoreException {
//        CertAndKeyGen rootCertAndKeyGen = new CertAndKeyGen("RSA", "MD5WithRSA", null);
//        rootCertAndKeyGen.setRandom(secureRandom);
//        rootCertAndKeyGen.generate(length);
//        X509Certificate rootCertificate = rootCertAndKeyGen.getSelfCertificate(issue, effectiveDays * 24L * 60L * 60L);
//        X509Certificate[] X509Certificates = new X509Certificate[] { rootCertificate };
//        createKeyStore(rootAlias, rootCertAndKeyGen.getPrivateKey(), storePasswd.toCharArray(),
//                certPasswd.toCharArray(), X509Certificates, issuePfxPath);
//        FileOutputStream fos = new FileOutputStream(new File(issueCrtPath));
//        fos.write(rootCertificate.getEncoded());
//        fos.close();
//    }
//
//    /**
//     * 证书私钥存储设施
//     *
//     * @param alias-->KeyStore别名
//     * @param key-->密钥（这里是私钥）
//     * @param storePasswd-->证书库秘钥
//     * @param certPasswd-->证书秘钥
//     * @param chain-->证书链
//     * @param filePath-->pfx文件路径
//     * @throws KeyStoreException
//     * @throws NoSuchAlgorithmException
//     * @throws CertificateException
//     * @throws IOException
//     */
//    private void createKeyStore(String alias, Key key, char[] storePasswd, char[] certPasswd, Certificate[] chain,
//                                String filePath) throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException {
//        KeyStore keyStore = KeyStore.getInstance("pkcs12");
//        keyStore.load(null);
//        keyStore.setKeyEntry(alias, key, certPasswd, chain);
//        FileOutputStream fos = new FileOutputStream(filePath);
//        keyStore.store(fos, storePasswd);
//        fos.close();
//    }
//
//    /**
//     * 颁布证书
//     *
//     * @param subjectPfxPath
//     * @param subjectCrtPath
//     * @param length
//     * @param subject
//     * @param effectiveDays
//     * @param subjectAlias
//     * @param storePasswd
//     * @param subjectPasswd
//     * @param issuePfxPath
//     * @param issueCrtPath
//     * @param issueAlias
//     * @param issue
//     * @param issueStorePasswd
//     * @param issueCertPasswd
//     * @throws NoSuchAlgorithmException
//     * @throws NoSuchProviderException
//     * @throws InvalidKeyException
//     * @throws CertificateException
//     * @throws IOException
//     * @throws KeyStoreException
//     * @throws UnrecoverableKeyException
//     * @throws SignatureException
//     */
//    public void createIssueCert(String subjectPfxPath, String subjectCrtPath, int length, X500Name subject,
//                                int effectiveDays, String subjectAlias, String storePasswd, String subjectPasswd, String issuePfxPath,
//                                String issueCrtPath, String issueAlias, X500Name issue, String issueStorePasswd, String issueCertPasswd)
//            throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, CertificateException,
//            IOException, KeyStoreException, UnrecoverableKeyException, SignatureException {
//        CertAndKeyGen certAndKeyGen = new CertAndKeyGen("RSA", "MD5WithRSA", null);
//        certAndKeyGen.setRandom(secureRandom);
//        certAndKeyGen.generate(length);
//        String sigAlg = "MD5WithRSA";
//        // 1年
//        Date firstDate = new Date();
//        Date lastDate = new Date();
//        lastDate.setTime(firstDate.getTime() + effectiveDays * 24L * 60L * 60L * 1000);
//        CertificateValidity interval = new CertificateValidity(firstDate, lastDate);
//        X509CertInfo info = new X509CertInfo();
//        // Add all mandatory attributes
//        info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
//        info.set(X509CertInfo.SERIAL_NUMBER,
//                new CertificateSerialNumber(new java.util.Random().nextInt() & 0x7fffffff));
//        AlgorithmId algID = AlgorithmId.get(sigAlg);
//        info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algID));
//        info.set(X509CertInfo.SUBJECT, new CertificateSubjectName(subject));
//        info.set(X509CertInfo.KEY, new CertificateX509Key(certAndKeyGen.getPublicKey()));
//        info.set(X509CertInfo.VALIDITY, interval);
//        info.set(X509CertInfo.ISSUER, new CertificateIssuerName(issue));
//        // 读取私钥
//        PrivateKey privateKey = readPrivateKey(issueAlias, issuePfxPath, issueStorePasswd, issueCertPasswd);
//        X509CertImpl cert = new X509CertImpl(info);
//        cert.sign(privateKey, sigAlg);
//        X509Certificate certificate = (X509Certificate) cert;
//        X509Certificate issueCertificate = readX509Certificate(issueCrtPath);
//        X509Certificate[] X509Certificates = new X509Certificate[] { certificate, issueCertificate };
//        createKeyStore(subjectAlias, certAndKeyGen.getPrivateKey(), storePasswd.toCharArray(),
//                subjectPasswd.toCharArray(), X509Certificates, subjectPfxPath);
//        FileOutputStream fos = new FileOutputStream(new File(subjectCrtPath));
//        fos.write(certificate.getEncoded());
//        fos.close();
//    }
//
//    /**
//     * @param alias-->别名
//     * @param pfxPath-->PFX文件路径
//     * @param storePasswd-->证书库密码
//     * @param certPasswd-->证书密码
//     * @return
//     * @throws KeyStoreException
//     * @throws NoSuchAlgorithmException
//     * @throws CertificateException
//     * @throws IOException
//     * @throws UnrecoverableKeyException
//     */
//    public PrivateKey readPrivateKey(String alias, String pfxPath, String storePasswd, String certPasswd)
//            throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException,
//            UnrecoverableKeyException {
//        KeyStore keyStore = KeyStore.getInstance("pkcs12");
//        FileInputStream fis = new FileInputStream(pfxPath);
//        keyStore.load(fis, storePasswd.toCharArray());
//        fis.close();
//        return (PrivateKey) keyStore.getKey(alias, certPasswd.toCharArray());
//    }
//
//    /**
//     * 读取X.509证书
//     *
//     * @param crtPath 证书路径
//     * @return
//     * @throws CertificateException
//     * @throws IOException
//     */
//    public X509Certificate readX509Certificate(String crtPath) throws CertificateException, IOException {
//        InputStream inStream = new FileInputStream(crtPath);
//        CertificateFactory cf = CertificateFactory.getInstance("X.509");
//        X509Certificate cert = (X509Certificate) cf.generateCertificate(inStream);
//        inStream.close();
//        return cert;
//    }
//
//    /**
//     * @param args
//     * @throws IOException
//     */
//    public static void main(String args[]) throws IOException {
//        String issuePfxPath = "D://cert//RootCA.pfx";
//        String issueCrtPath = "D://cert//RootCA.crt";
//        int length = 2048;
//        X500Name issue = new X500Name("CN=RootCA,OU=SAMC,O=www.what21.com,L=TY,ST=SX,C=CN");
//        int effectiveDays = 3650;
//        String rootAlias = "RootCA";
//        String storePasswd = "12345678";
//        String certPasswd = "123456";
//        // ===================================================================//
//        // 生成根证书
//        // ===================================================================//
//        X509CertMaker x509CertMaker = new X509CertMaker();
//        try {
//            x509CertMaker.createRootCert(issuePfxPath, issueCrtPath, length, issue, effectiveDays, rootAlias,
//                    storePasswd, certPasswd);
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (CertificateException e) {
//            e.printStackTrace();
//        } catch (SignatureException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        }
//        // ===================================================================//
//        // 生成签名证书
//        // ===================================================================//
//        String subjectPfxPath = "c://cert//issue.pfx";
//        String subjectCrtPath = "c://cert//issue.crt";
//        int subjectLength = 2048;
//        X500Name subject = new X500Name("CN=Subject,OU=SAMC,O=www.what21.com,L=TY,ST=SX,C=CN");
//        int subjectEffectiveDays = 365;
//        String subjectAlias = "Subject";
//        String subjectStorePasswd = "abcd1234";
//        String subjectPasswd = "abcd12";
//        try {
//            x509CertMaker.createIssueCert(subjectPfxPath, subjectCrtPath, subjectLength, subject, subjectEffectiveDays,
//                    subjectAlias, subjectStorePasswd, subjectPasswd, issuePfxPath, issueCrtPath, rootAlias, issue,
//                    storePasswd, certPasswd);
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (UnrecoverableKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (NoSuchProviderException e) {
//            e.printStackTrace();
//        } catch (CertificateException e) {
//            e.printStackTrace();
//        } catch (KeyStoreException e) {
//            e.printStackTrace();
//        } catch (SignatureException e) {
//            e.printStackTrace();
//        }
//    }
//}