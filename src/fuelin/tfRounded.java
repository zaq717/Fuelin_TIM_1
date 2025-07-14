package fuelin;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.metal.MetalTextFieldUI;

public class tfRounded extends JTextField {
    private TextFieldUI textUI;

    public tfRounded() {
        setOpaque(false);
        textUI = new TextFieldUI(this);
        setUI(textUI);
    }

    private class TextFieldUI extends MetalTextFieldUI {
        private JTextField textfield;
        private RoundedBorder border;
        private int round = 15;
        private List<String> items = new ArrayList<>();

        public TextFieldUI(JTextField textfield) {
            this.textfield = textfield;
            this.border = new RoundedBorder(15);
            textfield.setBorder(border);
        }

        public int getRound() {
            return round;
        }

        public void setRound(int round) {
            this.round = round;
            border.setRound(round);
            textfield.repaint();
        }

        public List<String> getItems() {
            return items;
        }

        public void setItems(List<String> items) {
            this.items = items;
        }

        private class RoundedBorder extends AbstractBorder {
            private Color borderColor = Color.RED;   // Warna border MERAH
            private int round;

            public RoundedBorder(int round) {
                this.round = round;
            }

            public void setRound(int round) {
                this.round = round;
            }

            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(borderColor);
                g2.drawRoundRect(x, y, width - 1, height - 1, round, round);

                g2.dispose();
            }
        }

        @Override
        protected void paintBackground(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(textfield.getBackground());
            g2.fillRoundRect(0, 0, textfield.getWidth(), textfield.getHeight(), round, round);

            g2.dispose();
        }

        @Override
        protected void paintSafely(Graphics g) {
            paintBackground(g);
            super.paintSafely(g);
        }
    }
}
