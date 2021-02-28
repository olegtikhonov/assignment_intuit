package com.intuit.home.strategy;

/**
 * Defines an interface for analysis
 * @param <T> return type
 * @param <V> gotten type
 */
public interface RiskAnalysis<T, V> {
    public T performAnalysis(V dataToBEAnalyzed);
}
