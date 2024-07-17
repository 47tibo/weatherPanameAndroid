import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.tibo47.androidPlatform.theme.MainTheme
import com.tibo47.weatherPaname.weeklyWeatherUi.ui.HourList
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant

class PreviewsScreenshots {
    @Preview
    @Composable
    private fun HourListPreview(
        @PreviewParameter(HoursPreviewParameterProvider::class) hours: List<Instant>,
    ) {
        MainTheme {
            HourList(hours = hours)
        }
    }

    private class HoursPreviewParameterProvider : PreviewParameterProvider<List<Instant>> {
        override val values: Sequence<List<Instant>> =
            sequenceOf(
                List(15) { LocalDateTime(2024, 3, 14, 9, 23).toInstant(TimeZone.currentSystemDefault()) },
            )
    }
}
