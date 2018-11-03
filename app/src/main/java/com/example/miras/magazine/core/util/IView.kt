/*
 * Copyright (c) DAR Ecosystem 2018.
 *
 * Created by sough on 14/08/2018.
 */

package com.example.miras.magazine.core.util
/**
 * Common view interface for app
 */
interface IView<out P : IPresenter<*>> {
    val presenter: P
}