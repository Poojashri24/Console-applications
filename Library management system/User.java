import java.util.*;

class User{

    double deposit=1500;

    ArrayList<Book> cart=new ArrayList<>();
    ArrayList<Book> borrowed=new ArrayList<>();


    void viewBooks(HashMap<Integer,Book> books){

        if(books.isEmpty()){
            System.out.println("No books available");
            return;
        }

        for(Book b:books.values()){
            b.displayBooks();
        }
    }


    void addToCart(HashMap<Integer,Book> books,int isbn){

        if(!books.containsKey(isbn)){
            System.out.println("Book not found");
            return;
        }

        Book b=books.get(isbn);

        if(cart.contains(b)){
            System.out.println("Already in cart");
            return;
        }

        cart.add(b);

        System.out.println("Book added to cart");
    }


    void removeFromCart(int isbn){

        Iterator<Book> it=cart.iterator();

        while(it.hasNext()){

            Book b=it.next();

            if(b.getISBN()==isbn){

                it.remove();
                System.out.println("Removed from cart");
                return;
            }
        }

        System.out.println("Book not in cart");
    }


    void checkout(){

        if(cart.isEmpty()){
            System.out.println("Cart empty");
            return;
        }

        if(borrowed.size()+cart.size()>3){
            System.out.println("Cannot borrow more than 3 books");
            return;
        }

        if(deposit<500){
            System.out.println("Minimum deposit 500 required");
            return;
        }

        for(Book b:cart){

            if(b.getStock()==0){
                System.out.println("Unavailable "+b.getName());
                continue;
            }

            borrowed.add(b);

            b.setStock(b.getStock()-1);

            b.increaseBorrowCount();

            System.out.println("Borrowed "+b.getName());
        }

        cart.clear();
    }


    void showBorrowed(){

        if(borrowed.isEmpty()){
            System.out.println("No books borrowed");
            return;
        }

        for(Book b:borrowed){
            b.displayBooks();
        }
    }

}