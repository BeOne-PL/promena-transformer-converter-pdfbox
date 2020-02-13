package pl.beone.promena.transformer.converter.pdfbox.applicationmodel.support

import io.kotlintest.shouldNotThrow
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.PdfBoxConverterSupport.ParametersSupport.isSupported
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.pdfBoxConverterParameters

class PdfBoxConverterParametersSupportTest {

    @Test
    fun isSupported() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(pdfBoxConverterParameters())
        }
    }
}