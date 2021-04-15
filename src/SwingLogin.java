
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class SwingLogin implements ActionListener, KeyListener {

    // Fenster
    private JFrame jFrame;
    private Container contentPane;

    // Komponenten
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userJTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton resetJButton;
    private JCheckBox showPasswordBox;
    private JCheckBox hidePasswordBox;

    private final String uSERNAMEString = "user123";
    private final String pASSWORDString = "123456";

    public SwingLogin() {
        initUI(); // Fenster erstellt

        createMenu(); // Menü erstellt

        createComponent(); // Komponenten erstellt

        addComponentsToContentPane(); // Komponenten hinzufügen

        setLayoutManager(); // Setze das Layout für den Container

        setLocationAndSizeOfComponent(); // Position und Größe von den Komponenten bestimmen
    }

    // Fenster (JFrame) erstellen
    private void initUI() {
        jFrame = new JFrame("Login");
        jFrame.setSize(400, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = jFrame.getContentPane();
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }

    // Menü erstellen
    private void createMenu() {
        // Menü -> JmenuBar -> Jmenu -> JMenuItem

        final JMenuBar jMenuBar = new JMenuBar();

        final JMenu fileMenu = new JMenu("File");
        final JMenu editMenu = new JMenu("Edit");
        final JMenu soruceMenu = new JMenu("Source");

        jMenuBar.add(fileMenu);
        jMenuBar.add(editMenu);
        jMenuBar.add(soruceMenu);

        final JMenuItem exitItem = new JMenuItem("Exit", new ImageIcon("images/xmark.png"));
        // exitItem.addActionListener(new ActionListener() {
        //
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // System.exit(0);
        // }
        // });

        exitItem.addActionListener(e -> {
            System.exit(0);
        });

        // Shortcut
        exitItem.setMnemonic(KeyEvent.VK_E);
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.ALT_MASK));

        fileMenu.add(exitItem);

        jFrame.setJMenuBar(jMenuBar);
    }

    // Komponenenten erstellen
    private void createComponent() {
        userLabel = new JLabel("Username: ");
        passwordLabel = new JLabel("Passwort: ");

        userJTextField = new JTextField();
        passwordField = new JPasswordField();
        passwordField.addKeyListener(this);

        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        resetJButton = new JButton("Reset");
        resetJButton.addActionListener(this);

        showPasswordBox = new JCheckBox("Passwort anzeigen");
        showPasswordBox.addActionListener(this);

        hidePasswordBox = new JCheckBox("Passwort verbergen");
    }

    // Komponenten hinzufügen
    private void addComponentsToContentPane() {
        contentPane.add(userLabel);
        contentPane.add(passwordLabel);
        contentPane.add(userJTextField);
        contentPane.add(passwordField);
        contentPane.add(hidePasswordBox);
        contentPane.add(showPasswordBox);
        contentPane.add(loginButton);
        contentPane.add(resetJButton);
    }

    // Position der Komponenten bestimmen, falls setLayout(null) ist
    private void setLocationAndSizeOfComponent() {
        userLabel.setBounds(50, 150, 100, 30); // (x-Position, y-Position, breite, höhe)
        passwordLabel.setBounds(50, 220, 100, 30);
        userJTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        // hidePasswordBox.setBounds(50, 250, 150, 30);
        showPasswordBox.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetJButton.setBounds(200, 300, 100, 30);
    }

    // Layout setzen
    private void setLayoutManager() {
        // FlowLayout flowLayout = new FlowLayout(FlowLayout.LEADING, 30, 30);
        // GridLayout gridLayout = new GridLayout(4, 2, 30, 30);

        contentPane.setLayout(null);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(() -> new SwingLogin());
    }

    // Dialog erstellen
    private void createMessage(final String message) {
        JOptionPane.showMessageDialog(jFrame, message);
    }

    // Event Handling
    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == loginButton) {
            final String userString = userJTextField.getText();
            final char[] chars = passwordField.getPassword();
            final String userPasswordString = new String(chars);

            if (uSERNAMEString.equalsIgnoreCase(userString) && pASSWORDString.equalsIgnoreCase(userPasswordString)) {
                System.out.println("Login erfolgreich");
                createMessage("Login erfolgreich");
            } else {
                System.out.println("Username oder Passwort falsch");
                createMessage("Username oder Passwort falsch");
            }
        }

        if (e.getSource() == resetJButton) {
            userJTextField.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == showPasswordBox) {
            if (showPasswordBox.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        }

    }

    @Override
    public void keyTyped(final KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        // System.out.println("Taste gedrückt");
        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
            System.out.println("Zum Login");
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        // TODO Auto-generated method stub

    }
}
