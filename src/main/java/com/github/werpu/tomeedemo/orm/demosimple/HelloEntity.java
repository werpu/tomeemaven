/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.github.werpu.tomeedemo.orm.demosimple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author Werner Punz (latest modification by $Author$)
 * @version $Revision$ $Date$
 */

@Entity
public class HelloEntity
{
    @Id
    @GeneratedValue
    Integer id;

    @Column(name = "HELLO_WORLD")
    String helloWorld = "helloWorld from entity";

    @Version
    protected Integer optlock;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getHelloWorld()
    {
        return helloWorld;
    }

    public void setHelloWorld(String helloWorld)
    {
        this.helloWorld = helloWorld;
    }

    public Integer getOptlock()
    {
        return optlock;
    }

    public void setOptlock(Integer optlock)
    {
        this.optlock = optlock;
    }
}
