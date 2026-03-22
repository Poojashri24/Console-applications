import java.util.*;

class Reports{

    void lowStock(HashMap<Integer,Book> books){

        System.out.println("Books with low stock");

        for(Book b:books.values()){
            if(b.getStock()<2)
                b.displayBooks();
        }
    }

    void neverBorrowed(HashMap<Integer,Book> books){

        System.out.println("Books never borrowed");

        for(Book b:books.values()){
            if(b.getBorrowCount()==0)
                b.displayBooks();
        }
    }

    void heavilyBorrowed(HashMap<Integer,Book> books){

        System.out.println("Heavily borrowed books");

        for(Book b:books.values()){
            if(b.getBorrowCount()>5)
                b.displayBooks();
        }
    }
}