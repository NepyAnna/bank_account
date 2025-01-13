# bank_account

     (Cuenta de ahorros):
It has an attribute to determine whether the savings account is active (type boolean). If the balance is less than $10,000, the account is inactive; otherwise, it is considered active.

The following methods are redefined:

++ Deposit: Money can be deposited only if the account is active. It must invoke the inherited method.
++ Withdraw: Money can be withdrawn only if the account is active. It must invoke the inherited method.

++ Monthly statement: If the number of withdrawals exceeds 4, an additional fee of $1,000 is charged for each extra withdrawal. When the statement is generated, it determines whether the account is active based on the balance.

++A new method, print, which returns the account balance, monthly fee, and the number of transactions (sum of deposits and withdrawals).



Current Account (Cuenta corriente):
++ It has an overdraft attribute, which is initialized to zero.

The following methods are redefined:

++ Withdraw: Money is withdrawn from the account, updating its balance. It is possible to withdraw an amount greater than the balance. The excess amount becomes an overdraft.

++ Deposit: Invokes the inherited method. If there is an overdraft, the deposited amount reduces the overdraft.

Monthly statement: Invokes the inherited method.

++ A new method, print, which returns the account balance, monthly fee, the number of transactions (sum of deposits and withdrawals), and the overdraft amount.
