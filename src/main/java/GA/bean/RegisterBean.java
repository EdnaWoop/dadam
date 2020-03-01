/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA.bean;

import GA.DAO.RegisterDAO;
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
@Named("RegisterBean")
public class RegisterBean implements Serializable {
        @NotNull
    private String name;
    @NotNull
    private String lastname;
    @NotNull
    private String username;
    @NotNull
    private String SSN;
    @NotNull
    private String email;
    @NotNull
    private String pwd;
    private String errorMessage;
    @Inject
    private RegisterDAO DAO;
    
        
    /**
     * register person to DB using RegistarDAO.register
     * @return 
     */
    public String regristration(){
        try{
            this.errorMessage = null;
            DAO.register(name, lastname, username, SSN, email, pwd);
            return "Success";
        }catch(Exception e){
            this.errorMessage=e.getMessage()+" sith try";
            return "fail";
        }
    }
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the SSN
     */
    public String getSSN() {
        return SSN;
    }

    /**
     * @param SSN the SSN to set
     */
    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
    
    
}
