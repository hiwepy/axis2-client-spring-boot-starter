/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.axis2.spring.boot.client;

/**
 * TODO
 * @author 		： <a href="https://github.com/hiwepy">hiwepy</a>
 */
import java.util.Iterator;

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;


public class Demo {

	private static void axis2WebService() {
		try {
			String soapBindingAddress = "http://192.168.0.55:9080/itsm/schemas/ProductServices?wsdl";
			ServiceClient sender = new ServiceClient();
			EndpointReference endpointReference = new EndpointReference(soapBindingAddress);
			Options options = new Options();

			options.setTo(endpointReference);
			sender.setOptions(options);
			OMFactory fac = OMAbstractFactory.getOMFactory();
			// 这个和qname差不多，设置命名空间
			OMNamespace omNs = fac.createOMNamespace("http://www.chinawiserv.com/onecenter", ""); // 这个是namespace的str
			OMElement data = fac.createOMElement("getProducts", omNs); // getProducts是方法
			// 对应参数的节点
			String[] strs = new String[] { "arg0" };
			// 参数值 ，以json的格式进行传递
			String[] val = new String[] { "{\"userId\":\"1\"}" };
			for (int i = 0; i < strs.length; i++) {
				QName qname = new QName(strs[i]);
				OMElement inner = fac.createOMElement(qname);
				inner.setText(val[i]);
				data.addChild(inner);
			}
			System.out.println(data);
			// 发送数据，返回结果
			OMElement result = sender.sendReceive(data);
			System.out.println(result.toString());
			// 下面是返回的数据解析，返回的是json格式的数据，对string进行jsonobject
			Iterator iterator = result.getChildElements();

			OMElement result1 = null;
			while (iterator.hasNext()) {
				result1 = (OMElement) iterator.next();
				System.out.println(result1.getText());
			}

			String re = result1.getText();
			//JSONObject json_test = JSON.parseObject(re);

			//System.out.println(json_test.getString("info"));
			//System.out.println(json_test.getString("result"));
		} catch (AxisFault ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		axis2WebService();
	}
}