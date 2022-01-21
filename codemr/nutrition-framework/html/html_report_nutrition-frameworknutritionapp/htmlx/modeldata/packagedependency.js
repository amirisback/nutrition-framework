var matrix = [[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,0,0,0,0,0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]
var packages = [{
"name": " com.frogobox.nutritionapp.source.local", "color": " #3182bd"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.admob", "color": " #6baed6"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.about", "color": " #9ecae1"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.usingadapter", "color": " #c6dbef"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.nutrition.general", "color": " #e6550d"
}
,{
"name": " com.frogobox.nutritionapp.util", "color": " #fd8d3c"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.uicomponent.uicompose", "color": " #fdae6b"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.main.generator", "color": " #fdd0a2"
}
,{
"name": " com.frogobox.nutritionapp.source.remote", "color": " #31a354"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.log", "color": " #74c476"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.admob.type2", "color": " #a1d99b"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.admob.type1", "color": " #c7e9c0"
}
,{
"name": " com.frogobox.nutritionapp", "color": " #756bb1"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.main.builder", "color": " #9e9ac8"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.notification.custom", "color": " #bcbddc"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.nutrition.meal", "color": " #dadaeb"
}
,{
"name": " com.frogobox.nutritionapp.core", "color": " #636363"
}
,{
"name": " com.frogobox.nutritionapp.source", "color": " #969696"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.simple", "color": " #bdbdbd"
}
,{
"name": " com.frogobox.nutritionapp.theme", "color": " #d9d9d9"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.noadapter.multiview", "color": " #3182bd"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.nested", "color": " #6baed6"
}
,{
"name": " com.frogobox.nutritionapp.model", "color": " #9ecae1"
}
,{
"name": " com.frogobox.nutritionapp.di", "color": " #c6dbef"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.uicomponent.uixml", "color": " #e6550d"
}
,{
"name": " com.frogobox.nutritionapp.source.local.dao", "color": " #fd8d3c"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.multiview", "color": " #fdae6b"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.java.noadapter.simple", "color": " #fdd0a2"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.nutrition.vitamin", "color": " #31a354"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.nutrition.article", "color": " #74c476"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.progress", "color": " #a1d99b"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.notification.stack", "color": " #c7e9c0"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.main", "color": " #756bb1"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.noadapter.shimmer", "color": " #9e9ac8"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.usingadapter.simple", "color": " #bcbddc"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.notification", "color": " #dadaeb"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler", "color": " #636363"
}
,{
"name": " com.frogobox.nutritionapp.mvvm.androidmethod.recycler.kotlin.compose", "color": " #969696"
}
];
