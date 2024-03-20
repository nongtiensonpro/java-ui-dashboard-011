package utilities;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Nong_Tien_Son
 */
public class MsgBox {

    public static void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Phần mềm bán hàng Yellow Cat", JOptionPane.INFORMATION_MESSAGE);
    }

    public static boolean confirm(Component perent, String mess) {
        int result = JOptionPane.showConfirmDialog(perent, mess, "Phần mềm bán hàng Yellow Cat", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public static String promt(Component parent, String mess) {
        return JOptionPane.showInputDialog(parent, mess, "Phần mềm bán hàng Yellow Cat", JOptionPane.INFORMATION_MESSAGE);
    }
}
