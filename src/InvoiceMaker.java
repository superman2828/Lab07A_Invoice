import javax.swing.*;
import java.awt.*;

public class InvoiceMaker {

    private static JTextArea displayTA;
    private static JScrollPane scrollPane;
    private static Invoice myInvoice;

    public static void main(String[] args) {
        myInvoice = new Invoice();
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Invoice Maker");
            frame.setFont(new Font("Arial", Font.BOLD, 12));
            frame.setSize(600, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout(25,5));
            JPanel panel = new JPanel();

            JComponent root = (JComponent) frame.getContentPane();
            root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            displayTA = new JTextArea(20,20);
            scrollPane = new JScrollPane(displayTA);
            frame.add(scrollPane, BorderLayout.CENTER);
            JButton addInvoiceButton = new JButton("Add Invoice");
            JButton quitButton = new JButton("Quit");
            quitButton.addActionListener(e -> {System.exit(0);});
            addInvoiceButton.addActionListener(e -> {
                AddressDialog addressDialog = new AddressDialog(frame, myInvoice);
                LineItemTableDialog lineItemTableDialog = new LineItemTableDialog(frame, myInvoice);
                lineItemTableDialog.setVisible(true);
                displayTA.setText(myInvoice.print());
            });

            panel.add(addInvoiceButton);
            panel.add(quitButton);
            frame.add(panel, BorderLayout.SOUTH);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

}
