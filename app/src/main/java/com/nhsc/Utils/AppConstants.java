package com.nhsc.Utils;


import java.util.HashMap;

/**
 * Created by emb-ganegor on 19/5/17.
 */

public class AppConstants {

    //permissions
    public static final int ON_ALLOW_M_PERMISSIONS = 3;
    public static final int ON_ALLOW_SETTING = 2;
    public static final int ON_REQUEST_CAMERA = 4;

public static HashMap<String ,Object> registrationValues=new HashMap<>();


    //Endpoints
    public static final String LOGIN_USER = "webservice/loginuser";
    public static final String LOGIN_USER_WITH_OTP = "webservice/loginotp";
    public static final String FORGOT_OTP = "webservice/forgetotp";
    public static final String OTP_REGISTER = "webservice/registerotp";
    public static final String VERIFY_OTP = "webservice/verifyotp";
    public static final String SOCIAL_LOGIN = "webservice/sociallogin";
    public static final String REGISTER = "webservice/register";
    public static final String RESET_PASSWORD = "webservice/changepassword";
    public static final String SOCIAL_REGISTER = "webservice/socialregister";
    public static final String SET_STORE = "webservice/setstore";
    public static final String SET_EDIT_PROFILE = "webservice/setprofiledata";
    public static final String GET_STORE = "webservice/getstore";
    public static final String CHECK_SERVICEABILITY = "webservice/getareas";
    public static final String LOGOUT_USER = "webservice/logout";
    public static final String HOME_PAGE = "cms/homepage";
    public static final String CUSTOMER_ADDRESS_LIST = "customer/address/list";
    public static final String CUSTOMER_EDIT_ADDRESS_LIST = "customer/address/edit";
    public static final String CUSTOMER_VALID_PINCODE = "customer/address/pincodevalidate";
    public static final String DELETE_CUSTOMER_ADDRESS_LIST = "customer/address/delete";
    public static final String PDP_PAGE = "catalog/product/view?sku=";
    public static final String GET_KITCHEN_MAIN_PAGE_DATA = "spencerkitchen/getkitchenmainpagedata";
    public static final String GET_RECIPE_PREPARE_STEPS = "spencerkitchen/getrecipepreparesteps?sku=";
    public static final String GET_KITCHEN_SUB_MAIN_DATA = "spencerkitchen/getkitchenmainpagesubdata";
    public static final String PDP_ASSOCIATED_PRODUCTS = "catalog/product/getassociatedproducts";
    public static final String GET_SHOPPING_LIST = "webservice/getshoppinglist";
    public static final String GET_LOCK_UNLOCK = "webservice/lockunlock";
    public static final String SAVE_SHOPPING_LIST = "webservice/saveshoppinglist";
    public static final String DELETE_SHOPPING_LIST = "webservice/deleteshoppinglist";
    public static final String BUY_SHOPPING_LIST = "webservice/buylistitems";
    public static final String GET_SUBSCRIPTION_DELIVERY_SLOT = "subscription/getdeliveryslot";
    public static final String GET_NEAREST_STORE = "webservice/getneareststore";
    public static final String GET_STORE_DETAILS = "webservice/getstoredetails";
    public static final String SET_SUBSCRIPTION_INFO = "subscription/setsubscriptioninfo";
    public static final String GET_SHOPPING_LIST_DATA = "webservice/getshoppinglistdata";
    public static final String ADD_PRODUCT_TO_SHOPPING_LIST = "webservice/addproducttolist";
    public static final String DELETE_PRODUCT_FROM_SHOPPING_LIST = "webservice/deleteitemfromlist";
    public static final String UPDATE_QUANTITY_SHOPPING_LIST = "webservice/updatelistitemqty";
    public static final String CART_DETAIL = "checkout/cart/cartdetails";
    public static final String APPLY_COUPON = "checkout/cart/applycouponcode/?coupon_code=";
    public static final String GET_COUPON = "checkout/cart/couponcodes";
    public static final String REMOVE_COUPON = "checkout/cart/removecouponcode/?coupon_code=";
    public static final String CATEGORY_LANDING_PAGE = "catalog/getcategoryinfo";
    public static final String CATEGORY_BANNER = "catalog/getcategorybanner";
    public static final String GUEST_TOKEN = "integration/guest/token";
    public static final String SEARCH_AREAS = "webservice/getsearch";
    public static final String GET_CATEGORIES = "catalog/getcategory";
    public static final String WRITE_REVIEW = "catalog/product/writereview";
    public static final String WRITE_REVIEW_FOR_TIPS = "blog/writereview";
    public static final String GET_REVIEW = "catalog/product/getreviews";
    public static final String GET_TIPS = "blog/getreviews";
    public static final String NOTIFY_ME = "catalog/product/notifyme";
    public static final String ALTERNATE_PRODUCTS = "catalog/product/getalternatives";
    public static final String ADD_TO_CART = "checkout/cart/additem";
    public static final String UPDATE_CART_QUANTITY = "checkout/cart/updateitem";
    public static final String DELETE_CART_ITEM = "checkout/cart/deleteitem";
    public static final String CART_BADGE = "checkout/cart/cartbatch";
    public static final String GET_ONLY_SHOPPING_LIST = "webservice/getshoppinglistarray";
    public static final String CREATE_AND_ADD_ITEM_SHOPPING_LIST = "webservice/quicksaveshoppinglist";
    public static final String SEARCH_RESULT = "catalogsearch/search";
    public static final String SEARCH_SHOPPING_LIST = "webservice/searchproductsforlist";
    public static final String ADD_TO_SHOPPING_LIST = "webservice/addtoshoppinglist";
    public static final String DELETE_PRODUCT_SHOPPING_LIST = "webservice/quickdeleteitemfromlist";
    public static final String SEARCH_PRODUCT_OFFLINE = "catalogsearch/searchoffline";
    public static final String SUBMIT_OFFLINE_PRODUCT = "catalogsearch/searchofflinerequest";
    public static final String GET_RECENT_ADDRESS = "checkout/address/recent";
    public static final String CHECK_SERVICEABILITY_ADDRESS = "checkout/cart/storevalidate";
    public static final String STORE_MISMATCH = "checkout/cart/storemismatch";
    public static final String STORE_SWITCH = "checkout/cart/storeswitch";
    public static final String DELETE_RECENT_ADDRESS = "checkout/address/recentdelete";
    public static final String EDIT_RECENT_ADDRESS = "checkout/address/recentedit";
    public static final String GET_DELIVERY_SLOT = "checkout/cart/getdeliveryslot";
    public static final String SET_DELIVERY_SLOT = "checkout/cart/setdeliveryslot";
    public static final String CHANGE_PASSWORD = "customer/changepassword";
    public static final String GET_SUB_CATEGORY = "spencerkitchen/getrecipesubcategories";
    public static final String GET_RECIPE_LIST = "spencerkitchen/getrecipelisting";
    public static final String USER_RECIPES = "spencerkitchen/getuserrecipes?page_number=";
    public static final String PROFILE_RECIPES = "spencerkitchen/getprofilerecipes?page_number=";
    public static final String USER_FAVOURITES_RECIPES = "spencerkitchen/getuserfavouritesrecipes?page_number=";
    public static final String PROFILE_FAVOURITES_RECIPES = "spencerkitchen/getprofilefavouritesrecipes?page_number=";
    public static final String GET_FOLLOWERS = "customer/getfollowers?page=";
    public static final String GET_GUEST_FOLLOWERS = "customer/getguestfollowers?page=";
    public static final String GET_FOLLOWING = "customer/getfollowing?page=";
    public static final String GET_GUEST_FOLLOWING = "customer/getguestfollowing?page=";
    public static final String GET_FOLLOW_ACTION = "customer/followaction?customerId=";
    public static final String DELETE_RECIPES = "spencerkitchen/deleterecipe?sku=";
    public static final String GET_POPULAR_TIPS = "blog/getpopulartips";
    public static final String GET_ALL_TIPS = "blog/getalltips?pageNumber=";
    public static final String GET_TIP_DETAIL = "blog/gettipdetail";
    public static final String GET_RELATED_TIP_INFO = "blog/getrelatedinfo";
    public static final String GET_COUPONS = "webservice/getofferslist?type=Coupons&pageSize=";
    public static final String GET_OFFERS_LIST = "webservice/getofferslist";
    public static final String GET_OFFERS_BANNERS = "webservice/getofferbanner";
    public static final String GUEST_PROFILE = "webservice/getguestprofile?customerid=";
    public static final String SET_DELIVERY_ADDRESS = "checkout/cart/setaddress";
    public static final String GET_RECIPES_DETAIL = "spencerkitchen/getrecipedetail?sku=";
    public static final String GET_RECIPES_BOTTOM_DETAIL = "spencerkitchen/getrecipeotherdetail?sku=";
    public static final String GET_RECIPE_INGREDIENTS = "spencerkitchen/getrecipeingredients";
    public static final String MANAGE_SERVE = "spencerkitchen/manageserve";
    public static final String BUY_INGREDIENTS ="spencerkitchen/buyingredients";
    public static final String ADD_INGREDIENTS_SHOPPING_LIST ="spencerkitchen/addingredientstolist";
    public static final String SHARED_WITH_ME ="webservice/sharedwithme";
    public static final String UNMAP_LIST ="webservice/unmaplist";
    public static final String GET_SUBSCRIBE_SHOPPING_LIST ="webservice/getsubscribeshoppinglist";
    public static final String GET_UNSUBSCRIBE_SHOPPING_LIST ="webservice/unsubscribeshoppinglist";
    public static final String CREATE_SHOPPING_LIST_WITH_QUERY ="spencerkitchen/addingredientstonewlist";
    public static final String ADD_OR_REMOVE_RECIPE_FROM_FAVOURITE ="spencerkitchen/addtowishlist";
    public static final String ADD_OR_REMOVE_TIPS ="blog/addtofavouritetip";
    public static final String GET_PAYMENT ="checkout/cart/payment";
    public static final String PROCESS_WALLET ="checkout/cart/walletprocess";
    public static final String PLACE_ORDER ="checkout/cart/placeorder";
    public static final String ORDER_COMPLETE = "checkout/cart/ordercomplete";
    public static final String VALIDATE_PINCODE ="checkout/cart/storevalidatebypincode";
    public static final String GET_STORES = "checkout/cart/getstores/";
    public static final String SET_STORE_ADDRESS = "checkout/cart/setstoreaddress";
    public static final String GET_WALLET_INFO = "checkout/cart/getwalletinfo";
    public static final String GET_WALLET_HISTORY ="checkout/cart/getwallethistory";
    public static final String GET_TRENDING_SEARCH = "catalogsearch/gettrendingsearch";
    public static final String PRODUCT_SEARCH = "catalogsearch/ajaxsearch";
    public static final String GET_WALLET_PAYMENT = "checkout/cart/walletpayment";
    public static final String PLACE_WALLET_ORDER = "checkout/cart/walletplaceorder";
    public static final String WALLET_ORDER_COMPLETE = "checkout/cart/walletordercomplete";
    public static final String GET_ALL_ORDER_HISTORY = "sales/getallorderlist";
    public static final String GET_RECENT_ORDER_HISTORY = "sales/getrecentorderlist";
    public static final String GET_CANCEL_ORDER_HISTORY = "sales/getcancelorderlist";
    public static final String GET_ORDER_DETAILS ="sales/getorderdetails";
    public static final String GET_GLOBAL_RECOMMENDATION ="catalogsearch/getGlobalRecommendation";
    public static final String CANCEL_ORDER ="sales/cancelorder";
    public static final String EDIT_ORDER = "sales/editorder";
    public static final String REORDER = "sales/reorder ";
    public static final String FEEDBACK = "sales/orderfeedback";
    public static final String GET_FEEDBACK_TYPES = "sales/getfeedbacktypes";
    public static final String GET_GIFT_CARD_DENOMINATIONS ="giftcard/getdenomination";
    public static final String GET_GC_PAYMENT = "giftcard/giftcardwalletpayment";
    public static final String PLACE_GC_ORDER ="giftcard/giftcardplaceorder";
    public static final String GC_ORDER_COMPLETE ="giftcard/giftcardordercomplete";
    public static final String SUBSCRIPTION_STORE_VALIDATE ="subscription/storevalidate";
    public static final String SUBSCRIPTION_STORE_MISMATCH = "subscription/storemismatch";
    public static final String SUBSCRIPTION_STORE_SWITCH = "subscription/storeswitch";
    public static final String SET_SUBSCRIPTION_DELIVERY_ADDRESS = "subscription/setaddress";
    public static final String GET_SUBSCRIPTION_SUMMARY = "subscription/getsubscriptioninfo";
    public static final String CREATE_SUBSCRIPTION = "subscription/createsubscription";
    public static final String REDEEM_GIFT_CARD ="giftcard/redeem";
    public static final String DOWNLOAD_GIFT_CARD ="giftcard/giftcarddownload";
    public static final String DELETE_SUBSCRIBED_SHOPPING_LIST ="subscription/deletesubscriptionlist";
    public static final String GET_GIFT_CARD_HISTORY ="giftcard/getgiftcardhistory";
    public static final String GET_DYNAMIC_DROP_DOWN_VALUES = "spencerkitchen/getdynamicdropdownvalues";
    public static final String CREATE_RECIPE = "spencerkitchen/createrecipe";
    public static final String UPLOAD_IMAGE = "spencerkitchen/imageupload";
    public static final String SEARCH_INGREDIENTS ="spencerkitchen/getingredientsproduct";
    public static final String PUBLISH_RECIPE="spencerkitchen/publishrecipe";
    public static final String GET_NOTIFICATION_OFFERS ="webservice/getofferslist";
    public static final String GET_NOTIFICATION_ALERTS ="notifications/getnotifications";
    public static final String GET_NOTIFICATION_ORDER_ALERTS ="notifications/getordernotifications";
    public static final String GET_RECIPE_DATA = "spencerkitchen/populaterecipedata";
    public static final String DELETE_NOTIFICATION_ALERTS ="notifications/deletenotification";
    public static final String UPLOAD_TIP_IMAGE ="blog/imageupload";
    public static final String CREATE_TIP ="blog/createtip";
    public static final String GET_SUBSCRIPTION_TYPE = "newsletter/getsubscriptiontype";
    public static final String UPDATE_SUBSCRIPTION = "newsletter/updatesubscription";
    public static final String SET_FCM_TOKEN ="webservice/setdeviceregistrationid";
    public static final String GET_RECOMMENDATIONS ="recommendations/getrecommendedproducts";
    public static final String SEARCH_BLOG = "catalogsearch/searchblog";
    public static final String GET_PROMO_HISTORY ="rewards/mine/getpromohistory";
    public static final String CHECK_COMPATIBILITY = "webservice/versionCheckmobile";
    public static final String GET_PROMOTIONS ="webservice/getofferdeatils";

