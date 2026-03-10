import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddressDialog extends JDialog {

    private Invoice invoiceModel;

    public AddressDialog(JFrame parent, Invoice inv) {
        super(parent, "Get Address", true);
        setSize(300, 250);
        setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTF = new JTextField(20);
        JLabel streetLabel = new JLabel("Street:");
        JTextField streetTF = new JTextField(20);
        JLabel cityLabel = new JLabel("City:");
        JTextField cityTF = new JTextField(20);
        JLabel stateLabel = new JLabel("State:");
        JTextField stateTF = new JTextField(20);
        JLabel zipCodeLabel = new JLabel("Zip Code:");
        JTextField zipCodeTF = new JTextField(20);
        JButton doneButton = new JButton("Done");

        doneButton.addActionListener(e -> {
            inv.setAddress(new Address(
                    nameTF.getText(),
                    streetTF.getText(),
                    cityTF.getText(),
                    stateTF.getText(),
                    zipCodeTF.getText())
            );

            dispose();
        });

        this.invoiceModel = inv;

        JPanel content = new JPanel(new BorderLayout());
        content.setBorder(new EmptyBorder(5, 15, 5, 10));

        JPanel form = new JPanel(new GridLayout(5, 2, 10, 8));
        form.add(nameLabel);
        form.add(nameTF);
        form.add(streetLabel);
        form.add(streetTF);
        form.add(cityLabel);
        form.add(cityTF);
        form.add(stateLabel);
        form.add(stateTF);
        form.add(zipCodeLabel);
        form.add(zipCodeTF);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        buttonPanel.add(doneButton);

        content.add(form, BorderLayout.NORTH);
        content.add(buttonPanel, BorderLayout.SOUTH);
        setContentPane(content);

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
