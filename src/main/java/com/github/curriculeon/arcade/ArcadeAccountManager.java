package com.github.curriculeon.arcade;

import com.github.curriculeon.Arcade;
import com.github.curriculeon.utils.AnsiColor;
import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {
    IOConsole console = new IOConsole(AnsiColor.YELLOW);
    String accountName;
    String accountPassword;
    List<ArcadeAccount> arcadeAccountList = new ArrayList<>();

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        for (int i = 0; i < arcadeAccountList.size(); i++) {
            ArcadeAccount account = arcadeAccountList.get(i);
            if (accountName.equals(account.getAccountName())
                    && accountPassword.equals(account.getAccountPassword())){
                return account;
            }

        }
        return null;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        ArcadeAccount arcadeAccount = new ArcadeAccount(accountName, accountPassword);
        return arcadeAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        arcadeAccountList.add(arcadeAccount);
    }
}
