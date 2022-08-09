package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class create_tabeles extends JTable {



    public JTable create_table(JTable t,String[]col,String []data){
        DefaultTableModel model =new DefaultTableModel();
        t=new JTable();
        model.setColumnIdentifiers(col);
        for (int i=0;i<=2;i++) {
            model.addRow(data);
        }
        t.setModel(model);
return t;
    }
}
