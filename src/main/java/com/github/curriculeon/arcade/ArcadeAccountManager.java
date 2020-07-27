package com.github.curriculeon.arcade;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {
    private final static ArcadeAccountManager INSTANCE = new ArcadeAccountManager();
    private final Map<String,ArcadeAccount> userKeys = new HashMap<>();

    public static ArcadeAccountManager getInstance(){
        return INSTANCE;
    }

    private ArcadeAccountManager(){}
    /**
     * @param accountName name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        if (userKeys.containsKey(accountName)) {
            if (userKeys.get(accountName).getAccountPassword().equals(accountPassword))
                return userKeys.get(accountName);
        }
        System.out.println(userKeys);
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     * @param accountName name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword)
    {
        return new  ArcadeAccount(accountName,accountPassword);
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        userKeys.put(arcadeAccount.getAccountName(),arcadeAccount);

    }


}
