/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA.DAO;

import GA.database.Person;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author bestPersonEver
 */
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class LoginDAO {
        
    @PersistenceContext(unitName="my_persistence_unit")
    private EntityManager em;
    private Query query;
    
    /**
     * communicates with the database returns the roles name
     * @param username
     * @param psw
     * @return
     * @throws Exception 
     */
    public String Login (String username, String psw) throws Exception{
        try{
            query = em.createQuery("SELECT pers FROM Person pers WHERE pers.username = :user").setParameter("user", username);
            List<Person> people = query.getResultList();
            if(!(people.isEmpty())&&people.get(0).getPassword().equals(psw))
                return  people.get(0).getRoleId().getName();
  
        }catch(Exception e){
            System.err.println(e.getMessage());
            throw new Exception("Something whent wrong when accessing the database");
        }
        System.err.println("Incorrect username or password username: "+username);
        throw new Exception("Incorrect username or password");
        
    }
}
