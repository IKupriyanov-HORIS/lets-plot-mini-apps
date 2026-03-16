import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.renderComposable
import org.jetbrains.letsPlot.compose.PlotPanel
import org.jetbrains.letsPlot.geom.geomDensity
import org.jetbrains.letsPlot.letsPlot
import kotlin.math.*
import kotlin.random.Random

fun main() {
    renderComposable(rootElementId = "root") {
        // Compose UI structure
        PlotContainer()
    }
}

@Composable
fun PlotContainer() {
    val n = 200
    val data = mapOf("x" to List(n) { nextGaussian() })

    val p = letsPlot(data) + geomDensity(
        color = "dark-green",
        fill = "green",
        alpha = .3,
        size = 2.0
    ) { x = "x" }

    // PlotPanel is the official way to embed a plot in Compose
    PlotPanel(
        figure = p,
        modifier = {
            // Use standard Compose modifiers
            style {
                width(400.px)
                height(300.px)
            }
        }
    )
}

fun nextGaussian(): Double {
    var u = 0.0
    var v = 0.0
    while (u < 1.0e-7) u = Random.nextDouble()
    while (v < 1.0e-7) v = Random.nextDouble()
    return sqrt(-2.0 * ln(u)) * cos(2.0 * PI * v)
}