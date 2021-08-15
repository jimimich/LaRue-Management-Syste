import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class Driver {
    
    public static void main(String[] args) throws NumberFormatException, IOException{

        //Frame main = new Frame();
        // main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // main.setSize(800, 600);
        // main.setVisible(true);

        while (true){

            System.out.println("");
            System.out.println("----------------------------------------");
            System.out.println("Welcome to the LaRue Management System! Type the number that corresponds to the action you want to perform!");
            System.out.println("");
            System.out.println("1: Sign a Patron In");
            System.out.println("2: Add a Season Pass");
            System.out.println("3: Add an Employee");
            System.out.println("4: Transact Money from Vault");
            System.out.println("5: Show Transaction History");
            System.out.println("6: Show All Season Passes");
            System.out.println("7: Show Sign-In Sheet");
            System.out.println("8: Show All Employees");
            System.out.println("9: Start a New Sign-In Sheet Day");
            System.out.println("0: Quit");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
                
            if (option == 1){
                signPatronIn();
            }
            else if(option == 2){
                addSeasonPassPatron();
            }
            else if (option == 3){
                addEmployee();
            }
            else if(option == 4){
                transactMoney();
            }
            else if(option == 5){
                
                System.out.println("------------------------------");
                System.out.println("Transaction History:");
                System.out.println("");

                FileReader fr = new FileReader("TransactionHistory.rtf");
  
                int i;
                while ((i=fr.read()) != -1)
                System.out.print((char) i);
            }
            else if(option == 6){
                System.out.println("------------------------------");
                System.out.println("Season Passes:");
                System.out.println("");

                FileReader fr = new FileReader("SeasonPassList.rtf");
  
                int i;
                while ((i=fr.read()) != -1)
                System.out.print((char) i);
            }
            else if(option == 7){
                System.out.println("------------------------------");

                FileReader fr = new FileReader("SignInSheet.rtf");
  
                int i;
                while ((i=fr.read()) != -1)
                System.out.print((char) i);
            }
            else if(option == 8){
                System.out.println("------------------------------");
                System.out.println("Employees:");
                System.out.println("");

                FileReader fr = new FileReader("EmployeeList.rtf");
  
                int i;
                while ((i=fr.read()) != -1)
                System.out.print((char) i);
            }
            else if (option == 9){
                clearTheFile();
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                LocalDateTime now = LocalDateTime.now(); 

                try {
                    PrintWriter write = new PrintWriter(new FileWriter("SignInSheet.rtf", true));
                    write.println("Sign-In Sheet Day Of: " + dtf.format(now));
                    write.println();
                    write.close();
                } catch (IOException e) {
                    System.out.println("Error");
                }
            }
            else if (option == 0){
                break;
            }
            else{
                System.out.println("Error");
            }
        }
    }

    //Clears the sign in sheet file...
    public static void clearTheFile() throws IOException {
        FileWriter fwOb = new FileWriter("SignInSheet.rtf", false); 
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
    }

    public static void addEmployee(){

        System.out.println("Add a new employee to the employee list...");

        System.out.println("Employee Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Employee Position: ");
        Scanner sc2 = new Scanner(System.in);
        String position = sc2.nextLine();

        System.out.println("Are they Certified? (Yes or No): ");
        Scanner sc3 = new Scanner(System.in);
        String certified = sc3.nextLine();

        System.out.println("Employee Wage: ");
        Scanner sc4 = new Scanner(System.in);
        String wage = sc4.nextLine();

        System.out.println("Employee Phone Number: ");
        Scanner sc5 = new Scanner(System.in);
        String phoneNum = sc5.nextLine();

        Employee employee = new Employee(name, position, certified, wage, phoneNum);
        employee.setName(name);
        employee.setPosition(position);
        employee.setCertified(certified);
        employee.setWage(wage);
        employee.setPhoneNum(phoneNum);

        try {
            PrintWriter write = new PrintWriter(new FileWriter("EmployeeList.rtf", true));
            write.println(employee.toString());
            write.println();
            write.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void addSeasonPassPatron(){

        System.out.println("Add a pass to the seasonal pass list...");

        System.out.println("Patron Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Patron Age: ");
        Scanner sc2 = new Scanner(System.in);
        int age = sc2.nextInt();

        System.out.println("Time Signed In: ");
        Scanner sc3 = new Scanner(System.in);
        String timeSignedIn = sc3.nextLine();

        System.out.println("Patron Phone Number: ");
        Scanner sc4 = new Scanner(System.in);
        String phoneNum = sc4.nextLine();

        SeasonPatron person = new SeasonPatron(name, age, phoneNum);
        person.setName(name);
        person.setAge(age);
        person.setPhoneNum(phoneNum);

        try {
            PrintWriter write = new PrintWriter(new FileWriter("SeasonPassList.rtf", true));
            write.println(person.toString());
            write.println();
            write.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void signPatronIn(){

        System.out.println("Add a patron to the sign in sheet...");

        System.out.println("Patron Name: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        System.out.println("Patron Age: ");
        Scanner sc2 = new Scanner(System.in);
        int age = sc2.nextInt();

        System.out.println("Time Signed In: ");
        Scanner sc3 = new Scanner(System.in);
        String timeSignedIn = sc3.nextLine();

        System.out.println("Patron Phone Number: ");
        Scanner sc4 = new Scanner(System.in);
        String phoneNum = sc4.nextLine();

        System.out.println("Patron Pass Type: ");
        Scanner sc5 = new Scanner(System.in);
        String passType = sc5.nextLine();

        Patron person = new Patron(name, age, timeSignedIn, phoneNum, passType);
        person.setName(name);
        person.setAge(age);
        person.setTimeSignedIn(timeSignedIn);
        person.setPhoneNum(phoneNum);
        person.setPassType(passType);

        try {
            PrintWriter write = new PrintWriter(new FileWriter("SignInSheet.rtf", true));
            write.println(person.toString());
            write.println();
            write.close();
        } 
        catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void transactMoney() throws NumberFormatException, IOException{

            System.out.println("What are you doing?");
            System.out.println("1: Adding to the Vault");
            System.out.println("2: Taking from the Vault");
            System.out.println("3: Quit");

            Scanner sc = new Scanner(System.in);
            int transactionType = sc.nextInt();

            if(transactionType == 1){

                System.out.println("How much are you adding? (Do not include the dollar sign. Example: 20.00)");
                Scanner sc2 = new Scanner(System.in);
                float newBalance = sc2.nextFloat();
                float addAmount = newBalance;

                BufferedReader br = new BufferedReader(new FileReader("MoneyList.rtf"));
                try {
                    String sCurrentLine;
                    String lastLine;
                    
                
                    while ((sCurrentLine = br.readLine()) != null) {
                        lastLine = sCurrentLine;
                    
                        if(lastLine == null){
                            newBalance = addAmount;
                        }
                        else if(lastLine != null){
                            float f = Float.parseFloat(lastLine);
                            newBalance = f + addAmount;
                        }
                        else{
                            System.out.println("Error");
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (br != null)br.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                
                    try {
                        PrintWriter write = new PrintWriter(new FileWriter("TransactionHistory.rtf", true));
                        write.println("Amount Added: " + addAmount);
                        write.println("New Vault Balance: " + newBalance); 
                        write.println();
                        write.close();
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                    try {
                        PrintWriter write = new PrintWriter(new FileWriter("MoneyList.rtf", true));
                        write.println(newBalance);
                        write.close();
                    } 
                    catch (IOException e) {
                        System.out.println("Error");
                    }
                }
            else if(transactionType == 2){

                System.out.println("How much are you taking from the vault? (Do not include the dollar sign. Example: 20.00)");
                Scanner sc2 = new Scanner(System.in);
                float newBalance = sc2.nextFloat();
                float subAmount = newBalance;

                BufferedReader br = new BufferedReader(new FileReader("MoneyList.rtf"));
                try {
                    String sCurrentLine;
                    String lastLine;
                    
                    while ((sCurrentLine = br.readLine()) != null) {
                        lastLine = sCurrentLine;

                        if(lastLine == null){
                            newBalance += 0;
                        }
                        else{
                            float f = Float.parseFloat(lastLine);
                            newBalance = f - subAmount;
                        }
                    }
                } 
                catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (br != null)br.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                
                    try {
                        PrintWriter write = new PrintWriter(new FileWriter("TransactionHistory.rtf", true));
                        write.println("Amount Subtracted: " + subAmount);
                        write.println("New Vault Balance: " + newBalance); 
                        write.println();
                        write.close();
                    } catch (IOException e) {
                        System.out.println("Error");
                    }
                    try {
                        PrintWriter write = new PrintWriter(new FileWriter("MoneyList.rtf", true));
                        write.println(newBalance);
                        write.close();
                    } 
                    catch (IOException e) {
                        System.out.println("Error");
                    }
            }
            else if(transactionType == 3){
            }
        }
    }