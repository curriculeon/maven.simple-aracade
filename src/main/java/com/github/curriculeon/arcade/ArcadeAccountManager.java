package com.github.curriculeon.arcade;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {
    private static final List<ArcadeAccount> arcadeAccountList = new ArrayList<>();;

    public ArcadeAccountManager() {}

    /**
     * @param accountName name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        Comparator<ArcadeAccount> areSame = Comparator.comparing(ArcadeAccount::getAccountName)
                                                      .thenComparing(ArcadeAccount::getAccountPassword);
        ArcadeAccount currentPlayer = new ArcadeAccount(accountName, accountPassword);
        System.out.println(arcadeAccountList);
        for (ArcadeAccount arcadeAccount : arcadeAccountList) {
            if(areSame.compare(arcadeAccount, currentPlayer) == 0) {
                return arcadeAccount;
            }
        }
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     * @param accountName name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword) {
         return new ArcadeAccount(accountName, accountPassword);
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        arcadeAccountList.add(arcadeAccount);
    }
}
