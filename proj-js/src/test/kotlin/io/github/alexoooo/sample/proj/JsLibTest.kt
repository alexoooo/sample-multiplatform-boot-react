package io.github.alexoooo.sample.proj

import io.github.alexoooo.sample.lib.ClassName
import io.github.alexoooo.sample.lib.Mirror
import io.github.alexoooo.sample.lib.ModuleRegistry
import io.github.alexoooo.sample.proj.model.ProjJsTestModel
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class JsLibTest {
    @Test
    fun detectExistenceOfJsTestClass() {
        ModuleRegistry.add(js("module.exports"))

        val sampleModelClass = ClassName(
            "io.github.alexoooo.sample.proj.model.ProjJsTestModel")

        assertTrue(Mirror.contains(sampleModelClass))

        assertEquals(
            listOf("name", "number"),
            Mirror.constructorArgumentNames(sampleModelClass))

        val sampleModel = Mirror.create(sampleModelClass, listOf("foo", 42.0))
                as ProjJsTestModel

        assertEquals("foo", sampleModel.name)
        assertEquals(42.0, sampleModel.number)
    }


    @Test
    fun detectExistenceOfJsMainClass() {
        ModuleRegistry.add(js("require('lib-lib-js')"))
//        ModuleRegistry.add(js("module.exports"))

        val sampleModelClass = ClassName(
            "io.github.alexoooo.sample.lib.model.JsMainModel")

//        val foo = JsMainModel("foo", 42.0)
        assertTrue(Mirror.contains(sampleModelClass))
    }


    @Test
    fun detectExistenceOfCommonClass() {
        ModuleRegistry.add(js("require('lib-lib-common')"))
//        println("!!!! " + js("Object.getOwnPropertyNames( window )"))

        val sampleModelClass = ClassName(
            "io.github.alexoooo.sample.lib.model.CommonModel")

        assertTrue(Mirror.contains(sampleModelClass))
    }
}