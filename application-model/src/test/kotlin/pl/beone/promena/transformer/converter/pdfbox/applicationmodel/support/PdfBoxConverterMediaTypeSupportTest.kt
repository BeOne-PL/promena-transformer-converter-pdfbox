package pl.beone.promena.transformer.converter.pdfbox.applicationmodel.support

import io.kotlintest.shouldNotThrow
import io.kotlintest.shouldThrow
import org.junit.jupiter.api.Test
import pl.beone.promena.transformer.applicationmodel.exception.transformer.TransformationNotSupportedException
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_MSWORD
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.APPLICATION_PDF
import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.PdfBoxConverterSupport.MediaTypeSupport.isSupported

class PdfBoxConverterMediaTypeSupportTest {

    @Test
    fun isSupported() {
        shouldNotThrow<TransformationNotSupportedException> {
            isSupported(APPLICATION_PDF, TEXT_PLAIN)
        }
    }

    @Test
    fun `isSupported _ target media type is not supported _ should throw TransformationNotSupportedException`() {
        shouldThrow<TransformationNotSupportedException> {
            isSupported(APPLICATION_MSWORD, APPLICATION_PDF)
        }
    }

    @Test
    fun `isSupported _ media type is not supported _ should throw TransformationNotSupportedException`() {
        shouldThrow<TransformationNotSupportedException> {
            isSupported(APPLICATION_PDF, APPLICATION_MSWORD)
        }
    }
}