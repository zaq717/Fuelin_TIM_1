package fuelin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPasswordField;
import javax.swing.border.AbstractBorder;

public class tfRoundedPassword extends JPasswordField {
    private int round = 15;

    public tfRoundedPassword() {
        setOpaque(false);
        setBorder(new RoundedBorder());
    }

    public void setRound(int round) {
        this.round = round;
        repaint();
    }

    private class RoundedBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(Color.RED);  // Border merah
            g2.drawRoundRect(x, y, width - 1, height - 1, round, round);

            g2.dispose();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), round, round);

        super.paintComponent(g);
        g2.dispose();
    }
}
