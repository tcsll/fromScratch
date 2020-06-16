package com.component.http.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

/**
 * @author shill
 */
public class RequestUtil {

    /**
     * Http Request POST Method
     *
     * @param urlStr 请求URL
     * @param params 请求参数
     * @return 返回请求结果
     */
    public static String sendPost(String urlStr, Map<String, String> params) {
        String result = "";
        HttpURLConnection conn = null;
        String BOUNDARY = "----------------------------------------------";
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");

            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + BOUNDARY);

            DataOutputStream out = new DataOutputStream(conn.getOutputStream());

            if (params != null) {
                StringBuffer strBuf = new StringBuffer();
                for (Object o : params.entrySet()) {
                    Map.Entry entry = (Map.Entry) o;
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    strBuf.append("\r\n").append("--").append(BOUNDARY)
                            .append("\r\n");
                    strBuf.append("Content-Disposition: form-data; name=\""
                            + inputName + "\"\r\n\r\n");
                    strBuf.append(inputValue);
                }
                out.write(strBuf.toString().getBytes("UTF-8"));
            }
            String endData = "\r\n--" + BOUNDARY + "--\r\n";
            out.write(endData.getBytes());
            out.flush();
            out.close();
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("=====请求异常 START=====\r\n" + urlStr + "\r\n=====请求异常 END=====");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
        return result;
    }

    /**
     * Http Request GET Method
     *
     * @param urlStr 请求URL
     * @param params 请求参数
     * @return
     */
    public static String sendGet(String urlStr, Map<String, String> params) {
        String result = "", paramsString = "";
        HttpURLConnection conn = null;
        try {
            if (params != null) {
                Iterator iter = params.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry entry = (Map.Entry) iter.next();
                    String inputName = (String) entry.getKey();
                    String inputValue = (String) entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    paramsString += inputName + "=" + inputValue + "&";
                }
            }

            URL url = new URL(urlStr + "?" + paramsString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");

            // 建立实际的连接
            conn.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.out.println("=====请求异常 START=====\r\n" + urlStr + "\r\n=====请求异常 END=====");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return result;
    }

}