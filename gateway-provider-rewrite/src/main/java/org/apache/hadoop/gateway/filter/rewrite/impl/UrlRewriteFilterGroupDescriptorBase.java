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
package org.apache.hadoop.gateway.filter.rewrite.impl;

import org.apache.hadoop.gateway.filter.rewrite.api.UrlRewriteFilterApplyDescriptor;
import org.apache.hadoop.gateway.filter.rewrite.api.UrlRewriteFilterGroupDescriptor;
import org.apache.hadoop.gateway.filter.rewrite.api.UrlRewriteFilterPathDescriptor;

import java.util.ArrayList;
import java.util.List;

public class UrlRewriteFilterGroupDescriptorBase
    extends UrlRewriteFilterSelectorDescriptorBase
    implements UrlRewriteFilterGroupDescriptor {

  private List<UrlRewriteFilterPathDescriptor> selectors = new ArrayList<UrlRewriteFilterPathDescriptor>();

  @Override
  public List<UrlRewriteFilterPathDescriptor> getSelectors() {
    return selectors;
  }

  @Override
  public void addSelector( UrlRewriteFilterPathDescriptor selector ) {
    this.selectors.add( selector );
  }

  @Override
  public UrlRewriteFilterApplyDescriptor addApply( String path, String rule ) {
    UrlRewriteFilterApplyDescriptor apply = new UrlRewriteFilterApplyDescriptorImpl();
    apply.path( path );
    apply.rule( rule );
    addSelector( apply );
    return apply;
  }

}
