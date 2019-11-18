/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import model.Student;
import utilitaire.Fonction;
import utilitaire.Parser;

/**
 *
 * @author miker
 */

@Stateless(name="Bobo", mappedName="michael")
public class FunctionContainerImpl implements FunctionContainer {

    @Override
    public int getNombreAdmis(String filiere, String classe) throws Exception {
        return Fonction.getNombreAdmis(filiere, classe);
    }

    @Override
    public float getMoyenneGenerale(String filiere, String classe) throws Exception {
        return Fonction.getMoyenneGenerale(filiere, classe);
    }

    @Override
    public int getNombreAjourne(String filiere, String classe) throws Exception {
        return Fonction.getNombreAjourne(filiere, classe);
    }

    @Override
    public List<String> getAllFilieres() throws Exception {
        return Fonction.getAllFilieres();
    }

    @Override
    public List<String> getAllClasses() throws Exception {
        return Fonction.getAllClasses();
    }
    
}
