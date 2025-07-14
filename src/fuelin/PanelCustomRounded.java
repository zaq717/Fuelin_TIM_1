package fuelin;

import java.awt.*;
import javax.swing.*;

public class PanelCustomRounded extends JPanel {

    /* ================== PARAMETER ================== */
    private final int   radius;        // jari-jari sudut
    private final Color leftColor;     // warna sisi kiri gradasi
    private final Color rightColor;    // warna sisi kanan gradasi
    private final Color borderColor;   // null = tanpa border
    private final int   borderSize;    // ketebalan border (px)

    /* ========== KONSTRUKTOR ========== */

    /** Gradasi coral-pink (#FF7575 ➜ #FFACAC), radius 20 px, tanpa border */
    public PanelCustomRounded() {
        this(10,
             new Color(255, 117, 117),   // kiri  (#FF7575)
             new Color(255, 172, 172),   // kanan (#FFACAC)
             null,                       // tanpa border
             0);
    }

    /** Gunakan ini kalau mau gradasi atau border berbeda */
    public PanelCustomRounded(int radius,
                              Color leftColor,
                              Color rightColor,
                              Color borderColor,
                              int borderSize) {
        this.radius      = radius;
        this.leftColor   = leftColor;
        this.rightColor  = rightColor;
        this.borderColor = borderColor;
        this.borderSize  = borderSize;
        setOpaque(false);               // biar sudut transparan
    }

    /* ========== RENDERING ========== */

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        int w   = getWidth();
        int h   = getHeight();
        int arc = radius * 2;

        // ===== Latar gradasi =====
        GradientPaint gp = new GradientPaint(0, 0, leftColor, w, 0, rightColor);
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, w, h, arc, arc);

        // ===== Border (opsional) =====
        if (borderColor != null && borderSize > 0) {
            g2.setColor(borderColor);
            g2.setStroke(new BasicStroke(borderSize));
            int off = borderSize / 2;
            g2.drawRoundRect(off, off,
                             w - borderSize,
                             h - borderSize,
                             arc, arc);
        }
        g2.dispose();
        super.paintComponent(g);
    }
}
