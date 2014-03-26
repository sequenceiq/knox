/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.gateway.hbase;

import org.apache.hadoop.gateway.dispatch.AppCookieManager;
import org.apache.http.HttpRequest;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import java.net.URI;
import java.net.URISyntaxException;

public class HBaseCookieManager extends AppCookieManager {

  protected HttpRequest createKerberosAuthenticationRequest( HttpUriRequest userRequest ) {
    URI userUri = userRequest.getURI();
    try {
      URI authUri = new URI(
          userUri.getScheme(), null, userUri.getHost(), userUri.getPort(),
          "/version", userUri.getQuery(), null );
      HttpRequest authRequest = new HttpGet( authUri );
      return authRequest;
    } catch( URISyntaxException e ) {
      throw new IllegalArgumentException( userUri.toString(), e );
    }
  }

}
