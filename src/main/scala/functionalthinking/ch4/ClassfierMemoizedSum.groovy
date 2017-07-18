package functionalthinking.ch4

/**
 * Created by dj on 2017/7/17.
 */
class ClassfierMemoizedSum {

    def static isFactor(number,it) {
        number % it == 0
    }

    def static factorsOf(number) {
        (1..number).find {isFactor(number,it)}
    }

    def static sumFactors = {
        number -> factorsOf(number).inject {i,j -> i+j}
    }

    def static sumOfFactors = sumFactors.memoize()

    def static isPerfect(number) {
        sumOfFactors(number) == 2 * number
    }

    def static  isAbundant(number) {
        sumOfFactors(number) > 2 * number
    }

    def static isDeficient(number) {
        sumOfFactors(number) < 2 * number
    }

}
