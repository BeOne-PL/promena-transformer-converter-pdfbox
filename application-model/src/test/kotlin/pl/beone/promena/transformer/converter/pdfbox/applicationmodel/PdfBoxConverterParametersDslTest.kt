package pl.beone.promena.transformer.converter.pdfbox.applicationmodel

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test

class PdfBoxConverterParametersDslTest {

    @Test
    fun pdfBoxConverterParameters_() {
        pdfBoxConverterParameters().getAll().size shouldBe 0
    }
}