package com.example.lab14

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.glance.*
import androidx.glance.action.ActionParameters
import androidx.glance.action.clickable
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.action.actionStartActivity
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.*
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider

class RefreshActionCallback : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters
    ) {
        println("Widget Refrescado por acción del usuario: $glanceId")
    }
}

class CustomWidgetContent : GlanceAppWidget() {

    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                WidgetLayout(context)
            }
        }
    }

    @Composable
    private fun WidgetLayout(context: Context) {

        val mainIntent = Intent(context, MainActivity::class.java)
        val settingsIntent = Intent(context, SettingsActivity::class.java)
        val newTaskIntent = Intent(context, NewTaskActivity::class.java)

        Box(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(GlanceTheme.colors.surface)
                .padding(8.dp)
        ) {

            Column(
                modifier = GlanceModifier.fillMaxSize(),
                horizontalAlignment = Alignment.Horizontal.Start
            ) {

                // -------- SECCIÓN SUPERIOR --------
                Row(
                    modifier = GlanceModifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Vertical.CenterVertically
                ) {

                    Text(
                        text = "Mi Proyecto Lab14",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = GlanceTheme.colors.onSurface
                        ),
                        modifier = GlanceModifier
                            .defaultWeight()
                            .padding(top = 4.dp)
                            .clickable(actionStartActivity(mainIntent))
                    )

                    Text(
                        text = "↺",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = GlanceTheme.colors.primary
                        ),
                        modifier = GlanceModifier
                            .padding(top = 4.dp, end = 4.dp)
                            .clickable(actionRunCallback<RefreshActionCallback>())
                    )
                }

                Spacer(modifier = GlanceModifier.height(8.dp))

                Text(
                    text = "Última acción: Tarea 'Lab14' completada hace 5 min.",
                    style = TextStyle(color = GlanceTheme.colors.secondary)
                )

                Spacer(modifier = GlanceModifier.height(12.dp))

                // -------- SECCIÓN INFERIOR --------
                Row(
                    modifier = GlanceModifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Vertical.CenterVertically
                ) {

                    Button(
                        text = "Ajustes",
                        onClick = actionStartActivity(settingsIntent),
                        modifier = GlanceModifier.defaultWeight()
                    )

                    Spacer(modifier = GlanceModifier.width(8.dp))

                    Button(
                        text = "Nueva Tarea",
                        onClick = actionStartActivity(newTaskIntent),
                        modifier = GlanceModifier.defaultWeight()
                    )
                }
            }
        }
    }
}
