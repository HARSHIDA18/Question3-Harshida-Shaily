import scala.annotation.tailrec
class BestTimeToBuyAndSellTheStock extends App {
    def maxProfit(prices: Array[Int]): Int = {
      if (prices.isEmpty) {
        0
      } else {
        require(prices.forall(_ >= 0), "Input array should contain non-negative integers")
        @tailrec

        def maxProfitHelp(prices: List[Int], maxProfit: Int, lastBuy: Int): Int = {
          prices match {
            case Nil => maxProfit
            case head :: tail => if (head > lastBuy) {
              maxProfitHelp(tail, Math.max(maxProfit, head - lastBuy), lastBuy)
            } else {
              maxProfitHelp(tail, maxProfit, head)
            }
          }
        }
        val listPrices = prices.toList
        maxProfitHelp(listPrices.tail, 0,listPrices.head)
      }
    }
}
