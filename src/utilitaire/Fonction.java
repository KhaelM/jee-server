/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Student;

/**
 *
 * @author miker
 */
public class Fonction {
    public static int getNombreAdmis(String filiere, String classe) throws Exception {
        List<Student> allStudents = Parser.getStudents();
        Predicate<Student> byFiliereAndClasse = student -> student.getFiliere().equals(filiere)
                                                        && student.getClasse().equals(classe) 
                                                        && student.getMoyenne() >= 10;
        List<Student> personneApresFiltre = allStudents.stream()
                .filter(byFiliereAndClasse)
                .collect(Collectors.toList());
        
        return personneApresFiltre.size();
        
    }

    public static float getMoyenneGenerale(String filiere, String classe) throws Exception {
        List<Student> allStudents = Parser.getStudents();
        Predicate<Student> byFiliereAndClasse = student -> student.getFiliere().equals(filiere)
                                                        && student.getClasse().equals(classe);
        
        List<Student> personneApresFiltre = allStudents.stream()
                .filter(byFiliereAndClasse)
                .collect(Collectors.toList());
        
        float sum = 0;
        for(Student student: personneApresFiltre) {
            sum += student.getMoyenne();
        }
        
        return sum / (float)personneApresFiltre.size();
    }

    public static int getNombreAjourne(String filiere, String classe) throws Exception {
        List<Student> allStudents = Parser.getStudents();
        Predicate<Student> byFiliereAndClasse = student -> student.getFiliere().equals(filiere)
                                                        && student.getClasse().equals(classe) 
                                                        && student.getMoyenne() < 10;
        List<Student> personneApresFiltre = allStudents.stream()
                .filter(byFiliereAndClasse)
                .collect(Collectors.toList());
        
        return personneApresFiltre.size();
    }
    
    public static List<String> getAllFilieres() throws Exception {
        List<Student> allStudents = Parser.getStudents();
        List<String> unfilteredFiliere = new ArrayList();
        
        allStudents.forEach((student) -> {
            unfilteredFiliere.add(student.getFiliere());
        });
        List<String> uniqueFiliere = new ArrayList<>(new HashSet<>(unfilteredFiliere));
        
        Collections.sort(uniqueFiliere);
        
        return uniqueFiliere;
    }
    
    public static List<String> getAllClasses() throws Exception {
        List<Student> allStudents = Parser.getStudents();
        List<String> unfilteredClasse = new ArrayList();
        
        allStudents.forEach((student) -> {
            unfilteredClasse.add(student.getClasse());
        });
        List<String> uniqueClasse = new ArrayList<>(new HashSet<>(unfilteredClasse));
        
        Collections.sort(uniqueClasse);
        
        return uniqueClasse;
    }
}
