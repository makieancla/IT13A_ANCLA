package Prelim;

public class Lab_act1_Arithmetics {

    public static void main(String[] org) {

        int makie = 10;
        int ancla = 6;
        int francis = 4;
        int estoque = 3;

        int show1 = makie * francis + ancla;
        int backup1 = makie - francis;
        int show2 = backup1 % ancla;
        int backup2 = makie + francis + ancla;
        int show3 = backup2 / estoque;
        int backup3 = ancla * francis;
        int show4 = makie * ancla - backup3;

        System.out.println(" 10 * 4 + 6 = " + show1);
        System.out.println("(10-4) % 6 = " + show2);
        System.out.println("(10 + 4 + 6)/3 = " + show3);
        System.out.println("10 * 6 -(4 * 4 ) = " + show4);

    }
}
