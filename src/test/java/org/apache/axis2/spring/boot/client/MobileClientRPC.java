package org.apache.axis2.spring.boot.client;

import javax.xml.namespace.QName;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.junit.Test;

/**
 * https://blog.csdn.net/menghuanzhiming/article/details/78489527
 * 
 * 方法一： 应用rpc的方式调用 这种方式就等于远程调用， 即通过url定位告诉远程服务器，告知方法名称，参数等， 调用远程服务，得到结果。
 * 使用org.apache.axis2.rpc.client.RPCServiceClient类调用WebService；
 * 
 * 【注】： 如果被调用的WebService方法有返回值 应使用 invokeBlocking 方法 该方法有三个参数
 * 第一个参数的类型是QName对象，表示要调用的方法名； 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]，
 * 当方法没有参数时，invokeBlocking方法的第二个参数值不能是null，而要使用new Object[]{}；
 * 第三个参数表示WebService方法的 返回值类型的Class对象，参数类型为Class[]。
 * 
 * 如果被调用的WebService方法没有返回值 应使用 invokeRobust方法,
 * 该方法只有两个参数，它们的含义与invokeBlocking方法的前两个参数的含义相同。
 * 
 */
public class MobileClientRPC {
	/**
	 * 
	 * @Title: testRPCClient
	 * @Description: TODO(rpc远程调用，失败，无法正确传参)
	 * @return void 返回类型
	 */
	@Test
	public void testRPCClient() {
		try {
			// 使用RPC方式调用WebService
			RPCServiceClient serviceClient = new RPCServiceClient();
			// 创建WSDL的URL，注意不是服务地址
			String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx?wsdl";
			// 指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(url);
			Options options = serviceClient.getOptions();
			// 确定目标服务地址
			options.setTo(targetEPR);
			// 确定调用方法（wsdl 命名空间地址 (wsdl文档中的targetNamespace) 和 方法名称 的组合）
			options.setAction("http://WebXml.com.cn/getMobileCodeInfo");
			// 指定方法的参数值
			Object[] parameters = new Object[] { "1866666666", "" };
			// 创建服务名称
			// 1.namespaceURI - 命名空间地址 (wsdl文档中的targetNamespace)
			// 2.localPart - 服务视图名 (wsdl文档中operation的方法名称，例如<wsdl:operation
			// name="getMobileCodeInfo">)
			QName qname = new QName("http://WebXml.com.cn/", "getMobileCodeInfo");
			// 调用方法一 传递参数，调用服务，获取服务返回结果集
			OMElement element = serviceClient.invokeBlocking(qname, parameters);
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
			Object[] response = serviceClient.invokeBlocking(qname, parameters, returnTypes);
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
	public void Weather() throws AxisFault {
		// 使用RPC方式调用WebService
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();
		// 指定调用WebService的URL
		EndpointReference targetEPR = new EndpointReference("http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl");
		options.setTo(targetEPR);
		options.setAction("http://WebXml.com.cn/getRegionProvince");
		// 指定方法的参数值
		Object[] opAddEntryArgs = new Object[] {};
		// 指定要调用的方法及WSDL文件的命名空间
		QName opAddEntry = new QName("http://WebXml.com.cn/", "getRegionProvince");
		// 调用法并输出该方法的返回值
		System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs));
	}

	/**
	 * 
	 * 
	 * @Title: Weather1
	 * @Description: TODO(rpc远程调用，失败，单个参数失败)
	 * @return void 返回类型
	 */
	@Test
	public void Weather1() {
		try {
			// 使用RPC方式调用WebService
			RPCServiceClient serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			// 指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(
					"http://ws.webxml.com.cn/WebServices/WeatherWS.asmx?wsdl");
			options.setTo(targetEPR);
			options.setAction("http://WebXml.com.cn/getSupportCityDataset");
			// 指定方法的参数值
			Object[] opAddEntryArgs = new Object[] { "北京" };
			// 指定要调用的方法及WSDL文件的命名空间
			QName opAddEntry = new QName("http://WebXml.com.cn/", "getSupportCityDataset");
			// 调用法并输出该方法的返回值
			System.out.println(serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs));
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
