package tests

import base.BaseTest
import io.qameta.allure.Allure
import io.qameta.allure.Description
import io.qameta.allure.Owner
import org.junit.jupiter.api.DisplayName
import org.testng.Assert
import org.testng.annotations.Test
import java.io.ByteArrayInputStream
import java.nio.file.Paths


class YandexDzenTests : BaseTest() {

    @Owner("Denis Maltsev")
    @DisplayName("Форма")
    @Description("Заполнение формы")
    @Test
    fun firstTest() {
        page?.navigate("http://85.192.34.140:8081/")
        page?.getByText("Elements")?.click()
        page?.querySelector("//li[@id='item-0']/span[1]")?.click()
        page?.fill("[id=userName]", "ThreadQA Test")
        page?.fill("[id=userEmail]", "threadqa@gmail.com")
        page?.fill("[id=currentAddress]", "somewhere")
        page?.click("[id=submit]")
        //Проверяем, что после заполнения формы, появился другой блок
        Assert.assertTrue(page?.isVisible("[id=output]")!!)
        //Проверяем, что в появившемся блоке, текст содержит предыдущий текст
        Assert.assertTrue(page?.locator("[id=name]")?.textContent()!!.contains("NOT ThreadQA Test"))
    }

    @Owner("Denis Maltsev")
    @DisplayName("Регистрация")
    @Description("Проверка формы регистрации")
    @Test
    fun regTest() {
        page?.navigate("http://85.192.34.140:8081/")
        page?.getByText("Forms")?.click()
        page?.getByText("Practice Form")?.click()
        page?.fill("[id=firstName]", "Denis")
        page?.fill("[id=lastName]", "Maltsev")
        page?.fill("[id=userEmail]", "test@gmgg.ru")
        page?.locator("//div[@class='custom-control custom-radio custom-control-inline'][1]")?.click()
        page?.fill("[id=userNumber]", "4444444444")
        page?.fill("[id=dateOfBirthInput]", "08 Dec 1998")
        page?.locator("//div[@class='custom-control custom-checkbox custom-control-inline'][1]")?.click()
        page?.locator("id=uploadPicture")?.setInputFiles(Paths.get("C:/Users/Deni/Desktop/Screenshot_2.png"))
        page?.fill("[id=currentAddress]", "Moscow, Green Street, 5")
        page?.getByText("Select State")?.click()
        page?.getByText("NCR")?.click()
        page?.getByText("Select City")?.click()
        page?.getByText("Gurgaon")?.click()
        Allure.addAttachment("Скриншот заполненной формы", ByteArrayInputStream(makeScreenshot()))
        page?.click("[id=submit]")
        Assert.assertEquals(page?.locator("id=example-modal-sizes-title-lg")?.textContent(), "Thanks for submitting the form")


    }




}


