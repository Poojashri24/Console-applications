class Book {

    private int ISBN;
    private String name;
    private String author;
    private int stock;
    private double price;
    private int borrowCount = 0;

    Book(int ISBN,String name,String author,int stock,double price){
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.stock = stock;
        this.price = price;
    }

    int getISBN(){
        return ISBN;
    }

    String getName(){
        return name;
    }

    String getAuthor(){
        return author;
    }

    int getStock(){
        return stock;
    }

    double getPrice(){
        return price;
    }

    int getBorrowCount(){
        return borrowCount;
    }

    void increaseBorrowCount(){
        borrowCount++;
    }

    void setName(String name){
        this.name=name;
    }

    void setAuthor(String author){
        this.author=author;
    }

    void setStock(int stock){
        this.stock=stock;
    }

    void setPrice(double price){
        this.price=price;
    }

    void displayBooks(){
        System.out.println("----------------------------");
        System.out.println("Book Name : "+name);
        System.out.println("ISBN : "+ISBN);
        System.out.println("Author : "+author);
        System.out.println("Stock : "+stock);
        System.out.println("Price : "+price);
        System.out.println("----------------------------");
    }
}