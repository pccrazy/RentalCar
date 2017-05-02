/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarRentalSystem.Forms;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import CarRentalSystem.Pojos.User;
import CarRentalSystem.Pojos.Error;
import CarRentalSystem.Utilities.CustomeException;
import CarRentalSystem.Utilities.UserHandler;

/**
 * Created by Radcliffe Brown-H000063206-CKIT-510-2-Week5-6 30/04/2017
 */

public class LoginForm extends JFrame implements UserHandler {

    User user=User.getInstance();
    Error error=Error.getErrorInstance();

    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
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

        jTextField1UserName = new javax.swing.JTextField();
        jTextPassword = new javax.swing.JTextField();
        javax.swing.JLabel jLabel1UserName = new javax.swing.JLabel();
        javax.swing.JLabel jLabel1UserName1 = new javax.swing.JLabel();
        jLogin = new javax.swing.JButton();
        jLabelCreateAccount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1UserName.setText("Password");
        jLabel1UserName.setToolTipText("");

        jLabel1UserName1.setText("Member number ");

        jLogin.setText("Login");
        jLogin.addActionListener(evt -> startLoginProccess(evt));

        jLabelCreateAccount.setText("Create Account");
        jLabelCreateAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCreateAccountMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1UserName))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jTextField1UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel1UserName1)))
                .addGap(0, 44, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jLabelCreateAccount)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1UserName1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel1UserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabelCreateAccount)
                .addGap(32, 32, 32))
        );

        user.addListener(this);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startLoginProccess(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //
        // TODO add your radcliffe add error handling code here:

        try {
            if ((jTextField1UserName.getText().isEmpty()) | (jTextPassword.getText().isEmpty())) {

                throw new CustomeException("Login text fields cannot be empty, please try again!");

            }else{
                UserHandler.login(jTextField1UserName.getText(),jTextPassword.getText());
            }

        }catch(CustomeException e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

//jLabelCreateAccount.addMouseListener(new MouseAdapter()  
//{ 
    private void jLabelCreateAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCreateAccountMouseClicked
               // TODO add your handling code here:
       // you can open a new frame here as
       // i have assumed you have declared "frame" as instance variable

       this.dispose(); //close the previous form
       if(evt.getSource().equals(jLabelCreateAccount)){

        AcountForm jf = new AcountForm();
        jf.setTitle("Create Account");
           
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Point middle = new Point(screenSize.width / 2, screenSize.height / 2);
        Point newLocation = new Point(middle.x - (jf.getWidth() / 2), 
                              middle.y - (jf.getHeight() / 2));
                      
        jf.pack();
            
        jf.setLocation(newLocation);
          
        jf.setVisible(true);
      
        }
    }//GEN-LAST:event_jLabelCreateAccountMouseClicked
//}); 
    
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jLogin;
    private javax.swing.JLabel jLabelCreateAccount;
    private javax.swing.JTextField jTextField1UserName;
    javax.swing.JTextField jTextPassword;
    @Override
    public void onSuccessLogin() {
        //Todo radclifee go to next GUI , close current
        this.dispose(); //close the previous form

        AvailableVehicleForm jf = new AvailableVehicleForm();
        jf.setTitle("Available Hire Cars");

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        Point middle = new Point(width / 2, height / 2);
        Point newLocation = new Point(middle.x - (jf.getWidth() / 2),
        middle.y - (jf.getHeight() / 2));

        jf.pack();

        jf.setLocation(newLocation);

        jf.setVisible(true);

        System.out.println("OnSuccessLogin");

    }

    @Override
    public void onUnSuccessLogin() {
        // Todo show an error message as what they have toaught us in the module

        JOptionPane.showMessageDialog(null, "Invalid Login!, Please try again");

        System.out.println("On Error Login");
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        System.out.println("rad test");
    }
    // End of variables declaration//GEN-END:variables
}
