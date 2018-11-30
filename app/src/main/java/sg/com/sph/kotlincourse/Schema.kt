package sg.com.sph.kotlincourse

data class HDBResalePriceIndexSchema(
        val help: String,
        val success: Boolean,
        val result: Result
)

data class Result(
        val resource_id: String,
        val fields: List<Field>,
        val records: List<Record>,
        val _links: Links,
        val limit: Int,
        val total: Int
)

data class Field(
        val type: String,
        val id: String
)

data class Links(
        val start: String,
        val next: String
)

data class Record(
        val index: String,
        val quarter: String,
        val _id: Int
)