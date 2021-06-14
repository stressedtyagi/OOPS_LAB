import java.util.Scanner;

public class Sample {
    private static class Clock{
        int hrs,mins,secs;

        Clock(int hrs,int mins,int secs){
            this.hrs = hrs;
            this.mins = mins;
            this.secs = secs;
        }

        public Clock add(Clock o){
            int secs = this.secs + o.secs;
            int carry = secs / 60;
            secs = secs % 60;
            
            int mins = this.mins + o.mins+carry;
            carry = mins / 60;
            mins = mins % 60;

            int hrs = this.hrs + o.hrs + carry;
            if(hrs > 23){
                // handle exception
            }

            return new Clock(hrs,mins,secs);
        }
        public String toString(){
            return hrs+":"+mins+":"+secs;
        }
    }    
    public static void main(String args[]){
        Scanner scn = new Scanner(System.in);
        int hr1 =scn.nextInt(), min1=scn.nextInt() , sec1 =scn.nextInt(), hr2 =scn.nextInt(),min2 =scn.nextInt(),sec2=scn.nextInt();
        Clock c1 = new Clock(hr1,min1,sec1);
        Clock c2 = new Clock(hr2,min2,sec2);
        Clock c3 = c1.add(c2);

        System.out.println(c3);

    }
}
