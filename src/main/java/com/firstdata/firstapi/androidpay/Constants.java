package com.firstdata.firstapi.androidpay;

import com.google.android.gms.wallet.WalletConstants;

public class Constants {
    // Environment to use when creating an instance of Wallet.WalletOptions
    public static final int WALLET_ENVIRONMENT = WalletConstants.ENVIRONMENT_TEST;

    public static final String MERCHANT_NAME = "First data Corporation";

    // Intent extra keys
    public static final String EXTRA_ITEM_ID = "com.firstdata.firstapi.androidpay.EXTRA_ITEM_ID";
    public static final String EXTRA_MASKED_WALLET = "com.firstdata.firstapi.androidpay.EXTRA_MASKED_WALLET";

    public static final String EXTRA_AMOUNT = "com.firstdata.firstapi.androidpay.EXTRA_AMOUNT";
    public static final String EXTRA_ENV = "com.firstdata.firstapi.androidpay.EXTRA_ENV";

    public static final String EXTRA_RESULT_STATUS = "com.firstdata.firstapi.androidpay.EXTRA_RESULT_STATUS";
    public static final String EXTRA_RESULT_MESSAGE = "com.firstdata.firstapi.androidpay.EXTRA_RESULT_MESSAGE";

    public static final String CURRENCY_CODE_USD = "USD";

    // values to use with KEY_DESCRIPTION
    public static final String DESCRIPTION_LINE_ITEM_SHIPPING = "Shipping";
    public static final String DESCRIPTION_LINE_ITEM_TAX = "Tax";

    //  Request Codes
    public static final int REQUEST_CODE_MASKED_WALLET = 1001;
    public static final int REQUEST_CODE_CHANGE_MASKED_WALLET = 1002;
}
