package org.apache.axis2.spring.boot.client;

import java.io.IOException;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

/**
 * https://blog.csdn.net/kris234seth/article/details/50456944
 */
public class RPCClient {

	public static String address = "http://localhost:8080/axis2/services/SimpleService";

	public static void main(String[] args) throws IOException {

		Object[] result = invoke("getPrice", new Object[] {}, new Class[] { int.class });
		System.out.println(result[0]);
		result = invoke("getGreeting", new Object[] { "jack" }, new Class[] { String.class });
		System.out.println(result[0]);
	}

	@SuppressWarnings("rawtypes")
	public static Object[] invoke(String method, Object[] params, Class[] classes) throws AxisFault {
		// 使用RPC方式调用WebService
		RPCServiceClient client = new RPCServiceClient();
		Options option = client.getOptions();

		// 指定调用的URL
		EndpointReference reference = new EndpointReference(address);
		option.setTo(reference);

		/*
		 * 设置要调用的方法 http://ws.apache.org/axis2 为默认的（无package的情况）命名空间， 如果有包名，则为
		 * http://axis2.webservice.elgin.com ,包名倒过来即可 method为方法名称
		 * 
		 */
		QName qname = new QName("http://ws.apache.org/axis2", method);

		// 调用远程方法,并指定方法参数以及返回值类型
		Object[] result = client.invokeBlocking(qname, params, classes);

		return result;

	}

}