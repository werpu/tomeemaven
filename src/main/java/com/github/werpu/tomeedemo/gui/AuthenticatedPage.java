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

package com.github.werpu.tomeedemo.gui;

import com.github.werpu.tomeedemo.service.SecuredEJB;

import javax.ejb.EJB;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Werner Punz (latest modification by $Author$)
 * @version $Revision$ $Date$
 */
@Named
@RequestScoped
public class AuthenticatedPage
{
    @EJB
    SecuredEJB securedEJB;

    public String doLogout() {
        try
        {
           ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).logout();
           ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
           ((HttpServletResponse)  FacesContext.getCurrentInstance().getExternalContext().getResponse()).sendRedirect(
                   FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath());
        }
        catch (ServletException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return "logout";
    }

    public String getUser() {
        String user = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
        return user;
    }

    public String getHello() {
        return securedEJB.getHelloAuthenticated();
    }
}
