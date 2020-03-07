package com.fasterxml.jackson.module.kotlin.test.github

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Test
import kotlin.test.assertEquals

class TestGithub173 {

    @Test
    fun testCamelCase_One_Constructor() {
        val mapper = jacksonObjectMapper()

        val expectedJson = """{"camelName":"John Smith"}"""
        val expectedPerson = CamelCase("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, CamelCase::class.java)
        assertEquals(expectedPerson.camelName, newPerson.camelName)
    }

    @Test
    fun testCamelCaseMultipleUppercase_One_Constructor() {
        val mapper = jacksonObjectMapper()

        val expectedJson = """{"anAME":"John Smith"}"""
        val expectedPerson = CamelCaseMultipleUppercase("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, CamelCaseMultipleUppercase::class.java)
        assertEquals(expectedPerson.anAME, newPerson.anAME)
    }

    @Test
    fun testLowercase_One_Constructor() {
        val mapper = jacksonObjectMapper()

        val expectedJson = """{"name":"John Smith"}"""
        val expectedPerson = Lowercase("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, Lowercase::class.java)
        assertEquals(expectedPerson.name, newPerson.name)
    }

    @Test
    fun testSecondCharIsMultipleUppercase_One_Constructor() {
        val mapper = jacksonObjectMapper()

        val expectedJson = """{"aNAMe":"John Smith"}"""
        val expectedPerson = SecondCharIsMultipleUppercase("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, SecondCharIsMultipleUppercase::class.java)
        assertEquals(expectedPerson.aNAMe, newPerson.aNAMe)
    }

    @Test
    fun testSecondCharIsUppercase_One_Constructor() {
        val mapper = jacksonObjectMapper()

        val expectedJson = """{"aName":"John Smith"}"""
        val expectedPerson = SecondCharIsUppercase("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, SecondCharIsUppercase::class.java)
        assertEquals(expectedPerson.aName, newPerson.aName)
    }

    @Test
    fun testSecondCharIsUppercaseAnnotated_One_Constructor() {
        val mapper = jacksonObjectMapper()

        val expectedJson = """{"aName":"John Smith"}"""
        val expectedPerson = SecondCharIsUppercaseAnnotated("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, SecondCharIsUppercaseAnnotated::class.java)
        assertEquals(expectedPerson.aName, newPerson.aName)
    }

    @Test
    fun testStartsWithUppercase_One_Constructor() {
        val mapper = jacksonObjectMapper()
//        val mapper = jacksonMapperBuilder()
//                .propertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE)
//                .build()

        val expectedJson = """{"Name":"John Smith"}"""
        val expectedPerson = StartsWithUppercase("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, StartsWithUppercase::class.java)
        assertEquals(expectedPerson.Name, newPerson.Name)
    }

    @Test
    fun testStartsWithUppercaseAnnotated_One_Constructor() {
        val mapper = jacksonObjectMapper()

        val expectedJson = """{"Name":"John Smith"}"""
        val expectedPerson = StartsWithUppercaseAnnotated("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, StartsWithUppercaseAnnotated::class.java)
        assertEquals(expectedPerson.Name, newPerson.Name)
    }

    @Test
    fun testStartsWithUppercaseAnnotatedJvmField_One_Constructor() {
        val mapper = jacksonObjectMapper()

        val expectedJson = """{"Name":"John Smith"}"""
        val expectedPerson = StartsWithUppercaseAnnotatedJvmField("John Smith")

        val actualJson = mapper.writeValueAsString(expectedPerson)
        assertEquals(expectedJson, actualJson)

        val newPerson = mapper.readValue(actualJson, StartsWithUppercaseAnnotatedJvmField::class.java)
        assertEquals(expectedPerson.Name, newPerson.Name)
    }

    /** {"camelName":"John Smith"} */
    private class CamelCase(val camelName: String)

    /** {"anAME":"John Smith"} */
    private class CamelCaseMultipleUppercase(val anAME: String)

    /** {"name":"John Smith"} */
    private class Lowercase(val name: String)

    /** {"aNAMe":"John Smith"} */
    private class SecondCharIsMultipleUppercase(val aNAMe: String)

    /** {"aName":"John Smith"} */
    private class SecondCharIsUppercase(val aName: String)

    /** {"aName":"John Smith"} */
    private class SecondCharIsUppercaseAnnotated(@JsonProperty("aName") val aName: String)

    /** {"Name":"John Smith"} */
    private class StartsWithUppercase(val Name: String)

    /** {"Name":"John Smith"} */
    private class StartsWithUppercaseAnnotated(@JsonProperty("Name") val Name: String)

    /** {"Name":"John Smith"} */
    private class StartsWithUppercaseAnnotatedJvmField(@JvmField val Name: String)

}
