## ✨ Features

### Account Operations
- ✅ **Create new accounts** with account number, holder name, and initial deposit
- 💰 **Deposit funds** into any existing account
- 💸 **Withdraw funds** with balance validation (prevents overdrafts)
- 🔍 **Check current balance** for any account

### Transaction Tracking
- 📜 **Complete transaction history** with timestamps for all operations
- ⏱️ **Automatic timestamping** for deposits, withdrawals, and account creation

### Data Management
- 💾 **Automatic data persistence** using binary file storage (`accounts.dat`)
- 🔄 **Data loading** on program startup maintains account continuity

### Error Handling
- 🛡️ **Custom exceptions** for insufficient funds scenarios
- ⚠️ **Input validation** for all monetary transactions