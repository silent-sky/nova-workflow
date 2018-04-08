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
package com.effektif.workflow.impl.workflowinstance;

import java.util.ArrayList;
import java.util.List;

import com.effektif.workflow.impl.job.Job;



/**
 * @author Tom Baeyens
 */
public class ScopeInstanceUpdates {

  public boolean isNew;
  public boolean isEndChanged;
  public boolean isActivityInstancesChanged;
  public boolean isVariableInstancesChanged;

  public void reset(boolean isNew) {
    this.isNew = isNew;
    this.isEndChanged = false;
    this.isActivityInstancesChanged = false;
    this.isVariableInstancesChanged = false;
  }
}
