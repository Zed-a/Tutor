package com.nan.tutor.net;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.nan.tutor.util.Constant;

/**
 * 进行网络通信，进行消息的上传与下载
 */
public class NetConnection {

    @SuppressLint("StaticFieldLeak")
    public NetConnection(final String url, final HttpMethod method, final SuccessCallback successCallback, final FailCallback failCallback, final JSONObject requestData) {

        new AsyncTask<Void, Void, String>() {//防止阻塞主线程
            @Override
            protected String doInBackground(Void... voids) {

                try {
                    URLConnection uc;

                    switch (method) {//选择传送方式
                        case POST://POST方式以流的方式上传数据到服务器
                            uc = new URL(url).openConnection();
                            uc.setConnectTimeout(120000);//连接的超时时间
                            uc.setReadTimeout(10000);//设置响应的时间
                            uc.setDoOutput(true);//设置这个连接是否可以写出数据
                            uc.setRequestProperty("Content-Type","application/json;charset=UTF-8");//设置消息的类型
                            uc.setRequestProperty("contentType", Constant.CHARSET);
                            uc.setRequestProperty("Accept-Charset", Constant.CHARSET);
                            uc.connect();//连接，从上述至此的配置必须要在connect之前完成，实际上它只是建立了一个与服务器的TCP连接

//                            OutputStream out=uc.getOutputStream();//输出流，用来发送请求，http请求实际上直到这个函数里面才发送出去
//                            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(out));//创建字符流对象并用高效缓冲流包装它，便获得最高的效率,发送的是字符串推荐用字符流，其它数据就用字节流

                            DataOutputStream outData=new DataOutputStream(uc.getOutputStream());
                            String data=requestData.toString();
                            outData.write(data.getBytes());
                            outData.flush();
                            outData.close();


                            break;
                        default:
                            uc = new URL(url + "?" +requestData.toString()).openConnection();
                            break;
                    }
                    System.out.println("Request data:" + requestData);


                    //从服务器读取数据
                    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream(), Constant.CHARSET));
                    String line;
                    StringBuilder result = new StringBuilder();
                    while ((line = br.readLine()) != null) {//一行一行读取数据
                        result.append(line);
                    }

                    System.out.println("Result:" + result);

                    return result.toString();

                } catch (IOException e) {
                    e.printStackTrace();
                }


                return null;
            }


            //对DoInbackground返回值响应
            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                if (result != null) {
                    if (successCallback != null) {
                        successCallback.onSuccess(result);
                    }
                } else {
                    if (failCallback != null) {
                        failCallback.onFail(result);
                    }
                }
            }
        }.execute();
    }


    /**
     * result就是从服务器返回的数据
     */
    public interface SuccessCallback {
        void onSuccess(String result);
    }

    public interface FailCallback {
        void onFail(String result);
    }
}
