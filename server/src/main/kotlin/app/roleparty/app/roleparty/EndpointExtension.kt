import app.roleparty.resource.HttpEndpoint
import app.roleparty.resource.HttpEndpoint.Method.POST
import io.ktor.server.routing.*

context(Route)
fun HttpEndpoint.configure(body: suspend RoutingContext.() -> Unit) = when (method) {
    POST -> post(url, body)
}