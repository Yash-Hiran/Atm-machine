package com.example

class AutoTellerMachine(val printer : Printer, val bankingService: BankingService) {
    fun withdraw(amount: Int) {
        try {
            bankingService.withdraw(amount)
            printer.print("$amount withdrawn successfully")
        }catch (exception : Exception){
            printer.print("error withdrawing amount")
        }
    }
}