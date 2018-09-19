package com.hcmony.test;

import com.bxm.util.OkHttpUtils;
import com.hcmony.utils.MD5Util;
import okhttp3.*;

import java.util.concurrent.TimeUnit;

/**
 * <h3>Shenjue.java基本描述</h3>
 * <p></p>
 *
 * @author hcmony
 * @since V1.0.0, 2018/07/30 11:06
 */
public class ATest {
	private static final OkHttpClient mOkHttpClient = new OkHttpClient.Builder().connectTimeout(5,
			TimeUnit.SECONDS).readTimeout(10,
			TimeUnit.SECONDS).build();
	public static void main(String[] args)throws Exception {

		String appid = "25678";
		String appkey ="03043d0bc912b1ac5169eae3111a9348";
		String url = "https://api.mysubmail.com/message/send.json";
		String to = "17770020528";
		String content = "【变现猫】中午请我吃个饭";
		String signature=appkey;
		//String signature = MD5Util.MD5EncodeUtf8("appid="+appid+"&to="+to+"&content="+content+"&signature="+appkey);
		String parm = "appid="+appid+"&to="+to+"&content="+content+"&signature="+signature;
		RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), parm);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = mOkHttpClient.newCall(request).execute();

		System.out.println(response.body().string());
	}
}
