package ValueDAO;

public class queries {
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
            COLUMN_CUST_PHONE + " = ? , " + COLUMN_CUST_EMAIL + " = ?  " + " WHERE " + COLUMN_SSN + " = ? ; ";

    public static final String  modifyP = "UPDATE " + TABLE_CDW_SAPP_CUSTOMER + " SET FIRST_NAME = ? where " +  COLUMN_SSN + " = ?; ";

    //start and stop safe mode for mysql to be able to edit without Key
    public static final String stopupdate = " SET SQL_SAFE_UPDATES = 0; ";
    public static final String startupdate = " SET SQL_SAFE_UPDATES = 1; ";


    //generate monthly bill for credit card (2.3)
    public static final String QUERY_GET_MONTHLYBILL_PREP = " SELECT SUM(" + COLUMN_C_TRANSACTION_VALUE + ")" + " FROM " + TABLE_CDW_SAPP_CREDITCARD +
            " WHERE " + COLUMN_C_CREDIT_CARD_NO + " = ?  " + " AND " + COLUMN_C_MONTH + " = ?  " +
            " AND " + COLUMN_C_YEAR + " = ? ;";

    // display customer Transaction by made (2.4)
    public static final String QUERY_DISPLAYCUSTTRANSACTIONBY_DATE_PREP = " SELECT * FROM " + TABLE_CDW_SAPP_CREDITCARD +
            " WHERE " + COLUMN_C_CUST_SSN + " = ?  AND " + COLUMN_C_YEAR + " BETWEEN ? AND ? AND " +
            COLUMN_C_MONTH + " BETWEEN ? AND ? AND " + COLUMN_C_DAY + " BETWEEN ? AND ? " +
            " ORDER BY " + COLUMN_C_YEAR + "," + COLUMN_C_MONTH + "," + COLUMN_C_DAY + ";";



}
