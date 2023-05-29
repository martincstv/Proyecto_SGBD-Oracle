package sgbd.GUI;

import java.sql.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Gestor extends javax.swing.JFrame {

    private static Gestor g;
    private static Connection connection;
    Statement statement = null;
    ResultSet resultSet = null;

    public Gestor() {
        initComponents();
        // Obtener la conexión establecida en NuevaConexion
        connection = Nueva_Conexion.obtenerConexion();
        if (connection != null) {
            jTextArea_Consola.setText("Conectado...");
            CargarArbol();
        } else {
            jTree_Arbol.setModel(null);
            jTextArea_Consola.setText("Desconectado...");
        }
    }

    public static Gestor obtenerInstancia() {
        if (g == null) {
            g = new Gestor();
        }
        return g;
    }

    public void CargarArbol() {
        DefaultMutableTreeNode rootNode;
        DefaultMutableTreeNode childNode1;
        DefaultMutableTreeNode childNode2;
        DefaultMutableTreeNode childNode3;
        DefaultMutableTreeNode childNode4;
        try {
            // Obtener los metadatos de la base de datos
            DatabaseMetaData metaData = connection.getMetaData();

            // Obtener el nombre del usuario actual
            String userName = metaData.getUserName();
            rootNode = new DefaultMutableTreeNode(userName); // Nodo raíz
            childNode1 = new DefaultMutableTreeNode("Tablas"); // Primer hijo
            rootNode.add(childNode1); // Agrega childNode1 como hijo del nodo raíz
            // Obtener información adicional sobre el usuario
            ResultSet resultSet = metaData.getTables(null, userName, null, null);

            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                childNode2 = new DefaultMutableTreeNode(tableName); // Segundo hijo
                childNode1.add(childNode2); // Agrega childNode2 como hijo del nodo raíz
            }

            DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
            jTree_Arbol.setModel(treeModel);
        } catch (Exception e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar_Estado = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree_Arbol = new javax.swing.JTree();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea_Query = new javax.swing.JTextArea();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea_Consola = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton_Ejecutar = new javax.swing.JButton();
        jButton_RecargarArbol = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_Archivo = new javax.swing.JMenu();
        jMenu_BaseDatos = new javax.swing.JMenu();
        jMenuItem_NuevaConexion = new javax.swing.JMenuItem();
        jMenuItem_Desconectar = new javax.swing.JMenuItem();
        jMenu_Ayuda = new javax.swing.JMenu();
        jMenuItem_AcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Base");
        jTree_Arbol.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(jTree_Arbol);

        jTextArea_Query.setColumns(20);
        jTextArea_Query.setRows(5);
        jScrollPane2.setViewportView(jTextArea_Query);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Query", jPanel1);

        jTextArea_Consola.setEditable(false);
        jTextArea_Consola.setColumns(20);
        jTextArea_Consola.setRows(5);
        jScrollPane3.setViewportView(jTextArea_Consola);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Consola", jPanel2);

        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        jButton_Ejecutar.setText("Ejecutar");
        jButton_Ejecutar.setFocusable(false);
        jButton_Ejecutar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_Ejecutar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_Ejecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EjecutarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton_Ejecutar);

        jButton_RecargarArbol.setText("Recargar Arbol");
        jButton_RecargarArbol.setFocusable(false);
        jButton_RecargarArbol.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton_RecargarArbol.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton_RecargarArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RecargarArbolActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton_RecargarArbol);

        jMenu_Archivo.setText("Archivo");
        jMenuBar1.add(jMenu_Archivo);

        jMenu_BaseDatos.setText("Base de Datos");

        jMenuItem_NuevaConexion.setText("Nueva Conexión");
        jMenuItem_NuevaConexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_NuevaConexionActionPerformed(evt);
            }
        });
        jMenu_BaseDatos.add(jMenuItem_NuevaConexion);

        jMenuItem_Desconectar.setText("Desconectar");
        jMenuItem_Desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_DesconectarActionPerformed(evt);
            }
        });
        jMenu_BaseDatos.add(jMenuItem_Desconectar);

        jMenuBar1.add(jMenu_BaseDatos);

        jMenu_Ayuda.setText("Ayuda");

        jMenuItem_AcercaDe.setText("Acerca de");
        jMenu_Ayuda.add(jMenuItem_AcercaDe);

        jMenuBar1.add(jMenu_Ayuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar_Estado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar_Estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem_NuevaConexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_NuevaConexionActionPerformed
        Nueva_Conexion nc = new Nueva_Conexion();
        nc.setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem_NuevaConexionActionPerformed

    private void jMenuItem_DesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_DesconectarActionPerformed
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                jTree_Arbol.setModel(null);
                jTextArea_Consola.setText("Desconectado...");
            } catch (SQLException e) {
                jTextArea_Consola.setText(e.getMessage());
            }
        }
    }//GEN-LAST:event_jMenuItem_DesconectarActionPerformed

    private void jButton_EjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EjecutarActionPerformed
        if (connection != null) {
            try {
                jTextArea_Consola.setText(null);
                // Paso 3: Crear una declaración
                statement = connection.createStatement();

                // Paso 4: Ejecutar la consulta
                String query = jTextArea_Query.getText();

                // Ejecutar el comando SQL y mostrar los resultados
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    // Obtener los metadatos de las columnas
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    String consola = "";
                    // Mostrar los nombres de las columnas
                    for (int i = 1; i <= columnCount; i++) {
                        consola = consola + metaData.getColumnName(i) + "\t";
                    }
                    consola = consola + "\n";

                    // Mostrar los datos de las filas
                    while (resultSet.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            consola += resultSet.getString(i) + "\t";
                        }
                        consola = consola + "\n";
                    }

                    jTextArea_Consola.setText(consola);
                }
            } catch (SQLException e) {
                jTextArea_Consola.setText(e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton_EjecutarActionPerformed

    private void jButton_RecargarArbolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RecargarArbolActionPerformed
        try {
            jTree_Arbol.setModel(null);
            CargarArbol();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton_RecargarArbolActionPerformed

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
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gestor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gestor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Ejecutar;
    private javax.swing.JButton jButton_RecargarArbol;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem_AcercaDe;
    private javax.swing.JMenuItem jMenuItem_Desconectar;
    private javax.swing.JMenuItem jMenuItem_NuevaConexion;
    private javax.swing.JMenu jMenu_Archivo;
    private javax.swing.JMenu jMenu_Ayuda;
    private javax.swing.JMenu jMenu_BaseDatos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar_Estado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea_Consola;
    private javax.swing.JTextArea jTextArea_Query;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTree jTree_Arbol;
    // End of variables declaration//GEN-END:variables

}
