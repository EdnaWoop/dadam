/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA.bean;

import GA.DAO.LoginDAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

/**
 *
 * @author bestPersonEver
 */
@SessionScoped
@Named("LoginBean")
public class LoginBean implements Serializable {
    
    private String errorMessage;
   @NotNull
    private String pwd;
   @NotNull
    private String alias;
   
   @Inject
   private LoginDAO DAO;
   @Inject
   private SessionBean sessionB;
   
   public String validate(){
        this.errorMessage=null;
        try{
            String valid = DAO.Login(alias, pwd);
            sessionB.setUsername(alias);
            sessionB.setRole(valid);            
            return valid;
        }catch(Exception e){
            this.errorMessage=e.getMessage();
            return "fail";
        }
   }
   
   public String logout(){
        this.setPwd(null);
        this.setAlias(null);
        sessionB.invalidate();
        return "logout";
   }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }
    
}
