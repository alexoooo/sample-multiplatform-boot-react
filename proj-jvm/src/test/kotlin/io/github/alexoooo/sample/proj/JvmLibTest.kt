package io.github.alexoooo.sample.proj

import io.github.alexoooo.sample.lib.ClassName
import io.github.alexoooo.sample.lib.Mirror
import io.github.alexoooo.sample.lib.model.JvmMainModel
import io.github.alexoooo.sample.proj.model.ProjJvmMainModel
import io.github.alexoooo.sample.proj.model.ProjJvmTestModel
import org.junit.Test
import kotlin.test.assertTrue


class JvmLibTest {
    @Test
    fun mirrorLibJvm() {
        val libClass = JvmMainModel::class.java
        assertTrue(Mirror.contains(ClassName(libClass.name)))
    }


    @Test
    fun mirrorProjMainJvm() {
        val projMainClass = ProjJvmMainModel::class.java
        assertTrue(Mirror.contains(ClassName(projMainClass.name)))
    }


    @Test
    fun mirrorProjTestJvm() {
        val projTestClass = ProjJvmTestModel::class.java
        assertTrue(Mirror.contains(ClassName(projTestClass.name)))
    }
}