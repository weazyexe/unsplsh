package dev.weazyexe.unsplsh.data.base

/**
 * Transformable to [T] type entity
 */
interface Transformable<T> {

    fun transform(): T
}

/**
 * Transforms a collection of [Transformable]s
 */
fun <T> Collection<Transformable<T>>.transform(): List<T> = map { it.transform() }