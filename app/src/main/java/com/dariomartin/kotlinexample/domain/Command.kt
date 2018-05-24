package com.dariomartin.kotlinexample.domain

/**
 * Created by megamedia on 24/5/18.
 */

public interface Command<out T> {
    fun execute(): T
}