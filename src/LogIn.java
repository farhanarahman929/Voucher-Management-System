
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class LogIn extends javax.swing.JFrame {

    private  Statement stmt = null;
    private static Connection connection ;
    /**
     * Creates new form LogIn
     */
    public LogIn() throws ClassNotFoundException, SQLException {
        initComponents();

     System.out.println("DB connection Starting..login");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                + "user=sa;password=p@ssword13;" 
                + "databaseName=voucher;";
        connection = DriverManager.getConnection(connectionUrl);
        System.out.println("Connected database successfully.........");
         stmt = connection.createStatement();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rightPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        userIconLeft = new javax.swing.JLabel();
        user_name = new javax.swing.JLabel();
        userNameTextField = new javax.swing.JTextField();
        userIconRight = new javax.swing.JLabel();
        userPassword = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JPasswordField();
        logInButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(611, 613));
        setMinimumSize(new java.awt.Dimension(611, 613));

        rightPanel.setBackground(new java.awt.Color(255, 255, 255));
        rightPanel.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(24, 44, 97));
        jPanel1.setLayout(null);

        userIconLeft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/circle-cropped.png"))); // NOI18N
        jPanel1.add(userIconLeft);
        userIconLeft.setBounds(10, 190, 240, 233);

        rightPanel.add(jPanel1);
        jPanel1.setBounds(0, 0, 260, 620);

        user_name.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        user_name.setText("User Id");
        rightPanel.add(user_name);
        user_name.setBounds(390, 50, 134, 50);

        userNameTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rightPanel.add(userNameTextField);
        userNameTextField.setBounds(360, 130, 208, 50);

        userIconRight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user_name2.png"))); // NOI18N
        rightPanel.add(userIconRight);
        userIconRight.setBounds(260, 110, 70, 78);

        userPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pass2.png"))); // NOI18N
        rightPanel.add(userPassword);
        userPassword.setBounds(280, 270, 40, 50);

        password.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        password.setText("Password");
        rightPanel.add(password);
        password.setBounds(370, 190, 190, 50);

        passwordTextField.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        rightPanel.add(passwordTextField);
        passwordTextField.setBounds(360, 270, 208, 50);

        logInButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button1.png"))); // NOI18N
        logInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logInButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logInButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logInButtonMouseExited(evt);
            }
        });
        rightPanel.add(logInButton);
        logInButton.setBounds(390, 340, 154, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logInButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButtonMouseClicked
        String id=userNameTextField.getText();
        String pass=passwordTextField.getText();
        int id_number=Integer.parseInt(id);
        System.out.println(id_number);
        System.out.println(pass);
        String query = "Select * from [voucher].[dbo].[users]";
        int flag=1;
        try {
            ResultSet rs = stmt.executeQuery(query);
        
        while(rs.next())
        {
            
            if (id_number==rs.getInt(1) && pass.equals(rs.getString(3)))
            {
                flag=0;
                create_Voucher cd=new create_Voucher(id_number);
                this.setVisible(false);
                cd.setVisible(true);
            }
            
            
           // System.out.println(rs.getString(1)+rs.getString(3));
        }
        if (flag==1)
        {
              JFrame f=new JFrame();  
              JOptionPane.showMessageDialog(f,"Incorrect Id or Pass","Alert",JOptionPane.WARNING_MESSAGE);
              userNameTextField.setText("");
              passwordTextField.setText("");      
        }

        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("hi");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        
        
    }//GEN-LAST:event_logInButtonMouseClicked

    private void logInButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButtonMouseEntered
        
    }//GEN-LAST:event_logInButtonMouseEntered

    private void logInButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logInButtonMouseExited
       
    }//GEN-LAST:event_logInButtonMouseExited

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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LogIn().setVisible(true);
                   
        
    
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logInButton;
    private javax.swing.JLabel password;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JLabel userIconLeft;
    private javax.swing.JLabel userIconRight;
    private javax.swing.JTextField userNameTextField;
    private javax.swing.JLabel userPassword;
    private javax.swing.JLabel user_name;
    // End of variables declaration//GEN-END:variables
}
