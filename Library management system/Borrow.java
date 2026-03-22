import java.util.*;

class Borrow{

    Scanner sc=new Scanner(System.in);
    Fine fine=new Fine();

    void returnBook(User user,Book book){

        if(!user.borrowed.contains(book)){
            System.out.println("Book not borrowed");
            return;
        }

        System.out.println("Enter number of days kept");
        int days=sc.nextInt();

        double f=fine.calculateFine(days,book.getPrice());

        if(f>0){

            System.out.println("Fine amount = "+f);

            System.out.println("1.Pay Cash");
            System.out.println("2.Deduct from Deposit");

            int op=sc.nextInt();

            if(op==2){
                user.deposit-=f;
            }
        }

        book.setStock(book.getStock()+1);

        user.borrowed.remove(book);

        System.out.println("Book returned successfully");
    }


    void markLost(User user,Book book){

        double f=fine.lostBookFine(book.getPrice());

        user.deposit-=f;

        user.borrowed.remove(book);

        System.out.println("Book marked lost. Fine = "+f);
    }

}