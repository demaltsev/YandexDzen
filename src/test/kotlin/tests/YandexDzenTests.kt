package tests

import com.microsoft.playwright.Locator
import com.microsoft.playwright.Page
import org.junit.jupiter.api.Test
import java.io.IOException
import java.nio.file.Paths
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import java.util.regex.Pattern


class YandexDzenTests : MainPage() {


    @Test
    fun firstTest() {
        try {

            page.navigate("https://dzen.ru/")
            page.screenshot(Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/1.png")))
            assertThat(page).hasTitle(Pattern.compile("Дзен"))

            val article: Locator =
                page.locator("text=Словацкий депутат Блаха назвал красной линией для России вылет F-16 c баз НАТО")
            assertThat(article).hasAttribute("class", "card-news-story__text-3F")
            article.click()

        } catch (e: IOException) {
        }

    }


    @Test
    fun secondTest() {
        page.navigate("https://www.kinopoisk.ru/")
        page.screenshot(Page.ScreenshotOptions().setPath(Paths.get("target/screenshots/2.png")))

        assertThat(page).hasTitle("Кинопоиск. Все фильмы планеты.")
    }

}