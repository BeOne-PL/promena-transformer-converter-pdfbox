package pl.beone.promena.transformer.converter.pdfbox.applicationmodel

import pl.beone.promena.transformer.contract.transformer.transformerId

object PdfBoxConverterConstants {

    const val TRANSFORMER_NAME = "converter"

    const val TRANSFORMER_SUB_NAME = "PDFBox"

    @JvmField
    val TRANSFORMER_ID = transformerId(TRANSFORMER_NAME, TRANSFORMER_SUB_NAME)
}