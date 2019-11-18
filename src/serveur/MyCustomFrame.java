/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serveur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
import model.Student;
import utilitaire.Parser;

/**
 *
 * @author miker
 */
public class MyCustomFrame extends javax.swing.JFrame {
    enum SortingAttribute {
        MOYENNE,
        NOM
    }
    
    private SortingAttribute sortingAttribute;
    private boolean ascendingChecked;
    
    public void updateStudentList() throws Exception {
        System.out.println("ato");
        setSortingAttribute();
        setAscendingChecked();
        
        clearStudentsListe();
        
        String filiereSelected = String.valueOf(filiereComboBox.getSelectedItem());
        String classeSelected = String.valueOf(classeComboBox.getSelectedItem());
        
        List<Student> allStudents = Parser.getStudents();
        List<Student> filteredStudents = new ArrayList();
        for(Student student: allStudents) {
            if(student.getFiliere().equals(filiereSelected) && student.getClasse().equals(classeSelected)) {
                filteredStudents.add(student);
            }
        }
        
        if(sortingAttribute == SortingAttribute.MOYENNE) {
            filteredStudents = filteredStudents.stream()
                    .sorted(Comparator.comparing(Student::getMoyenne))
                    .collect(Collectors.toList());
        } else {
            filteredStudents = filteredStudents.stream()
                    .sorted(Comparator.comparing(Student::getNom))
                    .collect(Collectors.toList());
        }
        
        if(!ascendingChecked) {
            Collections.reverse(filteredStudents);
        }
        
        
        DefaultTableModel model = (DefaultTableModel) searchResultTable.getModel();
        filteredStudents.forEach((student) -> {
            model.addRow(new Object[]{student.getNom(), student.getMoyenne(), student.getMention()});
        });
        
        nbResultats.setText(filteredStudents.size() + " Résultat(s)");
    }
    
    /**
     * Creates new form MyCustomFrame
     */
    public MyCustomFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OrdreTri = new javax.swing.ButtonGroup();
        TriPar = new javax.swing.ButtonGroup();
        filiereComboBox = new javax.swing.JComboBox<>();
        classeComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        TriParNom = new javax.swing.JRadioButton();
        TriParMoyenne = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        TriCroissant = new javax.swing.JRadioButton();
        TriDecroissant = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchResultTable = new javax.swing.JTable();
        nbResultats = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        filiereComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filière" }));

        classeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Classe" }));

        jButton1.setText("Afficher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TriPar.add(TriParNom);
        TriParNom.setText("Nom");

        TriPar.add(TriParMoyenne);
        TriParMoyenne.setSelected(true);
        TriParMoyenne.setText("Moyenne");

        jLabel1.setText("Trier par:");

        OrdreTri.add(TriCroissant);
        TriCroissant.setSelected(true);
        TriCroissant.setText("Croissant");

        OrdreTri.add(TriDecroissant);
        TriDecroissant.setText("Décroissant");

        jLabel2.setText("Ordre de tri");

        searchResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Moyenne", "Mention"
            }
        ));
        jScrollPane1.setViewportView(searchResultTable);

        nbResultats.setText("0 Résultat(s)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TriCroissant)
                        .addGap(12, 12, 12)
                        .addComponent(TriDecroissant))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(filiereComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(classeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nbResultats))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TriParMoyenne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TriParNom))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filiereComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(nbResultats))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TriParMoyenne)
                    .addComponent(TriParNom))
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TriCroissant)
                    .addComponent(TriDecroissant))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            updateStudentList();
        } catch(Exception e) {
            System.out.print("Misy exception");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyCustomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyCustomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyCustomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyCustomFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyCustomFrame().setVisible(true);
            }
        });
    }
    
    public void clearStudentsListe() {
        DefaultTableModel model = (DefaultTableModel) searchResultTable.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    public void loadFilieres() throws Exception {
        List<Student> allStudents = Parser.getStudents();
        List<String> unfilteredFiliere = new ArrayList();
        
        allStudents.forEach((student) -> {
            unfilteredFiliere.add(student.getFiliere());
        });
        List<String> uniqueFiliere = new ArrayList<>(new HashSet<>(unfilteredFiliere));
        
        Collections.sort(uniqueFiliere);
        uniqueFiliere.forEach((filiere) -> {
            filiereComboBox.addItem(filiere);
        });
        
    }
    
    public void loadClasses() throws Exception {
        List<Student> allStudents = Parser.getStudents();
        List<String> unfilteredClasse = new ArrayList();
        
        allStudents.forEach((student) -> {
            unfilteredClasse.add(student.getClasse());
        });
        List<String> uniqueClasse = new ArrayList<>(new HashSet<>(unfilteredClasse));
        
        Collections.sort(uniqueClasse);
        uniqueClasse.forEach((classe) -> {
            classeComboBox.addItem(classe);
        }); 
    }
    
    public void init() throws Exception {
        loadFilieres();
        loadClasses();
    }
    
    public void setSortingAttribute() {
        if(TriParMoyenne.isSelected())
            sortingAttribute = SortingAttribute.MOYENNE;
        else
            sortingAttribute = SortingAttribute.NOM;
    }
    
    public void setAscendingChecked() {
        ascendingChecked = TriCroissant.isSelected();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup OrdreTri;
    private javax.swing.JRadioButton TriCroissant;
    private javax.swing.JRadioButton TriDecroissant;
    private javax.swing.ButtonGroup TriPar;
    private javax.swing.JRadioButton TriParMoyenne;
    private javax.swing.JRadioButton TriParNom;
    private javax.swing.JComboBox<String> classeComboBox;
    private javax.swing.JComboBox<String> filiereComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nbResultats;
    private javax.swing.JTable searchResultTable;
    // End of variables declaration//GEN-END:variables
}