import java.util.Scanner;

interface playerClasses {
    public void displayPositionName();
    public void displaySpecialities();
}

class Scout implements playerClasses {
    private String scoutName;

    public void setScoutName (String name) {
        this.scoutName = name;
    }

    public void displayPositionName() {
         System.out.println("Welcome, you are our Scout! " + this.scoutName);
    }

    public void displaySpecialities() {
        String specialities = "Provides trailing footsteps of nearby enemies!";
        System.out.println("Your task as part of our new recruit: " + specialities);
    }

    public Scout (String name) {
        setScoutName(name);
        displayPositionName();
        displaySpecialities();
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter player1 name: ");
        String scoutName = input.nextLine();
        Scout s1 = new Scout(scoutName);
    }
}
