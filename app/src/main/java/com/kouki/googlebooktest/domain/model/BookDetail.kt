package com.kouki.googlebooktest.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookDetail(

	@field:SerializedName("saleInfo")
	val saleInfo: SaleInfo? = null,

	@field:SerializedName("kind")
	val kind: String? = null,

	@field:SerializedName("volumeInfo")
	val volumeInfo: VolumeInfo? = null,

	@field:SerializedName("etag")
	val etag: String? = null,

	@field:SerializedName("layerInfo")
	val layerInfo: LayerInfo? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("accessInfo")
	val accessInfo: AccessInfo? = null,

	@field:SerializedName("selfLink")
	val selfLink: String? = null
) : Parcelable

//@Parcelize
//data class VolumeInfo(
//
//	@field:SerializedName("pageCount")
//	val pageCount: Int? = null,
//
//	@field:SerializedName("printType")
//	val printType: String? = null,
//
//	@field:SerializedName("readingModes")
//	val readingModes: ReadingModes? = null,
//
//	@field:SerializedName("previewLink")
//	val previewLink: String? = null,
//
//	@field:SerializedName("canonicalVolumeLink")
//	val canonicalVolumeLink: String? = null,
//
//	@field:SerializedName("description")
//	val description: String? = null,
//
//	@field:SerializedName("language")
//	val language: String? = null,
//
//	@field:SerializedName("title")
//	val title: String? = null,
//
//	@field:SerializedName("imageLinks")
//	val imageLinks: ImageLinks? = null,
//
//	@field:SerializedName("averageRating")
//	val averageRating: Double? = null,
//
//	@field:SerializedName("panelizationSummary")
//	val panelizationSummary: PanelizationSummary? = null,
//
//	@field:SerializedName("publisher")
//	val publisher: String? = null,
//
//	@field:SerializedName("ratingsCount")
//	val ratingsCount: Int? = null,
//
//	@field:SerializedName("publishedDate")
//	val publishedDate: String? = null,
//
//	@field:SerializedName("printedPageCount")
//	val printedPageCount: Int? = null,
//
//	@field:SerializedName("maturityRating")
//	val maturityRating: String? = null,
//
//	@field:SerializedName("allowAnonLogging")
//	val allowAnonLogging: Boolean? = null,
//
//	@field:SerializedName("contentVersion")
//	val contentVersion: String? = null,
//
//	@field:SerializedName("authors")
//	val authors: List<String?>? = null,
//
//	@field:SerializedName("dimensions")
//	val dimensions: Dimensions? = null,
//
//	@field:SerializedName("infoLink")
//	val infoLink: String? = null
//) : Parcelable
//
//@Parcelize
//data class Epub(
//
//	@field:SerializedName("isAvailable")
//	val isAvailable: Boolean? = null,
//
//	@field:SerializedName("downloadLink")
//	val downloadLink: String? = null
//) : Parcelable
//
//@Parcelize
//data class ReadingModes(
//
//	@field:SerializedName("image")
//	val image: Boolean? = null,
//
//	@field:SerializedName("text")
//	val text: Boolean? = null
//) : Parcelable
//
//@Parcelize
//data class PanelizationSummary(
//
//	@field:SerializedName("containsImageBubbles")
//	val containsImageBubbles: Boolean? = null,
//
//	@field:SerializedName("containsEpubBubbles")
//	val containsEpubBubbles: Boolean? = null
//) : Parcelable
//
@Parcelize
data class LayersItem(

	@field:SerializedName("layerId")
	val layerId: String? = null,

	@field:SerializedName("volumeAnnotationsVersion")
	val volumeAnnotationsVersion: String? = null
) : Parcelable

//@Parcelize
//data class Dimensions(
//
//	@field:SerializedName("height")
//	val height: String? = null
//) : Parcelable
//
//@Parcelize
//data class AccessInfo(
//
//	@field:SerializedName("accessViewStatus")
//	val accessViewStatus: String? = null,
//
//	@field:SerializedName("country")
//	val country: String? = null,
//
//	@field:SerializedName("viewability")
//	val viewability: String? = null,
//
//	@field:SerializedName("pdf")
//	val pdf: Pdf? = null,
//
//	@field:SerializedName("webReaderLink")
//	val webReaderLink: String? = null,
//
//	@field:SerializedName("epub")
//	val epub: Epub? = null,
//
//	@field:SerializedName("publicDomain")
//	val publicDomain: Boolean? = null,
//
//	@field:SerializedName("quoteSharingAllowed")
//	val quoteSharingAllowed: Boolean? = null,
//
//	@field:SerializedName("embeddable")
//	val embeddable: Boolean? = null,
//
//	@field:SerializedName("textToSpeechPermission")
//	val textToSpeechPermission: String? = null
//) : Parcelable
//
@Parcelize
data class LayerInfo(

	@field:SerializedName("layers")
	val layers: List<LayersItem?>? = null
) : Parcelable

//@Parcelize
//data class Pdf(
//
//	@field:SerializedName("isAvailable")
//	val isAvailable: Boolean? = null,
//
//	@field:SerializedName("downloadLink")
//	val downloadLink: String? = null
//) : Parcelable
//
//@Parcelize
//data class SaleInfo(
//
//	@field:SerializedName("country")
//	val country: String? = null,
//
//	@field:SerializedName("isEbook")
//	val isEbook: Boolean? = null,
//
//	@field:SerializedName("saleability")
//	val saleability: String? = null,
//
//	@field:SerializedName("buyLink")
//	val buyLink: String? = null
//) : Parcelable
//
//@Parcelize
//data class ImageLinks(
//
//	@field:SerializedName("small")
//	val small: String? = null,
//
//	@field:SerializedName("thumbnail")
//	val thumbnail: String? = null,
//
//	@field:SerializedName("large")
//	val large: String? = null,
//
//	@field:SerializedName("extraLarge")
//	val extraLarge: String? = null,
//
//	@field:SerializedName("smallThumbnail")
//	val smallThumbnail: String? = null,
//
//	@field:SerializedName("medium")
//	val medium: String? = null
//) : Parcelable
