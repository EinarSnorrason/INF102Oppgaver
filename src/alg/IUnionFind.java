package alg;

/**
 * Interface that creates a list of nodes and allows them to be connected into components
 */
public interface IUnionFind {

    /**
     * @return number of components
     */
    int count();

    /**
     * Checks whether two integers are part of the same component
     * @param p
     * @param q
     * @return true if part of same component, false else
     */
    boolean connected(int p, int q);

    /**
     * Finds which component given integer belongs to (if any)
     * @param p
     * @return
     */
    public int find(int p);

    /**
     * Connects two integers
     * @param p
     * @param q
     */
    public void union(int p, int q);
}
