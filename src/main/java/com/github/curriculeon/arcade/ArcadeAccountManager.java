package com.github.curriculeon.arcade;

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
    private IOConsole console = new IOConsole(AnsiColor.YELLOW);
    private List<ArcadeAccount> arcadeAccountList = new ArrayList<>();
    /**
     * @param accountName name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        for (ArcadeAccount arcadeAccount : arcadeAccountList) {
            boolean isCorrectUser = accountName.equals(arcadeAccount.getAccountName());
            boolean isCorrectPassword = accountPassword.equals(arcadeAccount.getAccountPassword());
            boolean isValidLogin = isCorrectPassword && isCorrectUser;
            if (isValidLogin){
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
        console.println("Attempting to create new account with [%s] and password [%s]", accountName, accountPassword );
        ArcadeAccount arcadeAccount = new ArcadeAccount(accountName, accountPassword);
        console.println("Successfully created an account with name [%s] and password [%s]", accountName, accountPassword);
        return arcadeAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        arcadeAccountList.add(arcadeAccount);
    }
}
