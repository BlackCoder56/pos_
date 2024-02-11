
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

public class products extends javax.swing.JFrame {

    public products() {
        initComponents();
        load_tableData();
        brand();
        category();
        
        
        status_combox.setSelectedIndex(-1);
    }
    
    
    // sql object declarations
    Connection conn;
    PreparedStatement pst;
    
     // defined methods    
    public void clear_txt(){
        product_txt.setText("");
        description_textarea.setText("");  
        category_drop.setSelectedIndex(-1);
        brand_drop.setSelectedIndex(-1);
        price_txt.setText("");
        retail_price_txt.setText("");
        qty_txt.setText("");
        barcode_txt.setText("");
        status_combox.setSelectedIndex(-1);

        product_txt.requestFocus();
    }
    public class CategoryItem{
        int id;
        String name;
        
        public CategoryItem(int id, String name){
            this.id = id;
            this.name = name;
        }
        
        public String toString(){
            return name;
        }
        
    }
    
    public class BrandItem{
       int b_id;
       String b_name;

       public BrandItem(int b_id, String b_name){
           this.b_id = b_id;
           this.b_name = b_name;
       }

       public String toString(){
           return b_name;
       }

   }
    
    private void brand(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
            pst = conn.prepareStatement("SELECT * FROM brand");
            ResultSet rs = pst.executeQuery();
            brand_drop.removeAllItems();
            
            while(rs.next()){
                brand_drop.addItem(new BrandItem(rs.getInt(1), rs.getString(2)));
                brand_drop.setSelectedIndex(-1);
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
        }
    }
    
   
    
