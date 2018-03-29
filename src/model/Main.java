package model;


import com.sun.org.apache.xpath.internal.SourceTree;

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
                System.out.println("5: Display Transactions made by ssn, year, month");
                System.out.println("6: Display Transaction value by state");
                System.out.println("7: Modify customer details");
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
                            } else
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
                        datasource.query_TransZip(title2, month1, year2, TransZip, TransZipcust);

//                    TransZip = datasource.query_TransZip(title2);
                        try {
                            if (TransZip.isEmpty() || TransZipcust.isEmpty()) {
                                System.out.println("Customer does not have transcation: ");
                                return;
                            } else
                                for (cdw_sapp_creditcard creditcard : TransZip) {
                                    System.out.println(creditcard);
                                }
                            for (cdw_sapp_customer customer : TransZipcust) {
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
                            } else
                                for (cdw_sapp_creditcard creditcard : transtotal) {
                                    System.out.println("count: " + creditcard.getCount() + " transcation sum: " + creditcard.getTRANSCATION_VALUE());
                                }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }

                        break;
                    case 4:
                        System.out.println("Transaction value based on Card no. : ");
                        String cred = scanner.next();
                        String month = scanner.next();
                        String year = scanner.next();

                        List<cdw_sapp_creditcard> monthTotal = datasource.query_SumTransValueCard(cred, year, month);
//                    monthTotal = datasource.query_SumTransValueCard(title4);
                        try {
                            if (monthTotal.isEmpty()) {
                                System.out.println("Credit card has zero Transaction: ");
                                return;
                            } else {
                                for (cdw_sapp_creditcard creditcard : monthTotal) {
                                    System.out.println(creditcard);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("error " + e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println("Transaction value based on ssn, year range and month range and day range");
                        String ssn = scanner.next();
                        int year11 = scanner.nextInt();
                        int year12 = scanner.nextInt();
                        int month11 = scanner.nextInt();
                        int month12 = scanner.nextInt();
                        int day11 = scanner.nextInt();
                        int day12 = scanner.nextInt();

                        List<cdw_sapp_creditcard> transactionbyssn = datasource.query_DisplayCustTransDate(ssn, year11, year12, month11, month12, day11, day12);
                        try {
                            if (transactionbyssn.isEmpty()) {
                                System.out.println("No values found");
                                return;
                            } else {
                                for (cdw_sapp_creditcard cdw_sapp_creditcard : transactionbyssn) {
                                    System.out.println(cdw_sapp_creditcard);
                                }
                            }
                        } catch (Exception e) {
                            System.out.println("error in code : " + e.getMessage());
                        }
                        break;

                    case 6:
                        System.out.println("Transaction value based on Type: ");
                        String state = scanner.next();

                        List<cdw_sapp_creditcard> TranStat = new ArrayList<cdw_sapp_creditcard>();
                        List<cdw_sapp_branch> TranBranch = new ArrayList<cdw_sapp_branch>();
                        datasource.query_DISPLAY_BYSTATE(state, TranStat, TranBranch);
                        try {
                            if (TranBranch.isEmpty() || TranStat.isEmpty()) {
                                System.out.println("No transaction: ");
                                return;
                            } else {
                                for (cdw_sapp_creditcard cdw_sapp_creditcard : TranStat) {
                                    System.out.println(cdw_sapp_creditcard.getCount() + cdw_sapp_creditcard.getTRANSCATION_VALUE());
                                }
//                            for (cdw_sapp_branch cdw_sapp_branch : TranBranch){
//                                System.out.println(cdw_sapp_branch.getcount() + cdw_sapp_branch.getT);
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());

                        }
                        break;

                    case 7:
                        System.out.println("What is new customer information to modify");
                        System.out.println("enter first");
                        String first = scanner.next();
                        System.out.println("enter middle");
                      String middle = scanner.next();
                        System.out.println("enter last");
                      String last = scanner.next();
                        System.out.println("enter card no");
                      String card = scanner.next();
                        System.out.println("enter apt");
                      String apt = scanner.next();
                        System.out.println("enter street");
                      String street =scanner.next();
                        System.out.println("enter city");
                      String city = scanner.next();
                        System.out.println("enter state");
                      String state1  =scanner.next();
                        System.out.println("enter country");
                      String country = scanner.next();
                        System.out.println("enter contry");
                      String zip = scanner.next();
                        System.out.println("enter zip");
                      int phone = scanner.nextInt();
                        System.out.println("enter phone");
                      String email = scanner.next();
                        System.out.println("enter email");
                      int ssn1 = scanner.nextInt();
                        System.out.println("enter ssn");
                        datasource.query_CustMod(first, middle,last,card,apt,street,city,state1,country,zip,phone,email,ssn1);


                }

            } while (choice != 8);
    }
}


