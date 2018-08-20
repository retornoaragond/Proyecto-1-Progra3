/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mrcproject.vista;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.abs;
import mrcproject.model.Actividad;
import mrcproject.model.Proyecto;

/**
 *
 * @author Estudiante
 */
public class VentanaMRC extends javax.swing.JFrame {

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Proyecto model;
    int R = 20;
    int D = 40;

    public void setModel(Proyecto p) {
        this.model = p;
    }

    /**
     * Creates new form VentanaMRC
     */
    public VentanaMRC() {
        initComponents();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Actividad a : model.getActividades().values()) {
            if (a.getHolgura() == 0) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.black);
            }
            g.drawOval(a.getX() - R, a.getY() - R, D, D);
            g.drawString(a.getName() + "(" + a.getDtime() + ")",
                    a.getX() - R + 5, a.getY() + 5);
        }
        for (Actividad a : model.getActividades().values()) {
            for (Actividad act : a.getSalidas()) {
                if (!("n_f".equals(act.getName()))) {
                    if (a.getHolgura() == 0 && act.getHolgura() == 0) {
                        g.setColor(Color.red);
                    } else {
                        g.setColor(Color.black);
                    }
                    relaciones(a, act, g);
                }
            }
        }
    }

    public void relaciones(Actividad a, Actividad b, Graphics g) {
        int BX = a.getX() - b.getX();
        int BY = a.getY() - b.getY();
        int BH = (int) Math.sqrt(Math.pow(abs(BX), 2) + Math.pow(abs(BY), 2));
        int abx = R * abs(BX) / BH;
        int aby = R * abs(BY) / BH;
        int c=3;
        if (BY < 0) {
            if (BX < 0) {
                g.drawLine(a.getX() + abx, a.getY() + aby, b.getX() - abx, b.getY() - aby);
                g.fillOval(b.getX() - abx - c, b.getY() - aby - c, 6, 6);
            } else {
                g.drawLine(a.getX() - abx, a.getY() + aby, b.getX() + abx, b.getY() - aby);
                g.fillOval(b.getX() + abx - c, b.getY() - aby - c, 6, 6);
            }
        } else {
            if (BX < 0) {
                g.drawLine(a.getX() + abx, a.getY() - aby, b.getX() - abx, b.getY() + aby);
                g.fillOval(b.getX() - abx - c, b.getY() + aby - c, 6, 6);
            } else {
                g.drawLine(a.getX() - abx, a.getY() - aby, b.getX() + abx, b.getY() + aby);
                g.fillOval(b.getX() + abx - c, b.getY() + aby - c, 6, 6);
            }
        }
    }

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
            java.util.logging.Logger.getLogger(VentanaMRC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaMRC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaMRC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaMRC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaMRC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
