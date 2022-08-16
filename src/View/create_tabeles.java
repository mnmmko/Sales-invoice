package View;

import Model.invoiceHeader;
import Model.invoiceLine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Vector;

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
    public DefaultTableModel loaddata(JTable t, ArrayList<invoiceHeader> data, String []col){
        DefaultTableModel model =  new DefaultTableModel();
        t=new JTable();
        model.setColumnIdentifiers(col);
        for (int i=0;i<data.size();i++) {
            Vector row = new Vector();
            row.add(data.get(i).getNo());
            row.add(data.get(i).getDate());
            row.add(data.get(i).getCustomer());
            row.add(data.get(i).getTotal());
            model.addRow(row);
        }
       // t.setModel(model);
        return model;
    }public DefaultTableModel tableitems(JTable t, ArrayList<invoiceLine> data, String []col){
        DefaultTableModel model =new DefaultTableModel();
        t=new JTable();
        model.setColumnIdentifiers(col);
        for (int i=0;i<data.size();i++) {
            Vector row = new Vector();
            row.add(data.get(i).getNo());
            row.add(data.get(i).getItemname());
            row.add(data.get(i).getItemprice());
            row.add(data.get(i).getCount());
            row.add(data.get(i).getItemtotal());
            model.addRow(row);
        }
       // t.setModel(model);
       return model;
    }

}
