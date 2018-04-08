/*
 * Copyright 2014 Effektif GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.effektif.workflow.api.datasource;


/**
 * @author Tom Baeyens
 */
public class DataSourceQuery {

  protected String dataSourceId;
  protected String organizationId;

  public String getDataSourceId() {
    return this.dataSourceId;
  }
  public void setDataSourceId(String dataSourceId) {
    this.dataSourceId = dataSourceId;
  }
  public DataSourceQuery dataSourceId(String dataSourceId) {
    this.dataSourceId = dataSourceId;
    return this;
  }

  public String getOrganizationId() {
    return this.organizationId;
  }
  public void setOrganizationId(String organizationId) {
    this.organizationId = organizationId;
  }
  public DataSourceQuery organizationId(String organizationId) {
    this.organizationId = organizationId;
    return this;
  }
}
