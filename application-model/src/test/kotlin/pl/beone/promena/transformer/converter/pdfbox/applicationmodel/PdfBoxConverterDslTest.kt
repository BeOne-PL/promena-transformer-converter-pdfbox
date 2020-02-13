package pl.beone.promena.transformer.converter.pdfbox.applicationmodel

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.PdfBoxConverterConstants.TRANSFORMER_ID

class PdfBoxConverterDslTest {

    @Test
    fun pdfBoxConverterTransformation() {
        with(pdfBoxConverterTransformation(TEXT_PLAIN, pdfBoxConverterParameters())) {
            transformerId shouldBe TRANSFORMER_ID
            parameters.getAll().size shouldBe 0
        }
    }
}