
package org.libreoffice.zoho.ui;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import org.libreoffice.zoho.config.Configuration;
import org.libreoffice.zoho.handler.Document;
import org.libreoffice.zoho.handler.Downloader;
import org.libreoffice.zoho.handler.LocalStorage;
import org.libreoffice.zoho.ui.models.LocalDocTableModel;

/**
 *
 * @author amila
 */
public class LocalDocuments extends javax.swing.JFrame {

    Downloader downloader;
    
    /** Creates new form LocalDocuments */
    public LocalDocuments(Downloader downloader) {

        try {
            UIManager.setLookAndFeel(Configuration.getInstance().getLookAndFeel());
        } catch (Exception e) {}
        
        this.downloader = downloader;
        loadImages();
        initComponents();

        documentsTable.getColumnModel().getColumn(1).setPreferredWidth(20);
        documentsTable.getColumnModel().getColumn(0).setPreferredWidth(150);
        documentsTable.getColumnModel().getColumn(3).setPreferredWidth(120);
        
    }

    private void loadImages() {
        ImageIcon zohoIcon = new ImageIcon(getClass().getResource("/org/libreoffice/zoho/Resources/zoho_logo.png"));
        Image img = zohoIcon.getImage();
        zohoLogo = img.getScaledInstance(100, 33, java.awt.Image.SCALE_REPLICATE);
        this.setIconImage(new ImageIcon(getClass().getResource("/org/libreoffice/zoho/Resources/zoho_icon.png")).getImage());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        documentsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        openBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        documentsTable.setModel(new LocalDocTableModel());
        jScrollPane1.setViewportView(documentsTable);

        jLabel1.setIcon(new ImageIcon(zohoLogo));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18));
        jLabel2.setText("Local Documents");

        openBtn.setText("Open");
        openBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openBtn)
                        .addGap(18, 18, 18)
                        .addComponent(cancelBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cancelBtn)
                    .addComponent(openBtn))
                .addContainerGap())
        );

        pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Dimension dialogSize = getSize();
        setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBtnActionPerformed
        Document doc = LocalStorage.getInstance().getDocument(getSelectedDocumentID());
        LocalStorage.getInstance().setCurrentDoc(doc);
        downloader.openDownloadedDoc(doc.getLocalPath());
        this.dispose();
    }//GEN-LAST:event_openBtnActionPerformed

    public String getSelectedDocumentID(){
        int row = documentsTable.getSelectedRow();
        return documentsTable.getModel().getValueAt(row, 4).toString();
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTable documentsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton openBtn;
    // End of variables declaration//GEN-END:variables
    private Image zohoLogo;
}