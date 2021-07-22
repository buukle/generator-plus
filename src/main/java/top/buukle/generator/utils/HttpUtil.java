package top.buukle.generator.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

public class HttpUtil {
    public static final String STATUS_CODE_KEY = "STATUS_CODE_KEY";
    public static final String RESULT_KEY = "RESULT_KEY";

    /*
           Http协议GET请求
          */
     public static String httpGet(String url) throws Exception{
         //初始化HttpClient
         CloseableHttpClient httpClient = HttpClients.createDefault();
         //创建HttpGet
         HttpGet httpGet = new HttpGet(url);
         //发起请求，获取response对象
         CloseableHttpResponse response = httpClient.execute(httpGet);
         //获取请求状态码
         int statusCode = response.getStatusLine().getStatusCode();
         if (statusCode != HttpStatus.SC_OK){
             throw new Exception("http 请求异常,返回码 : " + statusCode);
         }
         //获取返回数据实体对象
         HttpEntity entity = response.getEntity();
         //转为字符串
         String result = EntityUtils.toString(entity,"UTF-8");
         return result;

     }
     /*
       Http协议Post请求
      */
     public static String httpPost (String url,String json) throws Exception {
         //初始HttpClient
         CloseableHttpClient httpClient = HttpClients.createDefault();
         //创建Post对象
         HttpPost httpPost = new HttpPost(url);
         //设置Content-Type
         httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
         //写入JSON数据
         httpPost.setEntity(new StringEntity(json));
         //发起请求，获取response对象
         CloseableHttpResponse response = httpClient.execute(httpPost);
         //获取请求码
         //response.getStatusLine().getStatusCode();
         //获取返回数据实体对象
         HttpEntity entity = response.getEntity();
         //转为字符串
         String result = EntityUtils.toString(entity,"UTF-8");
         return result;

     }


    public static String httpsGet(String url) throws Exception{
        CloseableHttpClient hp = createSSLClientDefault();
        HttpGet hg = new HttpGet(url);
        CloseableHttpResponse response = hp.execute(hg);
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity,"UTF-8");
        hp.close();
        return content;
    }

    public static String httpsPost(String url, String json) throws Exception{

         CloseableHttpClient hp = createSSLClientDefault();
         HttpPost httpPost = new HttpPost(url);
         httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
         httpPost.setEntity(new StringEntity(json));
         CloseableHttpResponse response = hp.execute(httpPost);
         HttpEntity entity = response.getEntity();
         String content = EntityUtils.toString(entity,"UTF-8");
         hp.close();
         return content;
    }


    public static CloseableHttpClient createSSLClientDefault() throws Exception{

        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy(){
            //信任所有
            public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        }).build();
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        return HttpClients.custom().setSSLSocketFactory(sslsf).build();
    }

    public static Map<String,String> httpPostWithCodeAndResult(String url, String json) throws IOException {
        //初始HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(6000).setConnectTimeout(6000).build();
        //创建Post对象
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        //设置Content-Type
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        //写入JSON数据
        httpPost.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));
        //发起请求，获取response对象
        CloseableHttpResponse response = httpClient.execute(httpPost);
        //获取请求码
        int statusCode = response.getStatusLine().getStatusCode();
        //获取返回数据实体对象
        HttpEntity entity = response.getEntity();
        //转为字符串
        String result = EntityUtils.toString(entity,"UTF-8");

        Map<String ,String> resultMap = new HashMap<>();
        resultMap.put(STATUS_CODE_KEY,statusCode+"");
        resultMap.put(RESULT_KEY,result);
        return resultMap;
    }
}
