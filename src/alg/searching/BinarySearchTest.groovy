package alg.searching

/**
 * Created by Einar Snorrason on 04/12/2017.
 */
class BinarySearchTest extends GroovyTestCase {

    Double[] a
    int n = 10000
    Random random = new Random()

    void setUp() {
        super.setUp()
        a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextDouble();
        }
        Arrays.sort(a);

    }

    void testRank() {
        super.setUp()
        a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextDouble();
        }
        Arrays.sort(a);
    }
}