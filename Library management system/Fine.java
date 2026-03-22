class Fine{

    double calculateFine(int days,double price){

        if(days<=15)
            return 0;

        int delay=days-15;

        double fine=delay*2;

        if(delay>10)
            fine=fine*1.5;

        double limit=price*0.8;

        return Math.min(fine,limit);
    }

    double lostBookFine(double price){

        return price*0.5;
    }

}