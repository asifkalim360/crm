package com.enterpriseflow.constant; 


public class AppConstants {

    // ======================== USER MESSAGES ==============================
	
	// public static final -> constant value hoti hai jo change nahi hoti
	// private constructor -> class ka object banne se rokta hai
	// constants ko centralize karna clean architecture ka part hai
	// hardcoded string multiple jagah likhna avoid karte hain


    public static final String USER_REGISTER_SUCCESS =
            "User registered successfully. Please verify your email.";

    public static final String EMAIL_ALREADY_EXISTS =
            "Email already exists.";

    public static final String ACCOUNT_VERIFIED =
            "Account verified successfully.";

    public static final String INVALID_TOKEN =
            "Invalid verification token.";

    public static final String TOKEN_EXPIRED =
            "Verification token expired.";

    private AppConstants() {
    	// is class ka object banne se rokne ke liye private constructor
    }
}
