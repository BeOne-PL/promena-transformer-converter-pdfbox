# Promena Transformer - `converter - PDFBox`
This transformer provides functionality to convert a `application/pdf` document to a `text/plain` document using PDFBox 2.0.16.

Visit [Promena#Transformer](https://github.com/BeOne-PL/promena#transformer) to understand the repository structure.

## Transformation [`PdfBoxConverterDsl`](./application-model/src/main/kotlin/pl/beone/promena/transformer/converter/pdfbox/applicationmodel/PdfBoxConverterDsl.kt)
The [`DataDescriptor`](https://github.com/BeOne-PL/promena/blob/master/base/promena-transformer/contract/src/main/kotlin/pl/beone/promena/transformer/contract/data/DataDescriptor.kt) has to contain at least one descriptor. If more than one descriptor is passed, the transformation will be performed on each of them separately.

## Support [`PdfBoxConverterSupport`](./application-model/src/main/kotlin/pl/beone/promena/transformer/converter/pdfbox/applicationmodel/PdfBoxConverterSupport.kt)
### Media type [`PdfBoxConverterSupport.MediaTypeSupport`](./application-model/src/main/kotlin/pl/beone/promena/transformer/converter/pdfbox/applicationmodel/PdfBoxConverterSupport.kt)
* `application/pdf; UTF-8` :arrow_right: `text/plain; UTF-8`

## Dependency
```xml
<dependency>
    <groupId>pl.beone.promena.transformer</groupId>
    <artifactId>converter-pdfbox-configuration</artifactId>
    <version>1.0.0</version>
</dependency>
```

### `promena-docker-maven-plugin`
```xml
<dependency>
    <groupId>pl.beone.promena.transformer</groupId>
    <artifactId>converter-pdfbox</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Properties
```properties
transformer.pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformer.priority=1
transformer.pl.beone.promena.transformer.converter.pdfbox.PdfBoxConverterTransformer.actors=1

transformer.pl.beone.promena.transformer.converter.pdfbox.default.parameters.timeout=
```