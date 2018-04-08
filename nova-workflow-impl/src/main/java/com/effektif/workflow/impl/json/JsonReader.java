/* Copyright (c) 2014, Effektif GmbH.
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
 * limitations under the License. */
package com.effektif.workflow.impl.json;

import java.lang.reflect.Type;

/**
 * An API for deserialising field values from a JSON source.
 *
 * @author Tom Baeyens
 */
public abstract class JsonReader {
  
  Mappings mappings;
  
  public JsonReader(Mappings mappings) {
    this.mappings = mappings;
  }

  public Object readObject(Object jsonValue, Type type) {
    JsonTypeMapper typeMapper = mappings.getTypeMapper(type);
    return typeMapper.read(jsonValue, this);
  }
}