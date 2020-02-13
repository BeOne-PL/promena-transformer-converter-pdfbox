package pl.beone.promena.transformer.converter.pdfbox.example

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaTypeConstants.TEXT_PLAIN
import pl.beone.promena.transformer.contract.transformation.Transformation
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.pdfBoxConverterParameters
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.pdfBoxConverterTransformation

fun promena(): Transformation {
    // Data: example.pdf

    return pdfBoxConverterTransformation(TEXT_PLAIN, pdfBoxConverterParameters())
}