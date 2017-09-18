package alg.oblig1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ex 2: Takes in number N and N lines of text.
 * Simulates browsing the web, where you can enter a website, or go
 * back and forward in the browsing history by typing "*back*" and "*forward*"
 */
public class siteBrowser {
    /**
     * Index of current site
     */
    private static int currentSite;

    /**
     * Index of last site in history
     */
    private static int maxSite;

    /**
     * List that contains the websites that have been visited from earliest to last
     */
    private static String[] history;

    public static void main(String args[]){
        //Scanner in = new Scanner(System.in);
        //System.out.print("Enter number of commands:");
        //int N = in.nextInt();
        //in.nextLine();

        int N = Integer.parseInt(args[0]);
        history = new String[N];
        //System.out.println("Write commands:");
        currentSite=-1;
        maxSite=currentSite;
        for (int i=1;i<=N;i++){
            String entry = args[i];
            switch (entry){
                case "*back*":
                    goBack();
                    break;
                case "*forward*":
                    goForward();
                    break;
                default:
                    System.out.println(entry);
                    history[++currentSite]=entry;
                    maxSite=currentSite;
                    break;
            }
        }
    }

    private static void goBack(){
        if (currentSite<=0){
            System.out.println("[Warning: First Website]");
            return;
        }
        System.out.println(history[--currentSite]);
    }

    private static void goForward(){
        if (currentSite>=maxSite){
            System.out.println("[Warning: Last Website]");
            return;
        }
        System.out.println(history[++currentSite]);
    }

}
