package org.apache.axis2.spring.boot.client;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.junit.Test;

/**
 * https://blog.csdn.net/menghuanzhiming/article/details/78489527
 */
public class Axis2RpcClientTemplate_Test {
	
	protected Axis2RpcClientTemplate template = new Axis2RpcClientTemplate();
	
	/**
	 * 
	 * @Title: testRPCClient
	 * @Description: TODO(rpc远程调用，失败，无法正确传参)
	 * @return void 返回类型
	 */
	@Test
	public void testRPCClient1() {
		try {
			
			// 创建WSDL的URL，注意不是服务地址
			String wsdlURL = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl";
			String namespaceURI = "http://WebXml.com.cn/";
			// 指定方法的参数值
			Object[] parameters = new Object[] { "13735896864", "" };
			OMElement element = template.invoke(wsdlURL, namespaceURI, "getMobileCodeInfo", parameters);
			System.out.println(element);

			/*
			 * 
			 * 值得注意的是，返回结果就是一段由OMElement对象封装的xml字符串。
			 * 我们可以对之灵活应用,下面我取第一个元素值，并打印之。因为调用的方法返回一个结果
			 */
			String result = element.getFirstElement().getText();
			System.out.println(result);

			// 调用方法二 getPrice方法并输出该方法的返回值
			// 指定方法返回值的数据类型的Class对象
			Class<?>[] returnTypes = new Class[] { String.class };
			Object[] response = template.invoke(wsdlURL, namespaceURI, "getMobileCodeInfo", parameters, returnTypes);
			String r = (String) response[0];
			System.out.println(r);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @Title: Weather
	 * @Description: TODO(rpc远程调用，成功，没有参数能够成功)
	 * @return void 返回类型
	 * @throws AxisFault
	 */
	@Test
	public void testRPCClient2() throws AxisFault {
		// 创建WSDL的URL，注意不是服务地址
		String wsdlURL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
		String namespaceURI = "http://WebXml.com.cn/";
		// 指定方法的参数值
		Object[] opAddEntryArgs = new Object[] {};
		// 调用法并输出该方法的返回值
		OMElement element = template.invoke(wsdlURL, namespaceURI, "getRegionProvince", opAddEntryArgs);
		System.out.println(element);
	}

	/**
	 * 
	 * 
	 * @Title: Weather1
	 * @Description: TODO(rpc远程调用，失败，单个参数失败)
	 * @return void 返回类型
	 */
	@Test
	public void testRPCClient3() {
		try {
			
			// 创建WSDL的URL，注意不是服务地址
			String wsdlURL = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl";
			String namespaceURI = "http://WebXml.com.cn/";
			// 指定方法的参数值
			Object[] opAddEntryArgs = new Object[] { "北京" };
			// 调用法并输出该方法的返回值
			OMElement element = template.invoke(wsdlURL, namespaceURI, "getSupportCityDataset", opAddEntryArgs);
			System.out.println(element);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
