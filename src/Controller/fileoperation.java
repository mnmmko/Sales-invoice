package Controller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Vector;

public class fileoperation extends JTable{

    //file choose method
    private String file_choose(){
        JFileChooser filechooser = new JFileChooser();
        String filepath="";
        int i = filechooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            File f = filechooser.getSelectedFile();
            filepath = f.getPath();

            System.out.print(filepath);

        }
        return filepath;
    }
    //read ivoice data
    public void read_file(JTable t,String col[]){
          String filepath=file_choose();

            DefaultTableModel model = new DefaultTableModel();
        String line="";
        model.setColumnIdentifiers(col);
        try {
            BufferedReader br=new BufferedReader(new FileReader(filepath));
            while ((line= br.readLine())!=null){
                String []datas=line.split(",");
                Vector row = new Vector();
                row.add(datas[0]);
                row.add(datas[1]);
                row.add(datas[2]);
                row.add(datas[3]);
                model.addRow(row);
            }
            System.out.println("read invoices item");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Can not load file");
        }
        t.setModel(model);
    }
    //read invoice item
    public void read_item(JTable t,String col[]){
          String filepath=file_choose();

            DefaultTableModel model = new DefaultTableModel();
        String line="";
        model.setColumnIdentifiers(col);
        try {
            BufferedReader br=new BufferedReader(new FileReader(filepath));
            while ((line= br.readLine())!=null){
                String []datas=line.split(",");
                Vector row = new Vector();
                row.add(datas[0]);
                row.add(datas[1]);
                row.add(datas[2]);
                row.add(datas[3]);
                row.add(Integer.parseInt(datas[3])*Integer.parseInt(datas[2]));
                model.addRow(row);
            }
            System.out.println("read invoices item");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Can not load file");
        }
        t.setModel(model);
    }



    //save data
    public void save_data(JTable t){

        String filepath=file_choose();
            FileOutputStream fos=null;
            try {
                fos=new FileOutputStream(filepath);
                for(int k=0;k<=t.getRowCount();k++){
                    for (int j=0;j<t.getColumnCount();j++){
                        fos.write((t.getValueAt(k,j)+",").toString().getBytes());
                    }
                    fos.write("\n".getBytes());
                }
                JOptionPane.showMessageDialog(null,"file saved");

                System.out.println("saved file");

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Can not save file");
            }catch (Exception e){

            }
            finally {try{
                fos.close();
            }catch (IOException e){

            }
            }


    }


}
