/*
 * Copyright (c) 2017 Outsource Cafe, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.javagen.schema.xml.node

import com.javagen.schema.xml.QName
import groovy.transform.ToString

@ToString(includePackage=false)
abstract class Node
{
    QName qname
    String id
    def attr = [:]
    boolean isRoot() { return qname!=null }
    void setQname(String name) { this.qname = new QName(name:name) }
    void setQname(QName qname) { this.qname = qname }
}
