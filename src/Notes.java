
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sagar
 */
public class Notes extends javax.swing.JFrame {

    /**
     * Creates new form Notes
     */
    public Notes() {
        initComponents();
        
        Connect();
        
        Notes_table();
       
        showTime();
    }
    
    
    
    
     void showTime()
    {
        new Timer(0,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-YYYY hh:mm:ss"); /// jdatechooser default format : - MMM d, yyyy
        tfdt.setText(s.format(d));
            }
        }).start();
            
        
    }
       
     
     
     Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
            public void Connect()
            {
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con =  DriverManager.getConnection("jdbc:mysql://localhost/Billing","root","");
                } catch(ClassNotFoundException ex) {
                    Logger.getLogger(Notes.class.getName()).log(Level.SEVERE,null,ex);
                } catch(SQLException ex) {
                    Logger.getLogger(Notes.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            
           
      
            
            
            public void Notes_table()
            {
                try {
                    pst = con.prepareStatement("select * from notes");
                    
                     rs = pst.executeQuery();
                     ResultSetMetaData Rsm = rs.getMetaData();
                     int c;
                     c=Rsm.getColumnCount();
                     
                     DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
                     df.setRowCount(0);
                     
                     while(rs.next())
                     {
                         Vector v2 = new Vector();
                         
                         for(int i=1;i<c;i++)
                         {
                         
                         v2.add(rs.getString("id"));
                         v2.add(rs.getString("Subject"));
                         v2.add(rs.getString("DateTime"));
                         v2.add(rs.getString("Note"));   
                        
                         
                         }
                         df.addRow(v2);
                     }
                     
                     /******************************/
                     
                     
                     
                     
                     
                     /*************************/
                     
                     
                } catch (SQLException ex) {
                    Logger.getLogger(Notes.class.getName()).log(Level.SEVERE,null,ex);
                }
               
                
            }
     
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfid = new javax.swing.JTextField();
        tfn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tanote = new javax.swing.JTextArea();
        addButton = new javax.swing.JButton();
        addButton9 = new javax.swing.JButton();
        addButton10 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Forte", 0, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Notes");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 0, 170, 90));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 3, true), "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Imprint MT Shadow", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sr No. :-");

        tfid.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        tfid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidActionPerformed(evt);
            }
        });

        tfn.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        tfn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfnKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Subject :-");

        tfdt.setEditable(false);
        tfdt.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        tfdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdtActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date & Time of Entry :-");

        jLabel12.setFont(new java.awt.Font("Imprint MT Shadow", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Write Note :-");

        tanote.setColumns(20);
        tanote.setFont(new java.awt.Font("Imprint MT Shadow", 1, 18)); // NOI18N
        tanote.setRows(5);
        tanote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tanoteKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(tanote);

        addButton.setBackground(new java.awt.Color(0, 51, 102));
        addButton.setFont(new java.awt.Font("Imprint MT Shadow", 1, 24)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("Save");
        addButton.setOpaque(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        addButton9.setBackground(new java.awt.Color(0, 51, 102));
        addButton9.setFont(new java.awt.Font("Imprint MT Shadow", 1, 24)); // NOI18N
        addButton9.setForeground(new java.awt.Color(255, 255, 255));
        addButton9.setText("Edit Note");
        addButton9.setOpaque(false);
        addButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton9ActionPerformed(evt);
            }
        });

        addButton10.setBackground(new java.awt.Color(0, 51, 102));
        addButton10.setFont(new java.awt.Font("Imprint MT Shadow", 1, 24)); // NOI18N
        addButton10.setForeground(new java.awt.Color(255, 255, 255));
        addButton10.setText("Delete Note");
        addButton10.setOpaque(false);
        addButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdt, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(150, 150, 150)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfn, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(109, 109, 109)
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(addButton9)
                        .addGap(18, 18, 18)
                        .addComponent(addButton10)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(tfn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addButton)
                            .addComponent(addButton9)
                            .addComponent(addButton10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1480, 370));

        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Name", "Date & Time of Entry", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setOpaque(false);
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 1480, 240));

        jButton4.setBackground(new java.awt.Color(0, 51, 102));
        jButton4.setFont(new java.awt.Font("Imprint MT Shadow", 1, 28)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 200, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bggg.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1530, 900));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidActionPerformed

    private void tfnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfnKeyTyped

        char ch = evt.getKeyChar();

        if((ch>='a'&& ch<='z' )|| (ch>='A' && ch<='Z') || (ch == ' '))
        {

            ;
        }
        else
        evt.consume();

        // TODO add your handling code here:
    }//GEN-LAST:event_tfnKeyTyped

    private void tfdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdtActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();

        tfid.setText(d1.getValueAt(SelectIndex,0).toString());              ///1
        tfn.setText(d1.getValueAt(SelectIndex,1).toString());               ///2
        tanote.setText(d1.getValueAt(SelectIndex,3).toString());             ///3
        ///4 cannot changed
      

        addButton.setEnabled(false);

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        
        if(tfid.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter id", null,WARNING_MESSAGE);
        }
        else if(tfn.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter Name", null,WARNING_MESSAGE);
            
        }
        else if(tanote.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Please Enter Note", null,WARNING_MESSAGE);
            
        }
        else
        {
            
        
        
                String mid = tfid.getText().toUpperCase();                            ///1
                String subject = tfn.getText();                           ///2
                 String dt = tfdt.getText();                         ///3
                String note = tanote.getText();                           ///4
                
             
                
                
               
                
    
        try {
            pst = con.prepareStatement("insert into notes(id,Subject,DateTime,Note)values(?,?,?,?)");
            pst.setString(1,mid);
            pst.setString(2,subject);
            pst.setString(3,dt);
            pst.setString(4,note);
          
            
            pst.executeUpdate();
            
            
            JOptionPane.showMessageDialog(this,"Note Saved!!!");
            
            tfid.setText("");
            tfn.setText("");
            tfdt.setText("");
           
            tanote.setText("");
            
            tfid.requestFocus();
            Notes_table();
            
        } catch (SQLException ex) {
            Logger.getLogger(Notes.class.getName()).log(Level.SEVERE,null,ex);
        }
            
            
        
        
        
        }

// TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    private void tanoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tanoteKeyTyped

              char ch = evt.getKeyChar();

        if(ch == '\t' || ch == '\r')
        {

            evt.consume();
        }
        else
        ;




// TODO add your handling code here:
    }//GEN-LAST:event_tanoteKeyTyped

    private void addButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton9ActionPerformed

               
                String mname = tfn.getText();                           ///2
                 String dt = tfdt.getText();                         ///3
                String note = tanote.getText();                           ///4
                
                String mid = tfid.getText().toUpperCase();                            ///1
    
        try {
            pst = con.prepareStatement("update notes set Name = ?,DateTime = ?, note = ? where id = ?");
            
            
            pst.setString(1,mname);
            pst.setString(2,dt);
            pst.setString(3,note);
            pst.setString(4,mid);
           
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Note Edited!!!");
            
           
            tfn.setText("");
            tfid.setText("");
            
            tanote.setText("");
           
            tfid.requestFocus();
          
            Notes_table();
            addButton.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Notes.class.getName()).log(Level.SEVERE,null,ex);
        }
            






// TODO add your handling code here:
    }//GEN-LAST:event_addButton9ActionPerformed

    private void addButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButton10ActionPerformed

        
          
                String mid = tfid.getText().toUpperCase();                            ///1
    
        try {
            pst = con.prepareStatement("delete from notes  where id = ?");
            
            
           
            pst.setString(1,mid);
           
            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(this,"Note Deleted!!!");
            
           
            tfn.setText("");
            tfid.setText("");
            
            tanote.setText("");
           
            tfid.requestFocus();
          
            Notes_table();
            addButton.setEnabled(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(Notes.class.getName()).log(Level.SEVERE,null,ex);
        }






// TODO add your handling code here:
    }//GEN-LAST:event_addButton10ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        new MenuInvent().setVisible(true);
        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addButton10;
    private javax.swing.JButton addButton9;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTable1;
    private javax.swing.JTextArea tanote;
    private javax.swing.JTextField tfdt;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tfn;
    // End of variables declaration//GEN-END:variables
}
