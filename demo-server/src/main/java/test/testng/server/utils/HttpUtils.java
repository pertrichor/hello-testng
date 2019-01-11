package test.testng.server.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:http请求api
 *
 * @author XuTao
 * @create 2018-10-31 14:28
 */
public class HttpUtils {

    private static final int DEFAULT_SOCKET_TIME_OUT = 60000;
    private static final int DEFAULT_CONNECT_TIME_OUT = 30000;
    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 发送get请求
     *
     * @param url        请求地址
     * @param headerList 头信息
     * @return
     */
    public static String sendGet(String url, List<NameValuePair> headerList) {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(DEFAULT_SOCKET_TIME_OUT).setConnectTimeout(DEFAULT_CONNECT_TIME_OUT).build();

            HttpGet httpGet = new HttpGet(url);
            httpGet.setConfig(requestConfig);

            // 设置头信息
            if (headerList == null) {
                headerList = getCommonHeaderList();
            }
            for (NameValuePair headerPair : headerList) {
                httpGet.addHeader(headerPair.getName(), headerPair.getValue());
            }

            CloseableHttpResponse response = httpClient.execute(httpGet);
            HttpEntity httpEntity = response.getEntity();

            return EntityUtils.toString(httpEntity, DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    /**
     * 发送post请求
     *
     * @param url                     请求地址
     * @param urlEncodedFormParamList 编码过的参数列表
     * @param headerList              头信息
     * @return
     */
    public static String sendPost(String url, List<NameValuePair> urlEncodedFormParamList, List<NameValuePair> headerList) {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(DEFAULT_SOCKET_TIME_OUT).setConnectTimeout(DEFAULT_CONNECT_TIME_OUT).build();

            HttpPost httpPost = new HttpPost(url);

            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new UrlEncodedFormEntity(urlEncodedFormParamList, DEFAULT_CHARSET));

            // 设置头信息
            if (headerList == null) {
                headerList = getCommonHeaderList();
            }
            for (NameValuePair headerPair : headerList) {
                httpPost.addHeader(headerPair.getName(), headerPair.getValue());
            }

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();

            return EntityUtils.toString(httpEntity, DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    /**
     * 发送post请求
     *
     * @param url        请求地址
     * @param paramStr   参数
     * @param headerList 头信息
     * @return
     */
    public static String sendPost(String url, String paramStr, List<NameValuePair> headerList) {
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(DEFAULT_SOCKET_TIME_OUT).setConnectTimeout(DEFAULT_CONNECT_TIME_OUT).build();

            HttpPost httpPost = new HttpPost(url);

            httpPost.setConfig(requestConfig);
            httpPost.setEntity(new StringEntity(paramStr, DEFAULT_CHARSET));

            // 设置头信息
            if (headerList == null) {
                headerList = getCommonHeaderList();
            }
            for (NameValuePair headerPair : headerList) {
                httpPost.addHeader(headerPair.getName(), headerPair.getValue());
            }

            CloseableHttpResponse response = httpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();

            return EntityUtils.toString(httpEntity, DEFAULT_CHARSET);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }


    private static List<NameValuePair> getCommonHeaderList() throws Exception {
        List<NameValuePair> headerList = new ArrayList<>();
        headerList.add(new BasicNameValuePair("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8"));
        headerList.add(new BasicNameValuePair("Accept-Encoding", "gzip, deflate"));
        headerList.add(new BasicNameValuePair("Accept-Language", "zh-CN,zh;q=0.9"));
        headerList.add(new BasicNameValuePair("Cache-Control", "max-age=0"));
        headerList.add(new BasicNameValuePair("Connection", "keep-alive"));
        headerList.add(new BasicNameValuePair("Upgrade-Insecure-Requests", "1"));
        headerList.add(new BasicNameValuePair("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36"));
        return headerList;
    }

    public static void main(String[] args) {
        String result = HttpUtils.sendGet("http://www.baidu.com", null);
        System.out.println(result);
    }
}
