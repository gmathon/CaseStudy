package model;

public class cdw_sapp_creditcard{
    private int TRANSACTION_ID;
    private int DAY;
    private int MONTH;
    private int YEAR;
    private String Count;
    private String CREDIT_CARD_NO;
    private int CUST_SSN;
    private int BRANCH_CODE;
    private String TRANSACTION_TYPE;
    private String TRANSCATION_VALUE;

    public String getCount() {
        return Count;
    }

    public void setCount(String count) {
        Count = count;
    }

    public int getTRANSACTION_ID() {
        return TRANSACTION_ID;
    }

    public void setTRANSACTION_ID(int TRANSACTION_ID) {
        this.TRANSACTION_ID = TRANSACTION_ID;
    }

    public int getDAY() {
        return DAY;
    }

    public void setDAY(int DAY) {
        this.DAY = DAY;
    }

    public int getMONTH() {
        return MONTH;
    }

    public void setMONTH(int MONTH) {
        this.MONTH = MONTH;
    }

    public int getYEAR() {
        return YEAR;
    }

    public void setYEAR(int YEAR) {
        this.YEAR = YEAR;
    }

    public String getCREDIT_CARD_NO() {
        return CREDIT_CARD_NO;
    }

    public void setCREDIT_CARD_NO(String CREDIT_CARD_NO) {
        this.CREDIT_CARD_NO = CREDIT_CARD_NO;
    }

    public int getCUST_SSN() {
        return CUST_SSN;
    }

    public void setCUST_SSN(int CUST_SSN) {
        this.CUST_SSN = CUST_SSN;
    }

    public int getBRANCH_CODE() {
        return BRANCH_CODE;
    }

    public void setBRANCH_CODE(int BRANCH_CODE) {
        this.BRANCH_CODE = BRANCH_CODE;
    }

    public String getTRANSACTION_TYPE() {
        return TRANSACTION_TYPE;
    }

    public void setTRANSACTION_TYPE(String TRANSACTION_TYPE) {
        this.TRANSACTION_TYPE = TRANSACTION_TYPE;
    }

    public String getTRANSCATION_VALUE() {
        return TRANSCATION_VALUE;
    }

    public void setTRANSCATION_VALUE(String TRANSCATION_VALUE) {
        this.TRANSCATION_VALUE = TRANSCATION_VALUE;
    }

    //stored as string because you shouldn't be able to do operations on this.



    @Override
    public String toString() {
        return "Creditcard Details[" +
                "TRANSACTION_ID=" + TRANSACTION_ID +
                ", DAY=" + DAY +
                ", MONTH=" + MONTH +
                ", YEAR=" + YEAR +
                ", CREDIT_CARD_NO='" + CREDIT_CARD_NO + '\'' +
                ", CUST_SSN=" + CUST_SSN +
                ", BRANCH_CODE=" + BRANCH_CODE +
                ", TRANSACTION_TYPE='" + TRANSACTION_TYPE + '\'' +
                ", TRANSCATION_VALUE=" + TRANSCATION_VALUE +
                ", count = " + Count+
                ']';
    }
}
