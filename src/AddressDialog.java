import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddressDialog extends JDialog {
//    private JTextField customerNameTF, streetTF, cityTF, stateTF, zipCodeTF;
//    private JButton saveButton;
//    private Address address;

    private Invoice invoiceModel;

    public AddressDialog(JFrame parent, Invoice inv) {
        super(parent, "Get Address", true);
        setSize(300, 250);
        setLayout(null);

        JLabel customerNameLabel = new JLabel("Customer Name:");
        JTextField customerNameTF = new JTextField(20);
        JLabel streetLabel = new JLabel("Street:");
        JTextField streetTF = new JTextField(20);
        JLabel cityLabel = new JLabel("City:");
        JTextField cityTF = new JTextField(20);
        JLabel stateLabel = new JLabel("State:");
        JTextField stateTF = new JTextField(20);
        JLabel zipCodeLabel = new JLabel("Zip Code:");
        JTextField zipCodeTF = new JTextField(20);
        JButton saveButton = new JButton("Save");

        saveButton.addActionListener(e -> {
            inv.setAddress(new Address(
                    customerNameTF.getText(),
                    streetTF.getText(),
                    cityTF.getText(),
                    stateTF.getText(),
                    zipCodeTF.getText())
            );

            dispose();
        });

        this.invoiceModel = inv;

        JPanel content = new JPanel();
        content.setBorder(new EmptyBorder(5, 15, 5, 10));

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 8));
        form.add(customerNameLabel);
        form.add(customerNameTF);
        form.add(streetLabel);
        form.add(streetTF);
        form.add(cityLabel);
        form.add(cityTF);
        form.add(stateLabel);
        form.add(stateTF);
        form.add(zipCodeLabel);
        form.add(zipCodeTF);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.add(saveButton);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
