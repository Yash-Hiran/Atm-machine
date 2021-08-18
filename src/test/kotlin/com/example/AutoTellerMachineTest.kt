package com.example

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe


class AutoTellerMachineTest: StringSpec({
    "should print a receipt if money is withdrawn successfully" {
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(true)
        AutoTellerMachine(fakePrinter, fakeBankingService).withdraw(100)
        fakePrinter.message shouldBe "100 withdrawn successfully"
    }

    "should call banking service " {
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(true)
        AutoTellerMachine(fakePrinter, fakeBankingService).withdraw(100)
        fakeBankingService.amountWithDrewed shouldBe 100
    }

    "should return an exception if banking service throws an exception" {
        val fakePrinter = FakePrinter()
        val fakeBankingService = FakeBankingService(false)
        AutoTellerMachine(fakePrinter, fakeBankingService).withdraw(100)
        fakePrinter.message shouldBe "error withdrawing amount"
    }
})