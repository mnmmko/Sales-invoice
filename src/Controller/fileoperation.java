package Controller;

import Model.invoiceHeader;
import Model.invoiceLine;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;

public class fileoperation extends JTable{
    //read ivoice data
    public ArrayList<invoiceHeader> readFile(){

          String filepath=file_choose();
        String line="";

ArrayList<invoiceHeader> ah=new ArrayList<>();

        try {
            BufferedReader br=new BufferedReader(new FileReader(filepath));
            while ((line= br.readLine())!=null){
            String[] datas=(line.split(","));
               ah.add(new invoiceHeader(datas[0],datas[1],datas[2],datas[3]));

            }
            System.out.println("read invoices item");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Can not load file");
        }
      //  t.setModel(model);
        return ah;
    }
    //save data
    public void writeFile(JTable t){

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
    //read invoice item
    public ArrayList<invoiceLine> read_item(){
          String filepath=file_choose();

            DefaultTableModel model = new DefaultTableModel();
        String line="";

        ArrayList<invoiceLine> al=new ArrayList<>();
        try {
            BufferedReader br=new BufferedReader(new FileReader(filepath));
            while ((line= br.readLine())!=null){
                String []datas=line.split(",");
                al.add(new invoiceLine(datas[0],datas[1],datas[2],datas[3],String.valueOf(Integer.parseInt(datas[3])*Integer.parseInt(datas[2]))));
            }
            System.out.println("read invoices item");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Can not load file");
        }
        return al;
    }





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


}
