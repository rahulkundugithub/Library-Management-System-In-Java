/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MyLibrary;

import java.sql.ResultSetMetaData;
   import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
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
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Category
     */
    public Book() {
        initComponents();
            //calling database connection constructor
            connect();
            //fetching data from category table to the category combo box
            Category();
            //fetching data from author table to the author combo box
            Author();
            //fetching data from author table to the publisher combo box
            Publisher();
            
            bookload();
    }
    
    
    //to store the data fetched from category table of sql
    public class CategoryItem
    {
        int id;
        String name;
    //to store the data-this constructor will be called in while loop inside Category()
        public CategoryItem(int id,String name)//rs.getInt() and rs.getString() will use these int id and String name as parameters
        {
        this.id=id;
        this.name=name;
        }
        
        public String toString()
        {
        return name;
        }
    }
    
    //to store the data fetched from author table of sql
    public class AuthorItem
    {
        int id;
        String name;
    //to store the data-this constructor will be called in while loop inside Author()
        public AuthorItem(int id,String name)//rs.getInt() and rs.getString() will use these int id and String name as parameters
        {
        this.id=id;
        this.name=name;
        }
        
        public String toString()
        {
        return name;
        }
    }
    
    //to store the data fetched from publisher table of sql
    public class PublisherItem
    {
        int id;
        String name;
    //to store the data-this constructor will be called in while loop inside Publisher()
        public PublisherItem(int id,String name)//rs.getInt() and rs.getString() will use these int id and String name as parameters
        {
        this.id=id;
        this.name=name;
        }
        
        public String toString()
        {
        return name;
        }
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
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        //connection to database is complete
        
        
        //fetching data from sql category table to category dropdown combo box on Book page
        public void Category()
        {
        try {
            pst=con.prepareStatement("select * from category");  //here category is the table name
            rs=pst.executeQuery();
            
            txtcategory.removeAllItems();
            //txtcategory.addItem(new CategoryItem(0,"<--Select Category-->"));
            while(rs.next())//rs.next() gives true if there are more rows in a table and false if no more rows left
            {
            txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2))); 
            //txtcategory.addItem(new CategoryItem(rs.getInt(1),rs.getString(2))); 
//here CategoryItem is the constructor name. 1 means position 1 i.e the column ID and 2 means the position 2 i.e the column CategoryName
 /*rs.getInt() and rs.getString() methods are used to get data from sql category table the these datas are passed as arguments into
    CategoryItem() method to store the data*/
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        //fetching data from sql author table to author dropdown combo box on Book page
        public void Author()
        {
        try {
            pst=con.prepareStatement("select * from author");  //here author is the table name
            rs=pst.executeQuery();
            
            txtauthor.removeAllItems();
                    //txtauthor.addItem(new AuthorItem(0,"<--Select Author-->"));
            while(rs.next())//rs.next() gives true if there are more rows in a table and false if no more rows left
            {
                
            txtauthor.addItem(new AuthorItem(rs.getInt(1),rs.getString(2))); 
//here AuthorItem is the constructor name. 1 means position 1 i.e the column ID and 2 means the position 2 i.e the column AuthorName
 /*rs.getInt() and rs.getString() methods are used to get data from sql author table the these datas are passed as arguments into
    AuthorItem() method to store the data*/
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        //fetching data from sql publisher table to author dropdown combo box on Book page
        public void Publisher()
        {
        try {
            pst=con.prepareStatement("select * from publisher");  //here publisher is the table name
            rs=pst.executeQuery();
            
            txtpublisher.removeAllItems();
                    //txtpublisher.addItem(new PublisherItem(0,"<--Select Publisher-->"));
            while(rs.next())//rs.next() gives true if there are more rows in a table and false if no more rows left
            {
                
            txtpublisher.addItem(new PublisherItem(rs.getInt(1),rs.getString(2))); 
//here PublisherItem is the constructor name. 1 means position 1 i.e the column ID and 2 means the position 2 i.e the column PublisherName
 /*rs.getInt() and rs.getString() methods are used to get data from sql publisher table the these datas are passed as arguments into
    Publisher() method to store the data*/
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
        
        
        
        
        
        
    
        //fetching data from database to JTable

    /**
     *
     */
        public void bookload()
        {
            int c;
        try {
            pst=con.prepareStatement("select b.ID,b.Book_Name,c.CategoryName,a.Author_Name,p.Publisher_Name,b.Isbn_No,b.Edition from book b,category c,author a,publisher p where b.Author=a.ID and b.Category=c.ID and b.Publisher=p.ID");//we cant say "select * from book" as in book table there are ids in places of category,author etc
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
                v2.add(rs.getString("ID"));
                v2.add(rs.getString("Book_Name")); // these will be names of the columns of database table
                v2.add(rs.getString("CategoryName"));// these will be names of the columns of the corresponding database table,not of Book Table
                v2.add(rs.getString("Author_Name"));
                v2.add(rs.getString("Publisher_Name"));
                v2.add(rs.getString("Isbn_No"));
                v2.add(rs.getString("Edition"));
                }
            d.addRow(v2);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
        txtname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtcategory = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtauthor = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtpublisher = new javax.swing.JComboBox();
        txtisbn = new javax.swing.JTextField();
        txtedition = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("Book Name");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Category :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Book Name", "Category", "Author", "Publisher", "ISBN No.", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jButton1.setMaximumSize(new java.awt.Dimension(89, 28));
        jButton1.setMinimumSize(new java.awt.Dimension(89, 28));
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
        jButton3.setMaximumSize(new java.awt.Dimension(89, 28));
        jButton3.setMinimumSize(new java.awt.Dimension(89, 28));
        jButton3.setPreferredSize(new java.awt.Dimension(89, 28));
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

        txtcategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategoryActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Author :");

        txtauthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtauthorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Publisher :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("ISBN No. :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Edition :");

        txtisbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtisbnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 326, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtisbn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(255, 255, 255))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
        
            //action of Add button-sending Book data to sql Book table
            String bname=txtname.getText();
            CategoryItem citem=(CategoryItem)txtcategory.getSelectedItem();//this is how to pick data from combobox
            
            AuthorItem aitem=(AuthorItem)txtauthor.getSelectedItem();
            PublisherItem pitem=(PublisherItem)txtpublisher.getSelectedItem();
            String isbn=txtisbn.getText();
            String edition=txtedition.getText();
//            if(citem.id==0){
//            JOptionPane.showMessageDialog(this, "Please select Category");
//            }
//            else if(aitem.id==0){
//            JOptionPane.showMessageDialog(this, "Please select Author");
//            }
//            else if(pitem.id==0){
//            JOptionPane.showMessageDialog(this, "Please select Publisher");
//            }
//            else
//            {
            
        try {
            pst = con.prepareStatement("insert into book(Book_Name,Category,Author,Publisher,Isbn_No,Edition)values(?,?,?,?,?,?)"); //1st one is table name of sql and inside bracket these are column names
            pst.setString(1, bname);
            pst.setInt(2,citem.id);//as we want to put category id on jtable
            pst.setInt(3,aitem.id);
            pst.setInt(4,pitem.id);
            pst.setString(5, isbn);
            pst.setString(6, edition);
            
            int k = pst.executeUpdate();
            if(k==1)
            {
            JOptionPane.showMessageDialog(this, "Book created successfully..");
            txtname.setText("");//to clear the text box
            txtcategory.setSelectedIndex(-1);
            txtauthor.setSelectedIndex(-1);
            txtpublisher.setSelectedIndex(-1);
            txtisbn.setText("");
            txtedition.setText("");
            txtname.requestFocus();//to bring the cursor on Author name box
            bookload();//will show the current input on jtable
            }
            else
            {
            JOptionPane.showMessageDialog(this, "Error in Book creation!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
//            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
            //if we click on any data on the jtable then it will appear on Category and Status box and we will be able to edit the dat
            
            
            DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
            int selectIndex=jTable1.getSelectedRow(); //row no of the selected data from the jtable is being fetched
            //JOptionPane.showMessageDialog(this, d1.getValueAt(selectIndex,2).toString());
            int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
            txtname.setText(d1.getValueAt(selectIndex,1).toString());
            txtcategory.setSelectedItem(d1.getValueAt(selectIndex,2).toString());
            txtauthor.setSelectedItem(d1.getValueAt(selectIndex,3).toString());
            txtpublisher.setSelectedItem(d1.getValueAt(selectIndex,4).toString());
            txtisbn.setText(d1.getValueAt(selectIndex,5).toString());
            txtedition.setText(d1.getValueAt(selectIndex,6).toString());
            
            
            jButton1.setEnabled(false);//this will inactivate the Add button when a row is being selected from from jtable
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
            //action of Update button-sending Updated Author details to sql and jtable
            
            DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
            int selectIndex=jTable1.getSelectedRow(); //row no of the selected data from the jtable is being fetched
            
            int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
            
        String name = txtname.getText();
        String category = txtcategory.getSelectedItem().toString();
        String author = txtauthor.getSelectedItem().toString();
        String publisher = txtpublisher.getSelectedItem().toString();
        String isbn=txtisbn.getText();
        String edition=txtedition.getText();
        int cid=0;
        int aid=0;
        int pid=0;
        try {
            pst=con.prepareStatement("select ID from category where CategoryName=?");
            pst.setString(1,category);
            rs=pst.executeQuery();
            while(rs.next())
            {
           cid=rs.getInt("ID");
            System.out.println(cid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst=con.prepareStatement("select ID from author where Author_Name=?");
            pst.setString(1,author);
            rs=pst.executeQuery();
            while(rs.next())
            {
          aid=rs.getInt("ID");
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            pst=con.prepareStatement("select ID from publisher where Publisher_Name=?");
            pst.setString(1,publisher);
            rs=pst.executeQuery();
            while(rs.next())
            {
            pid=rs.getInt("ID");
            System.out.println(pid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try {
            pst = con.prepareStatement("update book set Book_Name = ?, Category= ?, Author= ?, Publisher=?, Isbn_No=?, Edition=? where ID = ?"); //1st one is database table name,rest are column name
            pst.setString(1, name);
            pst.setInt(2,cid);
            pst.setInt(3,aid);
            pst.setInt(4, pid);
            pst.setString(5, isbn);
            pst.setString(6, edition);
            pst.setInt(7,id);
            int k = pst.executeUpdate();
            if(k==1)
            {
            JOptionPane.showMessageDialog(this, "Book details Updated successfully..");
            txtname.setText("");//to clear the category box
            txtisbn.setText("");//to clear the status box
            txtedition.setText("");
            txtname.requestFocus();//to bring the cursor on category box
            bookload();//load the updated data on the jtable
            jButton1.setEnabled(true);//reenable the Add button
            }
            else
            {
            JOptionPane.showMessageDialog(this, "Error in Book details Updatation!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
                //Remove button action
        DefaultTableModel d1=(DefaultTableModel)jTable1.getModel();
            int selectIndex=jTable1.getSelectedRow(); //row no of the selected data from the jtable is being fetched
            int id=Integer.parseInt(d1.getValueAt(selectIndex,0).toString());
            
        try {
            pst = con.prepareStatement("delete from book where id = ?"); //here book is database table name
            pst.setInt(1, id);
            int k = pst.executeUpdate();
            if(k==1)
            {
            JOptionPane.showMessageDialog(this, "Book details Removed successfully..");
            txtname.setText("");//to clear the name box
            txtisbn.setText("");//to clear the address box
            txtedition.setText("");//to clear the phone box
            txtname.requestFocus();//to bring the cursor on category box
            bookload();//load the updated data on the jtable
            jButton1.setEnabled(true);//reenable the Add button
            }
            else
            {
            JOptionPane.showMessageDialog(this, "Error in Book details Removal!!");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //Cancel the window
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtisbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtisbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtisbnActionPerformed

    private void txtauthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtauthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtauthorActionPerformed

    private void txtcategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategoryActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
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
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtisbn;
    private javax.swing.JTextField txtname;
    private javax.swing.JComboBox txtpublisher;
    // End of variables declaration//GEN-END:variables
}
