package functionalthinking.ch4

import org.junit.Test

/**
 * Created by dj on 2017/7/17.
 */
class ClassfierTest {

    def Classfier = new ClassfierCachedSum()
    def start

    def static final TEST_NUMBER_MAX = 5000

    @Test
    void mashup() {
        println "Test for range 1-${TEST_NUMBER_MAX}"
        println "未优化:"
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (Classfier.isPerfect(n)) print '!'
            else if (Classfier.isAbundant(n)) print '+'
            else if (Classfier.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
        println "未优化第2次运行 :"
        start = System.currentTimeMillis()
        (1..TEST_NUMBER_MAX).each { n ->
            if (Classfier.isPerfect(n)) print '!'
            else if (Classfier.isAbundant(n)) print '+'
            else if (Classfier.isDeficient(n)) print '-'
        }
        println "\n\t ${System.currentTimeMillis() - start} ms"
    }
}
