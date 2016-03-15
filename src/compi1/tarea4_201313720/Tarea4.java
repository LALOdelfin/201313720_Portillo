
package compi1.tarea4_201313720;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jose
 */
public class Tarea4 extends javax.swing.JFrame implements Runnable {

    
    public static String nombreArchivo="";
    
    public static final int PUERTO = 5000;
    public static final int PUERTO2 = 6001;
    public static final String HOST2 ="localhost";
    
    public ServerSocket server;
    public Socket sock;
    public Socket sockenvia;
    public DataInputStream flujoEntrada;
    public DataOutputStream flujoSalidaser;   

    
    public Tarea4() {
        
        Thread hiloserver = new Thread(this);
        hiloserver.start();
        
        initComponents();
        
        //txt_Ayuda.setVisible(false);
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_reciboServer = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Menu_AbrirArchivo = new javax.swing.JMenuItem();
        Menu_Salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Menu_EjecutaeAcciones = new javax.swing.JMenuItem();
        Menu_LimpiarConsolas = new javax.swing.JMenuItem();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SERVIDOR");

        txt_reciboServer.setColumns(20);
        txt_reciboServer.setRows(5);
        jScrollPane1.setViewportView(txt_reciboServer);

        jLabel3.setText("Input");

        jMenu1.setText("Archivo");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Menu_AbrirArchivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        Menu_AbrirArchivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Menu_AbrirArchivo.setText("Abrir archivo");
        Menu_AbrirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_AbrirArchivoActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_AbrirArchivo);

        Menu_Salir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        Menu_Salir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Menu_Salir.setText("Salir");
        Menu_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_SalirActionPerformed(evt);
            }
        });
        jMenu1.add(Menu_Salir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Acciones");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Menu_EjecutaeAcciones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Menu_EjecutaeAcciones.setText("Ejecutar Acciones");
        Menu_EjecutaeAcciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_EjecutaeAccionesActionPerformed(evt);
            }
        });
        jMenu2.add(Menu_EjecutaeAcciones);

        Menu_LimpiarConsolas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Menu_LimpiarConsolas.setText("Limpiar Consolas");
        Menu_LimpiarConsolas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Menu_LimpiarConsolasActionPerformed(evt);
            }
        });
        jMenu2.add(Menu_LimpiarConsolas);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Menu_LimpiarConsolasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_LimpiarConsolasActionPerformed

        
        txt_reciboServer.setText("");
    }//GEN-LAST:event_Menu_LimpiarConsolasActionPerformed

    private void Menu_EjecutaeAccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_EjecutaeAccionesActionPerformed

        
       
        
        if(txt_reciboServer.getText().length()!=0 || !txt_reciboServer.getText().equals(""))
        {
            Compilador c = new Compilador();
            c.analizar(txt_reciboServer.getText());
        }
         else{
            JOptionPane.showMessageDialog(null,"No hay un archivo que analizar","Archivo vacio",JOptionPane.WARNING_MESSAGE);
        }
        
        txt_reciboServer.setText("");
        
    }//GEN-LAST:event_Menu_EjecutaeAccionesActionPerformed

    public void ReporteErrores(String rerrores)
    {
        try{
            File objerrores = new File(rerrores);
            Desktop.getDesktop().open(objerrores);
        }catch(IOException e){
        
            System.out.println("Error....."+e.getMessage());
        }
    }
    
    public void ArchivoUsuario(String rerrores)
    {
        try{
            File objerrores = new File(rerrores);
            Desktop.getDesktop().open(objerrores);
        }catch(IOException e){
        
            System.out.println("Error....."+e.getMessage());
        }
    }
    
    private void Menu_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_SalirActionPerformed

        System.exit(0);
    }//GEN-LAST:event_Menu_SalirActionPerformed

    private void Menu_AbrirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Menu_AbrirArchivoActionPerformed

        JFileChooser filechooserabrir = new JFileChooser();
        filechooserabrir.setFileSelectionMode( JFileChooser.FILES_ONLY );
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de lenguaje Proyecto1 (*.SL)", "SL");
        filechooserabrir.setFileFilter(filtro);
        int seleccion = filechooserabrir.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION )
        {       
            try {
                BufferedReader bufferreader;
                File file = filechooserabrir.getSelectedFile();
                bufferreader = new BufferedReader(new FileReader(file.getAbsolutePath()));  
                String linea, contenido= "";
                //leeendo linea a linea
                while ((linea = bufferreader.readLine())!=null)
                {
                    contenido += linea +"\n";
                }
                
                
                //Agregando texto al editor
                txt_reciboServer.setText(contenido);
                
                bufferreader.close();
            } 
            catch (IOException ex) 
            {Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);}
        }
    }//GEN-LAST:event_Menu_AbrirArchivoActionPerformed

    
    
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tarea4().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Menu_AbrirArchivo;
    private javax.swing.JMenuItem Menu_EjecutaeAcciones;
    private javax.swing.JMenuItem Menu_LimpiarConsolas;
    private javax.swing.JMenuItem Menu_Salir;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JTextArea txt_reciboServer;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
   
       String recibirmensaje="";
       
        try{
            server = new ServerSocket(PUERTO);                      
            //flujoSalida = new DataOutputStream(sock.getOutputStream());
            while(true)
            {
                
                sock = server.accept();
                flujoEntrada = new DataInputStream(sock.getInputStream());
                                
                recibirmensaje = flujoEntrada.readUTF();
                txt_reciboServer.append(recibirmensaje+"\n");
                              
                //txt_reciboServer.setText(txt_reciboServer.getText().trim()+"\n"+enviarmensaje);
                sock.close();
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        } 
        try{
            //sock.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
}
