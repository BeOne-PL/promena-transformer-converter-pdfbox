package pl.beone.promena.transformer.converter.pdfbox.extension

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper

fun PDDocument.readPages(): List<String> =
    (0 until numberOfPages)
        .map { page -> readText(page) }

fun PDDocument.readText(page: Int): String =
    getPage(page).toPDDocument().use { PDFTextStripper().getText(it).trim() }