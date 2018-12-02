/*
 * Copyright (c) 2018, vindell (https://github.com/vindell).
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
 * @author 		： <a href="https://github.com/vindell">vindell</a>
 */

import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

public class Axis2Client {

	private static void axis2WebService() {  
        try {  
            String soapBindingAddress = "http://localhost/x5/service/helloWorld?wsdl";  
            ServiceClient sender = new ServiceClient();  
            EndpointReference endpointReference = new EndpointReference(soapBindingAddress);  
            Options options = new Options();  
        
            options.setTo(endpointReference);  
            sender.setOptions(options);  
            OMFactory fac = OMAbstractFactory.getOMFactory();  
            // 这个和qname差不多，设置命名空间  
            OMNamespace omNs = fac.createOMNamespace("http://impl.webservice.platform.hotent.com/",  "svc");  
            OMElement data = fac.createOMElement("sayHello", omNs);  
            // 对应参数的节点  
            String[] strs = new String[] { "arg0" };  
            // 参数值  
            String[] val = new String[] { "zhangyg" };  
            for (int i = 0; i < strs.length; i++) {  
                QName qname=new QName(strs[i]);
                OMElement inner = fac.createOMElement(qname);  
                inner.setText(val[i]);  
                data.addChild(inner);  
            }  
            // 发送数据，返回结果  
            OMElement result = sender.sendReceive(data);  
            System.out.println(result.toString());  
        } catch (AxisFault ex) {  
            ex.printStackTrace();  
        }  
  
    }  
	
}
