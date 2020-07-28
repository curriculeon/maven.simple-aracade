package com.github.curriculeon.arcade;

import com.github.curriculeon.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class ArcadeAccountManager {

    private List<ArcadeAccount> arcadeAccountList;
    /**
     * @param accountName name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount getAccount(String accountName, String accountPassword) {
        //return null;
        ArcadeAccount newArcadeAccount = createAccount(accountName, accountPassword);
        registerAccount(newArcadeAccount);
        return newArcadeAccount;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     * @param accountName name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public ArcadeAccount createAccount(String accountName, String accountPassword) {
        //return null;
        ArcadeAccount newArcadeAccount = new ArcadeAccount(accountName, accountPassword);
        IOConsole console = new IOConsole();
        console.println("New Account created successfully!");
        return newArcadeAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     * @param arcadeAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(ArcadeAccount arcadeAccount) {
        if(this.arcadeAccountList == null) {
            arcadeAccountList = new ArrayList<>();
        }
        arcadeAccountList.add(arcadeAccount);
    }
}
