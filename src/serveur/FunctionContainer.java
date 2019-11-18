/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author miker
 */

@Remote
public interface FunctionContainer {
    public int getNombreAdmis(String filiere, String classe) throws Exception;
    public float getMoyenneGenerale(String filiere, String classe) throws Exception;
    public int getNombreAjourne(String filiere, String classe) throws Exception;
    public List<String> getAllFilieres() throws Exception;
    public List<String> getAllClasses() throws Exception;
}
