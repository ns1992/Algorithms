package designPatterns.adapter;

/**
 * Our version of the person interface - incompatible with the Fench version (without an adaptor)
 */
public interface Person {
    String getName();
    String getWork();
}
