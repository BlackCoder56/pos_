
package box;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class sale_point extends javax.swing.JFrame {

    public sale_point() {
        initComponents();

        barcode_txt.requestFocus();        
        sub_total_txt.setText("0.0");
        pay_txt.setText("0");
        change_txt.setText("0.0");
    }
    
    
//     sql object declarations
    Connection conn;
    PreparedStatement pst;
    ResultSet rs;
    
    
    private void checkqyt()
    {
        int barcode_number = Integer.parseInt(barcode_txt.getText());
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
            pst = conn.prepareStatement("SELECT * FROM product WHERE barcode=?");
            pst.setInt(1, barcode_number);
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                int qty;
                qty = rs.getInt("qty");
                String productName = rs.getString("product_name");
                
                JOptionPane.showMessageDialog(this, "Available quantity = "+qty, productName+" product quantity", HEIGHT);
                
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sale_point.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(sale_point.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    
    private void pos()
    {
        float subtotal = 0;
        
        if("".equals(barcode_txt.getText()) || "".equals(qty_txt.getText())){
            JOptionPane.showMessageDialog(this, "Please enter product barcode or quantity!");
            barcode_txt.requestFocus();
        }else{
            
            int barcode_number = Integer.parseInt(barcode_txt.getText());
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
                pst = conn.prepareStatement("SELECT * FROM product WHERE barcode=?");
                pst.setInt(1, barcode_number);
                rs = pst.executeQuery();

                while(rs.next())
                {
                    int qty;
                    qty = rs.getInt("qty");
                    String productName = rs.getString("product_name");

                    int price = Integer.parseInt(price_txt.getText());
                    int unit_qty = Integer.parseInt(qty_txt.getText());

    //                Single product total
                    float product_total = price * unit_qty;

    //                Verifying unit quantity and stock quantity
                    if(unit_qty > qty){
                        JOptionPane.showMessageDialog(this,
                                productName+":\nAvailable quanatity = "+qty,
                                "Product not Enough", HEIGHT);
                    }else{
                        DefaultTableModel model = (DefaultTableModel)table_3.getModel();

                        model.addRow(new Object[]{
                           barcode_txt.getText(),
                           name_txt.getText(),
                           price_txt.getText(),
                           qty_txt.getText(),
                           product_total

                        });
    //                    subtotal


                    for(int i=0; i<table_3.getRowCount(); i++){

                         subtotal = subtotal + Float.parseFloat(table_3.getValueAt(i, 4).toString());

                    }

                    sub_total_txt.setText(String.valueOf(subtotal));

                        

                    barcode_txt.setText("");
                    name_txt.setText("");
                    price_txt.setText("");
                    qty_txt.setText("");

                    barcode_txt.requestFocus();

                    }


                }


            } catch (ClassNotFoundException ex) {
                Logger.getLogger(sale_point.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(sale_point.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
        s_p = new javax.swing.JLabel();
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
        barcode_txt = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        name_txt = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        price_txt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        qty_txt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_3 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        delete_btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        sub_total_txt = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        pay_txt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        change_txt = new javax.swing.JTextField();
        checkout_btn = new javax.swing.JButton();
        refresh_btn = new javax.swing.JButton();

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

        s_p.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        s_p.setForeground(new java.awt.Color(255, 255, 255));
        s_p.setText("Pos");
        s_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                s_pMouseClicked(evt);
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
            .addComponent(jSeparator16, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(category_net, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(s_p, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(282, Short.MAX_VALUE)
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
                .addComponent(s_p)
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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sales activity", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Bar Code");

        barcode_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        barcode_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barcode_txtKeyPressed(evt);
            }
        });

        add_btn.setText("Add");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Product");

        name_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Price");

        price_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Quantity");

        qty_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jButton1.setText("Check Qty");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(barcode_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(34, 34, 34)
                        .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(price_txt)
                    .addComponent(qty_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(barcode_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(price_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(qty_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        table_3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product Name", "Price", "Quality", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
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

        jSeparator1.setOpaque(true);

        delete_btn.setBackground(new java.awt.Color(204, 0, 0));
        delete_btn.setForeground(new java.awt.Color(255, 255, 255));
        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Invoice activity"));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Sub total");

        sub_total_txt.setEditable(false);
        sub_total_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        sub_total_txt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Pay");

        pay_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        pay_txt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        pay_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_txtActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Change");

        change_txt.setEditable(false);
        change_txt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        change_txt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        checkout_btn.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        checkout_btn.setText("Checkout");
        checkout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkout_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(change_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pay_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sub_total_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                        .addComponent(checkout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(133, 133, 133))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(sub_total_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pay_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(checkout_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(change_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        refresh_btn.setText("Refresh");
        refresh_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btnActionPerformed(evt);
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
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 981, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(94, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refresh_btn)
                        .addGap(121, 121, 121))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(refresh_btn))
                .addGap(46, 46, 46)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        pos();      
    }//GEN-LAST:event_add_btnActionPerformed

    private void table_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_3MouseClicked
       

         
         
    }//GEN-LAST:event_table_3MouseClicked

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        DefaultTableModel model = (DefaultTableModel)table_3.getModel();
        
        model.removeRow(table_3.getSelectedRow());
        float subtotal = 0;
        

        for(int i=0; i<table_3.getRowCount(); i++){            
            subtotal = subtotal + Float.parseFloat(table_3.getValueAt(i, 4).toString());
            sub_total_txt.setText(String.valueOf(subtotal));
        }

        
     
        
    }//GEN-LAST:event_delete_btnActionPerformed
// TODO add your handling code here:
    private void pay_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay_txtActionPerformed

    private void barcode_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcode_txtKeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER)
       {
           int barcode_number = Integer.parseInt(barcode_txt.getText());
           
           
           try {
               Class.forName("org.postgresql.Driver");
               conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+"pos","postgres","swap2");
               pst = conn.prepareStatement("SELECT * FROM product WHERE barcode=?");
               pst.setInt(1, barcode_number);
               rs = pst.executeQuery();
               
               if(rs.next() == false)
               {
                   JOptionPane.showMessageDialog(this, "Product with this "+barcode_number+" barcode not found!\nTry again!","Product Error!", HEIGHT);
                   barcode_txt.setText("");
                   barcode_txt.requestFocus();
               }else
               {
                    String product_name = rs.getString("product_name");
                    String price = rs.getString("retail");
                    int product_qty = rs.getInt("qty");
                    
                    if(product_qty <= 0){
                        JOptionPane.showMessageDialog(this, product_name+" is out of stock!","Out of Stock",HEIGHT);
                        barcode_txt.requestFocus();
                    }else{
                        name_txt.setText(product_name.trim());
                        price_txt.setText(price.trim());

                        qty_txt.requestFocus();
                    }
                   
                    
               }
            } catch (ClassNotFoundException ex) {            
            JOptionPane.showMessageDialog(null, ex, "Error", HEIGHT);
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Connection failed", HEIGHT);
            }
            
           
       }
    }//GEN-LAST:event_barcode_txtKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if("".equals(barcode_txt.getText())){
            JOptionPane.showMessageDialog(this, "Please enter product barcode!");
            barcode_txt.requestFocus();
        }else{
            checkqyt();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkout_btnActionPerformed
       
        
        if("0.0".equals(sub_total_txt.getText())){
            JOptionPane.showMessageDialog(this, "No product selected!");
        }else if("".equals(pay_txt.getText())){
           JOptionPane.showMessageDialog(this, "Please enter amout in pay field then checkout!");
           pay_txt.setText("");
           pay_txt.requestFocus();
       }else{
            float subtotal1 = Float.parseFloat(sub_total_txt.getText());
            float paid = Float.parseFloat(pay_txt.getText());
            float change = 0;
            
            
            if(subtotal1 > paid){
            JOptionPane.showMessageDialog(this, "Amout tendered is less than "+subtotal1);
                pay_txt.setText("");
                pay_txt.requestFocus();
            }else if(paid == 0){
                JOptionPane.showMessageDialog(this, "Please enter amout in pay field then checkout!");
                pay_txt.setText("");
                pay_txt.requestFocus();
            }else{
                change = (paid - subtotal1);
            }
       
       change_txt.setText(String.valueOf(change));
        
            
       }
      
    }//GEN-LAST:event_checkout_btnActionPerformed

    private void refresh_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btnActionPerformed
        barcode_txt.setText("");
        name_txt.setText("");
        price_txt.setText("");
        qty_txt.setText("");
        
        barcode_txt.requestFocus();
    }//GEN-LAST:event_refresh_btnActionPerformed

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

    private void s_pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_s_pMouseClicked
        
    }//GEN-LAST:event_s_pMouseClicked

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
            java.util.logging.Logger.getLogger(sale_point.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sale_point.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sale_point.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sale_point.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sale_point().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JTextField barcode_txt;
    private javax.swing.JLabel brand_net;
    private javax.swing.JLabel category_net;
    private javax.swing.JTextField change_txt;
    private javax.swing.JButton checkout_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JLabel exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField name_txt;
    private javax.swing.JTextField pay_txt;
    private javax.swing.JTextField price_txt;
    private javax.swing.JLabel product_net;
    private javax.swing.JTextField qty_txt;
    private javax.swing.JButton refresh_btn;
    private javax.swing.JLabel s_p;
    private javax.swing.JTextField sub_total_txt;
    private javax.swing.JTable table_3;
    // End of variables declaration//GEN-END:variables
}
