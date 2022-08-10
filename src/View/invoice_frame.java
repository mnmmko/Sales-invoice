package View;

import Controller.fileoperation;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class invoice_frame extends JFrame implements ActionListener {

    private JPanel panel;
    private JPanel panel1;
    private JMenuBar menubar;
    private JMenu filemenu;
    private JMenuItem loadfile;
    private JMenuItem savefile;

    public JTable t1;
    private JTable t2;
    private String []col={"No.","Date","Customer","Total"};
    private String []col1={"No.","Item Name","Item Price","Count","Item Total"};
    private String [] data={"","","",""};
    private String [] data1={"","","","",""};
    private JButton create_invoice;
    private JButton delete_invoice;
    private JButton save;
    private JButton cancel;

    private JLabel inv_num;
    public JLabel inv_nums;
    private JLabel inv_date;
    private JLabel customer_name;
    private JLabel invoice_total;
    public JLabel invoice_totals;
    private JLabel invoice_item;
    public JTextField tx1;
    public JTextField tx2;
    create_tabeles table=new create_tabeles();
    //controller fileopertaion
    fileoperation fp=new fileoperation();
public invoice_frame(){
    super("Sales invoice");
    //panal
    panel=new JPanel();
    panel1=new JPanel();
    panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
     panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
    //File Bar
    menubar=new JMenuBar();
    loadfile=new JMenuItem("Load file");
    loadfile.addActionListener(this);
    savefile=new JMenuItem("Save file");
    savefile.addActionListener(this);
    filemenu=new JMenu("File");
    filemenu.add(loadfile);
    filemenu.add(savefile);
    menubar.add(filemenu);
    setJMenuBar(menubar);
//invoice data table
    t1=new JTable();
    DefaultTableModel model =new DefaultTableModel();
    model.setColumnIdentifiers(col);
    t1.setModel(model);
    ListSelectionModel m=t1.getSelectionModel();
    m.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            DefaultTableModel models= (DefaultTableModel) t2.getModel();
            if(!m.isSelectionEmpty()){
             String val1=  t1.getValueAt(m.getMinSelectionIndex(),0).toString();
             int rows=t2.getRowCount();

                models.setColumnIdentifiers(col1);
                Vector row = new Vector();
             for (int i=0; i<rows;i++) {
                 String val2 = models.getValueAt(i, 0).toString();


                 if(val1.equals(val2)){

                     for (int k=0;k<5;k++){

                         row.add(t2.getValueAt(i, k));

                     }
                 }
                 models.addRow(row);
                 models.removeRow(0);

             }




                t2.setModel(models);

                //JOptionPane.showMessageDialog(null,"");
            }

        }
    });

//invoice item table
    t2=table.create_table(t2,col1,data1);
    panel.add(new JScrollPane(t1));
    panel1.add(new JScrollPane(t2));

//textbox
    tx1=new JTextField();
    tx2=new JTextField();

//labels
    inv_num=new JLabel("Invoice Number ");
    inv_nums=new JLabel("0");
    inv_date=new JLabel("Invoice Date ");
    invoice_item=new JLabel("Invoice Items ");
    customer_name=new JLabel("Customer Name ");
    invoice_total=new JLabel("Invoice Total ");
    invoice_totals=new JLabel("0");

//buttons
    create_invoice=new JButton("Create New Invoice");
    create_invoice.addActionListener(this);
    delete_invoice=new JButton("Delete Invoice");
    delete_invoice.addActionListener(this);
    save=new JButton("Save");
    cancel=new JButton("Cancel");
    save.addActionListener(this);

//elements postion
    panel.setBounds(10,45,550,500);
    panel1.setBounds(710,210,520,335);
    create_invoice.setBounds(100,550,150,25);
    delete_invoice.setBounds(300,550,120,25);
    save.setBounds(800,550,150,25);
    cancel.setBounds(1000,550,120,25);
    cancel.addActionListener(this);
    inv_num.setBounds(700,20,120,25);
    inv_nums.setBounds(800,20,120,25);
    inv_date.setBounds(700,60,120,25);
    customer_name.setBounds(700,100,120,25);
    invoice_total.setBounds(700,140,120,25);
    invoice_totals.setBounds(800,140,120,25);
    invoice_item.setBounds(710,175,120,25);
    tx1.setBounds(800,60,450,25);
    tx2.setBounds(800,100,450,25);

