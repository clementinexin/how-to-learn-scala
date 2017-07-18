package functionalthinking.ch4

/**
 * Created by dj on 2017/7/17.
 */
class ClassfierCachedSum {

    private sumCache = [:]

    def sumOfFactors(number) {
        if (!sumCache.containsKey(number)) {
            sumCache[number] = factorsOf(number).sum()
        }
        return sumCache[number]
    }

    def factorsOf(number) {
        return (1..number).findAll {number % it == 0}
    }

    def isPerfect(number) {
        number == sumOfFactors(number) - number
    }

    def isAbundant(number) {
        number > sumOfFactors(number) - number
    }

    def isDeficient(number) {
        number < sumOfFactors(number) - number
    }


}
