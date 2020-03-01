/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GA.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import GA.database.Person;
import GA.database.Role;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

/**
 *
 * @author bestPersonEver
 */
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRES_NEW)
public class RegisterDAO {
        
    @PersistenceContext(unitName="my_persistence_unit")
    private EntityManager em;
    private Query query;
    
    /**
     * tries to register/save person in database
     * @param name
     * @param lastname
     * @param username
     * @param SSN
     * @param Email
     * @param pwd
     * @throws Exception 
     */
    public void register (String name, String lastname, String username, String SSN, String Email, String pwd) throws Exception{
        try{
            //checks if username is taken
            query = em.createQuery("SELECT pers FROM Person pers WHERE pers.username = :user").setParameter("user", username);
            List<Person> people = query.getResultList();
            if(!(people.isEmpty()))
                throw new Exception("username already exist, choose another username");
            
            //adds info into the entity person
            query = em.createQuery("SELECT pers FROM Person pers");
            List<Person> peps = query.getResultList();
            Person person = new Person();
            person.setPersonId(Long.valueOf(peps.size()+1));
            person.setName(name);
            person.setSurname(lastname);
            person.setUsername(username);
            person.setSsn(SSN);
            person.setEmail(Email);
            person.setPassword(pwd);
            person.setRoleId(em.find(Role.class,Long.valueOf(2)));
            
            //persist the person into the DB
            em.persist(person);
        }catch(Exception e){
            System.err.println(e.getMessage());
            throw new Exception("Something whent wrong when accessing the database");
        }
    }

}
