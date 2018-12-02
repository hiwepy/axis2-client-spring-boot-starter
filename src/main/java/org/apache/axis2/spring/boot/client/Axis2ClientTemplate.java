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

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

/**
 * TODO
 * @author 		： <a href="https://github.com/vindell">vindell</a>
 */

public class Axis2ClientTemplate {

	/**
	 * 
	 * @param address		: 指定调用WebService的URL
	 * @param namespace		: 指定要调用的方法wsdl文件的命名空间;通过访问http://localhost:8080/ws/XXXService?wsdl 就可以看见 元素的targetNamespace属性值
	 * @param method		: 指定要调用的方法
	 * @param args			: 指定调用方法的参数值  
	 * @param returnTypes	: 指定调用方法返回值的数据类型的class对象  
	 * @return
	 * @throws Exception
	 */
	public Object[] invokeRPC(String address, String namespace, String method, Object[] args, Class<?>[] returnTypes) throws Exception {  
        
		RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();  
        // 指定调用WebService的URL  
        EndpointReference er = new EndpointReference(address);  
        options.setTo(er);
  
        // 指定要调用的方法及wsdl文件的命名空间，第一个参数表示WSDL文件的命名空间 ;通过访问http://localhost:8080/axis2/services/MyService?wsdl 就可以看见 元素的targetNamespace属性值  
        QName qname = new QName(namespace, method);  
  
        // 调用方法并输出该方法的返回值  
        /* 这里有三个参数的说明：
         * 1，是QName对象，表示要调用的方法名；
         * 2，webservice的参数值，参数类型是Object[]；
         * 3，返回值class对象，参数类型是Class[],
         */  
      return serviceClient.invokeBlocking(qname, args, returnTypes);  
  
    }
}
