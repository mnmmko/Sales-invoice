package Model;

public class invoiceLine {
    public String no;
    public String itemname;
    public String itemprice;
    public String count;
    public String itemtotal;
    public invoiceLine(){

    }

    public invoiceLine(String no, String itemname, String itemprice, String count,String itemtotal){
        this.no=no;
        this.itemname=itemname;
        this.itemprice=itemprice;
        this.count=count;
        this.itemtotal=itemtotal;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        this.itemprice = itemprice;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getItemtotal() {
        return itemtotal;
    }

    public void setItemtotal(String itemtotal) {
        this.itemtotal = itemtotal;
    }
}
