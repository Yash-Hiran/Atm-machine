package com.example

class FakeBankingService(val isValidTrasaction : Boolean) : BankingService{
    var amountWithDrewed : Int = 0
    override fun withdraw(amount: Int){
        if(!isValidTrasaction) throw Exception()
        amountWithDrewed = amount
    }
}