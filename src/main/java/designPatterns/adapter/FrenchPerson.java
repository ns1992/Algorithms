package designPatterns.adapter;

/**
 * A third party owned French version of the person interface
 */
public interface FrenchPerson {
    /**
     * French version of get name
     */
    String getNom();

    /**
     * French version of get work
     */
    String getTravail();
}
