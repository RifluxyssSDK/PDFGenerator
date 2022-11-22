//[PDFGenerator](../../../index.md)/[com.rifluxyss.pdfgenerator.structure](../index.md)/[Cell](index.md)

# Cell

[androidJvm]\
open class [Cell](index.md)

The type Cell.

## Constructors

| | |
|---|---|
| [Cell](-cell.md) | [androidJvm]<br>open fun [Cell](-cell.md)(rowSpan: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), colSpan: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), Draw: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Instantiates a new Cell. |
| [Cell](-cell.md) | [androidJvm]<br>open fun [Cell](-cell.md)(colSpan: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), Draw: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html))<br>Instantiates a new Cell. |

## Functions

| Name | Summary |
|---|---|
| [isBorder](is-border.md) | [androidJvm]<br>open fun [isBorder](is-border.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is border boolean. |
| [isCenter](is-center.md) | [androidJvm]<br>open fun [isCenter](is-center.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is center boolean. |
| [isLeft](is-left.md) | [androidJvm]<br>open fun [isLeft](is-left.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is left boolean. |
| [isRight](is-right.md) | [androidJvm]<br>open fun [isRight](is-right.md)(): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Is right boolean. |
| [setMargin](set-margin.md) | [androidJvm]<br>open fun [setMargin](set-margin.md)(margin: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Cell](index.md)<br>open fun [setMargin](set-margin.md)(marginLeft: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), marginTop: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), marginRight: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), marginBottom: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Cell](index.md)<br>Sets margin. |
| [setPadding](set-padding.md) | [androidJvm]<br>open fun [setPadding](set-padding.md)(padding: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Cell](index.md)<br>open fun [setPadding](set-padding.md)(paddingLeft: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), paddingTop: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), paddingRight: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), paddingBottom: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)): [Cell](index.md)<br>Sets padding. |
| [setSpannableString](set-spannable-string.md) | [androidJvm]<br>open fun [setSpannableString](set-spannable-string.md)(message: [SpannableStringBuilder](https://developer.android.com/reference/kotlin/android/text/SpannableStringBuilder.html)): [Cell](index.md)<br>Sets message. |

## Properties

| Name | Summary |
|---|---|
| [backgroundColor](background-color.md) | [androidJvm]<br>open var [backgroundColor](background-color.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Background color. |
| [bitmap](bitmap.md) | [androidJvm]<br>open var [bitmap](bitmap.md): [Bitmap](https://developer.android.com/reference/kotlin/android/graphics/Bitmap.html)<br>The Bitmap. |
| [bitmapHeight](bitmap-height.md) | [androidJvm]<br>open var [bitmapHeight](bitmap-height.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Bitmap height. |
| [bitmapWidth](bitmap-width.md) | [androidJvm]<br>open var [bitmapWidth](bitmap-width.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Bitmap width. |
| [border](border.md) | [androidJvm]<br>open var [border](border.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The Border. |
| [borderColor](border-color.md) | [androidJvm]<br>open var [borderColor](border-color.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Border color. |
| [borderWidth](border-width.md) | [androidJvm]<br>open var [borderWidth](border-width.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Border width. |
| [center](center.md) | [androidJvm]<br>open var [center](center.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The Center. |
| [colSpan](col-span.md) | [androidJvm]<br>open var [colSpan](col-span.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Col span. |
| [draw](draw.md) | [androidJvm]<br>open var [draw](draw.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Draw. |
| [fontStyle](font-style.md) | [androidJvm]<br>open var [fontStyle](font-style.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Font style. |
| [gravity](gravity.md) | [androidJvm]<br>open var [gravity](gravity.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Gravity. |
| [left](left.md) | [androidJvm]<br>open var [left](left.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The Left. |
| [lineSpacing](line-spacing.md) | [androidJvm]<br>open var [lineSpacing](line-spacing.md): [Float](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)<br>The Line spacing. |
| [marginBottom](margin-bottom.md) | [androidJvm]<br>open var [marginBottom](margin-bottom.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Margin bottom. |
| [marginLeft](margin-left.md) | [androidJvm]<br>open var [marginLeft](margin-left.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Margin left. |
| [marginRight](margin-right.md) | [androidJvm]<br>open var [marginRight](margin-right.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Margin right. |
| [marginTop](margin-top.md) | [androidJvm]<br>open var [marginTop](margin-top.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Margin top. |
| [message](message.md) | [androidJvm]<br>open var [message](message.md): [String](https://developer.android.com/reference/kotlin/java/lang/String.html)<br>The Message. |
| [paddingBottom](padding-bottom.md) | [androidJvm]<br>open var [paddingBottom](padding-bottom.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Padding bottom. |
| [paddingLeft](padding-left.md) | [androidJvm]<br>open var [paddingLeft](padding-left.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Padding left. |
| [paddingRight](padding-right.md) | [androidJvm]<br>open var [paddingRight](padding-right.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Padding right. |
| [paddingTop](padding-top.md) | [androidJvm]<br>open var [paddingTop](padding-top.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Padding top. |
| [paragraph](paragraph.md) | [androidJvm]<br>open var [paragraph](paragraph.md): [Paragraph](../-paragraph/index.md)<br>The Paragraph. |
| [right](right.md) | [androidJvm]<br>open var [right](right.md): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>The Right. |
| [rowSpan](row-span.md) | [androidJvm]<br>open var [rowSpan](row-span.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Row span. |
| [scaleType](scale-type.md) | [androidJvm]<br>open var [scaleType](scale-type.md): [ImageView.ScaleType](https://developer.android.com/reference/kotlin/android/widget/ImageView.ScaleType.html)<br>The Scale type. |
| [spannableStringBuilder](spannable-string-builder.md) | [androidJvm]<br>private open val [spannableStringBuilder](spannable-string-builder.md): [SpannableStringBuilder](https://developer.android.com/reference/kotlin/android/text/SpannableStringBuilder.html)<br>The spannableStringBuilder. |
| [textColor](text-color.md) | [androidJvm]<br>open var [textColor](text-color.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Text color. |
| [textSize](text-size.md) | [androidJvm]<br>open var [textSize](text-size.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>The Text size. |
