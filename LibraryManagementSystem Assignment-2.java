import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class LibraryManagementSystem extends JFrame implements ActionListener {

    JLabel l1, l2, l3;
    JTextField t1, t2, t3;

    JButton addBtn, updateBtn, deleteBtn, clearBtn;

    JTable table;
    DefaultTableModel model;

    int selectedRow = -1;

    LibraryManagementSystem() {

        setTitle("Library Management System");
        setSize(700, 500);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Book ID");
        l1.setBounds(50, 30, 100, 30);
        add(l1);

        l2 = new JLabel("Book Name");
        l2.setBounds(50, 70, 100, 30);
        add(l2);

        l3 = new JLabel("Author");
        l3.setBounds(50, 110, 100, 30);
        add(l3);

        t1 = new JTextField();
        t1.setBounds(160, 30, 150, 30);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(160, 70, 150, 30);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(160, 110, 150, 30);
        add(t3);

        addBtn = new JButton("Add");
        addBtn.setBounds(350, 30, 100, 30);
        add(addBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(350, 70, 100, 30);
        add(updateBtn);

        deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(350, 110, 100, 30);
        add(deleteBtn);

        clearBtn = new JButton("Clear");
        clearBtn.setBounds(350, 150, 100, 30);
        add(clearBtn);

        model = new DefaultTableModel();

        model.addColumn("Book ID");
        model.addColumn("Book Name");
        model.addColumn("Author");

        table = new JTable(model);

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50, 220, 550, 200);
        add(sp);

        addBtn.addActionListener(this);
        updateBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
        clearBtn.addActionListener(this);

        table.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent e) {

                selectedRow = table.getSelectedRow();

                t1.setText(model.getValueAt(selectedRow, 0).toString());
                t2.setText(model.getValueAt(selectedRow, 1).toString());
                t3.setText(model.getValueAt(selectedRow, 2).toString());
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String id = t1.getText();
        String name = t2.getText();
        String author = t3.getText();

        if (e.getSource() == addBtn) {

            model.addRow(new Object[]{id, name, author});
        }

        if (e.getSource() == updateBtn) {

            if (selectedRow >= 0) {

                model.setValueAt(id, selectedRow, 0);
                model.setValueAt(name, selectedRow, 1);
                model.setValueAt(author, selectedRow, 2);
            }
        }

        if (e.getSource() == deleteBtn) {

            if (selectedRow >= 0) {

                model.removeRow(selectedRow);
            }
        }

        if (e.getSource() == clearBtn) {

            t1.setText("");
            t2.setText("");
            t3.setText("");
        }
    }

    public static void main(String[] args) {

        new LibraryManagementSystem();
    }
}