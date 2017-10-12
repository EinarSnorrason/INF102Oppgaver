package alg.symbolTables;

import java.util.Iterator;

/**
 * Created by Einar Snorrason on 11/10/2017.
 */
public interface ISymbolTable <Key extends Comparable<? super Key>, Value> extends Iterable<Key> {
    int size();
    Value get(Key key);
    void put(Key key, Value value);
}