    //Methods
    public static final String METHOD_LOGIN = "login";
    public static final String METHOD_OTP_REGISTER = "registerotp";
    public static final String METHOD_VERIFY_OTP = "verifyotp";
    public static final String METHOD_REGISTER = "register";
    public static final String METHOD_HOME_PAGE = "homepage";
    public static final String METHOD_FORGOT_PASSWORD = "forget_password";
    public static final String METHOD_FORGOT_OTP = "forgetotp";
    public static final String METHOD_SOCIAL_LOGIN = "sociallogin";
    public static final String METHOD_CHANGE_PASSWORD = "changepassword";


    //Keys
    public static final String KEY_ACTION = "action";
    public static final String KEY_USER_NAME = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NEW_PASSWORD = "newpassword";
    public static final String KEY_PAGE = "page";
    public static final String KEY_CUSTOMER_ID = "customer_id";
    public static final String KEY_SHARED_WITH_ME = "customer_id";
    public static final String KEY_REMOVE = "remove";
    public static final String KEY_PRODUCT = "product";
    public static final String KEY_MOBILE_NUMBER = "mobile";
    public static final String KEY_ITEM = "item";


    public static final String KEY_STATUS = "status";
    public static final String KEY_STATUS_SUCCESS = "success";
    public static final String KEY_STATUS_FAILURE = "failure";
    public static final String KEY_DATA = "data";
    public static final String KEY_MESSAGE = "message";

