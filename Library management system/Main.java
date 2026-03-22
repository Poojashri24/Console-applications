import java.util.*;

class Main{

public static void main(String args[]){

    Scanner sc=new Scanner(System.in);
    
    HashMap<String,String> adminmap=new HashMap<>();
    HashMap<String,String> usermap=new HashMap<>();
    HashMap<Integer,Book> books=new HashMap<>();

    adminmap.put("admin","123");

    Admin admin=new Admin();
    Reports reports = new Reports();
    User user=new User();
    Borrow borrow=new Borrow();

    System.out.println("Welcome to Digital Library");

    boolean run=true;

    while(run){

        System.out.println("\n1.Admin\n2.User\n3.Exit");
        int role=sc.nextInt();
            switch(role){
            case 1:
                System.out.println("Enter email");
                String mail=sc.next();
                if(!adminmap.containsKey(mail)){
                System.out.println("Admin not found");
                break;
                }
                System.out.println("Enter password");
                String pass=sc.next();
                if(!adminmap.get(mail).equals(pass)){
                System.out.println("Wrong password");
                break;
                }

                boolean a=true;

                while(a){

                    System.out.println("\n1.Add Book");
                    System.out.println("2.Modify Book");
                    System.out.println("3.Delete Book");
                    System.out.println("4.Add Admin");
                    System.out.println("5.Add User");
                    System.out.println("6.View Books");
                    System.out.println("7.Search Book");
                    System.out.println("8.Reports");
                    System.out.println("9.Exit");
                    int op=sc.nextInt();

                    switch(op){

                        case 1:
                            admin.addbook(books);
                            break;

                        case 2:
                            System.out.println("Enter ISBN");
                            admin.modifyBook(books,sc.nextInt());
                            break;

                        case 3:
                            System.out.println("Enter ISBN");
                            admin.deleteBook(books,sc.nextInt());
                            break;

                        case 4:
                            admin.addAdmin(adminmap);
                            break;

                        case 5:
                            admin.addUser(usermap);
                            break;

                        case 6:
                            admin.display(books);
                            break;

                        case 7:
                            System.out.println("Enter ISBN");
                            admin.searchBook(books,sc.nextInt());
                            break;

                        case 8:

                            boolean r=true;

                            while(r){

                            System.out.println("\n----Reports Menu----");

                            System.out.println("1.Books with low stock");
                            System.out.println("2.Books never borrowed");
                            System.out.println("3.Heavily borrowed books");
                            System.out.println("4.Back");

                            int rep=sc.nextInt();

                            switch(rep){

                            case 1:
                                reports.lowStock(books);
                                break;

                            case 2:
                                reports.neverBorrowed(books);
                                break;

                            case 3:
                                reports.heavilyBorrowed(books);
                                break;

                            case 4:
                                r=false;
                                break;

                            }

                        }

                        break;

                    case 9:
                        a=false;
                        break;
                    }
                }

                break;

            case 2:

                System.out.println("Enter email");
                String u=sc.next();

                if(!usermap.containsKey(u)){
                System.out.println("User not found");
                break;
                }

                System.out.println("Enter password");
                String p=sc.next();

                if(!usermap.get(u).equals(p)){
                System.out.println("Wrong password");
                break;
                }

                boolean usr=true;

                while(usr){

                    System.out.println("\n1.View Books\n2.Add Cart\n3.Remove Cart\n4.Checkout\n5.View Borrowed\n6.Return Book\n7.Exit");

                    int op=sc.nextInt();

                    switch(op){

                    case 1:
                        user.viewBooks(books);
                        break;

                    case 2:
                        System.out.println("Enter ISBN");
                        user.addToCart(books,sc.nextInt());
                        break;

                    case 3:
                        System.out.println("Enter ISBN");
                        user.removeFromCart(sc.nextInt());
                        break;

                    case 4:
                        user.checkout();
                        break;

                    case 5:
                        user.showBorrowed();
                        break;

                    case 6:

                        System.out.println("Enter ISBN to return");
                        int id=sc.nextInt();

                        Book book=books.get(id);

                        borrow.returnBook(user,book);

                        break;

                    case 7:
                        usr=false;
                        break;
                    }
                }

            break;

            case 3:
                run=false;
                System.out.println("Thank you");
            }
    }
}
}