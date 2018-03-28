package model;

public class cdw_sapp_customer {

    private String FIRST_NAME;
    private String MIDDLE_NAME;
    private String LAST_NAME;
    private int SSN=0;
    private String CREDIT_CARD_NO;
    private String APT_NO;
    private String STREET_NAME;
    private String CUST_CITY;
    private String CUST_STATE;
    private String CUST_COUNTRY;
    private String CUST_ZIP;
    private int CUST_PHONE;
    private String CUST_EMAIL;

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getMIDDLE_NAME() {
        return MIDDLE_NAME;
    }

    public void setMIDDLE_NAME(String MIDDLE_NAME) {
        this.MIDDLE_NAME = MIDDLE_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public String getCREDIT_CARD_NO() {
        return CREDIT_CARD_NO;
    }

    public void setCREDIT_CARD_NO(String CREDIT_CARD_NO) {
        this.CREDIT_CARD_NO = CREDIT_CARD_NO;
    }

    public String getAPT_NO() {
        return APT_NO;
    }

    public void setAPT_NO(String APT_NO) {
        this.APT_NO = APT_NO;
    }

    public String getSTREET_NAME() {
        return STREET_NAME;
    }

    public void setSTREET_NAME(String STREET_NAME) {
        this.STREET_NAME = STREET_NAME;
    }

    public String getCUST_CITY() {
        return CUST_CITY;
    }

    public void setCUST_CITY(String CUST_CITY) {
        this.CUST_CITY = CUST_CITY;
    }

    public String getCUST_STATE() {
        return CUST_STATE;
    }

    public void setCUST_STATE(String CUST_STATE) {
        this.CUST_STATE = CUST_STATE;
    }

    public String getCUST_COUNTRY() {
        return CUST_COUNTRY;
    }

    public void setCUST_COUNTRY(String CUST_COUNTRY) {
        this.CUST_COUNTRY = CUST_COUNTRY;
    }

    public String getCUST_ZIP() {
        return CUST_ZIP;
    }

    public void setCUST_ZIP(String CUST_ZIP) {
        this.CUST_ZIP = CUST_ZIP;
    }

    public int getCUST_PHONE() {
        return CUST_PHONE;
    }

    public void setCUST_PHONE(int CUST_PHONE) {
        this.CUST_PHONE = CUST_PHONE;
    }

    public String getCUST_EMAIL() {
        return CUST_EMAIL;
    }

    public void setCUST_EMAIL(String CUST_EMAIL) {
        this.CUST_EMAIL = CUST_EMAIL;
    }

    @Override
    public String toString() {
        return "cdw_sapp_customer{" +
                "FIRST_NAME='" + FIRST_NAME + '\'' +
                ", MIDDLE_NAME='" + MIDDLE_NAME + '\'' +
                ", LAST_NAME='" + LAST_NAME + '\'' +
                ", SSN=" + SSN +
                ", CREDIT_CARD_NO='" + CREDIT_CARD_NO + '\'' +
                ", APT_NO='" + APT_NO + '\'' +
                ", STREET_NAME='" + STREET_NAME + '\'' +
                ", CUST_CITY='" + CUST_CITY + '\'' +
                ", CUST_STATE='" + CUST_STATE + '\'' +
                ", CUST_COUNTRY='" + CUST_COUNTRY + '\'' +
                ", CUST_ZIP='" + CUST_ZIP + '\'' +
                ", CUST_PHONE=" + CUST_PHONE +
                ", CUST_EMAIL='" + CUST_EMAIL + '\'' +
                '}';
    }
}