    public static final String KEY_NAME = "name";
    public static final String KEY_OTP = "otp";
    public static final String KEY_EXPIRY_TIME = "expirytime";
    public static final String KEY_BEARER_TOKEN = "token";

    public static final String KEY_ENROLL = "enroll";

    public static final String KEY_FACEBOOK = "facebook";
    public static final String KEY_GOOGLE = "google";

    public static final String KEY_STORE_CODE = "store_code";
    public static final String KEY_PINCODE_AREA = "pincode_area";
    public static final String KEY_PINCODE_CITY = "pincode_city";

    public static final String KEY_CONSUMER_KEY = "consumer_key";
    public static final String KEY_DEVICE_ID = "device_id";
    public static final String KEY_CHANGE_LOCATION = "change_location";

    public static final String KEY_CATEGORY_ID = "catId";
    public static final String KEY_KEYWORD = "keyword";
    public static final String KEY_PRODUCT_SKU = "product_sku";

    public static final String KEY_TITLE = "title";
    public static final String KEY_TIP = "tip";
    public static final String KEY_SKU = "sku";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_RATING = "rating";
    public static final String KEY_ITEM_ID = "item_id";
    public static final String KEY_LIST_ID = "listId";
    public static final String KEY_LIST_NAME = "listName";
    public static final String KEY_PRODUCT_ID = "productId";
    public static final String KEY_ADDRESS_ID = "address_id";
    public static final String KEY_USER_ADDRESS = "Address";
    public static final String KEY_FIRST_NAME = "firstname";
    public static final String KEY_STREET1 = "street1";
    public static final String KEY_STREET2 = "street2";
    public static final String KEY_CITY = "city";
    public static final String KEY_REGION = "region";
    public static final String KEY_TELEPHONE = "telephone";
    public static final String KEY_DELIVERY_ADDRESS_TYPE = "delivery_address_type";
    public static final String KEY_DEFAULT_ADDRESS = "default_address";
    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;
    public static final String DB_NAME = "";
    public static final String PREF_NAME = "pref";
    public static final long NULL_INDEX = -1L;
    public static final String SEED_DATABASE_OPTIONS = "";
    public static final String SEED_DATABASE_QUESTIONS = "";
    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";
    public static final String OTP_TIMER_FORMAT = "%02d:%02d";
    public static final String KEY_PINCODE = "pincode";
    public static final String VALIDATE_PINCODE_URL = "pincode/getstore/";
    public static final String SEARCH_BY_KEYWORD_URL = "pincode/searchbykeyword/";
    public static final String SEARCH_BY_KEYWORD = "searchbykeyword";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_QUANTITY = "qty";
    /* */
    public static final String API_MESSAGE = "message";
    public static final String APPLICATION_JSON = "application/json; charset=utf-8";
    public static final String SEARCH_TAG = "search";
    public static final String ERROR_MSG = "Something went wrong...";
    public static final String GET_AREA = "getareas";
    public static final String STORE_ID_KEY = "storeId";
    public static final String METHOD_SOCIALLOGIN = "sociallogin";
    public static final String KEY_IDENTIFIER = "identifier";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_TYPE = "type";
    public static final String KEY_START_DATE = "startdate";
    public static final String KEY_END_DATE = "enddate";
    public static final String KEY_ID = "id";
    public static final String KEY_IS_SUGGESTED = "is_suggested";
    public static final String GET_PROFILE = "webservice/getprofile";
    public static final String USER_TIPS = "blog/getmytips";
    public static final String DELETE_TIP = "blog/deletetip";
    public static final String GET_MY_FAVOURITES_TIPS = "blog/getmyfavouritetips";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_STORE = "store";
    public static final String TYPE_MOBILE = "mobile";
    public static final String TYPE_EMAIL = "email";
    public static final String FORGOT_EMAIL_SUCCESS = "Link Sent Successfully";
    public static final String LOADING_MSG = "Loading...";
    public static final String TAG_SIGNIN = "SIGNIN";
    public static final String TAG_SIGNUP = "SIGNUP";
    public static final String DEFAULT = "default";
    public static final String WELCOME_TITLE = "Welcome";
    public static final String IS_COMING_FROM_THANKYOU_PAGE = "is_coming_from_thank_you_page";
    //price Unit
    public static final String PRICE_UNIT = "\u20B9";
    //Errors
    public static final String ERROR_NEW_USER = "registration_required";
    //categroy
    public static final String POSITION = "position";
    public static final String CATEGORIES = "Categories";
    public static final String TYPE_CATEGORY = "Category";
    public static final String SPENCERS_GIFTCARD = "spencers_giftcard";

