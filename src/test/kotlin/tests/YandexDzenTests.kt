package tests

import base.BaseTest
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import org.testng.Assert
import org.testng.annotations.Test
import java.util.regex.Pattern


class YandexDzenTests : BaseTest() {


    @Test
    fun firstTest() {
        page?.navigate("http://85.192.34.140:8081/")
        page?.getByText("Elements")?.click();
        page?.querySelector("//li[@id='item-0']/span[1]")?.click();
        page?.fill("[id=userName]", "ThreadQA Test");
        page?.fill("[id=userEmail]", "threadqa@gmail.com");
        page?.fill("[id=currentAddress]", "somewhere");
        page?.click("[id=submit]");

        //Проверяем, что после заполнения формы, появился другой блок
        Assert.assertTrue(page?.isVisible("[id=output]")!!);
        //Проверяем, что в появившемся блоке, текст содержит предыдущий текст
        Assert.assertTrue(page?.locator("[id=name]")?.textContent()!!.contains("NOT ThreadQA Test"));
    }


    @Test
    fun secondTest() {
        page?.navigate("https://dzen.ru/")
        assertThat(page).hasTitle(Pattern.compile("Дзен"))
    }

}