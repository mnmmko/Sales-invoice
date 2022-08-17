package Model;

import java.util.ArrayList;

public class invoiceHeader {
    public String no;
    public String date;
    public String customer;
    public String total;
    public ArrayList<invoiceLine> il;
    public invoiceHeader(){

    }



    public ArrayList<invoiceLine> getIl() {
        return il;
    }

    public void setIl(ArrayList<invoiceLine> il) {
        this.il = il;
    }

    public invoiceHeader(String no, String date, String customer, String total, ArrayList<invoiceLine> il){
        this.no=no;
        this.date=date;
        this.customer=customer;
        this.total=total;
        this.il=il;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
