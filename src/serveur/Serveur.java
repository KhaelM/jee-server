/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

/**
 *
 * @author miker
 */
public class Serveur {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        MyCustomFrame window = new MyCustomFrame();
        window.init();
        window.setVisible(true);
    }
    
}
