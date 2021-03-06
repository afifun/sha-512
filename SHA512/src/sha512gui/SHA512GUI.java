/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sha512gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import sha512.SHA512;

/**
 *
 * @author moh.afifun.naily - 1106016802
 * @author haris.dwi - 1206239011
 */
public class SHA512GUI extends javax.swing.JFrame {

    public File plaintextFile;
    public File ciphertextFile;
    public File keyEncriptFile;
    public File keyDecryptFile;
    public String state = "";
    public SHA512 sha512 = new SHA512();

    /**
     * Creates new form SHA512StreamChipher
     */
    public SHA512GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        EncryptionPanel = new javax.swing.JPanel();
        encryptionButton = new javax.swing.JButton();
        PlaintextLabel = new javax.swing.JLabel();
        KeyEncryptLabel = new javax.swing.JLabel();
        KeyEncryptButton = new javax.swing.JButton();
        plaintextButton = new javax.swing.JButton();
        copyrightLabelEnkripsi = new javax.swing.JLabel();
        encryptionButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        textArea1 = new java.awt.TextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        encryptionButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        encryptionButton.setText("Compute");
        encryptionButton.setInheritsPopupMenu(true);
        encryptionButton.setName(""); // NOI18N
        encryptionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionButtonActionPerformed(evt);
            }
        });

        PlaintextLabel.setText("Input file to encrypt");
        PlaintextLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KeyEncryptLabel.setText("Input key file");
        KeyEncryptLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KeyEncryptButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        KeyEncryptButton.setText("Input Hash");
        KeyEncryptButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        KeyEncryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeyEncryptButtonActionPerformed(evt);
            }
        });

        plaintextButton.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        plaintextButton.setText("Input File");
        plaintextButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        plaintextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plaintextButtonActionPerformed(evt);
            }
        });

        copyrightLabelEnkripsi.setText("Developed By : Moh. Afifun Naily & Haris Dwi Prakoso");

        encryptionButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        encryptionButton1.setText("authenticate");
        encryptionButton1.setInheritsPopupMenu(true);
        encryptionButton1.setName(""); // NOI18N
        encryptionButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptionButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Output");

        javax.swing.GroupLayout EncryptionPanelLayout = new javax.swing.GroupLayout(EncryptionPanel);
        EncryptionPanel.setLayout(EncryptionPanelLayout);
        EncryptionPanelLayout.setHorizontalGroup(
            EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncryptionPanelLayout.createSequentialGroup()
                .addComponent(copyrightLabelEnkripsi)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncryptionPanelLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textArea1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addGroup(EncryptionPanelLayout.createSequentialGroup()
                            .addComponent(encryptionButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(encryptionButton1))
                        .addGroup(EncryptionPanelLayout.createSequentialGroup()
                            .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(PlaintextLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(KeyEncryptLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(plaintextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(KeyEncryptButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(77, 77, 77))
        );
        EncryptionPanelLayout.setVerticalGroup(
            EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EncryptionPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PlaintextLabel)
                    .addComponent(plaintextButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KeyEncryptLabel)
                    .addComponent(KeyEncryptButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EncryptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(encryptionButton)
                    .addComponent(encryptionButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(textArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(copyrightLabelEnkripsi))
        );

        jTabbedPane1.addTab("SHA-512 Encryption", EncryptionPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>                        

    private void encryptionButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        authenticate(plaintextFile, keyEncriptFile);
    }                                                 

    private void plaintextButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file == null) {
                JOptionPane.showMessageDialog(this, "Pastikan file yang inputkan benar", "Input Salah", JOptionPane.ERROR_MESSAGE);
            } else {
                String filename = file.getAbsolutePath();
                PlaintextLabel.setText(filename);
                this.plaintextFile = file;
            }
        }
    }                                               

    private void KeyEncryptButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        JFileChooser fc = new JFileChooser();
        int ret = fc.showOpenDialog(null);

        if (ret == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();
            String filename = file.getAbsolutePath();
            KeyEncryptLabel.setText(filename);
            this.keyEncriptFile = file;
        }
    }                                                

    private void encryptionButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        compute(plaintextFile);
    }                                                

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                SHA512GUI window = new SHA512GUI();
                window.setTitle("SHA512 Application");
                window.setVisible(true);
            }
        });
    }

    public String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") > 0) {
            return fileName.substring(fileName.lastIndexOf("."));
        } else {
            return "";
        }
    }

    public void compute(File file) {
        String inDir = file.getAbsolutePath();
        String outDir = inDir.substring(0, inDir.lastIndexOf(File.separator)) + File.separator + "r_" + file.getName();
        doSHA512(file, null, outDir, 0);
    }

    public void authenticate(File file, File key) {
        String inDir = file.getAbsolutePath();
        String outDir = inDir.substring(0, inDir.lastIndexOf(File.separator)) + File.separator + "D_" + file.getName();
        doSHA512(file, key, outDir, 1);
    }

    public String digest(String hexInput) {

        String output = "";
        textArea1.setText("Padding input... \n");
        int[] bits = sha512.generateBitsWithPadding(hexInput);
        textArea1.append("cut input int N*1024... \n");
        int[][] blockMessages = sha512.cutToN(bits);
        jLabel1.setText("Output ( Processing " + blockMessages.length + " Block Messages )");
        int[][] iv = new int[8][64];
        textArea1.append("convert iv to bits... \n");
        for (int i = 0; i < sha512.H.length; i++) {
            iv[i] = sha512.convertToBits(sha512.H[i]);
        }
        textArea1.append("start digest... \n");
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < blockMessages.length; i++) {
            int[][] temp2 = sha512.generateW(blockMessages[i]);
            long startTime1 = System.currentTimeMillis();
            int[][] hasil = sha512.processSingleBlock(temp2, iv);
            long stopTime1 = System.currentTimeMillis();
            long elapsedTime1 = stopTime1 - startTime1;
            textArea1.append("Block Message " + (i + 1) + " Done! in " + elapsedTime1 + " milisenconds\n");
            for (int j = 0; j < hasil.length; j++) {
                iv[j] = sha512.sum(hasil[j], iv[j]);
            }
        }
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        textArea1.append("Total time : " + elapsedTime / 1000.0 + " second(s)\n");
        output = sha512.convertBitsToHex(iv);
        return output;
    }

    public void doSHA512(final File docInput, final File hashInput, final String resultPath, int status) {
        // TODO add your handling code here:
        try {

            if (status == 0) {

                if (docInput == null) {
                    JOptionPane.showMessageDialog(this, "Input file kosong", "Input belum lengkap", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                new SwingWorker() {

                    @Override
                    protected Object doInBackground() throws Exception {
                        //membaca file
                        Path pathFile = Paths.get(docInput.getAbsolutePath());
                        byte[] bytesFile = Files.readAllBytes(pathFile);

                        SHA512 shaObj = new SHA512();
                        String hexFile = shaObj.convertBytestoHexa(bytesFile);
                        String result = digest(hexFile);

                        System.out.println(result);

                        FileWriter fw = new FileWriter(resultPath);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write(result);
                        bw.close();
                        textArea1.append("Finish... \nResult saved in :\n" + resultPath);
                        return null;
                    }

                }.execute();

//                JOptionPane.showMessageDialog(this, "Enkripsi telah selesai", "Finish", JOptionPane.INFORMATION_MESSAGE);
            } else {

                if (docInput == null) {
                    JOptionPane.showMessageDialog(this, "Input file kosong", "Input belum lengkap", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (hashInput == null) {
                    JOptionPane.showMessageDialog(this, "Input file hash kosong", "Input belum lengkap", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                new SwingWorker() {

                    @Override
                    protected Object doInBackground() throws Exception {
                        //membaca file
                        Path pathFile = Paths.get(docInput.getAbsolutePath());
                        byte[] bytesFile = Files.readAllBytes(pathFile);

                        //membaca file hash
                        Path pathHashFile = Paths.get(hashInput.getAbsolutePath());
                        FileReader file = new FileReader(pathHashFile.toString());
                        BufferedReader br = new BufferedReader(file);
                        String hashFileContent = br.readLine();
                        byte[] bytesHashFile = Files.readAllBytes(pathHashFile);

                        System.out.println(pathHashFile.toString());
                        SHA512 shaObj = new SHA512();
                        String hexFile = shaObj.convertBytestoHexa(bytesFile);
                        String result = shaObj.digest(hexFile);

                        System.out.println("hashFile : " + hashFileContent);
                        System.out.println("hexFile : " + result);

                        if (hashFileContent.equals(result)) {
//                    JOptionPane.showMessageDialog(this, "Otentikasi berhasil", "Finish", JOptionPane.INFORMATION_MESSAGE);

                            textArea1.setText("Authentication File, Success ...");
                        } else {
//                    JOptionPane.showMessageDialog(this, "Otentikasi gagal", "Finish", JOptionPane.INFORMATION_MESSAGE);
                            textArea1.setText("Authentication File,  Failed ...");
                        }
                        return null;
                    }

                }.execute();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify                     
    private javax.swing.JPanel EncryptionPanel;
    private javax.swing.JButton KeyEncryptButton;
    private javax.swing.JLabel KeyEncryptLabel;
    private javax.swing.JLabel PlaintextLabel;
    private javax.swing.JLabel copyrightLabelEnkripsi;
    private javax.swing.JButton encryptionButton;
    private javax.swing.JButton encryptionButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton plaintextButton;
    private java.awt.TextArea textArea1;
    // End of variables declaration                   

    private int[] genarate64BitKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