    private void category(){
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
            pst = conn.prepareStatement("SELECT * FROM category");
            ResultSet rs = pst.executeQuery();
            category_drop.removeAllItems();
            
            while(rs.next()){
                category_drop.addItem(new CategoryItem(rs.getInt(1), rs.getString(2)));
                category_drop.setSelectedIndex(-1);
            }
            
         } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
        }
    }
    
    private void load_tableData(){
        int c;
        
        try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
                pst = conn.prepareStatement("SELECT p.id, p.product_name, p.description, c.category, b.brand,"
                        + "p.costprice, p.retail, p.qty,p.barcode,p.status FROM product p INNER JOIN category"
                        + " c on p.category = c.id"
                        + " INNER JOIN brand b on p.brand = b.id");

                ResultSet rs = pst.executeQuery();

                ResultSetMetaData rsd = rs.getMetaData(); 
                c = rsd.getColumnCount();


                DefaultTableModel d = (DefaultTableModel)table_3.getModel();
                d.setRowCount(0);
                
           
                
                while(rs.next()){
                    Vector v2 = new Vector();
                    
                    for(int i = 1;i<=c; i++){
                        v2.add(rs.getString("id"));
                        v2.add(rs.getString("product_name"));
                        v2.add(rs.getString("description"));
                        v2.add(rs.getString("category"));
                        v2.add(rs.getString("brand"));
                        v2.add(rs.getString("costprice"));
                        v2.add(rs.getString("retail"));
                        v2.add(rs.getString("qty"));
                        v2.add(rs.getString("barcode"));
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
        category_net = new javax.swing.JLabel();
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
        product_txt = new javax.swing.JTextField();
        status_combox = new javax.swing.JComboBox<>();
        add_btn = new javax.swing.JButton();
        edit_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        description_textarea = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        category_drop = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        brand_drop = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        price_txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        retail_price_txt = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        qty_txt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        barcode_txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_3 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

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

        category_net.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        category_net.setForeground(new java.awt.Color(255, 255, 255));
        category_net.setText("Category");
        category_net.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                category_netMouseClicked(evt);
            }
        });

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
                .addComponent(category_net, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
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
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addComponent(category_net, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Product");

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Status");

        product_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

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

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Description");

        description_textarea.setColumns(20);
        description_textarea.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        description_textarea.setRows(5);
        jScrollPane2.setViewportView(description_textarea);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Category");

        category_drop.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        category_drop.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Brand");

        brand_drop.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        brand_drop.setForeground(new java.awt.Color(0, 0, 0));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Cost price");

        price_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Retail price");

        retail_price_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Quantity");

        qty_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Barcode");

        barcode_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14))
                        .addGap(402, 402, 402)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(346, 346, 346))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(480, 480, 480)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(retail_price_txt)
                                            .addComponent(qty_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(119, 119, 119)
                                                .addComponent(status_combox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addGap(103, 103, 103)
                                                .addComponent(barcode_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel15))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(price_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(product_txt)
                                .addComponent(category_drop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addComponent(brand_drop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(product_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jLabel16))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(retail_price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(36, 36, 36)
                        .addComponent(qty_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(category_drop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(brand_drop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(status_combox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(barcode_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(81, 81, 81)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(edit_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(35, 35, 35))
        );

        table_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Description", "Category", "Brand", "Cost price", "Retail price", "Qty", "Barcode", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_3MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_3);
        if (table_3.getColumnModel().getColumnCount() > 0) {
            table_3.getColumnModel().getColumn(0).setMaxWidth(40);
            table_3.getColumnModel().getColumn(7).setMaxWidth(80);
            table_3.getColumnModel().getColumn(9).setMaxWidth(110);
        }

        jSeparator1.setOpaque(true);

        jButton1.setBackground(new java.awt.Color(204, 0, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(77, 77, 77))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel8)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        if("".equals(product_txt.getText()) || "".equals(description_textarea.getText()) || "".equals(price_txt.getText()) || "".equals(retail_price_txt.getText()) || "".equals(qty_txt.getText())|| "".equals(barcode_txt.getText()) ){
            JOptionPane.showMessageDialog(null, "All fields are required!", "Required!", HEIGHT);
        }else{
            try{
                String product = product_txt.getText();
                String description = description_textarea.getText();        
                CategoryItem category_ = (CategoryItem)category_drop.getSelectedItem();
                BrandItem  brand_ = (BrandItem)brand_drop.getSelectedItem();
                String price = price_txt.getText();
                String retail = retail_price_txt.getText();
                int quantity = Integer.parseInt(qty_txt.getText());
                int barcode = Integer.parseInt(barcode_txt.getText());
                String status = status_combox.getSelectedItem().toString();

                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
                    pst = conn.prepareStatement("INSERT INTO product(product_name,description,category,brand,costprice,retail,qty,barcode, status) VALUES(?,?,?,?,?,?,?,?,?)");
                    pst.setString(1, product);
                    pst.setString(2, description);
                    pst.setInt(3, category_.id);
                    pst.setInt(4, brand_.b_id);
                    pst.setString(5, price);
                    pst.setString(6, retail);
                    pst.setInt(7, quantity);
                    pst.setInt(8, barcode);
                    pst.setString(9, status);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Producted created successfully!!");
                    load_tableData();

                    clear_txt();

                } catch (ClassNotFoundException ex) {
                    //Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
                } catch (SQLException ex) {
                   // Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
                }
        
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Only numbers are requred in some fields. \nMore information:\n\t"+ex, "Number format exception", HEIGHT);
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Must select dropdown value. \nMore information:\n\t"+ex, "Null pointer exception", HEIGHT);
            }
        }
        
    
        
    }//GEN-LAST:event_add_btnActionPerformed

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btnActionPerformed
        if("".equals(product_txt.getText()) || "".equals(description_textarea.getText()) || "".equals(price_txt.getText()) || "".equals(retail_price_txt.getText()) || "".equals(qty_txt.getText())|| "".equals(barcode_txt.getText()) ){
            JOptionPane.showMessageDialog(null, "All fields are required!", "Required!", HEIGHT);
        }else{
            try{
                DefaultTableModel ddt = (DefaultTableModel)table_3.getModel();
                int selectIndex = table_3.getSelectedRow();

                int id = Integer.parseInt(ddt.getValueAt(selectIndex, 0).toString());
                String product = product_txt.getText();
                String description = description_textarea.getText();        
                CategoryItem category_ = (CategoryItem)category_drop.getSelectedItem();
                BrandItem  brand_ = (BrandItem)brand_drop.getSelectedItem();
                String price = price_txt.getText();
                String retail = retail_price_txt.getText();
                int quantity = Integer.parseInt(qty_txt.getText());
                int barcode = Integer.parseInt(barcode_txt.getText());
                String status = status_combox.getSelectedItem().toString();

        
        
                try {
                    Class.forName("org.postgresql.Driver");
                    conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432"
                            + "/"+"pos","postgres","swap2");
                    pst = conn.prepareStatement("UPDATE product SET product_name=?,"
                            + "description=?,category=?,brand=?,costprice=?,retail=?,"
                            + "qty=?,barcode=?, status=? where id=?");
                    pst.setString(1, product);
                    pst.setString(2, description);
                    pst.setInt(3, category_.id);
                    pst.setInt(4, brand_.b_id);
                    pst.setString(5, price);
                    pst.setString(6, retail);
                    pst.setInt(7, quantity);
                    pst.setInt(8, barcode);
                    pst.setString(9, status);
                    pst.setInt(10, id);
                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Product Updated");
                    load_tableData();
                    
                    clear_txt();

                } catch (ClassNotFoundException ex) {
                    //Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
                } catch (SQLException ex) {
                   // Logger.getLogger(category.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Only numbers are requred in some fields. \nMore information:\n\t"+ex, "Number format exception", HEIGHT);
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Must select dropdown value. \nMore information:\n\t"+ex, "Null pointer exception", HEIGHT);
            }
        }
        
        
    }//GEN-LAST:event_edit_btnActionPerformed

    private void table_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_3MouseClicked
        DefaultTableModel dd = (DefaultTableModel)table_3.getModel();
        int selectIndex = table_3.getSelectedRow();
        
        
        product_txt.setText(dd.getValueAt(selectIndex, 1).toString());
        description_textarea.setText(dd.getValueAt(selectIndex, 2).toString());
        category_drop.setSelectedItem(dd.getValueAt(selectIndex, 3).toString());
        brand_drop.setSelectedItem(dd.getValueAt(selectIndex, 4).toString());
        price_txt.setText(dd.getValueAt(selectIndex, 5).toString());
        retail_price_txt.setText(dd.getValueAt(selectIndex, 6).toString());
        qty_txt.setText(dd.getValueAt(selectIndex, 7).toString());
        barcode_txt.setText(dd.getValueAt(selectIndex, 8).toString());
        status_combox.setSelectedItem(dd.getValueAt(selectIndex, 9).toString());
         
         
    }//GEN-LAST:event_table_3MouseClicked

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
         if("".equals(product_txt.getText()) || "".equals(description_textarea.getText()) || "".equals(price_txt.getText()) || "".equals(retail_price_txt.getText()) || "".equals(qty_txt.getText())|| "".equals(barcode_txt.getText()) ){
            JOptionPane.showMessageDialog(null, "All fields are required!", "Required!", HEIGHT);
        }else{
            try{
                DefaultTableModel ddt = (DefaultTableModel)table_3.getModel();
                int selectIndex = table_3.getSelectedRow();

                int id = Integer.parseInt(ddt.getValueAt(selectIndex, 0).toString());


                int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the "+product_txt.getText()+" product?", 
                        "Warning",JOptionPane.YES_NO_OPTION);


                if(dialogResult == JOptionPane.YES_OPTION){
                    try {
                        Class.forName("org.postgresql.Driver");
                        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
                        pst = conn.prepareStatement("DELETE FROM product WHERE id=?");          
                        pst.setInt(1, id);
                        pst.executeUpdate();

                        JOptionPane.showMessageDialog(null, product_txt.getText()+" product has been Deleted!");
                        load_tableData();
                        
                        clear_txt();

                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
                    }
                }
                else{
                    load_tableData();
                    clear_txt();
                }

            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Only numbers are requred in some fields. \nMore information:\n\t"+ex, "Number format exception", HEIGHT);
            }catch(NullPointerException ex){
                JOptionPane.showMessageDialog(null, "Must select dropdown value. \nMore information:\n\t"+ex, "Null pointer exception", HEIGHT);
            }
         }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        clear_txt();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void category_netMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_category_netMouseClicked
        category cat = new category();
        cat.show(true);
        this.dispose();
    }//GEN-LAST:event_category_netMouseClicked

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
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JTextField barcode_txt;
    private javax.swing.JComboBox brand_drop;
    private javax.swing.JLabel brand_net;
    private javax.swing.JComboBox category_drop;
    private javax.swing.JLabel category_net;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextArea description_textarea;
    private javax.swing.JButton edit_btn;
    private javax.swing.JLabel exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel p_s;
    private javax.swing.JTextField price_txt;
    private javax.swing.JLabel product_net;
    private javax.swing.JTextField product_txt;
    private javax.swing.JTextField qty_txt;
    private javax.swing.JTextField retail_price_txt;
    private javax.swing.JComboBox<String> status_combox;
    private javax.swing.JTable table_3;
    // End of variables declaration//GEN-END:variables
}
