import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LineItemTableDialog extends JDialog {
    private JTable table;
    private DefaultTableModel model;
    private Invoice invoiceModel;

    public LineItemTableDialog(JFrame parent, Invoice inv) {
        super(parent, "Bulk Item Entry", true);
        setSize(400, 400);
        this.invoiceModel = inv;

        String[] headers = {"Product Name", "Price", "Quantity"};
        model = new DefaultTableModel(headers, 0);
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JButton rowButton = new JButton("Add Row");
        rowButton.addActionListener(e -> model.addRow(new Object[]{"", 0.0, 0}));
        JButton removeButton = new JButton("Remove Selected");
        removeButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                model.removeRow(selectedRow);
            }
        });
        controlPanel.add(rowButton);
        controlPanel.add(removeButton);

        JButton saveButton = new JButton("Commit all to Invoice");
        saveButton.addActionListener(e -> {
            commitTableToInvoice();
            dispose();
        });
        add(controlPanel, BorderLayout.NORTH);
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
                LineItem lineItem = new LineItem(new Product(productName, price), quantity);
                invoiceModel.addItem(lineItem);
            }
        }
    }
}
