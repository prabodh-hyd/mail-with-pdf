package in.prabodh.restservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MocTemplateVariables {
    private  String date_stamp;
     private String loan_app_id;
     private String user_name_variable;
     private String user_address_variable;
     private String registered_mobile_number;
    private  String Application_name;
     private String NBFC_name;
    private String tenure;
    private String product_name;
    private String type;
   private String interest;
    private String processing_fee;
    private String disburse_amount;
    private String state_name;
    private String Reason;
    private String LA_RETAIL_900000160352;
   private  String Date_of_Disbursal;
    private String NBFC_Bank_account_number;
   private String NBFC_bank_name;
    private String NBFC_bank_ifsc;



    public void initValues() {
        this.setLoan_app_id(String.valueOf(12345667));
        this.setUser_name_variable("testyuvapaypush");
        this.setUser_address_variable("address");
        this.setregistered_mobile_number("9490288244");
        this.setApplication_name("soft.tech.coine");
        this.setNBFC_name("Liqui_loans");
        this.settenure(7);
        this.setproduct_name("pro_name");
        this.settype("DEFAULT");
        this.setinterest(String.valueOf(11.00));
        this.setprocessing_fee(String.valueOf(200));
        this.setdisburse_amount(String.valueOf(4000));
        this.setstate_name(type);
        //this.setReason();
        // this.setDate_of_Disbursal();
        // this.setNBFC_bank_name();
        //this.setNBFC_bank_ifsc();
        //this.setNBFC_Bank_account_number();
        System.out.println(loan_app_id);
    }


    private void settenure(int i) {

    }
    public String getdate_stamp() {
        return date_stamp;
    }



    public void setDate_stamp(String date_stamp) {
        this.date_stamp = date_stamp;
    }

    public String getLoan_app_id() {
        return loan_app_id;
    }

    public void setLoan_app_id(String loan_app_id) {
        this.loan_app_id = loan_app_id;
    }

    public String getLA_RETAIL_900000160352() {
        return LA_RETAIL_900000160352;
    }

    public void setLA_RETAIL_900000160352(String LA_RETAIL_900000160352) {
        this.LA_RETAIL_900000160352 = LA_RETAIL_900000160352;
    }

    public String getUser_name_variable() {
        return user_name_variable;
    }

    public void setUser_name_variable(String user_name_variable) {
        this.user_name_variable = user_name_variable;
    }

    public String getstate_name() {
        return state_name;
    }

    public void setstate_name(String state_name) {
        this.state_name = state_name;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getUser_address_variable() {
        return user_address_variable;
    }

    public void setUser_address_variable(String user_address_variable) {
        this.user_address_variable = user_address_variable;
    }

    public String getregistered_mobile_number() {
        return registered_mobile_number;
    }

    public void setregistered_mobile_number(String registered_mobile_number) {
        this.registered_mobile_number = registered_mobile_number;
    }

    public String getApplication_name() {
        return Application_name;
    }

    public void setApplication_name(String application_name) {
        this.Application_name = application_name;
    }

    public String getNBFC_name() {
        return NBFC_name;
    }

    public void setNBFC_name(String NBFC_name) {
        this.NBFC_name = NBFC_name;
    }

    public String getNBFC_Bank_account_number() {
        return NBFC_Bank_account_number;
    }

    public void setNBFC_Bank_account_number(String NBFC_Bank_account_number) {
        this.NBFC_Bank_account_number = NBFC_Bank_account_number;
    }

    public String getNBFC_bank_name() {
        return NBFC_bank_name;
    }

    public void setNBFC_bank_name(String NBFC_bank_name) {
        this.NBFC_bank_name = NBFC_bank_name;
    }

    public String getNBFC_bank_ifsc() {
        return NBFC_bank_ifsc;
    }

    public void setNBFC_bank_ifsc(String NBFC_bank_ifsc) {
        this.NBFC_bank_ifsc = NBFC_bank_ifsc;
    }

    public String gettenure() {
        return tenure;
    }

    public void settenure(String tenure) {
        this.tenure = tenure;
    }

    public String getDate_of_Disbursal() {
        return Date_of_Disbursal;
    }

    public void setDate_of_Disbursal(String date_of_Disbursal) {
        Date_of_Disbursal = date_of_Disbursal;
    }

    public String getproduct_name() {
        return product_name;
    }

    public void setproduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }

    public String getinterest() {
        return interest;
    }

    public void setinterest(String interest) {
        this.interest = interest;
    }

    public String getprocessing_fee() {
        return processing_fee;
    }

    public void setprocessing_fee(String processing_fee) {
        this.processing_fee = processing_fee;
    }

    public String getdisburse_amount() {
        return disburse_amount;
    }

    public void setdisburse_amount(String disburse_amount) {
        this.disburse_amount = disburse_amount;
    }

    public void display() {
       // logger.info(this.toString());
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return "MocTemplateVariables{" +
                "date_stamp='" + date_stamp + '\'' +
                ", loan_app_id='" + loan_app_id + '\'' +
                ", user_name_variable='" + user_name_variable + '\'' +
                ", user_address_variable='" + user_address_variable + '\'' +
                ", registered_mobile_number='" + registered_mobile_number + '\'' +
                ", Application_name='" + Application_name + '\'' +
                ", NBFC_name='" + NBFC_name + '\'' +
                ", tenure='" + tenure + '\'' +
                ", product_name='" + product_name + '\'' +
                ", type='" + type + '\'' +
                ", interest='" + interest + '\'' +
                ", processing_fee='" + processing_fee + '\'' +
                ", disburse_amount='" + disburse_amount + '\'' +
                ", state_name='" + state_name + '\'' +
                ", Reason='" + Reason + '\'' +
                ", LA_RETAIL_900000160352='" + LA_RETAIL_900000160352 + '\'' +
                ", Date_of_Disbursal='" + Date_of_Disbursal + '\'' +
                ", NBFC_Bank_account_number='" + NBFC_Bank_account_number + '\'' +
                ", NBFC_bank_name='" + NBFC_bank_name + '\'' +
                ", NBFC_bank_ifsc='" + NBFC_bank_ifsc + '\'' +
                '}';
    }
    MocTemplateVariables(){

    }

}