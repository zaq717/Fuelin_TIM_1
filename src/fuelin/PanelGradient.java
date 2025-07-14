package fuelin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import javax.swing.JPanel;

public class PanelGradient extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        // Gradasi horizontal dari KIRI ke KANAN
        GradientPaint gp = new GradientPaint(
                0, 0, Color.RED,              // Titik awal (kiri) - MERAH
                getWidth(), 0, Color.WHITE    // Titik akhir (kanan) - PUTIH
        );

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}
