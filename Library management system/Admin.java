import java.util.*;

class Admin{

    Scanner sc=new Scanner(System.in);

    void addbook(HashMap<Integer,Book> books){

        System.out.println("Enter ISBN");
        int isbn=sc.nextInt();

        System.out.println("Enter book name");
        String name=sc.next();

        System.out.println("Enter author");
        String author=sc.next();

        System.out.println("Enter stock");
        int stock=sc.nextInt();

        System.out.println("Enter price");
        double price=sc.nextDouble();

        books.put(isbn,new Book(isbn,name,author,stock,price));

        System.out.println("Book added successfully");
    }


    void display(HashMap<Integer,Book> books){

        if(books.isEmpty()){
            System.out.println("No books available");
            return;
        }

        for(Book b:books.values()){
            b.displayBooks();
        }
    }


    void modifyBook(HashMap<Integer,Book> books,int isbn){

        if(!books.containsKey(isbn)){
            System.out.println("Book not found");
            return;
        }

        Book b=books.get(isbn);

        System.out.println("Enter new name");
        String name=sc.next();

        System.out.println("Enter author");
        String author=sc.next();

        System.out.println("Enter stock");
        int stock=sc.nextInt();

        System.out.println("Enter price");
        double price=sc.nextDouble();

        b.setName(name);
        b.setAuthor(author);
        b.setStock(stock);
        b.setPrice(price);

        System.out.println("Book modified");
    }


    void deleteBook(HashMap<Integer,Book> books,int isbn){

        if(!books.containsKey(isbn)){
            System.out.println("Book not found");
            return;
        }

        books.remove(isbn);

        System.out.println("Book deleted");
    }


    void searchBook(HashMap<Integer,Book> books,int isbn){

        if(!books.containsKey(isbn)){
            System.out.println("Book not found");
            return;
        }

        books.get(isbn).displayBooks();
    }


    void addAdmin(HashMap<String,String> adminmap){

        System.out.println("Enter email");
        String mail=sc.next();

        System.out.println("Enter password");
        String pass=sc.next();

        adminmap.put(mail,pass);

        System.out.println("Admin added successfully");
    }


    void addUser(HashMap<String,String> usermap){

        System.out.println("Enter email");
        String mail=sc.next();

        System.out.println("Enter password");
        String pass=sc.next();

        usermap.put(mail,pass);

        System.out.println("User added successfully");
    }

}