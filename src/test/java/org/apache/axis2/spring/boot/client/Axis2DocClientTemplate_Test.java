package org.apache.axis2.spring.boot.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.junit.Test;

/**
 * https://blog.csdn.net/menghuanzhiming/article/details/78489527
 *
 */
public class Axis2DocClientTemplate_Test {

	Axis2DocClientTemplate template = new Axis2DocClientTemplate();
	
	/**
	 * 
	 * @Title: Weather
	 * @Description: TODO(document远程调用，成功，没有参数能够成功)
	 * @return void 返回类型
	 * @throws AxisFault
	 */
	@Test
	public void testRPCClient1() throws AxisFault {
		// 创建服务地址WebService的URL,注意不是WSDL的URL
		String serviceURL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx";
		String namespaceURI = "http://WebXml.com.cn/";
		// 确定调用方法（wsdl 命名空间地址 (wsdl文档中的targetNamespace) 和 方法名称 的组合）
		String action = "http://WebXml.com.cn/getRegionProvince";
		// 远程调用web服务 : 此次指定方法也无效果
		OMElement result = template.sendReceive(serviceURL, action, namespaceURI, "getSupportCityDataset");
		System.out.println(result);
	}

	/**
	 * (document远程调用，成功，单个参数能够成功)
	 */
	@Test
	public void testRPCClient2() {
		try {

			// 创建服务地址WebService的URL,注意不是WSDL的URL
			String serviceURL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx";
			String namespaceURI = "http://WebXml.com.cn/";
			Map<String,String> params = new HashMap<>();
			params.put("theRegionCode", "北京");
			// 远程调用web服务
			OMElement result = template.sendReceive(serviceURL, namespaceURI, "getSupportCityDataset", params);
			System.out.println(result);
			
		} catch (AxisFault axisFault) {
			axisFault.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * @Title: Weather1
	 * @Description: TODO(document远程调用，成功，多个参数)
	 * @return void 返回类型
	 */
	@Test
	public void testRPCClient3() {
		try {
			
			// 创建服务地址WebService的URL,注意不是WSDL的URL
			String serviceURL = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx";
			String namespaceURI = "http://WebXml.com.cn/";
			Map<String,String> params = new HashMap<>();
			params.put("mobileCode", "15932582632");
			params.put("userID", "");
			
			// 远程调用web服务
			OMElement result = template.sendReceive(serviceURL, namespaceURI, "getMobileCodeInfo", params);
			System.out.println(result);
		} catch (AxisFault axisFault) {
			axisFault.printStackTrace();
		}
	}
}
