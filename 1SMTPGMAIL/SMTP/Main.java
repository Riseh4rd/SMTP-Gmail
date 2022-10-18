package SMTP;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random r = new Random();
        System.out.printf(WHITE_BOLD_BRIGHT+"\nPlease, Enter Your login: ");
        String login = in.nextLine();

        System.out.printf("\nPlease, Enter Your password: ");
        String password = in.nextLine();

        System.out.printf("\nPlease, Enter Your "+YELLOW_BOLD_BRIGHT+"email: "+WHITE_BOLD_BRIGHT);
        String email = in.nextLine();

        String code = String.valueOf(r.nextInt(888888)+111111);
        SSLEmail.send(email,"Confirmation code",code);

        System.out.printf("\nPlease, Enter code from Your"+YELLOW_BOLD_BRIGHT+" email: "+WHITE_BOLD_BRIGHT);
        String authcode = in.nextLine();
        int InvalidCunter =0;
        while (true){
            if(InvalidCunter==9){System.out.println(RED_BOLD_BRIGHT+"No more Attempts left, Registration aborted...");break;}
        if (authcode.equals(code)){
            System.out.printf(GREEN_BOLD_BRIGHT+"\nSuccess account: "+YELLOW_BOLD_BRIGHT+"%s"+GREEN_BOLD_BRIGHT+", "+YELLOW_BOLD_BRIGHT+"%s",login,password);
            break;
        }

        else{
            System.out.println(RED_BOLD_BRIGHT+"Invalid code!!! ");
            InvalidCunter++;System.out.print(RED_BOLD_BRIGHT+"Attempts left: "+(10 - InvalidCunter));
            System.out.printf("\nPlease, Enter code from Your"+YELLOW_BOLD_BRIGHT+" email: "+WHITE_BOLD_BRIGHT);
            authcode = in.nextLine();
        }
        }
    }
}
