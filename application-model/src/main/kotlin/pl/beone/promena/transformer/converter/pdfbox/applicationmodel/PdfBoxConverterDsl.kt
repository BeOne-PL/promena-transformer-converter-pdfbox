@file:JvmName("PdfBoxConverterDsl")

package pl.beone.promena.transformer.converter.pdfbox.applicationmodel

import pl.beone.promena.transformer.applicationmodel.mediatype.MediaType
import pl.beone.promena.transformer.contract.model.Parameters
import pl.beone.promena.transformer.contract.transformation.Transformation
import pl.beone.promena.transformer.contract.transformation.singleTransformation
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.PdfBoxConverterConstants.TRANSFORMER_ID
import pl.beone.promena.transformer.converter.pdfbox.applicationmodel.PdfBoxConverterConstants.TRANSFORMER_NAME

fun converterTransformation(targetMediaType: MediaType, parameters: Parameters): Transformation.Single =
    singleTransformation(TRANSFORMER_NAME, targetMediaType, parameters)

fun pdfBoxConverterTransformation(targetMediaType: MediaType, parameters: Parameters): Transformation.Single =
    singleTransformation(TRANSFORMER_ID, targetMediaType, parameters)