package app.roleparty.resource

data class HttpEndpoint(
    val method: Method,
    val url: String
) {
    
    enum class Method {
        POST
    }
}