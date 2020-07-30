package com.github.curriculeon.arcade;

import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {
    private final static ArcadeAccountManager instance = new ArcadeAccountManager();
    private static final List<ArcadeAccount> arcadeAccountList = new ArrayList<>();
    private static IOConsole console = new IOConsole(AnsiColor.CYAN);

    private ArcadeAccountManager() {}
    public static ArcadeAccountManager getInstance() {
        return instance;
    }

    /**
     * @param accountName name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        Comparator<ArcadeAccount> compareArcadeAccount = Comparator.comparing(ArcadeAccount::getAccountName)
                                                                   .thenComparing(ArcadeAccount::getAccountPassword);
        ArcadeAccount comparingArcadeAccount = new ArcadeAccount(accountName, accountPassword);
        for (ArcadeAccount arcadeAccount : arcadeAccountList) {
            if(compareArcadeAccount.compare(arcadeAccount, comparingArcadeAccount) == 0) {
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
        console.println("%s account was created, the password is %s.", accountName, accountPassword);
         return new ArcadeAccount(accountName, accountPassword);
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        arcadeAccountList.add(arcadeAccount);
        console.println("The player %s was added to the list.", arcadeAccount.getAccountName());
    }
}
