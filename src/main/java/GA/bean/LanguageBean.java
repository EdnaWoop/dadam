/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author bestPersonEver
 */
@Named("LanguageBean")
@SessionScoped
public class LanguageBean implements Serializable{
        private static List countries;
        static{
         setCountries(new ArrayList());
         getCountries().add(Locale.ENGLISH);
         getCountries().add(Locale.GERMAN);
     }
               
    public void localeChanged(Locale local){

        FacesContext.getCurrentInstance().getViewRoot().setLocale(local);
    }

    /**
     * @return the countries
     */
    public static List getCountries() {
        return countries;
    }

    /**
     * @param aCountries the countries to set
     */
    public static void setCountries(List aCountries) {
        countries = aCountries;
    }

    
}
