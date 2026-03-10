import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LineItemTableDialog extends JDialog {
    private JTable table;
    private DefaultTableModel model;
    private Invoice invoiceModel;

    public LineItemTableDialog(JFrame parent, Invoice inv) {
        super(parent, "Add Line Items", true);
        setSize(400, 300);
        setLayout(new BorderLayout());

        this.invoiceModel = inv;

        String[] headers = {"Product Name", "Price", "Quantity"};
        model = new DefaultTableModel(headers, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton rowButton = new JButton("Add Row");
        rowButton.addActionListener(e -> model.addRow(new Object[]{"", 0.0, 0}));
        controlPanel.add(rowButton);
        JButton removeButton = new JButton("Remove Row");
        removeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            }
        });
        controlPanel.add(removeButton);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> {
            commitTableToInvoice();
            dispose();
        });
        add(saveButton, BorderLayout.SOUTH);
        setLocationRelativeTo(parent);
    }

    private void commitTableToInvoice() {
        if(table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }

        for(int i = 0; i < model.getRowCount(); i++) {
            String productName = model.getValueAt(i, 0).toString();
            double price = Double.parseDouble(model.getValueAt(i, 1).toString());
            int quantity = Integer.parseInt(model.getValueAt(i, 2).toString());

            if(!productName.isEmpty()) {
                Product product = new Product(productName, price);
                LineItem lineItem = new LineItem(product, quantity);
                invoiceModel.addItem(lineItem);
            }
        }
    }
}
