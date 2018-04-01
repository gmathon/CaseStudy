package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {


    //string declared for stored location/name
    public static final String DB_NAME = "banking";
    public static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String URL1 = "root";
    public static final String pass = "password";


    //creating constants of all table and column names
    public static final String TABLE_CDW_SAPP_CREDITCARD = "cdw_sapp_creditcard";
//    public static final String COLUMN_C_TRANSACTION_ID = "TRANSACTION_ID";
    public static final String COLUMN_C_DAY = "DAY";
    public static final String COLUMN_C_MONTH = "MONTH";
    public static final String COLUMN_C_YEAR = "YEAR";
    public static final String COLUMN_C_CREDIT_CARD_NO = "CREDIT_CARD_NO";
    public static final String COLUMN_C_CUST_SSN = "CUST_SSN";
    public static final String COLUMN_C_BRANCH_CODE = "BRANCH_CODE";
    public static final String COLUMN_C_TRANSACTION_TYPE = "TRANSACTION_TYPE";
    public static final String COLUMN_C_TRANSACTION_VALUE = "TRANSACTION_VALUE";


    //CREATING CONSTANTS FOR ALL TABLES AND COLUMNS || BRANCH
    public static final String TABLE_CDW_SAPP_BRANCH = "CDW_SAPP_BRANCH";
    public static final String COLUMN_BRAMCH_CODE = "BRANCH_CODE";
    public static final String COLUMN_BRANCH_NAME = "BRANCH_NAME";
    public static final String COLUMN_BRANCH_STREET = "BRANCH_STREET";
    public static final String COLUMN_BRANCH_CITY = "BRANCH_CITY";
    public static final String COLUMN_BRANCH_STATE = "BRANCH_STATE";
    public static final String COLUMN_BRANCH_ZIP = "BRANCH_ZIP";
    public static final String COLUMN_BRANCH_PHONE = "BRANCH_PHONE";


    //CREATING CONSTANTS FOR ALL TABLES AND OCLUMSN || BRANCH
    public static final String TABLE_CDW_SAPP_CUSTOMER = "CDW_SAPP_CUSTOMER";
    public static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    public static final String COLUMN_MIDDLE_NAME = "MIDDLE_NAME";
    public static final String COLUMN_LAST_NAME = "LAST_NAME";
    public static final String COLUMN_SSN = "SSN";
    public static final String COLUMN_CREDIT_CARD = "CREDIT_CARD";
    public static final String COLUMN_APT_NO = "APT_NO";
    public static final String COLUMN_STREET_NAME = "STREET_NAME";
    public static final String COLUMN_CUST_CITY = "CUST_CITY";
    public static final String COLUMN_CUST_STATE = "CUST_STATE";
    public static final String COLUMN_CUST_COUNTRY = "CUST_COUNTRY";
    public static final String COLUMN_CUST_ZIP = "CUST_ZIP";
    public static final String COLUMN_CUST_PHONE = "CUST_PHONE";
    public static final String COLUMN_CUST_EMAIL = "CUST_EMAIL";

    //QUERY FOR PREPARED STATEMENTS (1.1)
    public static final String QUERY_TRANSACTION_ZIP_PREP =
            "SELECT * FROM " + TABLE_CDW_SAPP_CREDITCARD + " JOIN " + TABLE_CDW_SAPP_CUSTOMER +
                    " ON " + TABLE_CDW_SAPP_CREDITCARD + "." + COLUMN_C_CUST_SSN + " = " + TABLE_CDW_SAPP_CUSTOMER + "." + COLUMN_SSN +
                    " WHERE " + COLUMN_CUST_ZIP + " = ? " + " AND " + COLUMN_C_MONTH + " = ? " + " AND " + COLUMN_C_YEAR + " = ?" +
                    " ORDER BY " + COLUMN_C_DAY + " DESC; ";

    //select * from cdw_sapp_customer where SSN = 123459988;
    //(2.1) check exisiting account details
    public static final String QUERY_GET_CUST_DETAILS_PREP = "SELECT * FROM " + TABLE_CDW_SAPP_CUSTOMER +
            " WHERE " + COLUMN_SSN + " = ? ;";


    //display number of total values of transcation in given state (1.3)
    //SELECT COUNT(*), sum(TRANSACTION_VALUE) FROM cdw_sapp_creditcard
    //JOIN cdw_sapp_branch ON cdw_sapp_creditcard.BRANCH_CODE=CDW_SAPP_BRANCH.BRANCH_CODE
    //WHERE cdw_sapp_branch.BRANCH_STATE = "NY"
    //GROUP BY cdw_sapp_creditcard.BRANCH_CODE;
    public static final String QUERY_DISPLAYNUMTOTALBY_STATE_PREP = "SELECT " +" COUNT(*), " + " SUM( " + COLUMN_C_TRANSACTION_VALUE + " ) " +
            " FROM " + TABLE_CDW_SAPP_CREDITCARD + " JOIN " + TABLE_CDW_SAPP_BRANCH + " ON " + TABLE_CDW_SAPP_CREDITCARD + "." + COLUMN_C_BRANCH_CODE + "=" +
            TABLE_CDW_SAPP_BRANCH + "." + COLUMN_BRAMCH_CODE + " WHERE " + TABLE_CDW_SAPP_BRANCH + "." + COLUMN_BRANCH_STATE + " = ? " +
            " GROUP BY " + TABLE_CDW_SAPP_CREDITCARD + "." + COLUMN_C_BRANCH_CODE + ";";

   // public static final String QUERY_DISPLAYNUMTOTALBY_STATE_PREP = "SELECT COUNT(*) FROM CDW_SAPP_BRANCH WHERE BRANCH_STATE = ?; ";


    //display number of total vlaues of transcation for given type (1.2)
    //SELECT COUNT(*), SUM(TRANSACTION_VALUE) FROM cdw_sapp_creditcard WHERE
    //TRANSACTION_TYPE = " ? "
    //GROUP BY TRANSACTION_TYPE
    public static final String QUERY_DISPLAYNUMTOTALBY_TYPE_PREP = "SELECT DISTINCT COUNT(*), " + " SUM( " + COLUMN_C_TRANSACTION_VALUE + " ) " +
            " FROM " + TABLE_CDW_SAPP_CREDITCARD + " WHERE " + COLUMN_C_TRANSACTION_TYPE + " = ? " +
            " GROUP BY " + COLUMN_C_TRANSACTION_TYPE + ";";

    //MODIFY CUSTOMER EXISTING ACCOUNT INFORMATION OF CUSTOMER (2.2)
    public static final String QUERY_MODIFY_CUSTDETAILS = " UPDATE " + TABLE_CDW_SAPP_CUSTOMER + " SET  " + COLUMN_FIRST_NAME + " = ? , " +
            COLUMN_MIDDLE_NAME + " = ? , " + COLUMN_LAST_NAME + " = ? , " + COLUMN_C_CREDIT_CARD_NO + " = ? , " + COLUMN_APT_NO + " = ? , " + COLUMN_STREET_NAME +
            " = ? , " + COLUMN_CUST_CITY + " = ? , " + COLUMN_CUST_STATE + " = ? , " + COLUMN_CUST_COUNTRY + " = ? , " + COLUMN_CUST_ZIP + " = ? , " +
            COLUMN_CUST_PHONE + " = ? , " + COLUMN_CUST_EMAIL + " = ? , " + " WHERE " + COLUMN_SSN + " = ? ; ";


    //generate monthly bill for credit card (2.3)
    public static final String QUERY_GET_MONTHLYBILL_PREP = " SELECT SUM(" + COLUMN_C_TRANSACTION_VALUE + ")" + " FROM " + TABLE_CDW_SAPP_CREDITCARD +
            " WHERE " + COLUMN_C_CREDIT_CARD_NO + " = ?  " + " AND " + COLUMN_C_MONTH + " = ?  " +
            " AND " + COLUMN_C_YEAR + " = ? ;";

    // display customer Transaction by made (2.4)
    public static final String QUERY_DISPLAYCUSTTRANSACTIONBY_DATE_PREP = " SELECT * FROM " + TABLE_CDW_SAPP_CREDITCARD +
            " WHERE " + COLUMN_C_CUST_SSN + " = ?  AND " + COLUMN_C_YEAR + " BETWEEN ? AND ? AND " +
            COLUMN_C_MONTH + " BETWEEN ? AND ? AND " + COLUMN_C_DAY + " BETWEEN ? AND ? " +
            " ORDER BY " + COLUMN_C_YEAR + "," + COLUMN_C_MONTH + "," + COLUMN_C_DAY + ";";



    //connection object created using .getconnection method
    public Connection conn;

    //create a private varible Preparedstatement
    private PreparedStatement query_GetCusDetails;
    private PreparedStatement query_TransZip;
    private PreparedStatement query_DisplayNumTotal;
    private PreparedStatement query_Get_Monthlybill;
    private PreparedStatement query_DisplayCustTransaction;
    private PreparedStatement query_Transtate;
    private PreparedStatement query_Update;
//    private PreparedStatement query_name;

    public boolean open() throws IllegalAccessException, InstantiationException {

        try {
            //register JDBC driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(CONNECTION_STRING, URL1, pass);

            //shows where the prepared statement starts with which query
            query_GetCusDetails = conn.prepareStatement(QUERY_GET_CUST_DETAILS_PREP);
            query_TransZip = conn.prepareStatement(QUERY_TRANSACTION_ZIP_PREP);
            query_DisplayNumTotal = conn.prepareStatement(QUERY_DISPLAYNUMTOTALBY_TYPE_PREP);
            query_Get_Monthlybill = conn.prepareStatement(QUERY_GET_MONTHLYBILL_PREP);
            query_DisplayCustTransaction = conn.prepareStatement(QUERY_DISPLAYCUSTTRANSACTIONBY_DATE_PREP);
            query_Transtate = conn.prepareStatement(QUERY_DISPLAYNUMTOTALBY_STATE_PREP);
            query_Update = conn.prepareStatement(QUERY_MODIFY_CUSTDETAILS, Statement.RETURN_GENERATED_KEYS);

            // opens connection
            System.out.println(" Connecting to " + DB_NAME + " Database....Connected!");
            return true;

        } catch (SQLException e) {
            System.out.println("Error with connection: " + e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void close() {
        try {
            if (query_GetCusDetails != null) {
                conn.close();
            }
            if (query_TransZip != null) {
                conn.close();
            }
            if (query_DisplayNumTotal != null) {
                conn.close();
            }
//            if (query_name != null) {
//                conn.close();
//            }
            if (query_Transtate != null) {
                conn.close();
            }
            if (query_DisplayCustTransaction != null) {
                conn.close();
            }
            if (query_Get_Monthlybill != null) {
                conn.close();
            }
            if (query_Update != null) {
                conn.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("couldn't close connection: " + e.getMessage());
        }
    }


    public List<cdw_sapp_customer> query_GetCusDetails(String title) {

        try {
            query_GetCusDetails.setString(1, title);
            ResultSet results = query_GetCusDetails.executeQuery();

            List<cdw_sapp_customer> custDetails = new ArrayList<cdw_sapp_customer>();

            while (results.next()) {
                cdw_sapp_customer cdw_sapp_customer = new cdw_sapp_customer();
                cdw_sapp_customer.setFIRST_NAME(results.getString(1));
                cdw_sapp_customer.setMIDDLE_NAME(results.getString(2));
                cdw_sapp_customer.setLAST_NAME(results.getString(3));
                cdw_sapp_customer.setSSN(results.getInt(4));
                cdw_sapp_customer.setCREDIT_CARD_NO(results.getString(5));
                cdw_sapp_customer.setAPT_NO(results.getString(6));
                cdw_sapp_customer.setSTREET_NAME(results.getString(7));
                cdw_sapp_customer.setCUST_CITY(results.getString(8));
                cdw_sapp_customer.setCUST_STATE(results.getString(9));
                cdw_sapp_customer.setCUST_COUNTRY(results.getString(10));
                cdw_sapp_customer.setCUST_ZIP(results.getString(11));
                cdw_sapp_customer.setCUST_PHONE(results.getInt(12));
                cdw_sapp_customer.setCUST_EMAIL(results.getString(13));

                custDetails.add(cdw_sapp_customer);
            }
            return custDetails;
        } catch (SQLException e) {
            System.out.println("Query failed " + e.getMessage());
            return null;
        }
    }

    public List<cdw_sapp_creditcard> query_DisplayNumTotal(String title3) {
        try {
            query_DisplayNumTotal.setString(1, title3);
            ResultSet results = query_DisplayNumTotal.executeQuery();

            List<cdw_sapp_creditcard> transTotal = new ArrayList<cdw_sapp_creditcard>();
            while (results.next()) {
                cdw_sapp_creditcard cdw_sapp_creditcard = new cdw_sapp_creditcard();
                cdw_sapp_creditcard.setTRANSCATION_VALUE(results.getString(2));
                cdw_sapp_creditcard.setCount(results.getString(1));
                transTotal.add(cdw_sapp_creditcard);
            }
            return transTotal;
        } catch (SQLException e) {
            System.out.println("The sum of all transcations is 0 ");
            e.printStackTrace();
        }


        return null;
    }

    public void query_DISPLAY_BYSTATE(String state, List<cdw_sapp_creditcard> TransState, List<cdw_sapp_branch> TransBranch) {
        try {
            query_Transtate.setString(1, state);
            ResultSet results = query_Transtate.executeQuery();

            System.out.println(query_Transtate);
            if(results.next()==false) {
                System.out.println("There is no State by this name");
                return;
            }
            while (results.next()) {
                cdw_sapp_creditcard cdw_sapp_creditcard = new cdw_sapp_creditcard();
                cdw_sapp_branch cdw_sapp_branch = new cdw_sapp_branch();
                cdw_sapp_branch cdw_sapp_branch1 = new cdw_sapp_branch();
                cdw_sapp_creditcard.setTRANSCATION_VALUE(results.getString(2));
                cdw_sapp_creditcard.setCount(results.getString(1));
//                cdw_sapp_branch.setBRANCH_CITY(results.getString(1));
                TransState.add(cdw_sapp_creditcard);
                TransBranch.add(cdw_sapp_branch);

            }

        } catch (SQLException e) {
            System.out.println("Error in display by transaction type: " + e.getMessage());
        }
    }
    //  public static final String QUERY_DISPLAYNUMTOTALBY_STATE_PREP = "SELECT COUNT(*), " + " SUM( " + COLUMN_C_TRANSACTION_VALUE + " ) " +
    //            " FROM " + TABLE_CDW_SAPP_CREDITCARD + " JOIN " + TABLE_CDW_SAPP_BRANCH + " ON " + TABLE_CDW_SAPP_CREDITCARD + "." + COLUMN_C_BRANCH_CODE + "=" +
    //            TABLE_CDW_SAPP_BRANCH + "." + COLUMN_BRAMCH_CODE + " WHERE " + TABLE_CDW_SAPP_BRANCH + "." + COLUMN_BRANCH_CITY + " = ? " +
    //            " GROUP BY " + TABLE_CDW_SAPP_CREDITCARD + "." + COLUMN_C_BRANCH_CODE + ";";


    public void query_TransZip(int title2, int month, int year, List<cdw_sapp_creditcard> TransZip, List<cdw_sapp_customer> TransZipcust) {
        try {
            query_TransZip.setInt(1, title2);
            query_TransZip.setInt(2, month);
            query_TransZip.setInt(3, year);
            ResultSet results = query_TransZip.executeQuery();

            while (results.next()) {
                cdw_sapp_creditcard cdw_sapp_creditcard = new cdw_sapp_creditcard();
                cdw_sapp_customer cdw_sapp_customer = new cdw_sapp_customer();
                cdw_sapp_creditcard.setTRANSACTION_ID(results.getInt(1));
                cdw_sapp_creditcard.setDAY(results.getInt(2));
                cdw_sapp_creditcard.setMONTH(results.getInt(3));
                cdw_sapp_creditcard.setYEAR(results.getInt(4));
                cdw_sapp_creditcard.setCREDIT_CARD_NO(results.getString(5));
                cdw_sapp_creditcard.setCUST_SSN(results.getInt(6));
                cdw_sapp_creditcard.setBRANCH_CODE(results.getInt(7));
                cdw_sapp_creditcard.setTRANSACTION_TYPE(results.getString(8));
                cdw_sapp_creditcard.setTRANSCATION_VALUE(results.getString(9));
                cdw_sapp_customer.setFIRST_NAME(results.getString(10));
                cdw_sapp_customer.setMIDDLE_NAME(results.getString(11));
                cdw_sapp_customer.setLAST_NAME(results.getString(12));
                cdw_sapp_customer.setCREDIT_CARD_NO(results.getString(13));
                cdw_sapp_customer.setAPT_NO(results.getString(14));
                cdw_sapp_customer.setSTREET_NAME(results.getString(15));
                cdw_sapp_customer.setCUST_CITY(results.getString(16));
                cdw_sapp_customer.setCUST_STATE(results.getString(17));
                cdw_sapp_customer.setCUST_COUNTRY(results.getString(18));
                cdw_sapp_customer.setCUST_ZIP(results.getString(19));
                cdw_sapp_customer.setCUST_PHONE(results.getInt(20));
                cdw_sapp_customer.setCUST_EMAIL(results.getString(21));

                TransZip.add(cdw_sapp_creditcard);
                TransZipcust.add(cdw_sapp_customer);
            }
            // return;

        } catch (SQLException e) {
            System.out.println("Query for Zip code fails " + e.getMessage());
            e.printStackTrace();
        }


        //return null;
    }


    public List<cdw_sapp_creditcard> query_DisplayCustTransDate(String ssn, int year11, int year12, int month11, int month12, int day11, int day12) {
        try {
            query_DisplayCustTransaction.setString(1, ssn);
            query_DisplayCustTransaction.setInt(2, year11);
            query_DisplayCustTransaction.setInt(3, year12);
            query_DisplayCustTransaction.setInt(4, month11);
            query_DisplayCustTransaction.setInt(5, month12);
            query_DisplayCustTransaction.setInt(6, day11);
            query_DisplayCustTransaction.setInt(7, day12);
            ResultSet results = query_DisplayCustTransaction.executeQuery();
            List<cdw_sapp_creditcard> displayCustTran = new ArrayList<cdw_sapp_creditcard>();
            while (results.next()) {
                cdw_sapp_creditcard cdw_sapp_creditcard = new cdw_sapp_creditcard();
                cdw_sapp_creditcard.setTRANSACTION_ID(results.getInt(1));
                cdw_sapp_creditcard.setDAY(results.getInt(2));
                cdw_sapp_creditcard.setMONTH(results.getInt(3));
                cdw_sapp_creditcard.setYEAR(results.getInt(4));
                cdw_sapp_creditcard.setCREDIT_CARD_NO(results.getString(5));
                cdw_sapp_creditcard.setCUST_SSN(results.getInt(6));
                cdw_sapp_creditcard.setBRANCH_CODE(results.getInt(7));
                cdw_sapp_creditcard.setTRANSACTION_TYPE(results.getString(8));
                cdw_sapp_creditcard.setTRANSCATION_VALUE(results.getString(9));

                displayCustTran.add(cdw_sapp_creditcard);
            }
            return displayCustTran;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

//         public static final String QUERY_DISPLAYCUSTTRANSACTIONBY_DATE_PREP = " SELECT * FROM " + TABLE_CDW_SAPP_CREDITCARD +
//            " WHERE " + COLUMN_C_CUST_SSN + " = ?  AND " + COLUMN_C_YEAR + " BETWEEN ? AND ? AND " +
//            COLUMN_C_MONTH + " BETWEEN ? AND ? AND " + COLUMN_C_DAY + " BETWEEN ? AND ? " +
//            " ORDER BY " + COLUMN_C_YEAR + "," + COLUMN_C_MONTH + "," + COLUMN_C_DAY + ";";

    public List<cdw_sapp_creditcard> query_SumTransValueCard(String cerd, String year, String month) {
        List<cdw_sapp_creditcard> monthTotal = new ArrayList<cdw_sapp_creditcard>();
        try {
            query_Get_Monthlybill.setString(1, cerd);
            query_Get_Monthlybill.setString(2, month);
            query_Get_Monthlybill.setString(3, year);
            ResultSet results = query_Get_Monthlybill.executeQuery();
            System.out.println(query_Get_Monthlybill);

            while (results.next()) {
                cdw_sapp_creditcard cdw_sapp_creditcard = new cdw_sapp_creditcard();
                cdw_sapp_creditcard.setTRANSCATION_VALUE(results.getString(1));
                System.out.println(cdw_sapp_creditcard.getTRANSCATION_VALUE());
                monthTotal.add(cdw_sapp_creditcard);
            }
            return monthTotal;

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return monthTotal;
    }

    public void query_CustMod(String first, String middle, String last, String card, String apt, String street, String city, String state, String country, String zip,
                              int phone, String email, int ssn) {
        try {

            query_Update.setString(1, first);
            query_Update.setString(2, middle);
            query_Update.setString(3, last);
            query_Update.setString(4, card);
            query_Update.setString(5, apt);
            query_Update.setString(6, street);
            query_Update.setString(7, city);
            query_Update.setString(8, state);
            query_Update.setString(9, country);
            query_Update.setString(10, zip);
            query_Update.setInt(11, phone);
            query_Update.setString(12, email);
            query_Update.setInt(13, ssn);
            int results = query_Update.executeUpdate();

            System.out.println(query_Update);

            while (results == 1) {
                cdw_sapp_customer cdw_sapp_customer = new cdw_sapp_customer();
                cdw_sapp_customer.getFIRST_NAME();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
//        return custMod;
    }
}



