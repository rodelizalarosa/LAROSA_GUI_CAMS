/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signInUp;

import config.connectDB;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Sem
 */
public class signUp extends javax.swing.JFrame {

    private JTextField fnameSU;
    private JTextField mnameSU;
    private JTextField lnameSU;
    private JTextField contSU;
    private JTextField userSU;
    private JTextField emailSU;
    private JPasswordField passSU;
    private JComboBox<String> typeUser; // For user type/role
    private JButton SIGNIN1;  // Assuming this is your register button.
    private Connection connectDB;
    private String user_id;
    
    
    public signUp() {
        initComponents(); // Initialize your components (NetBeans generated)
        
        connectDB connect = new connectDB();
         
        connectDB = (Connection) new connectDB(); // Create the connection object. This is CRUCIAL.
        if (connectDB.getConnection() == null) {
            JOptionPane.showMessageDialog(this, "Failed to connect to the database. Application will exit.", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Or handle the error as needed
        }
    }
    
    
       
   
    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    private boolean isUsernameTaken(String username) {
        String sql = "SELECT COUNT(*) FROM user WHERE username = ?"; // Corrected SQL
        try (PreparedStatement pst = connectDB.getConnection().prepareStatement(sql)) {
            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) { // Use try-with-resources for ResultSet
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle the exception appropriately (e.g., log it)
        }
        return false;
    }


    private boolean validateField(javax.swing.JTextField field, String fieldName) {
        if (field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, fieldName + " cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    private boolean validateContact(javax.swing.JTextField contSU) {
        String contactText = contSU.getText().trim();
        if (contactText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contact Number cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!contactText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Contact Number must contain only numbers", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }


    private boolean validatePassword(javax.swing.JPasswordField passSU) {
        String passwordText = new String(passSU.getPassword());
        if (passwordText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (passwordText.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isAllFieldsEmpty() {
        return fnameSU.getText().trim().isEmpty() && mnameSU.getText().trim().isEmpty()
                && lnameSU.getText().trim().isEmpty() && contSU.getText().trim().isEmpty()
                && typeUser.getSelectedIndex() == 0 && userSU.getText().trim().isEmpty()
                && emailSU.getText().trim().isEmpty() && passSU.getPassword().length == 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        forgotPass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SU = new javax.swing.JLabel();
        desc4 = new javax.swing.JLabel();
        desc5 = new javax.swing.JLabel();
        SIGNIN = new javax.swing.JLabel();
        mnameSU = new javax.swing.JTextField();
        signUpUser = new javax.swing.JLabel();
        signUpPass = new javax.swing.JLabel();
        passSU = new javax.swing.JPasswordField();
        SIGNIN1 = new javax.swing.JLabel();
        userSU = new javax.swing.JTextField();
        fnameSU = new javax.swing.JTextField();
        contSU = new javax.swing.JTextField();
        lnameSU = new javax.swing.JTextField();
        dobSU = new javax.swing.JTextField();
        signUpUser1 = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        mname = new javax.swing.JLabel();
        lname = new javax.swing.JLabel();
        typeUser = new javax.swing.JComboBox<>();
        cont = new javax.swing.JLabel();
        signUpUser6 = new javax.swing.JLabel();
        SU1 = new javax.swing.JLabel();
        emailSU = new javax.swing.JTextField();
        signUpUser2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(810, 540));
        setPreferredSize(new java.awt.Dimension(810, 540));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        forgotPass.setBackground(new java.awt.Color(255, 255, 255));
        forgotPass.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        forgotPass.setForeground(new java.awt.Color(0, 204, 204));
        forgotPass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPass.setText("Forgot Password?");
        jPanel4.add(forgotPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 306, 150, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/medlogo.png"))); // NOI18N
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, 110));

        SU.setBackground(new java.awt.Color(255, 255, 255));
        SU.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        SU.setForeground(new java.awt.Color(255, 255, 255));
        SU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SU.setText("Welcome Back!");
        jPanel4.add(SU, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 190, 40));

        desc4.setBackground(new java.awt.Color(255, 255, 255));
        desc4.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        desc4.setForeground(new java.awt.Color(255, 255, 255));
        desc4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desc4.setText("login your personal details.");
        desc4.setAutoscrolls(true);
        desc4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(desc4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 290, -1));

        desc5.setBackground(new java.awt.Color(255, 255, 255));
        desc5.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        desc5.setForeground(new java.awt.Color(255, 255, 255));
        desc5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        desc5.setText("To keep connected with us, please");
        desc5.setAutoscrolls(true);
        desc5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(desc5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 290, -1));

        SIGNIN.setBackground(new java.awt.Color(255, 255, 255));
        SIGNIN.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        SIGNIN.setForeground(new java.awt.Color(0, 204, 204));
        SIGNIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SIGNIN.setText("SIGN IN");
        SIGNIN.setDoubleBuffered(true);
        SIGNIN.setOpaque(true);
        SIGNIN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SIGNINMouseClicked(evt);
            }
        });
        jPanel4.add(SIGNIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 130, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 490));

        mnameSU.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        mnameSU.setForeground(new java.awt.Color(204, 204, 255));
        mnameSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnameSUActionPerformed(evt);
            }
        });
        jPanel1.add(mnameSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 220, 30));

        signUpUser.setBackground(new java.awt.Color(255, 255, 255));
        signUpUser.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        signUpUser.setForeground(new java.awt.Color(0, 204, 204));
        signUpUser.setText("Type");
        jPanel1.add(signUpUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, 30));

        signUpPass.setBackground(new java.awt.Color(255, 255, 255));
        signUpPass.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        signUpPass.setForeground(new java.awt.Color(0, 204, 204));
        signUpPass.setText("Password");
        jPanel1.add(signUpPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 70, 30));

        passSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passSUActionPerformed(evt);
            }
        });
        jPanel1.add(passSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 400, 220, 30));

        SIGNIN1.setBackground(new java.awt.Color(0, 204, 204));
        SIGNIN1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        SIGNIN1.setForeground(new java.awt.Color(255, 255, 255));
        SIGNIN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SIGNIN1.setText("SIGN UP");
        SIGNIN1.setDoubleBuffered(true);
        SIGNIN1.setOpaque(true);
        SIGNIN1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SIGNIN1MouseClicked(evt);
            }
        });
        jPanel1.add(SIGNIN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 440, 130, 30));

        userSU.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        userSU.setForeground(new java.awt.Color(204, 204, 255));
        userSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSUActionPerformed(evt);
            }
        });
        jPanel1.add(userSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 320, 220, 30));

        fnameSU.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        fnameSU.setForeground(new java.awt.Color(204, 204, 255));
        fnameSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameSUActionPerformed(evt);
            }
        });
        jPanel1.add(fnameSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 220, 30));

        contSU.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        contSU.setForeground(new java.awt.Color(204, 204, 255));
        contSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contSUActionPerformed(evt);
            }
        });
        jPanel1.add(contSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 200, 220, 30));

        lnameSU.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        lnameSU.setForeground(new java.awt.Color(204, 204, 255));
        lnameSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameSUActionPerformed(evt);
            }
        });
        jPanel1.add(lnameSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 160, 220, 30));

        dobSU.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        dobSU.setForeground(new java.awt.Color(204, 204, 255));
        dobSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dobSUActionPerformed(evt);
            }
        });
        jPanel1.add(dobSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 220, 30));

        signUpUser1.setBackground(new java.awt.Color(255, 255, 255));
        signUpUser1.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        signUpUser1.setForeground(new java.awt.Color(0, 204, 204));
        signUpUser1.setText("Username");
        jPanel1.add(signUpUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, 30));

        fname.setBackground(new java.awt.Color(255, 255, 255));
        fname.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        fname.setForeground(new java.awt.Color(0, 204, 204));
        fname.setText("First Name");
        jPanel1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, 30));

        mname.setBackground(new java.awt.Color(255, 255, 255));
        mname.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        mname.setForeground(new java.awt.Color(0, 204, 204));
        mname.setText("Middle Name");
        jPanel1.add(mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, -1, 30));

        lname.setBackground(new java.awt.Color(255, 255, 255));
        lname.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        lname.setForeground(new java.awt.Color(0, 204, 204));
        lname.setText("Last Name");
        jPanel1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, 30));

        typeUser.setEditable(true);
        typeUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select User Type", "Patient", "Doctor", "Staff" }));
        typeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeUserActionPerformed(evt);
            }
        });
        jPanel1.add(typeUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, 220, 30));

        cont.setBackground(new java.awt.Color(255, 255, 255));
        cont.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        cont.setForeground(new java.awt.Color(0, 204, 204));
        cont.setText("Contact Number");
        jPanel1.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, -1, 30));

        signUpUser6.setBackground(new java.awt.Color(255, 255, 255));
        signUpUser6.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        signUpUser6.setForeground(new java.awt.Color(0, 204, 204));
        signUpUser6.setText("Date of Birth");
        jPanel1.add(signUpUser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 240, -1, 30));

        SU1.setBackground(new java.awt.Color(0, 204, 204));
        SU1.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        SU1.setForeground(new java.awt.Color(0, 204, 204));
        SU1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SU1.setText("SIGN UP");
        jPanel1.add(SU1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 174, 40));

        emailSU.setFont(new java.awt.Font("Nirmala UI", 0, 12)); // NOI18N
        emailSU.setForeground(new java.awt.Color(204, 204, 255));
        emailSU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailSUActionPerformed(evt);
            }
        });
        jPanel1.add(emailSU, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 220, 30));

        signUpUser2.setBackground(new java.awt.Color(255, 255, 255));
        signUpUser2.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        signUpUser2.setForeground(new java.awt.Color(0, 204, 204));
        signUpUser2.setText("Email");
        jPanel1.add(signUpUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 360, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnameSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnameSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnameSUActionPerformed

    private void passSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passSUActionPerformed

    private void userSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userSUActionPerformed

    private void fnameSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameSUActionPerformed

    private void contSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contSUActionPerformed

    private void lnameSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameSUActionPerformed

    private void dobSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dobSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dobSUActionPerformed

    private void typeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeUserActionPerformed

    private void SIGNINMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIGNINMouseClicked
        signIn si = new signIn();
        si.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_SIGNINMouseClicked

    private void emailSUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailSUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailSUActionPerformed

    private void SIGNIN1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SIGNIN1MouseClicked
        
        String firstname = fnameSU.getText().trim();
        String middlename = mnameSU.getText().trim();
        String lastname = lnameSU.getText().trim();
        String contact = contSU.getText().trim();
        String username = userSU.getText().trim();
        String email = emailSU.getText().trim();
        String password = new String(passSU.getPassword()).trim(); // Get password from JPasswordField
        String type = (String) typeUser.getSelectedItem(); // Get selected user type.

        if (isAllFieldsEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill out the registration form", "Empty Form", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean isValid = true;

   
        if (fnameSU.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "First Name cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        if (mnameSU.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Middle Name cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        
        if (lnameSU.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Last Name cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        
        String contactText = contSU.getText().trim();
        if (contactText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Contact Number cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (!contactText.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Contact Number must contain only numbers", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        
        // Validate Role
        if (typeUser.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select type", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        
        // Validate Username
        String usernameText = userSU.getText().trim();
        if (usernameText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (isUsernameTaken(usernameText)) {
            JOptionPane.showMessageDialog(this, "Username is already taken", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        
        // Validate Email
        String emailText = emailSU.getText().trim();
        if (emailText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (!isValidEmail(emailText)) {
            JOptionPane.showMessageDialog(this, "Invalid email format", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        // Validate Password
        String passwordText = new String(passSU.getPassword());
        if (passwordText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (passwordText.length() < 8) {
            JOptionPane.showMessageDialog(this, "Password must be at least 8 characters long", "Validation Error", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        // If all validations pass, proceed with registration
        if (isValid) {
            // TODO: Implement actual registration logic
            JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);    
        }
        
        this.dispose();
        
        String sql = "INSERT INTO user (user_fname, user_mname, user_lname, contact, type, email, username, password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // Removed user_id
            try (PreparedStatement pst = connectDB.connect().prepareStatement(sql)) {
                pst.setString(1, firstname);
                pst.setString(2, middlename);
                pst.setString(3, lastname);
                pst.setString(4, contact);
                pst.setString(5, type);
                pst.setString(6, email);
                pst.setString(7, username);
                pst.setString(8, password);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearFields(); // Implement clearFields()
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace(); // Very important to print the stack trace for debugging
            }
            
    }//GEN-LAST:event_SIGNIN1MouseClicked

    private void clearFields() {
        fnameSU.setText("");
        mnameSU.setText("");
        lnameSU.setText("");
        contSU.setText("");
        userSU.setText("");
        emailSU.setText("");
        passSU.setText("");
    }
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
            java.util.logging.Logger.getLogger(signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SIGNIN;
    private javax.swing.JLabel SIGNIN1;
    private javax.swing.JLabel SU;
    private javax.swing.JLabel SU1;
    private javax.swing.JLabel cont;
    private javax.swing.JTextField contSU;
    private javax.swing.JLabel desc4;
    private javax.swing.JLabel desc5;
    private javax.swing.JTextField dobSU;
    private javax.swing.JTextField emailSU;
    private javax.swing.JLabel fname;
    private javax.swing.JTextField fnameSU;
    private javax.swing.JLabel forgotPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lname;
    private javax.swing.JTextField lnameSU;
    private javax.swing.JLabel mname;
    private javax.swing.JTextField mnameSU;
    private javax.swing.JPasswordField passSU;
    private javax.swing.JLabel signUpPass;
    private javax.swing.JLabel signUpUser;
    private javax.swing.JLabel signUpUser1;
    private javax.swing.JLabel signUpUser2;
    private javax.swing.JLabel signUpUser6;
    private javax.swing.JComboBox<String> typeUser;
    private javax.swing.JTextField userSU;
    // End of variables declaration//GEN-END:variables
}
