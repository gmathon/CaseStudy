package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
//removed hi testing
        model.DataSource datasource = new DataSource();
        if (!datasource.open()) {
            System.out.println("Can't open datasource");
            return;

        }
        int choice;
        do {
            System.out.println("JDBC Menu: What do you want to run ");
            System.out.println("1: Display CustDetails by SSN ");
            System.out.println("2: Display all Transactions by zip, month and year ");
            System.out.println("3: Display transaction type sum");
            System.out.println("4: Display transaction value based on card, month and year");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter a value");
                    String title = scanner.next();

                    List<cdw_sapp_customer> custDetails = datasource.query_GetCusDetails(title);


                    custDetails = datasource.query_GetCusDetails(title);
                {
                    try {
                        if (custDetails.isEmpty()) {
                            System.out.println(" Customer does not exist for this SSN:  ");
                            return;
                        }
                        for (cdw_sapp_customer customer : custDetails) {
                            System.out.println(customer);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }

                }
                break;

                case 2:
                    System.out.println("Enter a value");
                    int title2 = scanner.nextInt();
                    int month1 = scanner.nextInt();
                    int year2 = scanner.nextInt();

                    List<cdw_sapp_creditcard> TransZip = new ArrayList<cdw_sapp_creditcard>();
                    List<cdw_sapp_customer> TransZipcust = new ArrayList<cdw_sapp_customer>();
                    datasource.query_TransZip(title2,month1,year2,TransZip,TransZipcust);

//                    TransZip = datasource.query_TransZip(title2);
                    try {
                        if (TransZip.isEmpty()||TransZipcust.isEmpty()) {
                            System.out.println("Customer does not have transcation: ");
                            return;
                        }else
                        for (cdw_sapp_creditcard creditcard : TransZip) {
                            System.out.println(creditcard);
                        }
                        for(cdw_sapp_customer customer:TransZipcust){
                            System.out.println(customer);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    System.out.println("Transaction value : ");
                    String title3 = scanner.next();

                    List<cdw_sapp_creditcard> transtotal = datasource.query_DisplayNumTotal(title3);
                    transtotal = datasource.query_DisplayNumTotal(title3);
                    try {
                        if (transtotal.isEmpty()) {
                            System.out.println("Customer does not have transcation: ");
                            return;
                        }else
                            for (cdw_sapp_creditcard creditcard : transtotal) {
                                System.out.println( "count: " +creditcard.getCount() + " transcation sum: " + creditcard.getTRANSCATION_VALUE());
                            }
                    }
                     catch(Exception e){
                                System.out.println(e.getMessage());
                                e.printStackTrace();
                            }

                    break;
                case 4:
                    System.out.println("Transaction value based on Card no. : ");
                    String cred = scanner.next();
                    String month=scanner.next();
                    String year =scanner.next();

                    List<cdw_sapp_creditcard> monthTotal = datasource.query_SumTransValueCard(cred,year,month);
//                    monthTotal = datasource.query_SumTransValueCard(title4);
                    try {
                        if (monthTotal.isEmpty()) {
                            System.out.println("Credit card has zero Transaction: ");
                            return;
                        }else {
                            for (cdw_sapp_creditcard creditcard : monthTotal) {
                                System.out.println(creditcard);
                            }
                        }
                    }catch (Exception e){
                        System.out.println("error " + e.getMessage());
                    }

            }

        } while (choice !=5);
    }
}


//      Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a value");
//        String title = scanner.next();
//
//        List<cdw_sapp_customer> custDetails = datasource.query_GetCusDetails(title);
//
//
//        custDetails = datasource.query_GetCusDetails(title);
//        { try {
//            if (custDetails.isEmpty()) {
//                System.out.println(" Customer does not exist for this SSN:  ");
//                return;
//            }
//            for (cdw_sapp_customer customer : custDetails) {
//                System.out.println(customer);
//            }
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//        }


//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter a value");
//        int title2 = scanner.nextInt();
//        title2 = scanner.nextInt();
//        title2 = scanner.nextInt();
//
//
//        List<cdw_sapp_creditcard>TransZip = datasource.query_TransZip(title2);
//
//        TransZip = datasource.query_TransZip(title2);
//        try{
//            if(TransZip.isEmpty()) {
//                System.out.println("Customer does not have transcation: ");
//                return;
//            }
//             for (cdw_sapp_creditcard creditcard: TransZip){
//                System.out.println(creditcard);
//            }
//        }catch (Exception e ) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//    }
