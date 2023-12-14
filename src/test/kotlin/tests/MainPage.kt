package tests

import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import java.io.IOException
import java.nio.file.Paths

open class MainPage {

    open val playwright = Playwright.create()
    open val browser = playwright.chromium().launch(BrowserType.LaunchOptions().setHeadless(false))
    val context = browser.newContext()
    open val page = context.newPage()
    //blabla
}