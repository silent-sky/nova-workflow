/*
 * Copyright 2015 Effektif GmbH.
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
package com.effektif.workflow.impl.exceptions;




/**
 * @author Tom Baeyens
 */
public class NotFoundException extends HttpMappedException {

  private static final long serialVersionUID = 1L;

  public NotFoundException() {
    super("Not found");
  }
  
  public NotFoundException(String message) {
    super(message);
  }

  public NotFoundException(String message, Throwable t) {
    super(message, t);
  }

  @Override
  public int getStatusCode() {
    return HttpStatusCode.NOT_FOUND;
  }

  public static void checkTrue(boolean condition) {
   checkTrue(condition, null);
  }

  public static void checkTrue(boolean condition, String message) {
    if (!condition) {
      throw new NotFoundException(message);
    }
  }

  public static void checkNotNull(Object object) {
    checkTrue(object!=null, "Not found");
  }

  public static void checkNotNull(Object object, String message) {
    checkTrue(object != null, message);
  }
}
