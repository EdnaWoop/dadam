/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author bestPersonEver
 */
@SessionScoped
@Named("SessionBean")
public class SessionBean implements Serializable {
    /**
     * gets role session
     * @return 
     */
    public String getRole(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        return request.getSession(false).getAttribute("role").toString();
    }
    /**
     * sets role session
     * @param role 
     */
    public void setRole(String role){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession(false).setAttribute("role", role);
        
    }
    /**
     * gets the username from HttpSession
     * @return 
     */
    public String getUsername(){
       HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
       return request.getSession(false).getAttribute("username").toString();
    }
    
    /**
     * sets username to HttpSession
     * @param username 
     */
    public void setUsername(String username){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession(false).setAttribute("username", username);
       
    }
    
    /**
     * throws the session away/invalidates the session
     */
    public void invalidate(){
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession(false).invalidate();
    }
}
