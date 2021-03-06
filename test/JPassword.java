
import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;

public class JPassword {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        final JPasswordField field = new JPasswordField();

        field.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {

                char c = 0;
                field.setEchoChar(c);
                field.setText("Enter PW");

            }

            @Override
            public void focusGained(FocusEvent arg0) {

                char c = '*';
                field.setEchoChar(c);
                field.setText("");
            }
        });

        char c = 0;
        field.setText("Enter PW");
        field.setEchoChar(c);

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(new JButton("test"));
        frame.getContentPane().add(field);
        frame.pack();
        frame.setVisible(true);
    }
}