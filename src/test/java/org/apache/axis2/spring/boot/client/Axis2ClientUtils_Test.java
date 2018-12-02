/*
 * Copyright (c) 2010-2020, vindell (https://github.com/vindell).
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

import org.junit.Test;

public class Axis2ClientUtils_Test {
	
	Axis2ClientTemplate template = new Axis2ClientTemplate();
	
	@Test
	public void invoke() throws Exception {
		
		String nameSpace="http://ws.localhost.com";
		String endpoint = "http://localhost:8080/ws/services/sayHello";
		
		Object[] args = new Object[] {""};
		Class<?>[] returnTypes = new Class<?>[] { String.class };
		
		Object[] res = template.invokeRPC(endpoint, nameSpace, "sayHello", args, returnTypes);
		System.out.println(res[0]);
		
	}

}
