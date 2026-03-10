import javax.swing.*;
import java.awt.*;

public class InvoiceGeneratorFrame extends JFrame {

    Invoice thisInvoice;
    JPanel titlePanel, invoiceDisplay, controlPanel, inputPanel;
    JLabel titleLabel, customerNameLabel, streetLabel, cityLabel, stateLabel, zipCodeLabel;
    JTextArea customerAddressTA;
    JTextArea itemsList;
    JTextField customerNameTF, streetTF, cityTF, stateTF, zipCodeTF;
    JButton lineItemsButton, showInvoiceButton;



    public InvoiceGeneratorFrame() {
        setTitle("Invoice Generator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        titlePanel = new JPanel();
        titleLabel = new JLabel("Invoice Generator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);
        createInputPanel();
        lineItemsButton = new JButton("Add Line Items");
        inputPanel.add(lineItemsButton);
        showInvoiceButton = new JButton("Show Invoice");
        inputPanel.add(showInvoiceButton);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

    private void createInputPanel() {
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        customerNameLabel = new JLabel("Customer Name:");
        customerNameTF = new JTextField();
        streetLabel = new JLabel("Street:");
        streetTF = new JTextField();
        cityLabel = new JLabel("City:");
        cityTF = new JTextField();
        stateLabel = new JLabel("State:");
        stateTF = new JTextField();
        zipCodeLabel = new JLabel("Zip Code:");
        zipCodeTF = new JTextField();

        inputPanel.add(customerNameLabel);
        inputPanel.add(customerNameTF);
        inputPanel.add(streetLabel);
        inputPanel.add(streetTF);
        inputPanel.add(cityLabel);
        inputPanel.add(cityTF);
        inputPanel.add(stateLabel);
        inputPanel.add(stateTF);
        inputPanel.add(zipCodeLabel);
        inputPanel.add(zipCodeTF);

        add(inputPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InvoiceGeneratorFrame frame = new InvoiceGeneratorFrame();
            frame.setVisible(true);
        });
    }
}
