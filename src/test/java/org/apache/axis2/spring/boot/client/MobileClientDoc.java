package org.apache.axis2.spring.boot.client;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.junit.Test;

/**
 * https://blog.csdn.net/menghuanzhiming/article/details/78489527
 * @ClassName: MobileClientDoc
 * @Description: 方法二： 应用document方式调用
 *               用ducument方式应用现对繁琐而灵活。现在用的比较多。因为真正摆脱了我们不想要的耦合
 *               即使用org.apache.axis2.client.ServiceClient类进行远程调用web服务，不生成客户端
 * 
 * @date 2017年11月9日 下午1:27:17
 *
 */
public class MobileClientDoc {
	/**
	 * 
	 * @Title: Weather
	 * @Description: TODO(document远程调用，成功，没有参数能够成功)
	 * @return void 返回类型
	 * @throws AxisFault
	 */
	@Test
	public void Weather() throws AxisFault {
		
		ServiceClient serviceClient = new ServiceClient();
		// 创建服务地址WebService的URL,注意不是WSDL的URL
		String url = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx";
		EndpointReference targetEPR = new EndpointReference(url);
		Options options = serviceClient.getOptions();
		options.setTo(targetEPR);
		// 确定调用方法（wsdl 命名空间地址 (wsdl文档中的targetNamespace) 和 方法名称 的组合）
		options.setAction("http://WebXml.com.cn/getRegionProvince");
		OMFactory fac = OMAbstractFactory.getOMFactory();
		/*
		 * 
		 * 指定命名空间，参数： uri--即为wsdl文档的targetNamespace，命名空间 perfix--可不填
		 */
		OMNamespace omNs = fac.createOMNamespace("http://WebXml.com.cn/", "");
		// 指定方法
		OMElement method = fac.createOMElement("getSupportCityDataset", omNs);
		method.build(); // 远程调用web服务
		OMElement result = serviceClient.sendReceive(method);
		System.out.println(result);
	}

	/**
	 * 
	 * @Title: Weather1
	 * @Description: TODO(document远程调用，成功，没有参数能够成功)
	 * @return void 返回类型
	 */
	@Test
	public void Weather1() {
		try {

			ServiceClient serviceClient = new ServiceClient();
			// 创建服务地址WebService的URL,注意不是WSDL的URL
			String url = "http://ws.webxml.com.cn/WebServices/WeatherWS.asmx";
			EndpointReference targetEPR = new EndpointReference(url);
			Options options = serviceClient.getOptions();
			options.setTo(targetEPR);
			// 确定调用方法（wsdl 命名空间地址 (wsdl文档中的targetNamespace) 和 方法名称 的组合）
			options.setAction("http://WebXml.com.cn/getSupportCityDataset");
			OMFactory fac = OMAbstractFactory.getOMFactory();
			/*
			 * 
			 * 指定命名空间，参数： uri--即为wsdl文档的targetNamespace，命名空间 perfix--可不填
			 */
			OMNamespace omNs = fac.createOMNamespace("http://WebXml.com.cn/", "");
			// 指定方法
			OMElement method = fac.createOMElement("getSupportCityDataset", omNs);
			// 指定方法的参数
			OMElement theRegionCode = fac.createOMElement("theRegionCode", omNs);
			theRegionCode.setText("北京");
			method.addChild(theRegionCode);
			method.build();
			// 远程调用web服务
			OMElement result = serviceClient.sendReceive(method);
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
	public void MobileCodeWS() {
		try {

			ServiceClient serviceClient = new ServiceClient();
			// 创建服务地址WebService的URL,注意不是WSDL的URL
			String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx";
			EndpointReference targetEPR = new EndpointReference(url);
			Options options = serviceClient.getOptions();
			options.setTo(targetEPR);
			// 确定调用方法（wsdl 命名空间地址 (wsdl文档中的targetNamespace) 和 方法名称 的组合）
			options.setAction("http://WebXml.com.cn/getMobileCodeInfo");
			OMFactory fac = OMAbstractFactory.getOMFactory();
			/*
			 * 
			 * 指定命名空间，参数： uri--即为wsdl文档的targetNamespace，命名空间 perfix--可不填
			 */ 
			OMNamespace omNs = fac.createOMNamespace("http://WebXml.com.cn/", "");
			// 指定方法
			OMElement method = fac.createOMElement("getMobileCodeInfo", omNs);
			// 指定方法的参数
			OMElement mobileCode = fac.createOMElement("mobileCode", omNs);
			mobileCode.setText("15932582632");
			OMElement userID = fac.createOMElement("userID", omNs);
			userID.setText("");
			method.addChild(mobileCode);
			method.addChild(userID);
			method.build();
			// 远程调用web服务
			OMElement result = serviceClient.sendReceive(method);
			System.out.println(result);
		} catch (AxisFault axisFault) {
			axisFault.printStackTrace();
		}
	}
}
