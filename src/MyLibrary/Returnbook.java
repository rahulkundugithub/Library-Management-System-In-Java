/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyLibrary;

import java.awt.event.KeyEvent;
import java.sql.ResultSetMetaData;
   import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
//import com.sun.jdi.connect.spi.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rahul Kundu
 */
public class Returnbook extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Returnbook() {
        initComponents();
            //calling database connection constructor
            connect();
           // book();
           Returnbookload();
            
    }
    
    
    
    
    
    
        //connection to database
        Connection con;
        PreparedStatement pst; //will be used to load SQL queries
        ResultSet rs;
        
        public void connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Library","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Returnbook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Returnbook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //connection to database is complete
        
        
        //fetching data from database to JTable

    /**
     *
     */
        public void Returnbookload()
        {
            int c;
        try {
            pst=con.prepareStatement("select r.id,r.memberid,r.membername,r.bookname,r.returndate,r.actualreturndate,r.elapsed,r.fine from returnbook r");
            rs=pst.executeQuery();              
            ResultSetMetaData rsd=rs.getMetaData();
            c=rsd.getColumnCount();
            
            DefaultTableModel d=(DefaultTableModel)jTable1.getModel();//jTable1 is the name of the table variable
            d.setRowCount(0);
            
            while(rs.next())
            {
            Vector v2=new Vector();
                for(int i=1;i<=c;i++)
                {
                    v2.add(rs.getString("id"));
                v2.add(rs.getString("memberid"));
                v2.add(rs.getString("membername")); 
                v2.add(rs.getString("bookname"));
                v2.add(rs.getString("returndate"));
                v2.add(rs.getString("actualreturndate"));
                v2.add(rs.getString("elapsed"));
                v2.add(rs.getString("fine"));
                }
            d.addRow(v2);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Returnbook.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtmid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtmname = new javax.swing.JLabel();
        txtbook = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtelap = new javax.swing.JTextField();
        txtfine = new javax.swing.JTextField();
        txtrdate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("Return Book");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Member Id :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Member Name :");

        txtmid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmidActionPerformed(evt);
            }
        });
        txtmid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmidKeyPressed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Member ID", "Member Name", "Book Name", "Return Date", "Actual ReturnDate", "Elapsed Days", "Fine"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Book :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Return Date. :");

        txtmname.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtbook.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Date Elapsed :");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Fine :");

        txtelap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtelapActionPerformed(evt);
            }
        });

        txtrdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel4.setText("Put member id and press enter to auto fill");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(19, 19, 19)))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtmid, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                                .addComponent(txtmname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtbook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtrdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtelap)
                                                .addComponent(txtfine)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 364, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(120, 120, 120))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmid, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmname, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(txtbook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(txtrdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtelap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfine, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(349, 349, 349))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
            //action of Add button-sending Issuebook data to sql returnbook table
            
                
            Date date = new Date();
      SimpleDateFormat da = new SimpleDateFormat("yyyy-MM-dd");
       String adate = da.format(date);//to get current date
       
            String mid=txtmid.getText();
            String mname=txtmname.getText();
            String book=txtbook.getText();
            String rdate=txtrdate.getText();
            String elap=txtelap.getText();
            String fine=txtfine.getText();
            
        try {
            pst = con.prepareStatement("insert into returnbook(memberid,membername,bookname,returndate,actualreturndate,elapsed,fine)values(?,?,?,?,?,?,?)"); //1st one is table name of sql and inside bracket these are column names
            pst.setString(1, mid);
            pst.setString(2,mname);//as we want to put book id on jtable
            pst.setString(3, book);
            pst.setString(4, rdate);
            pst.setString(5, adate);
            pst.setString(6, elap);
            pst.setString(7, fine);
            
            int k = pst.executeUpdate();
            
            pst = con.prepareStatement("delete from issuebook where member_id=?");
            pst.setString(1, mid);
            pst.executeUpdate();
            if(k==1)
            {
            JOptionPane.showMessageDialog(this, "Book returned successfully..");
            txtmid.setText("");//to clear the text box
            txtmname.setText("");
            txtbook.setText("");
            txtrdate.setText("");
            txtelap.setText("");
            txtfine.setText("");
            txtmid.requestFocus();//to bring the cursor on Author name box
           Returnbookload();//will show the current input on jtable
            }
            else
            {
            JOptionPane.showMessageDialog(this, "Error in Book return!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Returnbook.class.getName()).log(Level.SEVERE, null, ex);
        }
//            }
//            }
//            }
//            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
            //if we click on any data on the jtable then it will appear on box and we will be able to edit the data
            
            
            DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
            int selectIndex=jTable1.getSelectedRow(); //row no of the selected data from the jtable is being fetched
            //JOptionPane.showMessageDialog(this, d1.getValueAt(selectIndex,2).toString());
            int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
            txtmid.setText(d1.getValueAt(selectIndex,1).toString());
            
            
            
            jButton1.setEnabled(false);//this will inactivate the Add button when a row is being selected from from jtable
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
            //action of Update button-sending Updated Author details to sql and jtable
            
            DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
            int selectIndex=jTable1.getSelectedRow(); //row no of the selected data from the jtable is being fetched
            
            int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
            
        int mid =Integer.parseInt( txtmid.getText());
        String mname = txtmname.getText();
        String book = txtbook.getText();
        String rdate = txtrdate.getText();
        int elap = Integer.parseInt(txtelap.getText());
        int fine = Integer.parseInt(txtfine.getText());
        
        
        
      
        
        
        try {
            pst = con.prepareStatement("update returnbook set memberid = ?, membername= ?, bookname= ?, returndate=?, elapsed=?, fine=? where id = ?"); //1st one is database table name,rest are column name
            pst.setInt(1, mid);
            pst.setString(2,mname);
            pst.setString(3,book);
            pst.setString(4, rdate);
            pst.setInt(5,elap);
            pst.setInt(6,fine);
            pst.setInt(7,id);
            int k = pst.executeUpdate();
            if(k==1)
            {
            JOptionPane.showMessageDialog(this, "Bookreturn details Updated successfully..");
            txtmid.setText("");//to clear the text box
            txtmname.setText("");
            txtbook.setText("");
            txtrdate.setText("");
            txtelap.setText("");
            txtfine.setText("");
            txtmid.requestFocus();//to bring the cursor on memberid box
           Returnbookload();//will show the current input on jtable
            jButton1.setEnabled(true);//reenable the Add button
            }
            else
            {
            JOptionPane.showMessageDialog(this, "Error in Bookreturn details Updatation!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Returnbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
                //Remove button action
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
            int selectIndex=jTable1.getSelectedRow(); //row no of the selected data from the jtable is being fetched
            int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
            
        try {
            pst = con.prepareStatement("delete from returnbook where id = ?"); //here book is database table name
            pst.setInt(1, id);
            int k = pst.executeUpdate();
            if(k==1)
            {
            JOptionPane.showMessageDialog(this, "Bookreturn details Removed successfully..");
            txtmid.setText("");//to clear the text box
            txtmname.setText("");
            txtbook.setText("");
            txtrdate.setText("");
            txtelap.setText("");
            txtfine.setText("");
            txtmid.requestFocus();//to bring the cursor on memberid box
           Returnbookload();
            jButton1.setEnabled(true);//reenable the Add button
            }
            else
            {
            JOptionPane.showMessageDialog(this, "error in Bookreturn details Removal!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Returnbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //Cancel the window
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtmidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmidKeyPressed
        // TODO add your handling code here:
                //if we insert member id and press enter then member name will be displayed in membername textbox
                if(evt.getKeyCode()==KeyEvent.VK_ENTER)
                {
        String id=txtmid.getText();
        try {
            pst=con.prepareStatement("select m.member_name,b.Book_Name,i.returndate,DATEDIFF(now(),i.returndate) as elap from member m,book b,issuebook i where ?=m.id and i.book_id=b.ID and m.id=i.member_id");
            pst.setString(1, id);
            rs=pst.executeQuery();
            if(rs.next()==false)
            {
            JOptionPane.showMessageDialog(this,"No book has been issued to this member");
            txtelap.setText("");
            txtfine.setText("");
            }
            else
            {
            String mname=rs.getString("m.member_name");
            String bname=rs.getString("b.Book_Name");
            String rdate=rs.getString("i.returndate");
            int e=Integer.parseInt(rs.getString("elap"));
            txtmname.setText(mname.trim());
            txtbook.setText(bname.trim());
            txtrdate.setText(rdate.trim());
            if(e>0)
                {
                  txtelap.setText(String.valueOf(e));
                  int fine=e*5;
                  txtfine.setText(String.valueOf(fine));
                }
            else
                {
                    txtelap.setText(String.valueOf("0"));
                    txtfine.setText(String.valueOf("0"));
                }
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Returnbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                }   
        
        
        
    }//GEN-LAST:event_txtmidKeyPressed

    private void txtelapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtelapActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_txtelapActionPerformed

    private void txtmidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmidActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException {
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
            java.util.logging.Logger.getLogger(Returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Returnbook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

            //sql connection checking
            String user="root";
            String password="";
            String url="jdbc:mysql://localhost:3306/Library";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Returnbook.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection cn = DriverManager.getConnection(url, user, password);
        if(cn!=null)
            System.out.print("connection to database is successful\n");
        else
            System.out.println("connection to database isn't successful\n");
            //sql connection checkig complete
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Returnbook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtbook;
    private javax.swing.JTextField txtelap;
    private javax.swing.JTextField txtfine;
    private javax.swing.JTextField txtmid;
    private javax.swing.JLabel txtmname;
    private javax.swing.JLabel txtrdate;
    // End of variables declaration//GEN-END:variables
}
