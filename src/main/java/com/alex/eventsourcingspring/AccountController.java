package com.alex.eventsourcingspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AccountController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountEventsRepository accountEventsRepository;

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable int id) {
        return accountsRepository.getOne(id);
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody CreateAccountCommand createAccountCommand) {
        Account account = createAccountCommand.getAccount();

        accountsRepository.save(account);
        accountEventsRepository.save(new AccountEvent(AccountEventType.PENDING));
        return account;
    }

    @PatchMapping("/accounts/{id}/activate")
    public Account activateAccount(@PathVariable int id) {
        Account account = accountsRepository.getOne(id);

        AccountStatus status = account.getAccountStatus();
        if(status == AccountStatus.PENDING) {
            account.setAccountStatus(AccountStatus.ACTIVE);
            accountEventsRepository.save(new AccountEvent(AccountEventType.ACTIVE, account.getAccountNum()));
        }

        return account;
    }

}
