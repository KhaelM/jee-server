/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author miker
 */
public class Parser {
    public static List<Student> getStudents() throws Exception
    {
        List studentList = new ArrayList();
        File file = new File("D:\\Programming\\JavaEE\\Serveur\\studentList.txt");
        BufferedReader bufferReader = new BufferedReader(new FileReader(file));
        
        String line;
        while((line = bufferReader.readLine()) != null)
        {
            studentList.add(parseLine(line));
        } 
        
        return studentList;
    }
    
    private static Student parseLine(String line) throws Exception {
        String[] splitted = line.split(";");
        
        if(splitted.length != 4)
            throw new Exception("Missing information");
        
        return new Student(splitted[2], splitted[0], splitted[1], Float.valueOf(splitted[3]));
    }
    
    
}
