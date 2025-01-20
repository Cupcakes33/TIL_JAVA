package Section10.section10Q;

public class Item {
    private String name;
    private int price;

    public Item(String name, int price){
        this.name = name;
        this.price = price;
    }


    public void print(){
        System.out.println(name + " 의 가격은 " + price + "원 입니다.");
    }

    public int getPrice() {
        return this.price;
    }

}
