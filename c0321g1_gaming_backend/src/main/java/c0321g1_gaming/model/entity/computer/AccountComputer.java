package c0321g1_gaming.model.entity.computer;

import c0321g1_gaming.model.entity.security.Account;

import javax.persistence.*;

@Entity
public class AccountComputer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountComputerId;
    private String timeUsed;
    private String timeLogin;
    private String timeLogout;
    @ManyToOne
    @JoinColumn(name = "computerId",referencedColumnName = "computerId")
    private Computer computer;
    @ManyToOne
    @JoinColumn(name = "accountId",referencedColumnName = "accountId")
    private Account account;

    public AccountComputer() {
    }

    public AccountComputer(Long accountComputerId, String timeUsed, String timeLogin, String timeLogout, Computer computer, Account account) {
        this.accountComputerId = accountComputerId;
        this.timeUsed = timeUsed;
        this.timeLogin = timeLogin;
        this.timeLogout = timeLogout;
        this.computer = computer;
        this.account = account;
    }

    public Long getAccountComputerId() {
        return accountComputerId;
    }

    public void setAccountComputerId(Long accountComputerId) {
        this.accountComputerId = accountComputerId;
    }

    public String getTimeUser() {
        return timeUsed;
    }

    public void setTimeUser(String timeUsed) {
        this.timeUsed = timeUsed;
    }

    public String getTimeLogin() {
        return timeLogin;
    }

    public void setTimeLogin(String timeLogin) {
        this.timeLogin = timeLogin;
    }

    public String getTimeLogout() {
        return timeLogout;
    }

    public void setTimeLogout(String timeLogout) {
        this.timeLogout = timeLogout;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
