package com.frogobox.nutritioncore.model.vitamin

data class VitaminResponse(
    val vitamin_content: List<VitaminContent>,
    val vitamin_name: String,
    val vitamin_source_data: String
)