    public static final String TYPE_PRODUCT = "Product";
    //Preferences Keys
    public static final String IS_WELCOME_SCREEN_SHOWN = "welcome_screens";
    //Broadcast
    public static final String CART_COUNT_BROADCAST = "com.count_brodCast";
    public static final byte ALL_SEARCH_RESULT_TYPE = 0x01;
    public static final byte RECIPE_SEARCH_RESULT_TYPE = 0x02;
    public static final byte PRODUCT_SEARCH_RESULT_TYPE = 0x03;
    public static final byte BLOG_SEARCH_RESULT_TYPE = 0x04;

    public static final String KEY_BROWSE_CATEGORIES = "browse_categories";
    public static final String KEY_SPENCERS_KITCHEN = "spencers_kitchen";
    public static final String KEY_LATEST_OFFERS = "latest_offers";
    public static final String KEY_EXPERT_CORNER = "expert_corner";
    public static final String KEY_CART_DATA= "cart_data";
    public static final String KEY_SHOPPING_LIST = "shopping_list";
    public static final String KEY_SMART_REWARDS = "smart_rewards";
    public static final String KEY_SPENCERS_WALLET = "spencers_wallet";
    public static final String AUTO_UPDATE_TIME = "auto_update_time_event";
    public static final String KEY_RECIPE = "recipe";
    public static int KEY_PDP_BANNERS = 1;
    public static int KEY_PDP_PRODUCT_DETAILS = 2;
    public static int KEY_PDP_OFFER = 3;
    public static int KEY_PDP_DESCRIPTION = 4;
    public static int KEY_PDP_BUNDLE = 10;
    public static int KEY_PDP_REVIEW = 5;
    public static int KEY_PDP_SIMILAR_PRODUCTS = 6;
    public static int KEY_PDP_RELATED_VIDEOS = 7;

    //Payment Key
    public static final String PAYMENT_KEY = "payment_type";

    //Payment Types
    public static final int CART_PAYMENT = 1;
    public static final int WALLET_PAYMENT = 2;
    public static final int GIFT_CARD_PAYMENT = 3;

    public static final int PAYMENT_REQUEST = 200;

    public static final int PAYMENT_FAILED_RESULT_CODE = 404;
    public static final int PAYMENT_SUCCESS_RESULT_CODE = 400;

    public static final int ORDER_REQUEST_CODE = 201;
    public static final int CANCEL_ORDER_SUCCESS_REUSLT_CODE = 400;
    public static final int EDIT_ORDER_SUCCESS_RESULT_CODE = 401;
    public static final int REORDER_SUCCESS_RESULT_CODE = 402;

    public static final int REQ_CODE_SPEECH_INPUT = 100;

    public static final int EDIT_RECIPE_REQUEST_CODE = 202;
    public static final int EDIT_RECIPE_RESULT_CODE = 400;

    public static final int EDIT_TIP_REQUEST_CODE = 203;
    public static final int EDIT_TIP_RESULT_CODE = 400;

    public static final String REDIRECT_URL = "redirect_url";


    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
