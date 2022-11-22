//[PDFGenerator](../../../index.md)/[com.rifluxyss.pdfgenerator.mainView](../index.md)/[PdfWriter](index.md)

# PdfWriter

[androidJvm]\
open class [PdfWriter](index.md)

## Constructors

| | |
|---|---|
| [PdfWriter](-pdf-writer.md) | [androidJvm]<br>open fun [PdfWriter](-pdf-writer.md)(pageSize: [PageSize](../../com.rifluxyss.pdfgenerator.constants/-page-size/index.md)) |
| [PdfWriter](-pdf-writer.md) | [androidJvm]<br>open fun [PdfWriter](-pdf-writer.md)(pageWidth: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), pageHeight: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)) |

## Functions

| Name | Summary |
|---|---|
| [createPDF](create-p-d-f.md) | [androidJvm]<br>open fun [createPDF](create-p-d-f.md)(file: [File](https://developer.android.com/reference/kotlin/java/io/File.html)): [PdfWriter](index.md) |
| [createTable](create-table.md) | [androidJvm]<br>open fun [createTable](create-table.md)(colWeight: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Table](../../com.rifluxyss.pdfgenerator.structure/-table/index.md) |
| [init](init.md) | [androidJvm]<br>open fun [init](init.md)(@[NonNull](https://developer.android.com/reference/kotlin/androidx/annotation/NonNull.html)context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)): [PdfWriter](index.md) |
| [setBackgroundImage](set-background-image.md) | [androidJvm]<br>open fun [setBackgroundImage](set-background-image.md)(imageData: [ImageData](../../com.rifluxyss.pdfgenerator.image/-image-data/index.md)): [PdfWriter](index.md) |
| [setMargin](set-margin.md) | [androidJvm]<br>open fun [setMargin](set-margin.md)(margin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [PdfWriter](index.md)<br>open fun [setMargin](set-margin.md)(marginLeft: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), marginTop: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), marginRight: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), marginBottom: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [PdfWriter](index.md) |
| [setPageCounter](set-page-counter.md) | [androidJvm]<br>open fun [setPageCounter](set-page-counter.md)(pageCounterModel: [PageCounterModel](../../com.rifluxyss.pdfgenerator.model/-page-counter-model/index.md)) |
