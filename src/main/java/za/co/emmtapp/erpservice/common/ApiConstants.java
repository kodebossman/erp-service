package za.co.emmtapp.erpservice.common;

public interface ApiConstants {

  String SUCCESS_MESSAGE = "Transaction Processed Successfully";
  String INSUFFICIENT_FUNDS_MESSAGE = "You have insufficient float balance to complete this operation";
  String NO_FCA_ACCOUNT_MESSAGE = "No FCA wallet account found";
  String INVALID_TOKEN = "Invalid Token";
  String VALID_TOKEN = "Valid token for user ";
  String USERNAME_OR_PASSWORD_INVALID = "Username or Password should not be empty";
  String GOOGLE_MAPS_API_KEY="";

  String APP_SUCCESS_MESSAGE = "Application Created Successfully";
  String APP_DELETE_MESSAGE = "Application Deletion Failed";

  String APP_DELETE_MESSAGE_SUCCESS= "Record Deleted Successfully";

  String APP_UPDATE_MESSAGE = "Updated Successfully";
  String APP_RETRIEVE_SUCCESS = "OK";
  int UPDATE_SUCCESS=204;
}
