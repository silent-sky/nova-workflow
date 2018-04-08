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
package com.effektif.workflow.api.workflow.diagram;

import java.util.ArrayList;
import java.util.List;

/**
 * An element - such as a shape - on a BPMN diagram.
 */
public class Node {
 
  public String id;
  public Bounds bounds;
  public List<Node> children = null;
  public String elementId;

  /** Optional attribute that is only used for Pools and Lanes. */
  public Boolean horizontal;
  /** Optional attribute that is only used for collapsed sub-processes. */
  public Boolean expanded;

  public Node bounds(Bounds bounds) {
    this.bounds = bounds;
    return this;
  }

  public Node children(List<Node> children) {
    if (children != null) {
      this.children = new ArrayList<>(children);
    } else {
      this.children = null;
    }
    return this;
  }
  
  public Node elementId(String elementId) {
    this.elementId = elementId;
    return this;
  }

  public Node horizontal(boolean horizontal) {
    this.horizontal = horizontal;
    return this;
  }

  public Node expanded(Boolean expanded) {
    this.expanded = expanded;
    return this;
  }
  
  public Node id(String id) {
    this.id = id;
    return this;
  }

  public Node addNode(Node node) {
    if (node != null) {
      if (children == null) {
        children = new ArrayList<>();
      }
      children.add(node);
    }
    return this;
  }

  public Node getChild(String id) {
    if (id != null && children != null) {
      for (Node node : children) {
        if (id.equals(node.elementId)) {
          return node;
        }
      }
    }
    return null;
  }
  
  public boolean hasChildren() {
    return children != null && !children.isEmpty();
  }
  
  /**
   * A Node is considered valid if its Bounds are valid 
   * and all the contained children are valid.
   */
  public boolean isValid() {
    if (bounds == null || !bounds.isValid()) {
      return false;
    }
    if (children != null) {
      for (Node node : children) {
        if (!node.isValid()) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((elementId == null) ? 0 : elementId.hashCode());
    result = prime * result + ((bounds == null) ? 0 : bounds.hashCode());
    result = prime * result + ((children == null) ? 0 : children.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Node other = (Node) obj;
    if (elementId == null) {
      if (other.elementId != null)
        return false;
    } else if (!elementId.equals(other.elementId))
      return false;
    if (bounds == null) {
      if (other.bounds != null)
        return false;
    } else if (!bounds.equals(other.bounds))
      return false;
    if (children == null) {
      if (other.children != null)
        return false;
    } else if (!children.equals(other.children))
      return false;
    return true;
  }
  
}
