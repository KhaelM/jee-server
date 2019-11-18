/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author miker
 */
public class Student {

    private String _nom;
    private String _filiere;
    private String _classe;
    private float _moyenne;
    
    public Student(String nom, String filiere, String classe, float moyenne) throws Exception {
        this._nom = nom;
        this._filiere = filiere;
        this._classe = classe;
        this.setMoyenne(moyenne);
    }

    /**
     * @return the _nom
     */
    public String getNom() {
        return _nom;
    }

    /**
     * @return the _filiere
     */
    public String getFiliere() {
        return _filiere;
    }

    /**
     * @return the _classe
     */
    public String getClasse() {
        return _classe;
    }

    /**
     * @return the _moyenne
     */
    public float getMoyenne() {
        return _moyenne;
    }

    public String getMention() {
        String mention;
        if (_moyenne < 10) {
            mention = "Recallé";
        } else if (_moyenne < 13) {
            mention = "Passable";
        } else if (_moyenne < 15) {
            mention = "Assez Bien";
        } else if (_moyenne < 16) {
            mention = "Bien";
        } else {
            mention = "Très Bien";
        }

        return mention;
    }

    /**
     * @param _moyenne the _moyenne to set
     */
    public void setMoyenne(float moyenne) throws Exception {
        if(moyenne < 0 || moyenne > 20)
            throw new Exception("Moyenne hors limite");
        
        this._moyenne = moyenne;
    }
}
