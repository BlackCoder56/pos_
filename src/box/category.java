
package box;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class category extends javax.swing.JFrame {

    public category() {
        initComponents();
        load_tableData();
        status_combox.setSelectedIndex(-1);
    }
    
    
    // sql object declarations
    Connection conn;
    PreparedStatement pst;
    
    
    
    // defined methods    
    private void load_tableData(){
        int c;
        
        try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
                pst = conn.prepareStatement("SELECT * FROM category");

                ResultSet rs = pst.executeQuery();

                ResultSetMetaData rsd = rs.getMetaData();
                c = rsd.getColumnCount();


                DefaultTableModel d = (DefaultTableModel)table_1.getModel();
                d.setRowCount(0);

                while(rs.next()){
                    Vector v2 = new Vector();

                    for(int i = 1;i<=c; i++){
                        v2.add(rs.getString("id"));
                        v2.add(rs.getString("category"));
                        v2.add(rs.getString("status"));
                    }

                    d.addRow(v2);

                }

        } catch (ClassNotFoundException ex) {            
            JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
        }
        
        
        
    }
    
  
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator5 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        brand_net = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        p_s = new javax.swing.JLabel();
        product_net = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cat_txt = new javax.swing.JTextField();
        status_combox = new javax.swing.JComboBox<>();
        add_btn = new javax.swing.JButton();
        edit_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));

        brand_net.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        brand_net.setForeground(new java.awt.Color(255, 255, 255));
        brand_net.setText("Brand");
        brand_net.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                brand_netMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category");

        p_s.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        p_s.setForeground(new java.awt.Color(255, 255, 255));
        p_s.setText("Pos");
        p_s.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_sMouseClicked(evt);
            }
        });

        product_net.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        product_net.setForeground(new java.awt.Color(255, 255, 255));
        product_net.setText("Product");
        product_net.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                product_netMouseClicked(evt);
            }
        });

        exit.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        exit.setForeground(new java.awt.Color(255, 255, 255));
        exit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        exit.setText("Exit");
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Chasier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addComponent(jSeparator16, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator15, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jSeparator14, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jSeparator13, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jSeparator12, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(jSeparator11, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(brand_net, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(product_net, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(p_s, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(brand_net)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(product_net)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(p_s)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator14, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator15, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jSeparator16, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Point of Sale");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Category");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Status");

        cat_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        status_combox.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        status_combox.setForeground(new java.awt.Color(0, 0, 0));
        status_combox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactivated" }));

        add_btn.setText("Add");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        edit_btn.setText("Edit");
        edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_btnActionPerformed(evt);
            }
        });

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(add_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cat_txt)
                            .addComponent(status_combox, 0, 190, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(edit_btn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(delete_btn)
                        .addGap(38, 38, 38))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cat_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(status_combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        table_1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Category", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_1);

        jSeparator1.setOpaque(true);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel8)
                        .addGap(0, 417, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(95, 95, 95)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator7, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                                    .addComponent(jSeparator8, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator6))))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel8)
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator4)
                                    .addComponent(jSeparator2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        String category_name = cat_txt.getText();
        String status = status_combox.getSelectedItem().toString();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
            pst = conn.prepareStatement("INSERT INTO category(category, status) VALUES(?,?)");
            pst.setString(1, category_name);
            pst.setString(2, status);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Category added");
            load_tableData();
            cat_txt.setText("");
            status_combox.setSelectedIndex(-1);

            cat_txt.requestFocus();

        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
        } catch (SQLException ex) {
           // Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
        }
            
      
        
        
        
        
        
        
    }//GEN-LAST:event_add_btnActionPerformed

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btnActionPerformed
        DefaultTableModel ddt = (DefaultTableModel)table_1.getModel();
        int selectIndex = table_1.getSelectedRow();
        
        int id = Integer.parseInt(ddt.getValueAt(selectIndex, 0).toString());
        String category_name = cat_txt.getText();
        String status = status_combox.getSelectedItem().toString();
        
        
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
            pst = conn.prepareStatement("UPDATE category SET category=?, status=? where id=?");
            pst.setString(1, category_name);
            pst.setString(2, status);
            pst.setInt(3, id);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Category Updated");
            load_tableData();
            cat_txt.setText("");
            status_combox.setSelectedIndex(-1);

            cat_txt.requestFocus();

        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
        } catch (SQLException ex) {
           // Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
        }
        
        
        
    }//GEN-LAST:event_edit_btnActionPerformed

    private void table_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_1MouseClicked
         DefaultTableModel dd = (DefaultTableModel)table_1.getModel();
         int selectIndex = table_1.getSelectedRow();
         
         cat_txt.setText(dd.getValueAt(selectIndex, 1).toString());
         status_combox.setSelectedItem(dd.getValueAt(selectIndex, 2).toString());
         
         
    }//GEN-LAST:event_table_1MouseClicked

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        DefaultTableModel ddt = (DefaultTableModel)table_1.getModel();
        int selectIndex = table_1.getSelectedRow();
        
        int id = Integer.parseInt(ddt.getValueAt(selectIndex, 0).toString());
//        String category_name = cat_txt.getText();
//        String status = status_combox.getSelectedItem().toString();
        
        int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the "+cat_txt.getText()+" category?", "Warning",JOptionPane.YES_NO_OPTION);
        
        
        if(dialogResult == JOptionPane.YES_OPTION){
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
                pst = conn.prepareStatement("DELETE FROM category WHERE id=?");          
                pst.setInt(1, id);
                pst.executeUpdate();

                JOptionPane.showMessageDialog(null, "Category Deleted!");
                load_tableData();
                cat_txt.setText("");
                status_combox.setSelectedIndex(-1);

                cat_txt.requestFocus();

            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
            } catch (SQLException ex) {
               // Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
            }
        }
        else{
            load_tableData();
            cat_txt.setText("");
            status_combox.setSelectedIndex(-1);
        }
        
        
    }//GEN-LAST:event_delete_btnActionPerformed

    private void brand_netMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_brand_netMouseClicked
        brand bra = new brand();
        bra.show(true);
        this.dispose();
    }//GEN-LAST:event_brand_netMouseClicked

    private void product_netMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_product_netMouseClicked
        products prod = new products();
        prod.show(true);
        this.dispose();
    }//GEN-LAST:event_product_netMouseClicked

    private void p_sMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_sMouseClicked
        sale_point s_p = new sale_point();
        s_p.show(true);
        this.dispose();
    }//GEN-LAST:event_p_sMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        this.dispose();
    }//GEN-LAST:event_exitMouseClicked

 
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
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JLabel brand_net;
    private javax.swing.JTextField cat_txt;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton edit_btn;
    private javax.swing.JLabel exit;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel p_s;
    private javax.swing.JLabel product_net;
    private javax.swing.JComboBox<String> status_combox;
    private javax.swing.JTable table_1;
    // End of variables declaration//GEN-END:variables
}