//add elements
    add(create_invoice);
    add(delete_invoice);
    add(save);
    add(cancel);
    add(panel);
    add(panel1);
    add(inv_num);
    add(inv_nums);
    add(inv_date);
    add(customer_name);
    add(invoice_total);
    add(invoice_totals);
    add(invoice_item);
    add(tx1);
    add(tx2);

    //frame
    setLayout(new BorderLayout());
    setSize(1280,650);
    setLocation(50,50);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}

   //laod item invoice
public void load(){

    fp.readFile(t1,col);
    fp.read_item(t2,col1);
    System.out.println("file loaded");
    JOptionPane.showMessageDialog(null,"file loaded");
}
 // save invoice data2)
 //	at javax.swing.plaf.basic.BasicMenuItemUI$Handler.mouseReleased(BasicMenu
public void save_file(){
    fp.writeFile(t1);
    fp.writeFile(t2);
    System.out.println("file saved");
    JOptionPane.showMessageDialog(null,"file saved");

}

//cancel function reset all invoive item
public void cancel(){
    try{
        invoice_totals.setText("0");
        tx1.setText("");
        tx2.setText("");
        inv_nums.setText("0");


    int row= t2.getRowCount();
    DefaultTableModel model=(DefaultTableModel) t2.getModel();
    for(int i =0;i<row;i++){
        model.removeRow(i);
        model.addRow(data1);
    }

    t2.setModel(model);
   }catch (Exception e){
        JOptionPane.showMessageDialog(null,"Empty row");
    }
}
// save function for save any edit in invoice item table
public void save(){
    try{
    int sum_total=0;
        int row= t2.getRowCount();
        DefaultTableModel model=(DefaultTableModel) t2.getModel();
        for(int i=0;i<=row;i++) {
            int total_price = Integer.parseInt(model.getValueAt(i, 2).toString()) * Integer.parseInt(model.getValueAt(i, 3).toString());
            model.setValueAt(total_price, i, 4);
            sum_total+=total_price;
            invoice_totals.setText(Integer.toString(sum_total));
            inv_nums.setText(model.getValueAt(i, 0).toString());
            if(model.getValueAt(row-1,4)!="") {
                model.addRow(data1);
            }
        }
        t2.setModel(model);
        System.out.println("save changes in item invoice");
    }catch (Exception e){

            }

}
// create new invoice
    public void create_invoice(){
        DefaultTableModel model =  (DefaultTableModel)t1.getModel();
        SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
        try {
          sdf.parse(tx1.getText());


            Vector row = new Vector();
            row.add(inv_nums.getText());
            row.add(tx1.getText());
            row.add(tx2.getText());
            row.add(invoice_totals.getText());
            model.addRow(row);

        }  catch (Exception e){
                 JOptionPane.showMessageDialog(null,"Invalid date format ,date format must be dd-mm-yyyy");
                 System.out.println("Invalid date format ,date format must be dd-mm-yyyy");
            }
    }
    //delete selected invoice
    public void delete(){
        try{
            int row= t1.getSelectedRow();
            DefaultTableModel model=(DefaultTableModel) t1.getModel();
            if(t1.getSelectedRowCount()==1){
                model.removeRow(row);
                System.out.println("delete invoice data");
            }else {
                if(t1.getSelectedRowCount()==0){
                    JOptionPane.showMessageDialog(null,"Select Row","Dialog",JOptionPane.PLAIN_MESSAGE);
                }
            }}catch (Exception e){
            JOptionPane.showMessageDialog(null,"Empty row");
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(loadfile)){
            load();
        }else if(e.getSource().equals(savefile)){
            save_file();
        }
       else if(e.getSource().equals(cancel)){
            cancel();
        } else if (e.getSource().equals(save)) {
            save();
        }else if(e.getSource().equals(create_invoice)){
           create_invoice();
        }
       else if(e.getSource().equals(delete_invoice)){
           delete();
        }

    }
}
