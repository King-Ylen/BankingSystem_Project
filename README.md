# Explanation ni Pogi
# BankAccount.java
sa class na to dito mo makikita yung method natin kung pano mangyayari yung deposit and withdraw.
gumamit tayo ng encapsulation para ma private yung Account Number, Owner, and Balance.
gumawa rin tayo ng getter method para makuha yung mga naka private.

# SavingsAccount.java
sa class na to gumamit na tayo ng inheritance ginamit natin yung extend para iconnect yung dalawa BankAccount atsaka SavingsAccount.
and then andito yung constractor natin para sa SavingsAccount Line 5.
nag add nalang ako ng Interest para goods.

# Main.java
sa main andito lahat ng function.
gumamit tayo ng scanner atsaka arraylist para ilista yung mga account.

Line 6 - eto yung structure ng SavingsAccount dito maisstore yung mga ilalagay na account.
Line 21 - gumamit tayo ng do-while loop para iloop yung mga choices
Line 33 - choice 1 if pinili is 1. Andiyan naman yung mga itatanong tignan mo nalang.
Line 49 - choice 2 if pinili is 2. dito ilalagay mo yung nilagay mo na account number then ma-aaccess mo siya diyan na mag sisimula yung deposit or withdraw.
Line 95 - choice 3 if pinili is 3. dito ililista niya lang yung mga nagawang account.
Line 108 - choice 4 if pinili 4. exit lang to.

# Important
Mga ginamit na lesson ni sir: 
Encapsulation - nasa BankAccount
Constractor - nasa SavingsAccount
Inheritance - tatlong class ginamit mag kakaconnect